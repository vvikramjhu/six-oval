/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package jp.go.aist.six.oval.core.rest;

import jp.go.aist.six.oval.core.service.OvalContext;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.service.OvalException;
import jp.go.aist.six.oval.service.OvalRepository;
import jp.go.aist.six.oval.service.OvalRepositoryException;
import jp.go.aist.six.util.IoUtil;
import jp.go.aist.six.util.search.SearchResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalRepositoryClient
    implements OvalRepository
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( OvalRepositoryClient.class );


    public static void main(
                    final String[] args
                    )
    throws Exception
    {
        OvalContext  context = new OvalContext();
        OvalRepositoryClient  client = context.getBean( "ovalRepositoryRestClient", OvalRepositoryClient.class );

        if (args.length < 1) {
            System.err.println( "No OVAL Definitions file specified." );
        } else {
            File  file = new File( args[0] );
            OvalResults  results = (OvalResults)context.getXml().unmarshal( new FileInputStream( file ) );
            client.createOvalResults( results );
//            client.createOvalDefinitions( file );
        }

//        client.getOvalResults( "89018e8d-1887-4e36-914b-e44f58474d0e" );
    }
//    {
//        OvalRepositoryClient  client = new OvalRepositoryClient();
//        OvalResults  results = client.getOvalResults( "68ab9c47-61aa-4cb7-acac-5f36401d2d06" );
//        System.out.println( "REST GET results: " + results );
//    }


    private static final List<MediaType>  _ACCEPT_MEDIA_TYPES_ =
        Arrays.asList( new MediaType[] { MediaType.APPLICATION_XML } );



    private String  _baseUri;
    private UriTemplate  _docBaseUri;
    private UriTemplate  _docLocationUri;


    private RestTemplate  _rest;



    /**
     * Constructor.
     */
    public OvalRepositoryClient()
    {
    }



    /**
     */
    public void setBaseUri(
                    final String uri
                    )
    {
        _baseUri = uri;
        if (_baseUri == null) {
            _LOG.warn( "null baseUri" );
        }

        if (_baseUri.endsWith( "/" )) {
            // remove the last "/"
            _baseUri = _baseUri.substring( 0, _baseUri.length() - 1 );
        }

        if (_LOG.isInfoEnabled()) {
            _LOG.info( "baseUri: " + _baseUri );
        }

        _docBaseUri     = new UriTemplate( _baseUri + "/{resourcePath}" );
        _docLocationUri = new UriTemplate( _baseUri + "/{resourcePath}/{id}" );
    }



    /**
     */
    public void setRestTemplate(
                    final RestTemplate rest
                    )
    {
        _rest = rest;
    }



    /**
     * REST GET:
     */
    private <T> T _getResource(
                    final Class<T> resourceType,
                    final UriTemplate uriTemplate,
                    final Object... uriVariableValues
                    )
    throws OvalRepositoryException
    {
        URI  requestUri = uriTemplate.expand( uriVariableValues );
        if (_LOG.isDebugEnabled()) {
            _LOG.debug( ">>> GET: request URI=" + requestUri );
        }

        HttpHeaders  headers = new HttpHeaders();
        headers.setContentType( MediaType.APPLICATION_XML );
        headers.setAccept( _ACCEPT_MEDIA_TYPES_ );
        HttpEntity<String>  entity = new HttpEntity<String>( headers );

        ResponseEntity<T>  response = null;
        try {
            response = _rest.exchange(
                            requestUri,
                            HttpMethod.GET,
                            entity,
                            resourceType
                            );
        } catch (HttpStatusCodeException ex) {
            if (_LOG.isErrorEnabled()) {
                _LOG.error( "<<< GET: error status=" + ex.getStatusCode()
                                + ", " + ex.getStatusText() );
            }
            throw new OvalException( ex );
        }

        T  resource = response.getBody();
        if (_LOG.isDebugEnabled()) {
            _LOG.debug( "<<< GET: status=" + response.getStatusCode() );
        }

        return resource;
    }



    /**
     * REST POST: Creates an OVAL resource via HTTP POST.
     *
     * @return
     *  the ID of the resource to be used to obtain the resource.
     */
    private String _createResource(
                    final Object resource,
                    final String resourcePath
                    )
    throws OvalRepositoryException
    {
        URI  requestUri = _docBaseUri.expand( resourcePath );
        if (_LOG.isDebugEnabled()) {
            _LOG.debug( ">>> POST: request URI=" + requestUri );
        }

        URI  locationUri = null;
        try {
            locationUri = _rest.postForLocation( requestUri, resource );
        } catch (HttpStatusCodeException ex) {
            if (_LOG.isErrorEnabled()) {
                _LOG.error( "<<< POST: error status=" + ex.getStatusCode()
                                + ", " + ex.getStatusText() );
            }
            throw new OvalException( ex );
        }

        if (_LOG.isDebugEnabled()) {
            _LOG.debug( "<<< POST: location=" + locationUri );
        }

        if (locationUri == null) {
            throw new OvalException( "no location URI in HTTP POST response" );
        }

        Map<String, String>  params =
            _docLocationUri.match( locationUri.toASCIIString() );
        String  id = params.get( "id" );
        if (_LOG.isDebugEnabled()) {
            _LOG.debug( "resource created: id=" + id);
        }

        return id;
    }



    /**
     * HTTP POST
     */
    private String _post(
//                    final Class<T> objectType,
                    final Object object,
                    final UriTemplate uriTemplate,
                    final Object... uriVariableValues
                    )
    throws OvalRepositoryException
    {
//        HttpHeaders  headers = new HttpHeaders();
//        headers.setContentType( MediaType.APPLICATION_XML );
//        HttpEntity<String>  entity = new HttpEntity<String>( headers );

        URI  uri = uriTemplate.expand( uriVariableValues );
        String  uriString = uri.toASCIIString();
        if (_LOG.isDebugEnabled()) {
            _LOG.debug( "POST URI: " + uriString );
        }

        URI  locationUri = _rest.postForLocation( uriString, object );
//        URI  locationUri = response.getHeaders().getLocation();

        return (locationUri == null ? null : locationUri.toASCIIString());
    }



    //**************************************************************
    // OvalRepository
    //**************************************************************

    public String createOvalDefinitions(
                    final File defsFile
                    )
    throws OvalRepositoryException
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "POST oval_definitions XML file: " + defsFile );
        }

        String  xml = null;
        try {
            xml = IoUtil.readCharacters( defsFile );
        } catch (Exception ex) {
            throw new OvalException( ex );
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType( MediaType.APPLICATION_XML );
        HttpEntity<String>  entity = new HttpEntity<String>( xml, headers );
//        HttpEntity<String>  entity = new HttpEntity<String>( xml );

//        HttpEntity<Resource>  entity = new HttpEntity<Resource>( new FileSystemResource( defsFile ) );

        String  location = null;
        try {
            location = _post(
                            entity,
                            new UriTemplate( "{baseUri}/{objectPath}" ),
                            _baseUri,
                            ResourcePath.OVAL_DEFINITIONS.value()
                            );
        } catch (Exception ex) {
            if (_LOG.isErrorEnabled()) {
                _LOG.error( "POST ERROR: " + ex.getMessage() );
            }
            throw new OvalException( ex );
        }

        if (_LOG.isDebugEnabled()) {
            _LOG.debug( "POST oval_definitions: " + location );
        }

        return location;
    }



    public String createOvalDefinitions(
                    final OvalDefinitions definitions
                    )
    throws OvalRepositoryException
    {
        return _createResource(
                        definitions,
                        ResourcePath.OVAL_DEFINITIONS.value()
                        );
    }


    public OvalDefinitions getOvalDefinitions(
                    final String pid
                    )
    throws OvalRepositoryException
    {
        return _getResource(
                        OvalDefinitions.class,
                        _docLocationUri,
                        ResourcePath.OVAL_DEFINITIONS.value(),
                        pid
                        );
    }


    public List<Definition> findDefinitionByCve(
                    final String cveName
                    )
    throws OvalRepositoryException
    {
        @SuppressWarnings( "unchecked" )
        SearchResult<Definition>  result = _getResource(
                        SearchResult.class,
                        new UriTemplate( _baseUri + "/{resourcePath}?metadata.reference.refID={cveName}" ),
                        ResourcePath.DEFINITION.value(),
                        cveName
                        );

        return result.getElements();
    }





    public List<Definition> findDefinition(
                    final Map<String, String> params
                    )
    throws OvalRepositoryException
    {
        StringBuilder  s = new StringBuilder( _baseUri + "/{resourcePath}" );
        List<String>  values = new ArrayList<String>();
        values.add( ResourcePath.DEFINITION.value() );

        if (params != null) {
            for (String  key : params.keySet()) {
                if (values.size() == 1) {
                    s.append( "?" );
                } else {
                    s.append( "&" );
                }
                s.append( key ).append( "={" ).append( key ).append( "}" );
                values.add( params.get( key ) );
            }
        }

        @SuppressWarnings( "unchecked" )
        SearchResult<Definition>  result = _getResource(
                        SearchResult.class,
                        new UriTemplate( s.toString() ),
                        values.toArray()
                        );

        return result.getElements();
    }




    public String createOvalSystemCharacteristics(
                    final OvalSystemCharacteristics definitions
                    )
    throws OvalRepositoryException
    {
        return _createResource(
                        definitions,
                        ResourcePath.OVAL_SC.value()
                        );
    }


    public OvalSystemCharacteristics getOvalSystemCharacteristics(
                    final String pid
                    )
    throws OvalRepositoryException
    {
        return _getResource(
                        OvalSystemCharacteristics.class,
                        _docLocationUri,
                        ResourcePath.OVAL_SC.value(),
                        pid
                        );
    }



    public String createOvalResults(
                    final OvalResults results
                    )
    throws OvalRepositoryException
    {
        return _createResource(
                        results,
                        ResourcePath.OVAL_RESULTS.value()
                        );
    }



    public OvalResults getOvalResults(
                    final String pid
    )
    throws OvalRepositoryException
    {
        return _getResource(
                        OvalResults.class,
                        _docLocationUri,
                        ResourcePath.OVAL_RESULTS.value(),
                        pid
                        );
    }

}
// OvalRepositoryClient

