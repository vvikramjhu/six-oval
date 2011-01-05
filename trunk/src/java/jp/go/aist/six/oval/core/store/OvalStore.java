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

import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.util.persist.DataStore;
import jp.go.aist.six.util.persist.Persistable;
import jp.go.aist.six.util.persist.PersistenceException;
import jp.go.aist.six.util.search.Binding;
import jp.go.aist.six.util.search.Limit;
import jp.go.aist.six.util.search.Order;
import jp.go.aist.six.util.search.SearchCriteria;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * An OVAL data store implementation.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalStore
//    extends CastorDataStore
    implements DataStore
{

//    /**
//     * Logger.
//     */
//    private static Log  _LOG = LogFactory.getLog( OvalStore.class );



    private DataStore  _dataStore;



    /**
     * Constructor.
     */
    public OvalStore()
    {
    }



    public void setDataStore(
                    final DataStore store
                    )
    {
        _dataStore = store;
    }



    /**
     * Worker registry.
     */
    private final Map<Class<? extends Persistable<?>>, Worker<?, ?>>  _workers =
        new HashMap<Class<? extends Persistable<?>>, Worker<?, ?>>();



    /**
     */
    private <K, T extends Persistable<K>>
    Worker<K, T> _getWorker(
                    final Class<T> type
                    )
    {
        Worker<?, ?>  worker = _workers.get( type );
        if (worker == null) {
            if (OvalDefinitions.class.isAssignableFrom( type )) {
                worker = new OvalDefinitionsWorker( _dataStore );
                _workers.put( OvalDefinitions.class, worker );
            } else if (OvalResults.class.isAssignableFrom( type )) {
                worker = new OvalResultsWorker( _dataStore );
                _workers.put( OvalResults.class, worker );
            }
        }

        @SuppressWarnings( "unchecked" )
        Worker<K, T>  w = (Worker<K, T>)worker;

        return w;
    }



    //**************************************************************
    //  DataStore
    //**************************************************************

    public <K, T extends Persistable<K>>
    K create(
                    final Class<T> type,
                    final T object
                    )
    throws PersistenceException
    {
        K  p_id = null;
        Worker<K, T>  worker = _getWorker( type );
        if (worker == null) {
            p_id = _dataStore.create( type, object );
        } else {
            p_id = worker.create( object );
        }

        return p_id;
    }



    public <K, T extends Persistable<K>>
    void update(
                    final Class<T> type,
                    final T object
                    )
    throws PersistenceException
    {
        Worker<K, T>  worker = _getWorker( type );
        if (worker == null) {
            _dataStore.update( type, object );
        } else {
            worker.update( object );
        }
    }



    public <K, T extends Persistable<K>>
    void remove(
                    final Class<T> type,
                    final T object
                    )
    throws PersistenceException
    {
        Worker<K, T>  worker = _getWorker( type );
        if (worker == null) {
            _dataStore.remove( type, object );
        } else {
            worker.remove( object );
        }
    }



    public <K, T extends Persistable<K>>
    T sync(
                    final Class<T> type,
                    final T object
                    )
    throws PersistenceException
    {
        T  p_object = null;
        Worker<K, T>  worker = _getWorker( type );
        if (worker == null) {
            p_object = _dataStore.sync( type, object );
        } else {
            p_object = worker.sync( object );
        }

        return p_object;
    }



    public <K, T extends Persistable<K>>
    List<T> syncAll(
                    final Class<T> type,
                    final List<? extends T> objects
                    )
    throws PersistenceException
    {
        List<T>  p_objects = null;
        Worker<K, T>  worker = _getWorker( type );
        if (worker == null) {
            p_objects = _dataStore.syncAll( type, objects );
        } else {
            p_objects = worker.syncAll( objects );
        }

        return p_objects;
    }



    public <K, T extends Persistable<K>>
    int count(
                    final Class<T> type
                    )
    throws PersistenceException
    {
        int  count = 0;
        Worker<K, T>  worker = _getWorker( type );
        if (worker == null) {
            count = _dataStore.count( type );
        } else {
            count = worker.count();
        }

        return count;
    }



    public <K, T extends Persistable<K>>
    int count(
                    final Class<T> type,
                    final Binding filter
                    )
    throws PersistenceException
    {
        int  count = 0;
        Worker<K, T>  worker = _getWorker( type );
        if (worker == null) {
            count = _dataStore.count( type, filter );
        } else {
            count = worker.count( filter );
        }

        return count;
    }



    public <K, T extends Persistable<K>>
    T load(
                    final Class<T> type,
                    final K identity
                    )
    throws PersistenceException
    {
        T  p_object = null;
        Worker<K, T>  worker = _getWorker( type );
        if (worker == null) {
            p_object = _dataStore.load( type, identity );
        } else {
            p_object = worker.load( identity );
        }

        return p_object;
    }



    public <K, T extends Persistable<K>>
    List<T> loadAll(
                    final Class<T> type,
                    final List<? extends K> identities
                    )
    throws PersistenceException
    {
        List<T>  p_objects = null;
        Worker<K, T>  worker = _getWorker( type );
        if (worker == null) {
            p_objects = _dataStore.loadAll( type, identities );
        } else {
            p_objects = worker.loadAll( identities );
        }

        return p_objects;
    }



    public <K, T extends Persistable<K>>
    Collection<T> find(
                    final Class<T> type
                    )
    throws PersistenceException
    {
        Collection<T>  p_objects = null;
        Worker<K, T>  worker = _getWorker( type );
        if (worker == null) {
            p_objects = _dataStore.find( type );
        } else {
            p_objects = worker.find();
        }

        return p_objects;
    }



    public <K, T extends Persistable<K>>
    Collection<T> find(
                    final Class<T> type,
                    final Binding filter
                    )
    throws PersistenceException
    {
        Collection<T>  p_objects = null;
        Worker<K, T>  worker = _getWorker( type );
        if (worker == null) {
            p_objects = _dataStore.find( type, filter );
        } else {
            p_objects = worker.find( filter );
        }

        return p_objects;
    }



    public <K, T extends Persistable<K>>
    Collection<T> find(
                    final Class<T> type,
                    final Binding filter,
                    final List<? extends Order> ordering,
                    final Limit limit
                    )
    throws PersistenceException
    {
        Collection<T>  p_objects = null;
        Worker<K, T>  worker = _getWorker( type );
        if (worker == null) {
            p_objects = _dataStore.find( type, filter, ordering, limit );
        } else {
            p_objects = worker.find( filter, ordering, limit );
        }

        return p_objects;
    }



    public <K, T extends Persistable<K>>
    Collection<K> findIdentity(
                    final Class<T> type
                    )
    throws PersistenceException
    {
        Collection<K>  p_ids = null;
        Worker<K, T>  worker = _getWorker( type );
        if (worker == null) {
            p_ids = _dataStore.findIdentity( type );
        } else {
            p_ids = worker.findIdentity();
        }

        return p_ids;
    }



    public <K, T extends Persistable<K>>
    Collection<K> findIdentity(
                    final Class<T> type,
                    final Binding filter
                    )
    throws PersistenceException
    {
        return findIdentity( type, filter, null, null );
    }



    public <K, T extends Persistable<K>>
    Collection<K> findIdentity(
                    final Class<T> type,
                    final Binding filter,
                    final List<? extends Order> ordering,
                    final Limit limit
                    )
    throws PersistenceException
    {
        Collection<K>  p_ids = null;
        Worker<K, T>  worker = _getWorker( type );
        if (worker == null) {
            p_ids = _dataStore.findIdentity( type, filter, ordering, limit );
        } else {
            p_ids = worker.findIdentity( filter, ordering, limit );
        }

        return p_ids;
    }



    public <K, T extends Persistable<K>>
    List<T> search(
                    final Class<T> type,
                    final SearchCriteria criteria
                    )
    throws PersistenceException
    {
        List<T>  p_objects = null;
        Worker<K, T>  worker = _getWorker( type );
        if (worker == null) {
            p_objects = _dataStore.search( type, criteria );
        } else {
            p_objects = worker.search( criteria );
        }

        return p_objects;
    }

}
// OvalStore
