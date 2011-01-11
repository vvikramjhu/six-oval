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
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimple;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.State;
import java.util.EnumMap;
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

    protected static enum Property
    {
        HIVE,   //EntityStateRegistryHive   {0..1}
        KEY,    //EntityStateString         {0..1}
        NAME,   //EntityStateString         {0..1}
        TYPE,   //EntityStateRegistryType   {0..1}
        VALUE;  //EntityStateAnySimple      {0..1}
    }



    private EnumMap<Property, EntityBase>  _properties =
        new EnumMap<Property, EntityBase>( Property.class );



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
        _setStateProperty( Property.HIVE, hive );
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
        return _getStateProperty( Property.HIVE, EntityStateRegistryHive.class );
    }



    /**
     */
    public void setKey(
                    final EntityStateString key
                    )
    {
        _setStateProperty( Property.KEY, key );
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
        return _getStateProperty( Property.KEY, EntityStateString.class );
    }



    /**
     */
    public void setName(
                    final EntityStateString name
                    )
    {
        _setStateProperty( Property.NAME, name );
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
        return _getStateProperty( Property.NAME, EntityStateString.class );
    }



    /**
     */
    public void setType(
                    final EntityStateRegistryType type
                    )
    {
        _setStateProperty( Property.TYPE, type );
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
        return _getStateProperty( Property.TYPE, EntityStateRegistryType.class );
    }



    /**
     */
    public void setValue(
                    final EntityStateAnySimple value
                    )
    {
        _setStateProperty( Property.VALUE, value );
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
        return _getStateProperty( Property.VALUE, EntityStateAnySimple.class );
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
        return _properties.values().iterator();
    }



    protected <T extends EntityBase> T _getStateProperty(
                    final Property key,
                    final Class<T> type
                    )
    {
        EntityBase  p = _properties.get( key );
        return type.cast( p );
    }



    protected void _setStateProperty(
                    final Property key,
                    final EntityBase value
                    )
    {
        _properties.put( key, value );
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
