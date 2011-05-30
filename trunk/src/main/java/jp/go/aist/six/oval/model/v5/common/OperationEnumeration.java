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

import jp.go.aist.six.oval.model.v5.OvalEnumeration;



/**
 * The Operation enumeration type defines acceptable operations.
 * Each operation defines how to compare entities against their actual values.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum OperationEnumeration
    implements OvalEnumeration
{

    EQUALS                      ( "equals" ),
    NOT_EQUAL                   ( "not equal" ),
    CASE_INSENSITIVE_EQUALS     ( "case insensitive equals" ),
    CASE_INSENSITIVE_NOT_EQUAL  ( "case insensitive not equal" ),
    GREATER_THAN                ( "greater than" ),
    LESS_THAN                   ( "less than" ),
    GREATER_THAN_OR_EQUAL       ( "greater than or equal" ),
    LESS_THAN_OR_EQUAL          ( "less than or equal" ),
    BITWISE_AND                 ( "bitwise and" ),
    BITWISE_OR                  ( "bitwise or" ),
    PATTERN_MATCH               ( "pattern match" ),
    SUBSET_OF                   ( "subset of" ),
    SUPERSET_OF                 ( "superset of" );


    /**
     * A factory method.
     */
    public static OperationEnumeration fromValue(
                    final String value
                    )
    {
        for (OperationEnumeration  e : OperationEnumeration.values()) {
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
    OperationEnumeration(
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
// OperationEnumeration
