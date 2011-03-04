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

package jp.go.aist.six.oval.model.v5.definitions;

import java.io.Serializable;
import java.util.HashMap;



/**
 * The FilterAction enumeration defines the different options
 * for filtering sets of items.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class FilterActionEnumeration
    implements Serializable
{

    private static final String  _EXCLUDE_  = "exclude";
    private static final String  _INCLUDE_  = "include";


    public static final FilterActionEnumeration  EXCLUDE = new FilterActionEnumeration( _EXCLUDE_ );
    public static final FilterActionEnumeration  INCLUDE = new FilterActionEnumeration( _INCLUDE_ );



    private static HashMap<String, FilterActionEnumeration> _INIT_()
    {
        HashMap<String, FilterActionEnumeration>  map = new HashMap<String, FilterActionEnumeration>();
        map.put( _EXCLUDE_,  EXCLUDE );
        map.put( _INCLUDE_,  INCLUDE );
        return map;
    }

    private static final HashMap<String, FilterActionEnumeration>  _INSTANCES_ = _INIT_();




    /**
     */
    public static FilterActionEnumeration valueOf(
                    final String name
                    )
    {
        FilterActionEnumeration  flag = null;
        if (name != null) {
            flag = _INSTANCES_.get( name );
        }

        if (flag == null) {
            throw new IllegalArgumentException( "invalid filter action: " + name );
        }

        return flag;
    }



    private String  _name = null;



    /**
     * Constructor.
     */
    private FilterActionEnumeration(
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
// FilterActionEnumeration
