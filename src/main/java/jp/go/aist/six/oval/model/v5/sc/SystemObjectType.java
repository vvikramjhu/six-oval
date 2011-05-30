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
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.v5.OvalElement;
import jp.go.aist.six.util.persist.Dependent;



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
    implements Dependent<OvalSystemCharacteristics>
{

//  private Collection<Message>  _messages = new ArrayList<Message>();
    //{0..*}
    /*** We have never seen a result which has multiple messages. ***/
    private String  _message;


    private final Collection<VariableValueType>  _variableValue = new ArrayList<VariableValueType>();
    //{0..*}


    private final Collection<ReferenceType>  _reference = new ArrayList<ReferenceType>();
    //{0..*}


    public static final Integer  DEFAULT_VARIABLE_INSTANCE = 1;
    private Integer  _variableInstance;
    //{xsd:nonNegativeInteger, optional, default="1"}


    private String  _comment;
    //{optional}


    private FlagEnumeration  _flag;
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
                    final Collection<? extends VariableValueType> values
                    )
    {
        if (values != _variableValue) {
            _variableValue.clear();
            if (values != null  &&  values.size() > 0) {
                _variableValue.addAll( values );
            }
        }
    }


    public boolean addVariableValue(
                    final VariableValueType value
                    )
    {
        if (value == null) {
            return false;
        }

        return _variableValue.add( value );
    }


    public SystemObjectType variableValue(
                    final VariableValueType value
                    )
    {
        addVariableValue( value );
        return this;
    }


    public Collection<VariableValueType> getVariableValue()
    {
        return _variableValue;
    }



    public void setReference(
                    final Collection<? extends ReferenceType> references
                    )
    {
        if (references != _reference) {
            _reference.clear();
            if (references != null  &&  references.size() > 0) {
                _reference.addAll( references );
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

        return _reference.add( reference );
    }


    public SystemObjectType reference(
                    final ReferenceType reference
                    )
    {
        addReference( reference );
        return this;
    }


    public SystemObjectType reference(
                    final int itemID
                    )
    {
        addReference( new ReferenceType( itemID ) );
        return this;
    }


    public Collection<ReferenceType> getReference()
    {
        return _reference;
    }


    public Iterator<ReferenceType> iterateReference()
    {
        return _reference.iterator();
    }



    /**
     */
    public void setVariableInstance(
                    final Integer variableInstance
                    )
    {
        _variableInstance = variableInstance;
    }


    public Integer getVariableInstance()
    {
        return _variableInstance;
    }



    /**
     */
    public void setComment(
                    final String comment
                    )
    {
        _comment = comment;
    }


    public SystemObjectType comment(
                    final String comment
                    )
    {
        setComment( comment );
        return this;
    }


    public String getComment()
    {
        return _comment;
    }



    /**
     */
    public void setFlag(
                    final FlagEnumeration flag
                    )
    {
        _flag = flag;
    }


    public FlagEnumeration getFlag()
    {
        return _flag;
    }



    //**************************************************************
    //  Dependent
    //**************************************************************

    private OvalSystemCharacteristics  _master;



    @Override
    public void setMasterObject(
                    final OvalSystemCharacteristics master
                    )
    {
        _master = master;
    }


    @Override
    public OvalSystemCharacteristics getMasterObject()
    {
        return _master;
    }



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
//                        + ", variable_instance=" + getVariableInstance()
                        + ", message=" + getMessage()
                        + "]";
    }

}
// CollectedSystemObject
