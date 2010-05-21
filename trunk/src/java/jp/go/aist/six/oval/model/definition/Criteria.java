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

package jp.go.aist.six.oval.model.definition;

import jp.go.aist.six.oval.model.common.Operator;
import java.util.ArrayList;
import java.util.Collection;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id: Criteria.java 634 2010-04-20 09:14:26Z akihito $
 */
public class Criteria
    extends CriteriaElement
{

    public static final Operator  DEFAULT_OPERATOR = Operator.AND;



    private Collection<CriteriaElement>  _elements = new ArrayList<CriteriaElement>();
    //{1..*}

    private Operator  _operator = DEFAULT_OPERATOR;
    //{optional, default="AND"}



    /**
     * Constructor.
     */
    public Criteria()
    {
    }



    public void setOperator(
                    final Operator operator
                    )
    {
        _operator = operator;
    }


    public Operator getOperator()
    {
        return _operator;
    }



    public void setElements(
                    final Collection<CriteriaElement> elements
                    )
    {
        _elements.clear();
        if (elements == null  ||  elements.size() == 0) {
            return;
        }

        for (CriteriaElement  e : elements) {
            addElement( e );
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


    public Collection<CriteriaElement> getElements()
    {
        return _elements;
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
        return "Criteria[negate=" + isNegate()
                        + ", operator=" + getOperator()
                        + ", " + getElements()
                        + "]";
    }

}
// Criteria
