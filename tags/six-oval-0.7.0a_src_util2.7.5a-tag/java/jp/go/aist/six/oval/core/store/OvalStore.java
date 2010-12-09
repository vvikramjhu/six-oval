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

import jp.go.aist.six.util.castor.CastorDataStore;



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



/***
    private <T extends AbstractOvalObject> Map<Class<T>, Worker<T>> _createWorkers()
    {
        Map<Class<T>, Worker<T>>  map = new HashMap<Class<T>, Worker<T>>();

//        map.put( OvalDefinitions.class, new OvalDefinitionsWorker() );

        return map;
    }



    private <T extends AbstractOvalObject> Map<Class<T>, Worker<T>>  _WORKERS =
        _createWorkers();



    private <T extends AbstractOvalObject> Worker<T> _getWorker(
                    final Class<? extends T> type
                    )
    {
        Worker<T>  worker = _WORKERS.get( type );
        if (worker == null) {
//            worker = new Worker<AbstractOvalObject>( AbstractOvalObject.class );
        }

        return worker;
    }


    private static class Worker<T extends AbstractOvalObject>
    {
        private final Class<T>  _type;

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


        public String create(
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
                        final String pid,
                        final ViewLevel view
                        )
        throws OvalRepositoryException
        {
            T  object = store.get( getType(), pid );
            return object;
        }
    }



    private static class OvalDefinitionsWorker
    extends Worker<OvalDefinitions>
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
***/

}
// OvalStore
