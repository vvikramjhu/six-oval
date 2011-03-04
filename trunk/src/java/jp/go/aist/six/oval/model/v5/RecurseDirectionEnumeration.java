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

package jp.go.aist.six.oval.model.v5;

import java.io.Serializable;
import java.util.HashMap;



/**
 * The RecurseDirection defines the direction to recurse,
 * either 'up' to parent directories, or 'down' into child directories.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class RecurseDirectionEnumeration
    implements Serializable
{

    private static final String  _NONE_  = "none";
    private static final String  _UP_    = "up";
    private static final String  _DOWN_  = "down";


    public static final RecurseDirectionEnumeration  NONE  = new RecurseDirectionEnumeration( _NONE_ );
    public static final RecurseDirectionEnumeration  UP    = new RecurseDirectionEnumeration( _UP_ );
    public static final RecurseDirectionEnumeration  DOWN  = new RecurseDirectionEnumeration( _DOWN_ );



    private static HashMap<String, RecurseDirectionEnumeration> _INIT_()
    {
        HashMap<String, RecurseDirectionEnumeration>  map = new HashMap<String, RecurseDirectionEnumeration>();
        map.put( _NONE_,  NONE );
        map.put( _UP_,    UP   );
        map.put( _DOWN_,  DOWN );
        return map;
    }

    private static final HashMap<String, RecurseDirectionEnumeration>  _INSTANCES_ = _INIT_();



    /**
     */
    public static RecurseDirectionEnumeration valueOf(
                    final String name
                    )
    {
        RecurseDirectionEnumeration  flag = null;
        if (name != null) {
            flag = _INSTANCES_.get( name );
        }

        if (flag == null) {
            throw new IllegalArgumentException( "invalid recurse direction: " + name );
        }

        return flag;
    }



    private String  _name = null;



    /**
     * Constructor.
     */
    private RecurseDirectionEnumeration(
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
// RecurseDirectionEnumeration
