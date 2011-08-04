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
 * Metadata of query results.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class QueryResultMetadata
    implements Serializable
{

    public static final String  NAMESPACE = "http://a9.com/-/spec/opensearch/1.1/";



    private Integer  _totalResults;
    //{0..1}

    private Integer  _startIndex;
    //{0..1}

    private Integer  _itemsPerPage;
    //{0..1}



    /**
     * Constructor.
     */
    public QueryResultMetadata()
    {
    }


    /**
     * Constructor.
     */
    public QueryResultMetadata(
                    final int totalResults,
                    final int startIndex,
                    final int itemsPerPage
                    )
    {
        setTotalResults( totalResults );
        setStartIndex( startIndex );
        setItemsPerPage( itemsPerPage );
    }



    /**
     */
    public void setTotalResults(
                    final Integer totalResults
                    )
    {
        this._totalResults = totalResults;
    }


    public Integer getTotalResults()
    {
        return _totalResults;
    }



    /**
     */
    public void setStartIndex(
                    final Integer startIndex
                    )
    {
        this._startIndex = startIndex;
    }


    public Integer getStartIndex()
    {
        return _startIndex;
    }



    /**
     */
    public void setItemsPerPage(
                    final Integer itemsPerPage
                    )
    {
        this._itemsPerPage = itemsPerPage;
    }


    public Integer getItemsPerPage()
    {
        return _itemsPerPage;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "QueryResultMetadata[totalResults=" + getTotalResults()
             + ", startIndex=" + getStartIndex()
             + ", itemsPerPage=" + getItemsPerPage()
             + "]"
             ;
    }

}
// QueryResultMetadata
