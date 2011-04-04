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
 * The Datatype enumeration type defines the legal datatypes
 * that are used to describe the values of individual entities.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum DatatypeEnumeration
{
    BINARY( "binary" ),
    BOOLEAN( "boolean" ),
    EVR_STRING( "evr_string" ),
    FILESET_REVISION( "fileset_revision" ),
    FLOAT( "float" ),
    IOS_VERSION( "ios_version" ),
    INT( "int" ),
    IPV4_ADDRESS( "ipv4_address" ),
    IPV6_ADDRESS( "ipv6_address" ),
    STRING( "string" ),
    VERSION( "version" ),

    RECORD( "record" );



    private final String  _value;



    DatatypeEnumeration(
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
    public static DatatypeEnumeration fromValue(
                    final String value
                    )
    {
        for (DatatypeEnumeration  e: DatatypeEnumeration.values()) {
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


//    private static final String  _BINARY_           = "binary";
//    private static final String  _BOOLEAN_          = "boolean";
//    private static final String  _EVR_STRING_       = "evr_string";
//    private static final String  _FILESET_REVISION_ = "fileset_revision";
//    private static final String  _FLOAT_            = "float";
//    private static final String  _IOS_VERSION_      = "ios_version";
//    private static final String  _INT_              = "int";
//    private static final String  _IPV4_ADDRESS_     = "ipv4_address";
//    private static final String  _IPV6_ADDRESS_     = "ipv6_address";
//    private static final String  _STRING_           = "string";
//    private static final String  _VERSION_          = "version";
//
//    private static final String  _RECORD_           = "record";
//
//
//    public static final DatatypeEnumeration  BINARY            = new DatatypeEnumeration( _BINARY_ );
//    public static final DatatypeEnumeration  BOOLEAN           = new DatatypeEnumeration( _BOOLEAN_ );
//    public static final DatatypeEnumeration  EVR_STRING        = new DatatypeEnumeration( _EVR_STRING_ );
//    public static final DatatypeEnumeration  FILESET_REVISION  = new DatatypeEnumeration( _FILESET_REVISION_ );
//    public static final DatatypeEnumeration  FLOAT             = new DatatypeEnumeration( _FLOAT_ );
//    public static final DatatypeEnumeration  IOS_VERSION       = new DatatypeEnumeration( _IOS_VERSION_ );
//    public static final DatatypeEnumeration  INT               = new DatatypeEnumeration( _INT_ );
//    public static final DatatypeEnumeration  IPV4_ADDRESS      = new DatatypeEnumeration( _IPV4_ADDRESS_ );
//    public static final DatatypeEnumeration  IPV6_ADDRESS      = new DatatypeEnumeration( _IPV6_ADDRESS_ );
//    public static final DatatypeEnumeration  STRING            = new DatatypeEnumeration( _STRING_ );
//    public static final DatatypeEnumeration  VERSION           = new DatatypeEnumeration( _VERSION_ );
//
//    public static final DatatypeEnumeration  RECORD            = new DatatypeEnumeration( _RECORD_ );
//
//
//
//    private static HashMap<String, DatatypeEnumeration> _INIT_()
//    {
//        HashMap<String, DatatypeEnumeration>  map = new HashMap<String, DatatypeEnumeration>();
//        map.put( _BINARY_,            BINARY           );
//        map.put( _BOOLEAN_,           BOOLEAN          );
//        map.put( _EVR_STRING_,        EVR_STRING       );
//        map.put( _FILESET_REVISION_,  FILESET_REVISION );
//        map.put( _FLOAT_,             FLOAT            );
//        map.put( _IOS_VERSION_,       IOS_VERSION      );
//        map.put( _INT_,               INT              );
//        map.put( _IPV4_ADDRESS_,      IPV4_ADDRESS     );
//        map.put( _IPV6_ADDRESS_,      IPV6_ADDRESS     );
//        map.put( _STRING_,            STRING           );
//        map.put( _VERSION_,           VERSION          );
//        map.put( _RECORD_,            RECORD           );
//        return map;
//    }
//
//    private static final HashMap<String, DatatypeEnumeration>  _INSTANCES_ = _INIT_();
//
//
//
//
//    /**
//     */
//    public static DatatypeEnumeration valueOf(
//                    final String name
//                    )
//    {
//        DatatypeEnumeration  flag = null;
//        if (name != null) {
//            flag = _INSTANCES_.get( name );
//        }
//
//        if (flag == null) {
//            throw new IllegalArgumentException( "invalid datatype: " + name );
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
//    private DatatypeEnumeration(
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
//    /**
//     */
//    public boolean isSimple()
//    {
//        return ((this == RECORD) ? false : true);
//    }
//
//
//
//    /**
//     */
//    public boolean isComplex()
//    {
//        return !isSimple();
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
// DatatypeEnumeration
