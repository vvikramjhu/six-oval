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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.oval.interpreter.Option;
import jp.go.aist.six.oval.interpreter.Options;
import jp.go.aist.six.oval.interpreter.OvalInterpreter;
import jp.go.aist.six.oval.interpreter.OvalInterpreterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * An ovaldi wrapper.
 * The ovaldi is a Mitre's reference implementation which evaluates OVAL Definitions.
 * Based on a set of OVAL Definitions the interpreter collects system information,
 * evaluates it, and generates a detailed OVAL Results file.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/interpreter.html">OVAL Interpreter</a>
 */
public class OvaldiProxy
    implements OvalInterpreter
{

    /**
     * Command line entry point.
     *
     * @param args
     *  the OVAL Interpreter program and its arguments.
     */
    public static void main(
                    final String[] args
                    )
    throws Exception
    {
        if (args.length < 1) {
            System.err.println( "no program and arguments specified" );
            System.exit( 1 );
        }

        List<String>  strings = Arrays.asList( args );
        String  executable = strings.remove( 0 );
        Options  options = OvaldiOptions.fromCommandLine( strings );

        final OvaldiProxy  ovaldi = new OvaldiProxy();
        ovaldi.setExecutable( executable );
        ovaldi.setOptions( options );

        final int  exit_value = ovaldi.execute();
        System.exit( exit_value );
    }



    /**
     * TODO:
     * Read the configuration properties from Java properties file!!!
     *
     * In Spring configuration:
     * < key="#{ T(xxx.Property).EXECUTABLE}" value="/usr/bin/ovaldi" />
     */

    private static enum Property
    {
        EXECUTABLE(   "six.oval.interpreter.executable", "ovaldi", null ),
        OVAL_XML_DIR( "six.oval.interpreter.xml",        null,     OvaldiOption.OVAL_XML_DIR ),
//        LOG_LEVEL(    "six.oval.interpreter.log",        "1",      OvaldiOption.LOG_LEVEL ),
//        WORKING_DIR(  "six.oval.interpreter.dir",        null,     null ),
//        TMP_DIR(      "java.io.tmpdir",                  null,     null )
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

    }
    //Property



    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( OvaldiProxy.class );


    private final Map<Property, String>  _config =
        new EnumMap<Property, String>( Property.class );


    private Options  _options;


//    private OvalContext  _context;



    /**
     * Constructor.
     */
    public OvaldiProxy()
    {
    }


    public OvaldiProxy(
                    final Options options
                    )
    {
        setOptions( options );
    }



    /**
     * Starts a new OVAL interpreter process.
     *
     * @throws  OvalInterpreterException
     */
    @Override
    public int execute()
    {
        final ProcessBuilder  builder = _createProcessBuilder();
        Process  process = null;
        int  exitValue = 0;
        try {
            process = builder.start();
                           //throws IOException, SecurityException
        } catch (final Exception ex) {
            throw new OvalInterpreterException( ex );
        }

        exitValue = _waitFor( process );

        return exitValue;
    }



    /**
     * Reads the output from the process and waits until the process has terminated.
     *
     * @return
     *  the exit value of the process.
     * @throws  OvalInterpreterException
     */
    private int _waitFor(
                    final Process process
                    )
    {
        final String  lineSeparator = System.getProperty( "line.separator" );
        final BufferedReader  reader = new BufferedReader(
                        new InputStreamReader( process.getInputStream() ) );

        int  exitValue = 0;
        final StringBuilder  log = new StringBuilder();
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

        } catch (final Exception ex) {
           throw new OvalInterpreterException( ex );
        } finally {
            try {
                reader.close();
                       //throws IOException
            } catch (final Exception ex) {
                // ignorable.
                _LOG_.warn( ex.getMessage() );
            }
        }

        _LOG_.debug( "==== ovaldi log ====\n" + log.toString() );

        _LOG_.debug( "exit value=" + exitValue );
        return exitValue;
    }



    /**
     * Creates a process builder.
     * The standard error and standard output are merged,
     * so that both can be read using the Process.getInputStream() method.
     */
    private ProcessBuilder _createProcessBuilder()
    {
        final List<String>  command = _createCommand();
        final ProcessBuilder  builder = new ProcessBuilder( command );

//        String  workingDir = getWorkingDir();
//        if (workingDir != null) {
//            builder.directory( new File( workingDir ) );
//        }
//        _LOG_.debug( "working dir=" + builder.directory() );

        /* Merging standard error and standard output!!!
         */
        builder.redirectErrorStream( true );

        return builder;
    }




    /**
     * Creates a command line: the program and its arguments.
     * E.g. ovaldi -m -o definitions.xml
     *
     * @throws  OvalInterpreterException
     */
    private List<String> _createCommand()
    {
        final List<String>  command = new ArrayList<String>();

        command.add( getExecutable() );

        Options  options = _adjustDefaultOptions( getOptions() );
        if (options == null) {
            options = new Options();
        }
        _LOG_.debug( "options: " + options );
        command.addAll( options.toCommandLine() );

        _LOG_.debug( "command: " + String.valueOf( command ) );
        return command;
    }



    /**
     *
     */
    private Options _adjustDefaultOptions(
                    final Options options
                    )
    {
        Options  complete_options = null;

        if (options != null) {
            try {
                complete_options = options.clone();
            } catch (CloneNotSupportedException ex) {
                // never happen
            }
        }

        if (complete_options == null) {
            complete_options = new OvaldiOptions();
        }

        for (Property  property : Property.values()) {
            if (property.option != null) {
                String  value = options.get( property.option );
                if (value == null) {
                    value = _getConfigProperty( property );
                    complete_options.set( property.option, value );
                }
            }
        }

        return complete_options;
    }



    /**
     */
    private String _getConfigProperty(
                    final Property property
                    )
    {
        String  value = _config.get( property );
        if (value == null) {
            value = OvalContext.getProperty( property.name );
        }

        return (value == null ? property.defaultValue : value);
    }


    private void _setConfigProperty(
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
        _setConfigProperty( Property.EXECUTABLE, filepath );
    }


    public String getExecutable()
    {
        return _getConfigProperty( Property.EXECUTABLE );
    }




    //**************************************************************
    //  OvalDefinitionsInterpreter
    //**************************************************************

//    public OvalDefinitionInterpreter setOptions(
    @Override
    public void setOptions(
                    final Options options
                    )
    {
        _options = options;
//        return this;
    }


    @Override
    public Options getOptions()
    {
        return _options;
    }


//    /**
//     */
//    public void setWorkingDir(
//                    final String dirpath
//                    )
//    {
//        _setConfigValue( Property.WORKING_DIR, dirpath );
//    }
//
//
//    public String getWorkingDir()
//    {
//        return _getConfigValue( Property.WORKING_DIR );
//    }
//
//
//
//    /**
//     */
//    public String getTmpDir()
//    {
//        String  tmpdir = _getConfigValue( Property.TMP_DIR );
//        if (tmpdir == null) {
//            throw new OvalInterpreterException( "config: tmpDir NOT found" );
//        }
//
//        return tmpdir;
//    }

}
//

