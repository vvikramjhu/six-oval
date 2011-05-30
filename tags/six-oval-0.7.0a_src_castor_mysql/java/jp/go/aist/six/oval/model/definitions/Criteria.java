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

import jp.go.aist.six.oval.model.common.Operator;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



/**
 * The Criteria describes a container for a set of sub Criteria,
 * Criteria, Criterion, or ExtendDefinition elements
 * allowing complex logical trees to be constructed.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Criteria
    extends CriteriaElement
    implements Iterable<CriteriaElement>
{

    private Set<CriteriaElement>  _elements = new HashSet<CriteriaElement>();
    //{1..*}

    public static final Operator  DEFAULT_OPERATOR = Operator.AND;
    private Operator  _operator;
    //{optional, default="AND"}



    /**
     * Constructor.
     */
    public Criteria()
    {
    }


    /**
     * Constructor.
     */
    public Criteria(
                    final String comment
                    )
    {
        super( comment );
    }


    /**
     * Constructor.
     */
    public Criteria(
                    final Operator operator
                    )
    {
        setOperator( operator );
    }


    /**
     * Constructor.
     */
    public Criteria(
                    final Operator operator,
                    final String comment
                    )
    {
        this( operator );
        setComment( comment );
    }


    /**
     * Constructor.
     */
    public Criteria(
                    final Operator operator,
                    final Collection<? extends CriteriaElement> elements
                    )
    {
        this( operator );
        setElements( elements );
    }



    public Criteria comment(
                    final String comment
                    )
    {
        setComment( comment );
        return this;
    }



    /**
     */
    public void setOperator(
                    final Operator operator
                    )
    {
        _operator = operator;
    }


    public Operator getOperator()
    {
        return (_operator == null ? DEFAULT_OPERATOR : _operator);
    }



    /**
     */
    public void setElements(
                    final Collection<? extends CriteriaElement> elements
                    )
    {
        if (elements != _elements) {
            _elements.clear();
            if (elements == null  ||  elements.size() == 0) {
                return;
            }

            for (CriteriaElement  e : elements) {
                addElement( e );
            }
        }
    }


    public boolean addElement(
                    final CriteriaElement element
                    )
    {
        if (element == null) {
            return false;
        }

        return _elements.add( element );
    }


    public Set<CriteriaElement> getElements()
    {
        return _elements;
    }


    public Iterator<CriteriaElement> iterateElements()
    {
        return _elements.iterator();
    }


    public Criteria element(
                    final CriteriaElement element
                    )
    {
        addElement( element );
        return this;
    }


    public Criteria criteria(
                    final Operator operator
                    )
    {
        return element( new Criteria( operator ) );
    }


    public Criteria criterion(
                    final String testID,
                    final String comment
                    )
    {
        return element( new Criterion( testID, comment ) );
    }


    public Criteria extendDefinition(
                    final String definitionID,
                    final String comment
                    )
    {
        return element( new ExtendDefinition( definitionID, comment ) );
    }



    //**************************************************************
    //  Iterable
    //**************************************************************

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

        Operator  operator = getOperator();
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

        if (!(obj instanceof Criteria)) {
            return false;
        }

        if (super.equals( obj )) {
            Criteria  other = (Criteria)obj;
            Operator  other_operator = other.getOperator();
            Operator   this_operator =  this.getOperator();
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
        return "criteria[negate=" + isNegate()
                        + ", operator=" + getOperator()
                        + ", " + getElements()
                        + "]";
    }

}
// Criteria
