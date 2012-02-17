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



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class CommonQueryParams
    extends QueryParams
{

    public static class Key
    {
        // TODO: adopt to OpenSearch ??? --- count, startIndex
        public static final String  LIMIT  = "limit";
        public static final String  OFFSET = "offset";

        public static final String  ORDER  = "order";

        // OpenSearch Time
        public static final String  DTSTART = "dtstart";
        public static final String  DTEND   = "dtend";
    }
    //



    /**
     * Constructor.
     */
    public CommonQueryParams()
    {
    }



    /**
     */
    public void setLimit(
                    final String limit
                    )
    {
        set( Key.LIMIT, limit );
    }


    public String getLimit()
    {
        return get( Key.LIMIT );
    }



    /**
     * @param   offset
     *  at which object the service should begin returning results.
     */
    public void setOffset(
                    final String offset
                    )
    {
        set( Key.OFFSET, offset );
    }


    public String getOffset()
    {
        return get( Key.OFFSET );
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
        set( Key.ORDER, order );
    }


    public String getOrder()
    {
        return get( Key.ORDER );
    }



    /**
     */
    public void setDtstart(
                    final String dtstart
    )
    {
        set( Key.DTSTART, dtstart );
    }


    public String getDtstart()
    {
        return get( Key.DTSTART );
    }



    /**
     */
    public void setDtend(
                    final String dtend
    )
    {
        set( Key.DTEND, dtend );
    }


    public String getDtend()
    {
        return get( Key.DTEND );
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

}
//

