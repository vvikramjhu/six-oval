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




/**
 * The OVAL Interpreter command line options.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public enum Option
{
    OVAL_DEFINITIONS(
                    "-o", true, "filename", "definitions.xml",
                    "path to the oval-definitions XML file"
    ),

    EVALUATE_DEFINITIONS(
                    "-e", true, "definition IDs", null,
                    "evaluate the specified list of definitions \n" +
                    "(supply definition IDs as a comma seperated list)"
    ),

    OVAL_RESULTS(
                    "-r", true, "filename", "results.xml",
                    "save oval-results to the specified XML file"
    ),

    NO_VERIFY(
                    "-m", false, null, null,
                    "do not verify the oval-definitions file with an MD5 hash"
    ),

    OVAL_XML_DIR(
                    "-a", true, "dir name", null,
                    "path to the directory that contains the OVAL schema and other xml resources"
    ),

    MD5_HASH(
                    null, true, "MD5Hash", null,
                    "MD5 checksum expected for the current OVAL Definitions document"
    ),

    LOG_LEVEL(
                    "-l", true, "integer", "2",
                    "log messages at the specified level \n"
                    + "(DEBUG = 1, INFO = 2, MESSAGE = 3, FATAL = 4)"
    )
    ;



    public final String  command;
    public final boolean  hasArgument;
    public final String  argumentName;
    public final String  defaultArgument;
    public final String  description;



    /**
     * Constructor.
     */
    Option(
                    final String name,
                    final boolean hasArgument,
                    final String argumentName,
                    final String defaultArgument,
                    final String description
                    )
    {
        this.command = name;
        this.hasArgument = hasArgument;
        this.argumentName = argumentName;
        this.defaultArgument = defaultArgument;
        this.description = description;
    }

}
// Option

