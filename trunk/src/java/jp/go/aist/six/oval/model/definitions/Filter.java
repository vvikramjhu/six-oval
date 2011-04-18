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

import jp.go.aist.six.oval.model.AbstractOvalObject;



/**
 * The Filter provides a reference to an existing OVAL State
 * and includes an optional action property.
 * The action property is used to specify whether items
 * that match the referenced OVAL State will be included in the resulting set
 * or excluded from the resulting set.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Filter
    extends AbstractOvalObject
{

    private String  _value;
    //{simpleContent}


    public static final FilterAction  DEFAULT_ACTION = FilterAction.EXCLUDE;
    private FilterAction  _action;
    //{optional, default='exclude'}



    /**
     * Constructor.
     */
    public Filter()
    {
    }


    /**
     * Constructor.
     */
    public Filter(
                    final String value
                    )
    {
        this( value, DEFAULT_ACTION );
    }


    /**
     * Constructor.
     */
    public Filter(
                    final String value,
                    final FilterAction action
                    )
    {
        setAction( action );
    }



    /**
     */
    public void setValue(
                    final String value
                    )
    {
        _value = value;
    }


    /**
     */
    public String getValue()
    {
        return _value;
    }



    /**
     */
    public void setAction(
                    final FilterAction action
                    )
    {
        _action = action;
    }


    public FilterAction getAction()
    {
        return (_action == null ? DEFAULT_ACTION : _action);
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        String  value = getValue();
        result = prime * result + ((value == null) ? 0 : value.hashCode());

        FilterAction  action = getAction();
        result = prime * result + ((action == null) ? 0 : action.hashCode());

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

        if (!(obj instanceof Filter)) {
            return false;
        }

        Filter  other = (Filter)obj;
        String  otherValue = other.getValue();
        String   thisValue =  this.getValue();
        if (thisValue == otherValue
                        ||  (thisValue != null  &&  thisValue.equals( otherValue ))) {
            if (this.getAction() == other.getAction()) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "filter[" + getValue()
                        + ", action=" + getAction()
                        + "]";
    }

}
// Filter
