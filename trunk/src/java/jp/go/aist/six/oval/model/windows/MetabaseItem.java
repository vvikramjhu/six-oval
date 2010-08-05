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

import jp.go.aist.six.oval.model.ObjectType;
import jp.go.aist.six.oval.model.sc.EntityItemAnySimple;
import jp.go.aist.six.oval.model.sc.EntityItemInt;
import jp.go.aist.six.oval.model.sc.EntityItemString;
import jp.go.aist.six.oval.model.sc.Item;
import jp.go.aist.six.oval.model.sc.Status;
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
    //{0..1}

    private EntityItemInt  _mbID;
    //{0..1, nillable="true"}

    private EntityItemString  _name;
    //{0..1}

    private EntityItemString  _userType;
    //{0..1}

    private EntityItemString  _dataType;
    //{0..1}

    private Collection<EntityItemAnySimple>  _data = new ArrayList<EntityItemAnySimple>();
    //{0..*}



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
                    final Collection<? extends EntityItemAnySimple> data
                    )
    {
        _data.clear();
        _data.addAll( data );
    }


    public Collection<EntityItemAnySimple> getData()
    {
        return _data;
    }



    //**************************************************************
    //  Item
    //**************************************************************

    @Override
    public ObjectType getObjectType()
    {
        return ObjectType.WINDOWS_METABASE;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "MtabaseItem[" + super.toString()
                        + ", key=" + getKey()
                        + ", mb_id=" + getMetabaseID()
                        + ", name=" + getName()
                        + ", user_type=" + getUserType()
                        + ", data_type=" + getDataType()
                        + ", data=" + getData()
                        + "]";
    }

}
// MetabaseItem
