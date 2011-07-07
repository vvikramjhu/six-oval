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

import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class DefinitionsQueryParams
    extends QueryParams<DefinitionType>
{

    public static final String  DEFINITION_CLASS    = "definition_class";
    public static final String  FAMILY              = "family";
    public static final String  PLATFORM            = "platform";
    public static final String  PRODUCT             = "product";




    /**
     * Constructor.
     */
    public DefinitionsQueryParams()
    {
        _addHandler( new Handler( DEFINITION_CLASS, "class"                      ) );
        _addHandler( new Handler( FAMILY,           "metadata.affected.family"   ) );
        _addHandler( new Handler( PLATFORM,         "metadata.affected.platform" ) );
        _addHandler( new Handler( PRODUCT,          "metadata.affected.product"  ) );
    }



    /**
     */
    public void setDefinition_class(
                    final String definitionClass
    )
    {
        _setParam( DEFINITION_CLASS, definitionClass );
    }


    public String getDefinition_class()
    {
        return _getParam( DEFINITION_CLASS );
    }



    /**
     */
    public void setFamily(
                    final String family
    )
    {
        _setParam( FAMILY, family );
    }


    public String getFamily()
    {
        return _getParam( FAMILY );
    }



    /**
     */
    public void setPlatform(
                    final String platform
    )
    {
        _setParam( PLATFORM, platform );
    }


    public String getPlatform()
    {
        return _getParam( PLATFORM );
    }



    /**
     */
    public void setProduct(
                    final String product
    )
    {
        _setParam( PRODUCT, product );
    }


    public String getProduct()
    {
        return _getParam( PRODUCT );
    }

}
//DefinitionQueryParams

