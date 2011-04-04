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

import jp.go.aist.six.oval.model.PlatformEntityType;
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

    private EntityItemRegistryHiveType  _hive;
    //{0..1}

    private EntityItemStringType  _key;
    //{0..1, nillable="true"}

    private EntityItemStringType  _name;
    //{0..1, nillable="true"}

    private EntityItemRegistryTypeType  _type;
    //{0..1}

    private EntityItemAnySimpleType  _value;
    //{0..*}
    // We have never found a registry item that has more than one value!!! //
//    private List<EntityItemAnySimple>  _values = new ArrayList<EntityItemAnySimple>();



    /**
     * Constructor.
     */
    public RegistryItem()
    {
    }


    public RegistryItem(
                    final int id
                    )
    {
        super( id );
    }



    /**
     */
    public EntityItemRegistryHiveType getHive()
    {
        return _hive;
    }


    public void setHive(
                    final EntityItemRegistryHiveType hive
                    )
    {
        _hive = hive;
    }



    /**
     */
    public EntityItemStringType getKey()
    {
        return _key;
    }


    public void setKey(
                    final EntityItemStringType key
                    )
    {
        _key = key;
    }



    /**
     */
    public EntityItemStringType getName()
    {
        return _name;
    }


    public void setName(
                    final EntityItemStringType name
                    )
    {
        _name = name;
    }



    /**
     */
    public EntityItemRegistryTypeType getType()
    {
        return _type;
    }


    public void setType(
                    final EntityItemRegistryTypeType type
                    )
    {
        _type = type;
    }



    /**
     */
    public void setValue(
                    final EntityItemAnySimpleType value
                    )
    {
        _value = value;
    }


    public EntityItemAnySimpleType getValue()
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
