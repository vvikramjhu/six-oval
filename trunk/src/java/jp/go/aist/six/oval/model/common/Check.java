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

package jp.go.aist.six.oval.model.common;

import java.io.Serializable;
import java.util.HashMap;



/**
 * The Check defines acceptable check values,
 * which are used to determine the final result of something
 * based on the results of individual components.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class Check
    implements Serializable
{

    private static final String  _ALL_           = "all";
    private static final String  _AT_LEAST_ONE_  = "at least one";
    private static final String  _NONE_EXIST_    = "none exist";
    private static final String  _NONE_SATISFY_  = "none satisfy";
    private static final String  _ONLY_ONE_      = "only one";


    public static final Check  ALL           = new Check( _ALL_ );
    public static final Check  AT_LEAST_ONE  = new Check( _AT_LEAST_ONE_ );
    public static final Check  NONE_EXIST    = new Check( _NONE_EXIST_ );
    public static final Check  NONE_SATISFY  = new Check( _NONE_SATISFY_ );
    public static final Check  ONLY_ONE      = new Check( _ONLY_ONE_ );



    private static HashMap<String, Check> _INIT_()
    {
        HashMap<String, Check>  map = new HashMap<String, Check>();
        map.put( _ALL_,          ALL          );
        map.put( _AT_LEAST_ONE_, AT_LEAST_ONE );
        map.put( _NONE_EXIST_,   NONE_EXIST   );
        map.put( _NONE_SATISFY_, NONE_SATISFY );
        map.put( _ONLY_ONE_,     ONLY_ONE     );
        return map;
    }

    private static final HashMap<String, Check>  _INSTANCES_ = _INIT_();




    /**
     */
    public static Check valueOf(
                    final String name
                    )
    {
        Check  flag = null;
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
    private Check(
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



    ////////////////////////////////////////////////////////////////
    //  java.lang.Object
    ////////////////////////////////////////////////////////////////

    @Override
    public String toString()
    {
        return getName();
    }

}
// Check
