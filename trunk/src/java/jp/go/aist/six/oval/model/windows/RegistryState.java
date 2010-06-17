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

import jp.go.aist.six.oval.core.model.ComponentType;
import jp.go.aist.six.oval.model.definition.EntityStateAnyType;
import jp.go.aist.six.oval.model.definition.EntityStateStringType;
import jp.go.aist.six.oval.model.definition.State;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class RegistryState
    extends State
{

    private EntityStateRegistryHiveType  _hive;
    //{0..1}

    private EntityStateStringType  _key;
    //{0..1}

    private EntityStateStringType  _name;
    //{0..1}

    private EntityStateRegistryType  _type;
    //{0..1}

    private EntityStateAnyType  _value;
    //{0..1}



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
     */
    public void setHive(
                    final EntityStateRegistryHiveType hive
                    )
    {
        _hive = hive;
    }


    /**
     */
    public EntityStateRegistryHiveType getHive()
    {
        return _hive;
    }



    /**
     */
    public void setKey(
                    final EntityStateStringType key
                    )
    {
        _key = key;
    }


    public EntityStateStringType getKey()
    {
        return _key;
    }



    /**
     */
    public void setName(
                    final EntityStateStringType name
                    )
    {
        _name = name;
    }


    public EntityStateStringType getName()
    {
        return _name;
    }



    /**
     */
    public void setType(
                    final EntityStateRegistryType type
                    )
    {
        _type = type;
    }


    /**
     */
    public EntityStateRegistryType getType()
    {
        return _type;
    }



    /**
     */
    public void setValue(
                    final EntityStateAnyType value
                    )
    {
        _value = value;
    }


    public EntityStateAnyType getValue()
    {
        return _value;
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public ComponentType getStateType()
    {
        return ComponentType.WINDOWS_REGISTRY;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        EntityStateRegistryHiveType  hive = getHive();
        result = prime * result + ((hive == null) ? 0 : hive.hashCode());

        EntityStateStringType  key = getKey();
        result = prime * result + ((key == null) ? 0 : key.hashCode());

        EntityStateStringType  name = getName();
        result = prime * result + ((name == null) ? 0 : name.hashCode());

        EntityStateStringType  type = getType();
        result = prime * result + ((type == null) ? 0 : type.hashCode());

        EntityStateAnyType  value = getValue();
        result = prime * result + ((value == null) ? 0 : value.hashCode());

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
            EntityStateRegistryHiveType  other_hive = other.getHive();
            EntityStateRegistryHiveType   this_hive =  this.getHive();
            if (this_hive == other_hive
                            ||  (this_hive != null  &&  this_hive.equals( other_hive ))) {
                EntityStateStringType  other_key = other.getKey();
                EntityStateStringType   this_key =  this.getKey();
                if (this_key == other_key
                                ||  (this_key != null  &&  this_key.equals( other_key ))) {
                    EntityStateStringType  other_name = other.getName();
                    EntityStateStringType   this_name =  this.getName();
                    if (this_name == other_name
                                    ||  (this_name != null  &&  this_name.equals( other_name ))) {
                        EntityStateRegistryType  other_type = other.getType();
                        EntityStateRegistryType   this_type =  this.getType();
                        if (this_type == other_type
                                        ||  (this_type != null  &&  this_type.equals( other_type ))) {
                            EntityStateAnyType  other_value = other.getValue();
                            EntityStateAnyType   this_value =  this.getValue();
                            if (this_value == other_value
                                            ||  (this_value != null  &&  this_value.equals( other_value ))) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }



    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "RegistryState[" + super.toString() + "]";
    }

}
// RegistryState
