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

import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.definitions.EntityBase;
import jp.go.aist.six.oval.model.definitions.EntityPropertyMap;
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimple;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.State;
import java.util.Iterator;



/**
 * The registry state defines the different metadata
 * associate with a Windows registry key.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RegistryState
    extends State
{

    private EntityPropertyMap<RegistryProperty>  _properties =
        RegistryProperty.createPropertyMap();



    /**
     * Constructor.
     */
    public RegistryState()
    {
    }


    /**
     * Constructor.
     */
    public RegistryState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
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
                    final EntityStateRegistryHive hive
                    )
    {
        _properties.setProperty( RegistryProperty.HIVE, hive );
    }


    public RegistryState hive(
                    final EntityStateRegistryHive hive
                    )
    {
        setHive( hive );
        return this;
    }


    public EntityStateRegistryHive getHive()
    {
        return _properties.getProperty(
                        RegistryProperty.HIVE, EntityStateRegistryHive.class );
    }



    /**
     */
    public void setKey(
                    final EntityStateString key
                    )
    {
        _properties.setProperty( RegistryProperty.KEY, key );
    }


    public RegistryState key(
                    final EntityStateString key
                    )
    {
        setKey( key );
        return this;
    }


    public EntityStateString getKey()
    {
        return _properties.getProperty(
                        RegistryProperty.KEY, EntityStateString.class );
    }



    /**
     */
    public void setName(
                    final EntityStateString name
                    )
    {
        _properties.setProperty( RegistryProperty.NAME, name );
    }


    public RegistryState name(
                    final EntityStateString name
                    )
    {
        setName( name );
        return this;
    }


    public EntityStateString getName()
    {
        return _properties.getProperty(
                        RegistryProperty.NAME, EntityStateString.class );
    }



    /**
     */
    public void setType(
                    final EntityStateRegistryType type
                    )
    {
        _properties.setProperty( RegistryProperty.TYPE, type );
    }


    public RegistryState type(
                    final EntityStateRegistryType type
                    )
    {
        setType( type );
        return this;
    }


    /**
     */
    public EntityStateRegistryType getType()
    {
        return _properties.getProperty(
                        RegistryProperty.TYPE, EntityStateRegistryType.class );
    }



    /**
     */
    public void setValue(
                    final EntityStateAnySimple value
                    )
    {
        _properties.setProperty( RegistryProperty.VALUE, value );
    }


    public RegistryState value(
                    final EntityStateAnySimple value
                    )
    {
        setValue( value );
        return this;
    }


    public EntityStateAnySimple getValue()
    {
        return _properties.getProperty(
                        RegistryProperty.VALUE, EntityStateAnySimple.class );
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
    public Iterator<EntityBase> iterateProperties()
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
