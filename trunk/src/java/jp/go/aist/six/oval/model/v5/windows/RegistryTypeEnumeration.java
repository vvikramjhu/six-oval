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
 * The registry type enumeration.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class RegistryTypeEnumeration
    implements Serializable
{

    private static final String  _REG_BINARY_    = "reg_binary";
    private static final String  _REG_DWORD_     = "reg_dword";
    private static final String  _REG_EXPAND_SZ_ = "reg_expand_sz";
    private static final String  _REG_MULTI_SZ_  = "reg_multi_sz";
    private static final String  _REG_NONE_      = "reg_none";
    private static final String  _REG_QWORD_     = "reg_qword";
    private static final String  _REG_SZ_        = "reg_sz";


    public static final RegistryTypeEnumeration  REG_BINARY    = new RegistryTypeEnumeration( _REG_BINARY_ );
    public static final RegistryTypeEnumeration  REG_DWORD     = new RegistryTypeEnumeration( _REG_DWORD_ );
    public static final RegistryTypeEnumeration  REG_EXPAND_SZ = new RegistryTypeEnumeration( _REG_EXPAND_SZ_ );
    public static final RegistryTypeEnumeration  REG_MULTI_SZ  = new RegistryTypeEnumeration( _REG_MULTI_SZ_ );
    public static final RegistryTypeEnumeration  REG_NONE      = new RegistryTypeEnumeration( _REG_NONE_ );
    public static final RegistryTypeEnumeration  REG_QWORD     = new RegistryTypeEnumeration( _REG_QWORD_ );
    public static final RegistryTypeEnumeration  REG_SZ        = new RegistryTypeEnumeration( _REG_SZ_ );



    private static HashMap<String, RegistryTypeEnumeration> _INIT_()
    {
        HashMap<String, RegistryTypeEnumeration>  map = new HashMap<String, RegistryTypeEnumeration>();
        map.put( _REG_BINARY_,    REG_BINARY );
        map.put( _REG_DWORD_,     REG_DWORD );
        map.put( _REG_EXPAND_SZ_, REG_EXPAND_SZ );
        map.put( _REG_MULTI_SZ_,  REG_MULTI_SZ );
        map.put( _REG_NONE_,      REG_NONE );
        map.put( _REG_QWORD_,     REG_QWORD );
        map.put( _REG_SZ_,        REG_SZ );
        return map;
    }

    private static final HashMap<String, RegistryTypeEnumeration>  _INSTANCES_ = _INIT_();




    /**
     */
    public static RegistryTypeEnumeration valueOf(
                    final String name
                    )
    {
        RegistryTypeEnumeration  e = null;
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
    private RegistryTypeEnumeration(
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
// RegistryTypeEnumeration
