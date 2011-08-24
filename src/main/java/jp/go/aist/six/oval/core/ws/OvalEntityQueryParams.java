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
public class DefinitionsQueryParams
    extends CommonQueryParams
{

    public static class Key
    extends CommonQueryParams.Key
    {
        public static final String  ID                  = "id";
        public static final String  VERSION             = "version";
        public static final String  DEFINITION_CLASS    = "definition_class";
        public static final String  FAMILY              = "family";
        public static final String  PLATFORM            = "platform";
        public static final String  PRODUCT             = "product";
        public static final String  REF_ID              = "ref_id";
    }
    // Key



    /**
     * The default sorting order.
     */
    public static final String  DEFAULT_ORDER = "oval_id";



    /**
     * Constructor.
     */
    public DefinitionsQueryParams()
    {
        setOrder( DEFAULT_ORDER );
    }



    /**
     */
    public void setId(
                    final String id
    )
    {
        set( DefinitionQueryKey.ID, id );
    }


    public String getId()
    {
        return String.class.cast( get( DefinitionQueryKey.ID ) );
    }



    /**
     */
    public void setVersion(
                    final String version
    )
    {
        set( DefinitionQueryKey.VERSION, version );
    }


    public String getVersion()
    {
        return String.class.cast( get( DefinitionQueryKey.VERSION ) );
    }



    /**
     */
    public void setDefinition_class(
                    final String definitionClass
    )
    {
        set( DefinitionQueryKey.DEFINITION_CLASS, definitionClass );
    }


    public String getDefinition_class()
    {
        return String.class.cast( get( DefinitionQueryKey.DEFINITION_CLASS ) );
    }



    /**
     */
    public void setFamily(
                    final String family
    )
    {
        set( DefinitionQueryKey.FAMILY, family );
    }


    public String getFamily()
    {
        return String.class.cast( get( DefinitionQueryKey.FAMILY ) );
    }



    /**
     */
    public void setPlatform(
                    final String platform
    )
    {
        set( DefinitionQueryKey.PLATFORM, platform );
    }


    public String getPlatform()
    {
        return String.class.cast( get( DefinitionQueryKey.PLATFORM ) );
    }



    /**
     */
    public void setProduct(
                    final String product
    )
    {
        set( DefinitionQueryKey.PRODUCT, product );
    }


    public String getProduct()
    {
        return String.class.cast( get( DefinitionQueryKey.PRODUCT ) );
    }



    /**
     */
    public void setRef_id(
                    final String ref_id
    )
    {
        set( DefinitionQueryKey.REF_ID, ref_id );
    }


    public String getRef_id()
    {
        return String.class.cast( get( DefinitionQueryKey.REF_ID ) );
    }

}
//DefinitionQueryParams

