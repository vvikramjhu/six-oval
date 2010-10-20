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

import jp.go.aist.six.oval.model.OvalElement;
import jp.go.aist.six.util.orm.Dependent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;



/**
 * A reference between items collected and a related global OVAL Object.
 *
 * <p>Properties:</p>
 * <ul>
 *   <li>id (required)</li>
 *   <li>version (required)</li>
 *   <li>variableInstance (optional -- default='1')</li>
 *   <li>comment (optional)</li>
 *   <li>flag (required)</li>
 *   <li>message (0..1): the original caridinality is (0..*).</li>
 *   <li>variableValue (0..*)</li>
 *   <li>reference (0..*)</li>
 * </ul>
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class CollectedSystemObject
    extends OvalElement
//    extends OvalAnalysisElement
    implements Dependent<OvalSystemCharacteristics>
{

//  private Collection<Message>  _messages = new ArrayList<Message>();
    //{0..*}
    /*** We have never seen a result which has multiple messages. ***/
    private String  _message;


    private Collection<VariableValue>  _variableValue = new ArrayList<VariableValue>();
    //{0..*}


    private Collection<ItemReference>  _reference = new ArrayList<ItemReference>();
    //{0..*}


    public static final int  DEFAULT_VARIABLE_INSTANCE = 1;
    private int  _variableInstance = DEFAULT_VARIABLE_INSTANCE;
    //{xsd:nonNegativeInteger, optional, default="1"}


    private String  _comment;


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
        if (values != _variableValue) {
            _variableValue.clear();
            if (values != null  &&  values.size() > 0) {
                for (VariableValue  v : values) {
                    addVariableValue( v );
                }
//                _variableValue.addAll( values );
            }
        }
    }


    public boolean addVariableValue(
                    final VariableValue value
                    )
    {
        if (value == null) {
            return false;
        }

        return _variableValue.add( value );
    }


    public CollectedSystemObject variableValue(
                    final VariableValue value
                    )
    {
        addVariableValue( value );
        return this;
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


    public CollectedSystemObject reference(
                    final ItemReference reference
                    )
    {
        addReference( reference );
        return this;
    }


    public CollectedSystemObject reference(
                    final int itemID
                    )
    {
        addReference( new ItemReference( itemID ) );
        return this;
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



    /**
     */
    public void setComment(
                    final String comment
                    )
    {
        _comment = comment;
    }


    public CollectedSystemObject comment(
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
