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

package jp.go.aist.six.oval.model.result;

import jp.go.aist.six.oval.model.Container;
import java.util.Arrays;
import java.util.Collection;



/**
 * A collection of System instances.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class Results
    extends Container<SystemResult> //{1..*}
{

    /**
     * Constructor.
     */
    public Results()
    {
    }


    /**
     * Constructor.
     */
    public Results(
                    final Collection<? extends SystemResult> system
                    )
    {
        super( system );
    }


    /**
     * Constructor.
     */
    public Results(
                    final SystemResult[] system
                    )
    {
        super( Arrays.asList( system ) );
    }



    public void setSystem(
                    final Collection<? extends SystemResult> system
                    )
    {
        reset( system );
    }


    public Collection<SystemResult> getSystem()
    {
        return _elements();
    }


//    public boolean addSystem(
//                    final SystemResult system
//                    )
//    {
//        return add( system );
//    }


//    public Iterator<SystemResult> iterateSystems()
//    {
//        return iterator();
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "Results["
                        + super.toString()
                        + "]";
    }

}
// Results
