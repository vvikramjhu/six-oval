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

package jp.go.aist.six.oval.model.v5;

import java.util.UUID;
import com.google.code.morphia.annotations.Id;



/**
 * A skeletal implementation of the OvalObject interface.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class AbstractOvalObject
    implements OvalObject<String>
{

    @Id
    private String  _objectID;



    /**
     * Constructor.
     */
    public AbstractOvalObject()
    {
        _objectID = UUID.randomUUID().toString();
    }



    //**************************************************************
    //  Persistable
    //**************************************************************

    @Override
    public final void setPersistentID(
                    final String pid
                    )
    {
        _objectID = pid;
    }


    @Override
    public final synchronized String getPersistentID()
    {
        if (_objectID == null) {
            _objectID = UUID.randomUUID().toString();
        }

        return _objectID;
    }

}
// AbstractOvalObject
