/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
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

import jp.go.aist.six.util.castor.AbstractPersistable;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



/**
 * A collection of element objects.
 * Every element MUST NOT be null.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class ContainerBak<E>
    extends AbstractPersistable
    implements Set<E>
{

    private final Set<E>  _elements = new HashSet<E>();



    /**
     * Constructor.
     */
    public ContainerBak()
    {
    }


    /**
     * Constructor.
     */
    public ContainerBak(
                    final Collection<? extends E> elements
                    )
    {
        addAll( elements );
    }


    /**
     * Constructor.
     */
    public ContainerBak(
                    final E[] elements
                    )
    {
        addAll( Arrays.asList( elements ) );
    }



    /**
     */
    protected Set<E>  _elements()
    {
        return _elements;
    }



    /**
     */
    public void reset(
                    final Collection<? extends E> c
                    )
    {
        if (c != _elements) {
            clear();
            addAll( c );
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



    public Iterator<E> iterator()
    {
        return _elements.iterator();
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
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        return _elements().hashCode();
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (! ContainerBak.class.isInstance( obj )) {
            return false;
        }

        @SuppressWarnings( "unchecked" )
        ContainerBak<E>  other = (ContainerBak<E>)obj;
        if (this.size() == other.size()) {
            return this._elements().equals( other._elements() );
        }

        return false;
    }



    @Override
    public String toString()
    {
        return String.valueOf( _elements() );
    }

}
// Container