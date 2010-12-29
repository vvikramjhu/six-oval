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
import jp.go.aist.six.oval.model.sc.EntityItemAnySimple;
import jp.go.aist.six.oval.model.sc.EntityItemString;
import jp.go.aist.six.oval.model.sc.Item;
import jp.go.aist.six.oval.model.sc.Status;



/**
 * The registry item specifies information that can be collected
 * about a particular registry key.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RegistryItem
    extends Item
{

    private EntityItemRegistryHive  _hive;
    //{0..1}

    private EntityItemString  _key;
    //{0..1, nillable="true"}

    private EntityItemString  _name;
    //{0..1, nillable="true"}

    private EntityItemRegistryType  _type;
    //{0..1}

    private EntityItemAnySimple  _value;
    //{0..*}
    // We have never found a registry item that has more than one value!!! //
//    private List<EntityItemAnySimple>  _values = new ArrayList<EntityItemAnySimple>();



    /**
     * Constructor.
     */
    public RegistryItem()
    {
    }


    /**
     * Constructor.
     */
    public RegistryItem(
                    final int id
                    )
    {
        super( id );
    }


    /**
     * Constructor.
     */
    public RegistryItem(
                    final int id,
                    final Status status
                    )
    {
        super( id, status );
    }


    /**
     * Constructor.
     */
    public RegistryItem(
                    final int id,
                    final Status status,
                    final EntityItemRegistryHive hive,
                    final EntityItemString key
                    )
    {
        this( id, status );
        setHive( hive );
        setKey( key );
    }


    /**
     * Constructor.
     */
    public RegistryItem(
                    final int id,
                    final Status status,
                    final RegistryHive hive,
                    final String key
                    )
    {
        this( id, status );

        if (hive != null) {
            setHive( new EntityItemRegistryHive( hive ) );
        }

        if (key != null) {
            setKey( new EntityItemString( key ) );
        }
    }


    /**
     * Constructor.
     */
    public RegistryItem(
                    final int id,
                    final Status status,
                    final EntityItemRegistryHive hive,
                    final EntityItemString key,
                    final EntityItemString name,
                    final EntityItemRegistryType type,
                    final EntityItemAnySimple value
                    )
    {
        this( id, status, hive, key );
        setName( name );
        setType( type );
        setValue( value );
    }


    /**
     * Constructor.
     */
    public RegistryItem(
                    final int id,
                    final Status status,
                    final RegistryHive hive,
                    final String key,
                    final String name,
                    final RegistryType type,
                    final String value
                    )
    {
        this( id, status, hive, key );

        if (name != null) {
            setName( new EntityItemString( name ) );
        }

        if (type != null) {
            setType( new EntityItemRegistryType( type ) );
        }

        if (value != null) {
            setValue( new EntityItemAnySimple( value ) );
        }
    }


    public EntityItemRegistryHive getHive()
    {
        return _hive;
    }


    public void setHive(
                    final EntityItemRegistryHive hive
                    )
    {
        _hive = hive;
    }



    public EntityItemString getKey()
    {
        return _key;
    }


    public void setKey(
                    final EntityItemString key
                    )
    {
        _key = key;
    }



    public EntityItemString getName()
    {
        return _name;
    }


    public void setName(
                    final EntityItemString name
                    )
    {
        _name = name;
    }



    public EntityItemRegistryType getType()
    {
        return _type;
    }


    public void setType(
                    final EntityItemRegistryType type
                    )
    {
        _type = type;
    }



    public void setValue(
                    final EntityItemAnySimple value
                    )
    {
        _value = value;
    }


    public EntityItemAnySimple getValue()
    {
        return _value;
    }



    //**************************************************************
    //  Item
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.WINDOWS_REGISTRY;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "registry_item[" + super.toString()
                        + ", hive=" + getHive()
                        + ", key=" + getKey()
                        + ", name=" + getName()
                        + ", type=" + getType()
                        + ", value=" + getValue()
//                        + ", values=" + getValues()
                        + "]";
    }

}
// RegistryItem
