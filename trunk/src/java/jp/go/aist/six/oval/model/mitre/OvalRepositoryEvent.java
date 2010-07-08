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
import java.util.Date;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class OvalRepositoryEvent
    extends AbstractPersistable
{

    private Date  _date;



    /**
     * Constructor.
     */
    public OvalRepositoryEvent()
    {
    }



    /**
     * Constructor.
     */
    public OvalRepositoryEvent(
                    final Date date
                    )
    {
        setDate( date );
    }



    public void setDate(
                    final Date date
                    )
    {
        this._date = date;
    }


    public Date getDate()
    {
        return _date;
    }

}
// OvalRepositoryEvent
