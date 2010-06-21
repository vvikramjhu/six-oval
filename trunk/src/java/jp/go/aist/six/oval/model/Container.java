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

import jp.go.aist.six.util.orm.AbstractPersistable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;



/**
 * A collection of element objects.
 * Every element MUST not be null.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class Container<E>
    extends AbstractPersistable
    implements Collection<E>
//implements Iterable<E>
{

//    private final Collection<E>  _elements = new ArrayList<E>();

    private final Map<Object, E>  _elements = new LinkedHashMap<Object, E>();



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
        addAll( elements );
    }


    /**
     * Constructor.
     */
    public Container(
                    final E[] elements
                    )
    {
        addAll( Arrays.asList( elements ) );
    }




    /**
     */
    protected abstract Object _getKey( E element );



    /**
     *
     */
    protected Collection<E>  _values()
    {
        return _elements.values();
    }



    /**
     */
    public void reset(
                    final Collection<? extends E> elements
                    )
    {
        clear();
        addAll( elements );
    }



//    /**
//     */
//    protected Set<Map.Entry<Object, E>> _entrySet()
//    {
//        return _elements.entrySet();
//    }



//    /**
//     */
//    protected Set<Object> _keySet()
//    {
//        return _elements.keySet();
//    }



//    /**
//     * Returns the elements.
//     * This method never returns null.
//     * Note that this method may returns
//     * the internal implementing collection object.
//     */
//    public Collection<E> getAll()
//    {
////        return _elements;
//        return _elements.values();
//    }



    /**
     */
    public E find(
                    final Object key
                    )
    {
        if (key == null) {
            throw new NullPointerException( "find: null argument" );
        }

        return _elements.get( key );
    }




//    //**************************************************************
//    //  Iterable
//    //**************************************************************

//    public Iterator<E> iterator()
//    {
//        return _elements.iterator();
//    }



    //**************************************************************
    //  Collection
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

        return _elements.containsValue( o );
    }



    public Iterator<E> iterator()
    {
        return _elements.values().iterator();
    }



    public Object[] toArray()
    {
        return _elements.values().toArray();
    }



    public <T> T[] toArray(
                    final T[] a
                    )
    {
        return _elements.values().toArray( a );
    }



    public boolean add(
                    final E e
                    )
    {
        if (e == null) {
            throw new NullPointerException( "add: null argument" );
        }

        Object  key = _getKey( e );
        if (key == null) {
            throw new IllegalArgumentException( "add: null-key argument" );
        }

        E  previousValue = _elements.put( key, e );

        return (e != previousValue);
    }



    public boolean remove(
                    final Object o
                    )
    {
        if (o == null) {
            throw new NullPointerException( "remove: null argument" );
        }

        @SuppressWarnings( "unchecked" )
        E  e = (E)o;

        Object  key = _getKey( e );
        if (key == null) {
            throw new IllegalArgumentException( "remove: null-key argument " );
        }

        E  previousValue = _elements.remove( key );

        return (previousValue != null);
    }



    public boolean containsAll(
                    final Collection<?> c
                    )
    {
        if (c == null) {
            throw new NullPointerException( "containsAll: null argument collection" );
        }

        for (Object  o : c) {
            if (o == null) {
                throw new NullPointerException( "containsAll: null element in argument collection" );
            }
        }

        return _elements.values().containsAll( c );
    }



    public boolean addAll(
                    final Collection<? extends E> c
                    )
    {
        if (c == null) {
            throw new NullPointerException( "containsAll: null argument collection" );
        }

        boolean  changed = false;
        for (E  e : c) {
            changed = changed || add( e );
        }

        return changed;
    }



    public boolean removeAll(
                    final Collection<?> c
                    )
    {
        if (c == null) {
            throw new NullPointerException( "removeAll: null argument collection" );
        }

        boolean  changed = false;
        for (Object  o : c) {
            changed = changed || remove( o );
        }

        return changed;
    }



    public boolean retainAll(
                    final Collection<?> c
                    )
    {
        if (c == null) {
            throw new NullPointerException( "retainAll: null argument collection" );
        }

        boolean  changed = false;
        for (Object  o : this) {
            if (!c.contains( o )) {
                changed = changed || remove( o );
            }
        }

        return changed;
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
        return _elements.hashCode();

//        final int  prime = 37;
//        int  result = 17;
//
//        Collection<E>  elements = getAll();
//        result = prime * result + elements.hashCode();
//
//        return result;
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

        Container<?>  other = Container.class.cast( obj );
        return other.containsAll( _elements.values() );

//        Collection<?>  other_elements = other.getAll();
//        Collection<?>   this_elements =  this.getAll();
//        if (this_elements == other_elements
//                        ||  (this_elements != null
//                                        &&  this_elements.equals( other_elements ))) {
//            return true;
//        }
//
//        return false;
    }



    @Override
    public String toString()
    {
        return String.valueOf( _elements.values() );
    }

}
// Container
