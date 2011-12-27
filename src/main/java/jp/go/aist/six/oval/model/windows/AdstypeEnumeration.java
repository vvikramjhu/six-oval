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

package jp.go.aist.six.oval.model.windows;

import jp.go.aist.six.oval.model.OvalEnumeration;



/**
 * The different types of information that an active directory attribute can represents.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum AdstypeEnumeration
    implements OvalEnumeration
{

    ADSTYPE_INVALID                 ( "ADSTYPE_INVALID" ),
    ADSTYPE_DN_STRING               ( "ADSTYPE_DN_STRING" ),
    ADSTYPE_CASE_EXACT_STRING       ( "ADSTYPE_CASE_EXACT_STRING" ),
    ADSTYPE_CASE_IGNORE_STRING      ( "ADSTYPE_CASE_IGNORE_STRING" ),
    ADSTYPE_PRINTABLE_STRING        ( "ADSTYPE_PRINTABLE_STRING" ),
    ADSTYPE_NUMERIC_STRING          ( "ADSTYPE_NUMERIC_STRING" ),
    ADSTYPE_BOOLEAN                 ( "ADSTYPE_BOOLEAN" ),
    ADSTYPE_INTEGER                 ( "ADSTYPE_INTEGER" ),
    ADSTYPE_OCTET_STRING            ( "ADSTYPE_OCTET_STRING" ),
    ADSTYPE_UTC_TIME                ( "ADSTYPE_UTC_TIME" ),
    ADSTYPE_LARGE_INTEGER           ( "ADSTYPE_LARGE_INTEGER" ),
    ADSTYPE_PROV_SPECIFIC           ( "ADSTYPE_PROV_SPECIFIC" ),
    ADSTYPE_OBJECT_CLASS            ( "ADSTYPE_OBJECT_CLASS" ),
    ADSTYPE_CASEIGNORE_LIST         ( "ADSTYPE_CASEIGNORE_LIST" ),
    ADSTYPE_OCTET_LIST              ( "ADSTYPE_OCTET_LIST" ),
    ADSTYPE_PATH                    ( "ADSTYPE_PATH" ),
    ADSTYPE_POSTALADDRESS           ( "ADSTYPE_POSTALADDRESS" ),
    ADSTYPE_TIMESTAMP               ( "ADSTYPE_TIMESTAMP" ),
    ADSTYPE_BACKLINK                ( "ADSTYPE_BACKLINK" ),
    ADSTYPE_TYPEDNAME               ( "ADSTYPE_TYPEDNAME" ),
    ADSTYPE_HOLD                    ( "ADSTYPE_HOLD" ),
    ADSTYPE_NETADDRESS              ( "ADSTYPE_NETADDRESS" ),
    ADSTYPE_REPLICAPOINTER          ( "ADSTYPE_REPLICAPOINTER" ),
    ADSTYPE_FAXNUMBER               ( "ADSTYPE_FAXNUMBER" ),
    ADSTYPE_EMAIL                   ( "ADSTYPE_EMAIL" ),
    ADSTYPE_NT_SECURITY_DESCRIPTOR  ( "ADSTYPE_NT_SECURITY_DESCRIPTOR" ),
    ADSTYPE_UNKNOWN                 ( "ADSTYPE_UNKNOWN" ),
    ADSTYPE_DN_WITH_BINARY          ( "ADSTYPE_DN_WITH_BINARY" ),
    ADSTYPE_DN_WITH_STRING          ( "ADSTYPE_DN_WITH_STRING" )
    ;



    /**
     * A factory method.
     */
    public static AdstypeEnumeration fromValue(
                    final String value
                    )
    {
        for (AdstypeEnumeration  e : AdstypeEnumeration.values()) {
            if (e.value.equals( value )) {
                return e;
            }
        }

        throw new IllegalArgumentException( value );
    }



    private String  value = null;



    /**
     * Constructor.
     */
    AdstypeEnumeration(
                    final String value
                    )
    {
        this.value = value;
    }



    @Override
    public String value()
    {
        return this.value;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return this.value;
    }

}
//AdstypeEnumeration
