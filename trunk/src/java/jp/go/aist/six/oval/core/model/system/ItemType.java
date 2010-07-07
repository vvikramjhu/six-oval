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

package jp.go.aist.six.oval.core.model.system;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public final class ItemType
    implements Serializable
{

    private static final String  _LINUX_RPMINFO_        = "linux.RpmInfo";
    private static final String  _LINUX_DPKGINFO_       = "linux.DpkgInfo";
    private static final String  _INDEPENDENT_FAMILY_   = "independent.Family";
    private static final String  _INDEPENDENT_TEXTFILECONTENT_   = "independent.TextFileContent";
    private static final String  _UNIX_UNAME_           = "unix.Uname";
    private static final String  _WINDOWS_FILE_         = "windows.File";
    private static final String  _WINDOWS_METABASE_     = "windows.Metabase";
    private static final String  _WINDOWS_REGISTRY_     = "windows.Registry";


    public static final ItemType  LINUX_RPMINFO         = new ItemType( _LINUX_RPMINFO_ );
    public static final ItemType  LINUX_DPKGINFO        = new ItemType( _LINUX_DPKGINFO_ );
    public static final ItemType  INDEPENDENT_FAMILY    = new ItemType( _INDEPENDENT_FAMILY_ );
    public static final ItemType  INDEPENDENT_TEXTFILECONTENT = new ItemType( _INDEPENDENT_TEXTFILECONTENT_ );
    public static final ItemType  UNIX_UNAME            = new ItemType( _UNIX_UNAME_ );
    public static final ItemType  WINDOWS_FILE          = new ItemType( _WINDOWS_FILE_ );
    public static final ItemType  WINDOWS_METABASE      = new ItemType( _WINDOWS_METABASE_ );
    public static final ItemType  WINDOWS_REGISTRY      = new ItemType( _WINDOWS_REGISTRY_ );


    private static HashMap<String, ItemType> _INIT_()
    {
        HashMap<String, ItemType>  map = new HashMap<String, ItemType>();
        map.put( _LINUX_RPMINFO_,       LINUX_RPMINFO       );
        map.put( _LINUX_DPKGINFO_,      LINUX_DPKGINFO      );
        map.put( _INDEPENDENT_FAMILY_,  INDEPENDENT_FAMILY  );
        map.put( _INDEPENDENT_TEXTFILECONTENT_, INDEPENDENT_TEXTFILECONTENT  );
        map.put( _UNIX_UNAME_,          UNIX_UNAME          );
        map.put( _WINDOWS_FILE_,        WINDOWS_FILE        );
        map.put( _WINDOWS_METABASE_,    WINDOWS_METABASE    );
        map.put( _WINDOWS_REGISTRY_,    WINDOWS_REGISTRY    );
        return map;
    }

    private static final HashMap<String, ItemType>  _INSTANCES_ = _INIT_();




    /**
     */
    public static ItemType valueOf(
                    final String name
                    )
    {
        ItemType  status = null;
        if (name != null) {
            status = _INSTANCES_.get( name );
        }

        if (status == null) {
            throw new IllegalArgumentException( "invalid item type: " + name );
        }

        return status;
    }



    private String  _name = null;



    /**
     */
    private ItemType(
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
// ItemType

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

