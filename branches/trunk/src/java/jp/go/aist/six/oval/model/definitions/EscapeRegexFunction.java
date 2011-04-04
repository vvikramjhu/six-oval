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
 * The escape_regex function takes a single string component
 * and escapes all of the regular expression characters.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EscapeRegexFunction
    extends Function
{

    private Component  _component;
    //{1..1}



    /**
     * Constructor.
     */
    public EscapeRegexFunction()
    {
    }


    /**
     * Constructor.
     */
    public EscapeRegexFunction(
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



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "escape_regex[" + getComponent()
                        + "]";
    }

}
// EscapeRegexFunction
