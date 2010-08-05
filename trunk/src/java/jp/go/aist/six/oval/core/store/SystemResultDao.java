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

import jp.go.aist.six.oval.model.result.DefinitionResult;
import jp.go.aist.six.oval.model.result.DefinitionResults;
import jp.go.aist.six.oval.model.result.SystemResult;
import jp.go.aist.six.oval.model.result.TestResult;
import jp.go.aist.six.oval.model.result.TestResults;
import jp.go.aist.six.oval.model.result.TestedItem;
import jp.go.aist.six.oval.model.result.TestedVariable;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.util.castor.CastorDao;
import java.util.Collection;
import java.util.UUID;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class SystemResultDao
    extends CastorDao<String, SystemResult>
{

    public SystemResultDao()
    {
        super( SystemResult.class );
    }



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    @Override
    public String create(
                    final SystemResult system
                    )
    {
        if (system.getPersistentID() == null) {
            String  uuid = UUID.randomUUID().toString();
            system.setPersistentID( uuid );
        }

        OvalSystemCharacteristics  sc = system.getOvalSystemCharacteristics();
        getForwardingDao( OvalSystemCharacteristics.class ).create( sc );


        DefinitionResults  dr_list = system.getDefinitions();
        if (dr_list != null  &&  dr_list.size() > 0) {
//            DefinitionResults  p_dr_list = new DefinitionResults();
            for (DefinitionResult  dr : dr_list) {
                dr.setMasterObject( system );
//                DefinitionResult  p_dr = getForwardingDao( DefinitionResult.class ).sync( dr );
//                p_dr_list.add( p_dr );
            }

//            system.setDefinitions( p_dr_list );
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

        return super.create( system );
    }

}
// SystemResultDao
