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
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalDatabase;
import jp.go.aist.six.oval.core.repository.mongodb.OvalDefinitionsGenerator;
import jp.go.aist.six.oval.model.OvalObject;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.StateType;
import jp.go.aist.six.oval.model.definitions.SystemObjectType;
import jp.go.aist.six.oval.model.definitions.TestType;
import jp.go.aist.six.oval.model.definitions.VariableType;
import jp.go.aist.six.oval.repository.CommonQueryParams;
import jp.go.aist.six.oval.repository.DefinitionQueryParams;
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
import org.springframework.web.bind.annotation.RequestBody;
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
    // "&" ampa  = %26
    // "*" astah = %2a
    // "." dot   = %2e
    // "/" slash = %2f


    private MongoOvalDatabase  _database;

    private OvalDefinitionsGenerator  _generator;



    /**
     * Constructor.
     */
    public OvalDefinitionRepositoryController()
    {
    }




    /**
     */
    public void setDatabase(
                    final MongoOvalDatabase database
                    )
    {
        _database = database;
    }


    protected MongoOvalDatabase _getDatabase()
    {
        return _database;
    }



    /**
     */
    public void setGenerator(
                    final OvalDefinitionsGenerator generator
                    )
    {
        _generator = generator;
    }


    protected OvalDefinitionsGenerator _getGenerator()
    {
        return _generator;
    }



    //////////////////////////////////////////////////////////////////////
    //  REST support methods
    //////////////////////////////////////////////////////////////////////

    /**
     * Builds a location URI from the specified request URL
     * and the created object ID.
     */
    protected URI _buildResourceLocation(
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
     * Find one resource by ID.
     */
    protected <K, T extends OvalObject & Persistable<K>>
    T _findResourceById(
                    final Class<T> type,
                    final K id
                    )
    throws OvalException
    {
        _LOG_.debug( "GET: type=" + type + ", id=" + id );
        T  resource = _getDatabase().findById( type, id );

        return resource;
    }



    /**
     * Creates a resource.
     */
    protected <K, T extends OvalObject & Persistable<K>>
    ResponseEntity<Void> _saveResource(
                    final HttpServletRequest request,
                    final Class<T> type,
                    final T object
                    )
    throws OvalException
    {
        _LOG_.debug( "POST: type=" + type + ", object=" + object );

        K  id = _database.save( type, object );

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
    protected <K, T extends OvalObject & Persistable<K>>
    QueryResults<T> _findResource(
                    final Class<T> type,
                    final QueryParams params
                    )
    throws OvalException
    {
        _LOG_.debug( "GET (find): type=" + type + ", params=" + params );

        QueryParams  p = ((params == null  ||  params.size() == 0) ? null : params);
        List<T>  list = _getDatabase().find( type, p );

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
        return new QueryResults<T>( elements );

//        QueryResults<T>  r = new QueryResults<T>( elements );
//        return r;
    }



    /**
     * Retrieves the resources.
     */
    protected <K, T extends OvalObject & Persistable<K>>
    QueryResults<K> _getResourceIDs(
                    final Class<T> type
                    )
    throws OvalException
    {
        _LOG_.debug( "GET (find): type=" + type );

        List<K>  list = _getDatabase().findId( type );

        return _buildQueryResults( list );
    }


    protected <K, T extends OvalObject & Persistable<K>>
    QueryResults<K> _findResourceIDs(
                    final Class<T> type,
                    final QueryParams params
                    )
    throws OvalException
    {
        _LOG_.debug( "GET (find): type=" + type + ", params=" + params );

        List<K>  list = _getDatabase().findId( type, params );

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


    protected void _handleException(
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

    // GET: fetch one by ID
    //
    // NOTE: OVAL IDs contain "." (dot) characters.
    //       The character has special meaning for the Spring framework.
    //
    // about path variables including ".":
    // @see http://forum.springsource.org/showthread.php?78085-Problems-with-RequestMapping&p=263563
    // test: curl -v -X GET -HAccept:application/xml "http://localhost:8080/six-oval/repository/definitions/oval:org%2emitre%2eoval:def:7222"
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/repository/definitions/{id:.*}"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody DefinitionType findDefinitionById(
                    @PathVariable final String id
                    )
    throws OvalException
    {
        return _findResourceById( DefinitionType.class, id );
    }



    //NOTE: From URI viewpoint, this path is a special case of findDefinition(params), where params = null.
    //If we activate this method, Spring MVC throws an exception.
//    // GET: fetch all
//    // test: curl -v -X GET -HAccept:application/xml "http://localhost:8080/oval_rep/def/definitions"
//    @RequestMapping(
//                    method=RequestMethod.GET
//                    ,value="/def/definitions"
//                    ,headers="Accept=application/xml"
//    )
//    public @ResponseBody QueryResults<DefinitionType> findAllDefinition()
//    throws OvalException
//    {
//        return _findResource( DefinitionType.class, null );
//    }



    // GET: query
    // test: curl -v -X GET -HAccept:application/xml "http://localhost:8080/six-oval/repository/definitions?platform=Microsoft%20Windows%20XP*,Microsoft%20Windows%207*"
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/repository/definitions"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody QueryResults<DefinitionType> findDefinition(
                    final DefinitionQueryParams params
                    )
    throws OvalException
    {
        return _findResource( DefinitionType.class, params );
    }



    // POST (create)




    //********************************************************************
    // oval-def:test, object, state, variable
    //********************************************************************

    // GET: fetch one by ID
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/repository/tests/{id:.*}"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody TestType findTestById(
                    @PathVariable final String id
                    )
    throws OvalException
    {
        return _findResourceById( TestType.class, id );
    }



    // GET: fetch one by ID
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/repository/objects/{id:.*}"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody SystemObjectType findObjectById(
                    @PathVariable final String id
                    )
    throws OvalException
    {
        return _findResourceById( SystemObjectType.class, id );
    }



    // GET: fetch one by ID
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/repository/states/{id:.*}"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody StateType findStateById(
                    @PathVariable final String id
                    )
    throws OvalException
    {
        return _findResourceById( StateType.class, id );
    }



    // GET: fetch one by ID
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/repository/variables/{id:.*}"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody VariableType findVariableById(
                    @PathVariable final String id
                    )
    throws OvalException
    {
        return _findResourceById( VariableType.class, id );
    }



    //********************************************************************
    // oval-def:oval_definitions
    //********************************************************************

    // GET: fetch one by ID
    // test: curl -v -X GET -HAccept:application/xml "http://localhost:8080/six-oval/repository/oval_definitions/fa54fd0a-2b71-4d6a-a17c-d1f123a74c2b"
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/repository/oval_definitions/{id:.*}"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody OvalDefinitions findOvalDefinitionsById(
                    @PathVariable final String id
                    )
    throws OvalException
    {
        return _findResourceById( OvalDefinitions.class, id );
    }



    // returns the list as Atom feed.
//    // GET (list) oval_definitions
//    //
//    // test: curl -v -X GET -HAccept:application/atom+xml http://localhost:8080/oval_rep/d/oval_definitions
//    @RequestMapping(
//                    method=RequestMethod.GET
//                    ,value="/d/oval_definitions"
//                    ,headers="Accept=application/atom+xml"
//    )
//    public @ResponseBody Feed findOvalDefinitions(
//                    final HttpServletRequest request
//                    )
//    throws OvalException
//    {
//        QueryResults<String>  ids = _findResourceIDs( OvalDefinitions.class );
//        if (ids == null) {
//            _LOG_.debug( "oval_definitions: #ids=0" );
//        } else {
//            _LOG_.debug( "oval_definitions: #ids=" + ids.size() );
//        }
//
//        Feed  feed = FeedHelper.buildAtomFeed(
//                        "oval_definitions",
//                        request.getRequestURL().toString(),
//                        DEFINITIONS_REL,
//                        ids.getResultsElements().getElements()
//                        );
//
//        return feed;
//    }



    // POST (create):
    //
    // test: curl -v -X POST -HContent-Type:application/xml --data-binary @definitions.xml http://localhost:8080/six-oval/repository/oval_definitions
    @RequestMapping(
                    method=RequestMethod.POST
                    ,value="/repository/oval_definitions"
                    ,headers="Content-Type=application/xml"
    )
    public ResponseEntity<Void> createOvalDefinitions(
                    @RequestBody final OvalDefinitions oval_definitions,
                    final HttpServletRequest request
                    )
    throws OvalException
    {
        return _saveResource( request, OvalDefinitions.class, oval_definitions );
    }



    // POST: generate
    //
    // test: curl -v -X POST -HContent-Type:application/xml "http://localhost:8080/six-oval/repository/oval_definitions/generate?searchTerm=win-def:file"
    @RequestMapping(
                    method=RequestMethod.POST
                    ,value="/repository/oval_definitions/generate"
                    ,headers="Content-Type=application/xml"
    )
    public ResponseEntity<Void> generateOvalDefinitions(
                    final DefinitionQueryParams params,
                    final HttpServletRequest request
                    )
    throws OvalException
    {
        String  id = _getGenerator().generateByQuery( params );
        URI  locationUri = _buildResourceLocation( request, String.valueOf( id ) );

        HttpHeaders  headers = new HttpHeaders();
        headers.setLocation( locationUri );
        _LOG_.debug( "HTTP response headers=" + headers );

        return new ResponseEntity<Void>( headers, HttpStatus.CREATED );
    }

}
//

