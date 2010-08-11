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

import jp.go.aist.six.oval.model.OvalElementContainer;
import java.util.Collection;
import java.util.Iterator;



/**
 * A container for one or more Test objects.
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
    extends OvalElementContainer<Test>  //{1..*}
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
                    final Collection<? extends Test> elements
                    )
    {
        super( elements );
    }


    /**
     * Constructor.
     */
    public Tests(
                    final Test[] elements
                    )
    {
        super( elements );
    }



    public void setTest(
                    final Collection<? extends Test> elements
                    )
    {
        reset( elements );
    }


    public boolean addTest(
                    final Test e
                    )
    {
        return add( e );
    }


    public Collection<Test> getTest()
    {
        return _values();
    }


    public Iterator<Test> iterateTest()
    {
        return iterator();
    }

}
// Tests
