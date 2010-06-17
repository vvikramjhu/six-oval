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

package jp.go.aist.six.oval.model.windows;

import jp.go.aist.six.oval.core.model.system.ItemType;
import jp.go.aist.six.oval.model.system.EntityItemAnyType;
import jp.go.aist.six.oval.model.system.EntityItemIntType;
import jp.go.aist.six.oval.model.system.EntityItemStringType;
import jp.go.aist.six.oval.model.system.Item;
import jp.go.aist.six.oval.model.system.ItemStatus;
import java.util.ArrayList;
import java.util.Collection;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class MetabaseItem
    extends Item
{

    private EntityItemStringType  _key;
    //{oval-sc:EntityItemStringType, 0..1}

    private EntityItemIntType  _mbID;
    //{oval-sc:EntityItemIntType, 0..1, nillable="true"}

    private EntityItemStringType  _name;
    //{oval-sc:EntityItemStringType, 0..1}

    private EntityItemStringType  _userType;
    //{oval-sc:EntityItemStringType, 0..1}

    private EntityItemStringType  _dataType;
    //{oval-sc:EntityItemStringType, 0..1}

    private Collection<EntityItemAnyType>  _data = new ArrayList<EntityItemAnyType>();
    //{oval-sc:EntityItemAnyType, 0..*}



    /**
     * Constructor.
     */
    public MetabaseItem()
    {
    }


    /**
     * Constructor.
     */
    public MetabaseItem(
                    final int id
                    )
    {
        super( id );
    }


    /**
     * Constructor.
     */
    public MetabaseItem(
                    final int id,
                    final ItemStatus status
                    )
    {
        super( id, status );
    }


    public EntityItemStringType getKey()
    {
        return _key;
    }


    public void setKey(
                    final EntityItemStringType key
                    )
    {
        _key = key;
    }



    public EntityItemIntType getMetabaseID()
    {
        return _mbID;
    }


    public void setMetabaseID(
                    final EntityItemIntType id
                    )
    {
        _mbID = id;
    }



    public EntityItemStringType getName()
    {
        return _name;
    }


    public void setName(
                    final EntityItemStringType name
                    )
    {
        _name = name;
    }



    public EntityItemStringType getUserType()
    {
        return _userType;
    }


    public void setUserType(
                    final EntityItemStringType type
                    )
    {
        _userType = type;
    }



    public EntityItemStringType getDataType()
    {
        return _dataType;
    }


    public void setDataType(
                    final EntityItemStringType type
                    )
    {
        _dataType = type;
    }



    public void setData(
                    final Collection<EntityItemAnyType> data
                    )
    {
        _data = data;
    }


    public Collection<EntityItemAnyType> getData()
    {
        return _data;
    }



    //**************************************************************
    //  Item
    //**************************************************************

    @Override
    public ItemType getItemType()
    {
        return ItemType.WINDOWS_METABASE;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "metabase_item[" + super.toString()
                        + ", key=" + getKey()
                        + ", id=" + getMetabaseID()
                        + ", name=" + getName()
                        + ", user_type=" + getUserType()
                        + ", data_type=" + getDataType()
                        + ", data=" + getData()
                        + "]";
    }

}
// MetabaseItem
