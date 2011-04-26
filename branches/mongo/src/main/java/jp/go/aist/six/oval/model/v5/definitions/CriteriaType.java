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

package jp.go.aist.six.oval.model.v5.definitions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.v5.common.OperatorEnumeration;



/**
 * The Criteria describes a container for a set of sub Criteria,
 * Criteria, Criterion, or ExtendDefinition elements
 * allowing complex logical trees to be constructed.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class CriteriaType
    extends CriteriaElement
    implements Iterable<CriteriaElement>
{

    private final Collection<CriteriaElement>  elements =
        new ArrayList<CriteriaElement>();
    //{1..*}

    public static final OperatorEnumeration  DEFAULT_OPERATOR = OperatorEnumeration.AND;
    private OperatorEnumeration  operator;
    //{optional, default="AND"}



    /**
     * Constructor.
     */
    public CriteriaType()
    {
    }


    /**
     * Constructor.
     */
    public CriteriaType(
                    final String comment
                    )
    {
        super( comment );
    }


    public CriteriaType(
                    final OperatorEnumeration operator
                    )
    {
        setOperator( operator );
    }


    public CriteriaType(
                    final OperatorEnumeration operator,
                    final String comment
                    )
    {
        this( operator );
        setComment( comment );
    }


    public CriteriaType(
                    final OperatorEnumeration operator,
                    final Collection<? extends CriteriaElement> elements
                    )
    {
        this( operator );
        setElements( elements );
    }



    public CriteriaType comment(
                    final String comment
                    )
    {
        setComment( comment );
        return this;
    }



    /**
     */
    public void setOperator(
                    final OperatorEnumeration operator
                    )
    {
        this.operator = operator;
    }


    public OperatorEnumeration getOperator()
    {
        return this.operator;
    }



    /**
     */
    public void setElements(
                    final Collection<? extends CriteriaElement> elementSequence
                    )
    {
        if (elementSequence != this.elements) {
            this.elements.clear();
            if (elementSequence != null  &&  elementSequence.size() > 0) {
                this.elements.addAll( elementSequence );
            }
        }
    }


    public Collection<CriteriaElement> getElements()
    {
        return this.elements;
    }


    public Iterator<CriteriaElement> iterateElements()
    {
        return this.elements.iterator();
    }


    public CriteriaType element(
                    final CriteriaElement element
                    )
    {
        this.elements.add( element );
        return this;
    }


    public CriteriaType criteria(
                    final OperatorEnumeration operator
                    )
    {
        return element( new CriteriaType( operator ) );
    }


    public CriteriaType criterion(
                    final String testID,
                    final String comment
                    )
    {
        return element( new CriterionType( testID, comment ) );
    }


    public CriteriaType extendDefinition(
                    final String definitionID,
                    final String comment
                    )
    {
        return element( new ExtendDefinitionType( definitionID, comment ) );
    }



    //**************************************************************
    //  Iterable
    //**************************************************************

    @Override
    public Iterator<CriteriaElement> iterator()
    {
        return iterateElements();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        Collection<CriteriaElement>  elements = getElements();
        result = prime * result + ((elements == null) ? 0 : elements.hashCode());

        OperatorEnumeration  operator = getOperator();
        result = prime * result + ((operator == null) ? 0 : operator.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CriteriaType)) {
            return false;
        }

        if (super.equals( obj )) {
            CriteriaType  other = (CriteriaType)obj;
            OperatorEnumeration  other_operator = other.getOperator();
            OperatorEnumeration   this_operator =  this.getOperator();
            if (this_operator == other_operator) {
                Collection<CriteriaElement>  other_elements = other.getElements();
                Collection<CriteriaElement>   this_elements =  this.getElements();
                if (this_elements == other_elements
                                ||  (this_elements != null
                                                &&  this_elements.equals( other_elements ))) {
                    return true;
                }
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "criteria[negate=" + getNegate()
                        + ", operator=" + getOperator()
                        + ", " + getElements()
                        + "]";
    }

}
// CriteriaType
