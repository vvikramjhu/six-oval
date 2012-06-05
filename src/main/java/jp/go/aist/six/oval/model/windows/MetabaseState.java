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

package jp.go.aist.six.oval.model.windows;

import java.util.ArrayList;
import java.util.Collection;
import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimpleType;
import jp.go.aist.six.oval.model.definitions.EntityStateIntType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The metabase state defines the different metadata
 * associate with a metabase item.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class MetabaseState
    extends StateType
{

    private EntityStateStringType  key;
    //{0..1}

    private EntityStateIntType  id;
    //{0..1}

    private EntityStateStringType  name;
    //{0..1}

    private EntityStateStringType  user_type;
    //{0..1}

    private EntityStateStringType  data_type;
    //{0..1}

    private EntityStateAnySimpleType  data;
    //{0..1}


//    private final EntityPropertyMap<MetabaseProperty>  _properties =
//        MetabaseProperty.createPropertyMap();



    /**
     * Constructor.
     */
    public MetabaseState()
    {
        this( null, 0 );
    }


    public MetabaseState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.metabase;
        _oval_family = Family.WINDOWS;
        _oval_component = Component.METABASE;
    }



    /**
     */
    public void setKey(
                    final EntityStateStringType key
                    )
    {
        this.key = key;
//        _properties.setProperty( MetabaseProperty.KEY, key );
    }


    public EntityStateStringType getKey()
    {
        return key;
//        return _properties.getProperty(
//                        MetabaseProperty.KEY, EntityStateStringType.class );
    }


    public MetabaseState key(
                    final EntityStateStringType key
                    )
    {
        setKey( key );
        return this;
    }



    /**
     */
    public void setId(
                    final EntityStateIntType id
                    )
    {
        this.id = id;
//        _properties.setProperty( MetabaseProperty.ID, id );
    }


    public EntityStateIntType getId()
    {
        return id;
//        return _properties.getProperty(
//                        MetabaseProperty.ID, EntityStateIntType.class );
    }


    public MetabaseState id(
                    final EntityStateIntType id
                    )
    {
        setId( id );
        return this;
    }



    /**
     */
    public void setName(
                    final EntityStateStringType name
                    )
    {
        this.name = name;
//        _properties.setProperty( MetabaseProperty.NAME, name );
    }


    public EntityStateStringType getName()
    {
        return name;
//        return _properties.getProperty(
//                        MetabaseProperty.NAME, EntityStateStringType.class );
    }


    public MetabaseState name(
                    final EntityStateStringType name
                    )
    {
        setName( name );
        return this;
    }



    /**
     */
    public void setUserType(
                    final EntityStateStringType user_type
                    )
    {
        this.user_type = user_type;
//        _properties.setProperty( MetabaseProperty.USER_TYPE, user_type );
    }


    public EntityStateStringType getUserType()
    {
        return user_type;
//        return _properties.getProperty(
//                        MetabaseProperty.USER_TYPE, EntityStateStringType.class );
    }


    public MetabaseState userType(
                    final EntityStateStringType user_type
                    )
    {
        setUserType( user_type );
        return this;
    }



    /**
     */
    public void setDataType(
                    final EntityStateStringType data_type
                    )
    {
        this.data_type = data_type;
//        _properties.setProperty( MetabaseProperty.DATA_TYPE, dataType );
    }


    public EntityStateStringType getDataType()
    {
        return data_type;
//        return _properties.getProperty(
//                        MetabaseProperty.DATA_TYPE, EntityStateStringType.class );
    }


    public MetabaseState dataType(
                    final EntityStateStringType data_type
                    )
    {
        setDataType( data_type );
        return this;
    }



    /**
     */
    public void setData(
                    final EntityStateAnySimpleType data
                    )
    {
        this.data = data;
//        _properties.setProperty( MetabaseProperty.DATA, data );
    }


    public EntityStateAnySimpleType getData()
    {
        return data;
//        return _properties.getProperty(
//                        MetabaseProperty.DATA, EntityStateAnySimpleType.class );
    }


    public MetabaseState data(
                    final EntityStateAnySimpleType data
                    )
    {
        setData( data );
        return this;
    }



    //*********************************************************************
    //  DefinitionsElement
    //*********************************************************************

    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();

        ref_list.add( getKey() );
        ref_list.add( getId() );
        ref_list.add( getName() );
        ref_list.add( getUserType() );
        ref_list.add( getDataType() );
        ref_list.add( getData() );

        return ref_list;
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
        if (!(obj instanceof MetabaseState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "metabase_state[" + super.toString()
                        + ", key="          + getKey()
                        + ", ID="           + getId()
                        + ", name="         + getName()
                        + ", user_type="    + getUserType()
                        + ", data_type="    + getDataType()
                        + ", data="         + getData()
                        + "]";
    }

}
//MetabaseState
