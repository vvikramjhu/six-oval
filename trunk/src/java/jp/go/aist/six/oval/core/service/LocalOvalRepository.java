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

import jp.go.aist.six.oval.model.AbstractOvalObject;
import jp.go.aist.six.oval.model.OvalObject;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.Definitions;
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
import java.util.HashMap;
import java.util.List;
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
        @SuppressWarnings( "unchecked" )
        Worker<K, T>  worker = (Worker<K, T>)_getWorker( type );

        K  pid = worker.create( _store, object );
        return pid;
    }


    public <K, T extends OvalObject<K>>
    T sync(
                    final Class<T> type,
                    final T object
                    )
    throws OvalRepositoryException
    {
        @SuppressWarnings( "unchecked" )
        Worker<K, T>  worker = (Worker<K, T>)_getWorker( type );

        return worker.sync( _store, object );
    }


    public <K, T extends OvalObject<K>>
    T get(
                    final Class<T> type,
                    final K pid,
                    final ViewLevel view
                    )
    throws OvalRepositoryException
    {
        @SuppressWarnings( "unchecked" )
        Worker<K, T>  worker = (Worker<K, T>)_getWorker( type );

        return worker.get( _store, pid, view );
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
            object = _store.get( OvalDefinitions.class, pid );
        } catch (PersistenceException ex) {
            throw new OvalRepositoryException( ex );
        }

        return object;
    }


    public List<Definition> findDefinitionByCve(
                    final String cveName
                    )
    throws OvalRepositoryException
    {
        Binding  filter = RelationalBinding.equalBinding( "metadata.reference.refID", cveName );
        List<Definition>  objects = null;
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
            object = _store.get( OvalSystemCharacteristics.class, pid );
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
            object = _store.get( OvalResults.class, pid );
        } catch (PersistenceException ex) {
            throw new OvalRepositoryException( ex );
        }

        return object;
    }



    // StoreWorker



    private static <T extends OvalObject<?>>
    Map<Class<T>, Worker<?, ? super T>> _createWorkers()
    {
        Map<Class<T>, Worker<?, T>>  map =
            new HashMap<Class<T>, Worker<?, T>>();

        map.put( OvalDefinitions.class, new OvalDefinitionsWorker() );

        return map;
    }

    private static final
    Map<Class<? extends OvalObject<?>>, Worker<?, ? extends OvalObject<?>>>  _WORKERS =
        _createWorkers();



    private static <T extends OvalObject<?>> Worker<?, T> _getWorker(
                    final Class<T> type
                    )
    {
        @SuppressWarnings( "unchecked" )
        Worker<?, T>  worker = (Worker<?, T>)_WORKERS.get( type );

        return worker;
    }


    /**
     */
    private static class Worker<K, T extends OvalObject<K>>
    {
        private Class<T>  _type;

        public Worker(
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



    private static class DefaultWorker
    extends Worker<String, AbstractOvalObject>
    {
        public DefaultWorker()
        {
            super( AbstractOvalObject.class );
        }
    }


    private static class OvalDefinitionsWorker
    extends Worker<String, OvalDefinitions>
    {
        public OvalDefinitionsWorker()
        {
            super( OvalDefinitions.class );
        }


        @Override
        public String create(
                        final DataStore store,
                        final OvalDefinitions object
                        )
        throws OvalRepositoryException
        {
            Definitions  definitions = object.getDefinitions();
            if (definitions != null) {
                for (Definition  d : definitions) {
                    store.sync( Definition.class, d );
                }
//                    List<Definition>  p_def_list =
//                        getForwardingDao( Definition.class ).syncAll( def_list );
//                    defs.setDefinitions( new Definitions( p_def_list ) );
            }

            return store.create( getType(), object );
        }


        @Override
        public OvalDefinitions get(
                        final DataStore store,
                        final String pid,
                        final ViewLevel view
                        )
        throws OvalRepositoryException
        {
            OvalDefinitions  object = store.get( getType(), pid );
            if (view == ViewLevel.SUMMARY) {
            } else if (view == ViewLevel.ALL) {

            }

            return object;
        }
    }

}
// OvalRepositoryClient

