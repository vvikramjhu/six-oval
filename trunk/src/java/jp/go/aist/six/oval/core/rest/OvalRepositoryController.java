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

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jp.go.aist.six.oval.OvalException;
import jp.go.aist.six.oval.core.store.OvalDataStore;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.util.persist.Persistable;
import jp.go.aist.six.util.search.AndBinding;
import jp.go.aist.six.util.search.Binding;
import jp.go.aist.six.util.search.LikeBinding;
import jp.go.aist.six.util.search.RelationalBinding;
import jp.go.aist.six.util.search.SearchResult;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;



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
    private OvalDataStore  _store;



    /**
     * Constructor.
     */
    public OvalRepositoryController()
    {
    }



    /**
     */
    public void setStore(
                    final OvalDataStore store
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
     *
     */
    private String _getPreDefinedOvalDefinitionsPath(
                    final String definitionClass,
                    final String family,
                    final String platform
                    )
    {
        String  path = "oval-" + definitionClass
        + "_" + family + ".xml";

        return path;
    }



    /**
     * REST GET:
     */
    private <K, T extends Persistable<K>> T _getResource(
                    final Class<T> type,
                    final K id
                    )
    {
        T  object = _store.load( type, id );
                           //throws ObjectRetrievalFailureException

        return object;
    }


    /**
     * REST POST:
     * Create the specified object in the repository and
     * returns the HTTP response.
     */
    private <K, T extends Persistable<K>> ResponseEntity<Void> _createResource(
                    final HttpServletRequest request,
                    final Class<T> type,
                    final T object
    )
    {
        K  pid = _store.create( type, object );
                        //throws DataAccessException

        HttpHeaders  headers = new HttpHeaders();
        headers.setLocation( _buildLocation( request, String.valueOf( pid ) ) );
        headers.setContentType( MediaType.APPLICATION_XML );

        return new ResponseEntity<Void>( headers, HttpStatus.CREATED );
    }



//    // text/html
//    @RequestMapping(
//                    method=RequestMethod.GET
//                    ,value="/oval_defs/{id}"
//    )
//    public ModelAndView getOvalDefinitionsModelAndView(
//                    @PathVariable final String id
//                    )
//    throws OvalServiceException
//    {
//        OvalDefinitions  defs = null;
//        try {
//            defs = _store.get( OvalDefinitions.class, id );
//        } catch (Exception ex) {
//            if (_LOG.isErrorEnabled()) {
//                _LOG.error( ex.getMessage() );
//            }
//            throw new OvalServiceException( ex );
//        }
//
//        return new ModelAndView( VIEW_OVAL_DEFINITIONS, "oval_definitions", defs );
//    }



    private Binding _buildFilter(
                    final Map<String, String> params
                    )
    {
        Binding  filter = null;

        if (params.size() == 0) {
            // empty filter
        } else if (params.size() == 1) {
            String  key = params.keySet().iterator().next();
            filter = _buildFilter( key, params.get( key ) );
        } else {
            AndBinding  binding = new AndBinding();
            for (String  key : params.keySet()) {
                binding.addElement( _buildFilter( key, params.get( key ) ) );
            }
            filter = binding;
        }

        return filter;
    }


    private Binding _buildFilter(
                    final String key,
                    final String value
                    )
    {
        if (key == null  ||  value == null) {
            throw new IllegalArgumentException( "invalid query param" );
        }

        return (value.contains( "%" )
                        ? (new LikeBinding( key, value ))
                        : RelationalBinding.equalBinding( key, value )
                        );
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
    @ExceptionHandler( DataAccessException.class )
    @ResponseStatus( HttpStatus.INTERNAL_SERVER_ERROR )
    public void handleInternalServerError(
                    final DataAccessException ex
                    )
    {
        _handleException( ex );
    }


    private void _handleException(
                    final Exception ex
                    )
    {
//        Throwable  rootCause = null;
//        if (ex instanceof NestedRuntimeException) {
//            rootCause = NestedRuntimeException.class.cast( ex ).getRootCause();
//        }

        if (_LOG.isErrorEnabled()) {
            _LOG.error( "handle exception: " + ex.getClass().getName()
                            + " --- " + ex.getMessage() );
        }
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
    throws OvalException
    {
        return _getResource( OvalDefinitions.class, id );
    }



    /**
     * Returns the latest definitions for the specified class, family, and platform.
     */
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/oval_definitions/{definitionClass}/{family}/{platform}"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody void getOvalDefinitions(
                    @PathVariable final String definitionClass,
                    @PathVariable final String family,
                    @PathVariable final String platform,
                    final HttpServletResponse response
                    )
    throws OvalException
    {
        String  filepath = _getPreDefinedOvalDefinitionsPath( definitionClass, family, platform );
        File  file = new File( filepath );
        try {
            OutputStream  outstream = response.getOutputStream();
            XmlFile.read( file, outstream );
        } catch (IOException ex) {
            throw new OvalException( ex );
        }
    }



    @RequestMapping(
                    method=RequestMethod.POST,
                    value="/oval_definitions"
    )
    public ResponseEntity<Void> createOvalDefinitions(
                    @RequestBody final OvalDefinitions definitions,
                    final HttpServletRequest request
    )
    throws OvalException
    {
        return _createResource( request, OvalDefinitions.class, definitions );
    }



    @RequestMapping(
                    method=RequestMethod.GET,
                    value="/definition",
                    headers="Accept=application/xml"
    )
    public @ResponseBody SearchResult<Definition> findDefinitionByCve(
                    @RequestParam final Map<String, String> params
                    )
    throws OvalException
    {
        _LOG.debug( "request params=" + params );

        Binding  filter = _buildFilter( params );
        Collection<Definition>  defs = _store.find(
                        Definition.class,
                        filter
                        );

        SearchResult<Definition>  result = new SearchResult<Definition>( new Date(), defs );

        return result;
    }


//    @RequestMapping(
//                    method=RequestMethod.GET,
//                    value="/definition",
//                    params="cve",
//                    headers="Accept=application/xml"
//    )
//    public @ResponseBody SearchResult<Definition> findDefinitionByCve(
//                    @RequestParam final String cve
//                    )
//    throws OvalException
//    {
//        List<Definition>  list = _store.find(
//                        Definition.class,
//                        RelationalBinding.equalBinding( "metadata.reference.refID", cve )
////                        RelationalBinding.equalBinding( "relatedCve.name", cve )
//                        );
//
//        SearchResult<Definition>  result = new SearchResult<Definition>( new Date(), list );
//
//        return result;
//    }



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
    throws OvalException
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
    throws OvalException
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
    throws OvalException
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
    throws OvalException
    {
        return _createResource( request, OvalResults.class, results );
    }

}
// OvalRepositoryController

