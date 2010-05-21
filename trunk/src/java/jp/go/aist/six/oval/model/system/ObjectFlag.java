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

package jp.go.aist.six.oval.model.system;

import java.io.Serializable;
import java.util.HashMap;



/**
 * The FlagEnumeration.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: ObjectFlag.java 438 2010-03-23 05:05:24Z akihito $
 */
public final class ObjectFlag
    implements Serializable
{

    private static final String  _ERROR_           = "error";
    private static final String  _COMPLETE_        = "complete";
    private static final String  _INCOMPLETE_      = "incomplete";
    private static final String  _DOES_NOT_EXIST_  = "does not exist";
    private static final String  _NOT_COLLECTED_   = "not collected";
    private static final String  _NOT_APPLICABLE_  = "not applicable";


    public static final ObjectFlag  ERROR          = new ObjectFlag( _ERROR_ );
    public static final ObjectFlag  COMPLETE       = new ObjectFlag( _COMPLETE_ );
    public static final ObjectFlag  INCOMPLETE     = new ObjectFlag( _INCOMPLETE_ );
    public static final ObjectFlag  DOES_NOT_EXIST = new ObjectFlag( _DOES_NOT_EXIST_ );
    public static final ObjectFlag  NOT_COLLECTED  = new ObjectFlag( _NOT_COLLECTED_ );
    public static final ObjectFlag  NOT_APPLICABLE = new ObjectFlag( _NOT_APPLICABLE_ );



    private static HashMap<String, ObjectFlag> _INIT_()
    {
        HashMap<String, ObjectFlag>  map = new HashMap<String, ObjectFlag>();
        map.put( _ERROR_,           ERROR          );
        map.put( _COMPLETE_,        COMPLETE       );
        map.put( _INCOMPLETE_,      INCOMPLETE     );
        map.put( _DOES_NOT_EXIST_,  DOES_NOT_EXIST );
        map.put( _NOT_COLLECTED_,   NOT_COLLECTED  );
        map.put( _NOT_APPLICABLE_,  NOT_APPLICABLE );
        return map;
    }

    private static final HashMap<String, ObjectFlag>  _INSTANCES_ = _INIT_();




    /**
     */
    public static ObjectFlag valueOf( final String name )
    {
        ObjectFlag  flag = null;
        if (name != null) {
            flag = _INSTANCES_.get( name );
        }

        if (flag == null) {
            throw new IllegalArgumentException( "invalid flag: " + name );
        }

        return flag;
    }



    private String  _name = null;



    /**
     */
    private ObjectFlag( final String name )
    {
        _name = name;
    }



    /**
     */
    public String getName()
    {
        return _name;
    }



    ////////////////////////////////////////////////////////////////
    //  java.lang.Object
    ////////////////////////////////////////////////////////////////

    @Override
    public String toString()
    {
        return getName();
    }

}
// ObjectFlag
