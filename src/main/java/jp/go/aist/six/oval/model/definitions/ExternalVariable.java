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
import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.common.DatatypeEnumeration;



/**
 * The external variable extends the VariableType and
 * defines a variable with some external source.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class ExternalVariable
    extends VariableType
{

    private final Collection<PossibleValueType>  possible_value = new ArrayList<PossibleValueType>();
    //{0..*}

    private final Collection<PossibleRestrictionType>  possible_restriction = new ArrayList<PossibleRestrictionType>();
    //{1..*}



    /**
     * Constructor.
     */
    public ExternalVariable()
    {
        this( null, 0 );
    }


    public ExternalVariable(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public ExternalVariable(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        this( id, version, comment, null );
    }


    public ExternalVariable(
                    final String id,
                    final int version,
                    final String comment,
                    final DatatypeEnumeration datatype
                    )
    {
        super( id, version, comment, datatype );
        _oval_component_type = OvalComponentType.external;
    }



    /**
     */
    public void setPossibleValue(
                    final Collection<? extends PossibleValueType> possible_values
                    )
    {
        if (possible_values != this.possible_value) {
            this.possible_value.clear();
            if (possible_values != null  &&  possible_values.size() > 0) {
                for (PossibleValueType  value : possible_values) {
                    addPossibleValue( value );
                }
            }
        }
    }


    public boolean addPossibleValue(
                    final PossibleValueType possible_value
                    )
    {
        if (possible_value == null) {
            return false;
        }

        return this.possible_value.add( possible_value );
    }


    public Collection<PossibleValueType> getPossibleValue()
    {
        return this.possible_value;
    }


    public Iterator<PossibleValueType> iteratePossibleValue()
    {
        return this.possible_value.iterator();
    }



    /**
     */
    public void setPossibleRestriction(
                    final Collection<? extends PossibleRestrictionType> restrictions
                    )
    {
        if (restrictions != this.possible_restriction) {
            this.possible_restriction.clear();
            if (restrictions != null  &&  restrictions.size() > 0) {
                for (PossibleRestrictionType  restriction : restrictions) {
                    addPossibleRestriction( restriction );
                }
            }
        }
    }


    public boolean addPossibleRestriction(
                    final PossibleRestrictionType restriction
                    )
    {
        if (restriction == null) {
            return false;
        }

        return this.possible_restriction.add( restriction );
    }


    public Collection<PossibleRestrictionType> getPossibleRestriction()
    {
        return this.possible_restriction;
    }


    public Iterator<PossibleRestrictionType> iteratePossibleRestriction()
    {
        return this.possible_restriction.iterator();
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
        if (!(obj instanceof ExternalVariable)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "external_variable[" + super.toString()
             + ", possible_value=" + getPossibleValue()
             + ", possible_restriction=" + getPossibleRestriction()
             + "]";
    }

}
//ExternalVariable
