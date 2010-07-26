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

import jp.go.aist.six.oval.model.definition.ComplexTest;
import jp.go.aist.six.oval.model.definition.StateRef;
import jp.go.aist.six.oval.model.definition.Test;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class TestDao
    extends OvalEntityDao<Test>
{

    public TestDao()
    {
        super( Test.class );
    }



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    @Override
    public String create(
                    final Test test
                    )
    {
        if (test instanceof ComplexTest) {
            ComplexTest  ctest = (ComplexTest)test;
            for (StateRef  sref : ctest.getState()) {
                sref.setMasterObject( test );
            }
        }

        return super.create( test );
    }

}
// TestDao
