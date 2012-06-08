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

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import jp.go.aist.six.oval.model.Container;



/**
 * The VariablesType is a container for one or more variables.
 *
 * <p>Constraints:
 * The id of each object is unique in this container.
 * </p>
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class VariablesType
    extends Container<VariableType> //{1..*}
{

    private final Collection<VariableType>  variable = new HashSet<VariableType>();



    /**
     * Constructor.
     */
    public VariablesType()
    {
    }


    public VariablesType(
                    final Collection<VariableType> variable_list
                    )
    {
        _copy( variable, variable_list );
    }


    public VariablesType(
                    final VariableType[] variable_list
                    )
    {
        this( Arrays.asList( variable_list ) );
    }



    /**
     */
    public void setVariable(
                    final Collection<? extends VariableType> variable_list
                    )
    {
        reset( variable_list );
//        _setElement( variable_list );
    }


    public void setVariable(
                    final VariableType[] variable_list
                    )
    {
        reset( variable_list );
    }


    public Collection<VariableType> getVariable()
    {
        return _getCollection();
    }


//    public boolean addVariable(
//                    final VariableType variable
//                    )
//    {
//        return add( variable );
//    }
//
//
//    public Iterator<VariableType> iterateVariable()
//    {
//        return iterator();
//    }



    //**************************************************************
    //  Container
    //**************************************************************

    @Override
    protected Collection<VariableType> _getCollection()
    {
        return variable;
    }

}
//
