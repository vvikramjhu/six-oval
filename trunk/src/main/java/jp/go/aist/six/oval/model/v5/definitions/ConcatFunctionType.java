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



/**
 * The concat function takes two or more components
 * and concatenates them together to form a single string.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class ConcatFunctionType
    extends FunctionGroup
{

    private final Collection<ComponentGroup>  component =
        new ArrayList<ComponentGroup>();
    //{2..*}



    /**
     * Constructor.
     */
    public ConcatFunctionType()
    {
    }



    /**
     */
    public void setComponent(
                    final Collection<? extends ComponentGroup> component
                    )
    {
        if (component != this.component) {
            this.component.clear();
            if (component != null  &&  component.size() > 0) {
                this.component.addAll( component );
            }
        }
    }


    public boolean addComponent(
                    final ComponentGroup component
                    )
    {
        return this.component.add( component );
    }


    public Collection<ComponentGroup> getComponent()
    {
        return this.component;
    }


    public Iterator<ComponentGroup> iterateComponent()
    {
        return this.component.iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "concat[" + getComponent()
             + "]";
    }

}
// ConcatFunctionType
