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
 * The split function takes a single string component and
 * turns it into multiple values based on a delimiter string.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class SplitFunctionType
    extends FunctionGroup
{

    private ComponentGroup  component;
    //{1..1}


    private String  delimiter;
    //{required}



    /**
     * Constructor.
     */
    public SplitFunctionType()
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
    public void setDelimiter(
                    final String delimiter
                    )
    {
        this.delimiter = delimiter;
    }


    public String getDelimiter()
    {
        return this.delimiter;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "split[" + getComponent()
             + ", delimiter=" + getDelimiter()
             + "]";
    }

}
// SplitFunctionType
