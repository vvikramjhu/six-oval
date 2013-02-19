/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.go.aist.six.oval.model.independent;

import jp.go.aist.six.oval.model.OvalEnumeration;



/**
 * The types of information that an LDAP attribute can represent.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum LdaptypeEnumeration
    implements OvalEnumeration
{

    LDAPTYPE_ATTRIBUTE_TYPE_DESCRIP_STRING  ( "LDAPTYPE_ATTRIBUTE_TYPE_DESCRIP_STRING" ),
    LDAPTYPE_DN_STRING          ( "LDAPTYPE_DN_STRING" ),
    LDAPTYPE_BIT_STRING         ( "LDAPTYPE_BIT_STRING" ),
    LDAPTYPE_PRINTABLE_STRING   ( "LDAPTYPE_PRINTABLE_STRING" ),
    LDAPTYPE_NUMERIC_STRING     ( "LDAPTYPE_NUMERIC_STRING" ),
    LDAPTYPE_BOOLEAN            ( "LDAPTYPE_BOOLEAN" ),
    LDAPTYPE_INTEGER            ( "LDAPTYPE_INTEGER" ),
    LDAPTYPE_UTC_TIME           ( "LDAPTYPE_UTC_TIME" ),
    LDAPTYPE_GENERALIZED_TIME   ( "LDAPTYPE_GENERALIZED_TIME" ),
    LDAPTYPE_DIRECTORY_STRING   ( "LDAPTYPE_DIRECTORY_STRING" ),
    LDAPTYPE_OBJECT_CLASS_DESCRIP_STRING    ( "LDAPTYPE_OBJECT_CLASS_DESCRIP_STRING" ),
    LDAPTYPE_BINARY             ( "LDAPTYPE_BINARY" ),
    LDAPTYPE_TIMESTAMP          ( "LDAPTYPE_TIMESTAMP" ),
    LDAPTYPE_EMAIL              ( "LDAPTYPE_EMAIL" ),
    EMPTY ( "" )
    ;



    /**
     * A factory method.
     */
    public static LdaptypeEnumeration fromValue(
                    final String value
                    )
    {
        for (LdaptypeEnumeration  e : LdaptypeEnumeration.values()) {
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
    LdaptypeEnumeration(
                    final String value
                    )
    {
        this.value = value;
    }



    public String value()
    {
        return value;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return value;
    }

}
// LdaptypeEnumeration
