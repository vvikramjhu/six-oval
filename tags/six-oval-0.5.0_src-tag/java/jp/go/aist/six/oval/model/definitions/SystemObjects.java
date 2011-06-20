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

package jp.go.aist.six.oval.model.definitions;

import jp.go.aist.six.oval.model.Container;
import java.util.Collection;
import java.util.Iterator;



/**
 * A container for one or more Object (SystemObject) instances.
 *
 * <p>Properties:</p>
 * <ul>
 *   <li>object (1..*)</li>
 * </ul>
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class SystemObjects
    extends Container<SystemObject>  //{1..*}
//extends OvalElementContainer<SystemObject>  //{1..*}
{

    /**
     * Constructor.
     */
    public SystemObjects()
    {
    }


    /**
     * Constructor.
     */
    public SystemObjects(
                    final Collection<? extends SystemObject> objects
                    )
    {
        super( objects );
    }


    /**
     * Constructor.
     */
    public SystemObjects(
                    final SystemObject[] objects
                    )
    {
        super( objects );
    }



    public void setObject(
                    final Collection<? extends SystemObject> objects
                    )
    {
        _setElement( objects );
//        if (_getElement() != objects) {
//            clear();
//            if (objects != null  &&  objects.size() > 0) {
//                addAll( objects );
//            }
//        }
    }


    public boolean addObject(
                    final SystemObject object
                    )
    {
        return add( object );
    }


    public Collection<SystemObject> getObject()
    {
        return _getElement();
    }


    public Iterator<SystemObject> iterateObject()
    {
        return iterator();
    }

}
// SystemObjects