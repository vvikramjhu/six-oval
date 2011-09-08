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
import javax.servlet.http.HttpServletRequest;
import jp.go.aist.six.oval.OvalException;
import jp.go.aist.six.oval.core.repository.mongodb.MongoDatastore;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalRepository;
import jp.go.aist.six.oval.core.repository.mongodb.QueryBuilder;
import jp.go.aist.six.oval.model.OvalObject;
import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;
import jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.v5.definitions.StateType;
import jp.go.aist.six.oval.model.v5.definitions.SystemObjectType;
import jp.go.aist.six.oval.model.v5.definitions.TestType;
import jp.go.aist.six.oval.model.v5.definitions.VariableType;
import jp.go.aist.six.oval.model.v5.results.OvalResults;
import jp.go.aist.six.oval.model.v5.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.repository.QueryResult;
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
import com.sun.syndication.feed.atom.Feed;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
@Controller
public class OvalController
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( OvalController.class );


    public static final String  DEFINITIONS_REL = "http://aist.go.jp/six/oval/rels/oval_definitions";
    public static final String  DEFINITION_REL  = "http://aist.go.jp/six/oval/rels/d/definition";
    public static final String  TEST_REL        = "http://aist.go.jp/six/oval/rels/d/test";
    public static final String  SC_REL          = "http://aist.go.jp/six/oval/rels/oval_system_characteristics";
    public static final String  RESULTS_REL     = "http://aist.go.jp/six/oval/rels/oval_results";


    // " " space = %20
    // "/" slash = %2f
    // "." dot   = %2e
    // "&" ampa  = %26


    /**
     * The data store sole instance.
     */
    private MongoDatastore  _datastore;


//    private MongoOvalService  _service;

    private MongoOvalRepository  _repository;



    /**
     * Constructor.
     */
    public OvalController()
    {
    }



    /**
     */
    public void setDatastore(
                    final MongoDatastore datastore
                    )
    {
        _datastore = datastore;

//        _service = new MongoOvalService();
//        _service.setDatastore( _datastore );

        _repository = new MongoOvalRepository();
        _repository.setDatastore( _datastore );
    }



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
     * Gets the resource.
     */
    private <K, T extends OvalObject & Persistable<K>>
    T _getResource(
                    final Class<T> type,
                    final K id
                    )
    throws OvalException
    {
        _LOG_.debug( "GET: type=" + type + ", id=" + id );

        T  resource = _repository.get( type, id );
//        T  resource = _service.getObject( type, id );

        return resource;
    }



    /**
     * Creates an OVAL resource.
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

        K  id = _repository.create( type, object );
//        K  id = _service.createObject( type, object );

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
    QueryResult<T> _findResource(
                    final Class<T> type,
                    final QueryParams params
                    )
    throws OvalException
    {
        _LOG_.debug( "GET (find): type=" + type + ", params=" + params );

        QueryBuilder  builder = MongoWebQueryBuilder.createInstance( type, params );
        QueryResult<T>  result = _repository.find( type, builder );
        return result;
    }



    /**
     * Retrieves the resources.
     */
    public <K, T extends OvalObject & Persistable<K>>
    QueryResult<K> _findResourceIDs(
                    final Class<T> type
                    )
    throws OvalException
    {
        _LOG_.debug( "GET (find): type=" + type );

        QueryResult<K>  result = _repository.findIDs( type );
        return result;
    }


    public <K, T extends OvalObject & Persistable<K>>
    QueryResult<K> _findResourceIDs(
                    final Class<T> type,
                    final QueryParams params
                    )
    throws OvalException
    {
        _LOG_.debug( "GET (find): type=" + type + ", params=" + params );

        QueryBuilder  builder = MongoWebQueryBuilder.createInstance( type, params );
        QueryResult<K>  result = _repository.findIDs( type, builder );
        return result;
    }



    //==============================================================
    // Exception Handlers, HTTP Status Code
    //==============================================================

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



    //**************************************************************
    //  REST WS API
    //**************************************************************

    //==============================================================
    // /build_oval_definitions
    //==============================================================



    //==============================================================
    // /d/oval_definitions
    //==============================================================

    // POST (create) oval_definitions
    //
    // test: curl -v -X POST -HContent-Type:application/xml --data-binary @definitions.xml http://localhost:8080/oval_rep/d/oval_definitions
    @RequestMapping(
                    method=RequestMethod.POST
                    ,value="/d/oval_definitions"
                    ,headers="Content-Type=application/xml"
    )
    public ResponseEntity<Void> createOvalDefinitions(
                    @RequestBody final OvalDefinitions oval_definitions,
                    final HttpServletRequest request
    )
    throws OvalException
    {
        return _createResource( request, OvalDefinitions.class, oval_definitions );
    }



    // GET (list) oval_definitions
    //
    // test: curl -v -X GET -HAccept:application/atom+xml http://localhost:8080/oval_rep/d/oval_definitions
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/d/oval_definitions"
                    ,headers="Accept=application/atom+xml"
    )
    public @ResponseBody Feed findOvalDefinitions(
                    final HttpServletRequest request
                    )
    throws OvalException
    {
        QueryResult<String>  ids = _findResourceIDs( OvalDefinitions.class );
//        Collection<String>  ids = _service.getObjectIDs( OvalDefinitions.class );
////        List<Key<OvalDefinitions>>  ids = _service.getObjectIDs( OvalDefinitions.class );
        if (ids == null) {
            _LOG_.debug( "oval_definitions: #ids=0" );
        } else {
            _LOG_.debug( "oval_definitions: #ids=" + ids.size() );
        }

        Feed  feed = FeedHelper.buildAtomFeed(
                        "oval_definitions",
                        request.getRequestURL().toString(),
                        DEFINITIONS_REL,
                        ids.getElements().getElements()
                        );

        return feed;
    }



    //==============================================================
    // /d/oval_definitions/{id}
    //==============================================================

    // GET (read) oval_definitions
    //
    // test: curl -v -X GET -HAccept:application/xml
    //   http://localhost:8080/oval_rep/d/oval_definitions/{id}
    // test: curl -v -X GET -HAccept:application/xml "http://localhost:8080/oval_rep/d/oval_definitions/60a24882-7f30-40d8-a77e-9f61b8c2bd48"
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/d/oval_definitions/{id}"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody OvalDefinitions getOvalDefinitions(
                    @PathVariable final String id
                    )
    throws OvalException
    {
        return _getResource( OvalDefinitions.class, id );
    }



    //==============================================================
    // /d/definitions
    //==============================================================

    // POST (create) --- NOT supported.


    // GET (query)
    // test: curl -v -X GET -HAccept:application/xml "http://localhost:8080/oval_rep/d/definitions?platform=Debian%20GNU%2fLinux%205%2e0&limit=1"
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/d/definitions"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody QueryResult<DefinitionType> findDefinitions(
                    final DefinitionsQueryParams params
                    )
    throws OvalException
    {
        return _findResource( DefinitionType.class, params );
    }



    // GET (list) definition
    //
    // test: curl -v -X GET -HAccept:application/atom+xml http://localhost:8080/oval_rep/d/definitions
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/d/definitions"
                    ,headers="Accept=application/atom+xml"
    )
    public @ResponseBody Feed findDefinitionIDs(
                    final HttpServletRequest request
                    )
    throws OvalException
    {
        QueryResult<String>  ids = _findResourceIDs( DefinitionType.class );
        if (ids == null) {
            _LOG_.debug( "definitions: #ids=0" );
        } else {
            _LOG_.debug( "definitions: #ids=" + ids.size() );
        }

        Feed  feed = FeedHelper.buildAtomFeed(
                        "OVAL Definitions",
                        request.getRequestURL().toString(),
                        DEFINITION_REL,
                        ids.getElements().getElements()
                        );

        return feed;
    }




    //==============================================================
    // /d/definitions/{id}
    //==============================================================

    // POST (create) definition --- error.


    // GET /d/definitions/{id}
    //
    // NOTE: OVAL IDs contain "." (dot) characters.
    //       The character has special meaning for the Spring framework.
    // about path variables including ".":
    // @see http://forum.springsource.org/showthread.php?78085-Problems-with-RequestMapping&p=263563
    // test: curl -v -X GET -HAccept:application/xml "http://localhost:8080/oval_rep/d/definitions/oval:org%2emitre%2eoval:def:7222"
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/d/definitions/{id:.*}"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody DefinitionType getDefinition(
                    @PathVariable final String id
                    )
    throws OvalException
    {
        return _getResource( DefinitionType.class, id );
    }



    //==============================================================
    // /d/tests/{id}
    //==============================================================

    // GET (query)
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/d/tests"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody QueryResult<TestType> findTests(
                    final TestQueryParams params
                    )
    throws OvalException
    {
        return _findResource( TestType.class, params );
    }



    // GET (list)
    //
    // test: curl -v -X GET -HAccept:application/atom+xml http://localhost:8080/oval_rep/d/tests
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/d/tests"
                    ,headers="Accept=application/atom+xml"
    )
    public @ResponseBody Feed findTestIDs(
                    final HttpServletRequest request,
                    final TestQueryParams params
                    )
    throws OvalException
    {
        QueryResult<String>  ids = _findResourceIDs( TestType.class, params );
        if (ids == null) {
            _LOG_.debug( "tests: #ids=0" );
        } else {
            _LOG_.debug( "tests: #ids=" + ids.size() );
        }

        Feed  feed = FeedHelper.buildAtomFeed(
                        "OVAL Tests",
                        request.getRequestURL().toString(),
                        TEST_REL,
                        ids.getElements().getElements()
                        );

        return feed;
    }




    // GET
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/d/tests/{id:.*}"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody TestType getTest(
                    @PathVariable final String id
                    )
    throws OvalException
    {
        return _getResource( TestType.class, id );
    }



    //==============================================================
    // /d/objects/{id}
    //==============================================================

    // GET
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/d/objects/{id:.*}"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody SystemObjectType getObject(
                    @PathVariable final String id
                    )
    throws OvalException
    {
        return _getResource( SystemObjectType.class, id );
    }



    //==============================================================
    // /d/states/{id}
    //==============================================================

    // GET
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/d/states/{id:.*}"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody StateType getState(
                    @PathVariable final String id
                    )
    throws OvalException
    {
        return _getResource( StateType.class, id );
    }



    //==============================================================
    // /d/variables/{id}
    //==============================================================

    // GET
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/d/variables/{id:.*}"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody VariableType getVariable(
                    @PathVariable final String id
                    )
    throws OvalException
    {
        return _getResource( VariableType.class, id );
    }



    //==============================================================
    // System Characteristics
    //==============================================================

    // GET (list) oval_system_characteristics
    //
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/s/oval_system_characteristics"
                    ,headers="Accept=application/atom+xml"
    )
    public @ResponseBody Feed findOvalSystemCharacteristics(
                    final OvalSystemCharacteristicsQueryParams params,
                    final HttpServletRequest request
                    )
    throws OvalException
    {
        QueryResult<String>  ids = _findResourceIDs( OvalSystemCharacteristics.class, params );
//        Collection<String>  ids = _service.findOvalSystemCharacteristics( params );
////        List<Key<OvalSystemCharacteristics>>  ids = _service.findOvalSystemCharacteristics( params );
        if (ids == null) {
            _LOG_.debug( "oval_sc: #ids=0" );
        } else {
            _LOG_.debug( "oval_sc: #ids=" + ids.size() );
        }

        Feed  feed = FeedHelper.buildAtomFeed(
                        "oval_system_characteristics",
                        request.getRequestURL().toString(),
                        SC_REL,
                        ids.getElements().getElements()
                        );

        return feed;
    }



//
//    @RequestMapping(
//                    method=RequestMethod.GET
//                    ,value="/oval_sc/{id}"
//                    ,headers="Accept=application/xml"
//    )
//    public @ResponseBody OvalSystemCharacteristics getOvalSystemCharacteristics(
//                    @PathVariable final String id
//                    )
//    throws OvalException
//    {
//        return _getResource( OvalSystemCharacteristics.class, id );
//    }
//
//
//
//    @RequestMapping(
//                    method=RequestMethod.POST,
//                    value="/oval_sc"
//    )
//    public ResponseEntity<Void> createOvalSystemCharacteristics(
//                    @RequestBody final OvalSystemCharacteristics sc,
//                    final HttpServletRequest request
//    )
//    throws OvalException
//    {
//        return _createResource( request, OvalSystemCharacteristics.class, sc );
//    }



    //==============================================================
    // /r/oval_results
    //==============================================================

    // POST /oval_results
    //
    // Example:
    // >curl -v -X POST -HContent-Type:application/xml
    //  --data-binary @oval-results.xml
    //  http://localhost:8080/oval_repo/oval_results
    @RequestMapping(
                    method=RequestMethod.POST
                    ,value="/r/oval_results"
                    ,headers="Content-Type=application/xml"
    )
    public ResponseEntity<Void> createOvalResults(
                    @RequestBody final OvalResults ovalResults,
                    final HttpServletRequest request
    )
    throws OvalException
    {
        return _createResource( request, OvalResults.class, ovalResults );
    }



    // GET (list) /oval_results
    //
    // test: curl -v -X GET -HAccept:application/atom+xml http://localhost:8080/oval_repo/oval_results
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/r/oval_results"
                    ,headers="Accept=application/atom+xml"
    )
    public @ResponseBody Feed findOvalResults(
                    final HttpServletRequest request
                    )
    throws OvalException
    {
        QueryResult<String>  ids = _findResourceIDs( OvalResults.class );
//        Collection<String>  ids = _service.getObjectIDs( OvalResults.class );
////        List<Key<OvalResults>>  ids = _service.getObjectIDs( OvalResults.class );
        if (ids == null) {
            _LOG_.debug( "oval_results: #ids=0" );
        } else {
            _LOG_.debug( "oval_results: #ids=" + ids.size() );
        }

        Feed  feed = FeedHelper.buildAtomFeed(
                        "oval_results",
                        request.getRequestURL().toString(),
                        RESULTS_REL,
                        ids.getElements().getElements()
                        );

        return feed;
    }




    //==============================================================
    // /oval_results/{id}
    //==============================================================

    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/r/oval_results/{id}"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody OvalResults getOvalResults(
                    @PathVariable final String id
                    )
    throws OvalException
    {
        return _getResource( OvalResults.class, id );
    }



    // curl -v -o query_primary_host_name.xml -X GET -HAccept:application/xml
    //   http://localhost:8080/oval_repo/oval_results/results?primary_host_name=host1
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/r/oval_results/results"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody QueryResult<OvalResults> getResults(
                    final ResultsQueryParams params
                    )
    throws OvalException
    {
        return _findResource( OvalResults.class, params );
    }

}
// OvalController

