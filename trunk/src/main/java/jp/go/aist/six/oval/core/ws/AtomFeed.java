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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;



/**
 * A helper class for feeds.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class AtomFeed
    implements Serializable
{

    public static final String  NAMESPACE = "http://www.w3.org/2005/Atom";


    private String  _id;
    private String  _title;
    private Date  _updated;
    private final List<AtomLink>  _link = new ArrayList<AtomLink>();



    /**
     * Constructor.
     */
    public AtomFeed()
    {
    }



    /**
     */
    public void setId(
                    final String id
                    )
    {
        this._id = id;
    }


    public String getId()
    {
        return _id;
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



    /**
     */
    public void setUpdated(
                    final Date updated
                    )
    {
        this._updated = updated;
    }


    public Date getUpdated()
    {
        return _updated;
    }


    /**
     *
     */
    public void setLink(
                    final Collection<? extends AtomLink> links
                    )
    {
        if (links != this._link) {
            this._link.clear();
            if (links != null  &&  links.size() > 0) {
                this._link.addAll( links );
            }
        }
    }


    public boolean addLink(
                    final AtomLink link
                    )
    {
        return this._link.add( link );
    }


    public Collection<AtomLink> getLink()
    {
        return this._link;
    }


    public Iterator<AtomLink> iterateLink()
    {
        return this._link.iterator();
    }

}
// AtomFeed
