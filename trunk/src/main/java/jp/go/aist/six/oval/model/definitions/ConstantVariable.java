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

package jp.go.aist.six.oval.model.definitions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.common.DatatypeEnumeration;



/**
 * The ConstantVariable extends the VariableType and
 * defines a variable with a constant value(s).
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class ConstantVariable
    extends VariableType
{

    private final Collection<ValueType>  value = new ArrayList<ValueType>();



    /**
     * Constructor.
     */
    public ConstantVariable()
    {
        this( null, 0 );
    }


    public ConstantVariable(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public ConstantVariable(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        this( id, version, comment, null );
    }


    public ConstantVariable(
                    final String id,
                    final int version,
                    final String comment,
                    final DatatypeEnumeration datatype
                    )
    {
        super( id, version, comment, datatype );

//        _oval_component_type = OvalComponentType.constant;
    }



    /**
     */
    public void setValue(
                    final Collection<? extends ValueType> values
                    )
    {
        value.clear();
        if (values != null  &&  values.size() > 0) {
            for (ValueType  value : values) {
                addValue( value );
            }
        }
    }


    public boolean addValue(
                    final ValueType value
                    )
    {
        if (value == null) {
            throw new IllegalArgumentException( "empty value" );
        }

        return this.value.add( value );
    }


    public Collection<ValueType> getValue()
    {
        return value;
    }


    public Iterator<ValueType> iterateValue()
    {
        return value.iterator();
    }



    //**************************************************************
    //  SIX extension
    //**************************************************************

    @Override
    public VariableType.Type ovalGetVariableType()
    {
        return VariableType.Type.CONSTANT;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof ConstantVariable)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "constant_variable[" + super.toString()
             + ", value=" + getValue()
             + "]";
    }

}
// ConstantVariable
