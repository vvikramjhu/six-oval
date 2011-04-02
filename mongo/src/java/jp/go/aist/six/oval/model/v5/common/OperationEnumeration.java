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
 * The Operation enumeration type defines acceptable operations.
 * Each operation defines how to compare entities against their actual values.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum OperationEnumeration
{

    EQUALS(                     "equals" ),
    NOT_EQUAL(                  "not equal" ),
    CASE_INSENSITIVE_EQUALS(    "case insensitive equals" ),
    CASE_INSENSITIVE_NOT_EQUAL( "case insensitive not equal" ),
    GREATER_THAN(               "greater than" ),
    LESS_THAN(                  "less than" ),
    GREATER_THAN_OR_EQUAL(      "greater than or equal"  ),
    LESS_THAN_OR_EQUAL(         "less than or equal" ),
    BITWISE_AND(                "bitwise and" ),
    BITWISE_OR(                 "bitwise or" ),
    PATTERN_MATCH(              "pattern match" ),
    SUBSET_OF(                  "subset of" ),
    SUPERSET_OF(                "superset of" );



    /**
     */
    public static OperationEnumeration fromValue(
                    final String value
                    )
    {
        for (OperationEnumeration  e: OperationEnumeration.values()) {
            if (e._value.equals( value )) {
                return e;
            }
        }
        throw new IllegalArgumentException( value );
    }



    private final String  _value;



    OperationEnumeration(
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


//    private static final String  _EQUALS_                      = "equals";
//    private static final String  _NOT_EQUAL_                   = "not equal";
//    private static final String  _CASE_INSENSITIVE_EQUALS_     = "case insensitive equals";
//    private static final String  _CASE_INSENSITIVE_NOT_EQUAL_  = "case insensitive not equal";
//    private static final String  _GREATER_THAN_                = "greater than";
//    private static final String  _LESS_THAN_                   = "less than";
//    private static final String  _GREATER_THAN_OR_EQUAL_       = "greater than or equal";
//    private static final String  _LESS_THAN_OR_EQUAL_          = "less than or equal";
//    private static final String  _BITWISE_AND_                 = "bitwise and";
//    private static final String  _BITWISE_OR_                  = "bitwise or";
//    private static final String  _PATTERN_MATCH_               = "pattern match";
//    private static final String  _SUBSET_OF_                   = "subset of";
//    private static final String  _SUPERSET_OF_                 = "superset of";
//
//
//    public static final OperationEnumeration  EQUALS                      = new OperationEnumeration( _EQUALS_ );
//    public static final OperationEnumeration  NOT_EQUAL                   = new OperationEnumeration( _NOT_EQUAL_ );
//    public static final OperationEnumeration  CASE_INSENSITIVE_EQUALS     = new OperationEnumeration( _CASE_INSENSITIVE_EQUALS_ );
//    public static final OperationEnumeration  CASE_INSENSITIVE_NOT_EQUAL  = new OperationEnumeration( _CASE_INSENSITIVE_NOT_EQUAL_ );
//    public static final OperationEnumeration  GREATER_THAN                = new OperationEnumeration( _GREATER_THAN_ );
//    public static final OperationEnumeration  LESS_THAN                   = new OperationEnumeration( _LESS_THAN_ );
//    public static final OperationEnumeration  GREATER_THAN_OR_EQUAL       = new OperationEnumeration( _GREATER_THAN_OR_EQUAL_ );
//    public static final OperationEnumeration  LESS_THAN_OR_EQUAL          = new OperationEnumeration( _LESS_THAN_OR_EQUAL_ );
//    public static final OperationEnumeration  BITWISE_AND                 = new OperationEnumeration( _BITWISE_AND_ );
//    public static final OperationEnumeration  BITWISE_OR                  = new OperationEnumeration( _BITWISE_OR_ );
//    public static final OperationEnumeration  PATTERN_MATCH               = new OperationEnumeration( _PATTERN_MATCH_ );
//    public static final OperationEnumeration  SUBSET_OF                   = new OperationEnumeration( _SUBSET_OF_ );
//    public static final OperationEnumeration  SUPERSET_OF                 = new OperationEnumeration( _SUPERSET_OF_ );
//
//
//
//    private static HashMap<String, OperationEnumeration> _INIT_()
//    {
//        HashMap<String, OperationEnumeration>  map = new HashMap<String, OperationEnumeration>();
//        map.put( _EQUALS_,                      EQUALS                     );
//        map.put( _NOT_EQUAL_,                   NOT_EQUAL                  );
//        map.put( _CASE_INSENSITIVE_EQUALS_,     CASE_INSENSITIVE_EQUALS    );
//        map.put( _CASE_INSENSITIVE_NOT_EQUAL_,  CASE_INSENSITIVE_NOT_EQUAL );
//        map.put( _GREATER_THAN_,                GREATER_THAN               );
//        map.put( _LESS_THAN_,                   LESS_THAN                  );
//        map.put( _GREATER_THAN_OR_EQUAL_,       GREATER_THAN_OR_EQUAL      );
//        map.put( _LESS_THAN_OR_EQUAL_,          LESS_THAN_OR_EQUAL         );
//        map.put( _BITWISE_AND_,                 BITWISE_AND                );
//        map.put( _BITWISE_OR_,                  BITWISE_OR                 );
//        map.put( _PATTERN_MATCH_,               PATTERN_MATCH              );
//        map.put( _SUBSET_OF_,                   SUBSET_OF                  );
//        map.put( _SUPERSET_OF_,                 SUPERSET_OF                );
//        return map;
//    }
//
//    private static final HashMap<String, OperationEnumeration>  _INSTANCES_ = _INIT_();
//
//
//
//
//    /**
//     */
//    public static OperationEnumeration valueOf(
//                    final String name
//                    )
//    {
//        OperationEnumeration  flag = null;
//        if (name != null) {
//            flag = _INSTANCES_.get( name );
//        }
//
//        if (flag == null) {
//            throw new IllegalArgumentException( "invalid operation: " + name );
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
//     * Constrcutor.
//     */
//    private OperationEnumeration(
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
//    //  java.lang.Object
//    //**************************************************************
//
//    @Override
//    public String toString()
//    {
//        return getName();
//    }

}
// OperationEnumeration
