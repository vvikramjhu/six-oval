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

package jp.go.aist.six.oval.model.windows;

import jp.go.aist.six.oval.model.definitions.EntityObjectStringType;



/**
 * The EntityObjectProtocolType restricts a string value 
 * to a specific set of values: TCP and UDP.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityObjectProtocolType
    extends EntityObjectStringType
{

    /**
     * Constructor.
     */
    public EntityObjectProtocolType()
    {
    }


    public EntityObjectProtocolType(
                    final String content
                    )
    {
        super( content );
    }
//
//
//    public EntityObjectRegistryHiveType(
//                    final String data,
//                    final OperationEnumeration operation
//                    )
//    {
//        this( data, FIXED_DATATYPE, operation );
//    }
//
//
//    public EntityObjectRegistryHiveType(
//                    final String data,
//                    final DatatypeEnumeration datatype,
//                    final OperationEnumeration operation
//                    )
//    {
//        super( data, datatype, operation );
//    }
//
//
//    public EntityObjectRegistryHiveType(
//                    final RegistryHiveEnumeration data
//                    )
//    {
//        this( data, DEFAULT_OPERATION );
//    }
//
//
//    public EntityObjectRegistryHiveType(
//                    final RegistryHiveEnumeration data,
//                    final OperationEnumeration operation
//                    )
//    {
//        this( (data == null ? null : data.getName()), operation );
//    }



    //**************************************************************
    //  EntitySimpleBaseType
    //**************************************************************

    @Override
    public void setContent(
                    final String content
                    )
    {
        if (content != null) {
            //validation
            ProtocolEnumeration.fromValue( content );
        }

        super.setContent( content );
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

        if (!(obj instanceof EntityObjectProtocolType)) {
            return false;
        }

        return super.equals( obj );
    }

}
//EntityObjectProtocolType
