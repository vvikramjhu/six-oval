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

package jp.go.aist.six.oval.core.store.v5;

import jp.go.aist.six.oval.model.v5.OvalEntity;
import jp.go.aist.six.util.BeansUtil;
import jp.go.aist.six.util.castor.CastorDao;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class OvalEntityDao<T extends OvalEntity>
    extends CastorDao<String, T>
{

    public OvalEntityDao()
    {
    }


    public OvalEntityDao(
                    final Class<? extends T> type
                    )
    {
        this( type, new OvalEntityHelper<T>() );
    }



    public OvalEntityDao(
                    final Class<? extends T> type,
                    final OvalEntityHelper<? super T> helper
//                    final PersistenceHelper<? super T> helper
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



    protected static final String[]  _COPY_EXCEPTED_PROPERTIES_ =
        new String[] {
        "persistentID",
        "ovalID",
        "ovalVersion",
        "entityType"
        };


    protected String[] _getCopyExcepts()
    {
        return _COPY_EXCEPTED_PROPERTIES_;
    }



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    @Override
    protected void _syncProperties(
                    final T   object,
                    final T p_object
                    )
    {
        if (p_object == null) {
            return;
        }

        BeansUtil.copyPropertiesExcept(
                        p_object, object, _COPY_EXCEPTED_PROPERTIES_ );
    }



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
