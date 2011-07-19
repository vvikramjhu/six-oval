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

import jp.go.aist.six.oval.model.v5.sc.OvalSystemCharacteristics;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalSystemCharacteristicsQueryParams
    extends QueryParams<OvalSystemCharacteristics>
{

    public static final String  PRIMARY_HOST_NAME   = "primary_host_name";
    public static final String  OS_NAME             = "os_name";



    /**
     * Constructor.
     */
    public OvalSystemCharacteristicsQueryParams()
    {
        _addHandler( DatetimeHandler.newAfterHandler(  "generator.timestamp" ) );
        _addHandler( DatetimeHandler.newBeforeHandler( "generator.timestamp" ) );
        _addHandler( new PatternHandler( PRIMARY_HOST_NAME, "system_info.primary_host_name" ) );
        _addHandler( new PatternHandler( OS_NAME,           "system_info.os_name"           ) );
    }



    /**
     */
    public void setAfter(
                    final String after
    )
    {
        _setParam( DatetimeHandler.AFTER, after );
    }


    public String getAfter()
    {
        return _getParam( DatetimeHandler.AFTER );
    }



    /**
     */
    public void setBefore(
                    final String before
    )
    {
        _setParam( DatetimeHandler.BEFORE, before );
    }


    public String getBefore()
    {
        return _getParam( DatetimeHandler.BEFORE );
    }



    /**
     */
    public void setPrimary_host_name(
                    final String primary_host_name
    )
    {
        _setParam( PRIMARY_HOST_NAME, primary_host_name );
    }


    public String getPrimary_host_name()
    {
        return _getParam( PRIMARY_HOST_NAME );
    }



    /**
     */
    public void setOs_name(
                    final String os_name
    )
    {
        _setParam( OS_NAME, os_name );
    }


    public String getOs_name()
    {
        return _getParam( OS_NAME );
    }

}
// OvalSystemCharacteristicsQueryParams

