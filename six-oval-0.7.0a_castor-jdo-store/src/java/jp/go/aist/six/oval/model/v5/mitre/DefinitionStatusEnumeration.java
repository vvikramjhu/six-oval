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

package jp.go.aist.six.oval.model.v5.mitre;

import java.io.Serializable;
import java.util.HashMap;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class DefinitionStatusEnumeration
    implements Serializable
{

    private static final String  _DRAFT_      = "DRAFT";
    private static final String  _INTERIM_    = "INTERIM";
    private static final String  _ACCEPTED_   = "ACCEPTED";
    private static final String  _DEPRECATED_ = "DEPRECATED";


    public static final DefinitionStatusEnumeration  DRAFT      = new DefinitionStatusEnumeration( _DRAFT_ );
    public static final DefinitionStatusEnumeration  INTERIM    = new DefinitionStatusEnumeration( _INTERIM_ );
    public static final DefinitionStatusEnumeration  ACCEPTED   = new DefinitionStatusEnumeration( _ACCEPTED_ );
    public static final DefinitionStatusEnumeration  DEPRECATED = new DefinitionStatusEnumeration( _DEPRECATED_ );



    private static HashMap<String, DefinitionStatusEnumeration> _INIT_()
    {
        HashMap<String, DefinitionStatusEnumeration>  map = new HashMap<String, DefinitionStatusEnumeration>();
        map.put( _DRAFT_,      DRAFT    );
        map.put( _INTERIM_,    INTERIM  );
        map.put( _ACCEPTED_,   ACCEPTED );
        map.put( _DEPRECATED_, DEPRECATED );
        return map;
    }

    private static final HashMap<String, DefinitionStatusEnumeration>  _INSTANCES_ = _INIT_();




    /**
     */
    public static DefinitionStatusEnumeration valueOf(
                    final String name
                    )
    {
        DefinitionStatusEnumeration  flag = null;
        if (name != null) {
            flag = _INSTANCES_.get( name );
        }

        if (flag == null) {
            throw new IllegalArgumentException( "invalid definition status: " + name );
        }

        return flag;
    }



    private String  _name = null;



    /**
     */
    private DefinitionStatusEnumeration(
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
// DefinitionStatusEnumeration
