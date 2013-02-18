/*
*  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.go.aist.six.oval.model.sc;

import jp.go.aist.six.oval.model.OvalObject;
import jp.go.aist.six.oval.model.common.DatatypeEnumeration;



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
        return datatype;
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
        return mask;
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
        return status;
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
