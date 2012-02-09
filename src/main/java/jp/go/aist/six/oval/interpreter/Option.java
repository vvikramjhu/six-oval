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

package jp.go.aist.six.oval.interpreter;

import java.io.Serializable;




/**
 * The OVAL Definition Interpreter option.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class Option
    implements Serializable
{

    public final String   description;
    public final String   command;
    public final boolean  hasArgument;
    public final String   argumentName;
    public final String   defaultArgument;
    public final String   contentType;



    /**
     * Constructor.
     */
    public Option(
                    final String  description,
                    final String  command,
                    final boolean hasArgument,
                    final String  argumentName,
                    final String  defaultArgument,
                    final String  contentType
                    )
    {
        this.description        = description;
        this.command            = command;
        this.hasArgument        = hasArgument;
        this.argumentName       = argumentName;
        this.defaultArgument    = defaultArgument;
        this.contentType        = contentType;
    }




//    /**
//     */
//    public static Collection<Option> values()
//    {
//        return _VALUES_;
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "Option["
                + (command != null ? command : "")
                + (hasArgument ? (" " + argumentName) : "")
//                + " = " + description
//                + " (default: " + defaultArgument
                + (contentType != null ? ("(" + contentType + ")") : "")
                + "]";
    }

}
// Option

