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

import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.common.CheckEnumeration;
import jp.go.aist.six.oval.model.definitions.StateRefType;
import jp.go.aist.six.oval.model.definitions.SystemObjectRefType;
import jp.go.aist.six.oval.model.definitions.TestType;



/**
 * The volume test is used to check information
 * about different storage volumes found on a Windows system.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class VolumeTest
    extends TestType
{

    /**
     * Constructor.
     */
    public VolumeTest()
    {
        this( null, 0 );
    }


    public VolumeTest(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null, null );
    }


    public VolumeTest(
                    final String id,
                    final int version,
                    final String comment,
                    final CheckEnumeration check
                    )
    {
        this( id, version, comment, check, null, null );
    }


    public VolumeTest(
                    final String id,
                    final int version,
                    final String comment,
                    final CheckEnumeration check,
                    final SystemObjectRefType object,
                    final StateRefType[] stateList
                    )
    {
        super( id, version, comment, check, object, stateList );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.volume;
        _oval_family = Family.WINDOWS;
        _oval_component = Component.VOLUME;
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
        if (!(obj instanceof VolumeTest)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "volume_test[" + super.toString() + "]";
    }

}
//VolumeTest