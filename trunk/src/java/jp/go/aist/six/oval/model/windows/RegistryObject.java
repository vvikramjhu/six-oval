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

import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.definition.EntityObjectString;
import jp.go.aist.six.oval.model.definition.EntityTypeHelper;
import jp.go.aist.six.oval.model.definition.SystemObject;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class RegistryObject
    extends SystemObject
{

    private RegistryBehaviors  _behaviors;
    //{0..1}

    private EntityObjectRegistryHive  _hive;
    //{1..1}

    private EntityObjectString  _key;
    //{1..1, nillable="true"}

    private EntityObjectString  _name;
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
        this( id, version,
                        new EntityObjectRegistryHive( hive.name() ),
                        new EntityObjectString( key ),
                        new EntityObjectString( name )
        );
    }


    /**
     * Constructor.
     */
    public RegistryObject(
                    final String id,
                    final int version,
                    final EntityObjectRegistryHive hive,
                    final EntityObjectString key,
                    final EntityObjectString name
                    )
    {
        super( id, version );
        setHive( hive );
        setKey( key );
        setName( name );
    }



    public void setBehaviors(
                    final RegistryBehaviors behaviors
                    )
    {
        _behaviors = behaviors;
    }



    public RegistryBehaviors getBehaviors()
    {
        return _behaviors;
    }



    public void setHive(
                    final EntityObjectRegistryHive hive
                    )
    {
        _hive = hive;
    }



    public EntityObjectRegistryHive getHive()
    {
        return _hive;
    }



    public void setKey(
                    final EntityObjectString key
                    )
    {
        _key = key;
    }


    public EntityObjectString getKey()
    {
        return _key;
    }



    public void setName(
                    final EntityObjectString name
                    )
    {
        _name = name;
    }


    public EntityObjectString getName()
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

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        RegistryBehaviors  behaviors = getBehaviors();
        result = prime * result + ((behaviors == null) ? 0 : behaviors.hashCode());

        EntityObjectRegistryHive  hive = getHive();
        result = prime * result + ((hive == null) ? 0 : hive.hashCode());

        EntityObjectString  key = getKey();
        result = prime * result + ((key == null) ? 0 : key.hashCode());

        EntityObjectString  name = getName();
        result = prime * result + ((name == null) ? 0 : name.hashCode());

        return result;
    }



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
            EntityObjectString  other_name = other.getName();
            EntityObjectString   this_name =  this.getName();
            if (EntityTypeHelper.equals( this_name, other_name )) {
                EntityObjectString  other_key = other.getKey();
                EntityObjectString   this_key =  this.getKey();
                if (EntityTypeHelper.equals( this_key, other_key )) {
                    EntityObjectRegistryHive  other_hive = other.getHive();
                    EntityObjectRegistryHive   this_hive =  this.getHive();
                    if (EntityTypeHelper.equals( this_hive, other_hive )) {
                        RegistryBehaviors  other_behaviors = other.getBehaviors();
                        RegistryBehaviors   this_behaviors =  this.getBehaviors();
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
