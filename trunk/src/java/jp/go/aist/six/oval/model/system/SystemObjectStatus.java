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

import jp.go.aist.six.oval.model.OvalAnalysisElement;
import java.util.ArrayList;
import java.util.Collection;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class SystemObjectStatus
    extends OvalAnalysisElement
{

    private ObjectFlag  _flag;

    private String  _message;
//    private Collection<Message>  _messages = new ArrayList<Message>();
    /*** Every result has at most one message. ***/

    private Collection<ItemReference>  _items = new ArrayList<ItemReference>();
//    private Collection<VariableValue>  _variableValues = new ArrayList<VariableValue>();



    /**
     * Constructor.
     */
    public SystemObjectStatus()
    {
    }


    /**
     * Constructor.
     */
    public SystemObjectStatus(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public SystemObjectStatus(
                    final String id,
                    final int version,
                    final ObjectFlag flag
                    )
    {
        super( id, version );
        setFlag( flag);
    }


    /**
     * Constructor.
     */
    public SystemObjectStatus(
                    final String id,
                    final int version,
                    final ObjectFlag flag,
                    final Collection<ItemReference> items
                    )
    {
        this( id, version, flag );
        setItems( items );
    }



    public void setFlag(
                    final ObjectFlag flag
                    )
    {
        _flag = flag;
    }


    public ObjectFlag getFlag()
    {
        return _flag;
    }



    public void setMessage(
                    final String message
                    )
    {
        _message = message;
    }


    public String getMessage()
    {
        return _message;
    }



    public void setItems(
                    final Collection<ItemReference> refs
                    )
    {
        if (refs != _items) {
            _items.clear();
            if (refs == null  ||  refs.size() == 0) {
                return;
            }

            for (ItemReference  ref : refs) {
                addItem( ref );
            }
        }
    }


    public boolean addItem(
                    final ItemReference ref
                    )
    {
        if (ref == null) {
            return false;
        }

//        ref.setObject( this );
        return _items.add( ref );
    }


    public Collection<ItemReference> getItems()
    {
        return _items;
    }




//    /**
//     * @param variableInstance the variableInstance to set
//     */
//    public void setVariableInstance( final int variableInstance )
//    {
//        this._variableInstance = variableInstance;
//    }
//
//
//    /**
//     * @return the variableInstance
//     */
//    public int getVariableInstance()
//    {
//        return _variableInstance;
//    }



//    public void setMessages( final Collection<Message> messages )
//    {
//        _messages.clear();
//        Iterator<Message>  i = messages.iterator();
//        while (i.hasNext()) {
//            addMessage( i.next() );
//        }
//    }
//
//
//    public boolean addMessage( final Message message )
//    {
//        if (message == null) {
//            return false;
//        }
//
//        if (!_messages.contains( message )) {
//            return _messages.add( message );
//        }
//
//        return false;
//    }
//
//
//    public Collection<Message> getMessages()
//    {
//        return _messages;
//    }



//    public void setVariableValues( final Collection<VariableValue> values )
//    {
//        _variableValues.clear();
//        Iterator<VariableValue>  i = values.iterator();
//        while (i.hasNext()) {
//            addVariableValue( i.next() );
//        }
//    }
//
//
//    public boolean addVariableValue( final VariableValue value )
//    {
//        if (value == null) {
//            return false;
//        }
//
//        if (!_variableValues.contains( value )) {
//            return _variableValues.add( value );
//        }
//
//        return false;
//    }
//
//
//    public Collection<VariableValue> getVariableValues()
//    {
//        return _variableValues;
//    }



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
                setMasterPersistentID( master.getPersistentID() );
            }
        }

        return _masterPersistentID;
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
        return "SystemObjectStatus [" + super.toString()
                        + ", flag=" + getFlag()
                        + ", items=" + getItems()
//                        + ", variable_instance=" + getVariableInstance()
//                        + ", messages=" + getMessages()
//                        + ", variable_values=" + getVariableValues()
                        + "]";
    }


//    public void setMessages( final Collection<Message> messages )
//    public boolean addMessage( final Message message )
//    public Collection<Message> getMessages()


//    public void setVariableInstance( final int variableInstance )
//    public int getVariableInstance()


//    public void setVariableValues( final Collection<VariableValue> values )
//    public boolean addVariableValue( final VariableValue value )
//    public Collection<VariableValue> getVariableValues()

}
// SystemObjectStatus
