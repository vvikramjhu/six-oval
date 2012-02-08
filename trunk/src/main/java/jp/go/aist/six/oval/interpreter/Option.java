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
 * The OVAL Interpreter command line options.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class Option
    implements Serializable
{

//    //==============================================================
//    // input resources
//    //==============================================================
//
//    public static final Option OVAL_DEFINITIONS = new Option(
//                    "-o", true, "filename", "definitions.xml",
//                    "application/xml",
//                    "path to the oval definitions XML file"
//    );
//
//    public static final Option EVALUATE_DEFINITIONS = new Option(
//                    "-e", true, "definition IDs", null,
//                    "text/plain",
//                    "evaluate the specified list of definitions \n" +
//                    "(supply definition IDs as a comma seperated list)"
//    );
//
//    public static final Option OVAL_XML_DIR = new Option(
//                    "-a", true, "dir name", null,
//                    null,
//                    "path to the directory that contains the OVAL schema and other xml resources"
//    );
//
//    public static final Option MD5_HASH = new Option(
//                    null, true, "MD5Hash", null,
//                    null,
//                    "MD5 checksum expected for the current OVAL Definitions document"
//    );
//
//
//    //==============================================================
//    // input resources
//    //==============================================================
//
//    public static final Option OVAL_RESULTS = new Option(
//                    "-r", true, "filename", "results.xml",
//                    "application/xml",
//                    "save oval-results to the specified XML file"
//    );
//
//
//    //==============================================================
//    // control
//    //==============================================================
//
//    public static final Option NO_VERIFY = new Option(
//                    "-m", false, null, null,
//                    null,
//                    "do not verify the oval-definitions file with an MD5 hash"
//    );
//
//    public static final Option LOG_LEVEL = new Option(
//                    "-l", true, "integer", "2",
//                    null,
//                    "log messages at the specified level \n"
//                    + "(DEBUG = 1, INFO = 2, MESSAGE = 3, FATAL = 4)"
//    );
//
//
//
//    private static final Option[]  _DEFINED_VALUES_ = new Option[] {
//        OVAL_DEFINITIONS,
//        EVALUATE_DEFINITIONS,
//        OVAL_RESULTS,
//        NO_VERIFY,
//        OVAL_XML_DIR,
//        MD5_HASH,
//        LOG_LEVEL
//    };
//
//
//    private static final Collection<Option>  _VALUES_ = Arrays.asList( _DEFINED_VALUES_ );
////        new ArrayList<Option>();



    public final String   description;
    public final String   command;
    public final boolean  hasArgument;
    public final String   argumentName;
    public final String   defaultArgument;
    public final String   contentType;



    /**
     * Constructor.
     */
    protected Option(
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

