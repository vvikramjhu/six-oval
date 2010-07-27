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

package jp.go.aist.six.oval.model.result;

import jp.go.aist.six.util.castor.AbstractPersistable;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class TestedVariable
    extends AbstractPersistable
{

    private String  _value;
    //{simpleContent, base=xsd:anySimpleType}


    private String  _variableID;
    //{required, type="oval:VariableIDPattern"}



    /**
     * Constructor.
     */
    public TestedVariable()
    {
    }


    /**
     * Constructor.
     */
    public TestedVariable(
                    final String variableID,
                    final String value
                    )
    {
        setVariableID( variableID );
        setValue( value );
    }



    /**
     */
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



    /**
     */
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



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        String  value = getValue();
        result = prime * result + ((value == null) ? 0 : value.hashCode());

        String  varID = getVariableID();
        result = prime * result + ((varID == null) ? 0 : varID.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TestedVariable)) {
            return false;
        }

        TestedVariable  other = (TestedVariable)obj;
        String  other_value = other.getValue();
        String   this_value =  this.getValue();
        if (this_value == other_value
                        ||  (this_value != null  &&  this_value.equals( other_value ))) {
            String  other_varID = other.getVariableID();
            String   this_varID =  this.getVariableID();
            if (this_varID == other_varID
                            ||  (this_varID != null  &&  this_varID.equals( other_varID ))) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "TestedVariable[variable_id=" + getVariableID()
                        + ", value=" + getValue()
                        + "]";
    }

}
// TestedVariable
