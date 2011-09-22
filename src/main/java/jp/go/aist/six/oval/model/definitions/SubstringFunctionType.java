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



/**
 * The substring function takes a single string component and
 * produces a single value that contains a portion of the original string.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class SubstringFunctionType
    extends FunctionGroup
{

    private ComponentGroup  component;
    //{1..1}


    private int  substring_start;
    //{required}


    private int  substring_length;
    //{required}



    /**
     * Constructor.
     */
    public SubstringFunctionType()
    {
    }



    /**
     */
    public void setComponent(
                    final ComponentGroup component
                    )
    {
        this.component = component;
    }


    public ComponentGroup getComponent()
    {
        return this.component;
    }



    /**
     */
    public void setSubstringStart(
                    final int substring_start
                    )
    {
        this.substring_start = substring_start;
    }


    public int getSubstringStart()
    {
        return this.substring_start;
    }



    /**
     */
    public void setSubstringLength(
                    final int substring_length
                    )
    {
        this.substring_length = substring_length;
    }


    public int getSubstringLength()
    {
        return this.substring_length;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "substring[" + getComponent()
             + ", substring_start=" + getSubstringStart()
             + ", substring_length=" + getSubstringLength()
             + "]";
    }

}
// SubstringFunctionType
