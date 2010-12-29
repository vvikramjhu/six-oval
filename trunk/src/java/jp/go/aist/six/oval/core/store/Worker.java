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

import jp.go.aist.six.util.persist.Dao;
import jp.go.aist.six.util.persist.DataStore;
import jp.go.aist.six.util.persist.Persistable;
import jp.go.aist.six.util.persist.PersistenceException;
import jp.go.aist.six.util.search.Binding;
import jp.go.aist.six.util.search.Limit;
import jp.go.aist.six.util.search.Order;
import jp.go.aist.six.util.search.SearchCriteria;
import java.util.Collection;
import java.util.List;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class Worker<K, T extends Persistable<K>>
implements Dao<K, T>
{

    private final Class<T>  _type;


    private final DataStore  _store;



    /**
     * Constructor.
     */
    public Worker(
                    final Class<T> type,
                    final DataStore store
    )
    {
        _type = type;
        _store = store;
    }



    public Class<T> getType()
    {
        return _type;
    }



    //**************************************************************
    //  implements Dao
    //**************************************************************

    public K create(
                    final T object
                    )
    throws PersistenceException
    {
        return _store.create( _type, object );
    }



    public void update(
                    final T object
                    )
    throws PersistenceException
    {
        _store.update( _type, object );
    }



    public void remove(
                    final T object
                    )
    throws PersistenceException
    {
        _store.remove( _type, object );
    }



    public T sync(
                    final T object
                    )
    throws PersistenceException
    {
        return _store.sync( _type, object );
    }



    public List<T> syncAll(
                    final List<? extends T> objects
                    )
    throws PersistenceException
    {
        return _store.syncAll( _type, objects );
    }



    public int count()
    throws PersistenceException
    {
        return _store.count( _type );
    }



    public int count(
                    final Binding filter
                    )
    throws PersistenceException
    {
        return _store.count( _type, filter );
    }



    public T load(
                    final K identity
                    )
    throws PersistenceException
    {
        return _store.load( _type, identity );
    }



    public List<T> loadAll(
                    final List<? extends K> identities
                    )
    throws PersistenceException
    {
        return _store.loadAll( _type, identities );
    }



    public Collection<T> find()
    throws PersistenceException
    {
        return _store.find( _type );
    }



    public Collection<T> find(
                    final Binding filter
                    )
    throws PersistenceException
    {
        return _store.find( _type, filter );
    }



    public Collection<T> find(
                    final Binding filter,
                    final List<? extends Order> ordering,
                    final Limit limit
                    )
    throws PersistenceException
    {
        return _store.find( _type, filter, ordering, limit );
    }



    public Collection<K> findIdentity()
    {
        return _store.findIdentity( _type );
    }



    public Collection<K> findIdentity(
                    final Binding filter
                    )
    throws PersistenceException
    {
        return _store.findIdentity( _type, filter );
    }



    public Collection<K> findIdentity(
                    final Binding filter,
                    final List<? extends Order> ordering,
                    final Limit limit
                    )
    throws PersistenceException
    {
        return _store.findIdentity( _type, filter, ordering, limit );
    }



    public List<T> search(
                    final SearchCriteria criteria
                    )
    throws PersistenceException
    {
        return _store.search( _type, criteria );
    }

}
// Worker

