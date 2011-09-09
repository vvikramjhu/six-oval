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
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * An OVAL Interpreter wrapper.
 * We assume the reference implementation: ovaldi.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalInterpreter
{

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
//        OVAL_XML_DIR( "six.oval.interpreter.xml",        null,     Option.OVAL_XML_DIR ),
//        LOG_LEVEL(    "six.oval.interpreter.log",        "1",      Option.LOG_LEVEL ),
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


    private Options  _options;



    /**
     * Constructor.
     */
    public OvalInterpreter()
    {
    }



    /**
     */
    public void setOptions(
                    final Options options
                    )
    {
        _options = options;
    }


    public Options getOptions()
    {
        return _options;
    }



    /**
     * Starts a new OVAL interpreter process.
     */
    public int execute()
    throws OvalInterpreterException
    {
        ProcessBuilder  builder = _createProcessBuilder();
        Process  process = null;
        int  exitValue = 0;
        try {
            process = builder.start();
                           //throws IOException, SecurityException
        } catch (Exception ex) {
            throw new OvalInterpreterException( ex );
        }

        exitValue = _waitFor( process );
        _LOG_.debug( "exit value=" + exitValue );

        return exitValue;
    }



    /**
     * Reads the output from the process and waits until the process has terminated.
     *
     * @return
     *  the exit value of the process.
     */
    private int _waitFor(
                    final Process process
                    )
    throws OvalInterpreterException
    {
        String  lineSeparator = System.getProperty( "line.separator" );
        BufferedReader  reader = new BufferedReader(
                        new InputStreamReader( process.getInputStream() ) );

        int  exitValue = 0;
        StringBuilder  log = new StringBuilder();
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
                _LOG_.warn( ex.getMessage() );
            }
        }

        _LOG_.debug( "==== ovaldi log ====\n" + log.toString() );

        return exitValue;
    }



    /**
     * Creates a process builder.
     * The standard error and standard output are merged,
     * so that both can be read using the Process.getInputStream() method.
     */
    private ProcessBuilder _createProcessBuilder()
    {
        List<String>  command = _createCommand();
        ProcessBuilder  builder = new ProcessBuilder( command );

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
     */
    private List<String> _createCommand()
    throws OvalInterpreterException
    {
        List<String>  command = new ArrayList<String>();

        command.add( getExecutable() );

        Options  options = getOptions();
        if (options == null) {
            options = new Options();
        }
        command.addAll( options.toCommand() );

        _LOG_.debug( "command: " + String.valueOf( command ) );
        return command;
    }



    /**
     */
    private String _getConfigProperty(
                    final Property property
                    )
    {
        String  value = _config.get( property );
        if (value == null  &&  property.hasProperty()) {
            value = System.getProperty( property.name );
//            value = OvalContext.INSTANCE.getProperty( property.name );
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
// OvalInterpreter

