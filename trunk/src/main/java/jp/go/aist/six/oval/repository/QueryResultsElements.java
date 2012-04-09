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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class QueryResultsElements<T>
    implements Iterable<T>, Serializable
{

    private final List<T>  _elements = new ArrayList<T>();
    //{0..*}



    /**
     * Constructor.
     */
    public QueryResultsElements()
    {
    }


    public QueryResultsElements(
                    final Collection<? extends T> elements
                    )
    {
        setElements( elements );
    }


    public QueryResultsElements(
                    final T[] elements
                    )
    {
        if (elements != null) {
            setElements( Arrays.asList( elements ) );
        }
    }



    /**
     */
    public void setElements(
                    final Collection<? extends T> elements
                    )
    {
        if (elements != this._elements) {
            this._elements.clear();
            if (elements != null  &&  elements.size() > 0) {
                this._elements.addAll( elements );
            }
        }
    }


    public boolean addElement(
                    final T element
                    )
    {
        return this._elements.add( element );
    }


    public List<T> getElements()
    {
        return this._elements;
    }


    public Iterator<T> iterateElements()
    {
        return this._elements.iterator();
    }



    public int size()
    {
        return getElements().size();
    }


    //**************************************************************
    //  java.lang.Iterable
    //**************************************************************

    @Override
    public Iterator<T> iterator()
    {
        return this._elements.iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return String.valueOf( getElements() );
    }

}
//
