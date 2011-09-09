/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
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
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class ObjectComponent
    extends ComponentElement
{

    private String  _objectRef;
    //{required}

    private String  _itemField;
    //{required}


    private String  _recordField;
    //{optional}



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
        return "ObjectVariableComponent[object_ref=" + getObjectRef()
                        + ", item_field" + getItemField()
                        + ", record_field" + getRecordField()
                        + "]";
    }

}
// ObjectVariableComponent