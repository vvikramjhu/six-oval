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

import jp.go.aist.six.oval.model.EntityType;
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimple;
import jp.go.aist.six.oval.model.definitions.EntityStateBase;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.State;
import java.util.EnumMap;
import java.util.Map;



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

    private Map<Property,EntityStateBase>  _properties =
        new EnumMap<Property,EntityStateBase>( Property.class );



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
        _properties.put( Property.HIVE, hive  );
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
        return (EntityStateRegistryHive)_properties.get( Property.HIVE );
    }



    /**
     */
    public void setKey(
                    final EntityStateString key
                    )
    {
        _properties.put( Property.KEY, key );
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
        return (EntityStateString)_properties.get( Property.KEY );
    }



    /**
     */
    public void setName(
                    final EntityStateString name
                    )
    {
        _properties.put( Property.NAME, name );
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
        return (EntityStateString)_properties.get( Property.NAME );
    }



    /**
     */
    public void setType(
                    final EntityStateRegistryType type
                    )
    {
        _properties.put( Property.TYPE, type );
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
        return (EntityStateRegistryType)_properties.get( Property.TYPE );
    }



    /**
     */
    public void setValue(
                    final EntityStateAnySimple value
                    )
    {
        _properties.put( Property.VALUE, value );
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
        return (EntityStateAnySimple)_properties.get( Property.VALUE );
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public EntityType getEntityType()
    {
        return EntityType.WINDOWS_REGISTRY;
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
