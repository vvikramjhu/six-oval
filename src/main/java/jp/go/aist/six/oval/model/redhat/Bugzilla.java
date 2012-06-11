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
 * A reference to a Bugzilla entry.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Bugzilla
    implements OvalObject
{

    private String  id;
    private String  href;
    private String  title;



    /**
     * Constructor.
     */
    public Bugzilla()
    {
    }


    public Bugzilla(
                    final String id,
                    final String href,
                    final String title
                    )
    {
        setId( id );
        setHref( href );
        setTitle( title );
    }



    /**
     */
    public void setId(
                    final String id
                    )
    {
        this.id = id;
    }


    public String getId()
    {
        return this.id;
    }



    /**
     */
    public void setHref(
                    final String href
                    )
    {
        this.href = href;
    }


    public String getHref()
    {
        return this.href;
    }



    /**
     */
    public void setTitle(
                    final String title
                    )
    {
        this.title = title;
    }


    public String getTitle()
    {
        return this.title;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "bugzilla[id=" + getId()
                        + ", href=" + getHref()
                        + ", title=" + getTitle()
                        + "]";
    }

}
//Bugzilla
