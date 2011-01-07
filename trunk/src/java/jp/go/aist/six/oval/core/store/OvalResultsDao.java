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
import jp.go.aist.six.oval.model.results.DefinitionResult;
import jp.go.aist.six.oval.model.results.DefinitionResults;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.results.SystemResult;
import jp.go.aist.six.oval.model.results.SystemResults;
import jp.go.aist.six.oval.model.results.TestResult;
import jp.go.aist.six.oval.model.results.TestResults;
import jp.go.aist.six.oval.model.results.TestedItem;
import jp.go.aist.six.oval.model.results.TestedVariable;
import jp.go.aist.six.util.BeansUtil;
import jp.go.aist.six.util.castor.CastorDao;
import jp.go.aist.six.util.persist.PersistenceException;
import java.util.Collection;
import java.util.UUID;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalResultsDao
    extends CastorDao<String, OvalResults>
{

    /**
     * Constructor.
     */
    public OvalResultsDao()
    {
        super( OvalResults.class );
    }



    /**
     */
    protected void _beforePersist(
                    final OvalResults ovalResults
                    )
    throws PersistenceException
    {
        String  ovalResultsPID = ovalResults.getPersistentID();
        if (ovalResultsPID == null) {
            ovalResultsPID = UUID.randomUUID().toString();
            ovalResults.setPersistentID( ovalResultsPID );
        }


        OvalDefinitions  ovalDefs = ovalResults.getOvalDefinitions();
        if (ovalDefs != null) {
            OvalResultsOvalDefinitionsAssociationEntry  assoc =
                    new OvalResultsOvalDefinitionsAssociationEntry(
                                    ovalResultsPID, ovalDefs.getPersistentID() );
            _sync( OvalResultsOvalDefinitionsAssociationEntry.class, assoc );
        }

        SystemResults  sysResults = ovalResults.getResults();
        if (sysResults != null) {
            for (SystemResult  sysResult : sysResults) {
                SystemResultOvalSystemCharacteristicsAssociationEntry assoc =
                    new SystemResultOvalSystemCharacteristicsAssociationEntry(
                                    sysResult.getPersistentID(),
                                    sysResult.getOvalSystemCharacteristics().getPersistentID()
                                    );
                _sync( SystemResultOvalSystemCharacteristicsAssociationEntry.class, assoc );
            }
        }
    }



    /**
     */
    private void _associateDependents(
                    final OvalResults ovalResults
                    )
    throws PersistenceException
    {
        SystemResults  sysResults = ovalResults.getResults();
        if (sysResults != null) {
            for (SystemResult  sysResult : sysResults) {
                sysResult.setMasterObject( ovalResults );

                DefinitionResults  defResults = sysResult.getDefinitions();
                for (DefinitionResult  defResult : defResults) {
                    defResult.setMasterObject( sysResult );
                }

                TestResults  testResults = sysResult.getTests();
                for (TestResult  testResult : testResults) {
                    testResult.setMasterObject( sysResult );

                    Collection<TestedItem>  items = testResult.getTestedItem();
                    if (items != null) {
                        for (TestedItem  item : items) {
                            item.setMasterObject( testResult );
                        }
                    }

                    Collection<TestedVariable>  variables = testResult.getTestedVariable();
                    if (variables != null) {
                        for (TestedVariable  variable : variables) {
                            variable.setMasterObject( testResult );
                        }
                    }
                }
            }
        }
    }



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    @Override
    protected void _createRelated(
                    final OvalResults object
                    )
    throws PersistenceException
    {
        _beforePersist( object );
        _associateDependents( object );
    }



    @Override
    protected void _updateRelated(
                    final OvalResults object
                    )
    throws PersistenceException
    {
        _associateDependents( object );
    }



    private static final String[]  _EXCEPTED_PROPERTIES_ =
        new String[] {
        "persistentID",
        "ovalDefinitions"
        };


    @Override
    protected void _syncProperties(
                    final OvalResults object,
                    final OvalResults p_object
                    )
    {
        if (p_object == null) {
            return;
        }

        BeansUtil.copyPropertiesExcept(
                        p_object, object, _EXCEPTED_PROPERTIES_ );
    }



    @Override
    protected void _syncRelated(
                    final OvalResults object,
                    final OvalResults p_object
                    )
    throws PersistenceException
    {
//        super._syncDeeply( object, p_object );
        _beforePersist( object );
        _associateDependents( object );
    }



//    @Override
//    public String create(
//                    final OvalResults results
//                    )
//    throws PersistenceException
//    {
//        if (results.getPersistentID() == null) {
//            String  uuid = UUID.randomUUID().toString();
//            results.setPersistentID( uuid );
//        }
//
//        for (SystemResult  system : results.getResults()) {
//            system.setMasterObject( results );
//
//            _createSystem( system );
//        }
//
//        OvalDefinitions  defs = results.getOvalDefinitions();
//        if (defs != null) {
//            OvalDefinitions  p_defs = getForwardingDao( OvalDefinitions.class ).sync( defs );
//            results.setOvalDefinitions( p_defs );
//        }
//
//        return super.create( results );
//    }

}
// OvalResultsDao
