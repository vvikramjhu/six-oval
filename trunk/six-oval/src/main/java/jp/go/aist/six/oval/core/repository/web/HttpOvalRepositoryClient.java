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

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.go.aist.six.oval.interpreter.OvalInterpreterException;
import jp.go.aist.six.oval.model.DocumentId;
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
import jp.go.aist.six.oval.repository.OvalResultsQueryParams;
import jp.go.aist.six.oval.repository.OvalSystemCharacteristicsQueryParams;
import jp.go.aist.six.oval.repository.QueryParams;
import jp.go.aist.six.oval.repository.QueryResults;
import jp.go.aist.six.oval.repository.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
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
    private List<HttpMessageConverter<?>>  _messageConverters;



    /**
     * Constructor.
     */
    public HttpOvalRepositoryClient()
    {
//        _init();
    }


    public HttpOvalRepositoryClient(
                    final String base_url
                    )
    {
        setRepositoryBaseUrl( base_url );
    }


//    private void _init()
//    {
//        _LOG_.debug( "initializing..." );
//
//        _repositoryBaseUrl = OvalContext.getProperty( "six.oval.repository.web.base-url" );
//        _LOG_.info( "repository base URL: " + _repositoryBaseUrl );
//
//        _LOG_.debug( "...initialized" );
//    }



    /**
     */
    public void setRepositoryBaseUrl(
                    final String url
                    )
    {
        _repositoryBaseUrl = url;
    }


    public String getRepositoryBaseUrl()
    {
        if (_repositoryBaseUrl == null) {
            throw new OvalRepositoryException( "repository base URL not configured" );
        }

        return _repositoryBaseUrl;
    }



    /**
     */
    public void setMessageConverters(
                    final List<HttpMessageConverter<?>> messageConverters
                    )
    {
        _messageConverters = messageConverters;
    }


    protected List<HttpMessageConverter<?>> _getMessageConverters()
    {
        return _messageConverters;
    }



    /**
     * scope="prototype";
     * i.e. each time this method is called, a new instance is created.
     */
    private RestTemplate _newRestTemplate()
    {
        RestTemplate  template = new RestTemplate();

        List<HttpMessageConverter<?>>  converters = _getMessageConverters();
        if (converters != null) {
            template.setMessageConverters( _getMessageConverters() );
        }

        return template;
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
                            getRepositoryBaseUrl() + url_path, HttpMethod.GET,
                            request_entity, response_type, uri_variables );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        T  body = response.getBody();

        return body;
    }



    /**
     * HTTP POST
     *
     * @throws  OvalInterpreterException
     */
    protected <T> String _httpPost(
                    final String url_path,
                    final T object,
                    final Class<T> type
                    )
    {
//        _LOG_.debug( "HTTP POST: to URL=" + to_url
//                        + ", from file=" + from_file
//                        + ", content-type=" + content_type );

        HttpHeaders  request_headers = new HttpHeaders();
        request_headers.setContentType( MediaType.APPLICATION_XML );
        HttpEntity<T> request_entity = new HttpEntity<T>( object, request_headers );

        URI  location = null;
        try {
            location= _newRestTemplate().postForLocation(
                            getRepositoryBaseUrl() + url_path, request_entity );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

//        HttpEntity<Void>  response = null;
//        try {
//            response = _newRestTemplate().exchange(
//                            _repositoryBaseUrl + url_path, HttpMethod.POST,
//                            request_entity, Void.class );
//        } catch (Exception ex) {
//            throw new OvalRepositoryException( ex );
//        }
//
//        HttpHeaders  response_headers = response.getHeaders();
//        URI  location = response_headers.getLocation();
//        if (location == null) {
//            throw new OvalRepositoryException( "no location in HTTP headers" );
//        }

        String  path = location.getPath();
        String  id = path.substring( path.lastIndexOf( '/' ) + 1 );

        return id;
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
    private QueryResults<String> _toStringOvalIdResults(
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


    private QueryResults<String> _toStringDocumentIdResults(
                    final QueryResults<DocumentId>  doc_id_results
                    )
    {
        List<String>  id_list = new ArrayList<String>();
        for (DocumentId  doc_id : doc_id_results.getElements()) {
            id_list.add( doc_id.toString() );
        }

        QueryResults<String>  query_results = new QueryResults<String>( id_list );
        query_results.setTimestamp( doc_id_results.getTimestamp() );
        query_results.setTotalResults( doc_id_results.getTotalResults() );
        query_results.setItemsPerPage( doc_id_results.getItemsPerPage() );

        return query_results;
    }




    //*********************************************************************
    //  implements OvalDefinitionRepository
    //*********************************************************************

    //=====================================================================
    //  Definition
    //=====================================================================

    private static final String  _URL_DEFINITON_BY_ID_  = "/definitions/{id}";

    private static final String  _URL_DEFINITON_        = "/definitions";


    @Override
    public DefinitionType findDefinitionById(
                    final String oval_id
                    )
    {
        DefinitionType  def = _httpGet(
                        _URL_DEFINITON_BY_ID_, DefinitionType.class, oval_id );
        return def;
    }



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



    @Override
    public QueryResults<String> findDefinitionId()
    {
        QueryParams  ps = new DefinitionQueryParams();
        ps.set( CommonQueryParams.Key.VIEW, View.id.name() );

        String  query_part = _toUriQueryStrings( ps );

        @SuppressWarnings( "unchecked" )
        QueryResults<OvalId>  oval_id_results = _httpGet(
                        _URL_DEFINITON_ + query_part, QueryResults.class );

        QueryResults<String>  query_results = _toStringOvalIdResults( oval_id_results );

        return query_results;
    }



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

        QueryResults<String>  query_results = _toStringOvalIdResults( oval_id_results );

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



    @Override
    public String saveDefinition(
                    final DefinitionType def
                    )
    {
        String  id = _httpPost( _URL_DEFINITON_, def, DefinitionType.class );

        return id;
    }



    //=====================================================================
    // definitions element (Definition, Test, Object, State, Variable)
    //=====================================================================

    private static final String  _URL_ELEMENT_BY_ID_ = "/{type}s/{id}";

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
    public QueryResults<String> findElementId(
                    final QueryParams params
                    )
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

    private static final String  _URL_OVAL_DEFINITONS_       = "/oval_definitions";

    private static final String  _URL_OVAL_DEFINITONS_BY_ID_ = "/oval_definitions/{id}";



    @Override
    public OvalDefinitions findOvalDefinitionsById(
                    final String id
                    )
    {
        OvalDefinitions  oval_defs = _httpGet(
                        _URL_OVAL_DEFINITONS_BY_ID_, OvalDefinitions.class, id );
        return oval_defs;
    }



    @Override
    public QueryResults<String> findOvalDefinitionsId()
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public QueryResults<String> findOvalDefinitionsId( final QueryParams params )
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public long countOvalDefinitions()
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public long countOvalDefinitions( final QueryParams params )
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public String saveOvalDefinitions(
                    final OvalDefinitions oval_defs
                    )
    {
        String  id = _httpPost( _URL_OVAL_DEFINITONS_, oval_defs, OvalDefinitions.class );

        return id;
    }



    //*********************************************************************
    //  implements OvalResultRepository
    //*********************************************************************

    private static final String  _URL_OVAL_RESULTS_         = "/oval_results";

    private static final String  _URL_OVAL_RESULTS_BY_ID_   = "/oval_results/{id}";


    @Override
    public OvalResults findOvalResultsById(
                    final String id
                    )
    {
        OvalResults  oval_results = _httpGet(
                        _URL_OVAL_RESULTS_BY_ID_, OvalResults.class, id );
        return oval_results;
    }



    @Override
    public QueryResults<OvalResults> findOvalResults()
    {
        @SuppressWarnings( "unchecked" )
        QueryResults<OvalResults>  query_results = _httpGet(
                        _URL_OVAL_RESULTS_, QueryResults.class );

        return query_results;
    }



    @Override
    public QueryResults<OvalResults> findOvalResults(
                    final QueryParams params
                    )
    {
        String  query_part = _toUriQueryStrings( params );

        @SuppressWarnings( "unchecked" )
        QueryResults<OvalResults>  query_results = _httpGet(
                        _URL_OVAL_RESULTS_ + query_part, QueryResults.class );

        return query_results;
    }



    @Override
    public QueryResults<String> findOvalResultsId()
    {
        return findOvalResultsId( null );
    }



    @Override
    public QueryResults<String> findOvalResultsId(
                    final QueryParams params
                    )
    {
        QueryParams  ps = null;
        if (params == null) {
            ps = new OvalResultsQueryParams();
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
        QueryResults<DocumentId>  doc_id_results = _httpGet(
                        _URL_OVAL_RESULTS_ + query_part, QueryResults.class );

        QueryResults<String>  query_results = _toStringDocumentIdResults( doc_id_results );

        return query_results;
    }



    @Override
    public long countOvalResults()
    {
        QueryParams  ps = new OvalResultsQueryParams();
        ps.set( CommonQueryParams.Key.VIEW, View.count.name() );

        String  query_part = _toUriQueryStrings( ps );

        @SuppressWarnings( "unchecked" )
        QueryResults<Void>  query_results = _httpGet(
                        _URL_OVAL_RESULTS_ + query_part, QueryResults.class );

        return query_results.getTotalResults();
    }



    @Override
    public long countOvalResults(
                    final QueryParams params
                    )
    {
        QueryParams  ps = null;
        if (params == null) {
            ps = new OvalResultsQueryParams();
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
                        _URL_OVAL_RESULTS_ + query_part, QueryResults.class );

        return query_results.getTotalResults();
    }



    @Override
    public String saveOvalResults(
                    final OvalResults oval_results
                    )
    {
        String  id = _httpPost( _URL_OVAL_RESULTS_, oval_results, OvalResults.class );

        return id;
    }



    //=====================================================================
    // OvalSystemCharacteristics
    //=====================================================================

    private static final String  _URL_OVAL_SCS_         = "/oval_scs";

    private static final String  _URL_OVAL_SCS_BY_ID_   = "/oval_scs/{id}";


    @Override
    public OvalSystemCharacteristics findOvalSystemCharacteristicsById(
                    final String id
                    )
    {
        OvalSystemCharacteristics  oval_scs = _httpGet(
                        _URL_OVAL_SCS_BY_ID_, OvalSystemCharacteristics.class, id );
        return oval_scs;
    }



    @Override
    public QueryResults<OvalSystemCharacteristics> findOvalSystemCharacteristics()
    {
        @SuppressWarnings( "unchecked" )
        QueryResults<OvalSystemCharacteristics>  query_results = _httpGet(
                        _URL_OVAL_SCS_, QueryResults.class );

        return query_results;
    }



    @Override
    public QueryResults<OvalSystemCharacteristics> findOvalSystemCharacteristics(
                    final QueryParams params
                    )
    {
        String  query_part = _toUriQueryStrings( params );

        @SuppressWarnings( "unchecked" )
        QueryResults<OvalSystemCharacteristics>  query_results = _httpGet(
                        _URL_OVAL_SCS_ + query_part, QueryResults.class );

        return query_results;
    }



    @Override
    public QueryResults<String> findOvalSystemCharacteristicsId()
    {
        return findOvalSystemCharacteristicsId( null );
    }



    @Override
    public QueryResults<String> findOvalSystemCharacteristicsId(
                    final QueryParams params
                    )
    {
        QueryParams  ps = null;
        if (params == null) {
            ps = new OvalSystemCharacteristicsQueryParams();
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
        QueryResults<DocumentId>  doc_id_results = _httpGet(
                        _URL_OVAL_SCS_ + query_part, QueryResults.class );

        QueryResults<String>  query_results = _toStringDocumentIdResults( doc_id_results );

        return query_results;
    }



    @Override
    public long countOvalSystemCharacteristics()
    {
        QueryParams  ps = new OvalSystemCharacteristicsQueryParams();
        ps.set( CommonQueryParams.Key.VIEW, View.count.name() );

        String  query_part = _toUriQueryStrings( ps );

        @SuppressWarnings( "unchecked" )
        QueryResults<Void>  query_results = _httpGet(
                        _URL_OVAL_SCS_ + query_part, QueryResults.class );

        return query_results.getTotalResults();
    }



    @Override
    public long countOvalSystemCharacteristics(
                    final QueryParams params
                    )
    {
        QueryParams  ps = null;
        if (params == null) {
            ps = new OvalSystemCharacteristicsQueryParams();
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
                        _URL_OVAL_SCS_ + query_part, QueryResults.class );

        return query_results.getTotalResults();
    }



    @Override
    public String saveOvalSystemCharacteristics(
                    final OvalSystemCharacteristics oval_scs
                    )
    {
        String  id = _httpPost( _URL_OVAL_SCS_, oval_scs, OvalSystemCharacteristics.class );

        return id;
    }

}
//
