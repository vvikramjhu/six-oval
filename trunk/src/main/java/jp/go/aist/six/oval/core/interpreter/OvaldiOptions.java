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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.go.aist.six.oval.interpreter.Option;
import jp.go.aist.six.oval.interpreter.Options;
import jp.go.aist.six.oval.interpreter.OvalInterpreterException;



/**
 * A collection of the ovaldi options.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvaldiOptions
    extends Options
{

//    /**
//     * Logger.
//     */
//    private static final Logger  _LOG_ = LoggerFactory.getLogger( OvaldiOptions.class );



    /**
     * A factory method.
     */
    public static Options fromCommandLine(
                    final List<String> strings
                    )
    throws OvalInterpreterException
    {
        Options  options = new OvaldiOptions();
        if (strings == null  ||  strings.size() == 0) {
            return options;
        }

        Map<String, Option>  map = new HashMap<String, Option>();
        for (Option  option : OvaldiOption.values()) {
            map.put( option.command, option );
        }

        int  num_strings = strings.size();
        for (int  i = 0; i < num_strings; i++) {
            String  string = strings.get( i );
            Option  option = map.get( string );

            if (option == null) {
                if (string.startsWith( "-" )) {
                    throw new OvalInterpreterException(
                                    "unknown command option: " + string );
                }

                // MD5Hash
                options.set( OvaldiOption.MD5_HASH, string );

            } else {
                if (option.hasArgument) {
                    if ((i + 1) < num_strings) {
                        String  arg_value = strings.get( i + 1 );
                        i++;
                        options.set( option, arg_value );
                    } else {
                        throw new OvalInterpreterException(
                                        "invalid command line: "
                                        + String.valueOf( strings )
                                        + ", error around: " + string );
                    }
                } else {
                    // no-argument option
                    options.set( option );
                }
            }
        }

        return options;
    }



    //**************************************************************
    //  Options
    //**************************************************************

    @Override
    public List<String> toCommandLine()
    throws OvalInterpreterException
    {
        List<String>  command_line = new ArrayList<String>();

        for (Option  option : OvaldiOption.values()) {
            if (contains( option )) {
                command_line.add( option.command );  //e.g. "-o"
                if (option.hasArgument) {
                    String  value = get( option );
                    if (value == null) {
                        throw new OvalInterpreterException(
                                        "no command argument: " + option );
                    }
                    command_line.add( value );       //e.g. "def.xml"
                }
            }
        }

//        _LOG_.debug( "command line: " + String.valueOf( command_line ) );
        return command_line;
    }

}
//OvaldiOptions

