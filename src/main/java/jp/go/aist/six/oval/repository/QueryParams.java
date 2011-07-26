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
import java.util.Iterator;
import java.util.Map;
import jp.go.aist.six.oval.model.OvalObject;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class QueryParams<T extends OvalObject>
{

    public static final String  LIMIT  = "limit";
    public static final String  OFFSET = "offset";
    public static final String  ORDER  = "order";

    // OpenSearch Time
    public static final String  DT_START = "dtstart";
    public static final String  DT_END   = "dtend";


    public static final int DEFAULT_LIMIT = 10;



    private final Map<String, Object>  _values = new HashMap<String, Object>();



    /**
     * Constructor.
     */
    public QueryParams()
    {
    }



    /**
     */
    public Iterator<String> keys()
    {
        return _values.keySet().iterator();
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



    /**
     */
    public void setLimit(
                    final Integer limit
                    )
    {
        set( LIMIT, limit );
    }


    public int getLimit()
    {
        return Integer.class.cast( get( LIMIT, DEFAULT_LIMIT ) );
    }



    /**
     * @param   offset
     *  at which object the service should begin returning results.
     */
    public void setOffset(
                    final Integer offset
                    )
    {
        set( OFFSET, offset );
    }


    public Integer getOffset()
    {
        return Integer.class.cast( get( OFFSET ) );
    }



    /**
     * @param   order
     *  items be returned in a particular order.
     *  The content must be comma-separated, e.g. "age,-date"
     */
    public void setOrder(
                    final String order
    )
    {
        set( ORDER, order );
    }


    public String getOrder()
    {
        return String.class.cast( get( ORDER ) );
    }



    /**
     */
    public void setDtstart(
                    final String dtstart
    )
    {
        set( DT_START, dtstart );
    }


    public String getDtstart()
    {
        return String.class.cast( get( DT_START ) );
    }



    /**
     */
    public void setDtend(
                    final String dtend
    )
    {
        set( DT_END, dtend );
    }


    public String getDtend()
    {
        return String.class.cast( get( DT_END ) );
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

