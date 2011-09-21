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

package jp.go.aist.six.oval.model.definitions;

import jp.go.aist.six.oval.model.common.CheckEnumeration;
import jp.go.aist.six.oval.model.common.DatatypeEnumeration;
import jp.go.aist.six.oval.model.common.OperationEnumeration;



/**
 * The EntityStateAnySimple type is extended by the entities
 * of an individual OVAL State.
 * This specific type describes any simple data.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityStateAnySimpleType
    extends EntityStateSimpleBaseType
{

    /**
     * Constructor.
     */
    public EntityStateAnySimpleType()
    {
    }


    public EntityStateAnySimpleType(
                    final String content
                    )
    {
        super( content );
    }


    public EntityStateAnySimpleType(
                    final DatatypeEnumeration datatype,
                    final OperationEnumeration operation,
                    final Boolean mask,
                    final String var_ref,
                    final CheckEnumeration var_check,
                    final String content
                    )
    {
        super( datatype, operation, mask, var_ref, var_check, content );
    }


    public EntityStateAnySimpleType(
                    final String datatype,
                    final String operation,
                    final Boolean mask,
                    final String var_ref,
                    final String var_check,
                    final String content
                    )
    {
        super( datatype, operation, mask, var_ref, var_check, content );
    }



    //**************************************************************
    //  EntityBase
    //**************************************************************

    @Override
    public void setDatatype(
                    final DatatypeEnumeration datatype
                    )
    {
        if (datatype != null  &&  datatype.isComplex()) {
            throw new IllegalArgumentException( "invalid datatype: " + datatype );
        }

        super.setDatatype( datatype );
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

        if (!(obj instanceof EntityStateAnySimpleType)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "[" + super.toString() + "]";
    }

}
// EntityStateAnySimpleType
