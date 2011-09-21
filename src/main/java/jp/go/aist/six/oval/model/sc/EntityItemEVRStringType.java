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

package jp.go.aist.six.oval.model.sc;

import jp.go.aist.six.oval.model.common.DatatypeEnumeration;



/**
 * The EntityItemEVRString type is extended by the entities of
 * an individual item.
 * This type represents the epoch, version, and release fields
 * as a single version string.
 * It has the form "EPOCH:VERSION-RELEASE".
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityItemEVRStringType
    extends EntityItemSimpleBaseType
{

    public static final DatatypeEnumeration  FIXED_DATATYPE =
        DatatypeEnumeration.EVR_STRING;
    //{required, fixed="evr_string"}



    /**
     * Constructor.
     */
    public EntityItemEVRStringType()
    {
    }


    public EntityItemEVRStringType(
                    final String content
                    )
    {
        super( content );
    }


//    public EntityItemEVRStringType(
//                    final String content,
//                    final StatusEnumeration status
//                    )
//    {
//        super( content, status );
//    }
//
//
//    public EntityItemEVRStringType(
//                    final String content,
//                    final DatatypeEnumeration datatype,
//                    final StatusEnumeration status
//                    )
//    {
//        super( content, datatype, status );
//    }



    //**************************************************************
    //  EntityItemBase
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


    //{required}
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

        if (!(obj instanceof EntityItemEVRStringType)) {
            return false;
        }

        return super.equals( obj );
    }

}
// EntityItemEVRStringType
