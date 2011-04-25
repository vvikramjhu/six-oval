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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.v5.PlatformEntityType;
import jp.go.aist.six.oval.model.v5.definitions.EntityAttributeGroup;
import jp.go.aist.six.oval.model.v5.definitions.EntityObjectStringType;
import jp.go.aist.six.oval.model.v5.definitions.EntityPropertyMap;
import jp.go.aist.six.oval.model.v5.definitions.Filter;
import jp.go.aist.six.oval.model.v5.definitions.SystemObjectType;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RegistryObject
    extends SystemObjectType
{

    private RegistryBehaviors  _behaviors;
    //{0..1}


    private final EntityPropertyMap<RegistryProperty>  _properties =
        RegistryProperty.createPropertyMap();

//    private EntityObjectRegistryHiveType  _hive;
//    //{1..1}
//
//    private EntityObjectStringType  _key;
//    //{1..1, nillable="true"}
//
//    private EntityObjectStringType  _name;
//    //{1..1, nillable="true"}


    private final Collection<Filter>  _filter = new ArrayList<Filter>();



    /**
     * Constructor.
     */
    public RegistryObject()
    {
    }


    public RegistryObject(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    public RegistryObject(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );
    }


    public RegistryObject(
                    final String id,
                    final int version,
                    final RegistryHiveEnumeration hive,
                    final String key,
                    final String name
                    )
    {
        this( id, version,
                        (hive == null ? null : (new EntityObjectRegistryHiveType( hive.getName() ))),
                        (key  == null ? null : (new EntityObjectStringType( key ))),
                        (name == null ? null : (new EntityObjectStringType( name )))
        );
    }


    public RegistryObject(
                    final String id,
                    final int version,
                    final EntityObjectRegistryHiveType hive,
                    final EntityObjectStringType key,
                    final EntityObjectStringType name
                    )
    {
        super( id, version );
        setHive( hive );
        setKey( key );
        setName( name );
    }



    /**
     */
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



    /**
     */
    public void setHive(
                    final EntityObjectRegistryHiveType hive
                    )
    {
        _properties.setProperty( RegistryProperty.HIVE, hive );
    }


    public RegistryObject hive(
                    final EntityObjectRegistryHiveType hive
                    )
    {
        setHive( hive );
        return this;
    }


    public EntityObjectRegistryHiveType getHive()
    {
        return _properties.getProperty(
                        RegistryProperty.HIVE, EntityObjectRegistryHiveType.class );
    }



    public void setKey(
                    final EntityObjectStringType key
                    )
    {
        _properties.setProperty( RegistryProperty.KEY, key );
    }


    public RegistryObject key(
                    final EntityObjectStringType key
                    )
    {
        setKey( key );
        return this;
    }


    public EntityObjectStringType getKey()
    {
        return _properties.getProperty(
                        RegistryProperty.KEY, EntityObjectStringType.class );
    }



    public void setName(
                    final EntityObjectStringType name
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
                    final EntityObjectStringType name
                    )
    {
        setName( name );
        return this;
    }


    public EntityObjectStringType getName()
    {
        return _properties.getProperty(
                        RegistryProperty.NAME, EntityObjectStringType.class );
    }



    /**
     */
    public void setFilter(
                    final Collection<? extends Filter> filters
                    )
    {
        if (filters != _filter) {
            _filter.clear();
            if (filters != null  &&  filters.size() > 0) {
                _filter.addAll( filters );
            }
        }
    }


    public Collection<Filter> getFilter()
    {
        return _filter;
    }


    public Iterator<Filter> iterateFilter()
    {
        return _filter.iterator();
    }



    //**************************************************************
    //  SystemObjectType
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
        if (!(obj instanceof RegistryObject)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "registry_object[" + super.toString()
                        + ", behaviors=" + getBehaviors()
                        + ", " + String.valueOf( _properties )
                        + ", filter=" + getFilter()
                        + "]";
    }

}
// RegistryObject
