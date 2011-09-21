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

package jp.go.aist.six.oval.model.sc;

import jp.go.aist.six.oval.model.common.DatatypeEnumeration;
import jp.go.aist.six.oval.model.v5.Oval5Object;



/**
 * The EntityItemBase is an abstract type that serves as the base type
 * for all item entities.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class EntityAttributeGroup
    implements Oval5Object
{

    public static final DatatypeEnumeration  DEFAULT_DATATYPE =
        DatatypeEnumeration.STRING;

    private DatatypeEnumeration  datatype;
    //{optional, default="string"}


    public static final Boolean  DEFAULT_MASK = Boolean.FALSE;

    private Boolean  mask;
    //{optional, default="false"}

    public static final StatusEnumeration  DEFAULT_STATUS =
        StatusEnumeration.EXISTS;

    private StatusEnumeration  status;
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
        this.datatype = datatype;
    }


    public DatatypeEnumeration getDatatype()
    {
        return this.datatype;
    }


    protected final DatatypeEnumeration _datatype()
    {
        DatatypeEnumeration  datatype = getDatatype();
        return (datatype == null ? DEFAULT_DATATYPE : datatype);
    }



    public void setMask(
                    final Boolean mask
                    )
    {
        this.mask = mask;
    }


    public Boolean getMask()
    {
        return this.mask;
    }


    protected final Boolean _mask()
    {
        Boolean  mask = getMask();
        return (mask == null ? DEFAULT_MASK : mask);
    }



    public void setStatus(
                    final StatusEnumeration status
                    )
    {
        this.status = status;
    }


    public StatusEnumeration getStatus()
    {
        return this.status;
    }


    protected final StatusEnumeration _status()
    {
        StatusEnumeration  status = getStatus();
        return (status == null ? DEFAULT_STATUS : status);
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        DatatypeEnumeration  datatype = _datatype();
        result = prime * result + ((datatype == null) ? 0 : datatype.hashCode());

        Boolean  mask = _mask();
        result = prime * result + (mask ? 0 : 1);

        StatusEnumeration  status = _status();
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
        if (this._status() == other._status()) {
            if (this._datatype() == other._datatype()) {
                if (this._mask() == other._mask()) {
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
             + ", mask=" + getMask()
             + ", status=" + getStatus()
             ;
    }

}
// EntityAttributeGroup
