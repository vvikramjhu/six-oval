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

import jp.go.aist.six.oval.repository.CommonQueryKey;
import jp.go.aist.six.oval.repository.QueryParams;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class DefaultQueryParams
    extends QueryParams
{

    /**
     * Constructor.
     */
    public DefaultQueryParams()
    {
    }



    /**
     */
    public void setLimit(
                    final String limit
                    )
    {
        set( CommonQueryKey.LIMIT, limit );
    }


    public String getLimit()
    {
        return String.class.cast( get( CommonQueryKey.LIMIT ) );
//        return Integer.class.cast( get( CommonQueryKey.LIMIT ) );
    }



    /**
     * @param   offset
     *  at which object the service should begin returning results.
     */
    public void setOffset(
                    final Integer offset
                    )
    {
        set( CommonQueryKey.OFFSET, offset );
    }


    public Integer getOffset()
    {
        return Integer.class.cast( get( CommonQueryKey.OFFSET ) );
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
        set( CommonQueryKey.ORDER, order );
    }


    public String getOrder()
    {
        return String.class.cast( get( CommonQueryKey.ORDER ) );
    }



    /**
     */
    public void setDtstart(
                    final String dtstart
    )
    {
        set( CommonQueryKey.DT_START, dtstart );
    }


    public String getDtstart()
    {
        return String.class.cast( get( CommonQueryKey.DT_START ) );
    }



    /**
     */
    public void setDtend(
                    final String dtend
    )
    {
        set( CommonQueryKey.DT_END, dtend );
    }


    public String getDtend()
    {
        return String.class.cast( get( CommonQueryKey.DT_END ) );
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

}
// DefaultQueryParams

