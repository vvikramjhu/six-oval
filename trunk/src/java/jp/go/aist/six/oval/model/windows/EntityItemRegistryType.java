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

package jp.go.aist.six.oval.model.windows;

import jp.go.aist.six.oval.model.system.EntityItemString;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class EntityItemRegistryType
    extends EntityItemString
{

    /**
     * Constructor.
     */
    public EntityItemRegistryType()
    {
    }


    /**
     * Constructor.
     */
    public EntityItemRegistryType(
                    final String data
                    )
    {
        setData( data );
    }



    //**************************************************************
    //  EntityItemBase
    //**************************************************************

    @Override
    public void setData(
                    final String data
                    )
    {
        super.setData( RegistryType.fromValue( data ).value() );
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
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EntityItemRegistryType)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "EntityItemRegistryType[" + super.toString() + "]";
    }

}
// EntityItemRegistryType
