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

import jp.go.aist.six.oval.model.common.Datatype;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class LiteralVariableComponent
    extends VariableComponent
{

    private Datatype  _datatype;
    //{optional, defualt="string"}



    /**
     * Constructor.
     */
    public LiteralVariableComponent()
    {
    }



    /**
     */
    public void setDatatype(
                    final Datatype datatype
                    )
    {
        _datatype = datatype;
    }



    public Datatype getDatatype()
    {
        return _datatype;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "LiteralVariableComponent[datatype=" + getDatatype()
                        + "]";
    }

}
// LiteralVariableComponent
