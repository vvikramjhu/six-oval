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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import jp.go.aist.six.oval.interpreter.Option;
import jp.go.aist.six.oval.interpreter.Options;
import jp.go.aist.six.oval.interpreter.OvalInterpreterException;
import jp.go.aist.six.util.net.Http;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;



/**
 * An ovaldi wrapper that enables network transfer of OVAL data.
 *
 * <ul>
 *   <li>-o filename|URL: path to the oval definitions XML file</li>
 *   <li>-r filename|URL: save oval-results to the specified XML file</li>
 * </ul>
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/interpreter.html">OVAL Interpreter</a>
 */
public class NetworkingOvaldiProxy
    extends OvaldiProxy
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
        strings.remove( 0 );
        Options  options = OvaldiOptions.fromCommandLine( strings );

        NetworkingOvaldiProxy  ovaldi = new NetworkingOvaldiProxy();
        ovaldi.setExecutable( args[0] );
        ovaldi.setOptions( options );

        int  exit_value = ovaldi.execute();
        System.exit( exit_value );
    }




//    private static class NetOption
//    extends Option
//    {
//        public static final NetOption WORK_DIR = new NetOption(
//                        "-workdir", true, "dir name", null,
//                        null,
//                        "path to the directory in which the temporary file resources are stored\n"
//                        + "(default is the Java temporary directory specified by 'java.io.tmpdir' system property)"
//        );
//
//
//        /**
//         * Constructor.
//         */
//        protected NetOption(
//                        final String name,
//                        final boolean hasArgument,
//                        final String argumentName,
//                        final String defaultArgument,
//                        final String contentType,
//                        final String description
//                        )
//        {
//            super( name, hasArgument, argumentName, defaultArgument, contentType, description );
//        }
//
//    }
//    // NetOption




    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( NetworkingOvaldiProxy.class );



//    private static final List<MediaType>  _OVAL_FILE_MEDIA_TYPES_ =
//        Arrays.asList( new MediaType[] { MediaType.APPLICATION_XML } );



    private static final Option[]  _NETWORK_INPUT_OPTIONS_ = new Option[] {
        OvaldiOption.OVAL_DEFINITIONS
    };


    private static final Option[]  _NETWORK_OUTPUT_OPTIONS_ = new Option[] {
        OvaldiOption.OVAL_RESULTS
    };



    private String  _workingFilePrefix;
    private File  _workingDir;




    /**
     * Constructor.
     */
    public NetworkingOvaldiProxy()
    {
    }


    public NetworkingOvaldiProxy(
                    final Options options
                    )
    {
        super( options );
    }



    /**
     *
     */
    private void _init()
    {
        _workingFilePrefix = _createWorkingFilePrefix();
        _workingDir = _getWorkingDir();

        _LOG_.debug( "working file prefix: " + _workingFilePrefix );
        _LOG_.debug( "working dir: " + _workingDir );
    }



    /**
     *
     * @throws  OvalInterpreterException
     */
   private void _preProcess(
                   final Options localOptions
                   )
   {
       _prepareInputFiles( localOptions );
       _prepareOutputFiles( localOptions );
   }



    /**
     *
     * @throws  OvalInterpreterException
     */
    private void _postProcess(
                    final Options localizedOptions
                    )
    {
        Options originalOptions = getOptions();
        for (Option option : _NETWORK_OUTPUT_OPTIONS_) {
            String original_file_location = originalOptions.get( option );
            if (original_file_location != null) {
                URL url = _toURL( original_file_location );
                if (url == null) {
                    // local filepath
                } else {
                    /**
                     * This option argument is an URL. Obtain the local
                     * filepath, and send the file to the remote execution.
                     */
                    String filepath = localizedOptions.get( option );
                    _httpPost( url, new File( filepath ), option.contentType );
                }
            }
        }
    }



    /**
     * TODO: Send all the error results to the given locations.
     * @param netOptions
     */
    private void _postErrorProcess()
    {
    }



    /**
     * A prefix string like "yyyyMMdd'T'HHmmss'_oval_'".
     */
    private String _createWorkingFilePrefix()
    {
        SimpleDateFormat  formatter = new SimpleDateFormat( "yyyyMMdd'T'HHmmss" );
        String  prefix = formatter.format( new Date() );
        prefix = prefix + "_oval_";

        return prefix;
    }



    /**
     * Obtains the directory for work.
     * We use the Java tmp directory.
     */
    private File _getWorkingDir()
    {
        String  dirpath = System.getProperty( "java.io.tmpdir" );
        File  dir = new File( dirpath );
        if (dir.exists()  &&  dir.canWrite()  &&  dir.canRead()) {
            //OK!!!
        } else {
            throw new IllegalStateException(
                            "Java tmp directory as the working directory not found or not ready: path=" + dirpath );
        }

        return dir;
    }



    /**
     * Creates a tmp working file in the specified directory.
     * The filename is generated using the specified prefix
     * and the option's default value.
     */
    private File _createWorkingFile(
                    final String postfix
                    )
    {
        _LOG_.debug( "creating working file: dir=" + _workingDir
                        + ", prefix=" + _workingFilePrefix
                        + ", postfix=" + postfix );

        String  filename = _workingFilePrefix + postfix;
        File  file = new File( _workingDir, filename );

        _LOG_.debug( "working file created: file=" + file );
        return file;
    }



    /**
     */
    private URL _toURL(
                    final String value
                    )
    {
        if (value == null) {
            return null;
        }

        URL  url = null;
        try {
            url = new URL( value );
        } catch (MalformedURLException ex) {
            // in case of a local file
            url = null;
        }

        return url;
    }



    /**
     */
    private void _validateNetworkingFileOption(
                    final Option option
                    )
    {
        if (option.hasArgument
                        &&  option.defaultArgument != null
                        &&  option.contentType != null) {
            //valid option
        } else {
            throw new IllegalStateException(
                            "INTERNAL ERROR: option not configured for networking resource: "
                                            + option );
        }
    }



    /**
     * For each input resources, if its location is given as an URL,
     * it is read and saved into a local temporary file.
     * And, the option values are adjusted to use those local files.
     */
    protected void _prepareInputFiles(
                    final Options localizedOptions
                    )
    {
        for (Option  option : _NETWORK_INPUT_OPTIONS_) {
            _validateNetworkingFileOption( option );

            String  file_location = localizedOptions.get( option );
            if (file_location != null) {
                URL  url = _toURL( file_location );
                if (url == null) {
                    // local filepath as it is
                } else {
                    /** This option argument is an URL.
                     * Download the resource and save it to a local file.
                     * Then, replace the argument for local execution.
                     */
                    File  file = _createWorkingFile( option.defaultArgument );
                    _httpGet( url, file, option.contentType );

                    localizedOptions.set( option, file.getAbsolutePath() );
                }
            }
        }
    }



    /**
     * If an output file location is an URL,
     * the output from the interpreter is written to a local working file.
     */
    private void _prepareOutputFiles(
                    final Options localizedOptions
                    )
    {
        for (Option  option : _NETWORK_OUTPUT_OPTIONS_) {
            _validateNetworkingFileOption( option );

            String  file_location = localizedOptions.get( option );
            if (file_location != null) {
                URL  url = _toURL( file_location );
                if (url == null) {
                    // local filepath
                } else {
                    /** This option argument is an URL.
                     * Decide the local filename, and
                     * replace the argument for local execution.
                     */
                    File  file = _createWorkingFile( option.defaultArgument );
                    localizedOptions.set( option, file.getAbsolutePath() );
                }
            }
        }
    }



    //==============================================================
    // HTTP support
    //==============================================================

    /**
     * HTTP GET to file
     *
     * @throws  OvalInterpreterException
     */
    protected void _httpGet(
                    final URL from_url,
                    final File to_file,
                    final String content_type
                    )
    {
        _LOG_.debug( "GET: from URL=" + from_url
                        + ", to file=" + to_file
                        + ", content-type=" + content_type );

        try {
            MediaType  media_type = MediaType.valueOf( content_type );
            List<MediaType>  accept_media_types = Collections.singletonList( media_type );
            Http.getTo( from_url, new FileOutputStream( to_file ), accept_media_types );
        } catch (Exception ex) {
            _LOG_.error( "HTTP GET error: " + ex );
            throw new OvalInterpreterException( ex );
        }
    }



    /**
     * HTTP POST file
     *
     * @throws  OvalInterpreterException
     */
    protected void _httpPost(
                    final URL to_url,
                    final File from_file,
                    final String content_type
                    )
    {
        _LOG_.debug( "HTTP POST: to URL=" + to_url
                        + ", from file=" + from_file
                        + ", content-type=" + content_type );

        try {
            MediaType  media_type = MediaType.valueOf( content_type );
            Http.postFrom( to_url, new FileInputStream( from_file ), media_type );
        } catch (Exception ex) {
            _LOG_.error( "HTTP POST error: " + ex );
            throw new OvalInterpreterException( ex );
        }
    }



    //*********************************************************************
    //  OvalInterpreter
    //*********************************************************************

    @Override
    public int execute()
    {
        _init();

        /**
         * NOTE: Copy the options as a backup.
         * The original options are re-configured to invoke local OvalInterpreter.
         * The backup is used in the post process to send the results
         * to the given locations, if required.
         */
        Options  localizedOptions = new OvaldiOptions();
        localizedOptions.set( getOptions() );
        _preProcess( localizedOptions );

        OvaldiProxy  ovaldi = new OvaldiProxy( localizedOptions );
        ovaldi.setExecutable( getExecutable() );
        int  exitValue = ovaldi.execute();

        if (exitValue == 0) {
            _postProcess( localizedOptions );
        } else {
            _postErrorProcess();
        }

        return exitValue;
    }

}
//

