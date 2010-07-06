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
 * @version $Id$
 */
public final class RegistryType
    implements Serializable
{

    private static final String  _REG_BINARY_    = "reg_binary";
    private static final String  _REG_DWORD_     = "reg_dword";
    private static final String  _REG_EXPAND_SZ_ = "reg_expand_sz";
    private static final String  _REG_MULTI_SZ_  = "reg_multi_sz";
    private static final String  _REG_NONE_      = "reg_none";
    private static final String  _REG_QWORD_     = "reg_qword";
    private static final String  _REG_SZ_        = "reg_sz";


    public static final RegistryType  REG_BINARY    = new RegistryType( _REG_BINARY_ );
    public static final RegistryType  REG_DWORD     = new RegistryType( _REG_DWORD_ );
    public static final RegistryType  REG_EXPAND_SZ = new RegistryType( _REG_EXPAND_SZ_ );
    public static final RegistryType  REG_MULTI_SZ  = new RegistryType( _REG_MULTI_SZ_ );
    public static final RegistryType  REG_NONE      = new RegistryType( _REG_NONE_ );
    public static final RegistryType  REG_QWORD     = new RegistryType( _REG_QWORD_ );
    public static final RegistryType  REG_SZ        = new RegistryType( _REG_SZ_ );



    private static HashMap<String, RegistryType> _INIT_()
    {
        HashMap<String, RegistryType>  map = new HashMap<String, RegistryType>();
        map.put( _REG_BINARY_,    REG_BINARY );
        map.put( _REG_DWORD_,     REG_DWORD );
        map.put( _REG_EXPAND_SZ_, REG_EXPAND_SZ );
        map.put( _REG_MULTI_SZ_,  REG_MULTI_SZ );
        map.put( _REG_NONE_,      REG_NONE );
        map.put( _REG_QWORD_,     REG_QWORD );
        map.put( _REG_SZ_,        REG_SZ );
        return map;
    }

    private static final HashMap<String, RegistryType>  _INSTANCES_ = _INIT_();




    /**
     */
    public static RegistryType valueOf(
                    final String name
                    )
    {
        RegistryType  e = null;
        if (name != null) {
            e = _INSTANCES_.get( name );
        }

        if (e == null) {
            throw new IllegalArgumentException( "invalid registry type: " + name );
        }

        return e;
    }



    private String  _name = null;



    /**
     */
    private RegistryType(
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



    ////////////////////////////////////////////////////////////////
    //  java.lang.Object
    ////////////////////////////////////////////////////////////////

    @Override
    public String toString()
    {
        return getName();
    }

}
// RegistryType
