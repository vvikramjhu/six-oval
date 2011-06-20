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

import jp.go.aist.six.oval.model.common.Datatype;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;



/**
 * The EntityItemRecord defines an entity that consists
 * of a number of named fields.
 * This structure is used for representing a record
 * from a database query and other similar structures
 * where multiple related fields must be collected at once.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityItemRecord
    extends EntityItemBase
{

    private Collection<EntityItemField>  _field = new ArrayList<EntityItemField>();
    //{0..*}


    public static final Datatype  FIXED_DATATYPE = Datatype.RECORD;



    /**
     * Constructor.
     */
    public EntityItemRecord()
    {
    }


    /**
     * Constructor.
     */
    public EntityItemRecord(
                    final String data
                    )
    {
        this( data, DEFAULT_STATUS );
    }


    /**
     * Constructor.
     */
    public EntityItemRecord(
                    final String data,
                    final Status status
                    )
    {
        this( data, FIXED_DATATYPE, status );
    }


    /**
     * Constructor.
     */
    public EntityItemRecord(
                    final String data,
                    final Datatype datatype,
                    final Status status
                    )
    {
        super( data, datatype, status );
    }



    /**
     */
    public void setField(
                    final Collection<? extends EntityItemField> fields
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
                    final EntityItemField field
                    )
    {
        if (field == null) {
            return false;
        }

        return _field.add( field );
    }


    public EntityItemRecord field(
                    final EntityItemField field
                    )
    {
        addField( field );
        return this;
    }


    public Collection<EntityItemField> getField()
    {
        return _field;
    }


    public Iterator<EntityItemField> iterateField()
    {
        return _field.iterator();
    }



    //**************************************************************
    //  EntityItemBase
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

        if (!(obj instanceof EntityItemRecord)) {
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
// EntityItemRecord