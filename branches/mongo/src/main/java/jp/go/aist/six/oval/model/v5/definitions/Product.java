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

package jp.go.aist.six.oval.model.v5.definitions;

import jp.go.aist.six.oval.model.v5.NameEntity;



/**
 * A product name.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Product
    extends NameEntity
    implements Comparable<Product>
//extends NamedEntry<Integer>
{

//    @Property( "product" )
//    private String  name;



    /**
     * Constructor.
     */
    public Product()
    {
    }


    public Product(
                    final String name
                    )
    {
        super( name );
    }



    //**************************************************************
    //  Comparable
    //**************************************************************

    @Override
    public int compareTo(
                    final Product o
                    )
    {
        return String.CASE_INSENSITIVE_ORDER.compare( getName(), o.getName() );
    }



    // **************************************************************
    // java.lang.Object
    // **************************************************************

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof Product)) {
            return false;
        }

        return super.equals( obj );
    }

}
// Product
