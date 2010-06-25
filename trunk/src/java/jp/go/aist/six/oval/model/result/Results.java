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

import jp.go.aist.six.util.orm.AbstractPersistable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;



/**
 * A collection of System instances.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class Results
    extends AbstractPersistable
    implements Iterable<SystemResult>
{

    private Collection<SystemResult>  _system = new ArrayList<SystemResult>();
    //{1..*}



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
        setSystem( system );
    }


    /**
     * Constructor.
     */
    public Results(
                    final SystemResult[] system
                    )
    {
        setSystem( Arrays.asList( system ) );
    }



    public void setSystem(
                    final Collection<? extends SystemResult> system
                    )
    {
        _system.clear();
        _system.addAll( system );
    }


    public Collection<SystemResult> getSystem()
    {
        return _system;
    }


//    public boolean addSystem(
//                    final SystemResult system
//                    )
//    {
//        return _system.add( system );
//    }


//    public Iterator<SystemResult> iterateSystems()
//    {
//        return _system.iterator();
//    }



    //**************************************************************
    //  Iterable
    //**************************************************************

    public Iterator<SystemResult> iterator()
    {
        return _system.iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "Results["
                        + String.valueOf( _system )
                        + "]";
    }

}
// Results
