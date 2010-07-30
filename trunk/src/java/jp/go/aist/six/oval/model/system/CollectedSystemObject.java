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
import java.util.Iterator;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class CollectedSystemObject
    extends OvalAnalysisElement
    implements Dependent<OvalSystemCharacteristics>
{

//  private Collection<Message>  _messages = new ArrayList<Message>();
    /*** We have never seen a result which has multiple messages. ***/
    private String  _message;
    //{0..*}


    private Collection<VariableValue>  _variableValue = new ArrayList<VariableValue>();
    //{0..*}


    private Collection<ItemReference>  _reference = new ArrayList<ItemReference>();
    //{0..*}


    public static final int  DEFAULT_VARIABLE_INSTANCE = 1;
    private int  _variableInstance = DEFAULT_VARIABLE_INSTANCE;
    //{xsd:nonNegativeInteger, optional, default="1"}


    //TODO: implement this?
//    private String  _comment;


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



    /**
     */
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



    public void setVariableValue(
                    final Collection<? extends VariableValue> values
                    )
    {
        _variableValue.clear();
        if (values != null) {
            _variableValue.addAll( values );
        }
    }


    public Collection<VariableValue> getVariableValue()
    {
        return _variableValue;
    }



    public void setReference(
                    final Collection<? extends ItemReference> references
                    )
    {
        if (references != _reference) {
            _reference.clear();
            if (references == null  ||  references.size() == 0) {
                return;
            }

            for (ItemReference  reference : references) {
                addReference( reference );
            }
        }
    }


    public boolean addReference(
                    final ItemReference reference
                    )
    {
        if (reference == null) {
            return false;
        }

        return _reference.add( reference );
    }


    public Collection<ItemReference> getReference()
    {
        return _reference;
    }


    public Iterator<ItemReference> iterateReference()
    {
        return _reference.iterator();
    }



    /**
     */
    public void setVariableInstance(
                    final int variableInstance
                    )
    {
        _variableInstance = variableInstance;
    }


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
                        + ", reference=" + getReference()
//                        + ", variable_instance=" + getVariableInstance()
//                        + ", messages=" + getMessages()
                        + ", variable_values=" + getVariableValue()
                        + "]";
    }

}
// CollectedSystemObject
