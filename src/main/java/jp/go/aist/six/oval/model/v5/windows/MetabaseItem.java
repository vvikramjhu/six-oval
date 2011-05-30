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

package jp.go.aist.six.oval.model.v5.windows;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import jp.go.aist.six.oval.model.v5.PlatformEntityType;
import jp.go.aist.six.oval.model.v5.sc.EntityAttributeGroup;
import jp.go.aist.six.oval.model.v5.sc.EntityItemAnySimpleType;
import jp.go.aist.six.oval.model.v5.sc.EntityItemIntType;
import jp.go.aist.six.oval.model.v5.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.v5.sc.ItemType;



/**
 * The metabase item gathers information from the specified metabase keys.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class MetabaseItem
    extends ItemType
{

    private final Map<MetabaseProperty, EntityAttributeGroup>  _properties =
        new EnumMap<MetabaseProperty, EntityAttributeGroup>( MetabaseProperty.class );

//    private EntityItemStringType  _key;
//    //{0..1}
//
//    private EntityItemIntType  _metabaseID;   //renamed!!!
//    //{0..1, nillable="true"}
//
//    private EntityItemStringType  _name;
//    //{0..1}
//
//    private EntityItemStringType  _userType;
//    //{0..1}
//
//    private EntityItemStringType  _dataType;
//    //{0..1}

    private final Collection<EntityItemAnySimpleType>  _data = new ArrayList<EntityItemAnySimpleType>();
    //{0..*}



    /**
     * Constructor.
     */
    public MetabaseItem()
    {
    }


    public MetabaseItem(
                    final int id
                    )
    {
        super( id );
    }



    /**
     */
    public EntityItemStringType getKey()
    {
        return (EntityItemStringType)_properties.get( MetabaseProperty.KEY );
    }


    public void setKey(
                    final EntityItemStringType key
                    )
    {
        _properties.put( MetabaseProperty.KEY, key );
    }



    /**
     */
    public EntityItemIntType getMetabaseID()
    {
        return (EntityItemIntType)_properties.get( MetabaseProperty.ID );
    }


    public void setMetabaseID(
                    final EntityItemIntType id
                    )
    {
        _properties.put( MetabaseProperty.ID, id );
    }



    /**
     */
    public EntityItemStringType getName()
    {
        return (EntityItemStringType)_properties.get( MetabaseProperty.NAME );
    }


    public void setName(
                    final EntityItemStringType name
                    )
    {
        _properties.put( MetabaseProperty.NAME, name );
    }



    public EntityItemStringType getUserType()
    {
        return (EntityItemStringType)_properties.get( MetabaseProperty.USER_TYPE );
    }


    public void setUserType(
                    final EntityItemStringType type
                    )
    {
        _properties.put( MetabaseProperty.USER_TYPE, type );
    }



    /**
     */
    public EntityItemStringType getDataType()
    {
        return (EntityItemStringType)_properties.get( MetabaseProperty.DATA_TYPE );
    }


    public void setDataType(
                    final EntityItemStringType type
                    )
    {
        _properties.put( MetabaseProperty.DATA_TYPE, type );
    }



    /**
     */
    public void setData(
                    final Collection<? extends EntityItemAnySimpleType> dataSequence
                    )
    {
        if (dataSequence != _data) {
            _data.clear();
            if (dataSequence != null  &&  dataSequence.size() > 0) {
                _data.addAll( dataSequence );
            }
        }
    }


    public Collection<EntityItemAnySimpleType> getData()
    {
        return _data;
    }


    public Iterator<EntityItemAnySimpleType> iterateData()
    {
        return _data.iterator();
    }



    //**************************************************************
    //  Item
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.WINDOWS_METABASE;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "mtabase_item[" + super.toString()
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
