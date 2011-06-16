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

package jp.go.aist.six.oval.model.v5.sc;




/**
 * An existing network interface on the system.
 * The name "interface" in the OVAL Schema is renamed
 * because the name has the special meaning in Java.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class NetworkInterfaceType
//    extends AbstractOvalObject
//    implements Dependent<OvalSystemCharacteristics>
//implements Dependent<SystemInfo>
{

    private String  interface_name;
    //{1..1}

    private EntityItemIPAddressStringType  ip_address;
//    private String  _ipAddress;
    //{1..1}

    private String  mac_address;
    //{1..1}



    /**
     * Constructor.
     */
    public NetworkInterfaceType()
    {
    }


    /**
     * Constructor.
     */
    public NetworkInterfaceType(
                    final String name,
                    final String ip,
                    final String mac
                    )
    {
        setInterfaceName( name );
        setIpAddress( ip );
        setMacAddress( mac );
    }



    /**
     */
    public void setInterfaceName(
                    final String interface_name
                    )
    {
        this.interface_name = interface_name;
    }


    public String getInterfaceName()
    {
        return this.interface_name;
    }



    /**
     */
    public void setIpAddress(
                    final String ip_address
                    )
    {
        setIpAddress( new EntityItemIPAddressStringType( ip_address ) );
    }


    public void setIpAddress(
                    final EntityItemIPAddressStringType ip_address
                    )
    {
        this.ip_address = ip_address;
    }


    public EntityItemIPAddressStringType getIpAddress()
    {
        return this.ip_address;
    }



    /**
     */
    public void setMacAddress(
                    final String mac_address
                    )
    {
        this.mac_address = mac_address;
    }


    public String getMacAddress()
    {
        return this.mac_address;
    }



//    //**************************************************************
//    //  Dependent
//    //**************************************************************
//
//    private OvalSystemCharacteristics  _master;
//
//
//
//    @Override
//    public void setMasterObject(
//                    final OvalSystemCharacteristics master
//                    )
//    {
//        _master = master;
//    }
//
//
//    @Override
//    public OvalSystemCharacteristics getMasterObject()
//    {
//        return _master;
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        String  interface_name = getInterfaceName();
        result = prime * result + ((interface_name == null) ? 0 : interface_name.hashCode());

        EntityItemIPAddressStringType  ip_address = getIpAddress();
        result = prime * result + ((ip_address == null) ? 0 : ip_address.hashCode());

        String  mac_address = getMacAddress();
        result = prime * result + ((mac_address == null) ? 0 : mac_address.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof NetworkInterfaceType)) {
            return false;
        }

        NetworkInterfaceType  other = (NetworkInterfaceType)obj;
        EntityItemIPAddressStringType  other_ip = other.getIpAddress();
        EntityItemIPAddressStringType   this_ip =  this.getIpAddress();
        if (this_ip == other_ip
                        ||  (this_ip != null  &&  this_ip.equals( other_ip ))) {
            String  other_mac = other.getMacAddress();
            String   this_mac =  this.getMacAddress();
            if (this_mac == other_mac
                            ||  (this_mac != null  &&  this_mac.equals( other_mac ))) {
                String  other_name = other.getInterfaceName();
                String   this_name =  this.getInterfaceName();
                if (this_name == other_name
                                ||  (this_name != null  &&  this_name.equals( other_name ))) {
                    return true;
                }
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "[interface_name=" + getInterfaceName()
                        + ", ip_address=" + getIpAddress()
                        + ", mac_address=" + getMacAddress()
                        + "]";
    }

}
// NetworkInterfaceType
