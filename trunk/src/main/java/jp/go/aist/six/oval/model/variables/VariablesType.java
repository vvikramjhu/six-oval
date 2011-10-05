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

package jp.go.aist.six.oval.model.variables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.Container;



/**
 * The VariablesType is a container for one or more variables.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class VariablesType
    extends Container<VariableType> //{1..*}
{

    private final Collection<VariableType>  variable = new ArrayList<VariableType>();



    /**
     * Constructor.
     */
    public VariablesType()
    {
    }


    public VariablesType(
                    final Collection<VariableType> variableList
                    )
    {
        setVariable( variableList );
    }


    public VariablesType(
                    final VariableType[] variableList
                    )
    {
        setVariable( Arrays.asList( variableList ) );
    }



    /**
     */
    public void setVariable(
                    final Collection<? extends VariableType> variableList
                    )
    {
        _setElement( variableList );
    }


    public boolean addVariable(
                    final VariableType variable
                    )
    {
        return _addElement( variable );
    }


    public Collection<VariableType> getVariable()
    {
        return _getElement();
    }


    public Iterator<VariableType> iterateVariable()
    {
        return _iterateElement();
    }



    //**************************************************************
    //  Container
    //**************************************************************

    @Override
    protected Collection<VariableType> _getElement()
    {
        return this.variable;
    }

}
//VariablesType
