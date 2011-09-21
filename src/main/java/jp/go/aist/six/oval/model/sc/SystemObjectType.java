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

package jp.go.aist.six.oval.model.sc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.OvalElement;
import jp.go.aist.six.oval.model.common.MessageType;



/**
 * A reference between items collected and a related global OVAL Object.
 * The name "object" in the OVAL Schema is renamed
 * because the name has the special meaning in Java.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class SystemObjectType
    extends OvalElement
//    implements Dependent<OvalSystemCharacteristics>
{

    private final Collection<MessageType>  message = new ArrayList<MessageType>();
    //{0..*}
//    /*** We have never seen a result which has multiple messages. ***/
//    private String  _message;


    private final Collection<VariableValueType>  variable_value =
        new ArrayList<VariableValueType>();
    //{0..*}


    private final Collection<ReferenceType>  reference =
        new ArrayList<ReferenceType>();
    //{0..*}


    public static final Integer  DEFAULT_VARIABLE_INSTANCE = 1;

    private Integer  variable_instance;
    //{xsd:nonNegativeInteger, optional, default="1"}


    private String  comment;
    //{optional}


    private FlagEnumeration  flag;
    //{required}



    /**
     * Constructor.
     */
    public SystemObjectType()
    {
    }


    public SystemObjectType(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    public SystemObjectType(
                    final String id,
                    final int version,
                    final FlagEnumeration flag
                    )
    {
        super( id, version );
        setFlag( flag);
    }


    public SystemObjectType(
                    final String id,
                    final int version,
                    final FlagEnumeration flag,
                    final ReferenceType[] items
                    )
    {
        this( id, version, flag, Arrays.asList( items ) );
    }


    public SystemObjectType(
                    final String id,
                    final int version,
                    final FlagEnumeration flag,
                    final Collection<? extends ReferenceType> items
                    )
    {
        this( id, version, flag );
        setReference( items );
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
//                    final String message
//                    )
//    {
//        _message = message;
//    }
//
//
//    public String getMessage()
//    {
//        return _message;
//    }



    /**
     */
    public void setVariableValue(
                    final Collection<? extends VariableValueType> variable_value
                    )
    {
        if (variable_value != this.variable_value) {
            this.variable_value.clear();
            if (variable_value != null  &&  variable_value.size() > 0) {
                this.variable_value.addAll( variable_value );
            }
        }
    }


    public boolean addVariableValue(
                    final VariableValueType variable_value
                    )
    {
        if (variable_value == null) {
            return false;
        }

        return this.variable_value.add( variable_value );
    }


    public Collection<VariableValueType> getVariableValue()
    {
        return this.variable_value;
    }


    public SystemObjectType variableValue(
                    final VariableValueType variable_value
                    )
    {
        addVariableValue( variable_value );
        return this;
    }



    /**
     */
    public void setReference(
                    final Collection<? extends ReferenceType> reference
                    )
    {
        if (reference != this.reference) {
            this.reference.clear();
            if (reference != null  &&  reference.size() > 0) {
                this.reference.addAll( reference );
            }
        }
    }


    public boolean addReference(
                    final ReferenceType reference
                    )
    {
        if (reference == null) {
            return false;
        }

        return this.reference.add( reference );
    }


    public Collection<ReferenceType> getReference()
    {
        return this.reference;
    }


    public Iterator<ReferenceType> iterateReference()
    {
        return this.reference.iterator();
    }


    public SystemObjectType reference(
                    final ReferenceType reference
                    )
    {
        addReference( reference );
        return this;
    }


    public SystemObjectType reference(
                    final int item_ref
                    )
    {
        addReference( new ReferenceType( item_ref ) );
        return this;
    }



    /**
     */
    public void setVariableInstance(
                    final Integer variable_instance
                    )
    {
        this.variable_instance = variable_instance;
    }


    public Integer getVariableInstance()
    {
        return this.variable_instance;
    }



    /**
     */
    public void setComment(
                    final String comment
                    )
    {
        this.comment = comment;
    }


    public String getComment()
    {
        return this.comment;
    }


    public SystemObjectType comment(
                    final String comment
                    )
    {
        setComment( comment );
        return this;
    }



    /**
     */
    public void setFlag(
                    final FlagEnumeration flag
                    )
    {
        this.flag = flag;
    }


    public FlagEnumeration getFlag()
    {
        return this.flag;
    }



//    //**************************************************************
//    //  Dependent
//    //**************************************************************
//
//    private OvalSystemCharacteristics  _master;
//
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



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "object[" + super.toString()
                        + ", flag=" + getFlag()
                        + ", variable_values=" + getVariableValue()
                        + ", reference=" + getReference()
                        + ", variable_instance=" + getVariableInstance()
                        + ", message=" + getMessage()
                        + "]";
    }

}
// CollectedSystemObject
