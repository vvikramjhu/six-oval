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

package jp.go.aist.six.oval.model;

import java.io.Serializable;
import java.util.HashMap;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: ComponentType.java 696 2010-04-26 10:22:00Z akihito $
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class EntityType
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

    private static final String  _VARIABLE_LOCAL_       = "variable.local";
    private static final String  _VARIABLE_EXTERNAL_    = "variable.external";


    public static final EntityType  UNKNOWN               = new EntityType( _UNKNOWN_ );
    public static final EntityType  INDEPENDENT_FAMILY    = new EntityType( _INDEPENDENT_FAMILY_ );
    public static final EntityType  INDEPENDENT_TEXTFILECONTENT = new EntityType( _INDEPENDENT_TEXTFILECONTENT_ );
    public static final EntityType  INDEPENDENT_TEXTFILECONTENT54 = new EntityType( _INDEPENDENT_TEXTFILECONTENT54_ );
    public static final EntityType  INDEPENDENT_UNKNOWN   = new EntityType( _INDEPENDENT_UNKNOWN_ );
    public static final EntityType  LINUX_DPKGINFO        = new EntityType( _LINUX_DPKGINFO_ );
    public static final EntityType  LINUX_RPMINFO         = new EntityType( _LINUX_RPMINFO_ );
    public static final EntityType  LINUX_RPMVERIFY       = new EntityType( _LINUX_RPMVERIFY_ );
    public static final EntityType  UNIX_UNAME            = new EntityType( _UNIX_UNAME_ );
    public static final EntityType  WINDOWS_FILE          = new EntityType( _WINDOWS_FILE_ );
    public static final EntityType  WINDOWS_METABASE      = new EntityType( _WINDOWS_METABASE_ );
    public static final EntityType  WINDOWS_REGISTRY      = new EntityType( _WINDOWS_REGISTRY_ );
    public static final EntityType  WINDOWS_WMI           = new EntityType( _WINDOWS_WMI_ );

    public static final EntityType  VARIABLE_LOCAL        = new EntityType( _VARIABLE_LOCAL_ );
    public static final EntityType  VARIABLE_EXTERNAL     = new EntityType( _VARIABLE_EXTERNAL_ );


    private static HashMap<String, EntityType> _INIT_()
    {
        HashMap<String, EntityType>  map = new HashMap<String, EntityType>();
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

        map.put( _VARIABLE_LOCAL_,      VARIABLE_LOCAL      );
        map.put( _VARIABLE_EXTERNAL_,   VARIABLE_EXTERNAL   );
        return map;
    }

    private static final HashMap<String, EntityType>  _INSTANCES_ = _INIT_();




    /**
     */
    public static EntityType valueOf(
                    final String name
                    )
    {
        EntityType  type = null;
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
    private EntityType(
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

