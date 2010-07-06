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

package jp.go.aist.six.oval.model.system;

import jp.go.aist.six.util.castor.AbstractPersistable;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class VariableValue
    extends AbstractPersistable
{

    private String  _variableID;
    private String  _value;



    public VariableValue()
    {
    }



    public void setVariableID(
                    final String id
                    )
    {
        _variableID = id;
    }


    public String getVariableID()
    {
        return _variableID;
    }



    public void setValue(
                    final String value
                    )
    {
        _value = value;
    }


    public String getValue()
    {
        return _value;
    }



    //**************************************************************
    //  Persistable
    //**************************************************************

    /**
     * The persistent identifier.
     */
    private  String  _persistentID;


    public void setPersistentID(
                    final String id
                    )
    {
        _persistentID = id;
    }


    public String getPersistentID()
    {
        return _persistentID;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "VariableValue [variable_id=" + getVariableID()
                        + ", " + getValue()
                        + "]";
    }

}
// VariableValue
