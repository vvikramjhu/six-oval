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

package jp.go.aist.six.oval.model.definitions;

import jp.go.aist.six.oval.model.Container;
import java.util.Collection;
import java.util.Iterator;



/**
 * A container for one or more Test instances.
 *
 * <p>Properties:</p>
 * <ul>
 *   <li>test (1..*)</li>
 * </ul>
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class Tests
    extends Container<Test>  //{1..*}
//extends OvalElementContainer<Test>  //{1..*}
{

    /**
     * Constructor.
     */
    public Tests()
    {
    }


    /**
     * Constructor.
     */
    public Tests(
                    final Collection<? extends Test> tests
                    )
    {
        super( tests );
    }


    /**
     * Constructor.
     */
    public Tests(
                    final Test[] tests
                    )
    {
        super( tests );
    }



    public void setTest(
                    final Collection<? extends Test> tests
                    )
    {
        _setElement( tests );

//        if (_getElement() != tests) {
//            clear();
//            if (tests != null  &&  tests.size() > 0) {
//                addAll( tests );
//            }
//        }
    }


    public boolean addTest(
                    final Test test
                    )
    {
        return add( test );
    }


    public Collection<Test> getTest()
    {
        return _getElement();
    }


    public Iterator<Test> iterateTest()
    {
        return iterator();
    }

}
// Tests
