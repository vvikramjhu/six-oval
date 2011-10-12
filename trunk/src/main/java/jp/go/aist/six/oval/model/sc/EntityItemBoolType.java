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
 * The EntityItemBoolType is extended by the entities of an individual item.
 * This type provides uniformity to each entity by including the attributes
 * found in the EntityItemSimpleBaseType.
 * This specific type describes simple boolean data.
 * The empty string is also allowed for cases where there was an error
 * in the data collection of an entity and a status needs to be reported.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityItemBoolType
    extends EntityItemSimpleBaseType
{

    public static final DatatypeEnumeration  FIXED_DATATYPE =
        DatatypeEnumeration.BOOLEAN;
    //{required, fixed="boolean"}



    /**
     * Constructor.
     */
    public EntityItemBoolType()
    {
    }


    public EntityItemBoolType(
                    final String content
                    )
    {
        super( content );
    }



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

        if (!(obj instanceof EntityItemBoolType)) {
            return false;
        }

        return super.equals( obj );
    }

}
// EntityItemBoolType
