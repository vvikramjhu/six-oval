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



/**
 * The arithmetic function takes two or more integer or float components
 * and performs a basic mathematical function on them.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class ArithmeticFunctionType
    extends FunctionGroup
{

    private final Collection<ComponentGroup>  component =
        new ArrayList<ComponentGroup>();
    //{2..*}


    private ArithmeticEnumeration  arithmetic_operation;
    //{required}



    /**
     * Constructor.
     */
    public ArithmeticFunctionType()
    {
    }



    /**
     */
    public void setComponent(
                    final Collection<? extends ComponentGroup> components
                    )
    {
        if (components != this.component) {
            this.component.clear();
            if (components != null  &&  components.size() > 0) {
                for (ComponentGroup  component : components) {
                    addComponent( component );
                }
//                this.component.addAll( components );
            }
        }
    }


    public boolean addComponent(
                    final ComponentGroup component
                    )
    {
        if (component == null) {
            return false;
        }

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



    /**
     *
     */
    public void setArithmeticOperation(
                    final ArithmeticEnumeration arithmetic_operation
                    )
    {
        this.arithmetic_operation = arithmetic_operation;
    }


    public ArithmeticEnumeration getArithmeticOperation()
    {
        return this.arithmetic_operation;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "arithmetic[" + getComponent()
                        + ", arithmetic_operation=" + getArithmeticOperation()
             + "]";
    }

}
// ArithmeticFunctionType
