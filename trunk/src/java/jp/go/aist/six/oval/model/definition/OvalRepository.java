/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
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

package jp.go.aist.six.oval.model.definition;

import java.util.ArrayList;
import java.util.Collection;




/**
 * A marker class for definition/metadata/any elements.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalRepository.java 677 2010-04-24 08:06:29Z akihito $
 */
public class OvalRepository
    extends MetadataItem
{

    private Collection<OvalRepositoryEvent>  _event = new ArrayList<OvalRepositoryEvent>();

    private DefinitionStatus  _status;



    /**
     * Constructor.
     */
    public OvalRepository()
    {
    }



    public void setEvent(
                    final Collection<OvalRepositoryEvent> events
                    )
    {
        _event.clear();
        if (events == null  ||  events.size() == 0) {
            return;
        }

        for (OvalRepositoryEvent  event : events) {
            addEvent( event );
        }
    }


    public boolean addEvent(
                    final OvalRepositoryEvent event
                    )
    {
        if (event == null) {
            return false;
        }

        return _event.add( event );
    }


    public Collection<OvalRepositoryEvent> getEvent()
    {
        return _event;
    }



    public void setStatus(
                    final DefinitionStatus status
                    )
    {
        _status = status;
    }


    public DefinitionStatus getStatus()
    {
        return _status;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "OvalRepository[status=" + getStatus()
                        + ", dates=" + getEvent()
                        + "]";
    }

}
// OvalRepository
