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



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class DefinitionQueryParams
    extends DefinitionsElementQueryParams
{

    public static class Key
    extends DefinitionsElementQueryParams.Key
    {
        public static final String  DEFINITION_CLASS    = "class";
//        public static final String  TITLE               = "title"; // Use "searchTerms" instead!!!
//        public static final String  FAMILY              = "family";   //override
        public static final String  PLATFORM            = "platform";
        public static final String  PRODUCT             = "product";
        public static final String  REF_SOURCE          = "refSource";
        public static final String  REF_ID              = "refId";
        public static final String  CVE                 = "cve";
    }
    // Key



    /**
     * Constructor.
     */
    public DefinitionQueryParams()
    {
    }



    /**
     */
    public void setDefinitionClass(
                    final String definition_class
                    )
    {
        set( Key.DEFINITION_CLASS, definition_class );
    }


    public String getDefinitionClass()
    {
        return get( Key.DEFINITION_CLASS );
    }



//    /**
//     */
//    public void setTitle(
//                    final String title
//    )
//    {
//        set( Key.TITLE, title );
//    }
//
//
//    public String getTitle()
//    {
//        return get( Key.TITLE );
//    }



//    /**
//     */
//    public void setFamily(
//                    final String family
//    )
//    {
//        set( Key.FAMILY, family );
//    }
//
//
//    public String getFamily()
//    {
//        return get( Key.FAMILY );
//    }



    /**
     */
    public void setPlatform(
                    final String platform
    )
    {
        set( Key.PLATFORM, platform );
    }


    public String getPlatform()
    {
        return get( Key.PLATFORM );
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
    public void setRefSource(
                    final String ref_source
    )
    {
        set( Key.REF_SOURCE, ref_source );
    }


    public String getRefSource()
    {
        return get( Key.REF_SOURCE );
    }



    /**
     */
    public void setRefId(
                    final String ref_id
    )
    {
        set( Key.REF_ID, ref_id );
    }


    public String getRefId()
    {
        return get( Key.REF_ID );
    }



    /**
     */
    public void setCve(
                    final String cve
    )
    {
        set( Key.CVE, cve );
    }


    public String getCve()
    {
        return get( Key.CVE );
    }

}
//

