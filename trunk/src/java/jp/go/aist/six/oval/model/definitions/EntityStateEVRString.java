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

import jp.go.aist.six.oval.model.common.Datatype;
import jp.go.aist.six.oval.model.common.Operation;



/**
 * The EntityStateEVRString type is extended by the entities
 * of an individual OVAL State.
 * This type represents the epoch, version, and release fields
 * as a single version string.
 * It has the form "EPOCH:VERSION-RELEASE".
 * Note that a null epoch (or '(none)' as returned by rpm)
 * is equivalent to '0' and would hence have the form 0:VERSION-RELEASE.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityStateEVRString
    extends EntityStateBase
{

    public static final Datatype  FIXED_DATATYPE = Datatype.EVR_STRING;



    /**
     * Constructor.
     */
    public EntityStateEVRString()
    {
    }


    /**
     * Constructor.
     */
    public EntityStateEVRString(
                    final String data
                    )
    {
        this( data, DEFAULT_OPERATION );
    }


    /**
     * Constructor.
     */
    public EntityStateEVRString(
                    final String data,
                    final Operation operation
                    )
    {
        super( data, FIXED_DATATYPE, operation );
    }


    /**
     * Constructor.
     */
    public EntityStateEVRString(
                    final String data,
                    final Datatype datatype,
                    final Operation operation
                    )
    {
        super( data, datatype, operation );
    }



    //**************************************************************
    //  EntityBase
    //**************************************************************

    @Override
    public void setDatatype(
                    final Datatype datatype
                    )
    {
        if (datatype != null  &&  datatype != FIXED_DATATYPE) {
            throw new IllegalArgumentException( "invalid datatype: " + datatype);
        }

        super.setDatatype( datatype );
    }


    @Override
    public Datatype getDatatype()
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

        if (!(obj instanceof EntityStateEVRString)) {
            return false;
        }

        return super.equals( obj );
    }

}
// EntityStateEVRString
