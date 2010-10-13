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

package jp.go.aist.six.oval.model;

import java.io.Serializable;
import java.util.HashMap;



/**
 * The Recurse defines how to recurse into the path entity,
 * in other words what to follow during recursion.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class Recurse
    implements Serializable
{

    private static final String  _DIRECTORIES_  = "directories";
    private static final String  _SYMLINKS_     = "symlinks";
    private static final String  _SYMLINKS_AND_DIRECTORIES_  = "symlinks and directories";


    public static final Recurse  DIRECTORIES    = new Recurse( _DIRECTORIES_ );
    public static final Recurse  SYMLINKS       = new Recurse( _SYMLINKS_ );
    public static final Recurse  SYMLINKS_AND_DIRECTORIES  = new Recurse( _SYMLINKS_AND_DIRECTORIES_ );



    private static HashMap<String, Recurse> _INIT_()
    {
        HashMap<String, Recurse>  map = new HashMap<String, Recurse>();
        map.put( _DIRECTORIES_,               DIRECTORIES              );
        map.put( _SYMLINKS_,                  SYMLINKS                 );
        map.put( _SYMLINKS_AND_DIRECTORIES_,  SYMLINKS_AND_DIRECTORIES );
        return map;
    }

    private static final HashMap<String, Recurse>  _INSTANCES_ = _INIT_();



    /**
     */
    public static Recurse valueOf(
                    final String name
                    )
    {
        Recurse  flag = null;
        if (name != null) {
            flag = _INSTANCES_.get( name );
        }

        if (flag == null) {
            throw new IllegalArgumentException( "invalid recurse: " + name );
        }

        return flag;
    }



    private String  _name = null;



    /**
     * Constructor.
     */
    private Recurse(
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
// Recurse
