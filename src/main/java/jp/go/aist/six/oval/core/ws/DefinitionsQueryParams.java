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
{

    private String  _definitionClass;
    private String  _family;
    private String  _platform;
    private String  _product;


    public DefinitionsQueryParams()
    {
    }


    public void setDefinitionClass(
                    final String primary_host_name
    )
    {
        _definitionClass = primary_host_name;
    }


    public String getDefinitionClass()
    {
        return _definitionClass;
    }


    public void setFamily(
                    final String family
    )
    {
        this._family = family;
    }


    public String getFamily()
    {
        return _family;
    }


    public void setPlatform(
                    final String platform
    )
    {
        this._platform = platform;
    }


    public String getPlatform()
    {
        return _platform;
    }


    public void setProduct(
                    final String product
    )
    {
        this._product = product;
    }


    public String getProduct()
    {
        return _product;
    }



    @Override
    public String toString()
    {
        return "definitionClass=" + _definitionClass
           + ", family=" + _family
           + ", platform=" + _platform
           + ", product=" + _product
           ;
    }

}
//DefinitionQueryParams

