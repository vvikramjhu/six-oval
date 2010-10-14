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
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class ConcatFunction
    extends Function
{

    private Collection<Component>  _component = new ArrayList<Component>();
    //{2..*}



    /**
     * Constructor.
     */
    public ConcatFunction()
    {
    }


    /**
     * Constructor.
     */
    public ConcatFunction(
                    final Collection<? extends Component> components
                    )
    {
        setComponent( components );
    }


    /**
     * Constructor.
     */
    public ConcatFunction(
                    final Component[] components
                    )
    {
        setComponent( Arrays.asList( components ) );
    }



    /**
     */
    public void setComponent(
                    final Collection<? extends Component> components
                    )
    {
        if (components != _component) {
            _component.clear();
            if (components != null  &&  components.size() > 0) {
                _component.addAll( components );
            }
        }
    }


    public boolean addComponent(
                    final Component component
                    )
    {
        return _component.add( component );
    }


    public Collection<Component> getComponent()
    {
        return _component;
    }


    public Iterator<Component> iterateComponent()
    {
        return _component.iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "ConcatFunction[" + getComponent()
                        + "]";
    }

}
// ConcatFunction
