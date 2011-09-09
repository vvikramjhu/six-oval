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
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * An OVAL Interpreter wrapper.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class Options
    implements Serializable
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( Options.class );



    private final EnumMap<Option, String>  _options =
        new EnumMap<Option, String>( Option.class );



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
    public List<String> toCommand()
    throws OvalInterpreterException
    {
        List<String>  command = new ArrayList<String>();

        for (Option  option : Option.values()) {
            if (contains( option )) {
                command.add( option.command );  //e.g. "-o"
                if (option.hasArgument) {
                    String  value = get( option );
                    if (value == null) {
                        throw new OvalInterpreterException( "no command argument: " + option.command );
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
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "Options" + String.valueOf( _options );
    }

}
// Options

