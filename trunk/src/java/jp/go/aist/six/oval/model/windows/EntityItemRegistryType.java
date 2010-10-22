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

import jp.go.aist.six.oval.model.common.Datatype;
import jp.go.aist.six.oval.model.sc.EntityItemString;
import jp.go.aist.six.oval.model.sc.Status;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityItemRegistryType
    extends EntityItemString
{

    /**
     * Constructor.
     */
    public EntityItemRegistryType()
    {
    }


    /**
     * Constructor.
     */
    public EntityItemRegistryType(
                    final String data
                    )
    {
        this( data, DEFAULT_STATUS );
    }


    /**
     * Constructor.
     */
    public EntityItemRegistryType(
                    final String data,
                    final Status status
                    )
    {
        this( data, FIXED_DATATYPE, status );
    }


    /**
     * Constructor.
     */
    public EntityItemRegistryType(
                    final String data,
                    final Datatype datatype,
                    final Status status
                    )
    {
        super( data, datatype, status );
    }


    /**
     * Constructor.
     */
    public EntityItemRegistryType(
                    final RegistryType data
                    )
    {
        this( data, DEFAULT_STATUS );
    }


    /**
     * Constructor.
     */
    public EntityItemRegistryType(
                    final RegistryType data,
                    final Status status
                    )
    {
        this( (data == null ? null : data.getName()), status );
    }



    //**************************************************************
    //  EntityItemBase
    //**************************************************************

    @Override
    public void setData(
                    final String data
                    )
    {
        if (data != null) {
            // validation
            RegistryType.valueOf( data );
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

        if (!(obj instanceof EntityItemRegistryType)) {
            return false;
        }

        return super.equals( obj );
    }

}
// EntityItemRegistryType
