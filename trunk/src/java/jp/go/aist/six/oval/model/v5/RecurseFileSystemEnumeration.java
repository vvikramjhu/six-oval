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
 * The RecurseFileSystem defines the file system limitation of any recursion,
 * either 'local' limiting data collection to local file systems
 * (as opposed to file systems mounted from an external system),
 * or 'defined' to keep any recursion within the file system
 * that the file_object (path+filename) has specified.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class RecurseFileSystemEnumeration
    implements Serializable
{

    private static final String  _ALL_      = "all";
    private static final String  _LOCAL_    = "local";
    private static final String  _DEFINED_  = "defined";


    public static final RecurseFileSystemEnumeration  ALL      = new RecurseFileSystemEnumeration( _ALL_ );
    public static final RecurseFileSystemEnumeration  LOCAL    = new RecurseFileSystemEnumeration( _LOCAL_ );
    public static final RecurseFileSystemEnumeration  DEFINED  = new RecurseFileSystemEnumeration( _DEFINED_ );



    private static HashMap<String, RecurseFileSystemEnumeration> _INIT_()
    {
        HashMap<String, RecurseFileSystemEnumeration>  map = new HashMap<String, RecurseFileSystemEnumeration>();
        map.put( _ALL_,      ALL     );
        map.put( _LOCAL_,    LOCAL   );
        map.put( _DEFINED_,  DEFINED );
        return map;
    }

    private static final HashMap<String, RecurseFileSystemEnumeration>  _INSTANCES_ = _INIT_();



    /**
     */
    public static RecurseFileSystemEnumeration valueOf(
                    final String name
                    )
    {
        RecurseFileSystemEnumeration  flag = null;
        if (name != null) {
            flag = _INSTANCES_.get( name );
        }

        if (flag == null) {
            throw new IllegalArgumentException(
                            "invalid recurse file system: " + name );
        }

        return flag;
    }



    private String  _name = null;



    /**
     * Constructor.
     */
    private RecurseFileSystemEnumeration(
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
// RecurseFileSystemEnumeration
