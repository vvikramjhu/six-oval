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

package jp.go.aist.six.oval.model.result;

import java.io.Serializable;
import java.util.HashMap;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public final class Content
    implements Serializable
{

    private static final String  _THIN_ = "thin";
    private static final String  _FULL_ = "full";


    public static final Content  THIN = new Content( _THIN_ );
    public static final Content  FULL = new Content( _FULL_ );



    private static HashMap<String, Content> _INIT_()
    {
        HashMap<String, Content>  map = new HashMap<String, Content>();
        map.put( _THIN_, THIN );
        map.put( _FULL_, FULL );
        return map;
    }

    private static final HashMap<String, Content>  _INSTANCES_ = _INIT_();




    /**
     */
    public static Content valueOf(
                    final String name
                    )
    {
        Content  e = null;
        if (name != null) {
            e = _INSTANCES_.get( name );
        }

        if (e == null) {
            throw new IllegalArgumentException( "invalid result: " + name );
        }

        return e;
    }



    private String  _name = null;



    /**
     */
    private Content(
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
// Content
