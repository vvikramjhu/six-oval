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

package jp.go.aist.six.oval.model.v5.definitions;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import jp.go.aist.six.oval.model.v5.OvalElementContainer;



/**
 * A container for one or more Test instances.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class TestsType
    extends OvalElementContainer<TestType>  //{1..*}
{

//    @Reference
    private final Set<TestType>  test = new HashSet<TestType>();



    /**
     * Constructor.
     */
    public TestsType()
    {
    }


    public TestsType(
                    final Collection<? extends TestType> tests
                    )
    {
        super( tests );
    }


    public TestsType(
                    final TestType[] tests
                    )
    {
        super( tests );
    }



    public void setTest(
                    final Collection<? extends TestType> tests
                    )
    {
        _setElement( tests );
    }


    public boolean addTest(
                    final TestType test
                    )
    {
        return _addElement( test );
    }


    public Collection<TestType> getTest()
    {
        return _getElement();
    }


    public Iterator<TestType> iterateTest()
    {
        return _iterateElement();
    }


    //**************************************************************
    //  Container
    //**************************************************************

    @Override
    protected Collection<TestType> _getElement()
    {
        return this.test;
    }

}
// TestsType
