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

package jp.go.aist.six.oval.repository;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalSystemCharacteristicsQueryParams
    extends CommonQueryParams
{

    public static class Key
    extends CommonQueryParams.Key
    {
        public static final String  HOST        = "primary_host_name";
        public static final String  OS          = "os_name";
        public static final String  OS_VERSION  = "os_version";
        public static final String  IP          = "ip_address";
        public static final String  MAC         = "mac_address";
    }
    // Key



    /**
     * Constructor.
     */
    public OvalSystemCharacteristicsQueryParams()
    {
    }



    /**
     */
    public void setHost(
                    final String host
                    )
    {
        set( Key.HOST, host );
    }


    public String getHost()
    {
        return get( Key.HOST );
    }



    /**
     */
    public void setOs(
                    final String os_name
    )
    {
        set( Key.OS, os_name );
    }


    public String getOs()
    {
        return get( Key.OS );
    }



    /**
     */
    public void setOsVersion(
                    final String os_version
    )
    {
        set( Key.OS_VERSION, os_version );
    }


    public String getOsVersion()
    {
        return get( Key.OS_VERSION );
    }



    /**
     */
    public void setIp(
                    final String ip_address
    )
    {
        set( Key.IP, ip_address );
    }


    public String getIp()
    {
        return get( Key.IP );
    }



    /**
     */
    public void setMac(
                    final String mac_address
    )
    {
        set( Key.MAC, mac_address );
    }


    public String getMac()
    {
        return get( Key.MAC );
    }

}
//

