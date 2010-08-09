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

package jp.go.aist.six.oval.model.linux;

import java.io.Serializable;
import java.util.HashMap;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public final class Severity
    implements Serializable
{

    private static final String  _LOW_        = "Low";
    private static final String  _MODERATE_   = "Moderate";
    private static final String  _IMPORTANT_  = "Important";
    private static final String  _CRITICAL_   = "Critical";


    public static final Severity  LOW        = new Severity( _LOW_       );
    public static final Severity  MODERATE   = new Severity( _MODERATE_  );
    public static final Severity  IMPORTANT  = new Severity( _IMPORTANT_ );
    public static final Severity  CRITICAL   = new Severity( _CRITICAL_  );



    private static HashMap<String, Severity> _INIT_()
    {
        HashMap<String, Severity>  map = new HashMap<String, Severity>();
        map.put( _LOW_,       LOW       );
        map.put( _MODERATE_,  MODERATE  );
        map.put( _IMPORTANT_, IMPORTANT );
        map.put( _CRITICAL_,  CRITICAL  );
        return map;
    }

    private static final HashMap<String, Severity>  _INSTANCES_ = _INIT_();




    /**
     */
    public static Severity valueOf( final String name )
    {
        Severity  flag = null;
        if (name != null) {
            flag = _INSTANCES_.get( name );
        }

        if (flag == null) {
            throw new IllegalArgumentException( "invalid severity: " + name );
        }

        return flag;
    }



    private String  _name = null;



    /**
     */
    private Severity(
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
// Severity
