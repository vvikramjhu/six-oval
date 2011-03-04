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
import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.v5.definitions.EntityAttributeGroup;
import jp.go.aist.six.oval.model.v5.definitions.EntityPropertyMap;
import jp.go.aist.six.oval.model.v5.definitions.EntityStateAnySimpleType;
import jp.go.aist.six.oval.model.v5.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.v5.definitions.StateType;



/**
 * The registry state defines the different metadata
 * associate with a Windows registry key.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RegistryState
    extends StateType
{

//    private EntityStateRegistryHiveType  _hive;
//    //{0..1}
//
//    private EntityStateStringType  _key;
//    //{0..1}
//
//    private EntityStateStringType  _name;
//    //{0..1}
//
//    private EntityStateRegistryTypeType  _type;
//    //{0..1}
//
//    private EntityStateAnySimpleType  _value;
//    //{0..1}



    private final EntityPropertyMap<RegistryProperty>  _properties =
        RegistryProperty.createPropertyMap();



    /**
     * Constructor.
     */
    public RegistryState()
    {
    }


    public RegistryState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    public RegistryState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );
    }



    /**
     */
    public void setHive(
                    final EntityStateRegistryHiveType hive
                    )
    {
        _properties.setProperty( RegistryProperty.HIVE, hive );
    }


    public RegistryState hive(
                    final EntityStateRegistryHiveType hive
                    )
    {
        setHive( hive );
        return this;
    }


    public EntityStateRegistryHiveType getHive()
    {
        return _properties.getProperty(
                        RegistryProperty.HIVE, EntityStateRegistryHiveType.class );
    }



    /**
     */
    public void setKey(
                    final EntityStateStringType key
                    )
    {
        _properties.setProperty( RegistryProperty.KEY, key );
    }


    public RegistryState key(
                    final EntityStateStringType key
                    )
    {
        setKey( key );
        return this;
    }


    public EntityStateStringType getKey()
    {
        return _properties.getProperty(
                        RegistryProperty.KEY, EntityStateStringType.class );
    }



    /**
     */
    public void setName(
                    final EntityStateStringType name
                    )
    {
        _properties.setProperty( RegistryProperty.NAME, name );
    }


    public RegistryState name(
                    final EntityStateStringType name
                    )
    {
        setName( name );
        return this;
    }


    public EntityStateStringType getName()
    {
        return _properties.getProperty(
                        RegistryProperty.NAME, EntityStateStringType.class );
    }



    /**
     */
    public void setType(
                    final EntityStateRegistryTypeType type
                    )
    {
        _properties.setProperty( RegistryProperty.TYPE, type );
    }


    public RegistryState type(
                    final EntityStateRegistryTypeType type
                    )
    {
        setType( type );
        return this;
    }


    public EntityStateRegistryTypeType getType()
    {
        return _properties.getProperty(
                        RegistryProperty.TYPE, EntityStateRegistryTypeType.class );
    }



    /**
     */
    public void setValue(
                    final EntityStateAnySimpleType value
                    )
    {
        _properties.setProperty( RegistryProperty.VALUE, value );
    }


    public RegistryState value(
                    final EntityStateAnySimpleType value
                    )
    {
        setValue( value );
        return this;
    }


    public EntityStateAnySimpleType getValue()
    {
        return _properties.getProperty(
                        RegistryProperty.VALUE, EntityStateAnySimpleType.class );
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.WINDOWS_REGISTRY;
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
        if (!(obj instanceof RegistryState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "registry_state[" + super.toString()
                        + ", " + String.valueOf( _properties )
                        + "]";
    }

}
// RegistryState
