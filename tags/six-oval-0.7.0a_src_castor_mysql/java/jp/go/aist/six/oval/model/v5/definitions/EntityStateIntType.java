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

package jp.go.aist.six.oval.model.v5.definitions;

import jp.go.aist.six.oval.model.v5.common.DatatypeEnumeration;



/**
 * The EntityStateInt type is extended by the entities
 * of an individual OVAL State.
 * This specific type describes simple integer data.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityStateIntType
    extends EntityStateSimpleBaseType
{

    public static final DatatypeEnumeration  FIXED_DATATYPE = DatatypeEnumeration.INT;



    /**
     * Constructor.
     */
    public  EntityStateIntType()
    {
    }


//    public EntityStateIntType(
//                    final String data
//                    )
//    {
//        this( data, DEFAULT_OPERATION );
//    }
//
//
//    public EntityStateIntType(
//                    final String data,
//                    final OperationEnumeration operation
//                    )
//    {
//        this( data, FIXED_DATATYPE, operation );
//    }
//
//
//    public EntityStateIntType(
//                    final String data,
//                    final DatatypeEnumeration datatype,
//                    final OperationEnumeration operation
//                    )
//    {
//        super( data, datatype, operation );
//    }


    public EntityStateIntType(
                    final int data
                    )
    {
        setContent( String.valueOf( data ) );
    }



    //**************************************************************
    //  EntityBase
    //**************************************************************

    @Override
    public void setDatatype(
                    final DatatypeEnumeration datatype
                    )
    {
        if (datatype != null  &&  datatype != FIXED_DATATYPE) {
            throw new IllegalArgumentException( "invalid datatype: " + datatype);
        }

        super.setDatatype( datatype );
    }


    @Override
    public DatatypeEnumeration getDatatype()
    {
        return FIXED_DATATYPE;
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

        if (!(obj instanceof EntityStateIntType)) {
            return false;
        }

        return super.equals( obj );
    }



//    @Override
//    public String toString()
//    {
//        return "[" + super.toString() + "]";
//    }

}
// EntityStateIntType