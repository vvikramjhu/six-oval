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

import jp.go.aist.six.oval.model.v5.common.ClassEnumeration;
import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;
import com.google.code.morphia.query.Query;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class DefinitionQueryParams
{

    public static final String  DEFINITION_CLASS    = "class";
    public static final String  FAMILY              = "metadata.affected.family";
    public static final String  PLATFORM            = "metadata.affected.platform";
    public static final String  PRODUCT             = "metadata.affected.product";

    private final Params  _params = new Params();

//    private String  _definitionClass;
//    private String  _family;
//    private String  _platform;
//    private String  _product;



    /**
     * Constructor.
     */
    public DefinitionQueryParams()
    {
    }



    public void buildQuery(
                    final Query<DefinitionType> query
                    )
    {
        _params.buildQuery( query );
    }



    /**
     */
    public void setDefinitionClass(
                    final String definitionClass
    )
    {
        _params.setProperty( DEFINITION_CLASS, definitionClass );
    }


    public String getDefinitionClass()
    {
        return _params.getProperty( DEFINITION_CLASS );
    }



    /**
     */
    public void setFamily(
                    final String family
    )
    {
        _params.setProperty( FAMILY, family );
    }


    public String getFamily()
    {
        return _params.getProperty( FAMILY );
    }



    /**
     */
    public void setPlatform(
                    final String platform
    )
    {
        _params.setProperty( PLATFORM, platform );
    }


    public String getPlatform()
    {
        return _params.getProperty( PLATFORM );
    }



    /**
     */
    public void setProduct(
                    final String product
    )
    {
        _params.setProperty( PRODUCT, product );
    }


    public String getProduct()
    {
        return _params.getProperty( PRODUCT );
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
    extends QueryParams<DefinitionType>
    {

        //**********************************************************
        //  extends QueryParams
        //**********************************************************

        @Override
        public void buildQuery(
                        final Query<DefinitionType> query
                        )
        {
            String  definitionClass = getProperty( DEFINITION_CLASS );
            if (definitionClass != null) {
                query.filter( DEFINITION_CLASS,
                                ClassEnumeration.fromValue( definitionClass ) );
            }

            _buildFilterQueryParam( query, FAMILY );
            _buildFilterQueryParam( query, PLATFORM );
            _buildFilterQueryParam( query, PRODUCT );

            _buildDefaultQueryParams( query );
        }
    }

}
//DefinitionQueryParams

