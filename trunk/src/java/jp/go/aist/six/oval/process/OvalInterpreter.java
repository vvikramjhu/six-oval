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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.go.aist.six.oval.core.service.OvalContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalInterpreter
{
    //TODO:
    //
    // Options:
    // -o filename  = path to the oval-definitions xml file.
    //                DEFAULT="definitions.xml"
    // -r filename  = save oval-results to the specified XML file.
    //                DEFAULT="oval-results.xml"
    // -a dir name  = path to the directory that contains the OVAL schema and other xml resources.
    //                On Windows platforms, DEFAULT="xml".
    //                On *nix platforms, DEFAULT="/usr/share/ovaldi".



    private static enum Property
    {
        EXECUTABLE(       "six.oval.interpreter.executable", "ovaldi",          null ),
        WORKING_DIR(      "six.oval.interpreter.dir",        null,              null ),
        OVAL_DEFINITIONS( null,                              "definitions.xml", "-o" ),
        OVAL_RESULTS(     null,                              "results.xml",     "-r" )
        ;


        final String  property;
        final String  defaultValue;
        final String  commandOption;


        /**
         * Constructor.
         */
        Property(
                        final String property,
                        final String defaultValue,
                        final String commandOption
                        )
        {
            this.property= property;
            this.defaultValue = defaultValue;
            this.commandOption = commandOption;
        }


        boolean hasProperty()
        {
            return (property == null ? false : true);
        }
    }



    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( OvalInterpreter.class );



    // Definition Evaluation Options:
    public static final String  OPT_INPUT_DEFINITIONS = "-o";
    public static final String  OPT_INPUT_DEFINITIONS_URL = "-ourl";


//
//    // Input Validation Options:
//    public static final String  OPT_RESOURCE_DIR = "-a";
//    public static final String  OPT_SKIP_INPUT_VERIFICATION = "-m";
//
//    //Data Collection Options:
//    public static final String  OPT_INPUT_SYSTEM_CHARACTERISTICS = "-i";
//
//    // Result Output Options:
//    public static final String  OPT_OUTPUT_SYSTEM_CHARACTERISTICS = "-d";
//    public static final String  OPT_OUTPUT_RESULTS = "-r";
//    public static final String  OPT_SKIP_OUTPUT_XSL = "-s";
//    public static final String  OPT_OUTPUT_RESULTS_HTML = "-x";



    private ProcessBuilder  _builder;


    // properties
    private String  _tmpDir;
    private String  _ovalScFilepath;
    private String  _ovalDefsUrl;
    private String  _ovalResultsUrl;


//    private String  _executable;
//    private String  _ovalDefinitions;
//    private String  _ovalResults;
//    private String  _workingDir;



    /**
     * Constructor.
     */
    protected OvalInterpreter()
    {
    }




    /**
     */
    private List<String> _createCommand()
    {
        List<String>  command = new ArrayList<String>();

        command.add( getExecutable() );
        command.add( "-m" );

        return command;
    }




    /**
     */
    private ProcessBuilder _createProcessBuilder()
    {
        List<String>  command = _createCommand();
        _LOG_.debug( "OVAL Interpreter command: " + String.valueOf( command ) );
        ProcessBuilder  builder = new ProcessBuilder( command );

        String  workingDir = getWorkingDir();
        if (workingDir != null) {
            builder.directory( new File( workingDir ) );
        }

        return builder;
    }



    /**
     * Starts a new OVAL interpreter process.
     */
    public Process execute()
    throws OvalInterpreterException
    {
        ProcessBuilder  builder = _createProcessBuilder();
        Process  proc = null;
        try {
            proc = builder.start();
        } catch (IOException ex) {
            throw new OvalInterpreterException( ex );
        }

        return proc;
    }



    // properties


    private final Map<Property, String>  _config = new HashMap<Property, String>();

    private String _getConfigValue(
                    final Property property
                    )
    {
        String  value = _config.get( property );
        if (value == null  &&  property.hasProperty()) {
            value = OvalContext.INSTANCE.getProperty( property.property );
        }

        return (value == null ? property.defaultValue : value);
    }


    private void _setConfigValue(
                    final Property property,
                    final String value
                    )
    {
        _config.put( property, value );
    }


    /**
     */
    public void setWorkingDir(
                    final String dir
                    )
    {
        _setConfigValue( Property.WORKING_DIR, dir );
    }


    public String getWorkingDir()
    {
        return _getConfigValue( Property.WORKING_DIR );
    }



    /**
     */
    public void setExecutable(
                    final String filepath
                    )
    {
        _setConfigValue( Property.EXECUTABLE, filepath );
    }


    public String getExecutable()
    {
        return _getConfigValue( Property.EXECUTABLE );
    }



    /**
     */
    public void setOvalDefinitions(
                    final String filepath
                    )
    {
        _setConfigValue( Property.OVAL_DEFINITIONS, filepath );
    }


    public String getOvalDefinitions()
    {
        return _getConfigValue( Property.OVAL_DEFINITIONS );
    }



    /**
     */
    public void setOvalResults(
                    final String filepath
                    )
    {
        _setConfigValue( Property.OVAL_RESULTS, filepath );
    }


    public String getOvalResults()
    {
        return _getConfigValue( Property.OVAL_RESULTS );
    }

}
// OvalInterpreter

