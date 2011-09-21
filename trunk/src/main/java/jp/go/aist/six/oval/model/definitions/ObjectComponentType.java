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



/**
 * The ObjectComponent type defines a specific value or set of values
 * on the local system to obtain.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class ObjectComponentType
    extends ComponentGroup
{

    private String  object_ref;
    //{required, oval:ObjectIDPattern}


    private String  item_field;
    //{required, oval:NonEmptyStringType}


    private String  record_field;
    //{optional, oval:NonEmptyStringType}



    /**
     * Constructor.
     */
    public ObjectComponentType()
    {
    }


    public ObjectComponentType(
                    final String object_ref,
                    final String item_field
                    )
    {
        setObjectRef( object_ref );
        setItemField( item_field );
    }



    /**
     */
    public void setObjectRef(
                    final String object_ref
                    )
    {
        this.object_ref = object_ref;
    }


    public String getObjectRef()
    {
        return this.object_ref;
    }



    /**
     */
    public void setItemField(
                    final String item_field
                    )
    {
        this.item_field = item_field;
    }


    public String getItemField()
    {
        return this.item_field;
    }



    /**
     */
    public void setRecordField(
                    final String record_field
                    )
    {
        this.record_field = record_field;
    }


    public String getRecordField()
    {
        return this.record_field;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "[object_ref="       + getObjectRef()
             + ", item_field="      + getItemField()
             + ", record_field="    + getRecordField()
             + "]";
    }

}
// ObjectComponentType
