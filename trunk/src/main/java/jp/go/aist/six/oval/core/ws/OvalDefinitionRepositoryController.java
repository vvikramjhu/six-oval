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

package jp.go.aist.six.oval.core.ws;

import java.net.URI;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import jp.go.aist.six.oval.OvalException;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalDatastore;
import jp.go.aist.six.oval.model.OvalObject;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.repository.CommonQueryParams;
import jp.go.aist.six.oval.repository.QueryParams;
import jp.go.aist.six.oval.repository.QueryResults;
import jp.go.aist.six.util.persist.Persistable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
@Controller
public class OvalDefinitionRepositoryController
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( OvalDefinitionRepositoryController.class );


    public static final String  DEFINITIONS_REL = "http://aist.go.jp/six/oval/rels/oval_definitions";
    public static final String  DEFINITION_REL  = "http://aist.go.jp/six/oval/rels/d/definition";
    public static final String  TEST_REL        = "http://aist.go.jp/six/oval/rels/d/test";
    public static final String  SC_REL          = "http://aist.go.jp/six/oval/rels/oval_system_characteristics";
    public static final String  RESULTS_REL     = "http://aist.go.jp/six/oval/rels/oval_results";


    // " " space = %20
    // "/" slash = %2f
    // "." dot   = %2e
    // "&" ampa  = %26


    private MongoOvalDatastore  _datastore;



    /**
     * Constructor.
     */
    public OvalDefinitionRepositoryController()
    {
    }




    /**
     */
    public void setDatastore(
                    final MongoOvalDatastore repository
                    )
    {
        _datastore = repository;
    }


    protected MongoOvalDatastore _getDatastore()
    {
        return _datastore;
    }



    //////////////////////////////////////////////////////////////////////
    //  REST support methods
    //////////////////////////////////////////////////////////////////////

    /**
     * Builds a location URI from the specified request URL
     * and the created object ID.
     */
    private URI _buildResourceLocation(
                    final HttpServletRequest request,
                    final String id
                    )
    {
        String  requestUrl = request.getRequestURL().toString();
        URI  uri = new UriTemplate( "{requestUrl}/{id}" ).expand( requestUrl, id );
//        _LOG_.debug( "Location: " + uri.toASCIIString() );

        return uri;
    }



    /**
     * GET: find one resource by ID.
     */
    private <K, T extends OvalObject & Persistable<K>>
    T _getResourceById(
                    final Class<T> type,
                    final K id
                    )
    throws OvalException
    {
        _LOG_.debug( "GET: type=" + type + ", id=" + id );
        T  resource = _getDatastore().findById( type, id );

        return resource;
    }



    /**
     * Creates a resource.
     */
    private <K, T extends OvalObject & Persistable<K>>
    ResponseEntity<Void> _createResource(
                    final HttpServletRequest request,
                    final Class<T> type,
                    final T object
                    )
    throws OvalException
    {
        _LOG_.debug( "POST: type=" + type + ", object=" + object );

        K  id = _datastore.save( type, object );

        URI  locationUri = _buildResourceLocation( request, String.valueOf( id ) );
//        _LOG_.debug( "resource created: location=" + locationUri.toASCIIString() );

        HttpHeaders  headers = new HttpHeaders();
        headers.setLocation( locationUri );

        _LOG_.debug( "HTTP response headers=" + headers );

        return new ResponseEntity<Void>( headers, HttpStatus.CREATED );
    }



    /**
     * Retrieves the resources.
     */
    public <K, T extends OvalObject & Persistable<K>>
    QueryResults<T> _findResource(
                    final Class<T> type,
                    final QueryParams params
                    )
    throws OvalException
    {
        _LOG_.debug( "GET (find): type=" + type + ", params=" + params );

        List<T>  list = _getDatastore().find( type, params );

        return _buildQueryResults( params, list );
    }



    /**
     */
    protected static <T> QueryResults<T> _buildQueryResults(
                    final QueryParams params,
                    final List<T> elements
                    )
    {
        QueryResults<T>  r = _buildQueryResults( elements );

        if (params != null) {
            String  key = CommonQueryParams.Key.COUNT;
            if (params.containsKey( key )) {
                int  count = params.getAsInt( key );
                r.setItemsPerPage( (long)count );
            }

            key = CommonQueryParams.Key.START_INDEX;
            if (params.containsKey( key )) {
                int  index = params.getAsInt( key );
                r.setItemsPerPage( (long)index );
            }
        }

        return r;
    }


    protected static <T> QueryResults<T> _buildQueryResults(
                    final List<T> elements
                    )
    {
        QueryResults<T>  r = new QueryResults<T>();
        r.setElements( elements );

        return r;
    }



    /**
     * Retrieves the resources.
     */
    public <K, T extends OvalObject & Persistable<K>>
    QueryResults<K> _getResourceIDs(
                    final Class<T> type
                    )
    throws OvalException
    {
        _LOG_.debug( "GET (find): type=" + type );

        List<K>  list = _getDatastore().findId( type );

        return _buildQueryResults( list );
    }


    public <K, T extends OvalObject & Persistable<K>>
    QueryResults<K> _findResourceIDs(
                    final Class<T> type,
                    final QueryParams params
                    )
    throws OvalException
    {
        _LOG_.debug( "GET (find): type=" + type + ", params=" + params );

        List<K>  list = _getDatastore().findId( type, params );

        return _buildQueryResults( params, list );
    }



    //////////////////////////////////////////////////////////////////////
    // Exception Handlers, HTTP Status Code
    //////////////////////////////////////////////////////////////////////

    // 404: Not Found
    @ExceptionHandler( ObjectRetrievalFailureException.class )
    @ResponseStatus( HttpStatus.NOT_FOUND )
    public void handleNotFound(
                    final ObjectRetrievalFailureException ex
                    )
    {
        _handleException( ex );
    }


    // 500: Internal Server Error
    @ExceptionHandler( OvalException.class )
    @ResponseStatus( HttpStatus.INTERNAL_SERVER_ERROR )
    public @ResponseBody String handleInternalServerError(
                    final OvalException ex
                    )
    {
        _handleException( ex );
        return ex.getMessage();
    }


    private void _handleException(
                    final Exception ex
                    )
    {
//        Throwable  rootCause = null;
//        if (ex instanceof NestedRuntimeException) {
//            rootCause = NestedRuntimeException.class.cast( ex ).getRootCause();
//        }

        _LOG_.error( "handle exception: " + ex.getClass().getName()
                            + " - " + ex.getMessage() );
    }



    //////////////////////////////////////////////////////////////////////
    //  REST WS API
    //////////////////////////////////////////////////////////////////////

    //********************************************************************
    // oval-def:definition
    //********************************************************************

    // GET
    //
    // NOTE: OVAL IDs contain "." (dot) characters.
    //       The character has special meaning for the Spring framework.
    //
    // about path variables including ".":
    // @see http://forum.springsource.org/showthread.php?78085-Problems-with-RequestMapping&p=263563
    // test: curl -v -X GET -HAccept:application/xml "http://localhost:8080/oval_rep/def/definitions/oval:org%2emitre%2eoval:def:7222"
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/def/definitions/{id:.*}"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody DefinitionType findDefinitionById(
                    @PathVariable final String id
                    )
    throws OvalException
    {
        return _getResourceById( DefinitionType.class, id );
    }



    // POST (create)


}
//

