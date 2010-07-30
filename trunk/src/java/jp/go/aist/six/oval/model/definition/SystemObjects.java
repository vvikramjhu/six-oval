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

package jp.go.aist.six.oval.model.definition;

import jp.go.aist.six.oval.model.OvalElementContainer;
import java.util.Collection;
import java.util.Iterator;



/**
 * A collection of SystemObject instances.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class SystemObjects
    extends OvalElementContainer<SystemObject>  //{1..*}
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
                    final Collection<? extends SystemObject> elements
                    )
    {
        super( elements );
    }


    /**
     * Constructor.
     */
    public SystemObjects(
                    final SystemObject[] elements
                    )
    {
        super( elements );
    }



    public void setObject(
                    final Collection<? extends SystemObject> elements
                    )
    {
        reset( elements );
    }


    public boolean addObject(
                    final SystemObject e
                    )
    {
        return add( e );
    }


    public Collection<SystemObject> getObject()
    {
        return _values();
    }


    public Iterator<SystemObject> iterateObject()
    {
        return iterator();
    }

}
// SystemObjects
