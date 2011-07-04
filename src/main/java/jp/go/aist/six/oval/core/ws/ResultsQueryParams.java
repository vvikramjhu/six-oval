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

import jp.go.aist.six.oval.model.v5.results.SystemType;
import com.google.code.morphia.query.Query;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class ResultsQueryParams
{

    public static final String  PRIMARY_HOST_NAME   = "results.system.oval_system_characteristics.system_info.primary_host_nmae";
    public static final String  OS_NAME             = "results.system.oval_system_characteristics.system_info.os_name";

    private final Params  _params = new Params();




    /**
     * Constructor.
     */
    public ResultsQueryParams()
    {
    }



    public void buildQuery(
                    final Query<SystemType> query
                    )
    {
        _params.buildQuery( query );
    }



    /**
     */
    public void setPrimaryHostName(
                    final String primary_host_name
    )
    {
        _params.setProperty( PRIMARY_HOST_NAME, primary_host_name );
    }


    public String getPrimaryHostName()
    {
        return _params.getProperty( PRIMARY_HOST_NAME );
    }



    /**
     */
    public void setOsName(
                    final String os_name
    )
    {
        _params.setProperty( OS_NAME, os_name );
    }


    public String getOsName()
    {
        return _params.getProperty( OS_NAME );
    }



    @Override
    public String toString()
    {
        return _params.toString();
    }



    //==============================================================
    //  nested classes
    //==============================================================

    private static class Params
    extends QueryParams<SystemType>
    {

        //**********************************************************
        //  extends QueryParams
        //**********************************************************

        @Override
        public void buildQuery(
                        final Query<SystemType> query
                        )
        {
            _buildFilterQueryParam( query, PRIMARY_HOST_NAME );

            _buildDefaultQueryParams( query );
        }
    }

}
// ResultsQueryParams

