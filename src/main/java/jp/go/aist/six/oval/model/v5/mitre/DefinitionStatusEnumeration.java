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

package jp.go.aist.six.oval.model.v5.mitre;

import jp.go.aist.six.oval.model.v5.Oval5Enumeration;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum DefinitionStatusEnumeration
    implements Oval5Enumeration
{

    DRAFT      ( "DRAFT" ),
    INTERIM    ( "INTERIM" ),
    ACCEPTED   ( "ACCEPTED" ),
    DEPRECATED ( "DEPRECATED" );



    /**
     * A factory method.
     */
    public static DefinitionStatusEnumeration fromValue(
                    final String value
                    )
    {
        for (DefinitionStatusEnumeration  e : DefinitionStatusEnumeration.values()) {
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
    DefinitionStatusEnumeration(
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
// DefinitionStatusEnumeration
