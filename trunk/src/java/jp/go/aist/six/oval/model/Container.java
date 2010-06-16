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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class Container<E>
    extends AbstractPersistable
    implements Iterable<E>
{

//    private final Map<Object, E>  _elements = new LinkedHashMap<Object, E>();
    private final Collection<E>  _elements = new ArrayList<E>();
//    private final Map<Object, E>  _map = null;



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
        setElements( elements );
    }



    /**
     */
    protected abstract Object _getKey( E element );




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



    /**
     */
    public void setElements(
                    final Collection<? extends E> elements
                    )
    {
        if (elements != _elements) {
            clear();
            if (elements == null  ||  elements.size() == 0) {
                return;
            }

            for (E  e : elements) {
                addElement( e );
            }
        }
    }


    /**
     * Appends an element.
     * If the argument element is null, it is simply ignored
     * and this method returns immediately.
     */
    public void addElement(
                    final E element
                    )
    {
        if (element == null) {
            return;
        }

        _elements.add( element );
//        _elements.put( _getKey( element ), element );
    }


    /**
     * Returns the elements.
     * This method never returns null.
     * Note that this method may returns
     * the internal implementing collection object.
     */
    public Collection<E> getElements()
    {
        return _elements;
//        return _elements.values();
    }


    /**
     */
    public E findElement(
                    final Object key
                    )
    {
        if (key == null) {
            throw new IllegalArgumentException( "null key" );
        }

        for (E  element : getElements()) {
            if (key.equals( _getKey( element ) )) {
                return element;
            }
        }
        return null;
    }



    /**
     */
    public void clear()
    {
        _elements.clear();
    }



    /**
     */
    public int size()
    {
        return _elements.size();
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
        final int  prime = 37;
        int  result = 17;

        Collection<E>  elements = getElements();
        result = prime * result + elements.hashCode();

        return result;
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
        Collection<?>  other_elements = other.getElements();
        Collection<?>   this_elements =  this.getElements();
        if (this_elements == other_elements
                        ||  (this_elements != null
                                        &&  this_elements.equals( other_elements ))) {
            return true;
        }

        return false;
    }



    @Override
    public String toString()
    {
        return String.valueOf( getElements() );
    }

}
// Container
