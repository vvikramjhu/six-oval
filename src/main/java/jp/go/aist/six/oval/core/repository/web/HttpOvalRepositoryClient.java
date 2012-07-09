/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.go.aist.six.oval.core.repository.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.oval.model.ElementType;
import jp.go.aist.six.oval.model.common.OvalId;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.DefinitionsElement;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.repository.CommonQueryParams;
import jp.go.aist.six.oval.repository.DefinitionQueryParams;
import jp.go.aist.six.oval.repository.OvalRepository;
import jp.go.aist.six.oval.repository.OvalRepositoryException;
import jp.go.aist.six.oval.repository.QueryParams;
import jp.go.aist.six.oval.repository.QueryResults;
import jp.go.aist.six.oval.repository.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;



/**
 * An implementation of OvalRepository using MongoDB.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class HttpOvalRepositoryClient
    implements OvalRepository
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
                    LoggerFactory.getLogger( HttpOvalRepositoryClient.class );




    private String  _repositoryBaseUrl;



    /**
     * Constructor.
     */
    public HttpOvalRepositoryClient()
    {
        _init();
    }



    private void _init()
    {
        _LOG_.debug( "initializing..." );

        _repositoryBaseUrl = OvalContext.getProperty( "six.oval.repository.web.base-url" );
        _LOG_.info( "repository base URL: " + _repositoryBaseUrl );

        _LOG_.debug( "...initialized" );
    }



    /**
     */
    private RestTemplate _newRestTemplate()
    {
        return OvalContext.getBean( RestTemplate.class );
    }



    /**
     * HTTP GET
     *
     * @return
     */
    private <T> T _httpGet(
                    final String url_path,
                    final Class<T> response_type,
                    final Object... uri_variables
                    )
    {
        _LOG_.debug( "HTTP GET: URL path=" + url_path
                        + ", response type=" + response_type
                        + ", variables=" + Arrays.toString( uri_variables ) );

        HttpHeaders  request_headers = new HttpHeaders();
        request_headers.setContentType( MediaType.APPLICATION_XML );
        HttpEntity<?> request_entity = new HttpEntity<Void>( request_headers );

        HttpEntity<T>  response = null;
        try {
            response = _newRestTemplate().exchange(
                            _repositoryBaseUrl + url_path, HttpMethod.GET,
                            request_entity, response_type, uri_variables );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        T  body = response.getBody();

        return body;
    }



    /**
     *
     * @param params
     * @return
     */
    private String _toUriQueryStrings(
                    final QueryParams params
                    )
    {
        if (params == null  ||  params.size() == 0) {
            return "";
        }

        StringBuilder  s = new StringBuilder();
        boolean  first_key = true;
        for (String  key : params.keys()) {
            if (first_key) {
                s.append( "?" );
                first_key = false;
            } else {
                s.append( "&" );
            }

            String  value = params.get( key );
            s.append( key ).append( "=" ).append( value );
        }

        return s.toString();
    }



    /**
     */
    private QueryResults<String> _toStringIdResults(
                    final QueryResults<OvalId>  oval_id_results
                    )
    {
        List<String>  id_list = new ArrayList<String>();
        for (OvalId  oval_id : oval_id_results.getElements()) {
            id_list.add( oval_id.toString() );
        }

        QueryResults<String>  query_results = new QueryResults<String>( id_list );
        query_results.setTimestamp( oval_id_results.getTimestamp() );
        query_results.setTotalResults( oval_id_results.getTotalResults() );
        query_results.setItemsPerPage( oval_id_results.getItemsPerPage() );

        return query_results;
    }




    //*********************************************************************
    //  implements OvalDefinitionRepository
    //*********************************************************************

    //=====================================================================
    //  Definition
    //=====================================================================

    private static final String  _URL_DEFINITON_BY_ID_ =
                    "/definitions/{id}";


    @Override
    public DefinitionType findDefinitionById(
                    final String oval_id
                    )
    {
        DefinitionType  def = _httpGet(
                        _URL_DEFINITON_BY_ID_, DefinitionType.class, oval_id );
        return def;
    }



    private static final String  _URL_DEFINITON_ =
                    "/definitions";

    @Override
    public QueryResults<DefinitionType> findDefinition()
    {
        @SuppressWarnings( "unchecked" )
        QueryResults<DefinitionType>  query_results = _httpGet(
                        _URL_DEFINITON_, QueryResults.class );

        return query_results;
    }



    @Override
    public QueryResults<DefinitionType> findDefinition(
                    final QueryParams params
                    )
    {
        String  query_part = _toUriQueryStrings( params );

        @SuppressWarnings( "unchecked" )
        QueryResults<DefinitionType>  query_results = _httpGet(
                        _URL_DEFINITON_ + query_part, QueryResults.class );

        return query_results;
    }



//    private static final String  _URL_DEFINITON_ID_ =
//                    "/definitions/id";
//
//
//    @Override
//    public QueryResults<String> findDefinitionId(
//                    final QueryParams params
//                    )
//    {
//        String  query_part = _toUriQueryStrings( params );
//
//        @SuppressWarnings( "unchecked" )
//        QueryResults<String>  query_results = _httpGet(
//                        _URL_DEFINITON_ID_ + query_part, QueryResults.class );
//
//        return query_results;
//    }

    @Override
    public QueryResults<String> findDefinitionId(
                    final QueryParams params
                    )
    {
        QueryParams  ps = null;
        if (params == null) {
            ps = new DefinitionQueryParams();
        } else {
            try {
                ps = QueryParams.class.cast( params.clone() );
            } catch (CloneNotSupportedException ex) {
                //never thrown
            }
        }
        ps.set( CommonQueryParams.Key.VIEW, View.id.name() );

        String  query_part = _toUriQueryStrings( ps );

        @SuppressWarnings( "unchecked" )
        QueryResults<OvalId>  oval_id_results = _httpGet(
                        _URL_DEFINITON_ + query_part, QueryResults.class );

        QueryResults<String>  query_results = _toStringIdResults( oval_id_results );

//        List<String>  id_list = new ArrayList<String>();
//        for (OvalId  oval_id : oval_id_results.getElements()) {
//            id_list.add( oval_id.toString() );
//        }
//
//        QueryResults<String>  query_results = new QueryResults<String>( id_list );
//        query_results.setTimestamp( oval_id_results.getTimestamp() );
//        query_results.setTotalResults( oval_id_results.getTotalResults() );
//        query_results.setItemsPerPage( oval_id_results.getItemsPerPage() );

        return query_results;
    }



//    private static final String  _URL_DEFINITON_COUNT_ =
//                    "/definitions/count";


    @Override
    public long countDefinition()
    {
        return countDefinition( null );
    }



    @Override
    public long countDefinition(
                    final QueryParams params
                    )
    {
        QueryParams  ps = null;
        if (params == null) {
            ps = new DefinitionQueryParams();
        } else {
            try {
                ps = QueryParams.class.cast( params.clone() );
            } catch (CloneNotSupportedException ex) {
                //never thrown
            }
        }
        ps.set( CommonQueryParams.Key.VIEW, View.count.name() );

        String  query_part = _toUriQueryStrings( ps );

        @SuppressWarnings( "unchecked" )
        QueryResults<Void>  query_results = _httpGet(
                        _URL_DEFINITON_ + query_part, QueryResults.class );

        return query_results.getTotalResults();
    }

//BACKUP
//    @Override
//    public long countDefinition(
//                    final QueryParams params
//                    )
//    {
//        String  query_part = _toUriQueryStrings( params );
//
//        @SuppressWarnings( "unchecked" )
//        QueryResults<Long>  query_results = _httpGet(
//                        _URL_DEFINITON_COUNT_ + query_part, QueryResults.class );
//
//        return query_results.getElements().get( 0 );
//    }






    //=====================================================================
    // definitions element (Definition, Test, Object, State, Variable)
    //=====================================================================

    private static final String  _URL_ELEMENT_BY_ID_ =
                    "/{type}s/{id}";

    @Override
    public DefinitionsElement findElementById(
                    final String oval_id
                    )
    {
        ElementType  type = OvalId.elementTypeOf( oval_id );
        DefinitionsElement  element = _httpGet(
                        _URL_ELEMENT_BY_ID_, DefinitionsElement.class, type.value(), oval_id );
        return element;
    }



    @Override
    public QueryResults<DefinitionsElement> findElement( final QueryParams params )
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public long countElement( final QueryParams params )
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public String saveElement( final DefinitionsElement element )
    {
        throw new UnsupportedOperationException();
    }



    //=====================================================================
    // OvalDefinitions
    //=====================================================================

    @Override
    public OvalDefinitions findOvalDefinitionsById( final String id )
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public String saveOvalDefinitions( final OvalDefinitions oval_defs )
    {
        throw new UnsupportedOperationException();
    }



    //*********************************************************************
    //  implements OvalResultRepository
    //*********************************************************************

    @Override
    public OvalResults findOvalResultsById( final String id )
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public QueryResults<OvalResults> findOvalResults()
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public QueryResults<OvalResults> findOvalResults( final QueryParams params )
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public QueryResults<String> findOvalResultsId()
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public QueryResults<String> findOvalResultsId( final QueryParams params )
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public long countOvalResults()
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public String saveOvalResults( final OvalResults oval_results )
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public OvalSystemCharacteristics findOvalSystemCharacteristicsById( final String id )
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public QueryResults<OvalSystemCharacteristics> findOvalSystemCharacteristics( final QueryParams params )
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public String saveOvalSystemCharacteristics( final OvalSystemCharacteristics oval_sc )
    {
        throw new UnsupportedOperationException();
    }

}
//
