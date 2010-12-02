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

package jp.go.aist.six.oval.core.service;

import jp.go.aist.six.oval.core.rest.ResourcePath;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.service.OvalException;
import jp.go.aist.six.oval.service.OvalRepository;
import jp.go.aist.six.oval.service.OvalRepositoryException;
import jp.go.aist.six.util.persist.DataStore;
import jp.go.aist.six.util.search.SearchResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.util.UriTemplate;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class LocalOvalRepository
    implements OvalRepository
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( LocalOvalRepository.class );



    private DataStore  _store;



    /**
     * Constructor.
     */
    public LocalOvalRepository()
    {
        _init();
    }



    /**
     *
     */
    private void _init()
    {
        OvalContext  context = new OvalContext();
        DataStore  store = context.getBean( "ovalStore", DataStore.class );
        setStore( store );
    }



    /**
     */
    public void setStore(
                    final DataStore store
                    )
    {
        _store = store;
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

