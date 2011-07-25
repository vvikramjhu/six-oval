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

package jp.go.aist.six.oval.core.ws;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jp.go.aist.six.oval.model.OvalObject;



/**
 * A helper class for feeds.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalQueryResultElements
    implements Serializable
{

    private final List<OvalObject>  _elements = new ArrayList<OvalObject>();
    //{0..*}




    /**
     * Constructor.
     */
    public OvalQueryResultElements()
    {
    }


    public OvalQueryResultElements(
                    final Collection<? extends OvalObject> elements
                    )
    {
        setElements( elements );
    }


    public OvalQueryResultElements(
                    final OvalObject[] elements
                    )
    {
        if (elements != null) {
            setElements( Arrays.asList( elements ) );
        }
    }



    /**
     */
    public void setElements(
                    final Collection<? extends OvalObject> elements
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
                    final OvalObject element
                    )
    {
        return this._elements.add( element );
    }


    public Collection<OvalObject> getElements()
    {
        return this._elements;
    }


    public Iterator<OvalObject> iterateElements()
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
// OvalQueryResultElements
