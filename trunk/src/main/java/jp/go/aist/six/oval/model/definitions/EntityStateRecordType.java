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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.common.CheckEnumeration;
import jp.go.aist.six.oval.model.common.DatatypeEnumeration;
import jp.go.aist.six.oval.model.common.OperationEnumeration;



/**
 * The EntityStateRecordType defines an entity that
 * consists of a number of uniquely named fields.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityStateRecordType
    extends EntityStateComplexBaseType
{

    private final Collection<EntityStateFieldType>  field =
        new ArrayList<EntityStateFieldType>();



    /**
     * Constructor.
     */
    public EntityStateRecordType()
    {
    }


    public EntityStateRecordType(
                    final DatatypeEnumeration datatype,
                    final OperationEnumeration operation,
                    final Boolean mask,
                    final String var_ref,
                    final CheckEnumeration var_check
                    )
    {
        super( datatype, operation, mask, var_ref, var_check );
    }


    public EntityStateRecordType(
                    final String datatype,
                    final String operation,
                    final Boolean mask,
                    final String var_ref,
                    final String var_check
                    )
    {
        super( datatype, operation, mask, var_ref, var_check );
    }



    /**
     */
    public void setField(
                    final Collection<? extends EntityStateFieldType> fieldList
                    )
    {
        if (this.field != fieldList) {
            this.field.clear();
            if (fieldList != null  &&  fieldList.size() > 0) {
                for (EntityStateFieldType  p : fieldList) {
                    addField( p );
                }
            }
        }
    }


    public boolean addField(
                    final EntityStateFieldType field
                    )
    {
        if (field == null) {
            throw new IllegalArgumentException( "empty field" );
        }

        return this.field.add( field );
    }


    public Collection<EntityStateFieldType> getField()
    {
        return this.field;
    }


    public Iterator<EntityStateFieldType> iterateField()
    {
        return getField().iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        Collection<EntityStateFieldType>  field = getField();
        result = prime * result + ((field == null) ? 0 : field.hashCode());

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

        if (!(obj instanceof EntityStateRecordType)) {
            return false;
        }

        EntityStateRecordType  other = (EntityStateRecordType)obj;
        Collection<EntityStateFieldType>  other_field = other.getField();
        Collection<EntityStateFieldType>   this_field =  this.getField();
        if (this_field == other_field
                        ||  (this_field != null  &&  other_field != null
                                        &&  this_field.size() == other_field.size()
                                        &&  this_field.containsAll( other_field ))) {
            return true;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return super.toString()
                        + ", field=" + getField()
                        ;
    }

}
//EntityStateRecordType
