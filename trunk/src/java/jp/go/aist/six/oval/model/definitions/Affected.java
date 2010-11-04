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

package jp.go.aist.six.oval.model.definitions;

import jp.go.aist.six.oval.model.common.Family;
import jp.go.aist.six.util.castor.AbstractPersistable;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;



/**
 * A description of the family, platform(s), and product(s)
 * to be evaluated for an OVAL Definition.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Affected
    extends AbstractPersistable
{

    private Collection<Platform>  _platform = new HashSet<Platform>();
    //{0..*}


    private Collection<Product>  _product = new HashSet<Product>();
    //{0..*}


    private Family  _family;
    //{required}



    /**
     * Constructor.
     */
    public Affected()
    {
    }


    /**
     * Constructor.
     */
    public Affected(
                    final Family family
                    )
    {
        setFamily( family );
    }


    /**
     * Constructor.
     */
    public Affected(
                    final Family family,
                    final Collection<? extends Platform> platform,
                    final Collection<? extends Product> product
                    )
    {
        setFamily( family );
        setPlatform( platform );
        setProduct( product );
    }


    /**
     * Constructor.
     */
    public Affected(
                    final Family family,
                    final Platform[] platform,
                    final Product[] product
                    )
    {
        setFamily( family );

        if (platform != null) {
            setPlatform( Arrays.asList( platform ) );
        }

        if (product != null) {
            setProduct( Arrays.asList( product ) );
        }
    }



    /**
     */
    public void setPlatform(
                    final Collection<? extends Platform> platforms
                    )
    {
        if (_platform != platforms) {
            _platform.clear();
            if (platforms != null  &&  platforms.size() > 0) {
                _platform.addAll( platforms );
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


    public Affected platform(
                    final Platform platform
                    )
    {
        addPlatform( platform );
        return this;
    }


    public Affected platform(
                    final String platform
                    )
    {
        addPlatform( new Platform( platform ) );
        return this;
    }


    public Collection<Platform> getPlatform()
    {
        return _platform;
    }


    public Iterator<Platform> iteratePlatform()
    {
        return _platform.iterator();
    }



    /**
     */
    public void setProduct(
                    final Collection<? extends Product> products
                    )
    {
        if (_product != products) {
            _product.clear();
            if (products != null  &&  products.size() > 0) {
                _product.addAll( products );
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


    public Affected product(
                    final Product product
                    )
    {
        addProduct( product );
        return this;
    }


    public Affected product(
                    final String product
                    )
    {
        addProduct( new Product( product ) );
        return this;
    }


    public Collection<Product> getProduct()
    {
        return _product;
    }


    public Iterator<Product> iterateProduct()
    {
        return _product.iterator();
    }



    /**
     */
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
                        ||  (this_product != null  &&  other_product != null
                                        &&  this_product.size() == other_product.size()
                                        &&  this_product.containsAll( other_product ))) {
            Collection<Platform>  other_platform = other.getPlatform();
            Collection<Platform>   this_platform =  this.getPlatform();
            if (this_platform == other_platform
                        ||  (this_platform != null  &&  other_platform != null
                                        &&  this_platform.size() == other_platform.size()
                                        &&  this_platform.containsAll( other_platform ))) {
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
        return "[family=" + getFamily()
                        + ", platform=" + getPlatform()
                        + ", product="  + getProduct()
                        + "]";
    }

}
// Affected
