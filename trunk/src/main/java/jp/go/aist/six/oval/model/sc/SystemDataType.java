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

package jp.go.aist.six.oval.model.sc;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import jp.go.aist.six.oval.model.Container;



/**
 * The SystemData is a container for one or more item elements.
 * Each item defines a specific piece of data on the system.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class SystemDataType
    extends Container<ItemType> //{1..*}
{

    private final Set<ItemType>  item = new HashSet<ItemType>();



    /**
     * Constructor.
     */
    public SystemDataType()
    {
    }


    public SystemDataType(
                    final Collection<? extends ItemType> item_list
                    )
    {
//        super( items );

//        item.addAll( item_list );
        _copy( item, item_list );
    }


    public SystemDataType(
                    final ItemType[] item_list
                    )
    {
//        super( items );

        this( Arrays.asList( item_list ) );
    }



    /**
     */
    public void setItem(
                    final Collection<? extends ItemType> item_list
                    )
    {
        reset( item_list );
//        _setElement( item_list );
    }


    public Collection<ItemType> getItem()
    {
        return _getCollection();
    }


//    public boolean addItem(
//                    final ItemType item
//                    )
//    {
//        return add( item );
//    }
//
//
//    public Iterator<ItemType> iterateItem()
//    {
//        return iterator();
//    }



    //**************************************************************
    //  Container
    //**************************************************************

    @Override
    protected Collection<ItemType> _getCollection()
    {
        return item;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

//    @Override
//    public String toString()
//    {
//        return "["
//                        + _getCollection()
//                        + "]";
//    }

}
//
