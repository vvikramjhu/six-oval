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

package jp.go.aist.six.oval.model.v5.windows;

import jp.go.aist.six.oval.model.v5.Oval5Enumeration;



/**
 * The registry type enumeration.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum RegistryTypeEnumeration
    implements Oval5Enumeration
{

    REG_BINARY    ( "reg_binary" ),
    REG_DWORD     ( "reg_dword" ),
    REG_EXPAND_SZ ( "reg_expand_sz" ),
    REG_MULTI_SZ  ( "reg_multi_sz" ),
    REG_NONE      ( "reg_none" ),
    REG_QWORD     ( "reg_qword" ),
    REG_SZ        ( "reg_sz" ),
    EMPTY         ( "" )
    ;



    /**
     * A factory method.
     */
    public static RegistryTypeEnumeration fromValue(
                    final String value
                    )
    {
        for (RegistryTypeEnumeration  e : RegistryTypeEnumeration.values()) {
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
    RegistryTypeEnumeration(
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
// RegistryTypeEnumeration
