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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.sc.EntityItemIPAddressStringType;
import jp.go.aist.six.oval.model.sc.EntityItemIntType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;



/**
 * The network_interface item enumerates various attributes 
 * about the network interfaces on a system.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class NetworkInterfaceItem
    extends ItemType
{

    private EntityItemStringType  name;
    //{0..1}

    private EntityItemIntType  index;
    //{0..1}

    private EntityItemNetworkInterfaceTypeType  type;
    //{0..1}

    private EntityItemStringType  hardware_addr;
    //{0..1}

    private EntityItemIPAddressStringType  inet_addr;
    //{0..1}

    private EntityItemIPAddressStringType  broadcast_addr;
    //{0..1}

    private EntityItemIPAddressStringType  netmask;
    //{0..1}

    private final Collection<EntityItemAddrTypeType>  addr_type =
        new ArrayList<EntityItemAddrTypeType>();
    //{0..*}



    /**
     * Constructor.
     */
    public NetworkInterfaceItem()
    {
        this( 0 );
    }


    public NetworkInterfaceItem(
                    final int id
                    )
    {
        super( id );

        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.network_interface;
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
    public EntityItemIntType getIndex()
    {
        return this.index;
    }


    public void setIndex(
                    final EntityItemIntType index
                    )
    {
        this.index = index;
    }



    /**
     */
    public EntityItemNetworkInterfaceTypeType getType()
    {
        return this.type;
    }


    public void setType(
                    final EntityItemNetworkInterfaceTypeType name
                    )
    {
        this.type = name;
    }



    /**
     */
    public EntityItemStringType getHardwareAddr()
    {
        return this.hardware_addr;
    }


    public void setHardwareAddr(
                    final EntityItemStringType hardware_addr
                    )
    {
        this.hardware_addr = hardware_addr;
    }



    /**
     */
    public EntityItemIPAddressStringType getInetAddr()
    {
        return this.inet_addr;
    }


    public void setInetAddr(
                    final EntityItemIPAddressStringType inet_addr
                    )
    {
        this.inet_addr = inet_addr;
    }



    /**
     */
    public EntityItemIPAddressStringType getBroadcastAddr()
    {
        return this.broadcast_addr;
    }


    public void setBroadcastAddr(
                    final EntityItemIPAddressStringType broadcast_addr
                    )
    {
        this.broadcast_addr = broadcast_addr;
    }



    /**
     */
    public EntityItemIPAddressStringType getNetmask()
    {
        return this.netmask;
    }


    public void setNetmask(
                    final EntityItemIPAddressStringType netmask
                    )
    {
        this.netmask = netmask;
    }



    /**
     */
    public void setAddrType(
                    final Collection<? extends EntityItemAddrTypeType> addr_types
                    )
    {
        if (this.addr_type != addr_types) {
            this.addr_type.clear();
            if (addr_types != null  &&  addr_types.size() > 0) {
                this.addr_type.addAll( addr_types );
            }
        }
    }


    public Collection<EntityItemAddrTypeType> getAddrType()
    {
        return this.addr_type;
    }


    public Iterator<EntityItemAddrTypeType> iterateAddrType()
    {
        return this.addr_type.iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "network_interface_item[" + super.toString()
             + ", name="            + getName()
             + ", index="           + getIndex()
             + ", type="            + getType()
             + ", hardware_addr="   + getHardwareAddr()
             + ", inet_addr="       + getInetAddr()
             + ", broadcast_addr="  + getBroadcastAddr()
             + ", netmask="         + getNetmask()
             + ", addr_type="       + getAddrType()
             + "]";
    }

}
//NetworkInterfaceItem