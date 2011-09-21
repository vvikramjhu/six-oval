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
import java.util.Iterator;
import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.PlatformEntityType;
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

    private EntityItemStringType  key;
    //{0..1}


    private EntityItemIntType  id;
    //{0..1, nillable="true"}


    private EntityItemStringType  name;
    //{0..1}


    private EntityItemStringType  user_type;
    //{0..1}


    private EntityItemStringType  data_type;
    //{0..1}


//    private final Map<MetabaseProperty, EntityAttributeGroup>  _properties =
//        new EnumMap<MetabaseProperty, EntityAttributeGroup>( MetabaseProperty.class );


    private final Collection<EntityItemAnySimpleType>  data =
        new ArrayList<EntityItemAnySimpleType>();
    //{0..*}



    /**
     * Constructor.
     */
    public MetabaseItem()
    {
        this( 0 );
    }


    public MetabaseItem(
                    final int id
                    )
    {
        super( id );

        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.metabase;
    }



    /**
     */
    public void setKey(
                    final EntityItemStringType key
                    )
    {
        this.key = key;
//        _properties.put( MetabaseProperty.KEY, key );
    }


    public EntityItemStringType getKey()
    {
        return this.key;
//        return (EntityItemStringType)_properties.get( MetabaseProperty.KEY );
    }



    /**
     * This property is renamed from "id" to "objectID"
     * because the super class ItemType has the property of the same name.
     */
    public void setObjectID(
                    final EntityItemIntType id
                    )
    {
        this.id = id;
//        _properties.put( MetabaseProperty.ID, id );
    }


    public EntityItemIntType getObjectID()
    {
        return this.id;
//        return (EntityItemIntType)_properties.get( MetabaseProperty.ID );
    }



    /**
     */
    public void setObjectName(
                    final EntityItemStringType name
                    )
    {
        this.name = name;
//        _properties.put( MetabaseProperty.NAME, name );
    }


    public EntityItemStringType getObjectName()
    {
        return this.name;
//        return (EntityItemStringType)_properties.get( MetabaseProperty.NAME );
    }



    /**
     */
    public void setUserType(
                    final EntityItemStringType user_type
                    )
    {
        this.user_type = user_type;
//        _properties.put( MetabaseProperty.USER_TYPE, type );
    }


    public EntityItemStringType getUserType()
    {
        return this.user_type;
//        return (EntityItemStringType)_properties.get( MetabaseProperty.USER_TYPE );
    }



    /**
     */
    public void setDataType(
                    final EntityItemStringType data_type
                    )
    {
        this.data_type = data_type;
//        _properties.put( MetabaseProperty.DATA_TYPE, type );
    }


    public EntityItemStringType getDataType()
    {
        return this.data_type;
//        return (EntityItemStringType)_properties.get( MetabaseProperty.DATA_TYPE );
    }



    /**
     */
    public void setData(
                    final Collection<? extends EntityItemAnySimpleType> data
                    )
    {
        if (data != this.data) {
            this.data.clear();
            if (data != null  &&  data.size() > 0) {
                this.data.addAll( data );
            }
        }
    }


    public Collection<EntityItemAnySimpleType> getData()
    {
        return this.data;
    }


    public Iterator<EntityItemAnySimpleType> iterateData()
    {
        return this.data.iterator();
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
             + ", key="         + getKey()
             + ", id="          + getObjectID()
             + ", name="        + getObjectName()
             + ", user_type="   + getUserType()
             + ", data_type="   + getDataType()
             + ", data="        + getData()
             + "]";
    }

}
// MetabaseItem
