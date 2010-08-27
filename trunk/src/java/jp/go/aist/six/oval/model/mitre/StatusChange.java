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

package jp.go.aist.six.oval.model.mitre;

import java.util.Date;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class StatusChange
    extends Event
{

    private DefinitionStatus  _status;



    /**
     * Constructor.
     */
    public StatusChange()
    {
    }


    /**
     * Constructor.
     */
    public StatusChange(
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

    @Override
    public String toString()
    {
        return "status_change[date=" + getDate()
                        + ", status=" + getStatus()
                        + "]";
    }

}
// StatusChange
