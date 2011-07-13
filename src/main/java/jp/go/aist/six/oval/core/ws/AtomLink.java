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

package jp.go.aist.six.oval.core.ws;

import java.io.Serializable;



/**
 * A helper class for feeds.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class AtomLink
    implements Serializable
{

    private String  _href;
    //attribute {1..1, atomUri}

    private String  _rel;
    //attribute {0..1}

    private String  _type;
    //{0..1, MIME media type}

    private String  _title;
    //{0..1}



    /**
     * Constructor.
     */
    public AtomLink()
    {
    }



    /**
     */
    public void setHref(
                    final String href
                    )
    {
        this._href = href;
    }


    public String getHref()
    {
        return _href;
    }



    /**
     */
    public void setRel(
                    final String rel
                    )
    {
        this._rel = rel;
    }


    public String getRel()
    {
        return _rel;
    }



    /**
     */
    public void setType(
                    final String type
                    )
    {
        this._type = type;
    }


    public String getType()
    {
        return _type;
    }



    /**
     */
    public void setTitle(
                    final String title
                    )
    {
        this._title = title;
    }


    public String getTitle()
    {
        return _title;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "AtomLink[href=" + getHref()
             + ", rel=" + getRel()
             + ", type=" + getType()
             + ", title=" + getTitle()
             + "]"
             ;
    }

}
// AtomFeed
