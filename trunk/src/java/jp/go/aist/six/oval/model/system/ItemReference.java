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

import jp.go.aist.six.util.orm.Persistable;




/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id: ItemReference.java 438 2010-03-23 05:05:24Z akihito $
 */
public class ItemReference
    implements Persistable
{

    private int  _itemID;



    /**
     * Constructor.
     */
    public ItemReference()
    {
    }


    /**
     * Constructor.
     */
    public ItemReference(
                    final int itemID
                    )
    {
        setItemID( itemID );
    }



    public void setItemID(
                    final int id
                    )
    {
        _itemID = id;
    }


    public int getItemID()
    {
        return _itemID;
    }



    //**************************************************************
    //  Castor JDO support
    //**************************************************************

    private SystemObjectStatus  _master;



    public void setMasterObject(
                    final SystemObjectStatus master
                    )
    {
        _master = master;
    }


    public SystemObjectStatus getMasterObject()
    {
        return _master;
    }



    //**************************************************************
    //  Persistable
    //**************************************************************

    /**
     * The persistent identifier.
     */
    private  String  _persistentID;


    public void setPersistentID(
                    final String id
                    )
    {
        _persistentID = id;
    }


    public String getPersistentID()
    {
        return _persistentID;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        result = prime * result + getItemID();

        return result;
    }



    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ItemReference)) {
            return false;
        }

        ItemReference  other = (ItemReference)obj;
        if (this.getItemID() == other.getItemID()) {
            return true;
        }

        return false;
    }



    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "ItemReference [item_ref=" + getItemID()
                        + "]";
    }

}
// ItemReference
