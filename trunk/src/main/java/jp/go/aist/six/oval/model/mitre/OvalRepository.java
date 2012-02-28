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

package jp.go.aist.six.oval.model.mitre;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.AffectedCpeList;
import jp.go.aist.six.oval.model.definitions.MetadataItem;



/**
 * A history of the OVAL Definition in the Mitre's OVAL repository.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class OvalRepository
    extends MetadataItem
{

    private final Collection<Event>  dates = new ArrayList<Event>();

    private DefinitionStatusEnumeration  status;


//    @Transient
    private AffectedCpeList  affected_cpe_list;



    /**
     * Constructor.
     */
    public OvalRepository()
    {
    }



    /**
     */
    public void setDates(
                    final Collection<? extends Event> events
                    )
    {
        if (events != dates) {
            dates.clear();
            if (events != null  &&  events.size() > 0) {
                dates.addAll( events );
            }
        }
    }


    public Collection<Event> getDates()
    {
        return dates;
    }


    public Iterator<Event> iterateDates()
    {
        return dates.iterator();
    }


    public OvalRepository date(
                    final Event event
                    )
    {
        dates.add( event );
        return this;
    }



    /**
     */
    public void setStatus(
                    final DefinitionStatusEnumeration status
                    )
    {
        this.status = status;
    }


    public DefinitionStatusEnumeration getStatus()
    {
        return status;
    }


    public OvalRepository status(
                    final DefinitionStatusEnumeration status
                    )
    {
        setStatus( status );
        return this;
    }



    /**
     */
    public void setAffectedCpeList(
                    final AffectedCpeList affectedCpeList
                    )
    {
        affected_cpe_list = affectedCpeList;
    }



    public AffectedCpeList getAffectedCpeList()
    {
        return affected_cpe_list;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "oval_repository[status=" + getStatus()
                        + ", dates=" + getDates()
                        + ", affected_cpe_list=" + getAffectedCpeList()
                        + "]";
    }

}
//OvalRepository
