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

package jp.go.aist.six.oval.model.unix;

import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.sc.EntityItemIPAddressStringType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;



/**
 * The interface item enumerates various attributes
 * about the network interfaces on a system.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class InterfaceItem
    extends ItemType
{

    //{0..1}
    private EntityItemStringType               name;
    private EntityItemInterfaceType     type;
    private EntityItemStringType               hardware_addr;
    private EntityItemIPAddressStringType      inet_addr;
    private EntityItemIPAddressStringType      broadcast_addr;
    private EntityItemIPAddressStringType      netmask;
    private EntityItemStringType               flag;



    /**
     * Constructor.
     */
    public InterfaceItem()
    {
        this( 0 );
    }


    public InterfaceItem(
                    final int id
                    )
    {
        super( id );

//        _oval_platform_type = OvalPlatformType.unix;
//        _oval_component_type = OvalComponentType.network_interface;
        _oval_family = Family.UNIX;
        _oval_component = Component.INTERFACE;
    }



    /**
     */
    public void setName(
                    final EntityItemStringType name
                    )
    {
        this.name = name;
    }


    public EntityItemStringType getName()
    {
        return name;
    }



    /**
     */
    public void setType(
                    final EntityItemInterfaceType type
                    )
    {
        this.type = type;
    }


    public EntityItemInterfaceType getType()
    {
        return type;
    }



    /**
     */
    public void setHardwareAddr(
                    final EntityItemStringType hardware_addr
                    )
    {
        this.hardware_addr = hardware_addr;
    }


    public EntityItemStringType getHardwareAddr()
    {
        return hardware_addr;
    }



    /**
     */
    public void setInetAddr(
                    final EntityItemIPAddressStringType inet_addr
                    )
    {
        this.inet_addr = inet_addr;
    }


    public EntityItemIPAddressStringType getInetAddr()
    {
        return inet_addr;
    }



    /**
     */
    public void setBroadcastAddr(
                    final EntityItemIPAddressStringType broadcast_addr
                    )
    {
        this.broadcast_addr = broadcast_addr;
    }


    public EntityItemIPAddressStringType getBroadcastAddr()
    {
        return broadcast_addr;
    }



    /**
     */
    public void setNetmask(
                    final EntityItemIPAddressStringType netmask
                    )
    {
        this.netmask = netmask;
    }


    public EntityItemIPAddressStringType getNetmask()
    {
        return netmask;
    }



    /**
     */
    public void setFlag(
                    final EntityItemStringType flag
                    )
    {
        this.flag = flag;
    }


    public EntityItemStringType getFlag()
    {
        return flag;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "interface_item[" + super.toString()
                        + ", name="            + getName()
                        + ", type="            + getType()
                        + ", hadware_addr="    + getHardwareAddr()
                        + ", inet_addr="       + getInetAddr()
                        + ", broadcast_addr="  + getBroadcastAddr()
                        + ", netmask="         + getNetmask()
                        + ", flag="            + getFlag()
             + "]";
    }

}
//InterfaceItem
