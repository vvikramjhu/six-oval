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
import jp.go.aist.six.oval.service.OvalServiceException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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


    @ExceptionHandler
    public @ResponseBody String handle(
                    final Exception e
                    )
    {
        return "Exception: " + e.getMessage();
    }
    // TODO:
    // Define OvalRepositoryException, ObjectNotFoundException, ...



    //**************************************************************
    //  OvalRepository
    //**************************************************************

    //==============================================================
    // Definitions
    //==============================================================

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


    // application/xml
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
        OvalDefinitions  defs = null;
        try {
            defs = _store.get( OvalDefinitions.class, id );
        } catch (Exception ex) {
            if (_LOG.isErrorEnabled()) {
                _LOG.error( ex.getMessage() );
            }
            throw new OvalServiceException( ex );
        }

        return defs;
    }



    @RequestMapping(
                    method=RequestMethod.POST,
                    value="/oval_definitions"
    )
    public ResponseEntity<String> createOvalDefinitions(
                    @RequestBody final OvalDefinitions definitions,
                    final HttpServletRequest request
    )
    throws Exception
    {
        String  pid = null;
        try {
             pid = _store.create( OvalDefinitions.class, definitions );
        } catch (Exception ex) {
            if (_LOG.isErrorEnabled()) {
                _LOG.error( ex.getMessage() );
            }
//            throw new OvalServiceException( ex );
        }

        HttpHeaders  headers = new HttpHeaders();
        headers.setLocation( _buildLocation( request, pid ) );

        return new ResponseEntity<String>( "", headers, HttpStatus.CREATED );
    }



    //==============================================================
    // Results
    //==============================================================

    // >curl -X POST -HContent-Type:application/xml
    //  --data-binary @oval\oval-results_CVE-2010-0176_rhsa20100332.xml
    //  http://localhost:8080/six-oval-0.7.0/rest/oval_results
    // <?xml version="1.0" encoding="UTF-8"?>
    // <string xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:oval="http://oval.mitre.org/XMLSchema/oval-common-5"></string>

    @RequestMapping(
                    method=RequestMethod.POST
                    ,value="/oval_results"
    )
    public ResponseEntity<String> addOvalResults(
                    @RequestBody final OvalResults results
                    ,final HttpServletRequest request
    )
    throws Exception
    {
        String  pid = null;
        try {
             pid = _store.create( OvalResults.class, results );
        } catch (Exception ex) {
            if (_LOG.isErrorEnabled()) {
                _LOG.error( ex.getMessage() );
            }
//            throw new OvalServiceException( ex );
        }

        HttpHeaders  headers = new HttpHeaders();
        headers.setLocation( _buildLocation( request, pid ) );

        return new ResponseEntity<String>( "", headers, HttpStatus.CREATED );
    }


}
// OvalRepositoryController

