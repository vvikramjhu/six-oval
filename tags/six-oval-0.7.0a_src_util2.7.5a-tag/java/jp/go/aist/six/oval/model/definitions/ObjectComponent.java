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
public class ObjectComponent
    extends Component
{

    private String  _objectRef;
    //{required, oval:ObjectIDPattern}


    private String  _itemField;
    //{required, oval:NonEmptyStringType}


    private String  _recordField;
    //{optional, oval:NonEmptyStringType}



    /**
     * Constructor.
     */
    public ObjectComponent()
    {
    }


    /**
     * Constructor.
     */
    public ObjectComponent(
                    final String objectRef,
                    final String itemField
                    )
    {
        setObjectRef( objectRef );
        setItemField( itemField );
    }



    /**
     */
    public String getObjectRef()
    {
        return _objectRef;
    }


    public void setObjectRef(
                    final String objectRef
                    )
    {
        _objectRef = objectRef;
    }



    /**
     */
    public String getItemField()
    {
        return _itemField;
    }


    public void setItemField(
                    final String itemField
                    )
    {
        _itemField = itemField;
    }



    /**
     */
    public String getRecordField()
    {
        return _recordField;
    }


    public void setRecordField(
                    final String recordField
                    )
    {
        _recordField = recordField;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "object_component[object_ref=" + getObjectRef()
                        + ", item_field=" + getItemField()
                        + ", record_field=" + getRecordField()
                        + "]";
    }

}
// ObjectComponent
