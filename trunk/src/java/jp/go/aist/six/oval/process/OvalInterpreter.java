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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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



    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( OvalInterpreter.class );



    private static enum Property
    {
        OVAL_DEFINITIONS( "-o", "definitions.xml" ),
        OVAL_RESULTS( "-r", "results.xml" ),
        ;


        final String  option;
        final String  defaultValue;


        /**
         * Constructor.
         */
        Property(
                        final String option
                        )
        {
            this( option, null );
        }


        Property(
                        final String option,
                        final String defaultValue
                        )
        {
            this.option = option;
            this.defaultValue = defaultValue;
        }
    }



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
    private String  _workingDir;
    private String  _tmpDir;
    private String  _ovalScFilepath;
    private String  _ovalDefsUrl;
    private String  _ovalResultsUrl;


    private String  _executable;
    private String  _ovalDefinitions;
    private String  _ovalResults;



    /**
     * Constructor.
     */
    protected OvalInterpreter()
    {
    }




    /**
     */
    private void _configure(
                    final List<String> args
                    )
    throws OvalInterpreterException
    {
        if (args == null  ||  args.size() < 2) {
            throw new IllegalArgumentException(
                            "invalid OVAL Interpreter args: "
                            + String.valueOf( args ) );
        }

        final String[]  argArray = args.toArray( new String[0] );

        OvalContext  context = OvalContext.INSTANCE;

        _tmpDir = _getProperty( context, "java.io.tmpdir", null );
        _LOG_.debug( "tmp dir=" + _tmpDir );

        _workingDir = _getProperty( context, "six.oval.interpreter.dir", _tmpDir );

        _executable = _getProperty( context, "six.oval.interpreter.executable", "ovaldi" );
    }



    private String _getProperty(
                    final OvalContext context,
                    final String name,
                    final String defaultValue
                    )
    {
        String  value = context.getProperty( name );
        return (value == null ? defaultValue : value);
    }





    /**
     */
    private ProcessBuilder _createProcessBuilder(
                    final List<String> args
                    )
    {
        OvalContext  context = OvalContext.INSTANCE;

        //TODO: build command line
        List<String>  command = new ArrayList<String>();

        command.add( (_executable == null ? "ovaldi" : _executable) );

        command.add( "-m" );

        _LOG_.debug( "OVAL Interpreter args: " + String.valueOf( args ) );


        ProcessBuilder  builder = new ProcessBuilder( command );
        //TODO: configure builder

        _tmpDir = _getProperty( context, "java.io.tmpdir", null );
        _LOG_.debug( "tmp dir=" + _tmpDir );

        _workingDir = _getProperty( context, "six.oval.interpreter.dir", _tmpDir );

        _executable = _getProperty( context, "six.oval.interpreter.executable", "ovaldi" );
        builder.directory();

        return builder;
    }



    /**
     * Starts a new OVAL interpreter process.
     */
    public Process execute()
    throws OvalInterpreterException
    {
        Process  proc = null;
        try {
            proc = _builder.start();
        } catch (IOException ex) {
            throw new OvalInterpreterException( ex );
        }

        return proc;
    }



    // properties


//    private final Map<Property, String>  _properties = new HashMap<Property, String>();
//
//    private String _getProperty(
//                    final Property property
//                    )
//    {
//        String  value = _properties.get( property );
//        return (value == null ? property.defaultValue : value);
//    }



    /**
     */
    public void setExecutable(
                    final String filepath
                    )
    {
        _executable = filepath;
    }


    public String getExecutable()
    {
        return _executable;
    }



    /**
     */
    public void setOvalDefinitions(
                    final String filepath
                    )
    {
        _ovalDefinitions = filepath;
    }


    public String getOvalDefinitions()
    {
        return _ovalDefinitions;
    }



    /**
     */
    public void setOvalResults(
                    final String filepath
                    )
    {
        _ovalResults = filepath;
    }


    public String getOvalResults()
    {
        return _ovalResults;
    }

}
// OvalInterpreter

