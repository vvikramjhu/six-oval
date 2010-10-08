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
public final class RecurseFileSystem
    implements Serializable
{

    private static final String  _ALL_      = "all";
    private static final String  _LOCAL_    = "local";
    private static final String  _DEFINED_  = "defined";


    public static final RecurseFileSystem  ALL      = new RecurseFileSystem( _ALL_ );
    public static final RecurseFileSystem  LOCAL    = new RecurseFileSystem( _LOCAL_ );
    public static final RecurseFileSystem  DEFINED  = new RecurseFileSystem( _DEFINED_ );



    private static HashMap<String, RecurseFileSystem> _INIT_()
    {
        HashMap<String, RecurseFileSystem>  map = new HashMap<String, RecurseFileSystem>();
        map.put( _ALL_,      ALL );
        map.put( _LOCAL_,    LOCAL);
        map.put( _DEFINED_,  DEFINED );
        return map;
    }

    private static final HashMap<String, RecurseFileSystem>  _INSTANCES_ = _INIT_();




    /**
     */
    public static RecurseFileSystem valueOf(
                    final String name
                    )
    {
        RecurseFileSystem  e = null;
        if (name != null) {
            e = _INSTANCES_.get( name );
        }

        if (e == null) {
            throw new IllegalArgumentException( "invalid recurse direction: " + name );
        }

        return e;
    }



    private String  _name = null;



    /**
     * Constructor.
     */
    private RecurseFileSystem(
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
// RecurseFileSystem
