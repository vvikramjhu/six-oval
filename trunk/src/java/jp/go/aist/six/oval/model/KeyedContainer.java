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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



/**
 * A collection of element objects.
 * Every element MUST NOT be null.
 * In this collection, each element is identified by its key.
 * Every subclass has to implement _getKey() method to obtain the key.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class KeyedContainer<K,V>
    extends AbstractPersistable
    implements Collection<V>
{

    private final Map<K,V>  _elements = new HashMap<K,V>();
    //TODO: If we use LnkedHashMap, Container.equals() method does NOT work.
    // The order of elements seems to be affected.



    /**
     * Constructor.
     */
    public KeyedContainer()
    {
    }


    /**
     * Constructor.
     */
    public KeyedContainer(
                    final Collection<? extends V> elements
                    )
    {
        addAll( elements );
    }


    /**
     * Constructor.
     */
    public KeyedContainer(
                    final V[] elements
                    )
    {
        addAll( Arrays.asList( elements ) );
    }



    /**
     * Returns the key of the specified element.
     */
    protected abstract K _getKey( V element );



    /**
     */
    protected Collection<V> _values()
    {
        return _elements.values();
    }



    /**
     */
    protected Set<K> _keySet()
    {
        return _elements.keySet();
    }


    /**
     */
    protected Set<Map.Entry<K, V>> _entrySet()
    {
        return _elements.entrySet();
    }



    /**
     */
    public void reset(
                    final Collection<? extends V> elements
                    )
    {
        clear();
        addAll( elements );
    }



    /**
     */
    public V find(
                    final K key
                    )
    {
        if (key == null) {
            throw new NullPointerException( "find: null argument" );
        }

        return _elements.get( key );
    }



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



    public Iterator<V> iterator()
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
                    final V e
                    )
    {
        if (e == null) {
            throw new NullPointerException( "add: null argument" );
        }

        K  key = _getKey( e );
        if (key == null) {
            throw new IllegalArgumentException( "add: null-key argument" );
        }

        V  previousValue = _elements.put( key, e );

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
        V  e = (V)o;

        K  key = _getKey( e );
        if (key == null) {
            throw new IllegalArgumentException( "remove: null-key argument " );
        }

        V  previousValue = _elements.remove( key );

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
                    final Collection<? extends V> c
                    )
    {
        if (c == null) {
            throw new NullPointerException( "addAll: null argument collection" );
        }

        boolean  changed = false;
        for (V  e : c) {
            boolean  e_added = add( e );
            changed = e_added || changed;

//          changed = changed || add( e );  // This code is BUG!!!
            // if "changed" is true, add( E ) is not called.
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
            boolean  o_removed =  remove( o );
            changed = o_removed || changed;
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
                boolean  o_removed = remove( o );
                changed = o_removed || changed;
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
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (! KeyedContainer.class.isInstance( obj )) {
            return false;
        }

        @SuppressWarnings( "unchecked" )
        KeyedContainer<K,V>  other = (KeyedContainer<K,V>)obj;
        if (this.size() == other.size()) {
            return this._entrySet().equals( other._entrySet() );
        }
        return false;
    }



    @Override
    public String toString()
    {
        return String.valueOf( _elements.values() );
    }

}
// KeyedContainer
