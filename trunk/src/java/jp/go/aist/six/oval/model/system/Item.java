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

import jp.go.aist.six.oval.core.model.system.ItemType;
import jp.go.aist.six.util.orm.AbstractPersistable;
import jp.go.aist.six.util.orm.Dependent;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class Item
    extends AbstractPersistable
    implements Dependent<OvalSystemCharacteristics>
{

//  private Message  _message;
    //{0..1}

    private int  _id;
    //{oval:ItemIDPattern, required}

    /**
     * The default status: "exists".
     */
    public static final Status  DEFAULT_STATUS = Status.EXISTS;
    private Status  _status;
    //{optional, default="exists"}



    /**
     * Constructor.
     */
    public Item()
    {
    }


    /**
     * Constructor.
     */
    public Item(
                    final int id
                    )
    {
        this( id, DEFAULT_STATUS );
    }


    /**
     * Constructor.
     */
    public Item(
                    final int id,
                    final Status status
                    )
    {
        setID( id );
        setStatus( status );
    }



    public void setItemType(
                    final ItemType type
                    )
    {
    }


    public abstract ItemType getItemType();



    public void setID(
                    final int id
                    )
    {
        _id = id;
    }


    public int getID()
    {
        return _id;
    }



    public void setStatus(
                    final Status status
                    )
    {
        _status = status;
    }


    public Status getStatus()
    {
        return (_status == null ? DEFAULT_STATUS : _status);
    }



    //**************************************************************
    //  Dependent
    //**************************************************************

    private OvalSystemCharacteristics  _master;


    public void setMasterObject(
                    final OvalSystemCharacteristics master
                    )
    {
        _master = master;
    }


    public OvalSystemCharacteristics getMasterObject()
    {
        return _master;
    }



    private String  _masterPersistentID;


    public void setMasterPersistentID(
                    final String id
                    )
    {
        _masterPersistentID = id;
    }


    public String getMasterPersistentID()
    {
        if (_masterPersistentID == null) {
            OvalSystemCharacteristics  master = getMasterObject();
            if (master != null) {
                _masterPersistentID = master.getPersistentID();
            }
        }

        return _masterPersistentID;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        int  id = getID();
        result = prime * result + id;

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

        if (!(obj instanceof Item)) {
            return false;
        }

        Item  other = (Item)obj;
        int  other_id = other.getID();
        int   this_id =  this.getID();
        if (this_id == other_id) {
            return true;
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "id=" + getID()
                + ", status=" + getStatus();
    }

}
// Item
