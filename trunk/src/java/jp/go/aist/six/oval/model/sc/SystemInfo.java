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

import jp.go.aist.six.util.castor.AbstractPersistable;
import jp.go.aist.six.util.orm.Dependent;
import java.util.Collection;



/**
 * General information about the system that data was collected from,
 * including information that can be used to identify the system.
 *
 * <p>Properties:</p>
 * <ul>
 *   <li>os_name (1..1)</li>
 *   <li>os_version (1..1)</li>
 *   <li>architecture (1..1)</li>
 *   <li>primaryhostName (1..1)</li>
 *   <li>netInterfaces (1..1): "interfaces" is renamed
 *   because the name "interface" has the special meaning in Java. </li>
 * </ul>
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class SystemInfo
    extends AbstractPersistable
    implements Dependent<OvalSystemCharacteristics>
{

    private String  _osName;
    //{1..1}

    private String  _osVersion;
    //{1..1}

    private String  _architecture;
    //{1..1}

    private String  _primaryHostName;
    //{1..1}

    private NetInterfaces  _interfaces = new NetInterfaces();
    //{1..1}


    //TODO: add property which denotes the OS name.
    // The domain of the OS names is the same as the affected platforms.
    // XSD namaspace should be, e.g. http://.../six.



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
                    Collection<? extends NetInterface> ifs
                    )
    {
        this( osName, osVersion, arch, hostName );
        setInterfaces( new NetInterfaces( ifs ) );
    }



    /**
     * Constructor.
     */
    public SystemInfo(
                    final String osName,
                    final String osVersion,
                    final String arch,
                    final String hostName,
                    NetInterface[] ifs
                    )
    {
        this( osName, osVersion, arch, hostName );
        setInterfaces( new NetInterfaces( ifs ) );
    }



    /**
     */
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



    /**
     */
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



    /**
     */
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



    /**
     */
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



    /**
     */
    public void setInterfaces(
                    final NetInterfaces interfaces
                    )
    {
        _interfaces = interfaces;
    }


    public NetInterfaces getInterfaces()
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
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "system_info[os_name=" + getOsName()
                    + ", os_version=" + getOsVersion()
                    + ", architecture=" + getArchitecture()
                    + ", primary_host_name=" + getPrimaryHostName()
                    + ", interfaces=" + getInterfaces()
                    + "]";
    }

}
// SystemInfo
