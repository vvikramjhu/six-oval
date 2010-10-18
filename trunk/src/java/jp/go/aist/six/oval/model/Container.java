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

package jp.go.aist.six.oval.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



/**
 * A set of element objects.
 * Every element MUST NOT be null.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Container<E>
    implements Iterable<E>
//    implements Set<E>
{

    private final Set<E>  _elements = new HashSet<E>();



    /**
     * Constructor.
     */
    public Container()
    {
    }


    /**
     * Constructor.
     */
    public Container(
                    final Collection<? extends E> elements
                    )
    {
        _setElement( elements );
    }


    /**
     * Constructor.
     */
    public Container(
                    final E[] elements
                    )
    {
        _setElement( Arrays.asList( elements ) );
    }



    /**
     */
    protected Set<E> _getElement()
    {
        return _elements;
    }



    /**
     */
    protected void _setElement(
                    final Collection<? extends E> c
                    )
    {
        if (c != _elements) {
            _elements.clear();
            if (c != null  &&  c.size() > 0) {
                addAll( c );
            }
        }
    }



    //**************************************************************
    //  Set
    //**************************************************************

    public int size()
    {
        return _elements.size();
    }



    public boolean isEmpty()
    {
        return _elements.isEmpty();
    }



    public boolean contains(
                    final Object o
                    )
    {
        if (o == null) {
            throw new NullPointerException( "contains: null argument" );
        }

        return _elements.contains( o );
    }



    public Object[] toArray()
    {
        return _elements.toArray();
    }



    public <T> T[] toArray(
                    final T[] a
                    )
    {
        return _elements.toArray( a );
    }



    public boolean add(
                    final E e
                    )
    {
        if (e == null) {
            throw new NullPointerException( "add: null argument" );
        }

        return _elements.add( e );
    }



    public boolean remove(
                    final Object o
                    )
    {
        if (o == null) {
            throw new NullPointerException( "remove: null argument" );
        }

        return _elements.remove( o );
    }



    public boolean containsAll(
                    final Collection<?> c
                    )
    {
        if (c == null) {
            throw new NullPointerException( "containsAll: null argument collection" );
        }

        return _elements.containsAll( c );
    }



    public boolean addAll(
                    final Collection<? extends E> c
                    )
    {
        if (c == null) {
            throw new NullPointerException( "addAll: null argument collection" );
        }

        if (c == _elements) {
            return false;
        }

        return _elements.addAll( c );
    }



    public boolean removeAll(
                    final Collection<?> c
                    )
    {
        if (c == null) {
            throw new NullPointerException( "removeAll: null argument collection" );
        }

        return _elements.removeAll( c );
    }



    public boolean retainAll(
                    final Collection<?> c
                    )
    {
        if (c == null) {
            throw new NullPointerException( "retainAll: null argument collection" );
        }

        return _elements.retainAll( c );
    }



    public void clear()
    {
        _elements.clear();
    }



    //**************************************************************
    //  Iterable
    //**************************************************************

    public Iterator<E> iterator()
    {
        return _elements.iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        return _elements.hashCode();
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (! Container.class.isInstance( obj )) {
            return false;
        }

        @SuppressWarnings( "unchecked" )
        Container<E>  other = (Container<E>)obj;
        if (this.size() == other.size()) {
            return this._getElement().equals( other._getElement() );
        }

        return false;
    }



    @Override
    public String toString()
    {
        return String.valueOf( _getElement() );
    }

}
// Container
