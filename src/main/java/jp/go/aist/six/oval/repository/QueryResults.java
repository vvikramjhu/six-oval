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



/**
 * Query results.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class QueryResults<T>
    implements Serializable
{

    private Long  _totalResults;    //OpenSearch
    //{0..1}

    private Long  _startIndex;      //OpenSearch
    //{0..1}

    private Long  _itemsPerPage;    //OpenSearch
    //{0..1}



    /**
     * Constructor.
     */
    public QueryResults()
    {
    }


    /**
     * Constructor.
     */
    public QueryResults(
                    final Long totalResults,
                    final Long startIndex,
                    final Long itemsPerPage
                    )
    {
        setTotalResults( totalResults );
        setStartIndex( startIndex );
        setItemsPerPage( itemsPerPage );
    }



    /**
     */
    public void setTotalResults(
                    final Long totalResults
                    )
    {
        _totalResults = totalResults;
    }


    public Long getTotalResults()
    {
        return _totalResults;
    }



    /**
     */
    public void setStartIndex(
                    final Long startIndex
                    )
    {
        _startIndex = startIndex;
    }


    public Long getStartIndex()
    {
        return _startIndex;
    }



    /**
     */
    public void setItemsPerPage(
                    final Long itemsPerPage
                    )
    {
        _itemsPerPage = itemsPerPage;
    }


    public Long getItemsPerPage()
    {
        return _itemsPerPage;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "QueryResults[totalResults=" + getTotalResults()
             + ", startIndex=" + getStartIndex()
             + ", itemsPerPage=" + getItemsPerPage()
             + "]"
             ;
    }

}
//QueryResults
