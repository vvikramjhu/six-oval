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

package jp.go.aist.six.oval.model.system;

import jp.go.aist.six.oval.model.common.Datatype;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class EntityItemString
    extends EntityItemBase
{

    /**
     * Constructor.
     */
    public EntityItemString()
    {
    }


    /**
     * Constructor.
     */
    public EntityItemString(
                    final String data
                    )
    {
        super( data );
    }


    /**
     * Constructor.
     */
    public EntityItemString(
                    final String data,
                    final Datatype datatype
                    )
    {
        super( data, datatype );
    }


    /**
     * Constructor.
     */
    public EntityItemString(
                    final String data,
                    final Datatype datatype,
                    final Status status
                    )
    {
        super( data, datatype, status );
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

        if (!(obj instanceof EntityItemString)) {
            return false;
        }

        return super.equals( obj );
    }

}
// EntityItemString
