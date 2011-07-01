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
import jp.go.aist.six.oval.core.datastore.mongodb.MongoDatastore;
import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;
import jp.go.aist.six.oval.model.v5.definitions.DefinitionsType;
import jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.v5.results.OvalResults;
import jp.go.aist.six.oval.model.v5.results.ResultsType;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;
import com.google.code.morphia.Key;
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
    public static final String  RESULTS_REL     = "http://aist.go.jp/six/oval/rels/oval_results";



    /**
     * The data store sole instance.
     */
    private MongoDatastore  _datastore;


    private MongoOvalService  _service;




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

        _service = new MongoOvalService();
        _service.setDatastore( _datastore );
    }



    /**
     * Builds a location URI from the specified request URL
     * and the created object ID.
     */
    private URI _buildLocation(
                    final HttpServletRequest request,
                    final String id
                    )
    {
        String  requestUrl = request.getRequestURL().toString();
        URI  uri = new UriTemplate( "{requestUrl}/{id}" ).expand( requestUrl, id );

        if (_LOG_.isDebugEnabled()) {
            _LOG_.debug( "Location: " + uri.toASCIIString() );
        }
        return uri;
    }


    /**
     * Find the OVAL resource.
     */
    private <K, T extends Persistable<K>>
    T _getResource(
                    final Class<T> type,
                    final K id
                    )
    throws OvalException
    {
        _LOG_.debug( "type=" + type + ", id=" + id );

        T  resource = _service.getObject( type, id );

//        HttpHeaders  headers = new HttpHeaders();
//        _LOG_.debug( "HTTP response headers=" + headers );

        return resource;
    }



    /**
     * Creates an OVAL resource.
     */
    private <K, T extends Persistable<K>>
    ResponseEntity<Void> _createResource(
                    final HttpServletRequest request,
                    final Class<T> type,
                    final T object
                    )
    throws OvalException
    {
        K  id = _service.createObject( type, object );

        HttpHeaders  headers = new HttpHeaders();
        headers.setLocation( _buildLocation( request, String.valueOf( id ) ) );
//        headers.setLocation( _buildLocation( request, "test" ) );
//        headers.setContentType( MediaType.APPLICATION_XML );

        _LOG_.debug( "HTTP response headers=" + headers );

        return new ResponseEntity<Void>( headers, HttpStatus.CREATED );
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



    //==============================================================
    // /build_oval_definitions
    //==============================================================



    //==============================================================
    // /oval_definitions
    //==============================================================

    // POST (create) oval_definitions
    @RequestMapping(
                    method=RequestMethod.POST
                    ,value="/oval_definitions"
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



    // GET (read) oval_definitions
    //
    // test: curl -v -X GET -HAccept:application/atom+xml http://localhost:8080/oval_repo/oval_definitions
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/oval_definitions"
                    ,headers="Accept=application/atom+xml"
    )
    public @ResponseBody Feed getOvalDefinitions(
                    final HttpServletRequest request
                    )
    throws OvalException
    {
        List<Key<OvalDefinitions>>  ids = _service.getObjectIDs( OvalDefinitions.class );
        if (ids == null) {
            _LOG_.debug( "oval_definitions: #ids=0" );
        } else {
            _LOG_.debug( "oval_definitions: #ids=" + ids.size() );
        }

        Feed  feed = FeedHelper.buildAtomFeed(
                        "oval_definitions",
                        request.getRequestURL().toString(),
                        DEFINITIONS_REL,
                        ids
                        );

        return feed;
    }



    // GET (read) oval_definitions
    //
    // test: curl -v -X GET -HAccept:application/xml
    //   http://localhost:8080/oval_repo/oval_definitions/{id}
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/oval_definitions/{id}"
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
    // /oval_definitions/definitions
    //==============================================================

    // about path variables including ".",
    // @see http://forum.springsource.org/showthread.php?78085-Problems-with-RequestMapping&p=263563
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/oval_definitions/definitions/{id:.*}"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody DefinitionType getDefinition(
                    @PathVariable final String id
                    )
    throws OvalException
    {
        return _getResource( DefinitionType.class, id );
    }



    // GET (query) /oval_definitions/definitions
    //
    // test: curl -v -X GET -HAccept:application/xml
    //   http://localhost:8080/oval_repo/oval_definitions/definitions?platform=Debian%20GNU%2fLinux%205%2e0
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/oval_definitions/definitions"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody DefinitionsType findDefinition(
                    final DefinitionsQueryParams params
                    )
    throws OvalException
    {
        return _service.findDefinitions( params );
    }




//    /**
//     */
//    @RequestMapping(
//                    method=RequestMethod.GET
//                    ,value="/oval_definitions"
//                    ,headers="Accept=application/xml"
//    )
//    public @ResponseBody OvalDefinitions getOvalDefinitions(
//                    @RequestParam final Map<String, String> params
//                    )
//    throws OvalException
//    {
//        return null;
//    }



//    @RequestMapping(
//                    method=RequestMethod.POST,
//                    value="/oval_definitions"
//    )
//    public ResponseEntity<Void> createOvalDefinitions(
//                    @RequestBody final OvalDefinitions definitions,
//                    final HttpServletRequest request
//    )
//    throws OvalException
//    {
//        return _createResource( request, OvalDefinitions.class, definitions );
//    }



//    @RequestMapping(
//                    method=RequestMethod.GET,
//                    value="/definition",
//                    headers="Accept=application/xml"
//    )
//    public @ResponseBody SearchResult<Definition> findDefinitionByCve(
//                    @RequestParam final Map<String, String> params
//                    )
//    throws OvalException
//    {
//        _LOG.debug( "request params=" + params );
//
//        Binding  filter = _buildFilter( params );
//        Collection<Definition>  defs = _store.find(
//                        Definition.class,
//                        filter
//                        );
//
//        SearchResult<Definition>  result = new SearchResult<Definition>( new Date(), defs );
//
//        return result;
//    }





//    //==============================================================
//    // System Characteristics
//    //==============================================================
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
    // Results
    //==============================================================

//    @RequestMapping(
//                    method=RequestMethod.GET
//                    ,value="/oval_results/{id}"
//                    ,headers="Accept=application/xml"
//    )
//    public @ResponseBody OvalResults getOvalResults(
//                    @PathVariable final String id
//                    )
//    throws OvalException
//    {
//        return _getResource( OvalResults.class, id );
//    }



    // Example:
    // >curl -v -X POST -HContent-Type:application/xml
    //  --data-binary @oval-results.xml
    //  http://localhost:8080/oval_repo/oval_results

    @RequestMapping(
                    method=RequestMethod.POST
                    ,value="/oval_results"
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



    // GET oval_results by ID
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/oval_results/{id}"
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
                    ,value="/oval_results/results"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody ResultsType getResults(
                    @RequestParam final String primary_host_name
                    )
    throws OvalException
    {
        return _service.findResults( primary_host_name );
    }

}
// OvalController

