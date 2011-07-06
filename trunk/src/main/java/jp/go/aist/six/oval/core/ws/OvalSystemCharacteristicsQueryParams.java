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
        _addHandler( new PatternHandler( PRIMARY_HOST_NAME, "system_info.primary_host_name" ) );
        _addHandler( new PatternHandler( OS_NAME,           "system_info.os_name"           ) );
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


//    protected void _buildPrimary_host_name(
//                    final Query<OvalSystemCharacteristics> query
//                    )
//    {
//        String  primary_host_name = getPrimary_host_name();
//        if (primary_host_name != null) {
//            Pattern  pat = Pattern.compile( ".*" + primary_host_name + ".*", Pattern.CASE_INSENSITIVE );
//            query.filter( PRIMARY_HOST_NAME, pat );
//        }
//    }



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


//    protected void _buildOs_name(
//                    final Query<OvalSystemCharacteristics> query
//                    )
//    {
//        String  os_name = getOs_name();
//        if (os_name != null) {
//            Pattern  pat = Pattern.compile( ".*" + os_name + ".*", Pattern.CASE_INSENSITIVE );
//            query.filter( OS_NAME, pat );
//        }
//    }



//    //**************************************************************
//    //  extends QueryParams
//    //**************************************************************
//
//    @Override
//    public void buildQuery(
//                    final Query<OvalSystemCharacteristics> query
//                    )
//    {
//        _buildPrimary_host_name( query );
//        _buildOs_name( query );
//
//        super.buildQuery( query );
//    }

}
// OvalSystemCharacteristicsQueryParams

