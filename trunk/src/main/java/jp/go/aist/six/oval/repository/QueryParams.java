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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class QueryParams
{

    private final Map<String, Object>  _values = new HashMap<String, Object>();



    /**
     * Constructor.
     */
    public QueryParams()
    {
    }



    /**
     */
    public Set<String> keys()
    {
        return _values.keySet();
    }



    /**
     *
     */
    public boolean isEmpty()
    {
        return _values.isEmpty();
    }



    /**
     */
    public void set(
                    final String key,
                    final Object value
                    )
    {
        _values.put( key, value );
    }



    public Object get(
                    final String key
                    )
    {
        return _values.get( key );
    }



    public Object get(
                    final String key,
                    final Object defaultValue
                    )
    {
        Object  value = get( key );
        return (value == null ? defaultValue : value);
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return _values.toString();
    }

}
// QueryParams

