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
import java.util.Date;
import java.util.Iterator;
import java.util.List;



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


    private QueryResultsElements<T>  _results = _newResultsElements();
//    private final List<T>  _elements = new ArrayList<T>();


    private Date  _timestamp;



    /**
     * Constructor.
     */
    public QueryResults()
    {
        this( 0L, 0L );
    }


    /**
     * Constructor.
     */
    public QueryResults(
//                    final Long totalResults,
                    final Long startIndex,
                    final Long itemsPerPage
                    )
    {
        this( startIndex, itemsPerPage, null );
//        this( totalResults, startIndex, itemsPerPage, null );
    }


    public QueryResults(
//                    final Long totalResults,
                    final Long startIndex,
                    final Long itemsPerPage,
                    final Collection<? extends T> results
                    )
    {
        _init( startIndex, itemsPerPage, results );
//        _init( totalResults, startIndex, itemsPerPage, results );
    }


    public QueryResults(
                    final Collection<? extends T> results
                    )
    {
        _init( 0L, (results == null ? 0L : results.size()), results );
//        _init( (results == null ? 0L : results.size()), null, null, results );
    }


    /**
     */
    private void _init(
//                    final Long totalResults,
                    final Long startIndex,
                    final Long itemsPerPage,
                    final Collection<? extends T> results
                    )
    {
//        setTotalResults( totalResults );
        setStartIndex( startIndex );
        setItemsPerPage( itemsPerPage );

        setResultsElements( new QueryResultsElements<T>( results ) );

        setTimestamp( new Date() );
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
    public void setResultsElements(
                    final QueryResultsElements<T> results
                    )
    {
        this._results = results;
    }


    public QueryResultsElements<T> getResultsElements()
    {
        return this._results;
    }



    /**
     */
    public void setElements(
                    final Collection<? extends T> elements
                    )
    {
        this._results.setElements( elements );
    }

    // A factory method.
    private static <S>
    QueryResultsElements<S> _newResultsElements()
    {
        return new QueryResultsElements<S>();
    }


    public void setElements(
                    final T[] elements
                    )
    {
        this._results.setElements( elements );
    }


    public boolean addElement(
                    final T element
                    )
    {
        return this._results.addElement( element );
    }


    public List<T> getElements()
    {
        return this._results.getElements();
    }


    public Iterator<T> iterateElements()
    {
        return this._results.iterateElements();
    }



    /**
     */
    public void setTimestamp(
                    final Date timestamp
                    )
    {
        _timestamp = timestamp;
    }


    public Date getTimestamp()
    {
        return _timestamp;
    }



    /**
     */
    public int size()
    {
        return (_results == null ? 0 : _results.size());
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
        return "QueryResults[timestamp="    + getTimestamp()
                        + ", totalResults=" + getTotalResults()
                        + ", startIndex="   + getStartIndex()
                        + ", itemsPerPage=" + getItemsPerPage()
                        + ", #elements="    + getResultsElements().size()
                        + "]"
                        ;
    }

}
//QueryResults
