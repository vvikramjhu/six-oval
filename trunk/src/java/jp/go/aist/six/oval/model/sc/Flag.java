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
 * The FlagEnumeration.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class Flag
    implements Serializable
{

    private static final String  _ERROR_           = "error";
    private static final String  _COMPLETE_        = "complete";
    private static final String  _INCOMPLETE_      = "incomplete";
    private static final String  _DOES_NOT_EXIST_  = "does not exist";
    private static final String  _NOT_COLLECTED_   = "not collected";
    private static final String  _NOT_APPLICABLE_  = "not applicable";


    public static final Flag  ERROR          = new Flag( _ERROR_ );
    public static final Flag  COMPLETE       = new Flag( _COMPLETE_ );
    public static final Flag  INCOMPLETE     = new Flag( _INCOMPLETE_ );
    public static final Flag  DOES_NOT_EXIST = new Flag( _DOES_NOT_EXIST_ );
    public static final Flag  NOT_COLLECTED  = new Flag( _NOT_COLLECTED_ );
    public static final Flag  NOT_APPLICABLE = new Flag( _NOT_APPLICABLE_ );



    private static HashMap<String, Flag> _INIT_()
    {
        HashMap<String, Flag>  map = new HashMap<String, Flag>();
        map.put( _ERROR_,           ERROR          );
        map.put( _COMPLETE_,        COMPLETE       );
        map.put( _INCOMPLETE_,      INCOMPLETE     );
        map.put( _DOES_NOT_EXIST_,  DOES_NOT_EXIST );
        map.put( _NOT_COLLECTED_,   NOT_COLLECTED  );
        map.put( _NOT_APPLICABLE_,  NOT_APPLICABLE );
        return map;
    }

    private static final HashMap<String, Flag>  _INSTANCES_ = _INIT_();




    /**
     */
    public static Flag valueOf(
                    final String name
                    )
    {
        Flag  e = null;
        if (name != null) {
            e = _INSTANCES_.get( name );
        }

        if (e == null) {
            throw new IllegalArgumentException( "invalid flag: " + name );
        }

        return e;
    }



    private String  _name = null;



    /**
     */
    private Flag(
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
// Flag
