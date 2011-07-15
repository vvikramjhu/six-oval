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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jp.go.aist.six.oval.model.v5.OvalObject;



/**
 * A helper class for feeds.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class AtomExtensionElements
    implements Serializable
{

    private final List<OvalObject>  _extensionElement = new ArrayList<OvalObject>();
    //{0..*}




    /**
     * Constructor.
     */
    public AtomExtensionElements()
    {
    }



    /**
     */
    public void setExtensionElement(
                    final Collection<? extends OvalObject> extensionElements
                    )
    {
        if (extensionElements != this._extensionElement) {
            this._extensionElement.clear();
            if (extensionElements != null  &&  extensionElements.size() > 0) {
                this._extensionElement.addAll( extensionElements );
            }
        }
    }


    public boolean addExtensionElement(
                    final OvalObject extensionElement
                    )
    {
        return this._extensionElement.add( extensionElement );
    }


    public Collection<OvalObject> getExtensionElement()
    {
        return this._extensionElement;
    }


    public Iterator<OvalObject> iterateExtensionElement()
    {
        return this._extensionElement.iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return String.valueOf( getExtensionElement() )
             ;
    }

}
// AtomExtensionElements
