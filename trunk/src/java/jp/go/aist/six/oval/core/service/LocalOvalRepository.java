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
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.service.OvalRepository;
import jp.go.aist.six.oval.service.OvalRepositoryException;
import jp.go.aist.six.oval.service.ViewLevel;
import jp.go.aist.six.util.persist.DataStore;
import jp.go.aist.six.util.persist.PersistenceException;
import jp.go.aist.six.util.search.Binding;
import jp.go.aist.six.util.search.RelationalBinding;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class LocalOvalRepository
    implements OvalRepository
{

//    /**
//     * Logger.
//     */
//    private static Log  _LOG = LogFactory.getLog( LocalOvalRepository.class );



    private DataStore  _store;



    /**
     * Constructor.
     */
    public LocalOvalRepository()
    {
        _init();
    }



    /**
     *
     */
    private void _init()
    {
        OvalContext  context = new OvalContext();
        DataStore  store = context.getBean( "ovalStore", DataStore.class );
        setStore( store );
    }



    /**
     */
    public void setStore(
                    final DataStore store
                    )
    {
        _store = store;
    }



    // StoreWorker

    private final Map<Class<? extends OvalObject<?>>, StoreWorker<?, ?>>  _workers =
        new HashMap<Class<? extends OvalObject<?>>, StoreWorker<?, ?>>();


//    @SuppressWarnings( "unchecked" )
    private <K, T extends OvalObject<K>> StoreWorker<K, T> _getWorker(
                    final Class<T> type
                    )
    {
        StoreWorker<?, ?>  worker = _workers.get( type );
        if (worker == null) {
            if (OvalDefinitions.class.isAssignableFrom( type )) {
                worker = new OvalDefinitionsStoreWorker();
                _workers.put( type, worker );
            }
        }

        @SuppressWarnings( "unchecked" )
        StoreWorker<K, T>  w = (StoreWorker<K, T>)worker;

        return w;
    }

//    @SuppressWarnings( "unchecked" )
//    private <K, T extends OvalObject<K>> StoreWorker<K, T> _getW(
//                    final Class<T> type
//                    )
//    {
//        StoreWorker<K, T>  worker = (StoreWorker<K, T>)_workers.get( type );
//        if (worker == null) {
//            if (OvalDefinitions.class.isAssignableFrom( type )) {
//                worker = new OvalDefinitionsStoreWorker();
//                _workers.put( type, worker );
//            }
//        }
//
//        return worker;
//    }



    //**************************************************************
    // OvalRepository
    //**************************************************************

    public <K, T extends OvalObject<K>>
    K create(
                    final Class<T> type,
                    final T object
                    )
    throws OvalRepositoryException
    {
        StoreWorker<K, T>  worker = _getWorker( type );
        K  pid = null;
        if (worker == null) {
            pid = _store.create( type, object );
        } else {
            pid = worker.create( _store, object );
        }

        return pid;
    }


    public <K, T extends OvalObject<K>>
    T sync(
                    final Class<T> type,
                    final T object
                    )
    throws OvalRepositoryException
    {
        StoreWorker<K, T>  worker = _getWorker( type );
        T  p_object = null;
        if (worker == null) {
            p_object = _store.sync( type, object );
        } else {
            p_object = worker.sync( _store, object );
        }

        return p_object;
    }


    public <K, T extends OvalObject<K>>
    T get(
                    final Class<T> type,
                    final K pid,
                    final ViewLevel view
                    )
    throws OvalRepositoryException
    {
        StoreWorker<K, T>  worker = _getWorker( type );
        T  p_object = null;
        if (worker == null) {
            p_object = _store.load( type, pid );
        } else {
            p_object = worker.get( _store, pid, view );
        }

        return p_object;
    }



    public String createOvalDefinitions(
                    final OvalDefinitions definitions
                    )
    throws OvalRepositoryException
    {
        String  pid = null;
        try {
            pid = _store.create( OvalDefinitions.class, definitions );
        } catch (PersistenceException ex) {
            throw new OvalRepositoryException( ex );
        }

        return pid;
    }


    public OvalDefinitions getOvalDefinitions(
                    final String pid
                    )
    throws OvalRepositoryException
    {
        OvalDefinitions  object = null;
        try {
            object = _store.load( OvalDefinitions.class, pid );
        } catch (PersistenceException ex) {
            throw new OvalRepositoryException( ex );
        }

        return object;
    }


    public Collection<Definition> findDefinitionByCve(
                    final String cveName
                    )
    throws OvalRepositoryException
    {
        Binding  filter = RelationalBinding.equalBinding( "metadata.reference.refID", cveName );
        Collection<Definition>  objects = null;
        try {
            objects = _store.find( Definition.class, filter );
        } catch (PersistenceException ex) {
            throw new OvalRepositoryException( ex );
        }

        return objects;
    }



    public String createOvalSystemCharacteristics(
                    final OvalSystemCharacteristics sc
                    )
    throws OvalRepositoryException
    {
        String  pid = null;
        try {
            pid = _store.create( OvalSystemCharacteristics.class, sc );
        } catch (PersistenceException ex) {
            throw new OvalRepositoryException( ex );
        }

        return pid;
    }


    public OvalSystemCharacteristics getOvalSystemCharacteristics(
                    final String pid
                    )
    throws OvalRepositoryException
    {
        OvalSystemCharacteristics  object = null;
        try {
            object = _store.load( OvalSystemCharacteristics.class, pid );
        } catch (PersistenceException ex) {
            throw new OvalRepositoryException( ex );
        }

        return object;
    }



    public String createOvalResults(
                    final OvalResults results
                    )
    throws OvalRepositoryException
    {
        String  pid = null;
        try {
            pid = _store.create( OvalResults.class, results );
        } catch (PersistenceException ex) {
            throw new OvalRepositoryException( ex );
        }

        return pid;
    }



    public OvalResults getOvalResults(
                    final String pid
    )
    throws OvalRepositoryException
    {
        OvalResults  object = null;
        try {
            object = _store.load( OvalResults.class, pid );
        } catch (PersistenceException ex) {
            throw new OvalRepositoryException( ex );
        }

        return object;
    }

}
// OvalRepositoryClient

