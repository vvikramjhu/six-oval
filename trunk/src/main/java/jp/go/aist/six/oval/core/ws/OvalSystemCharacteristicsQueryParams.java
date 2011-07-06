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

import java.util.regex.Pattern;
import jp.go.aist.six.oval.model.v5.sc.OvalSystemCharacteristics;
import com.google.code.morphia.query.Query;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalSystemCharacteristicsQueryParams
extends QueryParams<OvalSystemCharacteristics>
{

    public static final String  PRIMARY_HOST_NAME   = "system_info.primary_host_nmae";
    public static final String  OS_NAME             = "system_info.os_name";




    /**
     * Constructor.
     */
    public OvalSystemCharacteristicsQueryParams()
    {
    }




//    /**
//     */
//    public void setPrimaryHostName(
//                    final String primary_host_name
//    )
//    {
//        _params.setProperty( PRIMARY_HOST_NAME, primary_host_name );
//    }
//
//
//    public String getPrimaryHostName()
//    {
//        return _params.getProperty( PRIMARY_HOST_NAME );
//    }



    /**
     */
    public void setOsName(
                    final String os_name
    )
    {
        _setParam( OS_NAME, os_name );
    }


    public String getOsName()
    {
        return _getParam( OS_NAME );
    }


    protected void _buildOsName(
                    final Query<OvalSystemCharacteristics> query
                    )
    {
        String  os_name = getOsName();
        if (os_name != null) {
            Pattern  pat = Pattern.compile( ".*" + os_name + ".*", Pattern.CASE_INSENSITIVE );
            query.filter( OS_NAME, pat );
        }
    }



    //**************************************************************
    //  extends QueryParams
    //**************************************************************

    @Override
    public void buildQuery(
                    final Query<OvalSystemCharacteristics> query
                    )
    {
        _buildOsName( query );

        super.buildQuery( query );
    }

}
// OvalSystemCharacteristicsQueryParams

