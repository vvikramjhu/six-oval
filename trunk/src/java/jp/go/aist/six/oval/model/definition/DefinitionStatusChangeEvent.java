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

import java.util.Date;




/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id: DefinitionStatusChangeEvent.java 674 2010-04-23 09:51:49Z akihito $
 */
public class DefinitionStatusChangeEvent
    extends OvalRepositoryEvent
{

    private DefinitionStatus  _status;



    /**
     * Constructor.
     */
    public DefinitionStatusChangeEvent()
    {
    }


    /**
     * Constructor.
     */
    public DefinitionStatusChangeEvent(
                    final Date date,
                    final DefinitionStatus status
                    )
    {
        super( date );
        setStatus( status );
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
        return "status_change[date=" + getDate()
                        + ", status=" + getStatus()
                        + "]";
    }

}
// DefinitionStatusChangeEvent
