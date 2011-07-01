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

import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.common.Check;
import jp.go.aist.six.oval.model.definitions.Test;



/**
 * The dpkginfo test is used to check information for a given DPKG package.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class DpkgInfoTest
    extends Test
//extends SimpleTest
{

    /**
     * Constructor.
     */
    public DpkgInfoTest()
    {
    }


    /**
     * Constructor.
     */
    public DpkgInfoTest(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public DpkgInfoTest(
                    final String id,
                    final int version,
                    final String comment,
                    final Check check
                    )
    {
        super( id, version, comment, check );
    }



    //**************************************************************
    //  Test
    //**************************************************************

    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.LINUX_DPKGINFO;
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
        if (!(obj instanceof DpkgInfoTest)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "dpkginfo_test[" + super.toString() + "]";
    }

}
// DpkgInfoTest