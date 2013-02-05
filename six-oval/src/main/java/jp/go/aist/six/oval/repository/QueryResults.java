/**
 * SIX OVAL - http://code.google.com/p/six-oval/
 * Copyright (C) 2010
 *   National Institute of Advanced Industrial Science and Technology (AIST)
 *   Registration Number: H22PRO-1124
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
