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
 * The OperatorEnumeration simple type defines acceptable operators.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class Operator
    implements Serializable
{

    private static final String  _AND_  = "AND";
    private static final String  _ONE_  = "ONE";
    private static final String  _OR_   = "OR";
    private static final String  _XOR_  = "XOR";


    public static final Operator  AND = new Operator( _AND_ );
    public static final Operator  ONE = new Operator( _ONE_ );
    public static final Operator  OR  = new Operator( _OR_ );
    public static final Operator  XOR = new Operator( _XOR_ );



    private static HashMap<String, Operator> _INIT_()
    {
        HashMap<String, Operator>  map = new HashMap<String, Operator>();
        map.put( _AND_,  AND );
        map.put( _ONE_,  ONE );
        map.put( _OR_,   OR  );
        map.put( _XOR_,  XOR );
        return map;
    }

    private static final HashMap<String, Operator>  _INSTANCES_ = _INIT_();




    /**
     */
    public static Operator valueOf(
                    final String name
                    )
    {
        Operator  flag = null;
        if (name != null) {
            flag = _INSTANCES_.get( name );
        }

        if (flag == null) {
            throw new IllegalArgumentException( "invalid operator: " + name );
        }

        return flag;
    }



    private String  _name = null;



    /**
     * Constructor.
     */
    private Operator(
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
    //  extends Object
    //**************************************************************

    @Override
    public String toString()
    {
        return getName();
    }

}
// Operator
