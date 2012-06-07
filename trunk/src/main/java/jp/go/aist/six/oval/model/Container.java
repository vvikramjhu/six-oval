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



    /**
     */
    protected void _setElement(
                    final Collection<? extends E> element_list
                    )
    {
        if (_getElement() != element_list) {
            _getElement().clear();
            if (element_list != null  &&  element_list.size() > 0) {
                for (E  e : element_list) {
                    _addElement( e );
                }
            }
        }
    }


    protected void _setElement(
                    final E[] element_list
                    )
    {
        _getElement().clear();
        if (element_list != null  &&  element_list.length > 0) {
            for (E  e : element_list) {
                _addElement( e );
            }
        }
    }


    protected abstract Collection<E> _getElement();


    protected boolean _addElement(
                    final E e
                    )
    {
        if (e == null) {
            throw new NullPointerException( "adding null element" );
        }

        return _getElement().add( e );
    }


    public Iterator<E> iterator()
    {
        return _getElement().iterator();
    }



    public void clear()
    {
        _getElement().clear();
    }



    public int size()
    {
        return _getElement().size();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        return _getElement().hashCode();
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
        Collection<E>  other_elements = other._getElement();
        Collection<E>   this_elements =  this._getElement();
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
        return String.valueOf( _getElement() );
    }

}
//Container
