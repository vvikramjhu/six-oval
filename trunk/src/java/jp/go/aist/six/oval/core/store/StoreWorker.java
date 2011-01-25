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

import jp.go.aist.six.util.persist.AssociationEntry;
import jp.go.aist.six.util.persist.Dao;
import jp.go.aist.six.util.persist.DataStore;
import jp.go.aist.six.util.persist.Persistable;
import jp.go.aist.six.util.persist.PersistenceException;
import jp.go.aist.six.util.search.Binding;
import jp.go.aist.six.util.search.Limit;
import jp.go.aist.six.util.search.Order;
import jp.go.aist.six.util.search.RelationalBinding;
import jp.go.aist.six.util.search.SearchCriteria;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StoreWorker<K, T extends Persistable<K>>
    implements Dao<K, T>
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( StoreWorker.class );



    private Class<T>  _objectType;


    private DataStore  _store;


    private StoreWorkerRegistry  _registry;



    /**
     * Constructor.
     */
    public StoreWorker()
    {
    }


    /**
     * Constructor.
     */
    public StoreWorker(
                    final Class<T> type
                    )
    {
        this( type, null );
    }


    /**
     * Constructor.
     */
    public StoreWorker(
                    final Class<T> type,
                    final DataStore store
                    )
    {
        this( type, store, null );
    }


    /**
     * Constructor.
     */
    public StoreWorker(
                    final Class<T> type,
                    final DataStore store,
                    final StoreWorkerRegistry registry
                    )
    {
        setObjectType( type );
        setDataStore( store );
        setRegistry( registry );
    }



    /**
     */
    public final void setObjectType(
                    final Class<T> type
                    )
    {
        _objectType = type;
    }



    /**
     */
    public final Class<T> getObjectType()
    {
        return _objectType;
    }



    /**
     */
    public final void setDataStore(
                    final DataStore store
                    )
    {
        _store = store;
    }


    protected DataStore _getDataStore()
    {
        return _store;
    }



    public void setRegistry(
                    final StoreWorkerRegistry registry
                    )
    {
        _registry = registry;
    }



    public <L, S extends Persistable<L>>
    StoreWorker<L, S> getForwardingWorker(
                    final Class<S> type
                    )
    {
        StoreWorker<L, S>  worker = null;
        if (_registry != null) {
            worker = _registry.getWorker( type );
        }

        return worker;
    }





    /**
     */
    private <J, M, S extends AssociationEntry<J, K, M>>
    List<M> _findAssociatedPersistentID(
                    final K antecendentPID,
                    final Class<S> associationType
                    )
    throws PersistenceException
    {
        Binding  filter =
            RelationalBinding.equalBinding( "antecendentPersistentID", antecendentPID );
        Collection<S>  associations = _getDataStore().find( associationType, filter );

        List<M>  dependentPIDs = new ArrayList<M>();
        if (associations.size() > 0) {
            for (S  assoc : associations) {
                if (_LOG.isTraceEnabled()) {
                    _LOG.trace( "association: " + assoc );
                }
                M  dependentPID = assoc.getDependentPersistentID();
                dependentPIDs.add( dependentPID );
            }
        }

        return dependentPIDs;
    }



    /**
     * Loads all the associated objects of the specified type.
     */
    protected <M, D extends Persistable<M>, J, S extends AssociationEntry<J, K, M>>
    Collection<D> _loadAssociated(
                    final K antecendentPID,
                    final Class<D> dependentType,
                    final Class<S> associationType
                    )
    throws PersistenceException
    {
        List<M>  depPIDs = _findAssociatedPersistentID( antecendentPID, associationType );
        List<D>  deps = _loadAll( dependentType, depPIDs );

        return deps;
    }



    /**
     */
    protected <J, S extends Persistable<J>>
    List<S> _loadAll(
                    final Class<S> type,
                    final List<J> pids
                    )
    {
        List<S>  p_objects = null;
        StoreWorker<J, S>  worker = getForwardingWorker( type );
        if (worker == null) {
            p_objects = _getDataStore().loadAll( type, pids );
        } else {
            p_objects = worker.loadAll( pids );
        }

        return p_objects;
    }



    //**************************************************************
    //  template methods
    //**************************************************************

    /**
     */
    protected void _beforePersist(
                    final T object
                    )
    throws PersistenceException
    {
        // default: Do nothing.
    }



    /**
     */
    protected <J, S extends Persistable<J>>
    S _sync(
                    final Class<S> type,
                    final S object
                    )
    {
        S  p_object = null;
        StoreWorker<J, S>  worker = getForwardingWorker( type );
        if (worker == null) {
            p_object = _getDataStore().sync( type, object );
        } else {
            p_object = worker.sync( object );
        }

        return p_object;
    }



    /**
     */
    protected void _beforeUpdate(
                    final T object
                    )
    throws PersistenceException
    {
        // default: Do nothing.
    }



    /**
     *
     */
    protected void _afterLoad(
                    final T p_object
                    )
    throws PersistenceException
    {
        // default: Do nothing.
    }




    //**************************************************************
    //  implements Dao
    //**************************************************************

    public K create(
                    final T object
                    )
    throws PersistenceException
    {
        _beforePersist( object );
        return _store.create( _objectType, object );
    }



    public void update(
                    final T object
                    )
    throws PersistenceException
    {
        _beforeUpdate( object );
        _store.update( _objectType, object );
    }



    public void remove(
                    final T object
                    )
    throws PersistenceException
    {
        _store.remove( _objectType, object );
    }



    public T sync(
                    final T object
                    )
    throws PersistenceException
    {
        _beforePersist( object );
        T  p_object = _store.sync( _objectType, object );
        _afterLoad( p_object );

        return p_object;
    }



    public List<T> syncAll(
                    final List<? extends T> objects
                    )
    throws PersistenceException
    {
        List<T>  p_objects = new ArrayList<T>();
        if (objects.size() > 0) {
            for (T  object : objects) {
                T  p_object = sync( object );
                p_objects.add( p_object );
            }
        }

        return p_objects;
    }



    public int count()
    throws PersistenceException
    {
        return count( null );
    }



    public int count(
                    final Binding filter
                    )
    throws PersistenceException
    {
        return _store.count( _objectType, filter );
    }



    public T load(
                    final K identity
                    )
    throws PersistenceException
    {
        T  p_object = _store.load( _objectType, identity );
        _afterLoad( p_object );

        return p_object;
    }



    public List<T> loadAll(
                    final List<? extends K> identities
                    )
    throws PersistenceException
    {
        List<T>  p_objects = new ArrayList<T>();
        for (K  identity : identities) {
            T  p_object = load( identity );
            p_objects.add( p_object );
        }

        return p_objects;
    }



    public Collection<T> find()
    throws PersistenceException
    {
        return find( null, null, null );
    }



    public Collection<T> find(
                    final Binding filter
                    )
    throws PersistenceException
    {
        return find( filter, null, null );
    }



    public Collection<T> find(
                    final Binding filter,
                    final List<? extends Order> ordering,
                    final Limit limit
                    )
    throws PersistenceException
    {
        Collection<T>  p_objects = _store.find( _objectType, filter, ordering, limit );
        if (p_objects != null) {
            for (T  p_object : p_objects) {
                _afterLoad( p_object );
            }
        }

        return p_objects;
    }



    public Collection<K> findIdentity()
    {
        return findIdentity( null, null, null );
    }



    public Collection<K> findIdentity(
                    final Binding filter
                    )
    throws PersistenceException
    {
        return findIdentity( filter, null, null );
    }



    public Collection<K> findIdentity(
                    final Binding filter,
                    final List<? extends Order> ordering,
                    final Limit limit
                    )
    throws PersistenceException
    {
        return _store.findIdentity( _objectType, filter, ordering, limit );
    }



    public List<Object> search(
                    final SearchCriteria criteria
                    )
    throws PersistenceException
    {
        return _store.search( _objectType, criteria );
    }

}
// StoreWorker

