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

import jp.go.aist.six.oval.model.common.Datatype;
import jp.go.aist.six.oval.model.common.Operation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;



/**
 * The EntityStateRecord defines an entity that consists of
 * a number of uniquely named fields.
 * This structure is used for representing a record
 * from a database query and other similar structures
 * where multiple related fields must be collected at once.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityStateRecord
    extends EntityStateBase
{

    private Collection<EntityStateField>  _field = new ArrayList<EntityStateField>();
    //{0..*}


    public static final Datatype  FIXED_DATATYPE = Datatype.RECORD;



    /**
     * Constructor.
     */
    public EntityStateRecord()
    {
    }


    /**
     * Constructor.
     */
    public EntityStateRecord(
                    final String data
                    )
    {
        this( data, DEFAULT_OPERATION );
    }


    /**
     * Constructor.
     */
    public EntityStateRecord(
                    final String data,
                    final Operation operation
                    )
    {
        this( data, FIXED_DATATYPE, operation );
    }


    /**
     * Constructor.
     */
    public EntityStateRecord(
                    final String data,
                    final Datatype datatype,
                    final Operation operation
                    )
    {
        super( data, datatype, operation );
    }



    /**
     */
    public void setField(
                    final Collection<? extends EntityStateField> fields
                    )
    {
        if (_field != fields) {
            _field.clear();
            if (fields != null  &&  fields.size() > 0) {
                _field.addAll( fields );
            }
        }
    }


    public boolean addField(
                    final EntityStateField field
                    )
    {
        if (field == null) {
            return false;
        }

        return _field.add( field );
    }


    public EntityStateRecord field(
                    final EntityStateField field
                    )
    {
        addField( field );
        return this;
    }


    public Collection<EntityStateField> getField()
    {
        return _field;
    }


    public Iterator<EntityStateField> iterateField()
    {
        return _field.iterator();
    }



    //**************************************************************
    //  EntityBase
    //**************************************************************

    @Override
    public void setDatatype(
                    final Datatype datatype
                    )
    {
        if (datatype != null  &&  datatype != FIXED_DATATYPE) {
            throw new IllegalArgumentException( "invalid datatype: " + datatype);
        }

        super.setDatatype( datatype );
    }


    @Override
    public Datatype getDatatype()
    {
        return FIXED_DATATYPE;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EntityStateRecord)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "[field=" + getField()
                        + ", " + super.toString()
                        + "]";
    }

}
// EntityStateRecord
