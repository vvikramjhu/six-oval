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

package jp.go.aist.six.oval.model.linux;

import jp.go.aist.six.oval.model.ObjectType;
import jp.go.aist.six.oval.model.definition.EntityObjectString;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: RpmInfoObject.java 696 2010-04-26 10:22:00Z akihito $
 */
public class RpmInfoObject
    extends LinuxPkgInfoObject
{

    /**
     * Constructor.
     */
    public RpmInfoObject()
    {
    }


    /**
     * Constructor.
     */
    public RpmInfoObject(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public RpmInfoObject(
                    final String id,
                    final int version,
                    final String name
                    )
    {
        super( id, version, name );
    }


    /**
     * Constructor.
     */
    public RpmInfoObject(
                    final String id,
                    final int version,
                    final EntityObjectString name
                    )
    {
        super( id, version, name );
    }



    //**************************************************************
    //  SystemObject
    //**************************************************************

    @Override
    public ObjectType getObjectType()
    {
        return ObjectType.LINUX_RPMINFO;
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
        if (!(obj instanceof RpmInfoObject)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "RpmInfoObject[" + super.toString() + "]";
    }

}
// RpmInfoObject
