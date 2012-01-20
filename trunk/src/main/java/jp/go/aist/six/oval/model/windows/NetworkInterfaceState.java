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

import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.definitions.EntityStateIPAddressStringType;
import jp.go.aist.six.oval.model.definitions.EntityStateIntType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The network_interface state enumerates the different properties 
 * associate with a Windows interface. 
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class NetworkInterfaceState
    extends StateType
{

    //{0..1}
    private EntityStateStringType               name;
    private EntityStateIntType                  index;
    private EntityStateNetworkInterfaceTypeType type;
    private EntityStateStringType               hardware_addr;
    private EntityStateIPAddressStringType      inet_addr;
    private EntityStateIPAddressStringType      broadcast_addr;
    private EntityStateIPAddressStringType      netmask;
    private EntityStateAddrTypeType             addr_type;



    /**
     * Constructor.
     */
    public NetworkInterfaceState()
    {
        this( null, 0 );
    }


    public NetworkInterfaceState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public NetworkInterfaceState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.network_interface;
    }



    /**
     */
    public void setName(
                    final EntityStateStringType name
                    )
    {
        this.name = name;
    }


    public EntityStateStringType getName()
    {
        return this.name;
    }



    /**
     */
    public void setIndex(
                    final EntityStateIntType index
                    )
    {
        this.index = index;
    }


    public EntityStateIntType getIndex()
    {
        return this.index;
    }



    /**
     */
    public void setType(
                    final EntityStateNetworkInterfaceTypeType type
                    )
    {
        this.type = type;
    }


    public EntityStateNetworkInterfaceTypeType getType()
    {
        return this.type;
    }



    /**
     */
    public void setHardwareAddr(
                    final EntityStateStringType hardware_addr
                    )
    {
        this.hardware_addr = hardware_addr;
    }


    public EntityStateStringType getHardwareAddr()
    {
        return this.hardware_addr;
    }



    /**
     */
    public void setInetAddr(
                    final EntityStateIPAddressStringType inet_addr
                    )
    {
        this.inet_addr = inet_addr;
    }


    public EntityStateIPAddressStringType getInetAddr()
    {
        return this.inet_addr;
    }



    /**
     */
    public void setBroadcastAddr(
                    final EntityStateIPAddressStringType broadcast_addr
                    )
    {
        this.broadcast_addr = broadcast_addr;
    }


    public EntityStateIPAddressStringType getBroadcastAddr()
    {
        return this.broadcast_addr;
    }



    /**
     */
    public void setNetmask(
                    final EntityStateIPAddressStringType netmask
                    )
    {
        this.netmask = netmask;
    }


    public EntityStateIPAddressStringType getNetmask()
    {
        return this.netmask;
    }



    /**
     */
    public void setAddrType(
                    final EntityStateAddrTypeType addr_type
                    )
    {
        this.addr_type = addr_type;
    }


    public EntityStateAddrTypeType getAddrType()
    {
        return this.addr_type;
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
        if (!(obj instanceof NetworkInterfaceState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "neytwork_interface_state[" + super.toString()
             + ", name="            + getName()
             + ", index="           + getIndex()
             + ", type="            + getType()
             + ", hadware_addr="    + getHardwareAddr()
             + ", inet_addr="       + getInetAddr()
             + ", broadcast_addr="  + getBroadcastAddr()
             + ", netmask="         + getNetmask()
             + ", addr_type="       + getAddrType()
             + "]";
    }
}
//NetworkInterfaceState
