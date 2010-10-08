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

package jp.go.aist.six.oval.model.common;

import java.io.Serializable;
import java.util.HashMap;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class Datatype
    implements Serializable
{

    private static final String  _BINARY_           = "binary";
    private static final String  _BOOLEAN_          = "boolean";
    private static final String  _EVR_STRING_       = "evr_string";
    private static final String  _FILESET_REVISION_ = "fileset_revision";
    private static final String  _FLOAT_            = "float";
    private static final String  _IOS_VERSION_      = "ios_version";
    private static final String  _INT_              = "int";
    private static final String  _STRING_           = "string";
    private static final String  _VERSION_          = "version";


    public static final Datatype  BINARY            = new Datatype( _BINARY_ );
    public static final Datatype  BOOLEAN           = new Datatype( _BOOLEAN_ );
    public static final Datatype  EVR_STRING        = new Datatype( _EVR_STRING_ );
    public static final Datatype  FILESET_REVISION  = new Datatype( _FILESET_REVISION_ );
    public static final Datatype  FLOAT             = new Datatype( _FLOAT_ );
    public static final Datatype  IOS_VERSION       = new Datatype( _IOS_VERSION_ );
    public static final Datatype  INT               = new Datatype( _INT_ );
    public static final Datatype  STRING            = new Datatype( _STRING_ );
    public static final Datatype  VERSION           = new Datatype( _VERSION_ );



    private static HashMap<String, Datatype> _INIT_()
    {
        HashMap<String, Datatype>  map = new HashMap<String, Datatype>();
        map.put( _BINARY_,            BINARY );
        map.put( _BOOLEAN_,           BOOLEAN );
        map.put( _EVR_STRING_,        EVR_STRING );
        map.put( _FILESET_REVISION_,  FILESET_REVISION );
        map.put( _FLOAT_,             FLOAT );
        map.put( _IOS_VERSION_,       IOS_VERSION );
        map.put( _INT_,               INT );
        map.put( _STRING_,            STRING );
        map.put( _VERSION_,           VERSION );
        return map;
    }

    private static final HashMap<String, Datatype>  _INSTANCES_ = _INIT_();




    /**
     */
    public static Datatype valueOf(
                    final String name
                    )
    {
        Datatype  flag = null;
        if (name != null) {
            flag = _INSTANCES_.get( name );
        }

        if (flag == null) {
            throw new IllegalArgumentException( "invalid datatype: " + name );
        }

        return flag;
    }




    private String  _name = null;



    /**
     * Constructor.
     */
    private Datatype(
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
// Datatype
