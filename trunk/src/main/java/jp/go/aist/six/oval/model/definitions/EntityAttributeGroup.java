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

import jp.go.aist.six.oval.model.OvalObject;
import jp.go.aist.six.oval.model.common.CheckEnumeration;
import jp.go.aist.six.oval.model.common.DatatypeEnumeration;
import jp.go.aist.six.oval.model.common.OperationEnumeration;



/**
 * The EntityAttributeGroup is a collection of attributes that are common to all entities.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class EntityAttributeGroup
    implements OvalObject
{

    public static final DatatypeEnumeration  DEFAULT_DATATYPE =
        DatatypeEnumeration.STRING;

    private DatatypeEnumeration  datatype;
    //{optional, default="string"}


    public static final OperationEnumeration  DEFAULT_OPERATION =
        OperationEnumeration.EQUALS;

    private OperationEnumeration  operation;
    //{optional, default="equals"}


    public static final Boolean  DEFAULT_MASK = Boolean.FALSE;

    private Boolean  mask;
    //{optional, default="false"}


    private String  var_ref;
    //{optional, type="oval:VariableIDPattern"}


//    public static final CheckEnumeration  DEFAULT_VAR_CHECK =
//        CheckEnumeration.ALL;

    private CheckEnumeration  var_check;
    //{optional}: 5.10 (30358)
    //{optional, default="all"}: 5.9



    /**
     * Constructor.
     */
    public EntityAttributeGroup()
    {
    }


//    public EntityAttributeGroup(
//                    final OperationEnumeration operation
//                    )
//    {
//        this( DEFAULT_DATATYPE, operation );
//    }
//
//
//    public EntityAttributeGroup(
//                    final DatatypeEnumeration datatype,
//                    final OperationEnumeration operation
//                    )
//    {
//        setDatatype( datatype );
//        setOperation( operation );
//    }


    public EntityAttributeGroup(
                    final DatatypeEnumeration datatype,
                    final OperationEnumeration operation,
                    final Boolean mask,
                    final String var_ref,
                    final CheckEnumeration var_check
                    )
    {
        setDatatype( datatype );
        setOperation( operation );
        setMask( mask );
        setVarRef( var_ref );
        setVarCheck( var_check );
    }


    public EntityAttributeGroup(
                    final String datatype,
                    final String operation,
                    final Boolean mask,
                    final String var_ref,
                    final String var_check
                    )
    {
        this(
                        (datatype == null ? null : DatatypeEnumeration.fromValue( datatype )),
                        (operation == null ? null : OperationEnumeration.fromValue( operation )),
                        mask,
                        var_ref,
                        (var_check == null ? null : CheckEnumeration.fromValue( var_check ))
        );
    }



    /**
     */
    public void setDatatype(
                    final DatatypeEnumeration datatype
                    )
    {
        this.datatype = datatype;
    }


    public DatatypeEnumeration getDatatype()
    {
        return datatype;
    }


    public static final DatatypeEnumeration datatype(
                    final EntityAttributeGroup eag
                    )
    {
        if (eag == null) {
            throw new IllegalArgumentException( "null EntityAttributeGroup" );
        }

        DatatypeEnumeration  datatype = eag.getDatatype();
        if (datatype == null) {
            datatype = DEFAULT_DATATYPE;
        }

        return datatype;
    }



    /**
     */
    public void setOperation(
                    final OperationEnumeration operation
                    )
    {
        this.operation = operation;
    }


    public OperationEnumeration getOperation()
    {
        return operation;
    }


    public static final OperationEnumeration operation(
                    final EntityAttributeGroup eag
                    )
    {
        if (eag == null) {
            throw new IllegalArgumentException( "null EntityAttributeGroup" );
        }

        OperationEnumeration  operation = eag.getOperation();
        if (operation == null) {
            operation = DEFAULT_OPERATION;
        }

        return operation;
    }



    /**
     */
    public void setMask(
                    final Boolean mask
                    )
    {
        this.mask = mask;
    }


    public Boolean getMask()
    {
        return mask;
    }


    public static final Boolean mask(
                    final EntityAttributeGroup eag
                    )
    {
        if (eag == null) {
            throw new IllegalArgumentException( "null EntityAttributeGroup" );
        }

        Boolean  mask = eag.getMask();
        if (mask == null) {
            mask = DEFAULT_MASK;
        }

        return mask;
    }



    /**
     */
    public void setVarRef(
                    final String var_ref
                    )
    {
        this.var_ref= var_ref;
    }


    public String getVarRef()
    {
        return var_ref;
    }



    /**
     */
    public void setVarCheck(
                    final CheckEnumeration var_check
                    )
    {
        this.var_check = var_check;
    }


    public CheckEnumeration getVarCheck()
    {
        return var_check;
    }


//    public static final CheckEnumeration varCheck(
//                    final EntityAttributeGroup eag
//                    )
//    {
//        if (eag == null) {
//            throw new IllegalArgumentException( "null EntityAttributeGroup" );
//        }
//
//        CheckEnumeration  var_check = eag.getVarCheck();
//        if (var_check == null) {
//            var_check = DEFAULT_VAR_CHECK;
//        }
//
//        return var_check;
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        result = prime * result + datatype( this ).hashCode();

        result = prime * result + operation( this ).hashCode();

        result = prime * result + mask( this ).hashCode();

        String  var_ref = getVarRef();
        result = prime * result + ((var_ref == null) ? 0 : var_ref.hashCode());

        CheckEnumeration  var_check = getVarCheck();
        result = prime * result + ((var_check == null) ? 0 : var_check.hashCode());

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
        if (datatype( this ) == datatype( other )) {
            if (operation( this ) == operation( other )) {
                if (this.getVarCheck() == other.getVarCheck()) {
                    final String  other_var_ref = other.getVarRef();
                    final String   this_var_ref =  this.getVarRef();
                    if (this_var_ref == other_var_ref
                                    ||  (this_var_ref != null
                                                    &&  this_var_ref.equals( other_var_ref ))) {
                        if (mask( this ) == mask( other )) {
                            return true;
                        }
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
