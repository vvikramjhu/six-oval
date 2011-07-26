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

import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class DefinitionsQueryParams
    extends QueryParams<DefinitionType>
{

    public static final String  ID                  = "id";
    public static final String  VERSION             = "version";
    public static final String  DEFINITION_CLASS    = "definition_class";
    public static final String  FAMILY              = "family";
    public static final String  PLATFORM            = "platform";
    public static final String  PRODUCT             = "product";




    /**
     * Constructor.
     */
    public DefinitionsQueryParams()
    {
    }



    /**
     */
    public void setId(
                    final String id
    )
    {
        set( ID, id );
    }


    public String getId()
    {
        return String.class.cast( get( ID ) );
    }



    /**
     */
    public void setVersion(
                    final String version
    )
    {
        set( VERSION, version );
    }


    public String getVersion()
    {
        return String.class.cast( get( VERSION ) );
    }



    /**
     */
    public void setDefinition_class(
                    final String definitionClass
    )
    {
        set( DEFINITION_CLASS, definitionClass );
    }


    public String getDefinition_class()
    {
        return String.class.cast( get( DEFINITION_CLASS ) );
    }



    /**
     */
    public void setFamily(
                    final String family
    )
    {
        set( FAMILY, family );
    }


    public String getFamily()
    {
        return String.class.cast( get( FAMILY ) );
    }



    /**
     */
    public void setPlatform(
                    final String platform
    )
    {
        set( PLATFORM, platform );
    }


    public String getPlatform()
    {
        return String.class.cast( get( PLATFORM ) );
    }



    /**
     */
    public void setProduct(
                    final String product
    )
    {
        set( PRODUCT, product );
    }


    public String getProduct()
    {
        return String.class.cast( get( PRODUCT ) );
    }

}
//DefinitionQueryParams

