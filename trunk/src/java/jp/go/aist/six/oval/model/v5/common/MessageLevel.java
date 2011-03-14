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

package jp.go.aist.six.oval.model.v5.common;

import java.io.Serializable;
import java.util.HashMap;



/**
 * The MessageLevel enumeration type defines the different levels
 * associated with a message.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class MessageLevel
    implements Serializable
{

    private static final String  _DEBUG_    = "debug";
    private static final String  _ERROR_    = "error";
    private static final String  _FATAL_    = "fatal";
    private static final String  _INFO_     = "info";
    private static final String  _WARNING_  = "warning";


    public static final MessageLevel  DEBUG    = new MessageLevel( _DEBUG_ );
    public static final MessageLevel  ERROR    = new MessageLevel( _ERROR_ );
    public static final MessageLevel  FATAL    = new MessageLevel( _FATAL_ );
    public static final MessageLevel  INFO     = new MessageLevel( _INFO_ );
    public static final MessageLevel  WARNING  = new MessageLevel( _WARNING_ );



    private static HashMap<String, MessageLevel> _INIT_()
    {
        HashMap<String, MessageLevel>  map = new HashMap<String, MessageLevel>();
        map.put( _DEBUG_,   DEBUG );
        map.put( _ERROR_,   ERROR );
        map.put( _FATAL_,   FATAL );
        map.put( _INFO_,    INFO );
        map.put( _WARNING_, WARNING );
        return map;
    }

    private static final HashMap<String, MessageLevel>  _INSTANCES_ = _INIT_();




    /**
     */
    public static MessageLevel valueOf(
                    final String name
                    )
    {
        MessageLevel  flag = null;
        if (name != null) {
            flag = _INSTANCES_.get( name );
        }

        if (flag == null) {
            throw new IllegalArgumentException( "invalid message level: " + name );
        }

        return flag;
    }



    private String  _name = null;



    /**
     * Constructor.
     */
    private MessageLevel(
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
// MessageLevel
