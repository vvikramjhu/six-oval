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

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;



/**
 * An OVAL Interpreter wrapper.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class NetOvalInterpreter
    extends OvalInterpreter
{

    private static class NetOption
    extends Option
    {
        public static final NetOption WORK_DIR = new NetOption(
                        "-workdir", true, "dir name", null,
                        null,
                        "path to the directory in which the temporary file resources are stored\n"
                        + "(default is the Java temporary directory specified by 'java.io.tmpdir' system property)"
        );


        /**
         * Constructor.
         */
        protected NetOption(
                        final String name,
                        final boolean hasArgument,
                        final String argumentName,
                        final String defaultArgument,
                        final String contentType,
                        final String description
                        )
        {
            super( name, hasArgument, argumentName, defaultArgument, contentType, description );
        }

    }
    // NetOption




    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( NetOvalInterpreter.class );



    private static final List<MediaType>  _OVAL_FILE_MEDIA_TYPES_ =
        Arrays.asList( new MediaType[] { MediaType.APPLICATION_XML } );



    private static final Option[]  _NET_RCV_OPTIONS_ = new Option[] {
        Option.OVAL_DEFINITIONS
    };


    private static final Option[]  _NET_SND_OPTIONS_ = new Option[] {
        Option.OVAL_RESULTS
    };



    private String  _workingFilePrefix;
    private File  _workingDir;




    /**
     * Constructor.
     */
    public NetOvalInterpreter()
    {

    }



    /**
     *
     */
    private void _init()
    {
        _workingFilePrefix = _createFilePrefix();
        _workingDir = _getWorkingDir();

        _LOG_.debug( "working file prefix: " + _workingFilePrefix );
        _LOG_.debug( "working dir: " + _workingDir );
    }



    private static SimpleDateFormat  _DATETIME_FORMATTER_ =
        new SimpleDateFormat( "yyyyMMdd'T'HHmmss" );


    /**
     */
    private String _createFilePrefix()
    {
        String  prefix = _DATETIME_FORMATTER_.format( new Date() );
        prefix = prefix + "_oval_";

        return prefix;
    }



    /**
     *
     */
    private File _getWorkingDir()
    {
        String  dirpath = System.getProperty( "java.io.tmpdir" );
        File  dir = new File( dirpath );
        if (dir.exists()  &&  dir.canWrite()  &&  dir.canRead()) {
            //OK!!!
        } else {
            throw new IllegalStateException( "working directory not found or not ready: " + dirpath );
        }

        return dir;
    }




    /**
     */
    private URL _toUrl(
                    final String value
                    )
    {
        if (value == null) {
            return null;
        }

        URL  url = null;
        try {
            url = new URL( value );
                  //throws MalformedURLException
        } catch (MalformedURLException ex) {
            // in case of a local file
            url = null;
        }

        return (url == null ? null : url);
    }



    /**
     * For each input resources, if its location is given as an URL,
     * it is read and saved into a local temporary file.
     */
    protected void _prepareInputFiles(
                    final Options localOptions
                    )
    {
        Options  options = getOptions();
        for (Option  option : _NET_RCV_OPTIONS_) {
            if (option.hasArgument
                            &&  option.defaultArgument != null
                            &&  option.contentType != null) {
                //valid option
            } else {
                throw new IllegalStateException(
                                "INTERNAL ERROR: option not configured for remote resource: "
                                + option );
            }

            String  value = options.get( option );
            if (value != null) {
                URL  url = null;
                try {
                    url = new URL( value );
                } catch (MalformedURLException ex) {
                    //ignorable
                    url = null;
                }

                if (url == null) {
                    // local filepath
                } else {
                    /** This option argument is an URL.
                     * Download the resource and save it to a local file.
                     * Then, replace the argument for local execution.
                     */
                    File  file = _createWorkingFile( _workingDir, _workingFilePrefix, option );
                    _restGetFile( url, file, option.contentType );

                    localOptions.set( option, file.getAbsolutePath() );
                }
            }
        }
    }



    /**
     * Creates a temporary working file in the specified directory.
     */
    private File _createWorkingFile(
                    final File dir,
                    final String prefix,
                    final Option option
                    )
    {
        _LOG_.debug( "creating a working file: dir=" + dir
                        + ", prefix=" + prefix
                        + ", option=" + option );

        String  defaultFilename = option.defaultArgument;
        if (defaultFilename == null) {
            throw new IllegalArgumentException(
                            "option has no default value (filename): " + option );
        }

        String  filename = prefix + defaultFilename;
        File  file = new File( dir, filename );
        _LOG_.debug( "a working file created: file=" + file );

        return file;
    }



    /**
     * If an output file location is an URL,
     * the output from the interpreter is written to a local working file.
     */
    private void _prepareOutputFiles(
                    final Options localOptions
                    )
    {
        Options  options = getOptions();
        for (Option  option : _NET_SND_OPTIONS_) {
            if (option.hasArgument
                            &&  option.defaultArgument != null
                            &&  option.contentType != null) {
                //valid option
            } else {
                throw new IllegalStateException(
                                "INTERNAL ERROR: option not configured for remote resource: "
                                + option );
            }

            String  value = options.get( option );
            if (value != null) {
                URL  url = null;
                try {
                    url = new URL( value );
                } catch (MalformedURLException ex) {
                    //ignorable
                    url = null;
                }

                if (url == null) {
                    // local filepath
                } else {
                    /** This option argument is an URL.
                     * Decide the local filename, and
                     * replace the argument for local execution.
                     */
                    File  file = _createWorkingFile( _workingDir, _workingFilePrefix, option );
                    localOptions.set( option, file.getAbsolutePath() );
                }
            }
        }
    }



    /**
     *
     */
    private void _preProcess(
                    final Options localOptions
                    )
    throws OvalInterpreterException
    {
        _prepareInputFiles( localOptions );
        _prepareOutputFiles( localOptions );
    }



    /**
     * TODO: Send all the output files to the given locations.
     */
    private void _postProcess(
                    final Options localOptions
                    )
    throws OvalInterpreterException
    {
        Options  options = getOptions();
        for (Option  option : _NET_SND_OPTIONS_) {
            String  value = options.get( option );
            if (value != null) {
                URL  url = null;
                try {
                    url = new URL( value );
                } catch (MalformedURLException ex) {
                    //ignorable
                    url = null;
                }

                if (url == null) {
                    // local filepath
                } else {
                    /** This option argument is an URL.
                     * Obtain the local filepath, and
                     * send the file to the remote execution.
                     */
                    String  filepath = localOptions.get( option );
                    _restPostFile( url, new File( filepath ), option.contentType );
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



    //==============================================================
    // REST
    //==============================================================

    /**
     */
    protected RestTemplate _getRestTemplate()
    {
        return (new RestTemplate());
    }



    /**
     * REST: GET file
     */
    protected void _restGetFile(
                    final URL location,
                    final File file,
                    final String contentType
                    )
    throws OvalInterpreterException
    {
        _LOG_.debug( "GET: location=" + location
                        + ", file=" + file
                        + ", content-type=" + contentType );

        URI  uri = null;
        try {
            uri = location.toURI();
                      //throws URISyntaxException
        } catch (Exception ex) {
            throw new OvalInterpreterException( ex );
        }

        RestTemplate  rest = _getRestTemplate();
        try {
            FileResponseExtractor  extractor = new FileResponseExtractor( file );
            MediaType  mediaType = MediaType.valueOf( contentType );
            List<MediaType>  mediaTypes = Arrays.asList( new MediaType[] { mediaType} );
            AcceptHeaderRequestCallback  callback =
                new AcceptHeaderRequestCallback( mediaTypes );
            rest.execute(
                            uri,
                            HttpMethod.GET,
                            callback,
                            extractor
                            );
        } catch (RestClientException ex) {
            _LOG_.error( "REST GET error: " + ex );
            throw new OvalInterpreterException( ex );
        }
    }



    /**
     * REST: POST file
     */
    protected void _restPostFile(
                    final URL location,
                    final File file,
                    final String contentType
                    )
    throws OvalInterpreterException
    {
        _LOG_.debug( "POST: location=" + location
                        + ", file=" + file
                        + ", content-type=" + contentType );

        URI  uri = null;
        try {
            uri = location.toURI();
                      //throws URISyntaxException
        } catch (Exception ex) {
            throw new OvalInterpreterException( ex );
        }

        RestTemplate  rest = _getRestTemplate();
        MediaType  mediaType = MediaType.valueOf( contentType );
        try {
            FileRequestCallback  callback =
                new FileRequestCallback( file, mediaType );
            rest.execute(
                            uri,
                            HttpMethod.POST,
                            callback,
                            null
                            );
        } catch (RestClientException ex) {
            _LOG_.error( "REST POST error: " + ex );
            throw new OvalInterpreterException( ex );
        }
    }



    //**************************************************************
    //  OvalInterpreter
    //**************************************************************

    @Override
    public int execute()
    throws OvalInterpreterException
    {
        _init();

        /**
         * NOTE: Copy the options as a backup.
         * The original options are re-configured to invoke local OvalInterpreter.
         * The backup is used in the post process to send the results
         * to the given locations, if required.
         */
        Options  localOptions = null;
        try {
            localOptions = getOptions().clone();
        } catch (CloneNotSupportedException ex) {
            throw new OvalInterpreterException( ex );
        }

        _preProcess( localOptions );

        OvalInterpreter  ovaldi = new OvalInterpreter( localOptions );
        ovaldi.setExecutable( getExecutable() );
        int  exitValue = ovaldi.execute();

        if (exitValue == 0) {
            _postProcess( localOptions );
        } else {
            _postErrorProcess();
        }

        return exitValue;
    }




    //**************************************************************
    //  nested classes
    //**************************************************************

    /**
     * A simple callback for the Spring RestTemplate.
     */
    private static class AcceptHeaderRequestCallback
    implements RequestCallback
    {

        private final List<MediaType>  _acceptableMediaTypes;



        private AcceptHeaderRequestCallback(
                        final List<MediaType> mediaTypes
                        )
        {
            _acceptableMediaTypes = mediaTypes;
        }



        @Override
        public void doWithRequest(
                        final ClientHttpRequest request
                        )
        throws IOException
        {
            request.getHeaders().setAccept( _acceptableMediaTypes );
        }
    }
    //AcceptHeaderRequestCallback

}
//NetOvalInterpreter

