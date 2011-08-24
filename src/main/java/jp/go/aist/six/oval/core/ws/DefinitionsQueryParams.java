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
    extends OvalEntityQueryParams
{

    public static class Key
    extends OvalEntityQueryParams.Key
    {
        public static final String  DEFINITION_CLASS    = "definition_class";
        public static final String  FAMILY              = "family";
//        public static final String  PLATFORM            = "platform"; //defined in OvalEntityQueryParams
        public static final String  PRODUCT             = "product";
        public static final String  REF_ID              = "ref_id";
    }
    // Key



    /**
     * Constructor.
     */
    public DefinitionsQueryParams()
    {
    }



    /**
     */
    public void setDefinition_class(
                    final String definition_class
                    )
    {
        set( Key.DEFINITION_CLASS, definition_class );
    }


    public String getDefinition_class()
    {
        return get( Key.DEFINITION_CLASS );
    }



    /**
     */
    public void setFamily(
                    final String family
    )
    {
        set( Key.FAMILY, family );
    }


    public String getFamily()
    {
        return get( Key.FAMILY );
    }



    /**
     */
    public void setProduct(
                    final String product
    )
    {
        set( Key.PRODUCT, product );
    }


    public String getProduct()
    {
        return get( Key.PRODUCT );
    }



    /**
     */
    public void setRef_id(
                    final String ref_id
    )
    {
        set( Key.REF_ID, ref_id );
    }


    public String getRef_id()
    {
        return get( Key.REF_ID );
    }

}
//DefinitionQueryParams

