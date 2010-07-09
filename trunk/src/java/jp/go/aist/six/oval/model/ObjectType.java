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
public final class ObjectType
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

    private static final String  _VARIABLE_LOCAL_       = "variable.local";
    private static final String  _VARIABLE_EXTERNAL_    = "variable.external";


    public static final ObjectType  INDEPENDENT_FAMILY    = new ObjectType( _INDEPENDENT_FAMILY_ );
    public static final ObjectType  INDEPENDENT_TEXTFILECONTENT = new ObjectType( _INDEPENDENT_TEXTFILECONTENT_ );
    public static final ObjectType  INDEPENDENT_UNKNOWN   = new ObjectType( _INDEPENDENT_UNKNOWN_ );
    public static final ObjectType  LINUX_DPKGINFO        = new ObjectType( _LINUX_DPKGINFO_ );
    public static final ObjectType  LINUX_RPMINFO         = new ObjectType( _LINUX_RPMINFO_ );
    public static final ObjectType  UNIX_UNAME            = new ObjectType( _UNIX_UNAME_ );
    public static final ObjectType  WINDOWS_FILE          = new ObjectType( _WINDOWS_FILE_ );
    public static final ObjectType  WINDOWS_METABASE      = new ObjectType( _WINDOWS_METABASE_ );
    public static final ObjectType  WINDOWS_REGISTRY      = new ObjectType( _WINDOWS_REGISTRY_ );

    public static final ObjectType  VARIABLE_LOCAL        = new ObjectType( _VARIABLE_LOCAL_ );
    public static final ObjectType  VARIABLE_EXTERNAL     = new ObjectType( _VARIABLE_EXTERNAL_ );


    private static HashMap<String, ObjectType> _INIT_()
    {
        HashMap<String, ObjectType>  map = new HashMap<String, ObjectType>();
        map.put( _INDEPENDENT_FAMILY_,  INDEPENDENT_FAMILY  );
        map.put( _INDEPENDENT_TEXTFILECONTENT_,  INDEPENDENT_TEXTFILECONTENT  );
        map.put( _INDEPENDENT_UNKNOWN_, INDEPENDENT_UNKNOWN  );
        map.put( _LINUX_DPKGINFO_,      LINUX_DPKGINFO      );
        map.put( _LINUX_RPMINFO_,       LINUX_RPMINFO       );
        map.put( _UNIX_UNAME_,          UNIX_UNAME      );
        map.put( _WINDOWS_FILE_,        WINDOWS_FILE        );
        map.put( _WINDOWS_METABASE_,    WINDOWS_METABASE    );
        map.put( _WINDOWS_REGISTRY_,    WINDOWS_REGISTRY    );

        map.put( _VARIABLE_LOCAL_,      VARIABLE_LOCAL    );
        map.put( _VARIABLE_EXTERNAL_,   VARIABLE_EXTERNAL    );
        return map;
    }

    private static final HashMap<String, ObjectType>  _INSTANCES_ = _INIT_();




    /**
     */
    public static ObjectType valueOf(
                    final String name
                    )
    {
        ObjectType  status = null;
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
    private ObjectType(
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
// ObjectType

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

