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
import jp.go.aist.six.util.persist.DataStore;
import jp.go.aist.six.util.persist.Persistable;
import jp.go.aist.six.util.persist.PersistenceException;
import jp.go.aist.six.util.search.Binding;
import jp.go.aist.six.util.search.RelationalBinding;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class Worker<K, T extends Persistable<K>>
//    implements Dao<K, T>
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( Worker.class );



    private final Class<T>  _objectType;


    private final DataStore  _store;



    /**
     * Constructor.
     */
    public Worker(
                    final Class<T> type,
                    final DataStore store
                    )
    {
        _objectType = type;
        _store = store;
    }



    /**
     */
    public final Class<T> getObjectType()
    {
        return _objectType;
    }



    /**
     */
    protected final DataStore _getStore()
    {
        return _store;
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
        Collection<S>  associations = _getStore().find( associationType, filter );

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
        List<D>  deps = _getStore().loadAll( dependentType, depPIDs );

        return deps;
    }



    //**************************************************************
    //  implements Dao
    //**************************************************************

    public void createAssociated(
                    final T object
                    )
    throws PersistenceException
    {
//        return _store.create( _objectType, object );
    }



//    public void updateAssociated(
//                    final T object
//                    )
//    throws PersistenceException
//    {
////        _store.update( _objectType, object );
//    }



//    public void remove(
//                    final T object
//                    )
//    throws PersistenceException
//    {
////        _store.remove( _objectType, object );
//    }



    public void syncAssociated(
                    final T object
                    )
    throws PersistenceException
    {
//        return _store.sync( _objectType, object );
    }



    public void loadAssociated(
                    final T object
                    )
    throws PersistenceException
    {
//        return _store.load( _objectType, identity );
    }

}
// Worker

