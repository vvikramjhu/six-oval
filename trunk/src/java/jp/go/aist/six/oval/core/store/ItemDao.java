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

package jp.go.aist.six.oval.core.store;

import jp.go.aist.six.oval.model.system.Item;
import jp.go.aist.six.util.castor.CastorDao;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class ItemDao
    extends CastorDao<String, Item>
{

    public ItemDao()
    {
        super( Item.class );
    }



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

//    // workaround:
//    @Override
//    public Item get(
//                    final Object identity
//                    )
//    {
//        List<Item>  p_objects = find(
//                        RelationalBinding.equalBinding( "persistentID", identity ) );
//        return (p_objects.size() == 0 ? null : p_objects.get( 0 ) );
//    }

}
// ItemDao
