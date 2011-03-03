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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.v5.definitions.MetadataItem;



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

    private final Collection<Event>  _event = new ArrayList<Event>();

    private DefinitionStatusEnumeration  _status;



    /**
     * Constructor.
     */
    public OvalRepository()
    {
    }



    /**
     */
    public void setEvent(
                    final Collection<? extends Event> events
                    )
    {
        if (events != _event) {
            _event.clear();
            if (events != null  &&  events.size() > 0) {
                _event.addAll( events );
            }
        }
    }


    public OvalRepository event(
                    final Event event
                    )
    {
        _event.add( event );
        return this;
    }


    public Collection<Event> getEvent()
    {
        return _event;
    }


    public Iterator<Event> iterateEvent()
    {
        return _event.iterator();
    }



    public void setStatus(
                    final DefinitionStatusEnumeration status
                    )
    {
        _status = status;
    }


    public OvalRepository status(
                    final DefinitionStatusEnumeration status
                    )
    {
        setStatus( status );
        return this;
    }


    public DefinitionStatusEnumeration getStatus()
    {
        return _status;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "oval_repository[status=" + getStatus()
                        + ", dates=" + getEvent()
                        + "]";
    }

}
// OvalRepository
