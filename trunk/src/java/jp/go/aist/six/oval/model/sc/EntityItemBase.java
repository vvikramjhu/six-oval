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

import jp.go.aist.six.oval.model.AbstractOvalObject;
import jp.go.aist.six.oval.model.common.Datatype;



/**
 * The EntityItemBase is an abstract type that serves as the base type
 * for all item entities.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class EntityItemBase
    extends AbstractOvalObject
{

    private String  _data;
    //{base="xsd:anyType"}

    public static final Datatype  DEFAULT_DATATYPE = Datatype.STRING;
    private Datatype  _datatype;
    //{optional, default="string"}

    public static final boolean  DEFAULT_MASK = false;
    private boolean  _mask = DEFAULT_MASK;
    //{optional, default="false"}

    public static final Status  DEFAULT_STATUS = Status.EXISTS;
    private Status  _status;
    //{optional, default="exists"}



    /**
     * Constructor.
     */
    public EntityItemBase()
    {
    }


    /**
     * Constructor.
     */
    public EntityItemBase(
                    final String data
                    )
    {
        this( data, DEFAULT_STATUS );
    }


    /**
     * Constructor.
     */
    public EntityItemBase(
                    final String data,
                    final Datatype datatype
                    )
    {
        this( data, datatype, DEFAULT_STATUS );
    }


    /**
     * Constructor.
     */
    public EntityItemBase(
                    final String data,
                    final Status status
                    )
    {
        this( data, DEFAULT_DATATYPE, status );
    }


    /**
     * Constructor.
     */
    public EntityItemBase(
                    final String data,
                    final Datatype datatype,
                    final Status status
                    )
    {
        setData( data );
        setDatatype( datatype );
        setStatus( status );
    }



    /**
     */
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



    public void setStatus(
                    final Status status
                    )
    {
        _status = status;
    }


    public Status getStatus()
    {
        return (_status == null ? DEFAULT_STATUS : _status);
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        String  data = getData();
        result = prime * result + ((data == null) ? 0 : data.hashCode());

        Datatype  datatype = getDatatype();
        result = prime * result + ((datatype == null) ? 0 : datatype.hashCode());

        result = prime * result + (getMask() ? 0 : 1);

        Status  status = getStatus();
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

        if (!(obj instanceof EntityItemBase)) {
            return false;
        }

        EntityItemBase  other = (EntityItemBase)obj;
        String  other_data = other.getData();
        String   this_data =  this.getData();
        if (this_data == other_data
                        ||  (this_data != null  &&  this_data.equals( other_data ))) {
            Status  other_status = other.getStatus();
            Status   this_status =  this.getStatus();
            if (this_status == other_status) {
                Datatype  other_type = other.getDatatype();
                Datatype   this_type =  this.getDatatype();
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
                        + ", status=" + getStatus()
//                        + ", mask=" + getMask()
                        + ", data=" + getData();
    }

}
// EntityItemBase
