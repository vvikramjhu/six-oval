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

package jp.go.aist.six.oval.model.independent;

import jp.go.aist.six.oval.model.ObjectType;
import jp.go.aist.six.oval.model.definitions.SystemObject;



/**
 * The FamilyObject is used by a family test to define those objects
 * to evaluate based on a specified state.
 * There is actually only one object relating to family
 * and this is the system as a whole.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class FamilyObject
    extends SystemObject
{

    /**
     * Constructor.
     */
    public FamilyObject()
    {
    }


    /**
     * Constructor.
     */
    public FamilyObject(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }



    //**************************************************************
    //  SystemObject
    //**************************************************************

    @Override
    public ObjectType getObjectType()
    {
        return ObjectType.INDEPENDENT_FAMILY;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof FamilyObject)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "FamilyObject[" + super.toString() + "]";
    }

}
// FamilyObject
