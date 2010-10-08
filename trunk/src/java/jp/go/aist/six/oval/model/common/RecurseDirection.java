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

package jp.go.aist.six.oval.model.common;

import java.io.Serializable;
import java.util.HashMap;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class RecurseDirection
    implements Serializable
{

    private static final String  _NONE_  = "none";
    private static final String  _UP_    = "up";
    private static final String  _DOWN_  = "down";


    public static final RecurseDirection  NONE  = new RecurseDirection( _NONE_ );
    public static final RecurseDirection  UP    = new RecurseDirection( _UP_ );
    public static final RecurseDirection  DOWN  = new RecurseDirection( _DOWN_ );



    private static HashMap<String, RecurseDirection> _INIT_()
    {
        HashMap<String, RecurseDirection>  map = new HashMap<String, RecurseDirection>();
        map.put( _NONE_,  NONE );
        map.put( _UP_,    UP   );
        map.put( _DOWN_,  DOWN );
        return map;
    }

    private static final HashMap<String, RecurseDirection>  _INSTANCES_ = _INIT_();




    /**
     */
    public static RecurseDirection valueOf(
                    final String name
                    )
    {
        RecurseDirection  flag = null;
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
    private RecurseDirection(
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
// RecurseDirection
