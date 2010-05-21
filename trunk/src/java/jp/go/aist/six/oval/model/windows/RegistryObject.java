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
import jp.go.aist.six.oval.core.model.definition.EntityTypeHelper;
import jp.go.aist.six.oval.model.definition.EntityObjectStringType;
import jp.go.aist.six.oval.model.definition.SystemObject;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: RegistryObject.java 696 2010-04-26 10:22:00Z akihito $
 */
public class RegistryObject
    extends SystemObject
{

    private Behaviors  _behaviors;// = Behaviors.DEFAULT_VALUE;
    //{0..1}

    private RegistryHive  _hive;
    //{1..1}

    private EntityObjectStringType  _key;
    //{1..1, nillable="true"}

    private EntityObjectStringType  _name;
    //{1..1, nillable="true"}



    /**
     * Constructor.
     */
    public RegistryObject()
    {
    }


    /**
     * Constructor.
     */
    public RegistryObject(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public RegistryObject(
                    final String id,
                    final int version,
                    final RegistryHive hive,
                    final String key,
                    final String name
                    )
    {
        super( id, version );
        setHive( hive );
        setKey( key );
        setName( name );
    }


    /**
     * Constructor.
     */
    public RegistryObject(
                    final String id,
                    final int version,
                    final RegistryHive hive,
                    final EntityObjectStringType key,
                    final EntityObjectStringType name
                    )
    {
        super( id, version );
        setHive( hive );
        setKey( key );
        setName( name );
    }



    public void setBehaviors(
                    final Behaviors behaviors
                    )
    {
        _behaviors = behaviors;
    }



    public Behaviors getBehaviors()
    {
        return _behaviors;
    }



    public void setHive(
                    final RegistryHive hive
                    )
    {
        _hive = hive;
    }



    public RegistryHive getHive()
    {
        return _hive;
    }



    public void setKey(
                    final String key
                    )
    {
        setKey( new EntityObjectStringType( key ) );
    }


    public void setKey(
                    final EntityObjectStringType key
                    )
    {
        _key = key;
    }


    public EntityObjectStringType getKey()
    {
        return _key;
    }



    public void setName(
                    final String name
                    )
    {
        setName( new EntityObjectStringType( name ) );
    }


    public void setName(
                    final EntityObjectStringType name
                    )
    {
        _name = name;
    }


    public EntityObjectStringType getName()
    {
        return _name;
    }



    //**************************************************************
    //  SystemObject
    //**************************************************************

    @Override
    public ComponentType getSystemObjectType()
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

        Behaviors  behaviors = getBehaviors();
        result = prime * result + ((behaviors == null) ? 0 : behaviors.hashCode());

        RegistryHive  hive = getHive();
        result = prime * result + ((hive == null) ? 0 : hive.hashCode());

        EntityObjectStringType  key = getKey();
        result = prime * result + ((key == null) ? 0 : key.hashCode());

        EntityObjectStringType  name = getName();
        result = prime * result + ((name == null) ? 0 : name.hashCode());

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
        if (!(obj instanceof RegistryObject)) {
            return false;
        }

        if (super.equals( obj )) {
            RegistryObject  other = (RegistryObject)obj;
            EntityObjectStringType  other_name = other.getName();
            EntityObjectStringType   this_name =  this.getName();
            if (EntityTypeHelper.equals( this_name, other_name)) {
                EntityObjectStringType  other_key = other.getKey();
                EntityObjectStringType   this_key =  this.getKey();
                if (EntityTypeHelper.equals( this_key, other_key)) {
                    RegistryHive  other_hive = other.getHive();
                    RegistryHive   this_hive =  this.getHive();
                    if (this_hive == other_hive) {
                        Behaviors  other_behaviors = other.getBehaviors();
                        Behaviors   this_behaviors =  this.getBehaviors();
                        if (this_behaviors == other_behaviors
                                        ||  (this_behaviors != null  &&  this_behaviors.equals( other_behaviors ))) {
                            return true;
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
        return "RegistryObject[" + super.toString()
                        + ", hive=" + getHive()
                        + ", key=" + getKey()
                        + ", name=" + getName()
                        + ", behaviors=" + getBehaviors()
                        + "]";
    }

}
// RegistryObject
