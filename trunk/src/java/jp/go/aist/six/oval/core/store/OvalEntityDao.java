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
import jp.go.aist.six.util.castor.CastorDao;
import jp.go.aist.six.util.castor.PersistenceHelper;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalEntityDao<T extends OvalEntity>
    extends CastorDao<String, T>
{

    public OvalEntityDao()
    {
    }


    public OvalEntityDao(
                    final Class<? extends T> type
                    )
    {
        this( type, new PersistenceHelper<T>() );
    }



    public OvalEntityDao(
                    final Class<? extends T> type,
                    final PersistenceHelper<? super T> helper
                    )
    {
        super( type, helper );
    }


//    public OvalEntityDao(
//                    final Class<? extends T> type
//                    )
//    {
//        this( type, new OvalEntityHelper<T>() );
//    }
//
//
//
//    public OvalEntityDao(
//                    final Class<? extends T> type,
//                    final OvalEntityHelper<? super T> helper
//                    )
//    {
//        super( type, helper );
//    }



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    // Polymorphic loading of abstract class, OvalEntity, State, Test,...
    // fails with NullPointerException:
    //  at org.castor.persist.ObjectTracker.untrackObject(ObjectTracker.java:443)

//    // workaround:
//    @Override
//    public T get(
//                    final String identity
//                    )
//    throws PersistenceException
//    {
//        List<T>  p_objects = find(
//                        RelationalBinding.equalBinding( "persistentID", identity ) );
//        return (p_objects.size() == 0 ? null : p_objects.get( 0 ) );
//    }

}
// OvalEntityDao
