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

