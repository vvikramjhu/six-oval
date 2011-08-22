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

package jp.go.aist.six.oval.model.v5.independent;

import java.util.Collection;
import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.v5.PlatformEntityType;
import jp.go.aist.six.oval.model.v5.common.CheckEnumeration;
import jp.go.aist.six.oval.model.v5.definitions.StateRefType;
import jp.go.aist.six.oval.model.v5.definitions.SystemObjectRefType;
import jp.go.aist.six.oval.model.v5.definitions.TestType;



/**
 * An unknown test acts as a placeholder for tests whose implementation is unknown.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class UnknownTest
    extends TestType
{

    /**
     * Constructor.
     */
    public UnknownTest()
    {
        this( null, 0 );
    }


    public UnknownTest(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null, null );
    }


    public UnknownTest(
                    final String id,
                    final int version,
                    final String comment,
                    final CheckEnumeration check
                    )
    {
        super( id, version, comment, check );

        oval_platform_type = OvalPlatformType.independent;
        oval_component_type = OvalComponentType.unknown;
    }



    //**************************************************************
    //  Test
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.INDEPENDENT_UNKNOWN;
    }


    @Override
    public void setObject(
                    final SystemObjectRefType ref
                    )
    {
    }


    @Override
    public SystemObjectRefType getObject()
    {
        return null;
    }



    @Override
    public void setState(
                    final Collection<? extends StateRefType> ref
                    )
    {
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
        if (!(obj instanceof UnknownTest)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "unknown_test[" + super.toString() + "]";
    }

}
// UnknownTest
