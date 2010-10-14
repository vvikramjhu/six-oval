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
 * The EntityStateAnySimple type is extended by the entities
 * of an individual OVAL State.
 * This specific type describes any simple data.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityStateAnySimple
    extends EntityStateBase
{

    /**
     * Constructor.
     */
    public EntityStateAnySimple()
    {
    }


    /**
     * Constructor.
     */
    public EntityStateAnySimple(
                    final String data
                    )
    {
        super( data );
    }


    /**
     * Constructor.
     */
    public EntityStateAnySimple(
                    final String data,
                    final Operation operation
                    )
    {
        super( data, operation );
    }


    /**
     * Constructor.
     */
    public EntityStateAnySimple(
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

        if (!(obj instanceof EntityStateAnySimple)) {
            return false;
        }

        return super.equals( obj );
    }

}
// EntityStateAnySimple
