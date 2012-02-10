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

package jp.go.aist.six.oval.model.independent;

import jp.go.aist.six.oval.model.OvalEnumeration;



/**
 * The types of information that an LDAP attribute can represent.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum LdapTypeEnumeration
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
    public static LdapTypeEnumeration fromValue(
                    final String value
                    )
    {
        for (LdapTypeEnumeration  e : LdapTypeEnumeration.values()) {
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
    LdapTypeEnumeration(
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
// LdaptypeEnumeration
