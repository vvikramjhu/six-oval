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



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Modified
    extends Event
{

    private String  comment;


    private Contributor  contributor;
    //{0..1}



    /**
     * Constructor.
     */
    public Modified()
    {
    }


    public Modified(
                    final String date,
                    final String comment
                    )
    {
        super( date );
        setComment( comment );
    }


    public Modified(
                    final String date,
                    final String comment,
                    final Contributor contributor
                    )
    {
        super( date );
        setComment( comment );
        setContributor( contributor );
    }



    /**
     */
    public void setComment(
                    final String comment
                    )
    {
        this.comment = comment;
    }


    public String getComment()
    {
        return this.comment;
    }



    /**
     */
    public void setContributor(
                    final Contributor contributor
                    )
    {
        this.contributor = contributor;
    }


    public Contributor getContributor()
    {
        return this.contributor;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "modified[date=" + getDate()
                        + ", comment=" + getComment()
                        + ", contributor=" + getContributor()
                        + "]";
    }

}
// Modified
