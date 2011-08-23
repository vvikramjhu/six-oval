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
import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.v5.PlatformEntityType;
import jp.go.aist.six.oval.model.v5.sc.EntityItemAnySimpleType;
import jp.go.aist.six.oval.model.v5.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.v5.sc.ItemType;



/**
 * The registry item specifies information that can be collected
 * about a particular registry key.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RegistryItem
    extends ItemType
{

    private EntityItemRegistryHiveType  hive;
    //{0..1}

    private EntityItemStringType  key;
    //{0..1, nillable="true"}

    private EntityItemStringType  name;
    //{0..1, nillable="true"}

    private EntityItemRegistryTypeType  type;
    //{0..1}


    private final Collection<EntityItemAnySimpleType>  value =
        new ArrayList<EntityItemAnySimpleType>();
    //{0..*}
//    private EntityItemAnySimpleType  _value;
    // We have never found a registry item that has more than one value!!! //



    /**
     * Constructor.
     */
    public RegistryItem()
    {
        this( 0 );
    }


    public RegistryItem(
                    final int id
                    )
    {
        super( id );

        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.registry;
    }



    /**
     */
    public void setHive(
                    final EntityItemRegistryHiveType hive
                    )
    {
        this.hive = hive;
    }


    public EntityItemRegistryHiveType getHive()
    {
        return this.hive;
    }



    /**
     */
    public EntityItemStringType getKey()
    {
        return this.key;
    }


    public void setKey(
                    final EntityItemStringType key
                    )
    {
        this.key = key;
    }



    /**
     */
    public EntityItemStringType getName()
    {
        return this.name;
    }


    public void setName(
                    final EntityItemStringType name
                    )
    {
        this.name = name;
    }



    /**
     */
    public EntityItemRegistryTypeType getType()
    {
        return this.type;
    }


    public void setType(
                    final EntityItemRegistryTypeType type
                    )
    {
        this.type = type;
    }



    /**
     */
    public void setValue(
                    final Collection<? extends EntityItemAnySimpleType> value
                    )
    {
        if (this.value != value) {
            this.value.clear();
            if (value != null  &&  value.size() > 0) {
                this.value.addAll( value );
            }
        }
    }


    public Collection<EntityItemAnySimpleType> getValue()
    {
        return this.value;
    }


    public Iterator<EntityItemAnySimpleType> iterateValue()
    {
        return this.value.iterator();
    }


//    /**
//     */
//    public void setValue(
//                    final EntityItemAnySimpleType value
//                    )
//    {
//        _value = value;
//    }
//
//
//    public EntityItemAnySimpleType getValue()
//    {
//        return _value;
//    }



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
             + ", hive="    + getHive()
             + ", key="     + getKey()
             + ", name="    + getName()
             + ", type="    + getType()
             + ", value="   + getValue()
             + "]";
    }

}
// RegistryItem
