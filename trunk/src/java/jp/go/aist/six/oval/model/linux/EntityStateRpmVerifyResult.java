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

package jp.go.aist.six.oval.model.linux;

import jp.go.aist.six.oval.model.common.Operation;
import jp.go.aist.six.oval.model.definitions.EntityStateString;



/**
 * The EntityStateRpmVerifyResult restricts a string value
 * to the set of possible outcomes of checking an attribute
 * of a file included in an RPM against the actual value
 * of that attribute in the RPM database.
 * The empty string is also allowed to support the empty element
 * associated with variable references.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityStateRpmVerifyResult
    extends EntityStateString
{

    /**
     * Constructor.
     */
    public EntityStateRpmVerifyResult()
    {
    }


    /**
     * Constructor.
     */
    public EntityStateRpmVerifyResult(
                    final String data
                    )
    {
        this( data, DEFAULT_OPERATION );
    }


    /**
     * Constructor.
     */
    public EntityStateRpmVerifyResult(
                    final RpmVerifyResult data
                    )
    {
        this( data, DEFAULT_OPERATION );
    }


    /**
     * Constructor.
     */
    public EntityStateRpmVerifyResult(
                    final String data,
                    final Operation operation
                    )
    {
        this( RpmVerifyResult.valueOf( data ), operation );
    }



    /**
     * Constructor.
     */
    public EntityStateRpmVerifyResult(
                    final RpmVerifyResult data,
                    final Operation operation
                    )
    {
        super( (data == null ? null : data.getName()), operation );
    }



    //**************************************************************
    //  EntityBaseType
    //**************************************************************

    @Override
    public void setData(
                    final String data
                    )
    {
        if (data != null) {
            //validation
            RpmVerifyResult.valueOf( data );
        }

        super.setData( data );
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

        if (!(obj instanceof EntityStateRpmVerifyResult)) {
            return false;
        }

        return super.equals( obj );
    }



//    @Override
//    public String toString()
//    {
//        return "EntityStateFamily[" + super.toString() + "]";
//    }

}
// EntityStateRpmVerifyResult
