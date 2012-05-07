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

package jp.go.aist.six.oval.model.sc;

import java.util.Collection;
import jp.go.aist.six.oval.model.OvalObject;



/**
 * General information about the system that data was collected from,
 * including information that can be used to identify the system.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class SystemInfoType
    implements OvalObject
//    implements Dependent<OvalSystemCharacteristics>
{

    private String  os_name;
    //{1..1}

    private String  os_version;
    //{1..1}

    private String  architecture;
    //{1..1}

    private String  primary_host_name;
    //{1..1}

    private InterfacesType  interfaces;// = new NetInterfaces();
    //{1..1}


    //TODO: add property which denotes the OS family???
    // The domain of the OS names is the same as the affected platforms.
    // XSD namaspace should be, e.g. http://.../six.



    /**
     * Constructor.
     */
    public SystemInfoType()
    {
    }


    public SystemInfoType(
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


    public SystemInfoType(
                    final String osName,
                    final String osVersion,
                    final String arch,
                    final String hostName,
                    final Collection<? extends InterfaceType> ifs
                    )
    {
        this( osName, osVersion, arch, hostName );
        setInterfaces( new InterfacesType( ifs ) );
    }



    public SystemInfoType(
                    final String osName,
                    final String osVersion,
                    final String arch,
                    final String hostName,
                    final InterfaceType[] ifs
                    )
    {
        this( osName, osVersion, arch, hostName );
        setInterfaces( new InterfacesType( ifs ) );
    }



    /**
     */
    public void setOsName(
                    final String os_name
                    )
    {
        this.os_name = os_name;
    }


    public String getOsName()
    {
        return os_name;
    }



    /**
     */
    public void setOsVersion(
                    final String os_version
                    )
    {
        this.os_version = os_version;
    }


    public String getOsVersion()
    {
        return os_version;
    }



    /**
     */
    public void setArchitecture(
                    final String architecture
                    )
    {
        this.architecture = architecture;
    }


    public String getArchitecture()
    {
        return architecture;
    }



    /**
     */
    public void setPrimaryHostName(
                    final String primary_host_name
                    )
    {
        this.primary_host_name = primary_host_name;
    }



    public String getPrimaryHostName()
    {
        return primary_host_name;
    }



    /**
     */
    public void setInterfaces(
                    final InterfacesType interfaces
                    )
    {
        this.interfaces = interfaces;
    }


    public InterfacesType getInterfaces()
    {
        return interfaces;
    }



//    //**************************************************************
//    //  Dependent
//    //**************************************************************
//
//    private OvalSystemCharacteristics  _master;
//
//
//    @Override
//    public void setMasterObject(
//                    final OvalSystemCharacteristics sc
//                    )
//    {
//        _master = sc;
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

        String  os_name = getOsName();
        result = prime * result + ((os_name == null) ? 0 : os_name.hashCode());

        String  os_version = getOsVersion();
        result = prime * result + ((os_version == null) ? 0 : os_version.hashCode());

        String  arch = getArchitecture();
        result = prime * result + ((arch == null) ? 0 : arch.hashCode());

        String  host_name = getPrimaryHostName();
        result = prime * result + ((host_name == null) ? 0 : host_name.hashCode());

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

        if (!(obj instanceof SystemInfoType)) {
            return false;
        }

        SystemInfoType  other = (SystemInfoType)obj;
        String  other_host = other.getPrimaryHostName();
        String   this_host =  this.getPrimaryHostName();
        if (this_host == other_host
                        ||  (this_host != null  &&  this_host.equals( other_host ))) {
            String  other_os_version = other.getOsVersion();
            String   this_os_version =  this.getOsVersion();
            if (this_os_version == other_os_version
                            ||  (this_os_version != null  &&  this_os_version.equals( other_os_version ))) {
                String  other_os_name = other.getOsName();
                String   this_os_name =  this.getOsName();
                if (this_os_name == other_os_name
                                ||  (this_os_name != null  &&  this_os_name.equals( other_os_name ))) {
                    String  other_arch = other.getArchitecture();
                    String   this_arch =  this.getArchitecture();
                    if (this_arch == other_arch
                                    ||  (this_arch != null  &&  this_arch.equals( other_arch ))) {
                        return true;
                    }
                }
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "[os_name=" + getOsName()
                    + ", os_version=" + getOsVersion()
                    + ", architecture=" + getArchitecture()
                    + ", primary_host_name=" + getPrimaryHostName()
                    + ", interfaces=" + getInterfaces()
                    + "]";
    }

}
// SystemInfoType
