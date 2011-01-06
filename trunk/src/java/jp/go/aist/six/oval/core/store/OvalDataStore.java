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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



/**
 * An OVAL data store implementation.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalDataStore
    implements DataStore
{

//    /**
//     * Logger.
//     */
//    private static Log  _LOG = LogFactory.getLog( OvalStore.class );



    private DataStore  _dataStore;


    private StoreWorkerRegistry  _workerRegistry;



    /**
     * Constructor.
     */
    public OvalDataStore()
    {
    }



    public final void setDataStore(
                    final DataStore store
                    )
    {
        _dataStore = store;
        _workerRegistry = _createWorkerRegistry( _dataStore );
    }



    private StoreWorkerRegistry _createWorkerRegistry(
                    final DataStore datastore
                    )
    {
        StoreWorkerRegistry   reg = new StoreWorkerRegistry( datastore );
        reg.addEntry( OvalDefinitions.class, new OvalDefinitionsStoreWorker( datastore ) );
        reg.addEntry( OvalResults.class,     new OvalResultsStoreWorker(     datastore ) );

        return reg;
    }



    private <K, T extends Persistable<K>>
    StoreWorker<K, T> _getWorker(
                    final Class<T> type
                    )
    {
        StoreWorker<K, T>  worker = _workerRegistry.getWorker( type );
        worker.setRegistry( _workerRegistry );

        return worker;
    }



//    /**
//     * Worker registry.
//     */
//    private final Map<Class<? extends Persistable<?>>, Worker<?, ?>>  _workers =
//        new HashMap<Class<? extends Persistable<?>>, Worker<?, ?>>();



//    /**
//     */
//    private <K, T extends Persistable<K>>
//    Worker<K, T> _getWorker(
//                    final Class<T> type
//                    )
//    {
//        Worker<?, ?>  worker = _workers.get( type );
//        if (worker == null) {
//            if (OvalDefinitions.class.isAssignableFrom( type )) {
//                worker = new OvalDefinitionsWorker( this );
////                worker = new OvalDefinitionsWorker( _dataStore );
//                _workers.put( OvalDefinitions.class, worker );
//            } else if (OvalResults.class.isAssignableFrom( type )) {
//                worker = new OvalResultsWorker( this );
////                worker = new OvalResultsWorker( _dataStore );
//                _workers.put( OvalResults.class, worker );
//            }
//        }
//
//        @SuppressWarnings( "unchecked" )
//        Worker<K, T>  w = (Worker<K, T>)worker;
//
//        return w;
//    }



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
        StoreWorker<K, T>  worker = _getWorker( type );
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
        StoreWorker<K, T>  worker = _getWorker( type );
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
        StoreWorker<K, T>  worker = _getWorker( type );
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
        StoreWorker<K, T>  worker = _getWorker( type );
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
        List<T>  p_objects = new ArrayList<T>();
        if (objects != null) {
            for (T  object : objects) {
                T  p_object = sync( type, object );
                p_objects.add( p_object );
            }
        }

        return p_objects;
    }



    public <K, T extends Persistable<K>>
    int count(
                    final Class<T> type
                    )
    throws PersistenceException
    {
        return count( type, null );
    }
//    {
//        int  count = 0;
//        Worker<K, T>  worker = _getWorker( type );
//        if (worker == null) {
//            count = _dataStore.count( type );
//        } else {
//            count = worker.count();
//        }
//
//        return count;
//    }



    public <K, T extends Persistable<K>>
    int count(
                    final Class<T> type,
                    final Binding filter
                    )
    throws PersistenceException
    {
        int  count = 0;
        StoreWorker<K, T>  worker = _getWorker( type );
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
        StoreWorker<K, T>  worker = _getWorker( type );
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
        List<T>  p_objects = new ArrayList<T>();
        if (identities != null) {
            for (K  identity : identities) {
                T  p_object = load( type, identity );
                p_objects.add( p_object );
            }
        }

        return p_objects;
    }



    public <K, T extends Persistable<K>>
    Collection<T> find(
                    final Class<T> type
                    )
    throws PersistenceException
    {
        return find( type, null, null, null );
    }



    public <K, T extends Persistable<K>>
    Collection<T> find(
                    final Class<T> type,
                    final Binding filter
                    )
    throws PersistenceException
    {
        return find( type, filter, null, null );
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
        Collection<K>  pids = findIdentity( type, filter, ordering, limit );
        Collection<T>  p_objects = loadAll( type, new ArrayList<K>( pids ) );

        return p_objects;
    }



    public <K, T extends Persistable<K>>
    Collection<K> findIdentity(
                    final Class<T> type
                    )
    throws PersistenceException
    {
        return findIdentity( type, null, null, null );
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
        Collection<K>  pids = null;
        StoreWorker<K, T>  worker = _getWorker( type );
        if (worker == null) {
            pids = _dataStore.findIdentity( type, filter, ordering, limit );
        } else {
            pids = worker.findIdentity( filter, ordering, limit );
        }

        return pids;
    }



    public <K, T extends Persistable<K>>
    List<T> search(
                    final Class<T> type,
                    final SearchCriteria criteria
                    )
    throws PersistenceException
    {
        Collection<T>  p_objects = null;
        if (criteria == null) {
            p_objects = find( type );
        } else {
            p_objects = find( type,
                            criteria.getBinding(),
                            criteria.getOrders(),
                            criteria.getLimit()
                            );
        }

        return (new ArrayList<T>( p_objects ));
    }

}
// OvalStore
