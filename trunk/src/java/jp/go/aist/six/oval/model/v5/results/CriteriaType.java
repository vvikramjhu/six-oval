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

package jp.go.aist.six.oval.model.v5.results;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.v5.common.OperatorEnumeration;



/**
 * The CriteriaResult describes the high level container
 * for all the tests and represents the meat of the definition.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class CriteriaType
    extends CriteriaResultElement
{

    private final Collection<CriteriaResultElement>  _elements = new ArrayList<CriteriaResultElement>();
    //{1..*}


    private OperatorEnumeration  _operator;
    //{required}



    /**
     * Constructor.
     */
    public CriteriaType()
    {
    }


    public CriteriaType(
                    final OperatorEnumeration operator,
                    final ResultEnumeration result
                    )
    {
        super( result );
        setOperator( operator );
    }



    /**
     */
    public void setOperator(
                    final OperatorEnumeration operator
                    )
    {
        _operator = operator;
    }


    public OperatorEnumeration getOperator()
    {
        return _operator;
    }



    public void setElements(
                    final Collection<? extends CriteriaResultElement> elements
                    )
    {
        if (elements != _elements) {
            _elements.clear();
            if (elements != null  &&  elements.size() > 0) {
                _elements.addAll( elements );
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


    public CriteriaType element(
                    final CriteriaResultElement element
                    )
    {
        addElement( element );
        return this;
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
        return "criteria[" + super.toString()
                        + ", operator=" + getOperator()
                        + ", " + getElements()
                        + "]";
    }

}
// CriteriaType
