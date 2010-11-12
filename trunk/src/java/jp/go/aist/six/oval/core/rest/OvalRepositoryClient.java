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
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.service.OvalRepository;
import jp.go.aist.six.oval.service.OvalServiceException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;



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


    public static void main( final String[] args )
    throws Exception
    {
        OvalContext  context = new OvalContext();
        OvalRepositoryClient  client = (OvalRepositoryClient)context.getBean( "ovalRepositoryRestClient" );

        if (args.length < 1) {
            System.err.println( "No OVAL Definitions file specified." );
        } else {
            File  file = new File( args[0] );
            OvalDefinitions  defs = (OvalDefinitions)context.getXml().unmarshal( new FileInputStream( file ) );
            client.createOvalDefinitions( defs );
        }

//        client.getOvalResults( "89018e8d-1887-4e36-914b-e44f58474d0e" );
    }
//    {
//        OvalRepositoryClient  client = new OvalRepositoryClient();
//        OvalResults  results = client.getOvalResults( "68ab9c47-61aa-4cb7-acac-5f36401d2d06" );
//        System.out.println( "REST GET results: " + results );
//    }



    private String  _baseUri;

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
        if (_LOG.isInfoEnabled()) {
            _LOG.info( "baseUri: " + _baseUri );
        }
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
     * HTTP GET
     */
    private <T> T _get(
                    final Class<T> objectType,
                    final UriTemplate uriTemplate,
                    final Object... uriVariableValues
                    )
    throws OvalServiceException
    {
        HttpHeaders  headers = new HttpHeaders();
        // TODO: Accept???
        headers.setContentType( MediaType.APPLICATION_XML );
        HttpEntity<String>  entity = new HttpEntity<String>( headers );

        URI  uri = uriTemplate.expand( uriVariableValues );

        ResponseEntity<T>  response = _rest.exchange(
                        uri.toASCIIString(), HttpMethod.GET, entity, objectType
                        );
        T  object = response.getBody();

        return object;
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
    throws OvalServiceException
    {
//        HttpHeaders  headers = new HttpHeaders();
//        headers.setContentType( MediaType.APPLICATION_XML );
//        HttpEntity<String>  entity = new HttpEntity<String>( headers );

        URI  uri = uriTemplate.expand( uriVariableValues );

        URI  locationUri = _rest.postForLocation(
                        uri.toASCIIString(),
                        object
                        );
//        URI  locationUri = response.getHeaders().getLocation();

        return (locationUri == null ? null : locationUri.toASCIIString());
    }



    //**************************************************************
    // OvalRepository
    //**************************************************************

    public String createOvalDefinitions(
                    final OvalDefinitions defs
                    )
    throws OvalServiceException
    {
        String  location = _post(
                        defs,
                        new UriTemplate( "{baseUri}/{objectPath}" ),
                        _baseUri,
                        ResourcePath.OVAL_DEFINITIONS.value()
                        );
        if (_LOG.isDebugEnabled()) {
            _LOG.debug( "POST oval_definitions: " + location );
        }

        return location;
    }


    public OvalDefinitions getOvalDefinitions( String pid )
    throws OvalServiceException
    {
        return null;
    }



    public String createOvalResults( OvalResults resutls )
    throws OvalServiceException
    {
        return null;
    }



    public OvalResults getOvalResults(
                    final String pid
    )
    throws OvalServiceException
    {
        OvalResults  results = _get(
                        OvalResults.class,
                        new UriTemplate( "{baseUri}/{objectPath}/{id}" ),
                        _baseUri,
                        ResourcePath.OVAL_RESULTS.value(),
                        pid
                        );
        if (_LOG.isDebugEnabled()) {
            _LOG.debug( "GET oval_results: " + results );
        }

        return results;
    }

}
// OvalRepositoryClient

