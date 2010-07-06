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
import jp.go.aist.six.util.orm.Dependent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class CollectedSystemObject
    extends OvalAnalysisElement
    implements Dependent<OvalSystemCharacteristics>
{

    private String  _message;
    //{0..*}
//  private Collection<Message>  _messages = new ArrayList<Message>();
    /*** We have never seen a result which has multiple messages. ***/

    // NOT implemented yet
//  private Collection<VariableValue>  _variableValues = new ArrayList<VariableValue>();
//    //{0..*}

    private Collection<ItemReference>  _reference = new ArrayList<ItemReference>();
    //{0..*}

    public static final int  DEFAULT_VARIABLE_INSTANCE = 1;
    private int  _variableInstance = DEFAULT_VARIABLE_INSTANCE;
    //{xsd:nonNegativeInteger, optional, default="1"}

    private Flag  _flag;
    //{required}



    /**
     * Constructor.
     */
    public CollectedSystemObject()
    {
    }


    /**
     * Constructor.
     */
    public CollectedSystemObject(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public CollectedSystemObject(
                    final String id,
                    final int version,
                    final Flag flag
                    )
    {
        super( id, version );
        setFlag( flag);
    }


    /**
     * Constructor.
     */
    public CollectedSystemObject(
                    final String id,
                    final int version,
                    final Flag flag,
                    final ItemReference[] items
                    )
    {
        this( id, version, flag, Arrays.asList( items ) );
    }


    /**
     * Constructor.
     */
    public CollectedSystemObject(
                    final String id,
                    final int version,
                    final Flag flag,
                    final Collection<? extends ItemReference> items
                    )
    {
        this( id, version, flag );
        setReference( items );
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



    public void setReference(
                    final Collection<? extends ItemReference> refList
                    )
    {
        if (refList != _reference) {
            _reference.clear();
            if (refList == null  ||  refList.size() == 0) {
                return;
            }

            for (ItemReference  ref : refList) {
                addReference( ref );
            }
        }
    }


    public boolean addReference(
                    final ItemReference ref
                    )
    {
        if (ref == null) {
            return false;
        }

//        ref.setObject( this );
        return _reference.add( ref );
    }


    public Collection<ItemReference> getReference()
    {
        return _reference;
    }



    /**
     */
    public void setVariableInstance(
                    final int variableInstance
                    )
    {
        _variableInstance = variableInstance;
    }


    /**
     */
    public int getVariableInstance()
    {
        return _variableInstance;
    }



    public void setFlag(
                    final Flag flag
                    )
    {
        _flag = flag;
    }


    public Flag getFlag()
    {
        return _flag;
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
                setMasterPersistentID( master.getPersistentID() );
            }
        }

        return _masterPersistentID;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "CollectedSystemObject[" + super.toString()
                        + ", flag=" + getFlag()
                        + ", items=" + getReference()
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
// CollectedSystemObject
