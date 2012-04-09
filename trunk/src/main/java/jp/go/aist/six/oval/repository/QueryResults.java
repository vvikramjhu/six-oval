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
import java.util.Collection;



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


    private QueryResultsElements<T>  _elements;
//    private final List<T>  _elements = new ArrayList<T>();




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
        this( totalResults, startIndex, itemsPerPage, null );
//        setTotalResults( totalResults );
//        setStartIndex( startIndex );
//        setItemsPerPage( itemsPerPage );
    }


    public QueryResults(
                    final Long totalResults,
                    final Long startIndex,
                    final Long itemsPerPage,
                    final Collection<? extends T> elements
                    )
    {
        setTotalResults( totalResults );
        setStartIndex( startIndex );
        setItemsPerPage( itemsPerPage );

        if (elements != null) {
            setElements( new QueryResultsElements<T>( elements ) );
        }
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



    /**
     */
    public void setElements(
                    final QueryResultsElements<T> elements
                    )
    {
        this._elements = elements;
    }


    public QueryResultsElements<T> getElements()
    {
        return this._elements;
    }



//    /**
//     *
//     */
//    public void setElements( final Collection<? extends T> elements )
//    {
//        if (elements != _elements) {
//            _elements.clear();
//            if (elements != null  &&  elements.size() > 0) {
//                _elements.addAll( elements );
//            }
//        }
//    }
//
//
//    public List<T> getElements()
//    {
//        return _elements;
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "QueryResults[totalResults=" + getTotalResults()
             + ", startIndex=" + getStartIndex()
             + ", itemsPerPage=" + getItemsPerPage()
             + ", #elements=" + getElements().size()
             + "]"
             ;
    }

}
//QueryResults
