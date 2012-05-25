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

package jp.go.aist.six.oval.repository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;



/**
 * A set of query parameters to be interpreted as a filter
 * for collections of OVAL entities.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class QueryParams
    implements Cloneable, Serializable
{

    public static final String  LIST_DELIMITER = ",";


    private final Map<String, String>  _params = new HashMap<String, String>();



    /**
     * Constructor.
     */
    public QueryParams()
    {
    }


    public QueryParams(
                    final Map<String, String> params
                    )
    {
        _params.putAll( params );
    }



    /**
     */
    public Set<String> keys()
    {
        return _params.keySet();
    }



    /**
     *
     */
    public boolean isEmpty()
    {
        return _params.isEmpty();
    }



    /**
     */
    public QueryParams set(
                    final String key,
                    final String value
                    )
    {
        _params.put( key, value );

        return this;
    }



    public String get(
                    final String key
                    )
    {
        return _params.get( key );
    }


    public String get(
                    final String key,
                    final String defaultValue
                    )
    {
        String  value = get( key );
        return (value == null ? defaultValue : value);
    }


    public int getAsInt(
                    final String key
                    )
    {
        String  v = _params.get( key );
        if (v == null) {
            throw new IllegalArgumentException( "no such key: " + key );
        }

        return Integer.valueOf( v ).intValue();
    }



    /**
     */
    public boolean containsKey(
                    final String key
                    )
    {
        return _params.containsKey( key );
    }



    /**
     *
     */
    public String remove(
                    final String key
                    )
    {
        return _params.remove( key );
    }



    /**
     *
     */
    public int size()
    {
        return _params.size();
    }



    //**************************************************************
    //  java.lang.Cloneable
    //**************************************************************

    @Override
    public Object clone()
    throws CloneNotSupportedException
    {
        return (new QueryParams( _params ));
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return _params.toString();
    }

}
//

