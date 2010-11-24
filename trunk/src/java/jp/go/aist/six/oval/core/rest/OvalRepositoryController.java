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

import jp.go.aist.six.oval.core.store.OvalStore;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.service.OvalServiceException;
import jp.go.aist.six.util.orm.Persistable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriTemplate;
import java.net.URI;
import javax.servlet.http.HttpServletRequest;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
@Controller
public class OvalRepositoryController
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( OvalRepositoryController.class );



    public static final String  VIEW_OVAL_DEFINITIONS = "oval_definitions";




    /**
     * The data store sole instance.
     */
    private OvalStore  _store;



    /**
     * Constructor.
     */
    public OvalRepositoryController()
    {
    }



    /**
     */
    public void setStore(
                    final OvalStore store
                    )
    {
        _store = store;
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

        if (_LOG.isDebugEnabled()) {
            _LOG.debug( "Location: " + uri.toASCIIString() );
        }
        return uri;
    }



    /**
     * REST GET resource.
     */
    private <K, T extends Persistable<K>> T _getResource(
                    final Class<T> type,
                    final K id
                    )
    throws OvalServiceException
    {
        T  object = null;
        try {
            object = _store.get( type, id );
        } catch (ObjectRetrievalFailureException ex) {
            throw ex;
//            throw new OvalServiceException( ex );
        }

        return object;
    }


    /**
     * Create the specified object in the repository and
     * returns the HTTP response.
     */
    private <K, T extends Persistable<K>> ResponseEntity<Void> _createResource(
                    final HttpServletRequest request,
                    final Class<T> type,
                    final T object
    )
    throws OvalServiceException
    {
        K  pid = null;
        try {
             pid = _store.create( type, object );
        } catch (DataAccessException ex) {
            throw ex;
//            if (_LOG.isErrorEnabled()) {
//                _LOG.error( ex.getMessage() );
//            }
//            throw new OvalServiceException( ex );
        }

        HttpHeaders  headers = new HttpHeaders();
        headers.setLocation( _buildLocation( request, String.valueOf( pid ) ) );
        headers.setContentType( MediaType.APPLICATION_XML );

        return new ResponseEntity<Void>( headers, HttpStatus.CREATED );
    }



    //==============================================================
    // Exception Handlers
    //==============================================================

    @ExceptionHandler( ObjectRetrievalFailureException.class )
    @ResponseStatus( HttpStatus.NOT_FOUND )
    public void handleNotFound(
                    final ObjectRetrievalFailureException ex
                    )
    {
        if (_LOG.isErrorEnabled()) {
            _LOG.error( "handle exception: " + ex.getClass().getName()
                            + ": " + ex.getMessage() );
        }
    }


    @ExceptionHandler( DataAccessException.class )
    @ResponseStatus( HttpStatus.INTERNAL_SERVER_ERROR )
    public void handleInternalServerError(
                    final DataAccessException ex
                    )
    {
        if (_LOG.isErrorEnabled()) {
            _LOG.error( "handle exception: " + ex.getClass().getName()
                            + ": " + ex.getMessage() );
        }
    }



//    @ExceptionHandler(CastorObjectRetrievalFailureException.class)
//    @ResponseStatus( HttpStatus.NOT_FOUND )
//    public void handleNotFound(
//                    final CastorObjectRetrievalFailureException ex
//                    )
//    {
//        if (_LOG.isErrorEnabled()) {
//            _LOG.error( "handle exception: " + ex.getClass().getName() );
//        }
////        return ClassUtils.getShortName( ex.getClass() );
//    }

//    @ExceptionHandler
//    public @ResponseBody RestStatus handleException(
//                    final Exception e
//                    )
//    {
//        if (_LOG.isErrorEnabled()) {
//            _LOG.error( "handle exception: " + e.getClass().getName()
//                            + ", " + e.getMessage() );
//        }
//        return new RestStatus( e.getMessage() );
//    }
//    public @ResponseBody Exception handleException(
//                    final Exception e
//                    )
//    {
//        if (_LOG.isErrorEnabled()) {
//            _LOG.error( "handle exception: " + e.getClass().getName() );
//        }
//        return e;
//    }
//    public @ResponseBody OvalServiceException handleException(
//                    final Exception e
//                    )
//    {
//        if (_LOG.isErrorEnabled()) {
//            _LOG.error( "handle exception: " + e.getClass().getName() );
//        }
//
//        if (e instanceof OvalServiceException) {
//            return OvalServiceException.class.cast( e );
//        }
//        return new OvalServiceException( e );
//    }
    // TODO:
    // Define OvalRepositoryException, ObjectNotFoundException, ...???



    // text/html
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/oval_defs/{id}"
    )
    public ModelAndView getOvalDefinitionsModelAndView(
                    @PathVariable final String id
                    )
    {
        OvalDefinitions  defs = null;
        try {
            defs = _store.get( OvalDefinitions.class, id );
        } catch (Exception ex) {
            if (_LOG.isErrorEnabled()) {
                _LOG.error( ex.getMessage() );
            }
//            throw new OvalServiceException( ex );
        }

        return new ModelAndView( VIEW_OVAL_DEFINITIONS, "oval_definitions", defs );
    }



    //**************************************************************
    //  OvalRepository
    //**************************************************************

    //==============================================================
    // Definitions
    //==============================================================

    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/oval_definitions/{id}"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody OvalDefinitions getOvalDefinitions(
                    @PathVariable final String id
                    )
    throws OvalServiceException
    {
        return _getResource( OvalDefinitions.class, id );
    }



    @RequestMapping(
                    method=RequestMethod.POST,
                    value="/oval_definitions"
    )
    public ResponseEntity<Void> createOvalDefinitions(
                    @RequestBody final OvalDefinitions definitions,
                    final HttpServletRequest request
    )
    throws OvalServiceException
    {
        return _createResource( request, OvalDefinitions.class, definitions );
    }



    //==============================================================
    // System Characteristics
    //==============================================================

    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/oval_sc/{id}"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody OvalSystemCharacteristics getOvalSystemCharacteristics(
                    @PathVariable final String id
                    )
    throws OvalServiceException
    {
        return _getResource( OvalSystemCharacteristics.class, id );
    }



    @RequestMapping(
                    method=RequestMethod.POST,
                    value="/oval_sc"
    )
    public ResponseEntity<Void> createOvalSystemCharacteristics(
                    @RequestBody final OvalSystemCharacteristics sc,
                    final HttpServletRequest request
    )
    throws OvalServiceException
    {
        return _createResource( request, OvalSystemCharacteristics.class, sc );
    }



    //==============================================================
    // Results
    //==============================================================

    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/oval_results/{id}"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody OvalResults getOvalResults(
                    @PathVariable final String id
                    )
    throws OvalServiceException
    {
        return _getResource( OvalResults.class, id );
    }



    // >curl -X POST -HContent-Type:application/xml
    //  --data-binary @oval\oval-results_CVE-2010-0176_rhsa20100332.xml
    //  http://localhost:8080/six-oval-0.7.0/rest/oval_results
    // <?xml version="1.0" encoding="UTF-8"?>
    // <string xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:oval="http://oval.mitre.org/XMLSchema/oval-common-5"></string>

    @RequestMapping(
                    method=RequestMethod.POST
                    ,value="/oval_results"
    )
    public ResponseEntity<Void> createOvalResults(
                    @RequestBody final OvalResults results
                    ,final HttpServletRequest request
    )
    throws OvalServiceException
    {
        return _createResource( request, OvalResults.class, results );
    }

}
// OvalRepositoryController

