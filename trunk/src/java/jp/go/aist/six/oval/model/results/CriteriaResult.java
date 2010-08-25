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

package jp.go.aist.six.oval.model.results;

import jp.go.aist.six.oval.model.common.Operator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;



/**
 * A high level container for all the tests.
 *
 * <p>Properties:</p>
 * <ul>
 *   <li>operator (optional -- default='AND')</li>
 *   <li>negate (optional -- default='false')</li>
 *   <li>comment (optional)</li>
 *   <li>criteria (0..*)</li>
 *   <li>criterion (0..*)</li>
 *   <li>extend_definition (0..*)</li>
 * </ul>
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class CriteriaResult
    extends CriteriaResultElement
{

    private Collection<CriteriaResultElement>  _elements = new ArrayList<CriteriaResultElement>();
    //{1..*}

    public static final Operator  DEFAULT_OPERATOR = Operator.AND;
    private Operator  _operator;
    //{optional, default="AND"}



    /**
     * Constructor.
     */
    public CriteriaResult()
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
        return (_operator == null ? DEFAULT_OPERATOR : _operator);
    }



    public void setElements(
                    final Collection<? extends CriteriaResultElement> elements
                    )
    {
        if (elements != _elements) {
            _elements.clear();
            if (elements == null  ||  elements.size() == 0) {
                return;
            }

            for (CriteriaResultElement  e : elements) {
                addElement( e );
            }
        }
    }


    public boolean addElement(
                    final CriteriaResultElement element
                    )
    {
        if (element == null) {
            return false;
        }

        return _elements.add( element );
    }


    public Collection<CriteriaResultElement> getElements()
    {
        return _elements;
    }


    public Iterator<CriteriaResultElement> iterateElements()
    {
        return _elements.iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "Criteria[negate=" + isNegate()
                        + ", operator=" + getOperator()
                        + ", " + getElements()
                        + "]";
    }

}
// CriteriaResult
