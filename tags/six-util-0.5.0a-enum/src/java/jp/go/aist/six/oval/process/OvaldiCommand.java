/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
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

package jp.go.aist.six.oval.process;

import jp.go.aist.six.util.Command;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




/**
 * An ovaldi command wrapper.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvaldiCommand.java 490 2010-03-29 06:32:03Z akihito $
 */
public class OvaldiCommand
    extends Command
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( OvaldiCommand.class );

    // Definition Evaluation Options:
    public static final String  OPT_INPUT_DEFINITIONS = "-o";

    // Input Validation Options:
    public static final String  OPT_RESOURCE_DIR = "-a";
    public static final String  OPT_SKIP_INPUT_VERIFICATION = "-m";

    //Data Collection Options:
    public static final String  OPT_INPUT_SYSTEM_CHARACTERISTICS = "-i";

    // Result Output Options:
    public static final String  OPT_OUTPUT_SYSTEM_CHARACTERISTICS = "-d";
    public static final String  OPT_OUTPUT_RESULTS = "-r";
    public static final String  OPT_SKIP_OUTPUT_XSL = "-s";
    public static final String  OPT_OUTPUT_RESULTS_HTML = "-x";


    private static final String[]  _VALID_OPTIONS_ARRAY_
    = new String[] {
        OPT_INPUT_DEFINITIONS,

        OPT_RESOURCE_DIR,
        OPT_SKIP_INPUT_VERIFICATION,

        OPT_INPUT_SYSTEM_CHARACTERISTICS,

        OPT_OUTPUT_SYSTEM_CHARACTERISTICS,
        OPT_OUTPUT_RESULTS,
        OPT_SKIP_OUTPUT_XSL,
        OPT_OUTPUT_RESULTS_HTML
    };


    /**
     * The valid options.
     */
    public static final List<String>  VALID_OPTIONS =
        Collections.unmodifiableList( Arrays.asList( _VALID_OPTIONS_ARRAY_ ) );


    private static Map<String,String> _createDefaultOptions()
    {
        Map<String,String>   options = new HashMap<String,String>();
        options.put( OPT_INPUT_DEFINITIONS,              "definitions.xml" );
        options.put( OPT_OUTPUT_SYSTEM_CHARACTERISTICS,  "system-characteristics.xml" );
        options.put( OPT_OUTPUT_RESULTS,                 "results.xml" );

        return options;
    }


    private static final Map<String,String>  _DEFAULT_OPTIONS_ =
        _createDefaultOptions();



    // status attributes:
    public static final String  ATTR_OVALDI_LOG = "ovaldi.log";
    public static final String  ATTR_OVALDI_EXIT_VALUE = "ovaldi.exit_value";




    private String  _md5;



    /**
     * Constructor.
     */
    public OvaldiCommand()
    {
        // The minimum command array: ovaldi -m
    }



    /**
     * Constructor.
     */
    public OvaldiCommand(
                    final String executable,
                    final Map<String,String> options,
                    final String md5
                    )
    {
        super( executable, options );
        setMd5Checksum( md5 );
    }



    /**
     * Constructor.
     */
    public OvaldiCommand(
                    final String[] cmdarray
                    )
    {
        _configure( cmdarray );
    }



    /**
     */
    private void _configure(
                    final String[] cmdarray
                    )
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "cmdarray: " + Arrays.toString( cmdarray ));
        }

        if (cmdarray == null  ||  cmdarray.length == 0) {
            throw new IllegalArgumentException(
                            "no executable and options specified" );
        }

        setExecutable( cmdarray[0] );

        try {
            final int  size = cmdarray.length;
            // cmdarray[0] is ovaldi executable
            for (int  i = 1; i < size; i++) {
                if (cmdarray[i].equals( OPT_INPUT_DEFINITIONS )) {
                    setOption( OPT_INPUT_DEFINITIONS, cmdarray[ ++i ] );
                } else if (cmdarray[i].equals( OPT_RESOURCE_DIR )) {
                    setOption( OPT_RESOURCE_DIR, cmdarray[ ++i ] );
                } else if (cmdarray[i].equals( OPT_SKIP_INPUT_VERIFICATION )) {
                    setOption( OPT_SKIP_INPUT_VERIFICATION );
                } else if (cmdarray[i].equals( OPT_INPUT_SYSTEM_CHARACTERISTICS )) {
                    setOption( OPT_INPUT_SYSTEM_CHARACTERISTICS, cmdarray[ ++i ] );
                } else if (cmdarray[i].equals( OPT_OUTPUT_SYSTEM_CHARACTERISTICS )) {
                    setOption( OPT_OUTPUT_SYSTEM_CHARACTERISTICS, cmdarray[ ++i ] );
                } else if (cmdarray[i].equals( OPT_OUTPUT_RESULTS )) {
                    setOption( OPT_OUTPUT_RESULTS, cmdarray[ ++i ] );
                } else if (cmdarray[i].equals( OPT_SKIP_OUTPUT_XSL )) {
                    setOption( OPT_SKIP_OUTPUT_XSL );
                } else if (cmdarray[i].equals( OPT_OUTPUT_RESULTS_HTML )) {
                    setOption( OPT_OUTPUT_RESULTS_HTML, cmdarray[ ++i ] );
                } else if (i == (size - 1)) {
                    if (!isSkipInputDefinitionsVerification()) {
                        setMd5Checksum( cmdarray[ cmdarray.length - 1 ] );
                    }
                }
            }
        } catch (IndexOutOfBoundsException ex) {
            throw new IllegalArgumentException(
                            "invalid command argument specified" );
        }

        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "ovaldi configured: " + this );
        }
    }



    public void setMd5Checksum(
                    final String md5
                    )
    {
        _md5 = md5;
    }


    /**
     */
    public String getMd5Checksum()
    {
        return _md5;
    }



    @Override
    public String getOption(
                    final String name
                    )
    {
        String  value = super.getOption( name );
        if (value == null) {
            value = _DEFAULT_OPTIONS_.get( name );
        }

        return value;
    }


    /**
     */
    public String getInputDefinitions()
    {
        return getOption( OPT_INPUT_DEFINITIONS );
    }


    public void setInputDefinitions(
                    final String location
                    )
    {
        setOption( OPT_INPUT_DEFINITIONS, location );
    }


    /**
     */
    public boolean isSkipInputDefinitionsVerification()
    {
        return isOptionSet( OPT_SKIP_INPUT_VERIFICATION );
    }


    public void setSkipInputDefinitionsVerification(
                    final boolean skip
                    )
    {
        if (skip) {
            setOption( OPT_SKIP_INPUT_VERIFICATION );
        } else {
            removeOption( OPT_SKIP_INPUT_VERIFICATION );
        }
    }



    /**
     */
    public String getInputSystemCharacteristics()
    {
        return getOption( OPT_INPUT_SYSTEM_CHARACTERISTICS );
    }


    public void setInputSystemCharacteristics(
                    final String location )
    {
        setOption( OPT_INPUT_SYSTEM_CHARACTERISTICS, location );
    }



    /**
     */
    public String getOutputSystemCharacteristics()
    {
        return getOption( OPT_OUTPUT_SYSTEM_CHARACTERISTICS );
    }


    public void setOutputSystemCharacteristics(
                    final String location )
    {
        setOption( OPT_OUTPUT_SYSTEM_CHARACTERISTICS, location );
    }



    /**
     */
    public String getOutputResults()
    {
        return getOption( OPT_OUTPUT_RESULTS );
    }


    public void setOutputResults(
                    final String location
                    )
    {
        setOption( OPT_OUTPUT_RESULTS, location );
    }



    /**
     */
    public String getOutputResultsHtml()
    {
        return getOption( OPT_OUTPUT_RESULTS_HTML );
    }


    public void setOutputResultsHtml(
                    final String location
                    )
    {
        setOption( OPT_OUTPUT_RESULTS_HTML, location );
    }



    /**
     */
    public boolean isSkipOutputXsl()
    {
        return isOptionSet( OPT_SKIP_OUTPUT_XSL );
    }


    public void setSkipOutputXsl(
                    final boolean skip
                    )
    {
        if (skip) {
            setOption( OPT_SKIP_OUTPUT_XSL );
        } else {
            removeOption( OPT_SKIP_OUTPUT_XSL );
        }
    }



    /**
     */
    public String getResourceDir()
    {
        return getOption( OPT_RESOURCE_DIR );
    }


    public void setResourceDir(
                    final String location
                    )
    {
        setOption( OPT_RESOURCE_DIR, location );
    }



    //**************************************************************
    //  Command
    //**************************************************************

    @Override
    public List<String> createCommandList()
    {
        List<String>  list = super.createCommandList( VALID_OPTIONS );
        if (!isSkipInputDefinitionsVerification()) {
            String  md5 = getMd5Checksum();
            if (md5 == null) {
                throw new IllegalStateException( "no md5 checksum specfieid" );
            } else {
                list.add( md5 );
            }
        }

        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "ovaldi command list: " + list );
        }

        return list;
    }



    //==============================================================
    //  java.lang.Object
    //==============================================================

    @Override
    public String toString()
    {
        StringBuilder  s = new StringBuilder( "Ovaldi[" );
        s.append( super.toString() );
        s.append( ", md5=" ).append( getMd5Checksum() );
        s.append( "]" );

        return s.toString();
    }

}
// OvaldiCommand

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

