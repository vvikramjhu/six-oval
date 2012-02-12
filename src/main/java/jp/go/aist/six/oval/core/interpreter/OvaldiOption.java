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

package jp.go.aist.six.oval.core.interpreter;

import java.util.Arrays;
import java.util.Collection;
import jp.go.aist.six.oval.interpreter.Option;




/**
 * The definition of the ovaldi command options.
 *
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvaldiOption
    extends Option
{

    //==============================================================
    // input resources
    //==============================================================

    public static final OvaldiOption OVAL_DEFINITIONS = new OvaldiOption(
                    "path to the oval definitions XML file",
                    "-o", true, "filename", "definitions.xml",
                    "application/xml"
    );

    public static final OvaldiOption EVALUATE_DEFINITIONS = new OvaldiOption(
                    "evaluate the specified list of definitions \n" +
                    "(supply definition IDs as a comma seperated list)",
                    "-e", true, "definition IDs", null,
                    "text/plain"
    );

    public static final OvaldiOption OVAL_XML_DIR = new OvaldiOption(
                    "path to the directory that contains the OVAL schema and other xml resources",
                    "-a", true, "dir name", null,
                    null
    );

    public static final OvaldiOption MD5_HASH = new OvaldiOption(
                    "MD5 checksum expected for the current OVAL Definitions document",
                    null, true, "MD5Hash", null,
                    null
    );


    //==============================================================
    // output resources
    //==============================================================

    public static final OvaldiOption OVAL_SC = new OvaldiOption(
                    "save system-characteristics data to the specified XML file",
                    "-d", true, "filename", "system-characteristics.xml",
                    "application/xml"
    );


    public static final OvaldiOption OVAL_RESULTS = new OvaldiOption(
                    "save oval-results to the specified XML file",
                    "-r", true, "filename", "results.xml",
                    "application/xml"
    );


    public static final OvaldiOption OVAL_TRANSFORMED_RESULTS = new OvaldiOption(
                    "output xsl transform results to the specified file",
                    "-x", true, "filename", "results.html",
                    "text/html"
    );


    //==============================================================
    // control
    //==============================================================

    public static final OvaldiOption NO_VERIFY = new OvaldiOption(
                    "do not verify the oval-definitions file with an MD5 hash",
                    "-m", false, null, null,
                    null
    );


    public static final OvaldiOption PRINT_ALL_INFO = new OvaldiOption(
                    "print all information and error messages",
                    "-p", false, null, null,
                    null
    );


    public static final OvaldiOption LOG_LEVEL = new OvaldiOption(
                    "log messages at the specified level \n"
                    + "(DEBUG = 1, INFO = 2, MESSAGE = 3, FATAL = 4)",
                    "-l", true, "integer", "2",
                    null
    );




    private static final Option[]  _DEFINED_VALUES_ = new OvaldiOption[] {
        OVAL_DEFINITIONS,
        EVALUATE_DEFINITIONS,
        OVAL_SC,
        OVAL_RESULTS,
        OVAL_TRANSFORMED_RESULTS,
        NO_VERIFY,
        OVAL_XML_DIR,
        MD5_HASH,
        PRINT_ALL_INFO,
        LOG_LEVEL
    };


    private static final Collection<Option>  _VALUES_ = Arrays.asList( _DEFINED_VALUES_ );
//        new ArrayList<Option>();




    /**
     * Constructor.
     */
    protected OvaldiOption(
                    final String  description,
                    final String  command,
                    final boolean hasArgument,
                    final String  argumentName,
                    final String  defaultArgument,
                    final String  contentType
                    )
    {
        super( description, command, hasArgument, argumentName, defaultArgument, contentType );
    }




    /**
     */
    public static Collection<Option> values()
    {
        return _VALUES_;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

}
//OvaldiOption

