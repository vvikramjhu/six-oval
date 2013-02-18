/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.go.aist.six.oval.model.definitions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;



/**
 * The time difference function calculates the difference
 * in seconds between date-time values.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class TimeDifferenceFunctionType
    extends FunctionGroup
{

    private final Collection<ComponentGroup>  component =
        new ArrayList<ComponentGroup>( 2 );
    //{1..2}


    private DateTimeFormatEnumeration  format_1;
    //{optional, default="year_month_day"}

    private DateTimeFormatEnumeration  format_2;
    //{optional, default="year_month_day"}




    /**
     * Constructor.
     */
    public TimeDifferenceFunctionType()
    {
    }



    /**
     */
    public void setComponent(
                    final Collection<? extends ComponentGroup> components
                    )
    {
        if (components != component) {
            component.clear();
            if (components != null  &&  components.size() > 0) {
                for (ComponentGroup  component : components) {
                    addComponent( component );
                }
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
        return component;
    }


    public Iterator<ComponentGroup> iterateComponent()
    {
        return component.iterator();
    }



    /**
     */
    public void setFormat1(
                    final DateTimeFormatEnumeration format_1
                    )
    {
        this.format_1 = format_1;
    }


    public DateTimeFormatEnumeration getFormat1()
    {
        return format_1;
    }



    /**
     */
    public void setFormat2(
                    final DateTimeFormatEnumeration format_2
                    )
    {
        this.format_2 = format_2;
    }


    public DateTimeFormatEnumeration getFormat2()
    {
        return format_2;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "time_difference[" + getComponent()
                        + ", format_1=" + getFormat1()
                        + ", format_2=" + getFormat2()
                        + "]";
    }

}
//TimeDifferenceFunctionType
