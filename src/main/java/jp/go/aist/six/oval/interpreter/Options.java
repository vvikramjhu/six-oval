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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * A collection of OVAL Interpreter options.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class Options
    implements Cloneable, Serializable
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( Options.class );



    /**
     * A factory method.
     */
    public static Options fromCommandLine(
                    final List<String> strings
                    )
    throws OvalInterpreterException
    {
        Options  options = new Options();
        if (strings == null  ||  strings.size() == 0) {
            return options;
        }

        Map<String, Option>  map = new HashMap<String, Option>();
        for (Option  option : Option.values()) {
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
                options.set( Option.MD5_HASH, string );

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



    /**
     * NOTE: This "field" is NOT "final"
     * because it has to be created whenever this object is cloned.
     * Since this "class" is NOT "final", and {@link #clone()} method
     * must return the same class as this object,
     * the copy constructor {@link #Options(Map)} can't be used.
     *
     * @see #clone()
     */
    private Map<Option, String>  _options = new HashMap<Option, String>();



    /**
     * Constructor.
     */
    public Options()
    {
    }


    public Options(
                    final Map<Option, String> options
                    )
    {
        set( options );
    }



    /**
     */
    public List<String> toCommandLine()
    throws OvalInterpreterException
    {
        List<String>  command = new ArrayList<String>();

        for (Option  option : Option.values()) {
            if (contains( option )) {
                command.add( option.command );  //e.g. "-o"
                if (option.hasArgument) {
                    String  value = get( option );
                    if (value == null) {
                        throw new OvalInterpreterException(
                                        "no command argument: " + option.command );
                    }
                    command.add( value );       //e.g. "def.xml"
                }
            }
        }

        _LOG_.debug( "command: " + String.valueOf( command ) );
        return command;
    }



    /**
     */
    public Options set(
                    final Map<Option, String> options
                    )
    {
        if (options == null) {
            throw new IllegalArgumentException( "no option specified" );
        }

        for (Option  option : options.keySet()) {
            set( option, options.get( option ) );
        }

        return this;
    }


    public Options set(
                    final Option option
                    )
    {
        set( option, null );
        return this;
    }


    public Options set(
                    final Option option,
                    final String value
                    )
    {
        if (option == null) {
            throw new IllegalArgumentException( "no option specified" );
        }

        if (option.hasArgument) {
            if (value == null  ||  value.length() == 0) {
                throw new IllegalArgumentException(
                                "no option argument specified: " + option.command );
            }
        }

        _options.put( option, value );
        return this;
    }


    public Options remove(
                    final Option option
                    )
    {
        if (option == null) {
            throw new IllegalArgumentException( "no option specified" );
        }

        _options.remove( option );
        return this;
    }


    public Options clear()
    {
        _options.clear();
        return this;
    }


    public String get(
                    final Option option
                    )
    {
        if (option == null) {
            throw new IllegalArgumentException( "no option specified" );
        }

        return _options.get( option );
    }


    public boolean contains(
                    final Option option
                    )
    {
        if (option == null) {
            throw new IllegalArgumentException( "no option specified" );
        }

        return _options.containsKey( option );
    }



//    //==============================================================
//    //  individual options
//    //==============================================================
//
//    /**
//     * -o
//     */
//    public void setOvalDefinitions(
//                    final String filepath
//                    )
//    {
//        set( Option.OVAL_DEFINITIONS, filepath );
//    }
//
//
//    public String getOvalDefinitions()
//    {
//        return get( Option.OVAL_DEFINITIONS );
//    }
//
//
//
//    /**
//     * -e
//     */
//    public void setEvaluateDefinitions(
//                    final List<String> defIDs
//                    )
//    {
//        if (defIDs == null  ||  defIDs.size() == 0) {
//            remove( Option.EVALUATE_DEFINITIONS );
//        } else {
//            StringBuilder  s = new StringBuilder();
//            for (String  defID : defIDs) {
//                if (s.length() > 0) {
//                    s.append( "," );
//                }
//                s.append( defID );
//            }
//
//            setEvaluateDefinitions( s.toString() );
//        }
//    }
//
//
//    public void setEvaluateDefinitions(
//                    final String defIDs
//                    )
//    {
//        if (defIDs == null  ||  defIDs.length() == 0) {
//            remove( Option.EVALUATE_DEFINITIONS );
//        } else {
//            set( Option.EVALUATE_DEFINITIONS, defIDs );
//        }
//    }
//
//
//    public String getEvaluateDefinitions()
//    {
//        return get( Option.EVALUATE_DEFINITIONS );
//    }
//
//
//
//    /**
//     * -r
//     */
//    public void setOvalResults(
//                    final String filepath
//                    )
//    {
//        set( Option.OVAL_RESULTS, filepath );
//    }
//
//
//    public String getOvalResults()
//    {
//        return get( Option.OVAL_RESULTS );
//    }
//
//
//
//    /**
//     * -a
//     */
//    public void setOvalXmlDir(
//                    final String dirpath
//                    )
//    {
//        set( Option.OVAL_XML_DIR, dirpath );
//    }
//
//
//    public String getOvalXmlDir()
//    {
//        return get( Option.OVAL_XML_DIR );
//    }
//
//
//
//    /**
//     * -m
//     */
//    public void setNoVerify(
//                    final boolean noVerify
//                    )
//    {
//        if (noVerify) {
//            set( Option.NO_VERIFY );
//        } else {
//            remove( Option.NO_VERIFY );
//        }
//    }
//
//
//    public boolean isNoVerify()
//    {
//        return contains( Option.NO_VERIFY );
//    }
//
//
//
//    /**
//     * MD5Hash
//     */
//    public void setMD5Hash(
//                    final String hash
//                    )
//    {
//        set( Option.MD5_HASH, hash );
//    }
//
//
//    public String getMD5Hash()
//    {
//        return get( Option.MD5_HASH );
//    }



    //**************************************************************
    //  java.lang.Cloneable
    //**************************************************************

    @Override
    public Options clone()
    throws CloneNotSupportedException
    {
        Options  clone = null;
        try {
            clone = (Options)super.clone();
            clone._options = new HashMap<Option, String>( _options );
            //Copy all the mapping to a new Map object.
        } catch (CloneNotSupportedException ex) {
            throw new AssertionError();
        }

        return clone;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "Options" + String.valueOf( _options );
    }

}
// Options

