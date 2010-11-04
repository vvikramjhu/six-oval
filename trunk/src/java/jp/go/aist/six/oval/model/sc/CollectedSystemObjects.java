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

package jp.go.aist.six.oval.model.sc;

import jp.go.aist.six.oval.model.OvalElementContainer;
import java.util.Collection;
import java.util.Iterator;



/**
 * A collection of all the objects that have been collected
 * by the system characteristics file..
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class CollectedSystemObjects
    extends OvalElementContainer<CollectedSystemObject>    //{1..*}
{

    /**
     * Constructor.
     */
    public CollectedSystemObjects()
    {
    }


    /**
     * Constructor.
     */
    public CollectedSystemObjects(
                    final Collection<? extends CollectedSystemObject> objects
                    )
    {
        super( objects );
    }


    /**
     * Constructor.
     */
    public CollectedSystemObjects(
                    final CollectedSystemObject[] objects
                    )
    {
        super( objects );
    }



    public void setObject(
                    final Collection<? extends CollectedSystemObject> objects
                    )
    {
        _setElement( objects );
    }


    public boolean addObject(
                    final CollectedSystemObject object
                    )
    {
        return add( object );
    }


    public Collection<CollectedSystemObject> getObject()
    {
        return _getElement();
    }



    public Iterator<CollectedSystemObject> iterateObject()
    {
        return iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "collected_objects["
                        + _getElement()
                        + "]";
    }

}
// CollectedSystemObjects
