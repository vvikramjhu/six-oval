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

package jp.go.aist.six.oval.model.system;

import jp.go.aist.six.oval.model.KeyedContainer;
import java.util.Collection;
import java.util.Iterator;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class SystemData
    extends KeyedContainer<Integer, Item> //{1..*}
{

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
        super( items );
    }


    /**
     * Constructor.
     */
    public SystemData(
                    final Item[] items
                    )
    {
        super( items );
    }



    /**
     */
    public void setItem(
                    final Collection<? extends Item> items
                    )
    {
        reset( items );
    }


    public boolean addItem(
                    final Item item
                    )
    {
        return add( item );
    }


    public Collection<Item> getItem()
    {
        return _values();
    }


    public Iterator<Item> iterateItem()

    {
        return iterator();
    }



    //**************************************************************
    //  Container
    //**************************************************************

    protected Integer _getKey(
                    final Item element
                    )
    {
        return Integer.valueOf( element.getID() );

    }

}
// SystemData
