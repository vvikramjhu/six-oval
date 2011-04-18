/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
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

import jp.go.aist.six.util.persist.DataStore;
import jp.go.aist.six.util.persist.Persistable;
import jp.go.aist.six.util.persist.PersistenceException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.HashMap;
import java.util.Map;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StoreWorkerRegistry
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( StoreWorkerRegistry.class );



    private Map<String, String>  _typeMapping = new HashMap<String, String>();


    private Map<Class<? extends Persistable<?>>, StoreWorker<?, ?>>  _workerMapping =
        new HashMap<Class<? extends Persistable<?>>, StoreWorker<?, ?>>();



    private DataStore  _dataStore;



    /**
     * Constructor.
     */
    public StoreWorkerRegistry()
    {
    }



    /**
     * Constructor.
     */
    public StoreWorkerRegistry(
                    final DataStore store
                    )
    {
        setDataStore( store );
    }



    /**
     */
    public void setDataStore(
                    final DataStore store
                    )
    {
        _dataStore = store;
    }



    /**
     */
    public void setEntriesByName(
                    final Map<String, String> map
                    )
    {
        if (map == null) {
            return;
//            throw new IllegalArgumentException( "null mapping" );
        }

        _typeMapping.putAll( map );
        if (_LOG.isDebugEnabled()) {
            _LOG.debug( "type mapping: " + _typeMapping );
        }
    }



    /**
     */
    public <K, T extends Persistable<K>> void addEntry(
                    final Class<T> type,
                    final StoreWorker<K, T> worker
                    )
    {
        if (type == null) {
            throw new IllegalArgumentException( "no type specfied" );
        }

        if (worker == null) {
            throw new IllegalArgumentException( "no worker specfied" );
        }

        _workerMapping.put( type, worker );
    }



    /**
     * Creates a Dao for the specified object type.
     */
    private <K, T extends Persistable<K>> StoreWorker<K, T> _createWorker(
                    final Class<T> type
                    )
    throws PersistenceException
    {
        String  clazzName = _typeMapping.get( type.getName() );
        if (_LOG.isDebugEnabled()) {
            _LOG.debug( "creating Worker: object type=" + type
                            + ", Worker type=" + clazzName );
        }

        StoreWorker<K, T>  worker = null;
        if (clazzName == null) {
            worker = new StoreWorker<K, T>( type, _dataStore );
        } else {
            try {
                @SuppressWarnings( "unchecked" )
                Class<StoreWorker<K, T>>  clazz =
                    (Class<StoreWorker<K, T>>)Class.forName( clazzName );
                worker = clazz.newInstance();
                               //throws InstantiationException, IllegalAccessException
            } catch (Exception ex) {
                throw new PersistenceException( ex );
            }

            worker.setDataStore( _dataStore );
        }

        return worker;
    }



    public <K, T extends Persistable<K>> StoreWorker<K, T> getWorker(
                    final Class<T> type
                    )
    throws PersistenceException
    {
        if (type == null) {
            throw new IllegalArgumentException( "no type specified" );
        }

        @SuppressWarnings( "unchecked" )
        StoreWorker<K, T>  dao = (StoreWorker<K, T>)_workerMapping.get( type );

        if (dao == null) {
            dao = _createWorker( type );
            _workerMapping.put( type, dao );
        }

        return dao;
    }

}
// StoreWorkerRegistry
