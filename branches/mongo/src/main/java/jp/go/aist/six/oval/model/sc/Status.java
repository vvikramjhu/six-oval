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

package jp.go.aist.six.oval.model.sc;

import java.io.Serializable;
import java.util.HashMap;



/**
 * The Status enumeration defines the valid status messages
 * associated with collection of specific information associated with an item.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class Status
    implements Serializable
{

    private static final String  _ERROR_           = "error";
    private static final String  _EXISTS_          = "exists";
    private static final String  _DOES_NOT_EXIST_  = "does not exist";
    private static final String  _NOT_COLLECTED_   = "not collected";


    public static final Status  ERROR          = new Status( _ERROR_ );
    public static final Status  EXISTS         = new Status( _EXISTS_ );
    public static final Status  DOES_NOT_EXIST = new Status( _DOES_NOT_EXIST_ );
    public static final Status  NOT_COLLECTED  = new Status( _NOT_COLLECTED_ );


    private static HashMap<String, Status> _INIT_()
    {
        HashMap<String, Status>  map = new HashMap<String, Status>();
        map.put( _ERROR_,           ERROR          );
        map.put( _EXISTS_,          EXISTS         );
        map.put( _DOES_NOT_EXIST_,  DOES_NOT_EXIST );
        map.put( _NOT_COLLECTED_,   NOT_COLLECTED  );
        return map;
    }

    private static final HashMap<String, Status>  _INSTANCES_ = _INIT_();




    /**
     */
    public static Status valueOf(
                    final String name
                    )
    {
        Status  status = null;
        if (name != null) {
            status = _INSTANCES_.get( name );
        }

        if (status == null) {
            throw new IllegalArgumentException( "invalid item status: " + name );
        }

        return status;
    }



    private String  _name = null;



    /**
     */
    private Status(
                    final String name
                    )
    {
        _name = name;
    }



    /**
     */
    public String getName()
    {
        return _name;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return getName();
    }

}
// Status

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

