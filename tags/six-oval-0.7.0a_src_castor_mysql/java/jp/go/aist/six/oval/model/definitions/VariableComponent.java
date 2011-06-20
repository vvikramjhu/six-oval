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



/**
 * The VariableComponent type defines a specific value obtained by
 * looking at the value of another OVAL Variable.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class VariableComponent
    extends Component
{

    private String  _varRef;
    //{required, oval:VariableIDPattern}



    /**
     * Constructor.
     */
    public VariableComponent()
    {
    }


    /**
     * Constructor.
     */
    public VariableComponent(
                    final String varRef
                    )
    {
        setVarRef( varRef );
    }



    /**
     */
    public String getVarRef()
    {
        return _varRef;
    }


    public void setVarRef(
                    final String varRef
                    )
    {
        _varRef = varRef;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "variable_component[var_ref=" + getVarRef()
                        + "]";
    }

}
// VariableComponent