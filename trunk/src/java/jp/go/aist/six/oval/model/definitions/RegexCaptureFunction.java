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
 * The regex_capture function captures a single substring from a string component.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RegexCaptureFunction
    extends Function
{

    private Component  _component;
    //{1..1}


    private String  _pattern;
    //{option}



    /**
     * Constructor.
     */
    public RegexCaptureFunction()
    {
    }


    /**
     * Constructor.
     */
    public RegexCaptureFunction(
                    final Component component
                    )
    {
        setComponent( component );
    }



    /**
     */
    public void setComponent(
                    final Component component
                    )
    {
        _component = component;
    }


    public Component getComponent()
    {
        return _component;
    }



    /**
     */
    public void setPattern(
                    final String pattern
                    )
    {
        _pattern = pattern;
    }


    public String getPattern()
    {
        return _pattern;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "regex_capture[pattern=" + getPattern()
                        + ", " + getComponent()
                        + "]";
    }

}
// RegexCaptureFunction
