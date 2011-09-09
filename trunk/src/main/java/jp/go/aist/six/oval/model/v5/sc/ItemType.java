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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.v5.Oval5Object;
import jp.go.aist.six.oval.model.v5.PlatformEntityType;
import jp.go.aist.six.oval.model.v5.common.MessageType;



/**
 * The abstract Item holds information about a specific item on a system.
 * An item might be a file, a rpm, a process, etc.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
// NOTE: This class must be abstract and dependent.
// Castor fails to load polymorphic objects
// if the common abstract super class is mapped to a super table.
//public abstract class Item
public class ItemType
    implements Oval5Object
//    implements Dependent<OvalSystemCharacteristics>
{

    private final Collection<MessageType>  message =
        new ArrayList<MessageType>();
    //{0..50}
//
//    private MessageType  _message;
//    // TODO: We have never seen any item which has multiple messages.


    private int  id;
    //{oval:ItemIDPattern, required}


    /**
     * The default status: "exists".
     */
    public static final StatusEnumeration  DEFAULT_STATUS =
        StatusEnumeration.EXISTS;

    private StatusEnumeration  status;
    //{optional, default="exists"}


    // SIX extension
    protected OvalPlatformType   _oval_platform_type;
    protected OvalComponentType  _oval_component_type;



    /**
     * Constructor.
     */
    public ItemType()
    {
    }


    public ItemType(
                    final int id
                    )
    {
        this( id, null );
    }


    public ItemType(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        setID( id );
        setStatus( status );
    }



    /**
     */
    public void setEntityType(
                    final PlatformEntityType type
                    )
    {
    }


//    public abstract EntityType getEntityType();
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.UNKNOWN;
    }



    /**
     */
    public void setMessage(
                    final Collection<? extends MessageType> messageList
                    )
    {
        if (this.message != messageList) {
            this.message.clear();
            if (messageList != null  &&  messageList.size() > 0) {
                this.message.addAll( messageList );
            }
        }
    }


    public Collection<MessageType> getMessage()
    {
        return this.message;
    }


    public Iterator<MessageType> iterateMessage()
    {
        return this.message.iterator();
    }

//    /**
//     */
//    public void setMessage(
//                    final MessageType message
//                    )
//    {
//        _message = message;
//    }
//
//
//    public MessageType getMessage()
//    {
//        return _message;
//    }



    /**
     */
    public void setID(
                    final int id
                    )
    {
        this.id = id;
    }


    public int getID()
    {
        return this.id;
    }



    /**
     */
    public void setStatus(
                    final StatusEnumeration status
                    )
    {
        this.status = status;
    }


    public StatusEnumeration getStatus()
    {
        return this.status;
    }



//    //**************************************************************
//    //  Dependent
//    //**************************************************************
//
//    private OvalSystemCharacteristics  _master;
//
//
//    @Override
//    public void setMasterObject(
//                    final OvalSystemCharacteristics master
//                    )
//    {
//        _master = master;
//    }
//
//
//    @Override
//    public OvalSystemCharacteristics getMasterObject()
//    {
//        return _master;
//    }



//    private String  _masterPersistentID;
//
//
//    public void setMasterPersistentID(
//                    final String id
//                    )
//    {
//        _masterPersistentID = id;
//    }
//
//
//    public String getMasterPersistentID()
//    {
//        if (_masterPersistentID == null) {
//            OvalSystemCharacteristics  master = getMasterObject();
//            if (master != null) {
//                _masterPersistentID = master.getPersistentID();
//            }
//        }
//
//        return _masterPersistentID;
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

//    @Override
//    public int hashCode()
//    {
//        final int  prime = 37;
//        int  result = 17;
//
//        int  id = getID();
//        result = prime * result + id;
//
//        return result;
//    }
//
//
//
//    @Override
//    public boolean equals(
//                    final Object obj
//                    )
//    {
//        if (this == obj) {
//            return true;
//        }
//
//        if (!(obj instanceof Item)) {
//            return false;
//        }
//
//        Item  other = (Item)obj;
//        int  other_id = other.getID();
//        int   this_id =  this.getID();
//        if (this_id == other_id) {
//            return true;
//        }
//
//        return false;
//    }



    @Override
    public String toString()
    {
        return "id=" + getID()
                + ", status=" + getStatus();
    }

}
// ItemType