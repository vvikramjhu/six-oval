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

import jp.go.aist.six.oval.model.Oval5Enumeration;



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
    implements Oval5Enumeration
{

    ALL_EXIST            ( "all_exist" ),
    ANY_EXIST            ( "any_exist" ),
    AT_LEAST_ONE_EXISTS  ( "at_least_one_exists" ),
    NONE_EXIST           ( "none_exist" ),
    ONLY_ONE_EXISTS      ( "only_one_exists" );



    /**
     * A factory method.
     */
    public static ExistenceEnumeration fromValue(
                    final String value
                    )
    {
        for (ExistenceEnumeration  e : ExistenceEnumeration.values()) {
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
    ExistenceEnumeration(
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
// ExistenceEnumeration
