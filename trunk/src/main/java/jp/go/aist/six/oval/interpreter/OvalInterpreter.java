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
    private String _getConfigValue(
                    final Property property
                    )
    {
        String  value = _config.get( property );
        if (value == null  &&  property.hasProperty()) {
            value = OvalInterpreterContext.INSTANCE.getProperty( property.name );
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



}
// OvalInterpreter

