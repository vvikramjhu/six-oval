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

import jp.go.aist.six.oval.core.service.OvalContext;
import jp.go.aist.six.oval.core.xml.OvalXml;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.util.persist.DataStore;
import jp.go.aist.six.util.persist.PersistenceException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class DefinitionStoreWorker
    extends StoreWorker<String, Definition>
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( DefinitionStoreWorker.class );



    /**
     * Constructor.
     */
    public DefinitionStoreWorker(
                    final DataStore store
                    )
    {
        this( store, null );
    }



    /**
     * Constructor.
     */
    public DefinitionStoreWorker(
                    final DataStore store,
                    final StoreWorkerRegistry registry
                    )
    {
        super( Definition.class, store, registry );
    }



    private static OvalXml  _mapper = null;

    protected static OvalXml _getMapper()
    {
        if (_mapper == null) {
            _mapper = OvalContext.INSTANCE.getXml();
        }

        return _mapper;
    }



    //**************************************************************
    // StoreWorker
    //**************************************************************

    @Override
    protected void _beforePersist(
                    final Definition def
                    )
    throws PersistenceException
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "*** beforePersist ***" );
        }

    }



    @Override
    protected void _afterLoad(
                    final Definition def
                    )
    throws PersistenceException
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "*** afterLoad ***" );
        }

    }

}
// OvalDefinitionsStoreWorker

