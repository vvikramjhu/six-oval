/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
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

package jp.go.aist.six.oval.model.definition;

import jp.go.aist.six.oval.model.common.Family;
import jp.go.aist.six.util.orm.AbstractPersistable;
import java.util.ArrayList;
import java.util.Collection;



/**
 * An Affected describes family, platform(s), and product(s)
 * to be evaluated for the OVAL Definition.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class Affected
extends AbstractPersistable
{

    private Collection<Platform>  _platform = new ArrayList<Platform>();
    //{0..*}

    private Collection<Product>  _product = new ArrayList<Product>();
    //{0..*}

    private Family  _family;
    //{required}



    /**
     * Constructor.
     */
    public Affected()
    {
    }



    public void setPlatform(
                    final Collection<? extends Platform> platformList
                    )
    {
        if (_platform != platformList) {
            _platform.clear();
            if (platformList != null) {
                for (Platform  p : platformList) {
                    addPlatform( p );
                }
            }
        }
    }


    public boolean addPlatform(
                    final Platform platform
                    )
    {
        if (platform == null) {
            return false;
        }

        return _platform.add( platform );
    }


    public Collection<Platform> getPlatform()
    {
        return _platform;
    }



    public void setProduct(
                    final Collection<? extends Product> productList
                    )
    {
        if (_product != productList) {
            _product.clear();
            if (productList != null) {
                for (Product  p : productList) {
                    addProduct( p );
                }
            }
        }
    }


    public boolean addProduct(
                    final Product product
                    )
    {
        if (product == null) {
            return false;
        }

        return _product.add( product );
    }


    public Collection<Product> getProduct()
    {
        return _product;
    }



    public void setFamily(
                    final Family family
                    )
    {
        _family = family;
    }


    public Family getFamily()
    {
        return _family;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        Collection<Platform>  platform = getPlatform();
        result = prime * result + ((platform == null) ? 0 : platform.hashCode());

        Collection<Product>  product = getProduct();
        result = prime * result + ((product == null) ? 0 : product.hashCode());

        Family  family = getFamily();
        result = prime * result + ((family == null) ? 0 : family.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Affected)) {
            return false;
        }

        Affected  other = (Affected)obj;
        Collection<Product>  other_product = other.getProduct();
        Collection<Product>   this_product =  this.getProduct();
        if (this_product == other_product
                        ||  (this_product != null
                                        &&  this_product.equals( other_product ))) {
            Collection<Platform>  other_platform = other.getPlatform();
            Collection<Platform>   this_platform =  this.getPlatform();
            if (this_platform == other_platform
                        ||  (this_platform != null
                                        &&  this_platform.equals( other_platform ))) {
                if (this.getFamily() == other.getFamily()) {
                    return true;
                }
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "Affected[family=" + getFamily()
                        + ", platform=" + getPlatform()
                        + ", product="  + getProduct()
                        + "]";
    }

}
// Affected
