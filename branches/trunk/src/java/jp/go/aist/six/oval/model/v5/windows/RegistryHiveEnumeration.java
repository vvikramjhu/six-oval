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

import java.io.Serializable;
import java.util.HashMap;



/**
 * The registry hive enumeration.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class RegistryHiveEnumeration
    implements Serializable
{

    private static final String  _HKEY_CLASSES_ROOT_   = "HKEY_CLASSES_ROOT";
    private static final String  _HKEY_CURRENT_CONFIG_ = "HKEY_CURRENT_CONFIG";
    private static final String  _HKEY_CURRENT_USER_   = "HKEY_CURRENT_USER";
    private static final String  _HKEY_LOCAL_MACHINE_  = "HKEY_LOCAL_MACHINE";
    private static final String  _HKEY_USERS_          = "HKEY_USERS";
    private static final String  _NONE_                = "";


    public static final RegistryHiveEnumeration  HKEY_CLASSES_ROOT   = new RegistryHiveEnumeration( _HKEY_CLASSES_ROOT_ );
    public static final RegistryHiveEnumeration  HKEY_CURRENT_CONFIG = new RegistryHiveEnumeration( _HKEY_CURRENT_CONFIG_ );
    public static final RegistryHiveEnumeration  HKEY_CURRENT_USER   = new RegistryHiveEnumeration( _HKEY_CURRENT_USER_ );
    public static final RegistryHiveEnumeration  HKEY_LOCAL_MACHINE  = new RegistryHiveEnumeration( _HKEY_LOCAL_MACHINE_ );
    public static final RegistryHiveEnumeration  HKEY_USERS          = new RegistryHiveEnumeration( _HKEY_USERS_ );
    public static final RegistryHiveEnumeration  NONE                = new RegistryHiveEnumeration( _NONE_ );



    private static HashMap<String, RegistryHiveEnumeration> _INIT_()
    {
        HashMap<String, RegistryHiveEnumeration>  map = new HashMap<String, RegistryHiveEnumeration>();
        map.put( _HKEY_CLASSES_ROOT_,   HKEY_CLASSES_ROOT );
        map.put( _HKEY_CURRENT_CONFIG_, HKEY_CURRENT_CONFIG );
        map.put( _HKEY_CURRENT_USER_,   HKEY_CURRENT_USER );
        map.put( _HKEY_LOCAL_MACHINE_,  HKEY_LOCAL_MACHINE );
        map.put( _HKEY_USERS_,          HKEY_USERS );
        map.put( _NONE_,                NONE );
        return map;
    }

    private static final HashMap<String, RegistryHiveEnumeration>  _INSTANCES_ = _INIT_();




    /**
     */
    public static RegistryHiveEnumeration valueOf(
                    final String name
                    )
    {
        RegistryHiveEnumeration  e = null;
        if (name != null) {
            e = _INSTANCES_.get( name );
        }

        if (e == null) {
            throw new IllegalArgumentException( "invalid registry hive: " + name );
        }

        return e;
    }



    private String  _name = null;



    /**
     */
    private RegistryHiveEnumeration(
                    final String name
                    )
    {
        _name = name;
    }



    /**
     */
    public String getName()
    {
        return _name;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return getName();
    }

}
// RegistryHiveEnumeration
