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
 * A container for one or more State instances.
 *
 * <p>Properties:</p>
 * <ul>
 *   <li>state (1..*)</li>
 * </ul>
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class States
    extends Container<State> //{1..*}
//extends OvalElementContainer<State> //{1..*}
{

    /**
     * Constructor.
     */
    public States()
    {
    }


    /**
     * Constructor.
     */
    public States(
                    final Collection<? extends State> states
                    )
    {
        super( states );
    }


    /**
     * Constructor.
     */
    public States(
                    final State[] states
                    )
    {
        super( states );
    }



    public void setState(
                    final Collection<? extends State> states
                    )
    {
        _setElement( states );
//        if (_getElement() != states) {
//            clear();
//            if (states != null  &&  states.size() > 0) {
//                addAll( states );
//            }
//        }
    }


    public boolean addState(
                    final State state
                    )
    {
        return add( state );
    }


    public Collection<State> getState()
    {
        return _getElement();
    }


    public Iterator<State> iterateState()
    {
        return iterator();
    }

}
// States