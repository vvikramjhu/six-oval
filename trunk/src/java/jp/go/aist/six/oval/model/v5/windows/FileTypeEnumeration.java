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
 * The Windows file types.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class FileTypeEnumeration
    implements Serializable
{

    private static final String  _FILE_ATTRIBUTE_DIRECTORY_   = "FILE_ATTRIBUTE_DIRECTORY";
    private static final String  _FILE_TYPE_CHAR_             = "FILE_TYPE_CHAR";
    private static final String  _FILE_TYPE_DISK_             = "FILE_TYPE_DISK";
    private static final String  _FILE_TYPE_PIPE_             = "FILE_TYPE_PIPE";
    private static final String  _FILE_TYPE_REMOTE_           = "FILE_TYPE_REMOTE";
    private static final String  _FILE_TYPE_UNKNOWN_          = "FILE_TYPE_UNKNOWN";
    private static final String  _NONE_                       = "";


    public static final FileTypeEnumeration  FILE_ATTRIBUTE_DIRECTORY  = new FileTypeEnumeration( _FILE_ATTRIBUTE_DIRECTORY_ );
    public static final FileTypeEnumeration  FILE_TYPE_CHAR            = new FileTypeEnumeration( _FILE_TYPE_CHAR_ );
    public static final FileTypeEnumeration  FILE_TYPE_DISK            = new FileTypeEnumeration( _FILE_TYPE_DISK_ );
    public static final FileTypeEnumeration  FILE_TYPE_PIPE            = new FileTypeEnumeration( _FILE_TYPE_PIPE_ );
    public static final FileTypeEnumeration  FILE_TYPE_REMOTE          = new FileTypeEnumeration( _FILE_TYPE_REMOTE_ );
    public static final FileTypeEnumeration  FILE_TYPE_UNKNOWN         = new FileTypeEnumeration( _FILE_TYPE_UNKNOWN_ );
    public static final FileTypeEnumeration  NONE                      = new FileTypeEnumeration( _NONE_ );



    private static HashMap<String, FileTypeEnumeration> _INIT_()
    {
        HashMap<String, FileTypeEnumeration>  map = new HashMap<String, FileTypeEnumeration>();
        map.put( _FILE_ATTRIBUTE_DIRECTORY_, FILE_ATTRIBUTE_DIRECTORY );
        map.put( _FILE_TYPE_CHAR_,           FILE_TYPE_CHAR );
        map.put( _FILE_TYPE_DISK_,           FILE_TYPE_DISK );
        map.put( _FILE_TYPE_PIPE_,           FILE_TYPE_PIPE );
        map.put( _FILE_TYPE_REMOTE_,         FILE_TYPE_REMOTE );
        map.put( _FILE_TYPE_UNKNOWN_,        FILE_TYPE_UNKNOWN );
        map.put( _NONE_,                     NONE );
        return map;
    }

    private static final HashMap<String, FileTypeEnumeration>  _INSTANCES_ = _INIT_();




    /**
     */
    public static FileTypeEnumeration valueOf(
                    final String name
                    )
    {
        FileTypeEnumeration  flag = null;
        if (name != null) {
            flag = _INSTANCES_.get( name );
        }

        if (flag == null) {
            throw new IllegalArgumentException( "invalid file type: " + name );
        }

        return flag;
    }



    private String  _name = null;



    /**
     */
    private FileTypeEnumeration(
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
// FileTypeEnumeration
