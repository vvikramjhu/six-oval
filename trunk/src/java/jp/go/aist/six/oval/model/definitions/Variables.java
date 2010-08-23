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
 * A container for one or more Variable instances.
 *
 * <p>Properties:</p>
 * <ul>
 *   <li>variable (1..*)</li>
 * </ul>
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class Variables
    extends OvalElementContainer<Variable>  //{1..*}
{

    /**
     * Constructor.
     */
    public Variables()
    {
    }


    /**
     * Constructor.
     */
    public Variables(
                    final Collection<? extends Variable> elements
                    )
    {
        super( elements );
    }


    /**
     * Constructor.
     */
    public Variables(
                    final Variable[] elements
                    )
    {
        super( elements );
    }



    public void setVariable(
                    final Collection<? extends Variable> variables
                    )
    {
        reset( variables );
    }


    public boolean addVariable(
                    final Variable variable
                    )
    {
        return add( variable );
    }


    public Collection<Variable> getVariable()
    {
        return this;
//      return _values();
    }


    public Iterator<Variable> iterateVariable()
    {
        return iterator();
    }

}
// Variables
