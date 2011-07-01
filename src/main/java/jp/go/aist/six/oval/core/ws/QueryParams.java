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

package jp.go.aist.six.oval.core.ws;

import java.util.Properties;
import com.google.code.morphia.query.Query;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class QueryParams<T>
extends Properties
{

    public static final String  LIMIT = "limit";
    public static final String  OFFSET = "offset";
    public static final String  ORDER = "order";

    public static final int  DEFAULT_LIMIT = 10;
    public static final int  DEFAULT_OFFSET = 0;


    private static Properties _createDefaults()
    {
        Properties  defaults = new Properties();
        defaults.setProperty( LIMIT, String.valueOf( DEFAULT_LIMIT ) );
        defaults.setProperty( OFFSET, String.valueOf( DEFAULT_OFFSET ) );

        return defaults;
    }

    private static final Properties  _DEFAULTS_ = _createDefaults();




    /**
     * Constructor.
     */
    public QueryParams()
    {
        super( _DEFAULTS_ );
    }



    /**
     */
    public void buildQuery(
                    final Query<T> query
                    )
    {
        _buildDefaultQueryParams( query );
    }



    /**
     */
    protected void _buildDefaultQueryParams(
                    final Query<T> query
                    )
    {
        int  limit = _asInt( getLimit() );
        query.limit( limit );

        int  offset = _asInt( getOffset() );
        if (offset != DEFAULT_OFFSET) {
            query.offset( offset );
        }

        String  order = getOrder();
        if (order != null) {
            query.order( order );
        }
    }



    /**
     */
    protected void _buildFilterQueryParam(
                    final Query<T> query,
                    final String param
    )
    {
        String  value = getProperty( param );
        if (value != null) {
            query.filter( param, value );
        }
    }



    /**
     */
    protected int _asInt( final String value )
    {
        return Integer.valueOf( value ).intValue();
    }



    /**
     * @param   limit
     *  a maximum number of results to return.
     */
    public void setLimit(
                    final String limit
    )
    {
        if (limit == null) {
            //nothing
        } else {
            int  int_limit = Integer.valueOf( limit );
            if (int_limit < 1) {
                throw new IllegalArgumentException( "negative or zero limit" );
            }
        }

        setProperty( LIMIT, limit );
    }


    public String getLimit()
    {
        return getProperty( LIMIT );
    }



    /**
     * @param   offset
     *  at which object the service should begin returning results.
     */
    public void setOffset(
                    final String offset
    )
    {
        if (offset == null) {
            //nothing
        } else {
            int  int_offset = Integer.valueOf( offset );
            if (int_offset < 0) {
                throw new IllegalArgumentException( "negative offset" );
            }
        }

        setProperty( OFFSET, offset );
    }


    public String getOffset()
    {
        return getProperty( OFFSET );
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
        setProperty( ORDER, order );
    }


    public String getOrder()
    {
        return getProperty( ORDER );
    }

}
// QueryParams

