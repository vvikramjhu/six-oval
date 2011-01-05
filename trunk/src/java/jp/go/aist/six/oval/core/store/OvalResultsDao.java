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

import jp.go.aist.six.oval.model.results.DefinitionResult;
import jp.go.aist.six.oval.model.results.DefinitionResults;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.results.SystemResult;
import jp.go.aist.six.oval.model.results.SystemResults;
import jp.go.aist.six.oval.model.results.TestResult;
import jp.go.aist.six.oval.model.results.TestResults;
import jp.go.aist.six.util.castor.CastorDao;
import jp.go.aist.six.util.persist.PersistenceException;
import java.util.UUID;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalResultsDao
    extends CastorDao<String, OvalResults>
{

    private static final String[]  _EXCEPTED_PROPERTIES_ =
        new String[] {
        "persistentID",
        "ovalDefinitions"
        };



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
        if (ovalResults.getPersistentID() == null) {
            String  uuid = UUID.randomUUID().toString();
            ovalResults.setPersistentID( uuid );
        }

    }



    /**
     */
    private void _associateDependents(
                    final OvalResults object
                    )
    throws PersistenceException
    {
        final OvalResults  ovalResults = object;

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
                }
            }
        }
    }



//    /**
//     */
//    private void _createSystem(
//                    final SystemResult system
//                    )
//    {
//        OvalSystemCharacteristics    sc = system.getOvalSystemCharacteristics();
//        OvalSystemCharacteristics  p_sc = getForwardingDao( OvalSystemCharacteristics.class ).sync( sc );
//        system.setOvalSystemCharacteristics( p_sc );
//
//        DefinitionResults  dr_list = system.getDefinitions();
//        if (dr_list != null  &&  dr_list.size() > 0) {
//            for (DefinitionResult  dr : dr_list) {
//                dr.setMasterObject( system );
//            }
//        }
//
//        TestResults  tests = system.getTests();
//        if (tests != null  &&  tests.size() > 0) {
//            for (TestResult  test : tests) {
//                test.setMasterObject( system );
//
//                Collection<TestedItem>  items = test.getTestedItem();
//                if (items != null   &&  items.size() > 0) {
//                    for (TestedItem  item : items) {
//                        item.setMasterObject( test );
//                    }
//                }
//
//                Collection<TestedVariable>  variables = test.getTestedVariable();
//                if (variables != null   &&  variables.size() > 0) {
//                    for (TestedVariable  variable : variables) {
//                        variable.setMasterObject( test );
//                    }
//                }
//            }
//        }
//    }



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    @Override
    protected void _createRelatedTo(
                    final OvalResults object
                    )
    throws PersistenceException
    {
        _beforePersist( object );
        _associateDependents( object );
    }



    @Override
    protected void _updateDeeply(
                    final OvalResults object
                    )
    throws PersistenceException
    {
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
