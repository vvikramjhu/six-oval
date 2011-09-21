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

package jp.go.aist.six.oval.model.common;

import jp.go.aist.six.oval.model.v5.Oval5Enumeration;



/**
 * The Family enumeration type is a listing of families
 * that OVAL supports at this time.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum FamilyEnumeration
    implements Oval5Enumeration
{

    CATOS                 ( "catos" ),
    IOS                   ( "ios" ),
    MACOS                 ( "macos" ),
    PIXOS                 ( "pixos" ),
    UNDEFINED             ( "undefined" ),
    UNIX                  ( "unix" ),
    VMWARE_INFRASTRUCTURE ( "vmware_infrastructure" ),
    WINDOWS               ( "windows" ),
    EMPTY                 ( "" );



    /**
     * A factory method.
     */
    public static FamilyEnumeration fromValue(
                    final String value
                    )
    {
        for (FamilyEnumeration  e : FamilyEnumeration.values()) {
            if (e.value.equals( value )) {
                return e;
            }
        }

        throw new IllegalArgumentException( value );
    }



    private String  value = null;



    /**
     * Constructor.
     */
    FamilyEnumeration(
                    final String value
                    )
    {
        this.value = value;
    }



    @Override
    public String value()
    {
        return this.value;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return this.value;
    }

}
// FamilyEnumeration
