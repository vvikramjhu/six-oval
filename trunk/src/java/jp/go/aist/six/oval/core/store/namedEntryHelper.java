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

package jp.go.aist.six.oval.core.store;

import jp.go.aist.six.oval.model.OvalEntity;
import jp.go.aist.six.util.castor.PersistenceHelper;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalEntityHelper<T extends OvalEntity>
    extends PersistenceHelper<T>
{

    public OvalEntityHelper()
    {
    }



    //**************************************************************
    //  PersistenceHelper
    //**************************************************************

    @Override
    public boolean hasUnique()
    {
        return true;
    }



    @Override
    public Object getUnique(
                    final T object
                    )
    {
        return (new Object[] {
                        object.getOvalID(),
                        Integer.valueOf( object.getOvalVersion() )
        });
    }



    @Override
    public String getUniqueFilter()
    {
        return "WHERE o.ovalID = $1 AND o.ovalVersion = $2";
    }

}
// OvalEntityHelper

