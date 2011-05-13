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

package jp.go.aist.six.oval.model.v5;

import java.util.Collection;
import java.util.Iterator;



/**
 * A set of element objects.
 * Every element MUST NOT be null.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class Container<E>
{

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
        _setElements( elements );
    }


    /**
     * Constructor.
     */
    public Container(
                    final E[] elements
                    )
    {
        _setElements( elements );
    }



    /**
     */
    protected void _setElements(
                    final Collection<? extends E> elements
                    )
    {
        if (_getElements() != elements) {
            _getElements().clear();
            if (elements != null  &&  elements.size() > 1) {
                for (E  e : elements) {
                    _addElement( e );
                }
            }
        }
    }


    protected void _setElements(
                    final E[] elements
                    )
    {
        _getElements().clear();
        if (elements != null  &&  elements.length > 1) {
            for (E  e : elements) {
                _addElement( e );
            }
        }
    }


    protected abstract Collection<E> _getElements();


    protected boolean _addElement(
                    final E e
                    )
    {
        if (e == null) {
            throw new NullPointerException( "adding null element" );
        }

        return _getElements().add( e );
    }


    protected Iterator<E> _iterateElements()
    {
        return _getElements().iterator();
    }



    public int size()
    {
        return _getElements().size();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        return _getElements().hashCode();
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
        Collection<E>  other_elements = other._getElements();
        Collection<E>   this_elements =  this._getElements();
        if (this_elements == other_elements
                        ||  (this_elements != null
                                        &&  this_elements.equals( other_elements ))) {
            return true;
        }

        return false;
    }

}
// Container
