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
 * A collection of State objects.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class States
    extends OvalElementContainer<State> //{1..*}
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
                    final Collection<? extends State> elements
                    )
    {
        super( elements );
    }


    /**
     * Constructor.
     */
    public States(
                    final State[] elements
                    )
    {
        super( elements );
    }



    public void setState(
                    final Collection<? extends State> states
                    )
    {
        reset( states );
    }


    public boolean addState(
                    final State state
                    )
    {
        return add( state );
    }


    public Collection<State> getState()
    {
        return _values();
    }


    public Iterator<State> iterateState()
    {
        return iterator();
    }

}
// States
