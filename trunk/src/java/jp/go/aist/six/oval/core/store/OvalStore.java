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
import jp.go.aist.six.util.castor.CastorDataStore;
import jp.go.aist.six.util.persist.Persistable;
import java.util.HashMap;
import java.util.Map;



/**
 * An OVAL data store implementation.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalStore
    extends CastorDataStore
{

//    /**
//     * Logger.
//     */
//    private static Log  _LOG = LogFactory.getLog( OvalStoreImpl.class );



    /**
     * Constructor.
     */
    public OvalStore()
    {
    }



    private final Map<Class<? extends Persistable<?>>, Worker<?, ?>>  _workers =
        _createWorkers();



    private Map<Class<? extends Persistable<?>>, Worker<?, ?>> _createWorkers()
    {
        Map<Class<? extends Persistable<?>>, Worker<?, ?>>  map
                        = new HashMap<Class<? extends Persistable<?>>, Worker<?, ?>>();

        map.put( OvalDefinitions.class, new OvalDefinitionsWorker( this ) );

        return map;
    }



    private <K, T extends Persistable<K>>
    Worker<K, T> _getWorker(
                    final Class<T> type
                    )
    {
        Worker<?, ?>  worker = _workers.get( type );
        if (worker == null) {
            worker = new Worker<K, T>( type, this );
            _workers.put( type, worker );
        }

        @SuppressWarnings( "unchecked" )
        Worker<K, T>  w = (Worker<K, T>)worker;

        return w;
    }

}
// OvalStore
