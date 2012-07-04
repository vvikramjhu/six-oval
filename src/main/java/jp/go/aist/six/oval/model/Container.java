/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
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

package jp.go.aist.six.oval.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;



/**
 * A generic container which can contain objects.
 * Every element MUST NOT be null.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class Container<E>
    implements OvalObject
{

    /*
     * (1) Rename the methods and make them public!
     * add(E), addAll(Collection<? extends E>), addAll(E[]),
     * clear(), remove(E),
     * iterator(), contains(E), size(), isEmpty(),
     * toArray(), toArray(T[])
     *
     * (2) Prevent the collection to be exposed, in the subclasses!
     * Implements two kinds of methods: iterateXxx and addXxx.
     * http://www.castor.org/how-to-prevent-collection-from-being-exposed.html
     */

    /**
     * Constructor.
     */
    public Container()
    {
    }


//    public Container(
//                    final Collection<? extends E> elements
//                    )
//    {
//        _setElement( elements );
//    }
//
//
//    public Container(
//                    final E[] elements
//                    )
//    {
//        _setElement( elements );
//    }



//    /**
//     */
//    protected void _setElement(
//                    final Collection<? extends E> element_list
//                    )
//    {
//        if (_getCollection() != element_list) {
//            _getCollection().clear();
//            if (element_list != null  &&  element_list.size() > 0) {
//                for (E  e : element_list) {
//                    add( e );
//                }
//            }
//        }
//    }
//
//
//    protected void _setElement(
//                    final E[] element_list
//                    )
//    {
//        _getCollection().clear();
//        if (element_list != null  &&  element_list.length > 0) {
//            for (E  e : element_list) {
//                add( e );
//            }
//        }
//    }


    ///////////////////////////////////////////////////////////////////////

    protected abstract Collection<E> _getCollection();


    public void reset(
                    final Collection<? extends E> element_list
                    )
    {
        Collection<E>  this_collection = _getCollection();

        if (this_collection != element_list) {
            this_collection.clear();
            if (element_list != null  &&  element_list.size() > 0) {
                addAll( element_list );
            }
        }
    }


    public void reset(
                    final E[] element_list
                    )
    {
        if (element_list == null) {
            return;
        }

        reset( Arrays.asList( element_list ) );
    }



    public boolean add(
                    final E e
                    )
    {
        if (e == null) {
            throw new NullPointerException( "adding null element" );
        }

        return _getCollection().add( e );
    }


    public boolean addAll(
                    final Collection<? extends E> c
                    )
    {
        if (c == null) {
            throw new NullPointerException( "adding null collection" );
        }

        boolean  modified = false;
        Iterator<? extends E>  e = c.iterator();
        while (e.hasNext()) {
            if (add( e.next() )) {
                modified = true;
            }
        }

        return modified;
    }


    public boolean addAll(
                    final E[] c
                    )
    {
        if (c == null) {
            throw new NullPointerException( "adding null array" );
        }

        return addAll( Arrays.asList( c ) );
    }



    public void clear()
    {
        _getCollection().clear();
    }



    public boolean remove(
                    final E e
                    )
    {
        if (e == null) {
            throw new NullPointerException( "removing null element" );
        }

        return _getCollection().remove( e );
    }



    public Iterator<E> iterator()
    {
        return _getCollection().iterator();
    }



    public boolean contains(
                    final E e
                    )
    {
        if (e == null) {
            throw new NullPointerException( "testing null element" );
        }

        return _getCollection().contains( e );
    }



    public int size()
    {
        return _getCollection().size();
    }


    public boolean isEmpty()
    {
        return (size() == 0);
    }



    public Object[] toArray()
    {
        return _getCollection().toArray();
    }


    public <T> T[] toArray(
                    final T[] a
                    )
    {
        return _getCollection().toArray( a );
    }



    /**
     * A utility function.
     */
    protected static <T> void _copy(
                    final Collection<T> dst,
                    final Collection<? extends T> src
                    )
    {
        for (T  e : src) {
            if (e != null) {
                dst.add( e );
            }
        }
    }



    //*********************************************************************
    //  java.lang.Object
    //*********************************************************************

    @Override
    public int hashCode()
    {
        return _getCollection().hashCode();
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
        Collection<E>  other_elements = other._getCollection();
        Collection<E>   this_elements =  this._getCollection();
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
        return String.valueOf( _getCollection() );
    }

}
//Container
