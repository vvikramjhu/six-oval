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

package jp.go.aist.six.oval.model.definition;

import jp.go.aist.six.oval.model.common.Datatype;
import jp.go.aist.six.oval.model.common.Operation;
import jp.go.aist.six.util.orm.Persistable;


/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class EntityBaseType
    implements Persistable
{

    private String  _data;
    //{base="xsd:anySimpleType"}

    public static final Datatype  DEFAULT_DATATYPE = Datatype.STRING;
    private Datatype  _datatype = DEFAULT_DATATYPE;
    //{optional,default="string"}

    public static final Operation  DEFAULT_OPERATION = Operation.EQUALS;
    private Operation  _operation = DEFAULT_OPERATION;
    //{optional, default="equals"}

    public static final boolean  DEFAULT_MASK = false;
    private boolean  _mask = DEFAULT_MASK;
    //{optional, default="false"}

    private String  _varRef;
    //{optional, type="oval:VariableIDPattern"}



    /**
     * Constructor.
     */
    public EntityBaseType()
    {
    }



    public void setData(
                    final String data
                    )
    {
        _data = data;
    }


    public String getData()
    {
        return _data;
    }



    public void setDatatype(
                    final Datatype datatype
                    )
    {
        _datatype = datatype;
    }


    public Datatype getDatatype()
    {
        return (_datatype == null ? DEFAULT_DATATYPE : _datatype);
    }



    public void setOperation(
                    final Operation operation
                    )
    {
        _operation = operation;
    }


    public Operation getOperation()
    {
        return _operation;
    }



    public boolean getMask()
    {
        return _mask;
    }


    public void setMask(
                    final boolean mask
                    )
    {
        _mask = mask;
    }



    public void setVariableReference(
                    final String varRef
                    )
    {
        _varRef= varRef;
    }


    public String getVariableReference()
    {
        return _varRef;
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
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        String  data = getData();
        result = prime * result + ((data == null) ? 0 : data.hashCode());

        Datatype  datatype = getDatatype();
        result = prime * result + ((datatype == null) ? 0 : datatype.hashCode());

        Operation  op = getOperation();
        result = prime * result + ((op == null) ? 0 : op.hashCode());

        result = prime * result + (getMask() ? 0 : 1);

        String  var_ref = getVariableReference();
        result = prime * result + ((var_ref == null) ? 0 : var_ref.hashCode());

        return result;
    }



    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EntityBaseType)) {
            return false;
        }

        EntityBaseType  other = (EntityBaseType)obj;
        String  other_data = other.getData();
        String   this_data =  this.getData();
        if (this_data == other_data
                        ||  (this_data != null  &&  this_data.equals( other_data ))) {
            String  other_var_ref = other.getVariableReference();
            String   this_var_ref =  this.getVariableReference();
            if (this_var_ref == other_var_ref
                        ||  (this_var_ref != null  &&  this_var_ref.equals( other_var_ref ))) {
                Operation  other_op = other.getOperation();
                Operation   this_op =  this.getOperation();
                if (this_op == other_op) {
                    Datatype  other_type = other.getDatatype();
                    Datatype   this_type =  this.getDatatype();
                    if (this_type == other_type) {
                        if (this.getMask() == other.getMask()) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }



    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "data=" + getData()
                        + ", datatype=" + getDatatype()
                        + ", operation=" + getOperation()
//                        + ", mask=" + getMask()
                        + ", var_ref=" + getVariableReference();
    }

}
// EntityBaseType
