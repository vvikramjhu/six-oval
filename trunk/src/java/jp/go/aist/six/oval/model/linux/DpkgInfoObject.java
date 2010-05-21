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

import jp.go.aist.six.oval.core.model.ComponentType;
import jp.go.aist.six.oval.model.definition.EntityObjectStringType;





/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: DpkgInfoObject.java 696 2010-04-26 10:22:00Z akihito $
 */
public class DpkgInfoObject
    extends LinuxPkgInfoObject
{

    /**
     * Constructor.
     */
    public DpkgInfoObject()
    {
    }


    /**
     * Constructor.
     */
    public DpkgInfoObject(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public DpkgInfoObject(
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
    public DpkgInfoObject(
                    final String id,
                    final int version,
                    final EntityObjectStringType name
                    )
    {
        super( id, version, name );
    }




    //**************************************************************
    //  SystemObject
    //**************************************************************

    @Override
    public ComponentType getSystemObjectType()
    {
        return ComponentType.LINUX_DPKGINFO;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        return super.hashCode();
    }



    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof DpkgInfoObject)) {
            return false;
        }

        return super.equals( obj );
    }



    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "DpkgInfoObject["
                        + super.toString()
                        + "]";
    }

}
// DpkgInfoObject
