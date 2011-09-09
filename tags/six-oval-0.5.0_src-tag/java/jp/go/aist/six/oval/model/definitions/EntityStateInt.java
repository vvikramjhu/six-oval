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



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class EntityStateInt
    extends EntityStateBase
{

    /**
     * Constructor.
     */
    public  EntityStateInt()
    {
    }


    /**
     * Constructor.
     */
    public EntityStateInt(
                    final String data
                    )
    {
        super( data );
    }


    /**
     * Constructor.
     */
    public EntityStateInt(
                    final int data
                    )
    {
        super( String.valueOf( data ) );
    }



//    public void setValue(
//                    final int value
//                    )
//    {
//        _value = value;
//    }
//
//
//    public int getValue()
//    {
//        return _value;
//    }



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

        if (!(obj instanceof EntityStateInt)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "EntityStateInt[" + super.toString() + "]";
    }

}
// EntityStateInt