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

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import jp.go.aist.six.oval.core.service.OvalContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * An OVAL Interpreter wrapper.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalInterpreter
{

    private static enum Property
    {
        EXECUTABLE(   "six.oval.interpreter.executable", "ovaldi", null ),
        OVAL_XML_DIR( "six.oval.interpreter.xml",        null,     Option.OVAL_XML_DIR ),
        LOG_LEVEL(    "six.oval.interpreter.log",        "1",      Option.LOG_LEVEL ),
        WORKING_DIR(  "six.oval.interpreter.dir",        null,     null ),
        TMP_DIR(      "java.io.tmpdir",                  null,     null )
        ;


        final String  name;
        final String  defaultValue;
        final Option  option;


        /**
         * Constructor.
         */
        Property(
                        final String name,
                        final String defaultValue,
                        final Option option
                        )
        {
            this.name= name;
            this.defaultValue = defaultValue;
            this.option = option;
        }


        boolean hasProperty()
        {
            return (name == null ? false : true);
        }
    }



    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( OvalInterpreter.class );


    private final Map<Property, String>  _config =
        new EnumMap<Property, String>( Property.class );


    private final EnumMap<Option, String>  _options =
        new EnumMap<Option, String>( Option.class );

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



    /**
     * Constructor.
     */
    public OvalInterpreter()
    {
    }



    /**
     * Starts a new OVAL interpreter process.
     */
    public int execute()
    throws OvalInterpreterException
    {
        ProcessBuilder  builder = _createProcessBuilder();
        Process  proc = null;
        int  exitValue = 0;
        try {
            proc = builder.start();
                           //throws IOException
        } catch (Exception ex) {
            throw new OvalInterpreterException( ex );
        }

        exitValue = _handleProcess( proc );
        _LOG_.debug( "exit value=" + exitValue );

        return exitValue;
    }



    private int _handleProcess(
                    final Process process
                    )
    throws OvalInterpreterException
    {
        int  exitValue = 0;
        StringBuilder  log = new StringBuilder();
        String  lineSeparator = System.getProperty( "line.separator" );
        BufferedReader  reader = new BufferedReader(
                        new InputStreamReader( process.getInputStream() ) );
        try {
            String  line = null;
            while (true) {
                if (line != null) {
                    log.append( lineSeparator );
                }
                line = reader.readLine();
                              //throws IOException
                if (line == null) {
                    break;
                }
                log.append( line );
            }

            exitValue = process.waitFor();
                                //throws InterruptedException

        } catch (Exception ex) {
           throw new OvalInterpreterException( ex );
        } finally {
            try {
                reader.close();
                       //throws IOException
            } catch (Exception ex) {
                // ignorable.
                if (_LOG_.isWarnEnabled()) {
                    _LOG_.warn( ex.getMessage() );
                }
            }
        }

        _LOG_.debug( "==== ovaldi log ====\n" + log.toString() );

        return exitValue;
    }



    /**
     */
    private ProcessBuilder _createProcessBuilder()
    {
        List<String>  command = _createCommand();
        ProcessBuilder  builder = new ProcessBuilder( command );

        String  workingDir = getWorkingDir();
        if (workingDir != null) {
            builder.directory( new File( workingDir ) );
        }
        _LOG_.debug( "working dir=" + builder.directory() );

        builder.redirectErrorStream( true );

        return builder;
    }




    /**
     */
    private List<String> _createCommand()
    throws OvalInterpreterException
    {
        List<String>  command = new ArrayList<String>();

        command.add( getExecutable() );
//        command.add( Property.NO_VERIFY.commandOption );

        // XML dir
        String  xmldir = getOvalXmlDir();
        if (xmldir == null) {
            xmldir = _getConfigValue( Property.OVAL_XML_DIR );
        }
        if (xmldir != null) {
            command.add( Option.OVAL_XML_DIR.command );
            command.add( xmldir );
        }

//        // log level
//        String  logLevel = getLogLevel();
//        if (logLevel != null) {
//            command.add( Property.LOG_LEVEL.commandOption );
//            command.add( logLevel );
//        }

        // -o URL
        String  ovalDefinitions = getOvalDefinitions();
        if (ovalDefinitions == null) {
            throw new OvalInterpreterException( "NO oval definitions to evaluate" );
        }
        command.add( Option.OVAL_DEFINITIONS.command );
        command.add( ovalDefinitions );

//        String  defIDs = getEvaluateDefinitions();
//        if (defIDs != null) {
//            command.add( Property.EVALUATE_DEFINITIONS.commandOption );
//            command.add( defIDs );
//        }

//        // -r URL
//        String  ovalResults = _getTmpOvalResults();
//        if (ovalResults == null) {
//            // -r local_file
//            ovalResults = getOvalResults();
//        }
//        if (ovalResults != null) {
//            command.add( Property.OVAL_RESULTS.commandOption );
//            command.add( ovalResults );
//        }

        // -m or MD5Hash
        boolean  noVerify = isNoVerify();
        if (noVerify) {
            command.add( Option.NO_VERIFY.command );
        } else {
            String  hash = getMD5Hash();
            if (hash == null) {
                throw new OvalInterpreterException( "NO MD5Hash without -m option" );
            }
            command.add( hash );
        }

        _LOG_.debug( "command: " + String.valueOf( command ) );
        return command;
    }



    /**
     */
    private String _getConfigValue(
                    final Property property
                    )
    {
        String  value = _config.get( property );
        if (value == null  &&  property.hasProperty()) {
            value = OvalContext.INSTANCE.getProperty( property.name );
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
    public void setWorkingDir(
                    final String dirpath
                    )
    {
        _setConfigValue( Property.WORKING_DIR, dirpath );
    }


    public String getWorkingDir()
    {
        return _getConfigValue( Property.WORKING_DIR );
    }



    /**
     */
    public String getTmpDir()
    {
        String  tmpdir = _getConfigValue( Property.TMP_DIR );
        if (tmpdir == null) {
            throw new OvalInterpreterException( "config: tmpDir NOT found" );
        }

        return tmpdir;
    }



    //==============================================================
    //  interpreter options
    //==============================================================

    /**
     * -o
     */
    public void setOvalDefinitions(
                    final String filepath
                    )
    {
        _options.put( Option.OVAL_DEFINITIONS, filepath );
    }


    public String getOvalDefinitions()
    {
        return _options.get( Option.OVAL_DEFINITIONS );
    }



    /**
     * -e
     */
    public void setEvaluateDefinitions(
                    final List<String> defIDs
                    )
    {
        if (defIDs == null) {
            _options.put( Option.EVALUATE_DEFINITIONS, null );
        } else {
            StringBuilder  s = new StringBuilder();
            for (String  defID : defIDs) {
                if (s.length() > 0) {
                    s.append( "," );
                }
                s.append( defID );
            }

            _options.put( Option.EVALUATE_DEFINITIONS, s.toString() );
        }
    }


    public void setEvaluateDefinitions(
                    final String defIDs
                    )
    {
        _options.put( Option.EVALUATE_DEFINITIONS, defIDs );
    }


    public String getEvaluateDefinitions()
    {
        return _options.get( Option.EVALUATE_DEFINITIONS );
    }



    /**
     * -r
     */
    public void setOvalResults(
                    final String filepath
                    )
    {
        _options.put( Option.OVAL_RESULTS, filepath );
    }


    public String getOvalResults()
    {
        return _options.get( Option.OVAL_RESULTS );
    }



    /**
     * -a
     */
    public void setOvalXmlDir(
                    final String dirpath
                    )
    {
        _options.put( Option.OVAL_XML_DIR, dirpath );
    }


    public String getOvalXmlDir()
    {
        return _options.get( Option.OVAL_XML_DIR );
    }



    /**
     * -m
     */
    public void setNoVerify(
                    final boolean noVerify
                    )
    {
        _options.put( Option.NO_VERIFY, String.valueOf( noVerify ) );
    }


    public boolean isNoVerify()
    {
        String  noVerify = _options.get( Option.NO_VERIFY );

        return (noVerify == null ? false : Boolean.valueOf( noVerify ).booleanValue() );
    }



    /**
     * MD5Hash
     */
    public void setMD5Hash(
                    final String hash
                    )
    {
        _options.put( Option.MD5_HASH, hash );
    }


    public String getMD5Hash()
    {
        return _options.get( Option.MD5_HASH );
    }

}
// OvalInterpreter

