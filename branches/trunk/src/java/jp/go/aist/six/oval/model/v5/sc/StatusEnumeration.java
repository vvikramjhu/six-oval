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

package jp.go.aist.six.oval.model.v5.sc;

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
public final class StatusEnumeration
    implements Serializable
{

    private static final String  _ERROR_           = "error";
    private static final String  _EXISTS_          = "exists";
    private static final String  _DOES_NOT_EXIST_  = "does not exist";
    private static final String  _NOT_COLLECTED_   = "not collected";


    public static final StatusEnumeration  ERROR          = new StatusEnumeration( _ERROR_ );
    public static final StatusEnumeration  EXISTS         = new StatusEnumeration( _EXISTS_ );
    public static final StatusEnumeration  DOES_NOT_EXIST = new StatusEnumeration( _DOES_NOT_EXIST_ );
    public static final StatusEnumeration  NOT_COLLECTED  = new StatusEnumeration( _NOT_COLLECTED_ );


    private static HashMap<String, StatusEnumeration> _INIT_()
    {
        HashMap<String, StatusEnumeration>  map = new HashMap<String, StatusEnumeration>();
        map.put( _ERROR_,           ERROR          );
        map.put( _EXISTS_,          EXISTS         );
        map.put( _DOES_NOT_EXIST_,  DOES_NOT_EXIST );
        map.put( _NOT_COLLECTED_,   NOT_COLLECTED  );
        return map;
    }

    private static final HashMap<String, StatusEnumeration>  _INSTANCES_ = _INIT_();




    /**
     */
    public static StatusEnumeration valueOf(
                    final String name
                    )
    {
        StatusEnumeration  status = null;
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
    private StatusEnumeration(
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
// StatusEnumeration

