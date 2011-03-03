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
import java.util.Iterator;
import jp.go.aist.six.oval.model.v5.OvalElementContainer;



/**
 * A container for one or more Variable instances.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class VariablesType
    extends OvalElementContainer<VariableType>  //{1..*}
//extends Container<Variable>  //{1..*}
{

    /**
     * Constructor.
     */
    public VariablesType()
    {
    }


    /**
     * Constructor.
     */
    public VariablesType(
                    final Collection<? extends VariableType> variables
                    )
    {
        super( variables );
    }


    /**
     * Constructor.
     */
    public VariablesType(
                    final VariableType[] variables
                    )
    {
        super( variables );
    }



    public void setVariable(
                    final Collection<? extends VariableType> variables
                    )
    {
        _setElement( variables );
    }


    public boolean addVariable(
                    final VariableType variable
                    )
    {
        return add( variable );
    }


    public Collection<VariableType> getVariable()
    {
        return _getElement();
    }


    public Iterator<VariableType> iterateVariable()
    {
        return iterator();
    }

}
// VariablesType
