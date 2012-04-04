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
        // OpenSearch
        public static final String  SEARCH_TERMS    = "searchTerms";
        public static final String  COUNT           = "count";
        public static final String  START_INDEX     = "startIndex";
        public static final String  START_PAGE      = "startPage";

        // OpenSearch Time
        public static final String  DTSTART         = "dtstart";
        public static final String  DTEND           = "dtend";

        //sorting
        public static final String  ORDER           = "order";

        //predefined projection
        public static final String  VIEW            = "view";
    }
    //


    public static enum View
    {
        id,
        summary,
        complete,
        count
    }
    //View



    /**
     * Constructor.
     */
    public CommonQueryParams()
    {
    }



    /**
     */
    public void setSearchTerms(
                    final String searchTerms
                    )
    {
        set( Key.SEARCH_TERMS, searchTerms );
    }


    public String getSearchTerms()
    {
        return get( Key.SEARCH_TERMS );
    }



    /**
     */
    public void setCount(
                    final String count
                    )
    {
        set( Key.COUNT, count );
    }


    public String getCount()
    {
        return get( Key.COUNT );
    }



    /**
     * @param   start_index
     *  at which object the service should begin returning results.
     */
    public void setStartIndex(
                    final String start_index
                    )
    {
        set( Key.START_INDEX, start_index );
    }


    public String getStartIndex()
    {
        return get( Key.START_INDEX );
    }



    /**
     */
    public void setStartPage(
                    final String start_page
                    )
    {
        set( Key.START_PAGE, start_page );
    }


    public String getStartPage()
    {
        return get( Key.START_PAGE );
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
    public void setView(
                    final String view
    )
    {
        if (view != null) {
            // validation
            View.valueOf( view );
        }

        set( Key.VIEW, view );
    }


    public String getView()
    {
        return get( Key.VIEW );
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

}
//

