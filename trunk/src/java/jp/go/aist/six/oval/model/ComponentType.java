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

package jp.go.aist.six.oval.model;

import java.io.Serializable;
import java.util.HashMap;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: ComponentType.java 696 2010-04-26 10:22:00Z akihito $
 */
public final class ComponentType
    implements Serializable
{

    private static final String  _INDEPENDENT_FAMILY_   = "independent.family";
    private static final String  _INDEPENDENT_TEXTFILECONTENT_   = "independent.textfilecontent";
    private static final String  _INDEPENDENT_UNKNOWN_  = "independent.unknown";
    private static final String  _LINUX_DPKGINFO_       = "linux.dpkginfo";
    private static final String  _LINUX_RPMINFO_        = "linux.rpminfo";
    private static final String  _UNIX_UNAME_           = "unix.uname";
    private static final String  _WINDOWS_FILE_         = "windows.file";
    private static final String  _WINDOWS_METABASE_     = "windows.metabase";
    private static final String  _WINDOWS_REGISTRY_     = "windows.registry";


    public static final ComponentType  INDEPENDENT_FAMILY    = new ComponentType( _INDEPENDENT_FAMILY_ );
    public static final ComponentType  INDEPENDENT_TEXTFILECONTENT = new ComponentType( _INDEPENDENT_TEXTFILECONTENT_ );
    public static final ComponentType  INDEPENDENT_UNKNOWN   = new ComponentType( _INDEPENDENT_UNKNOWN_ );
    public static final ComponentType  LINUX_DPKGINFO        = new ComponentType( _LINUX_DPKGINFO_ );
    public static final ComponentType  LINUX_RPMINFO         = new ComponentType( _LINUX_RPMINFO_ );
    public static final ComponentType  UNIX_UNAME            = new ComponentType( _UNIX_UNAME_ );
    public static final ComponentType  WINDOWS_FILE          = new ComponentType( _WINDOWS_FILE_ );
    public static final ComponentType  WINDOWS_METABASE      = new ComponentType( _WINDOWS_METABASE_ );
    public static final ComponentType  WINDOWS_REGISTRY      = new ComponentType( _WINDOWS_REGISTRY_ );


    private static HashMap<String, ComponentType> _INIT_()
    {
        HashMap<String, ComponentType>  map = new HashMap<String, ComponentType>();
        map.put( _INDEPENDENT_FAMILY_,  INDEPENDENT_FAMILY  );
        map.put( _INDEPENDENT_TEXTFILECONTENT_,  INDEPENDENT_TEXTFILECONTENT  );
        map.put( _INDEPENDENT_UNKNOWN_, INDEPENDENT_UNKNOWN  );
        map.put( _LINUX_DPKGINFO_,      LINUX_DPKGINFO      );
        map.put( _LINUX_RPMINFO_,       LINUX_RPMINFO       );
        map.put( _UNIX_UNAME_,          UNIX_UNAME      );
        map.put( _WINDOWS_FILE_,        WINDOWS_FILE        );
        map.put( _WINDOWS_METABASE_,    WINDOWS_METABASE    );
        map.put( _WINDOWS_REGISTRY_,    WINDOWS_REGISTRY    );
        return map;
    }

    private static final HashMap<String, ComponentType>  _INSTANCES_ = _INIT_();




    /**
     */
    public static ComponentType valueOf(
                    final String name
                    )
    {
        ComponentType  status = null;
        if (name != null) {
            status = _INSTANCES_.get( name );
        }

        if (status == null) {
            throw new IllegalArgumentException( "invalid component type: " + name );
        }

        return status;
    }



    private String  _name = null;



    /**
     */
    private ComponentType(
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
// ComponentType

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

