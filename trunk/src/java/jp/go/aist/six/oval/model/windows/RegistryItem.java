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

import jp.go.aist.six.oval.core.model.system.ItemType;
import jp.go.aist.six.oval.model.system.EntityItemAnyType;
import jp.go.aist.six.oval.model.system.EntityItemStringType;
import jp.go.aist.six.oval.model.system.Item;
import jp.go.aist.six.oval.model.system.Status;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class RegistryItem
    extends Item
{

    private RegistryHive  _hive;
    //{win-sc:EntityItemRegistryHiveType, 0..1}

    private EntityItemStringType  _key;
    //{oval-sc:EntityItemStringType, 0..1, nillable="true"}

    private EntityItemStringType  _name;
    //{oval-sc:EntityItemStringType, 0..1, nillable="true"}

    private RegistryType  _type;
    //{win-sc:EntityItemRegistryTypeType, 0..1}

    private EntityItemAnyType  _value;
    //{oval-sc:EntityItemAnyType, 0..*}
    // We found that every registry item has at most one value!!! //
//    private List<EntityItemAnyType>  _values = new ArrayList<EntityItemAnyType>();



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
                    final RegistryHive hive,
                    final EntityItemStringType key,
                    final EntityItemStringType name,
                    final EntityItemAnyType value,
                    final RegistryType type
                    )
    {
        this( id, status );
        setHive( hive );
        setKey( key );
        setName( name );
        setValue( value );
        setType( type );
    }



    public RegistryHive getHive()
    {
        return _hive;
    }


    public void setHive(
                    final RegistryHive hive
                    )
    {
        _hive = hive;
    }



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



    public RegistryType getType()
    {
        return _type;
    }


    public void setType(
                    final RegistryType type
                    )
    {
        _type = type;
    }



    public void setValue(
                    final EntityItemAnyType value
                    )
    {
        _value = value;
    }


    public EntityItemAnyType getValue()
    {
        return _value;
    }

//    /**
//     * @return the values
//     */
//    public List<EntityItemAnyType> getValues()
//    {
//        return _values;
//    }
//
//
//
//    /**
//     * @param values the values to set
//     */
//    public void setValues( final List<EntityItemAnyType> values )
//    {
//        _values.clear();
//        Iterator<EntityItemAnyType>  i = values.iterator();
//        while (i.hasNext()) {
//            addValue( i.next() );
//        }
//    }
//
//
//    /**
//     *
//     */
//    public boolean addValue( final EntityItemAnyType value )
//    {
//        return _values.add( value );
//    }



    //**************************************************************
    //  Item
    //**************************************************************

    @Override
    public ItemType getItemType()
    {
        return ItemType.WINDOWS_REGISTRY;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "RegistryItem[" + super.toString()
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
