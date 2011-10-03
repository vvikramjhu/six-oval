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

import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimpleType;
import jp.go.aist.six.oval.model.definitions.EntityStateIntType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



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

    private EntityStateRegistryHiveType  hive;
    //{0..1}

    private EntityStateStringType  key;
    //{0..1}

    private EntityStateStringType  name;
    //{0..1}

    private EntityStateIntType  last_write_time;
    //{0..1}: 5.10

    private EntityStateRegistryTypeType  type;
    //{0..1}

    private EntityStateAnySimpleType  value;
    //{0..1}



//    private final EntityPropertyMap<RegistryProperty>  _properties =
//        RegistryProperty.createPropertyMap();



    /**
     * Constructor.
     */
    public RegistryState()
    {
        this( null, 0 );
    }


    public RegistryState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public RegistryState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.registry;
    }



    /**
     */
    public void setHive(
                    final EntityStateRegistryHiveType hive
                    )
    {
        this.hive = hive;
//        _properties.setProperty( RegistryProperty.HIVE, hive );
    }


    public EntityStateRegistryHiveType getHive()
    {
        return this.hive;
//        return _properties.getProperty(
//                        RegistryProperty.HIVE, EntityStateRegistryHiveType.class );
    }


    public RegistryState hive(
                    final EntityStateRegistryHiveType hive
                    )
    {
        setHive( hive );
        return this;
    }



    /**
     */
    public void setKey(
                    final EntityStateStringType key
                    )
    {
        this.key = key;
//        _properties.setProperty( RegistryProperty.KEY, key );
    }


    public EntityStateStringType getKey()
    {
        return this.key;
//        return _properties.getProperty(
//                        RegistryProperty.KEY, EntityStateStringType.class );
    }


    public RegistryState key(
                    final EntityStateStringType key
                    )
    {
        setKey( key );
        return this;
    }



    /**
     */
    public void setName(
                    final EntityStateStringType name
                    )
    {
        this.name = name;
//        _properties.setProperty( RegistryProperty.NAME, name );
    }


    public EntityStateStringType getName()
    {
        return this.name;
//        return _properties.getProperty(
//                        RegistryProperty.NAME, EntityStateStringType.class );
    }


    public RegistryState name(
                    final EntityStateStringType name
                    )
    {
        setName( name );
        return this;
    }



    /**
     */
    public void setLastWriteTime(
                    final EntityStateIntType last_write_time
                    )
    {
        this.last_write_time = last_write_time;
    }


    public EntityStateIntType getLastWriteTime()
    {
        return this.last_write_time;
    }



    /**
     */
    public void setType(
                    final EntityStateRegistryTypeType type
                    )
    {
        this.type = type;
//        _properties.setProperty( RegistryProperty.TYPE, type );
    }


    public EntityStateRegistryTypeType getType()
    {
        return this.type;
//        return _properties.getProperty(
//                        RegistryProperty.TYPE, EntityStateRegistryTypeType.class );
    }


    public RegistryState type(
                    final EntityStateRegistryTypeType type
                    )
    {
        setType( type );
        return this;
    }



    /**
     */
    public void setValue(
                    final EntityStateAnySimpleType value
                    )
    {
        this.value = value;
//        _properties.setProperty( RegistryProperty.VALUE, value );
    }


    public EntityStateAnySimpleType getValue()
    {
        return this.value;
//        return _properties.getProperty(
//                        RegistryProperty.VALUE, EntityStateAnySimpleType.class );
    }


    public RegistryState value(
                    final EntityStateAnySimpleType value
                    )
    {
        setValue( value );
        return this;
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
                        + ", hive=" + getHive()
                        + ", key=" + getKey()
                        + ", name=" + getName()
                        + ", last_write_time=" + getLastWriteTime()
                        + ", type=" + getType()
                        + ", value=" + getValue()
//                        + ", " + String.valueOf( _properties )
                        + "]";
    }

}
// RegistryState
