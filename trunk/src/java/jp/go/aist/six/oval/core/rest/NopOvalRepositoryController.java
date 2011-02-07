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

import java.net.URI;
import javax.servlet.http.HttpServletRequest;
import jp.go.aist.six.oval.OvalException;
import jp.go.aist.six.oval.core.process.OvalInterpreter;
import jp.go.aist.six.oval.core.store.OvalDataStore;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.util.persist.Persistable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
@Controller
public class NopOvalRepositoryController
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( OvalInterpreter.class );



    /**
     * Constructor.
     */
    public NopOvalRepositoryController()
    {
    }



    /**
     */
    public void setStore(
                    final OvalDataStore store
                    )
    {
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
        _LOG_.info( "request: " + String.valueOf( request ) );
        _LOG_.info( "type: " + type.getName() );
        _LOG_.info( "object: " + String.valueOf( object ) );

        HttpHeaders  headers = new HttpHeaders();
        try {
            headers.setLocation( new URI( "http://nop.jp/oval/results" ) );
        } catch (Exception ex) {
        }

        headers.setContentType( MediaType.APPLICATION_XML );

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

        _LOG_.error( "handle exception: " + ex.getClass().getName()
                            + " --- " + ex.getMessage() );
    }



    //**************************************************************
    //  OvalRepository
    //**************************************************************

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
                    ,value="/results"
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
// NopOvalRepositoryController

