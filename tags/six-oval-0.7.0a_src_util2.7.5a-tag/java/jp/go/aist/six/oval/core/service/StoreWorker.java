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

package jp.go.aist.six.oval.core.service;

import jp.go.aist.six.oval.model.OvalObject;
import jp.go.aist.six.oval.service.OvalRepositoryException;
import jp.go.aist.six.oval.service.ViewLevel;
import jp.go.aist.six.util.persist.DataStore;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StoreWorker<K, T extends OvalObject<K>>
{

//    /**
//     * Logger.
//     */
//    private static Log  _LOG = LogFactory.getLog( LocalOvalRepository.class );



    private Class<T>  _type;



    /**
     * Constructor.
     */
    public StoreWorker(
                    final Class<T> type
    )
    {
        _type = type;
    }



    public Class<T> getType()
    {
        return _type;
    }



    public K create(
                    final DataStore store,
                    final T object
                    )
    throws OvalRepositoryException
    {
        return store.create( getType(), object );
    }



    public T sync(
                    final DataStore store,
                    final T object
                    )
    throws OvalRepositoryException
    {
        return store.sync( getType(), object );
    }



    public T get(
                    final DataStore store,
                    final K pid,
                    final ViewLevel view
                    )
    throws OvalRepositoryException
    {
        T  object = store.get( getType(), pid );
        return object;
    }

}
// StoreWorker

