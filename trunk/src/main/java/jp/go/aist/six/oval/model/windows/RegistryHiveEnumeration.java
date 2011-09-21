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

import jp.go.aist.six.oval.model.v5.Oval5Enumeration;



/**
 * The registry hive enumeration.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum RegistryHiveEnumeration
    implements Oval5Enumeration
{

    HKEY_CLASSES_ROOT   ( "HKEY_CLASSES_ROOT" ),
    HKEY_CURRENT_CONFIG ( "HKEY_CURRENT_CONFIG" ),
    HKEY_CURRENT_USER   ( "HKEY_CURRENT_USER" ),
    HKEY_LOCAL_MACHINE  ( "HKEY_LOCAL_MACHINE" ),
    HKEY_USERS          ( "HKEY_USERS" ),
    NONE                ( "" );



    /**
     * A factory method.
     */
    public static RegistryHiveEnumeration fromValue(
                    final String value
                    )
    {
        for (RegistryHiveEnumeration  e : RegistryHiveEnumeration.values()) {
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
    RegistryHiveEnumeration(
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
// RegistryHiveEnumeration
