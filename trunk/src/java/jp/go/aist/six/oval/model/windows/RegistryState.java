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
import jp.go.aist.six.oval.model.definition.EntityStateAnySimple;
import jp.go.aist.six.oval.model.definition.EntityStateBase;
import jp.go.aist.six.oval.model.definition.EntityStateString;
import jp.go.aist.six.oval.model.definition.State;
import java.util.EnumMap;
import java.util.Map;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class RegistryState
    extends State
{

    protected static enum Property
    {
        HIVE,
        KEY,
        NAME,
        TYPE,
        VALUE;
    }

    private Map<Property,EntityStateBase>  _properties =
        new EnumMap<Property,EntityStateBase>( Property.class );

//    private EntityStateRegistryHiveType  _hive;
//    //{0..1}
//
//    private EntityStateStringType  _key;
//    //{0..1}
//
//    private EntityStateStringType  _name;
//    //{0..1}
//
//    private EntityStateRegistryType  _type;
//    //{0..1}
//
//    private EntityStateAnySimpleType  _value;
//    //{0..1}



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
     *
     */
    protected Map<Property,EntityStateBase> _getProperties()
    {
        return _properties;
    }



    /**
     */
    public void setHive(
                    final EntityStateRegistryHive hive
                    )
    {
        _properties.put( Property.HIVE, hive  );
//        _hive = hive;
    }


    /**
     */
    public EntityStateRegistryHive getHive()
    {
        return (EntityStateRegistryHive)_properties.get( Property.HIVE );
//        return _hive;
    }



    /**
     */
    public void setKey(
                    final EntityStateString key
                    )
    {
        _properties.put( Property.KEY, key );
//        _key = key;
    }


    public EntityStateString getKey()
    {
        return (EntityStateString)_properties.get( Property.KEY );
//        return _key;
    }



    /**
     */
    public void setName(
                    final EntityStateString name
                    )
    {
        _properties.put( Property.NAME, name );
//        _name = name;
    }


    public EntityStateString getName()
    {
        return (EntityStateString)_properties.get( Property.NAME );
//        return _name;
    }



    /**
     */
    public void setType(
                    final EntityStateRegistryType type
                    )
    {
        _properties.put( Property.TYPE, type );
//        _type = type;
    }


    /**
     */
    public EntityStateRegistryType getType()
    {
        return (EntityStateRegistryType)_properties.get( Property.TYPE );
//        return _type;
    }



    /**
     */
    public void setValue(
                    final EntityStateAnySimple value
                    )
    {
        _properties.put( Property.VALUE, value );
//        _value = value;
    }


    public EntityStateAnySimple getValue()
    {
        return (EntityStateAnySimple)_properties.get( Property.VALUE );
//        return _value;
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public ObjectType getObjectType()
    {
        return ObjectType.WINDOWS_REGISTRY;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        result = prime * result + _getProperties().hashCode();

//        EntityStateRegistryHiveType  hive = getHive();
//        result = prime * result + ((hive == null) ? 0 : hive.hashCode());
//
//        EntityStateStringType  key = getKey();
//        result = prime * result + ((key == null) ? 0 : key.hashCode());
//
//        EntityStateStringType  name = getName();
//        result = prime * result + ((name == null) ? 0 : name.hashCode());
//
//        EntityStateStringType  type = getType();
//        result = prime * result + ((type == null) ? 0 : type.hashCode());
//
//        EntityStateAnySimpleType  value = getValue();
//        result = prime * result + ((value == null) ? 0 : value.hashCode());

        return result;
    }



    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof RegistryState)) {
            return false;
        }

        if (super.equals( obj )) {
            RegistryState  other = (RegistryState)obj;
            Map<Property,EntityStateBase>  other_props = other._getProperties();
            Map<Property,EntityStateBase>   this_props =  this._getProperties();
            if (this_props == other_props
                            ||  (this_props != null  &&  this_props.equals( other_props ))) {
                return true;
            }
//            EntityStateRegistryHiveType  other_hive = other.getHive();
//            EntityStateRegistryHiveType   this_hive =  this.getHive();
//            if (this_hive == other_hive
//                            ||  (this_hive != null  &&  this_hive.equals( other_hive ))) {
//                EntityStateStringType  other_key = other.getKey();
//                EntityStateStringType   this_key =  this.getKey();
//                if (this_key == other_key
//                                ||  (this_key != null  &&  this_key.equals( other_key ))) {
//                    EntityStateStringType  other_name = other.getName();
//                    EntityStateStringType   this_name =  this.getName();
//                    if (this_name == other_name
//                                    ||  (this_name != null  &&  this_name.equals( other_name ))) {
//                        EntityStateRegistryType  other_type = other.getType();
//                        EntityStateRegistryType   this_type =  this.getType();
//                        if (this_type == other_type
//                                        ||  (this_type != null  &&  this_type.equals( other_type ))) {
//                            EntityStateAnySimpleType  other_value = other.getValue();
//                            EntityStateAnySimpleType   this_value =  this.getValue();
//                            if (this_value == other_value
//                                            ||  (this_value != null  &&  this_value.equals( other_value ))) {
//                                return true;
//                            }
//                        }
//                    }
//                }
//            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "RegistryState[" + super.toString() + "]";
    }

}
// RegistryState
