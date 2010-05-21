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

import java.io.Serializable;
import java.util.HashMap;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: RegistryHive.java 684 2010-04-24 14:36:18Z akihito $
 */
public final class RegistryHive
    implements Serializable
{

    private static final String  _HKEY_CLASSES_ROOT_   = "HKEY_CLASSES_ROOT";
    private static final String  _HKEY_CURRENT_CONFIG_ = "HKEY_CURRENT_CONFIG";
    private static final String  _HKEY_CURRENT_USER_   = "HKEY_CURRENT_USER";
    private static final String  _HKEY_LOCAL_MACHINE_  = "HKEY_LOCAL_MACHINE";
    private static final String  _HKEY_USERS_          = "HKEY_USERS";
    private static final String  _NONE_                 = "";


    public static final RegistryHive  HKEY_CLASSES_ROOT   = new RegistryHive( _HKEY_CLASSES_ROOT_ );
    public static final RegistryHive  HKEY_CURRENT_CONFIG = new RegistryHive( _HKEY_CURRENT_CONFIG_ );
    public static final RegistryHive  HKEY_CURRENT_USER   = new RegistryHive( _HKEY_CURRENT_USER_ );
    public static final RegistryHive  HKEY_LOCAL_MACHINE  = new RegistryHive( _HKEY_LOCAL_MACHINE_ );
    public static final RegistryHive  HKEY_USERS          = new RegistryHive( _HKEY_USERS_ );
    public static final RegistryHive  NONE                = new RegistryHive( _NONE_ );



    private static HashMap<String, RegistryHive> _INIT_()
    {
        HashMap<String, RegistryHive>  map = new HashMap<String, RegistryHive>();
        map.put( _HKEY_CLASSES_ROOT_,   HKEY_CLASSES_ROOT );
        map.put( _HKEY_CURRENT_CONFIG_, HKEY_CURRENT_CONFIG );
        map.put( _HKEY_CURRENT_USER_,   HKEY_CURRENT_USER );
        map.put( _HKEY_LOCAL_MACHINE_,  HKEY_LOCAL_MACHINE );
        map.put( _HKEY_USERS_,          HKEY_USERS );
        map.put( _NONE_,                NONE );
        return map;
    }

    private static final HashMap<String, RegistryHive>  _INSTANCES_ = _INIT_();




    /**
     */
    public static RegistryHive valueOf( final String name )
    {
        RegistryHive  flag = null;
        if (name != null) {
            flag = _INSTANCES_.get( name );
        }

        if (flag == null) {
            throw new IllegalArgumentException( "invalid registry hive: " + name );
        }

        return flag;
    }



    private String  _name = null;



    /**
     */
    private RegistryHive(
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
// RegistryHive
