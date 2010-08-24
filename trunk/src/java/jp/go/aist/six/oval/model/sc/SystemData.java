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

package jp.go.aist.six.oval.model.sc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class SystemData
//    extends Container<Item>
implements Iterable<Item>
{

    private Collection<Item>  _items = new ArrayList<Item>();



    /**
     * Constructor.
     */
    public SystemData()
    {
    }


    /**
     * Constructor.
     */
    public SystemData(
                    final Collection<? extends Item> items
                    )
    {
        setItem( items );
//        super( items );
    }


    /**
     * Constructor.
     */
    public SystemData(
                    final Item[] items
                    )
    {
        setItem( Arrays.asList( items ) );
//        super( items );
    }



    /**
     */
    public void setItem(
                    final Collection<? extends Item> items
                    )
    {
        if (items != _items) {
            _items.clear();
            if (items != null  &&  items.size() > 0) {
                _items.addAll( items );
            }
        }
    }
//    {
//        reset( items );
//    }


    public boolean addItem(
                    final Item item
                    )
    {
        return _items.add( item );
    }
//    {
//        return add( item );
//    }


    public Collection<Item> getItem()
    {
        return _items;
    }
//    {
////      return this;
//      return _elements();
//  }


    public Iterator<Item> iterateItem()
    {
        return _items.iterator();
    }
//    {
//        return iterator();
//    }


    public int size()
    {
        return _items.size();
    }



    //**************************************************************
    //  Iterable
    //**************************************************************

    public Iterator<Item> iterator()
    {
        return _items.iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "SystemData["
                        + getItem()
                        + "]";
    }

}
// SystemData
