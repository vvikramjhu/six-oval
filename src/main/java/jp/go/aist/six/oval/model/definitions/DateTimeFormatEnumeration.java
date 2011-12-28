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

package jp.go.aist.six.oval.model.definitions;

import jp.go.aist.six.oval.model.OvalEnumeration;



/**
 * The DateTimeFormatEnumeration defines the different date-time formats
 * that are understood by OVAL.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum DateTimeFormatEnumeration
    implements OvalEnumeration
{

    YEAR_MONTH_DAY      ( "year_month_day" ),
    MONTH_DAY_YEAR      ( "month_day_year" ),
    DAY_MONTH_YEAR      ( "day_month_year" ),
    WIN_FILETIME        ( "win_filetime" ),
    SECONDS_SINCE_EPOCH ( "seconds_since_epoch" )
    ;



    /**
     * A factory method.
     */
    public static DateTimeFormatEnumeration fromValue(
                    final String value
                    )
    {
        for (DateTimeFormatEnumeration  e : DateTimeFormatEnumeration.values()) {
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
    DateTimeFormatEnumeration(
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
//DateTimeFormatEnumeration