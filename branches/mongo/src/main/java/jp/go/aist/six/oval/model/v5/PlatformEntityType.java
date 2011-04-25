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

package jp.go.aist.six.oval.model.v5;

import java.io.Serializable;
import java.util.HashMap;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class PlatformEntityType
    implements Serializable
{

    private static final String  _UNKNOWN_              = "unknown";
    private static final String  _INDEPENDENT_FAMILY_   = "independent.family";
    private static final String  _INDEPENDENT_TEXTFILECONTENT_   = "independent.textfilecontent";
    private static final String  _INDEPENDENT_TEXTFILECONTENT54_ = "independent.textfilecontent54";
    private static final String  _INDEPENDENT_UNKNOWN_  = "independent.unknown";
    private static final String  _LINUX_DPKGINFO_       = "linux.dpkginfo";
    private static final String  _LINUX_RPMINFO_        = "linux.rpminfo";
    private static final String  _LINUX_RPMVERIFY_      = "linux.rpmverify";
    private static final String  _UNIX_UNAME_           = "unix.uname";
    private static final String  _WINDOWS_FILE_         = "windows.file";
    private static final String  _WINDOWS_METABASE_     = "windows.metabase";
    private static final String  _WINDOWS_REGISTRY_     = "windows.registry";
    private static final String  _WINDOWS_WMI_          = "windows.wmi";
    private static final String  _WINDOWS_WMI57_        = "windows.wmi57";

    private static final String  _VARIABLE_LOCAL_       = "variable.local";
    private static final String  _VARIABLE_EXTERNAL_    = "variable.external";


    public static final PlatformEntityType  UNKNOWN               = new PlatformEntityType( _UNKNOWN_ );
    public static final PlatformEntityType  INDEPENDENT_FAMILY    = new PlatformEntityType( _INDEPENDENT_FAMILY_ );
    public static final PlatformEntityType  INDEPENDENT_TEXTFILECONTENT = new PlatformEntityType( _INDEPENDENT_TEXTFILECONTENT_ );
    public static final PlatformEntityType  INDEPENDENT_TEXTFILECONTENT54 = new PlatformEntityType( _INDEPENDENT_TEXTFILECONTENT54_ );
    public static final PlatformEntityType  INDEPENDENT_UNKNOWN   = new PlatformEntityType( _INDEPENDENT_UNKNOWN_ );
    public static final PlatformEntityType  LINUX_DPKGINFO        = new PlatformEntityType( _LINUX_DPKGINFO_ );
    public static final PlatformEntityType  LINUX_RPMINFO         = new PlatformEntityType( _LINUX_RPMINFO_ );
    public static final PlatformEntityType  LINUX_RPMVERIFY       = new PlatformEntityType( _LINUX_RPMVERIFY_ );
    public static final PlatformEntityType  UNIX_UNAME            = new PlatformEntityType( _UNIX_UNAME_ );
    public static final PlatformEntityType  WINDOWS_FILE          = new PlatformEntityType( _WINDOWS_FILE_ );
    public static final PlatformEntityType  WINDOWS_METABASE      = new PlatformEntityType( _WINDOWS_METABASE_ );
    public static final PlatformEntityType  WINDOWS_REGISTRY      = new PlatformEntityType( _WINDOWS_REGISTRY_ );
    public static final PlatformEntityType  WINDOWS_WMI           = new PlatformEntityType( _WINDOWS_WMI_ );
    public static final PlatformEntityType  WINDOWS_WMI57         = new PlatformEntityType( _WINDOWS_WMI57_ );

    public static final PlatformEntityType  VARIABLE_LOCAL        = new PlatformEntityType( _VARIABLE_LOCAL_ );
    public static final PlatformEntityType  VARIABLE_EXTERNAL     = new PlatformEntityType( _VARIABLE_EXTERNAL_ );


    private static HashMap<String, PlatformEntityType> _INIT_()
    {
        HashMap<String, PlatformEntityType>  map = new HashMap<String, PlatformEntityType>();
        map.put( _UNKNOWN_,             UNKNOWN             );
        map.put( _INDEPENDENT_FAMILY_,  INDEPENDENT_FAMILY  );
        map.put( _INDEPENDENT_TEXTFILECONTENT_,   INDEPENDENT_TEXTFILECONTENT    );
        map.put( _INDEPENDENT_TEXTFILECONTENT54_, INDEPENDENT_TEXTFILECONTENT54  );
        map.put( _INDEPENDENT_UNKNOWN_, INDEPENDENT_UNKNOWN );
        map.put( _LINUX_DPKGINFO_,      LINUX_DPKGINFO      );
        map.put( _LINUX_RPMINFO_,       LINUX_RPMINFO       );
        map.put( _LINUX_RPMVERIFY_,     LINUX_RPMVERIFY     );
        map.put( _UNIX_UNAME_,          UNIX_UNAME          );
        map.put( _WINDOWS_FILE_,        WINDOWS_FILE        );
        map.put( _WINDOWS_METABASE_,    WINDOWS_METABASE    );
        map.put( _WINDOWS_REGISTRY_,    WINDOWS_REGISTRY    );
        map.put( _WINDOWS_WMI_,         WINDOWS_WMI         );
        map.put( _WINDOWS_WMI57_,       WINDOWS_WMI57       );

        map.put( _VARIABLE_LOCAL_,      VARIABLE_LOCAL      );
        map.put( _VARIABLE_EXTERNAL_,   VARIABLE_EXTERNAL   );
        return map;
    }

    private static final HashMap<String, PlatformEntityType>  _INSTANCES_ = _INIT_();




    /**
     */
    public static PlatformEntityType valueOf(
                    final String name
                    )
    {
        PlatformEntityType  type = null;
        if (name != null) {
            type = _INSTANCES_.get( name );
        }

        if (type == null) {
            throw new IllegalArgumentException( "invalid entity type: " + name );
        }

        return type;
    }



    private String  _name = null;



    /**
     */
    private PlatformEntityType(
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
// EntityType

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

