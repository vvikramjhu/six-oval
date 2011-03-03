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

import jp.go.aist.six.oval.model.common.Check;
import jp.go.aist.six.oval.model.common.Datatype;
import jp.go.aist.six.oval.model.common.Operation;
import jp.go.aist.six.oval.model.v5.AbstractOvalObject;



/**
 * The EntitySimpleBaseType complex type is an abstract type
 * that defines the default attributes associated with every simple entity.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class EntitySimpleBase
    extends AbstractOvalObject
{

    private String  _content;
    //{simpleContent, base="xsd:anySimpleType"}


    // xsd:attributeGroup ref="EntityAttributeGroup" //

    public static final Datatype  DEFAULT_DATATYPE = Datatype.STRING;
    private Datatype  _datatype;
    //{optional, default="string"}

    public static final Operation  DEFAULT_OPERATION = Operation.EQUALS;
    private Operation  _operation;
    //{optional, default="equals"}

    public static final Boolean  DEFAULT_MASK = false;
    private Boolean  _mask;
    //{optional, default="false"}

    private String  _varRef;
    //{optional, type="oval:VariableIDPattern"}

    public static final Check  DEFAULT_VAR_CHECK = Check.ALL;
    private Check  _varCheck;
    //{optional, default="all"}



    /**
     * Constructor.
     */
    public EntitySimpleBase()
    {
    }



    /**
     */
    public void setContent(
                    final String content
                    )
    {
        _content = content;
    }


    public String getContent()
    {
        return _content;
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



    /**
     */
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



    /**
     */
    public void setMask(
                    final Boolean mask
                    )
    {
        _mask = mask;
    }


    public Boolean getMask()
    {
        return _mask;
    }



    /**
     */
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
                    final Check check
                    )
    {
        _varCheck = check;
    }


    public Check getVarCheck()
    {
        return _varCheck;
    }



   //**************************************************************
    //  java.lang.Object
    //**************************************************************

//    @Override
//    public int hashCode()
//    {
//        final int  prime = 37;
//        int  result = 17;
//
//        String  data = getContent();
//        result = prime * result + ((data == null) ? 0 : data.hashCode());
//
//        Datatype  datatype = getDatatype();
//        result = prime * result + ((datatype == null) ? 0 : datatype.hashCode());
//
//        Operation  op = getOperation();
//        result = prime * result + ((op == null) ? 0 : op.hashCode());
//
//        result = prime * result + (getMask() ? 0 : 1);
//
//        String  var_ref = getVarRef();
//        result = prime * result + ((var_ref == null) ? 0 : var_ref.hashCode());
//
//        return result;
//    }
//
//
//
//    @Override
//    public boolean equals(
//                    final Object obj
//                    )
//    {
//        if (this == obj) {
//            return true;
//        }
//
//        if (!(obj instanceof EntitySimpleBaseType)) {
//            return false;
//        }
//
//        EntitySimpleBaseType  other = (EntitySimpleBaseType)obj;
//        String  other_data = other.getContent();
//        String   this_data =  this.getContent();
//        if (this_data == other_data
//                        ||  (this_data != null  &&  this_data.equals( other_data ))) {
//            String  other_var_ref = other.getVarRef();
//            String   this_var_ref =  this.getVarRef();
//            if (this_var_ref == other_var_ref
//                        ||  (this_var_ref != null  &&  this_var_ref.equals( other_var_ref ))) {
//                Operation  other_op = other.getOperation();
//                Operation   this_op =  this.getOperation();
//                if (this_op == other_op) {
//                    Datatype  other_type = other.getDatatype();
//                    Datatype   this_type =  this.getDatatype();
//                    if (this_type == other_type) {
//                        if (this.getMask() == other.getMask()) {
//                            return true;
//                        }
//                    }
//                }
//            }
//        }
//
//        return false;
//    }



    @Override
    public String toString()
    {
        return "" + getContent()
                        + ", datatype="  + getDatatype()
                        + ", operation=" + getOperation()
                        + ", mask="      + getMask()
                        + ", var_ref="   + getVarRef()
                        + ", var_check=" + getVarCheck()
                        ;
    }

}
// EntitySimpleBaseType
