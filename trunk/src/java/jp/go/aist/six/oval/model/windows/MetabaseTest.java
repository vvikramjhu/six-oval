/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
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

import jp.go.aist.six.oval.core.model.ComponentType;
import jp.go.aist.six.oval.model.definition.SimpleTest;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class MetabaseTest
    extends SimpleTest
{

    /**
     * Constructor.
     */
    public MetabaseTest()
    {
    }


    /**
     * Constructor.
     */
    public MetabaseTest(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }



    //**************************************************************
    //  Test
    //**************************************************************

    @Override
    public ComponentType getTestType()
    {
        return ComponentType.WINDOWS_METABASE;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
//        final int  prime = 37;
        int  result = super.hashCode();

        return result;
    }



    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof MetabaseTest)) {
            return false;
        }

        return super.equals( obj );
    }



    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "MetabaseTest[" + super.toString() + "]";
    }

}
// MetabaseTest
