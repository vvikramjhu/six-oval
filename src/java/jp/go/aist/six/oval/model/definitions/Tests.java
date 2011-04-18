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

package jp.go.aist.six.oval.model.definitions;

import jp.go.aist.six.oval.model.OvalElementContainer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;



/**
 * A container for one or more Test instances.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
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
                    final Collection<? extends Test> tests
                    )
    {
        setTest( tests );
    }


    /**
     * Constructor.
     */
    public Tests(
                    final Test[] tests
                    )
    {
        setTest( Arrays.asList( tests ) );
    }



    public void setTest(
                    final Collection<? extends Test> tests
                    )
    {
        _setElement( tests );
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
