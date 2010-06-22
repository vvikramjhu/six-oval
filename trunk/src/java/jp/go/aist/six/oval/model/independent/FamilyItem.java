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

package jp.go.aist.six.oval.model.independent;

import jp.go.aist.six.oval.core.model.system.ItemType;
import jp.go.aist.six.oval.model.common.Family;
import jp.go.aist.six.oval.model.system.Item;
import jp.go.aist.six.oval.model.system.Status;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class FamilyItem
    extends Item
{

    private Family  _family;



    /**
     * Constructor.
     */
    public FamilyItem()
    {
    }


    /**
     * Constructor.
     */
    public FamilyItem(
                    final int id
                    )
    {
        super( id );
    }


    /**
     * Constructor.
     */
    public FamilyItem(
                    final int id,
                    final Status status
                    )
    {
        super( id, status );
    }


    /**
     * Constructor.
     */
    public FamilyItem(
                    final int id,
                    final Status status,
                    final Family family
                    )
    {
        this( id, status );
        setFamily( family );
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
    //  Item
    //**************************************************************

    @Override
    public ItemType getItemType()
    {
        return ItemType.INDEPENDENT_FAMILY;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "FamilyItem[" + super.toString()
                        + ", family=" + getFamily()
                        + "]";
    }

}
// FamilyItem
