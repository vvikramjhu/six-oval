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
        OvalRepositoryClient  client = new OvalRepositoryClient();
        client.getOvalResults( "68ab9c47-61aa-4cb7-acac-5f36401d2d06" );
    }



    private RestTemplate  _rest;



    /**
     * Constructor.
     */
    public OvalRepositoryClient()
    {
    }



    /**
     */
    private void _setUp()
    throws OvalServiceException
    {
        OvalContext  context = new OvalContext();
        try {
            _rest = (RestTemplate)context.getBean( "restTemplate" );
        } catch (Exception ex) {
            throw new OvalServiceException( ex );
        }
    }



    /**
     */
    private HttpEntity<String> _prepareGet(
                    final MediaType type
    )
    throws OvalServiceException
    {
        if (_rest == null) {
            _setUp();
        }

        HttpHeaders  headers = new HttpHeaders();
        headers.setContentType( type );
        HttpEntity<String>  entity = new HttpEntity<String>( headers );

        return entity;
    }



    //**************************************************************
    // OvalRepository
    //**************************************************************

    public String createOvalDefinitions( OvalDefinitions defs )
    throws OvalServiceException
    {
        return null;
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
        HttpEntity<String>  entity = _prepareGet( MediaType.APPLICATION_XML );

        ResponseEntity<OvalResults>  response = _rest.exchange(
                "http://localhost:8080/six-oval-0.7.0/rest/oval_results/" + pid,
                HttpMethod.GET, entity, OvalResults.class);
        OvalResults  results = response.getBody();

        return results;
    }

}
// OvalRepositoryClient

