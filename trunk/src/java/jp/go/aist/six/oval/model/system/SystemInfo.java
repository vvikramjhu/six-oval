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
import java.util.ArrayList;
import java.util.Collection;


/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id: SystemInfo.java 752 2010-05-10 03:14:15Z akihito $
 */
public class SystemInfo
    implements Persistable
    , Dependent<OvalSystemCharacteristics>
{

    private String  _osName;
    //{1..1}

    private String  _osVersion;
    //{1..1}

    private String  _architecture;
    //{1..1}

    private String  _primaryHostName;
    //{1..1}

//  private Interfaces  _interfaces;
//  //{1..1}

    private Collection<NetworkInterface>  _interfaces =
        new ArrayList<NetworkInterface>();
    //{0..*}



    /**
     * Constructor.
     */
    public SystemInfo()
    {
    }



    /**
     * Constructor.
     */
    public SystemInfo(
                    final String osName,
                    final String osVersion,
                    final String arch,
                    final String hostName
                    )
    {
        setOsName( osName );
        setOsVersion( osVersion );
        setArchitecture( arch );
        setPrimaryHostName( hostName );
    }



    /**
     * Constructor.
     */
    public SystemInfo(
                    final String osName,
                    final String osVersion,
                    final String arch,
                    final String hostName,
                    Collection<NetworkInterface> ifs
                    )
    {
        this( osName, osVersion, arch, hostName );
        setInterfaces( ifs );
    }



    public void setOsName(
                    final String name
                    )
    {
        _osName = name;
    }



    public String getOsName()
    {
        return _osName;
    }



    public void setOsVersion(
                    final String version
                    )
    {
        _osVersion = version;
    }



    public String getOsVersion()
    {
        return _osVersion;
    }



    public void setArchitecture(
                    final String architecture
                    )
    {
        _architecture = architecture;
    }



    public String getArchitecture()
    {
        return _architecture;
    }



    public void setPrimaryHostName(
                    final String hostName
                    )
    {
        _primaryHostName = hostName;
    }



    public String getPrimaryHostName()
    {
        return _primaryHostName;
    }



    public void setInterfaces(
                    final Collection<NetworkInterface> netifs
                    )
    {
        _interfaces.clear();
        if (netifs == null || netifs.size() == 0) {
            return;
        }

        for (NetworkInterface netif : netifs) {
            addInterface( netif );
        }
    }


    public boolean addInterface(
                    final NetworkInterface netif
                    )
    {
        if (netif == null) {
            return false;
        }

        return _interfaces.add( netif );
    }


    public Collection<NetworkInterface> getInterfaces()
    {
        return _interfaces;
    }



    //**************************************************************
    //  Dependent
    //**************************************************************

    private OvalSystemCharacteristics  _master;


    public void setMasterObject(
                    final OvalSystemCharacteristics sc
                    )
    {
        _master = sc;
    }


    public OvalSystemCharacteristics getMasterObject()
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
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "SystemInfo[os=" + getOsName() + " " + getOsVersion()
                    + ", architecture=" + getArchitecture()
                    + ", primary_host_name=" + getPrimaryHostName()
                    + ", interfaces=" + getInterfaces()
                    + "]";
    }

}
// SystemInfo
