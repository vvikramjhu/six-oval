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
import jp.go.aist.six.oval.model.system.EntityItemAnySimple;
import jp.go.aist.six.oval.model.system.EntityItemInt;
import jp.go.aist.six.oval.model.system.EntityItemString;
import jp.go.aist.six.oval.model.system.Item;
import jp.go.aist.six.oval.model.system.Status;
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

    private EntityItemString  _key;
    //{oval-sc:EntityItemStringType, 0..1}

    private EntityItemInt  _mbID;
    //{oval-sc:EntityItemIntType, 0..1, nillable="true"}

    private EntityItemString  _name;
    //{oval-sc:EntityItemStringType, 0..1}

    private EntityItemString  _userType;
    //{oval-sc:EntityItemStringType, 0..1}

    private EntityItemString  _dataType;
    //{oval-sc:EntityItemStringType, 0..1}

    private Collection<EntityItemAnySimple>  _data = new ArrayList<EntityItemAnySimple>();
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
                    final Status status
                    )
    {
        super( id, status );
    }


    public EntityItemString getKey()
    {
        return _key;
    }


    public void setKey(
                    final EntityItemString key
                    )
    {
        _key = key;
    }



    public EntityItemInt getMetabaseID()
    {
        return _mbID;
    }


    public void setMetabaseID(
                    final EntityItemInt id
                    )
    {
        _mbID = id;
    }



    public EntityItemString getName()
    {
        return _name;
    }


    public void setName(
                    final EntityItemString name
                    )
    {
        _name = name;
    }



    public EntityItemString getUserType()
    {
        return _userType;
    }


    public void setUserType(
                    final EntityItemString type
                    )
    {
        _userType = type;
    }



    public EntityItemString getDataType()
    {
        return _dataType;
    }


    public void setDataType(
                    final EntityItemString type
                    )
    {
        _dataType = type;
    }



    public void setData(
                    final Collection<EntityItemAnySimple> data
                    )
    {
        _data = data;
    }


    public Collection<EntityItemAnySimple> getData()
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
