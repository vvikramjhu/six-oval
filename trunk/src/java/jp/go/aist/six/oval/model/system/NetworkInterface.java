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

package jp.go.aist.six.oval.model.system;

import jp.go.aist.six.util.orm.Dependent;
import jp.go.aist.six.util.orm.Persistable;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id: NetworkInterface.java 752 2010-05-10 03:14:15Z akihito $
 */
public class NetworkInterface
    implements Persistable
    , Dependent<SystemInfo>
{

    private String  _interfaceName;
    //{1..1}

    private String  _ipAddress;
    //{1..1}

    private String  _macAddress;
    //{1..1}



    /**
     * Constructor.
     */
    public NetworkInterface()
    {
    }


    /**
     * Constructor.
     */
    public NetworkInterface(
                    final String name,
                    final String ip,
                    final String mac
                    )
    {
        setInterfaceName( name );
        setIpAddress( ip );
        setMacAddress( mac );
    }



    public void setInterfaceName(
                    final String name
                    )
    {
        _interfaceName = name;
    }


    public String getInterfaceName()
    {
        return _interfaceName;
    }



    public void setIpAddress(
                    final String ip
                    )
    {
        _ipAddress = ip;
    }


    public String getIpAddress()
    {
        return _ipAddress;
    }



    public void setMacAddress(
                    final String mac
                    )
    {
        _macAddress = mac;
    }


    public String getMacAddress()
    {
        return _macAddress;
    }



    //**************************************************************
    //  Dependent
    //**************************************************************

    private SystemInfo  _master;



    public void setMasterObject(
                    final SystemInfo master
                    )
    {
        _master = master;
    }


    public SystemInfo getMasterObject()
    {
        return _master;
    }



    //**************************************************************
    //  Persistable
    //**************************************************************

    /**
     * The persistent identifier.
     */
    private  String  _persistentID;


    public void setPersistentID(
                    final String id
                    )
    {
        _persistentID = id;
    }


    public String getPersistentID()
    {
        return _persistentID;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        String  name = getInterfaceName();
        result = prime * result + ((name == null) ? 0 : name.hashCode());

        String  ip = getIpAddress();
        result = prime * result + ((ip == null) ? 0 : ip.hashCode());

        String  mac = getMacAddress();
        result = prime * result + ((mac == null) ? 0 : mac.hashCode());

        return result;
    }



    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof NetworkInterface)) {
            return false;
        }

        NetworkInterface  other = (NetworkInterface)obj;
        String  other_ip = other.getIpAddress();
        String   this_ip =  this.getIpAddress();
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



    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "NetworkInterface[name=" + getInterfaceName()
                        + ", IP=" + getIpAddress()
                        + ", MAC=" + getMacAddress()
                        + "]";
    }

}
// NetworkInterface
