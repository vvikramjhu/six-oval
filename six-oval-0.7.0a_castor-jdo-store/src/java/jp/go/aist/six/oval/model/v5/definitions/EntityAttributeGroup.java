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

import jp.go.aist.six.oval.model.v5.AbstractOvalObject;
import jp.go.aist.six.oval.model.v5.common.CheckEnumeration;
import jp.go.aist.six.oval.model.v5.common.DatatypeEnumeration;
import jp.go.aist.six.oval.model.v5.common.OperationEnumeration;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class EntityAttributeGroup
    extends AbstractOvalObject
{

    public static final DatatypeEnumeration  DEFAULT_DATATYPE = DatatypeEnumeration.STRING;
    private DatatypeEnumeration  _datatype;
    //{optional, default="string"}


    public static final OperationEnumeration  DEFAULT_OPERATION = OperationEnumeration.EQUALS;
    private OperationEnumeration  _operation;
    //{optional, default="equals"}


    public static final Boolean  DEFAULT_MASK = Boolean.FALSE;
    private Boolean  _mask;
    //{optional, default="false"}


    private String  _varRef;
    //{optional, type="oval:VariableIDPattern"}


    public static final CheckEnumeration  DEFAULT_VAR_CHECK = CheckEnumeration.ALL;
    private CheckEnumeration  _varCheck;
    //{optional, default="all"}



    /**
     * Constructor.
     */
    public EntityAttributeGroup()
    {
    }


    public EntityAttributeGroup(
                    final OperationEnumeration operation
                    )
    {
        this( DEFAULT_DATATYPE, operation );
    }


    public EntityAttributeGroup(
                    final DatatypeEnumeration datatype,
                    final OperationEnumeration operation
                    )
    {
        setDatatype( datatype );
        setOperation( operation );
    }



    public void setDatatype(
                    final DatatypeEnumeration datatype
                    )
    {
        _datatype = datatype;
    }


    public DatatypeEnumeration getDatatype()
    {
        return _datatype;
    }



    public void setOperation(
                    final OperationEnumeration operation
                    )
    {
        _operation = operation;
    }


    public OperationEnumeration getOperation()
    {
        return _operation;
    }



    public Boolean getMask()
    {
        return _mask;
    }


    public void setMask(
                    final Boolean mask
                    )
    {
        _mask = mask;
    }



    public void setVarRef(
                    final String varRef
                    )
    {
        _varRef= varRef;
    }


    public String getVarRef()
    {
        return _varRef;
    }



    /**
     */
    public void setVarCheck(
                    final CheckEnumeration varCheck
                    )
    {
        _varCheck = varCheck;
    }


    public CheckEnumeration getVarCheck()
    {
        return _varCheck;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        DatatypeEnumeration  datatype = getDatatype();
        result = prime * result + ((datatype == null) ? 0 : datatype.hashCode());

        OperationEnumeration  op = getOperation();
        result = prime * result + ((op == null) ? 0 : op.hashCode());

        result = prime * result + (getMask() ? 0 : 1);

        String  var_ref = getVarRef();
        result = prime * result + ((var_ref == null) ? 0 : var_ref.hashCode());

        CheckEnumeration  varCheck = getVarCheck();
        result = prime * result + ((varCheck == null) ? 0 : varCheck.hashCode());

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

        if (!(obj instanceof EntityAttributeGroup)) {
            return false;
        }

        EntityAttributeGroup  other = (EntityAttributeGroup)obj;
        String  other_var_ref = other.getVarRef();
        String   this_var_ref =  this.getVarRef();
        if (this_var_ref == other_var_ref
                        ||  (this_var_ref != null  &&  this_var_ref.equals( other_var_ref ))) {
            OperationEnumeration  other_op = other.getOperation();
            OperationEnumeration   this_op =  this.getOperation();
            if (this_op == other_op) {
                DatatypeEnumeration  other_type = other.getDatatype();
                DatatypeEnumeration   this_type =  this.getDatatype();
                if (this_type == other_type) {
                    if (this.getMask() == other.getMask()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "datatype=" + getDatatype()
                        + ", operation=" + getOperation()
                        + ", mask=" + getMask()
                        + ", var_ref=" + getVarRef()
                        + ", var_check=" + getVarCheck()
                        ;
    }

}
// EntityAttributeGroup
