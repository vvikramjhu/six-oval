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

package jp.go.aist.six.oval.model.v5.sc;

import jp.go.aist.six.oval.model.AbstractOvalObject;
import jp.go.aist.six.oval.model.v5.common.DatatypeEnumeration;



/**
 * The EntityItemBase is an abstract type that serves as the base type
 * for all item entities.
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

    public static final Boolean  DEFAULT_MASK = Boolean.FALSE;
    private Boolean  _mask;
    //{optional, default="false"}

    public static final StatusEnumeration  DEFAULT_STATUS = StatusEnumeration.EXISTS;
    private StatusEnumeration  _status;
    //{optional, default="exists"}



    /**
     * Constructor.
     */
    public EntityAttributeGroup()
    {
    }



    /**
     */
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



    public void setStatus(
                    final StatusEnumeration status
                    )
    {
        _status = status;
    }


    public StatusEnumeration getStatus()
    {
        return _status;
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

        Boolean  mask = getMask();
        if (mask == null) {
            mask = DEFAULT_MASK;
        }
        result = prime * result + (mask ? 0 : 1);

        StatusEnumeration  status = getStatus();
        result = prime * result + ((status == null) ? 0 : status.hashCode());

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
        StatusEnumeration  other_status = other.getStatus();
        StatusEnumeration   this_status =  this.getStatus();
        if (this_status == other_status) {
            DatatypeEnumeration  other_type = other.getDatatype();
            DatatypeEnumeration   this_type =  this.getDatatype();
            if (this_type == other_type) {
                Boolean  this_mask = this.getMask();
                if (this_mask == null) {
                    this_mask = DEFAULT_MASK;
                }
                Boolean  other_mask = other.getMask();
                if (other_mask == null) {
                    other_mask = DEFAULT_MASK;
                }
                if (this.getMask() == other.getMask()) {
                    return true;
                }
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "datatype=" + getDatatype()
                        + ", status=" + getStatus()
//                        + ", mask=" + getMask()
                        ;
    }

}
// EntityAttributeGroup
