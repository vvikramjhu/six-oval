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

package jp.go.aist.six.oval.model.common;

import jp.go.aist.six.oval.model.OvalEnumeration;



/**
 * The Datatype enumeration type defines the legal datatypes
 * that are used to describe the values of individual entities.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum DatatypeEnumeration
    implements OvalEnumeration
{

    BINARY            ( "binary" ),
    BOOLEAN           ( "boolean" ),
    EVR_STRING        ( "evr_string" ),
    FILESET_REVISION  ( "fileset_revision" ),
    FLOAT             ( "float" ),
    IOS_VERSION       ( "ios_version" ),
    INT               ( "int" ),
    IPV4_ADDRESS      ( "ipv4_address" ),
    IPV6_ADDRESS      ( "ipv6_address" ),
    STRING            ( "string" ),
    VERSION           ( "version" ),

    RECORD            ( "record", true );



    /**
     * A factory method.
     */
    public static DatatypeEnumeration fromValue(
                    final String value
                    )
    {
        for (DatatypeEnumeration  e : DatatypeEnumeration.values()) {
            if (e.value.equals( value )) {
                return e;
            }
        }

        throw new IllegalArgumentException( value );
    }



    private String  value = null;
    private boolean  complex = false;



    /**
     * Constructor.
     */
    DatatypeEnumeration(
                    final String value
                    )
    {
        this( value, false );
    }


    DatatypeEnumeration(
                    final String value,
                    final boolean complex
                    )
    {
        this.value = value;
        this.complex = complex;
    }



    @Override
    public String value()
    {
        return this.value;
    }



    /**
     */
    public boolean isComplex()
    {
        return complex;
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
// DatatypeEnumeration
