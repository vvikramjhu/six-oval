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

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import jp.go.aist.six.oval.model.ElementContainer;
import com.google.code.morphia.annotations.Reference;



/**
 * A container for one or more Test instances.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class TestsType
    extends ElementContainer<TestType>  //{1..*}
{

    @Reference
    private final Set<TestType>  test = new HashSet<TestType>();



    /**
     * Constructor.
     */
    public TestsType()
    {
    }


    public TestsType(
                    final Collection<? extends TestType> test_list
                    )
    {
//        super( tests );

//        test.addAll( test_list );
        _copy( test, test_list );
    }


    public TestsType(
                    final TestType[] test_list
                    )
    {
//        super( tests );

        this( Arrays.asList( test_list ) );
    }



    /**
     */
    public void setTest(
                    final Collection<? extends TestType> test_list
                    )
    {
        reset( test_list );
//        _setElement( test_list );
    }


    public void setTest(
                    final TestType[] test_list
                    )
    {
        reset( test_list );
    }


    public Collection<TestType> getTest()
    {
        return _getCollection();
    }


//    public boolean addTest(
//                    final TestType test
//                    )
//    {
//        return add( test );
//    }
//
//
//    public Iterator<TestType> iterateTest()
//    {
//        return iterator();
//    }


    //**************************************************************
    //  Container
    //**************************************************************

    @Override
    protected Collection<TestType> _getCollection()
    {
        return test;
    }

}
//
