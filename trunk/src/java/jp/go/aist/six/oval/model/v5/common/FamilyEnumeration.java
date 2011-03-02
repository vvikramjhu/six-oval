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

package jp.go.aist.six.oval.model.v5.common;

import java.io.Serializable;
import java.util.HashMap;



/**
 * The Family enumeration type is a listing of families
 * that OVAL supports at this time.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class FamilyEnumeration
    implements Serializable
{

    private static final String  _CATOS_     = "catos";
    private static final String  _IOS_       = "ios";
    private static final String  _MACOS_     = "macos";
    private static final String  _PIXOS_     = "pixos";
    private static final String  _UNDEFINED_ = "undefined";
    private static final String  _UNIX_      = "unix";
    private static final String  _VMWARE_INFRASTRUCTURE_ = "vmware_infrastructure";
    private static final String  _WINDOWS_   = "windows";


    public static final FamilyEnumeration  CATOS      = new FamilyEnumeration( _CATOS_ );
    public static final FamilyEnumeration  IOS        = new FamilyEnumeration( _IOS_ );
    public static final FamilyEnumeration  MACOS      = new FamilyEnumeration( _MACOS_ );
    public static final FamilyEnumeration  PIXOS      = new FamilyEnumeration( _PIXOS_ );
    public static final FamilyEnumeration  UNDEFINED  = new FamilyEnumeration( _UNDEFINED_ );
    public static final FamilyEnumeration  UNIX       = new FamilyEnumeration( _UNIX_ );
    public static final FamilyEnumeration  VMWARE_INFRASTRUCTURE = new FamilyEnumeration( _VMWARE_INFRASTRUCTURE_ );
    public static final FamilyEnumeration  WINDOWS    = new FamilyEnumeration( _WINDOWS_ );



    private static HashMap<String, FamilyEnumeration> _INIT_()
    {
        HashMap<String, FamilyEnumeration>  map = new HashMap<String, FamilyEnumeration>();
        map.put( _CATOS_,      CATOS     );
        map.put( _IOS_,        IOS       );
        map.put( _MACOS_,      MACOS     );
        map.put( _PIXOS_,      PIXOS     );
        map.put( _UNDEFINED_,  UNDEFINED );
        map.put( _UNIX_,       UNIX      );
        map.put( _VMWARE_INFRASTRUCTURE_, VMWARE_INFRASTRUCTURE );
        map.put( _WINDOWS_,    WINDOWS   );
        return map;
    }

    private static final HashMap<String, FamilyEnumeration>  _INSTANCES_ = _INIT_();



    /**
     */
    public static FamilyEnumeration valueOf(
                    final String name
                    )
    {
        FamilyEnumeration  flag = null;
        if (name != null) {
            flag = _INSTANCES_.get( name );
        }

        if (flag == null) {
            throw new IllegalArgumentException( "invalid family: " + name );
        }

        return flag;
    }



    private String  _name = null;



    /**
     * Constructor.
     */
    private FamilyEnumeration(
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
// FamilyEnumeration
