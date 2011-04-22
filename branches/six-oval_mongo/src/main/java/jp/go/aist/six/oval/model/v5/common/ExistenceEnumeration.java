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
 * The Existence enumeration type defines acceptable existence values,
 * which are used to determine a result based on the existence
 * of individual components.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum ExistenceEnumeration
{

    ALL_EXIST( "all_exist" ),
    ANY_EXIST( "any_exist" ),
    AT_LEAST_ONE_EXISTS( "at_least_one_exists" ),
    NONE_EXIST( "none_exist" ),
    ONLY_ONE_EXISTS( "only_one_exists" );



    private final String  _value;



    ExistenceEnumeration(
                    final String value
                    )
    {
        _value = value;
    }



    public String value()
    {
        return _value;
    }



    /**
     */
    public static ExistenceEnumeration fromValue(
                    final String value
                    )
    {
        for (ExistenceEnumeration  e: ExistenceEnumeration.values()) {
            if (e._value.equals( value )) {
                return e;
            }
        }
        throw new IllegalArgumentException( value );
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return _value;
    }


//    private static final String  _ALL_EXIST_            = "all_exist";
//    private static final String  _ANY_EXIST_            = "any_exist";
//    private static final String  _AT_LEAST_ONE_EXISTS_  = "at_least_one_exists";
//    private static final String  _NONE_EXIST_           = "none_exist";
//    private static final String  _ONLY_ONE_EXISTS_      = "only_one_exists";
//
//
//    public static final ExistenceEnumeration  ALL_EXIST            = new ExistenceEnumeration( _ALL_EXIST_ );
//    public static final ExistenceEnumeration  ANY_EXIST            = new ExistenceEnumeration( _ANY_EXIST_ );
//    public static final ExistenceEnumeration  AT_LEAST_ONE_EXISTS  = new ExistenceEnumeration( _AT_LEAST_ONE_EXISTS_ );
//    public static final ExistenceEnumeration  NONE_EXIST           = new ExistenceEnumeration( _NONE_EXIST_ );
//    public static final ExistenceEnumeration  ONLY_ONE_EXISTS      = new ExistenceEnumeration( _ONLY_ONE_EXISTS_ );
//
//
//
//    private static HashMap<String, ExistenceEnumeration> _INIT_()
//    {
//        HashMap<String, ExistenceEnumeration>  map = new HashMap<String, ExistenceEnumeration>();
//        map.put( _ALL_EXIST_,           ALL_EXIST           );
//        map.put( _ANY_EXIST_,           ANY_EXIST           );
//        map.put( _AT_LEAST_ONE_EXISTS_, AT_LEAST_ONE_EXISTS );
//        map.put( _NONE_EXIST_,          NONE_EXIST          );
//        map.put( _ONLY_ONE_EXISTS_,     ONLY_ONE_EXISTS     );
//        return map;
//    }
//
//    private static final HashMap<String, ExistenceEnumeration>  _INSTANCES_ = _INIT_();
//
//
//
//
//    /**
//     */
//    public static ExistenceEnumeration valueOf(
//                    final String name
//                    )
//    {
//        ExistenceEnumeration  flag = null;
//        if (name != null) {
//            flag = _INSTANCES_.get( name );
//        }
//
//        if (flag == null) {
//            throw new IllegalArgumentException( "invalid existence: " + name );
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
//    private ExistenceEnumeration(
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
// ExistenceEnumeration
