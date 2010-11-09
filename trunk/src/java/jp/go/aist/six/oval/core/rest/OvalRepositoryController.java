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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



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
//  public ModelAndView getOvalDefinitions(
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

//        return new ModelAndView( VIEW_OVAL_DEFINITIONS, "object", defs );
        return defs;
    }



    //==============================================================
    // Results
    //==============================================================

}
// OvalRepositoryController

