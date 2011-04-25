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

import java.util.Iterator;
import jp.go.aist.six.oval.model.v5.PlatformEntityType;
import jp.go.aist.six.oval.model.v5.definitions.EntityAttributeGroup;
import jp.go.aist.six.oval.model.v5.definitions.EntityPropertyMap;
import jp.go.aist.six.oval.model.v5.definitions.EntityStateAnySimpleType;
import jp.go.aist.six.oval.model.v5.definitions.EntityStateIntType;
import jp.go.aist.six.oval.model.v5.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.v5.definitions.StateType;



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

    private final EntityPropertyMap<MetabaseProperty>  _properties =
        MetabaseProperty.createPropertyMap();



    /**
     * Constructor.
     */
    public MetabaseState()
    {
    }


    public MetabaseState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }



    /**
     */
    public EntityStateStringType getKey()
    {
        return _properties.getProperty(
                        MetabaseProperty.KEY, EntityStateStringType.class );
    }


    public void setKey(
                    final EntityStateStringType key
                    )
    {
        _properties.setProperty( MetabaseProperty.KEY, key );
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
    public EntityStateIntType getID()
    {
        return _properties.getProperty(
                        MetabaseProperty.ID, EntityStateIntType.class );
    }


    public void setID(
                    final EntityStateIntType id
                    )
    {
        _properties.setProperty( MetabaseProperty.ID, id );
    }


    public MetabaseState ID(
                    final EntityStateIntType id
                    )
    {
        setID( id );
        return this;
    }



    /**
     */
    public EntityStateStringType getName()
    {
        return _properties.getProperty(
                        MetabaseProperty.NAME, EntityStateStringType.class );
    }


    public void setName(
                    final EntityStateStringType name
                    )
    {
        _properties.setProperty( MetabaseProperty.NAME, name );
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
    public EntityStateStringType getUserType()
    {
        return _properties.getProperty(
                        MetabaseProperty.USER_TYPE, EntityStateStringType.class );
    }


    public void setUserType(
                    final EntityStateStringType userType
                    )
    {
        _properties.setProperty( MetabaseProperty.USER_TYPE, userType );
    }


    public MetabaseState userType(
                    final EntityStateStringType userType
                    )
    {
        setUserType( userType );
        return this;
    }



    /**
     */
    public EntityStateStringType getDataType()
    {
        return _properties.getProperty(
                        MetabaseProperty.DATA_TYPE, EntityStateStringType.class );
    }


    public void setDataType(
                    final EntityStateStringType dataType
                    )
    {
        _properties.setProperty( MetabaseProperty.DATA_TYPE, dataType );
    }


    public MetabaseState dataType(
                    final EntityStateStringType dataType
                    )
    {
        setDataType( dataType );
        return this;
    }



    /**
     */
    public EntityStateAnySimpleType getData()
    {
        return _properties.getProperty(
                        MetabaseProperty.DATA, EntityStateAnySimpleType.class );
    }


    public void setData(
                    final EntityStateAnySimpleType data
                    )
    {
        _properties.setProperty( MetabaseProperty.DATA, data );
    }


    public MetabaseState data(
                    final EntityStateAnySimpleType data
                    )
    {
        setData( data );
        return this;
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.WINDOWS_METABASE;
    }



    @Override
    public Iterator<EntityAttributeGroup> iterateProperties()
    {
        return _properties.iterateProperties();
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
                        + ", " + String.valueOf( _properties )
                        + "]";
    }

}
// MetabaseState
