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

package jp.go.aist.six.oval.core.ws;





/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalSystemCharacteristicsQueryParams
    extends CommonQueryParams
{

    public static class Key
    extends CommonQueryParams.Key
    {
        public static final String  PRIMARY_HOST_NAME   = "primary_host_name";
        public static final String  OS_NAME             = "os_name";
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
    public void setPrimary_host_name(
                    final String primary_host_name
                    )
    {
        set( Key.PRIMARY_HOST_NAME, primary_host_name );
    }


    public String getPrimary_host_name()
    {
        return get( Key.PRIMARY_HOST_NAME );
    }



    /**
     */
    public void setOs_name(
                    final String os_name
    )
    {
        set( Key.OS_NAME, os_name );
    }


    public String getOs_name()
    {
        return get( Key.OS_NAME );
    }

}
// OvalSystemCharacteristicsQueryParams

