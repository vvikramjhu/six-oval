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

import jp.go.aist.six.oval.model.NameEntity;
import jp.go.aist.six.util.castor.CastorDao;
import jp.go.aist.six.util.castor.PersistenceHelper;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class NameEntityDao<T extends NameEntity>
    extends CastorDao<String, T>
{

    /**
     * Constructor.
     */
    public NameEntityDao()
    {
    }


    /**
     * Constructor.
     */
    public NameEntityDao(
                    final Class<? extends T> type
                    )
    {
        this( type, new PersistenceHelper<T>() );
    }


    /**
     * Constructor.
     */
    public NameEntityDao(
                    final Class<? extends T> type,
                    final PersistenceHelper<? super T> helper
                    )
    {
        super( type, helper );
    }



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    @Override
    protected void _syncProperties(
                    final T object,
                    final T p_object
                    )
    {
        if (p_object == null) {
            return;
        }

        // nothing to copy
    }

}
// NameEntityDao
