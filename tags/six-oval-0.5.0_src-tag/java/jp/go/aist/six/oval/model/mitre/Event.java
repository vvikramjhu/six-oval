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

import jp.go.aist.six.util.castor.AbstractPersistable;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class Event
    extends AbstractPersistable
{

    private String  _date;
//    private Date  _date;



    /**
     * Constructor.
     */
    public Event()
    {
    }


    /**
     * Constructor.
     */
    public Event(
                    final String date
                    )
    {
        setDate( date );
    }



    public void setDate(
                    final String date
                    )
    {
        _date = date;
    }


    public String getDate()
    {
        return _date;
    }

}
// Event
