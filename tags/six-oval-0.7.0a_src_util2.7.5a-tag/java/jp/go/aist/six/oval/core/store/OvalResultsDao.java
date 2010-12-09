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
import jp.go.aist.six.oval.model.results.TestResult;
import jp.go.aist.six.oval.model.results.TestResults;
import jp.go.aist.six.oval.model.results.TestedItem;
import jp.go.aist.six.oval.model.results.TestedVariable;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
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
    private void _createSystem(
                    final SystemResult system
                    )
    {
        OvalSystemCharacteristics    sc = system.getOvalSystemCharacteristics();
        OvalSystemCharacteristics  p_sc = getForwardingDao( OvalSystemCharacteristics.class ).sync( sc );
        system.setOvalSystemCharacteristics( p_sc );

        DefinitionResults  dr_list = system.getDefinitions();
        if (dr_list != null  &&  dr_list.size() > 0) {
            for (DefinitionResult  dr : dr_list) {
                dr.setMasterObject( system );
            }
        }

        TestResults  tests = system.getTests();
        if (tests != null  &&  tests.size() > 0) {
            for (TestResult  test : tests) {
                test.setMasterObject( system );

                Collection<TestedItem>  items = test.getTestedItem();
                if (items != null   &&  items.size() > 0) {
                    for (TestedItem  item : items) {
                        item.setMasterObject( test );
                    }
                }

                Collection<TestedVariable>  variables = test.getTestedVariable();
                if (variables != null   &&  variables.size() > 0) {
                    for (TestedVariable  variable : variables) {
                        variable.setMasterObject( test );
                    }
                }
            }
        }
    }



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    @Override
    public String create(
                    final OvalResults results
                    )
    throws PersistenceException
    {
        if (results.getPersistentID() == null) {
            String  uuid = UUID.randomUUID().toString();
            results.setPersistentID( uuid );
        }

        for (SystemResult  system : results.getResults()) {
            system.setMasterObject( results );

            _createSystem( system );
        }

        OvalDefinitions  defs = results.getOvalDefinitions();
        if (defs != null) {
            OvalDefinitions  p_defs = getForwardingDao( OvalDefinitions.class ).sync( defs );
            results.setOvalDefinitions( p_defs );
        }

        return super.create( results );
    }

}
// OvalResultsDao
