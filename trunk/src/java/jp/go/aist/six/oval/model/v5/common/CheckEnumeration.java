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
 * The Check enumeration type defines acceptable check values,
 * which are used to determine the final result of something
 * based on the results of individual components.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class CheckEnumeration
    implements Serializable
{

    private static final String  _ALL_           = "all";
    private static final String  _AT_LEAST_ONE_  = "at least one";
    private static final String  _NONE_EXIST_    = "none exist";
    private static final String  _NONE_SATISFY_  = "none satisfy";
    private static final String  _ONLY_ONE_      = "only one";


    public static final CheckEnumeration  ALL           = new CheckEnumeration( _ALL_ );
    public static final CheckEnumeration  AT_LEAST_ONE  = new CheckEnumeration( _AT_LEAST_ONE_ );
    public static final CheckEnumeration  NONE_EXIST    = new CheckEnumeration( _NONE_EXIST_ );
    public static final CheckEnumeration  NONE_SATISFY  = new CheckEnumeration( _NONE_SATISFY_ );
    public static final CheckEnumeration  ONLY_ONE      = new CheckEnumeration( _ONLY_ONE_ );



    private static HashMap<String, CheckEnumeration> _INIT_()
    {
        HashMap<String, CheckEnumeration>  map = new HashMap<String, CheckEnumeration>();
        map.put( _ALL_,          ALL          );
        map.put( _AT_LEAST_ONE_, AT_LEAST_ONE );
        map.put( _NONE_EXIST_,   NONE_EXIST   );
        map.put( _NONE_SATISFY_, NONE_SATISFY );
        map.put( _ONLY_ONE_,     ONLY_ONE     );
        return map;
    }

    private static final HashMap<String, CheckEnumeration>  _INSTANCES_ = _INIT_();




    /**
     */
    public static CheckEnumeration valueOf(
                    final String name
                    )
    {
        CheckEnumeration  flag = null;
        if (name != null) {
            flag = _INSTANCES_.get( name );
        }

        if (flag == null) {
            throw new IllegalArgumentException( "invalid check: " + name );
        }

        return flag;
    }




    private String  _name = null;



    /**
     * Constructor.
     */
    private CheckEnumeration(
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
// CheckEnumeration
