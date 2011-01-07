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
import jp.go.aist.six.oval.model.results.SystemResult;
import jp.go.aist.six.oval.model.results.SystemResults;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.util.persist.DataStore;
import jp.go.aist.six.util.persist.PersistenceException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Collection;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalResultsStoreWorker
    extends StoreWorker<String, OvalResults>
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( OvalResultsStoreWorker.class );



    /**
     * Constructor.
     */
    public OvalResultsStoreWorker(
                    final DataStore store
                    )
    {
        super( OvalResults.class, store );
    }



    //**************************************************************
    // StoreWorker
    //**************************************************************

    @Override
    protected void _beforePersist(
                    final OvalResults object
                    )
    throws PersistenceException
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "*** beforePersist ***" );
        }

        OvalDefinitions  ovalDefs = object.getOvalDefinitions();
        if (ovalDefs != null) {
            _sync( OvalDefinitions.class, ovalDefs );
        }

        SystemResults  sysResults = object.getResults();
        if (sysResults != null) {
            for (SystemResult  sysResult : sysResults) {
                OvalSystemCharacteristics  ovalSC = sysResult.getOvalSystemCharacteristics();
                _sync( OvalSystemCharacteristics.class, ovalSC );
            }
        }
    }



    @Override
    protected void _afterLoad(
                    final OvalResults object
                    )
    throws PersistenceException
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "*** afterLoad ***" );
        }

        String  pid = object.getPersistentID();

        Collection<OvalDefinitions>  p_defs = _loadAssociated( pid, OvalDefinitions.class,
                            OvalResultsOvalDefinitionsAssociationEntry.class );
        if (p_defs != null  &&  p_defs.size() > 0) {
            object.setOvalDefinitions( p_defs.iterator().next() );
        }

        SystemResults  sysResults = object.getResults();
//        Collection<OvalSystemCharacteristics>  p_scs = _loadAssociated( pid, OvalSystemCharacteristics.class,
//                        OvalSystemResultsOvalSystemCharacteristicsAssociationEntry.class );
//        if (p_scs != null  &&  p_scs.size() > 0) {
//            object.setOvalDefinitions( p_defs.iterator().next() );
//        }
    }

}
// OvalResultsStoreWorker

