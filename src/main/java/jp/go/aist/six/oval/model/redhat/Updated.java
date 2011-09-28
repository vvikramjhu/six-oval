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

package jp.go.aist.six.oval.model.redhat;

import jp.go.aist.six.oval.model.OvalObject;



/**
 * A date when a Red Hat security advisory was last updated.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Updated
    implements OvalObject
{

    private String  date;



    /**
     * Constructor.
     */
    public Updated()
    {
    }


    public Updated(
                    final String date
                    )
    {
        setDate( date );
    }



    /**
     */
    public void setDate(
                    final String date
                    )
    {
        this.date = date;
    }


    public String getDate()
    {
        return this.date;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "updated[date=" + getDate()
                        + "]";
    }

}
//Updated
