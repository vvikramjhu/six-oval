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
import jp.go.aist.six.util.orm.Dependent;
import jp.go.aist.six.util.orm.Persistable;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: Item.java 761 2010-05-10 07:22:50Z akihito $
 */
public abstract class Item
    implements Persistable, Dependent<OvalSystemCharacteristics>
{

//  private Message  _message;
    //{0..1}

    private int  _id;
    //{oval:ItemIDPattern, required}

    public static final ItemStatus  DEFAULT_STATUS = ItemStatus.EXISTS;
    private ItemStatus  _status;
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
                    final ItemStatus status
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
                    final ItemStatus status
                    )
    {
        _status = status;
    }


    public ItemStatus getStatus()
    {
        return (_status == null ? DEFAULT_STATUS : _status);
    }



    //**************************************************************
    //  Castor JDO support
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
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "id=" + getID()
                + ", status=" + getStatus();
    }

}
// Item
