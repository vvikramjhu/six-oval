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

import jp.go.aist.six.util.castor.AbstractPersistable;
import jp.go.aist.six.util.orm.Dependent;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class ItemReference
    extends AbstractPersistable
    implements Dependent<CollectedSystemObject>
{

    private int  _itemRef;
    //{required}



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
        setItemRef( itemID );
    }



    public void setItemRef(
                    final int id
                    )
    {
        _itemRef = id;
    }


    public int getItemRef()
    {
        return _itemRef;
    }



    //**************************************************************
    //  Dependent
    //**************************************************************

    private CollectedSystemObject  _master;



    public void setMasterObject(
                    final CollectedSystemObject master
                    )
    {
        _master = master;
    }


    public CollectedSystemObject getMasterObject()
    {
        return _master;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        result = prime * result + getItemRef();

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

        if (!(obj instanceof ItemReference)) {
            return false;
        }

        ItemReference  other = (ItemReference)obj;
        if (this.getItemRef() == other.getItemRef()) {
            return true;
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "ItemReference [item_ref=" + getItemRef()
                        + "]";
    }

}
// ItemReference
