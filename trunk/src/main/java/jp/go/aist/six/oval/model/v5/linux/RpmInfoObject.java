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

package jp.go.aist.six.oval.model.v5.linux;

import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.definitions.EntityObjectStringType;



/**
 * The rpminfo object is used by a rpminfo test to define
 * the object to be evaluated.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RpmInfoObject
    extends LinuxPkgInfoObject
{

    /**
     * Constructor.
     */
    public RpmInfoObject()
    {
        this( null, 0 );
    }


    public RpmInfoObject(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public RpmInfoObject(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.linux;
        _oval_component_type = OvalComponentType.rpminfo;
    }



    /**
     */
    public RpmInfoObject name(
                    final EntityObjectStringType name
                    )
    {
        setName( name );
        return this;
    }


    public RpmInfoObject name(
                    final String name
                    )
    {
        return name( new EntityObjectStringType( name ) );
    }



    //**************************************************************
    //  SystemObject
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.LINUX_RPMINFO;
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
        if (!(obj instanceof RpmInfoObject)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "rpminfo_object[" + super.toString()
                        + ", name=" + getName()
                        + "]";
    }

}
// RpmInfoObject
