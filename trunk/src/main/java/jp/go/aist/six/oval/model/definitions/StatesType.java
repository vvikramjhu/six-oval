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

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import jp.go.aist.six.oval.model.OvalElementContainer;



/**
 * A container for one or more State instances.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class StatesType
    extends OvalElementContainer<StateType> //{1..*}
//extends Container<State> //{1..*}
{

//    @Reference
    private final Set<StateType>  state = new HashSet<StateType>();



    /**
     * Constructor.
     */
    public StatesType()
    {
    }


    public StatesType(
                    final Collection<? extends StateType> states
                    )
    {
        super( states );
    }


    public StatesType(
                    final StateType[] states
                    )
    {
        super( states );
    }



    public void setState(
                    final Collection<? extends StateType> states
                    )
    {
        _setElement( states );
    }


    public boolean addState(
                    final StateType state
                    )
    {
        return _addElement( state );
    }


    public Collection<StateType> getState()
    {
        return _getElement();
    }


    public Iterator<StateType> iterateState()
    {
        return _iterateElement();
    }



    //**************************************************************
    //  Container
    //**************************************************************

    @Override
    protected Collection<StateType> _getElement()
    {
        return this.state;
    }

}
// StatesType
