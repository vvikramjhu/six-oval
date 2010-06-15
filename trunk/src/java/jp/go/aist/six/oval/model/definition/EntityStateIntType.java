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



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class EntityStateIntType
    extends EntityStateBaseType
{

//    private int  _value;



    /**
     * Constructor.
     */
    public  EntityStateIntType()
    {
    }


    /**
     * Constructor.
     */
    public EntityStateIntType(
                    final int value
                    )
    {
        setData( String.valueOf( value ) );
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

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
//        final int  prime = 37;
        int  result = super.hashCode();

//        result = prime * result + getValue();

        return result;
    }



    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EntityStateIntType)) {
            return false;
        }

        if (super.equals( obj )) {
//            EntityStateIntType  other = (EntityStateIntType)obj;
//            int  other_value = other.getValue();
//            int   this_value =  this.getValue();
//            if (this_value == other_value) {
                return true;
//            }
        }

        return false;
    }



    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "EntityStateIntType[" + super.toString() + "]";

//        return "[value=" + getValue()
//                        + ", " + super.toString()
//                        + "]";
    }

}
// EntityStateIntType
