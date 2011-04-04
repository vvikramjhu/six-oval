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
import jp.go.aist.six.oval.model.definitions.EntityObjectString;
import jp.go.aist.six.oval.model.definitions.EntityPropertyMap;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import java.util.Iterator;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RegistryObject
    extends SystemObject
{

    private RegistryBehaviors  _behaviors;
    //{0..1}

    private EntityPropertyMap<RegistryProperty>  _properties =
        RegistryProperty.createPropertyMap();


//    private EntityObjectRegistryHive  _hive;
//    //{1..1}
//
//    private EntityObjectString  _key;
//    //{1..1, nillable="true"}
//
//    private EntityObjectString  _name;
//    //{1..1, nillable="true"}



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
                    final String comment
                    )
    {
        super( id, version, comment );
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
                        (hive == null ? null : (new EntityObjectRegistryHive( hive.getName() ))),
                        (key  == null ? null : (new EntityObjectString( key ))),
                        (name == null ? null : (new EntityObjectString( name )))
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


    public RegistryObject behaviors(
                    final RegistryBehaviors behaviors
                    )
    {
        setBehaviors( behaviors );
        return this;
    }


    public RegistryBehaviors getBehaviors()
    {
        return _behaviors;
    }



    public void setHive(
                    final EntityObjectRegistryHive hive
                    )
    {
        _properties.setProperty( RegistryProperty.HIVE, hive );
    }


    public RegistryObject hive(
                    final EntityObjectRegistryHive hive
                    )
    {
        setHive( hive );
        return this;
    }


    public EntityObjectRegistryHive getHive()
    {
        return _properties.getProperty(
                        RegistryProperty.HIVE, EntityObjectRegistryHive.class );
    }



    public void setKey(
                    final EntityObjectString key
                    )
    {
        _properties.setProperty( RegistryProperty.KEY, key );
    }


    public RegistryObject key(
                    final EntityObjectString key
                    )
    {
        setKey( key );
        return this;
    }


    public EntityObjectString getKey()
    {
        return _properties.getProperty(
                        RegistryProperty.KEY, EntityObjectString.class );
    }



    public void setName(
                    final EntityObjectString name
                    // nillable ="true"
                    )
    {
        _properties.setProperty( RegistryProperty.NAME, name );

//        EntityObjectString  n = name;
//        if (name != null) {
//            String  data = name.getData();
//            if (data == null  ||  data.length() == 0) {
//                n = null;
//            }
//        }
//
//        _name = n;
    }


    public RegistryObject name(
                    final EntityObjectString name
                    )
    {
        setName( name );
        return this;
    }


    public EntityObjectString getName()
    {
        return _properties.getProperty(
                        RegistryProperty.NAME, EntityObjectString.class );
    }



    //**************************************************************
    //  SystemObject
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
        if (!(obj instanceof RegistryObject)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "registry_object[" + super.toString()
                        + ", " + String.valueOf( _properties )
                        + "]";
    }

}
// RegistryObject