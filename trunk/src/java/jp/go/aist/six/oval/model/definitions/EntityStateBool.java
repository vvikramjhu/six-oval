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
 * The EntityStateBool type is extended by the entities
 * of an individual OVAL State.
 * This specific type describes simple boolean data.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityStateBool
    extends EntityStateBase
{

    public static final Datatype  FIXED_DATATYPE = Datatype.BOOLEAN;



    /**
     * Constructor.
     */
    public  EntityStateBool()
    {
    }


    /**
     * Constructor.
     */
    public EntityStateBool(
                    final String data
                    )
    {
        this( data, DEFAULT_OPERATION );
    }


    /**
     * Constructor.
     */
    public EntityStateBool(
                    final String data,
                    final Operation operation
                    )
    {
        this( data, FIXED_DATATYPE, operation );
    }


    /**
     * Constructor.
     */
    public EntityStateBool(
                    final String data,
                    final Datatype datatype,
                    final Operation operation
                    )
    {
        super( data, datatype, operation );
    }


    /**
     * Constructor.
     */
    public EntityStateBool(
                    final boolean data
                    )
    {
        this( String.valueOf( data ) );
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
            throw new IllegalArgumentException( "invalid datatype: " + datatype );
        }

        super.setDatatype( datatype );
    }


    @Override
    public Datatype getDatatype()
    {
        return FIXED_DATATYPE;
    }



    @Override
    public void setData(
                    final String data
                    )
    {
        if (data != null) {
            if (data.equalsIgnoreCase( "true" )
                            ||  data.equalsIgnoreCase( "false" )
                            ||  data.equalsIgnoreCase( "1" )
                            ||  data.equalsIgnoreCase( "0" )) {
                // valid xsd:boolean value
            } else {
                throw new IllegalArgumentException( "invalid boolean data: " + data );
            }
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

        if (!(obj instanceof EntityStateBool)) {
            return false;
        }

        return super.equals( obj );
    }

}
// EntityStateBool
