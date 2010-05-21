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

import jp.go.aist.six.util.orm.Persistable;
import java.util.ArrayList;
import java.util.Collection;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: States.java 421 2010-03-18 10:17:37Z akihito $
 */
public abstract class Container<E>
implements Persistable
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
                    final Collection<E> elements
                    )
    {
        clear();
        if (elements == null  ||  elements.size() == 0) {
            return;
        }

        for (E  e : elements) {
            addElement( e );
        }
    }


    /**
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
     */
    public Collection<E> getElements()
    {
        return _elements;
//        return _elements.values();
    }


    /**
     */
    public E findElement( final Object key )
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
    //  Persistable
    //**************************************************************

    /**
     * The persistent identifier.
     */
    private  String  _persistentID;


    public void setPersistentID(
                    final String id
                    )
    {
        _persistentID = id;
    }


    public String getPersistentID()
    {
        return _persistentID;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        Collection<E>  elements = getElements();
        result = prime * result + elements.hashCode();

        return result;
    }



    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
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



    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return String.valueOf( getElements() );
    }

}
// Container
