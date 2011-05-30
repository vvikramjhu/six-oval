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

package jp.go.aist.six.oval.model.v5.results;

import java.io.Serializable;
import java.util.HashMap;



/**
 * The Content enumeration defines the valid values
 * for the directives controlling the amount of
 * expected depth found in the results document.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class ContentEnumeration
    implements Serializable
{

    private static final String  _THIN_ = "thin";
    private static final String  _FULL_ = "full";


    public static final ContentEnumeration  THIN = new ContentEnumeration( _THIN_ );
    public static final ContentEnumeration  FULL = new ContentEnumeration( _FULL_ );



    private static HashMap<String, ContentEnumeration> _INIT_()
    {
        HashMap<String, ContentEnumeration>  map = new HashMap<String, ContentEnumeration>();
        map.put( _THIN_, THIN );
        map.put( _FULL_, FULL );
        return map;
    }

    private static final HashMap<String, ContentEnumeration>  _INSTANCES_ = _INIT_();




    /**
     */
    public static ContentEnumeration valueOf(
                    final String name
                    )
    {
        ContentEnumeration  e = null;
        if (name != null) {
            e = _INSTANCES_.get( name );
        }

        if (e == null) {
            throw new IllegalArgumentException( "invalid result: " + name );
        }

        return e;
    }



    private String  _name = null;



    /**
     */
    private ContentEnumeration(
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
// ContentEnumeration
