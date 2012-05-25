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

import javax.servlet.http.HttpServletRequest;
import jp.go.aist.six.oval.OvalException;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.repository.OvalResultsQueryParams;
import jp.go.aist.six.oval.repository.QueryResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
@Controller
public class OvalRepositoryController
    extends OvalDefinitionRepositoryController
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( OvalRepositoryController.class );



    /**
     * Constructor.
     */
    public OvalRepositoryController()
    {
    }



    //////////////////////////////////////////////////////////////////////
    //  REST WS API
    //////////////////////////////////////////////////////////////////////


    //********************************************************************
    // oval-sc:oval_system_characteristics
    //********************************************************************

    // GET: fetch one by ID
    // test: curl -v -X GET -HAccept:application/xml "http://localhost:8080/six-oval/repository/oval_scs/fa54fd0a-2b71-4d6a-a17c-d1f123a74c2b"
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/repository/oval_scs/{id:.*}"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody OvalSystemCharacteristics findOvalSystemCharacteristicsById(
                    @PathVariable final String id
                    )
    throws OvalException
    {
        return _findResourceById( OvalSystemCharacteristics.class, id );
    }




    //********************************************************************
    // oval-sc:oval_results
    //********************************************************************

    // GET: fetch one by ID
    // test: curl -v -X GET -HAccept:application/xml "http://localhost:8080/six-oval/repository/oval_results/fa54fd0a-2b71-4d6a-a17c-d1f123a74c2b"
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/repository/oval_results/{id:.*}"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody OvalResults findOvalResultsById(
                    @PathVariable final String id
                    )
    throws OvalException
    {
        return _findResourceById( OvalResults.class, id );
    }



    // GET: query
    // test: curl -v -X GET -HAccept:application/xml "http://localhost:8080/six-oval/repository/oval_results?definition=oval:org%2emitre%2eoval:def:6210"
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/repository/oval_results"
                    ,headers="Accept=application/xml"
    )
    public @ResponseBody QueryResults<OvalResults> findOvalResults(
                    final OvalResultsQueryParams params
                    )
    throws OvalException
    {
        return _findResource( OvalResults.class, params );
    }



    // POST (create):
    //
    // test: curl -v -X POST -HContent-Type:application/xml --data-binary @results.xml http://localhost:8080/six-oval/repository/oval_results
    @RequestMapping(
                    method=RequestMethod.POST
                    ,value="/repository/oval_results"
                    ,headers="Content-Type=application/xml"
    )
    public ResponseEntity<Void> createOvalResults(
                    @RequestBody final OvalResults oval_results,
                    final HttpServletRequest request
                    )
    throws OvalException
    {
        return _saveResource( request, OvalResults.class, oval_results );
    }




}
//

