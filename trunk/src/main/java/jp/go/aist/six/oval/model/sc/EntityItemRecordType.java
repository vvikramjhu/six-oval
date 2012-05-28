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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;



/**
 * The EntityItemRecordType defines an entity that consists of a number of named fields.
 * This structure is used for representing a record from a database query
 * and other similar structures where multiple related fields must be collected at once.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityItemRecordType
    extends EntityItemComplexBaseType
{

    private final Collection<EntityItemFieldType>  field =
                    new ArrayList<EntityItemFieldType>();
    //{0..*}



    /**
     * Constructor.
     */
    public EntityItemRecordType()
    {
    }



    /**
     */
    public void setField(
                    final Collection<? extends EntityItemFieldType> field_list
                    )
    {
        if (field != field_list) {
            field.clear();
            if (field_list != null  &&  field_list.size() > 0) {
                for (EntityItemFieldType  p : field_list) {
                    addField( p );
                }
            }
        }
    }


    public boolean addField(
                    final EntityItemFieldType field
                    )
    {
        if (field == null) {
            throw new IllegalArgumentException( "empty field" );
        }

        return this.field.add( field );
    }


    public Collection<EntityItemFieldType> getField()
    {
        return field;
    }


    public Iterator<EntityItemFieldType> iterateField()
    {
        return getField().iterator();
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

        if (!(obj instanceof EntityItemRecordType)) {
            return false;
        }

        return super.equals( obj );
    }



//    @Override
//    public String toString()
//    {
//        return "[" + super.toString() + "]";
//    }

}
//
