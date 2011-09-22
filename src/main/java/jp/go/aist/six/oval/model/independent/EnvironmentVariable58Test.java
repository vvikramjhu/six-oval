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

package jp.go.aist.six.oval.model.independent;

import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.common.CheckEnumeration;
import jp.go.aist.six.oval.model.definitions.TestType;



/**
 * The environmentvariable test element is used to check an environment variable
 * for the specified process, which is identified by its process ID, on the system.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EnvironmentVariable58Test
    extends TestType
{

    /**
     * Constructor.
     */
    public EnvironmentVariable58Test()
    {
        this( null, 0 );
    }


    public EnvironmentVariable58Test(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null, null );
    }


    public EnvironmentVariable58Test(
                    final String id,
                    final int version,
                    final String comment,
                    final CheckEnumeration check
                    )
    {
        super( id, version, comment, check );

        _oval_platform_type = OvalPlatformType.independent;
        _oval_component_type = OvalComponentType.textfilecontent54;
    }


//    public TextfileContent54Test(
//                    final String id,
//                    final int version,
//                    final String comment,
//                    final CheckEnumeration check,
//                    final SystemObjectRefType object,
//                    final StateRefType[] stateList
//                    )
//    {
//        super( id, version, comment, check, object, stateList );
//    }




    //**************************************************************
    //  Test
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.INDEPENDENT_ENVIRONMENTVARIABLE58;
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
        if (!(obj instanceof EnvironmentVariable58Test)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "environmentvariable58_test[" + super.toString() + "]";
    }

}
//EnvironmentVariable58Test
