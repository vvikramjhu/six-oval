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




/**
 * The Operator enumeration type defines acceptable operators.
 * Each operator defines how to evaluate multiple arguments.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum OperatorEnumeration
{
    AND( "AND" ),
    ONE( "ONE" ),
    OR( "OR" ),
    XOR( "XOR" );



    /**
     */
    public static OperatorEnumeration fromValue(
                    final String value
                    )
    {
        for (OperatorEnumeration  e: OperatorEnumeration.values()) {
            if (e._value.equals( value )) {
                return e;
            }
        }
        throw new IllegalArgumentException( value );
    }



    private final String  _value;



    OperatorEnumeration(
                    final String value
                    )
    {
        _value = value;
    }



    public String value()
    {
        return _value;
    }



    @Override
    public String toString()
    {
        return _value;
    }



//    private static final String  _AND_  = "AND";
//    private static final String  _ONE_  = "ONE";
//    private static final String  _OR_   = "OR";
//    private static final String  _XOR_  = "XOR";
//
//
//    public static final OperatorEnumeration  AND = new OperatorEnumeration( _AND_ );
//    public static final OperatorEnumeration  ONE = new OperatorEnumeration( _ONE_ );
//    public static final OperatorEnumeration  OR  = new OperatorEnumeration( _OR_ );
//    public static final OperatorEnumeration  XOR = new OperatorEnumeration( _XOR_ );
//
//
//
//    private static HashMap<String, OperatorEnumeration> _INIT_()
//    {
//        HashMap<String, OperatorEnumeration>  map = new HashMap<String, OperatorEnumeration>();
//        map.put( _AND_,  AND );
//        map.put( _ONE_,  ONE );
//        map.put( _OR_,   OR  );
//        map.put( _XOR_,  XOR );
//        return map;
//    }
//
//    private static final HashMap<String, OperatorEnumeration>  _INSTANCES_ = _INIT_();
//
//
//
//
//    /**
//     */
//    public static OperatorEnumeration valueOf(
//                    final String name
//                    )
//    {
//        OperatorEnumeration  flag = null;
//        if (name != null) {
//            flag = _INSTANCES_.get( name );
//        }
//
//        if (flag == null) {
//            throw new IllegalArgumentException( "invalid operator: " + name );
//        }
//
//        return flag;
//    }
//
//
//
//    private String  _name = null;
//
//
//
//    /**
//     * Constructor.
//     */
//    private OperatorEnumeration(
//                    final String name
//                    )
//    {
//        _name = name;
//    }
//
//
//
//    /**
//     */
//    public String getName()
//    {
//        return _name;
//    }
//
//
//
//    //**************************************************************
//    //  extends Object
//    //**************************************************************
//
//    @Override
//    public String toString()
//    {
//        return getName();
//    }

}
// OperatorEnumeration
