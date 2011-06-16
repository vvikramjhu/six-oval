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

package jp.go.aist.six.oval.model.v5.sc;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import jp.go.aist.six.oval.model.v5.Container;



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
                    final Collection<? extends ItemType> items
                    )
    {
        super( items );
    }


    public SystemDataType(
                    final ItemType[] items
                    )
    {
        super( items );
    }



    /**
     */
    public void setItem(
                    final Collection<? extends ItemType> items
                    )
    {
        _setElement( items );
    }


    public boolean addItem(
                    final ItemType item
                    )
    {
        return _addElement( item );
    }


    public Collection<ItemType> getItem()
    {
        return _getElement();
    }


    public Iterator<ItemType> iterateItem()
    {
        return _iterateElement();
    }



    //**************************************************************
    //  Container
    //**************************************************************

    @Override
    protected Collection<ItemType> _getElement()
    {
        return this.item;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "["
                        + _getElement()
                        + "]";
    }

}
// SystemDataType
