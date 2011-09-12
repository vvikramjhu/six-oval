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
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import jp.go.aist.six.util.IsoDate;
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
                        final String description
                        )
        {
            super( name, hasArgument, argumentName, defaultArgument, description );
        }

    }
    // NetOption




    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( NetOvalInterpreter.class );



    private static final List<MediaType>  _ACCEPT_MEDIA_TYPES_ =
        Arrays.asList( new MediaType[] { MediaType.APPLICATION_XML } );



    private static final Option[]  _NET_RCV_OPTIONS_ = new Option[] {
        Option.OVAL_DEFINITIONS
    };


    private static final Option[]  _NET_SND_OPTIONS_ = new Option[] {
        Option.OVAL_RESULTS
    };



    private final String  _filePrefix;
    private final File  _workingDir;




    /**
     * Constructor.
     */
    public NetOvalInterpreter()
    {
        _filePrefix = _createFilePrefix();
        _workingDir = _getWorkingDir();
    }



    /**
     */
    private String _createFilePrefix()
    {
        String  prefix = IsoDate.format( new Date() );
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
     */
    protected void _prepareInputFiles()
    {
        Options  options = getOptions();
        for (Option  option : _NET_RCV_OPTIONS_) {
            String  value = options.get( option );
            if (option.hasArgument  &&  value != null) {
                URL  url = null;
                try {
                    url = new URL( value );
                } catch (MalformedURLException ex) {
                    //ignorable
                }
                if (url == null) {
                    // local filepath
                } else {
                    // option argument is an URL
                    File  file = _createWorkingFile( _filePrefix, option );
                    _restGetOvalDefinitions( url, file );

                    options.set( option, file.getAbsolutePath() );
                }
            }
        }
    }



    /**
     */
    private File _createWorkingFile(
                    final String prefix,
                    final Option option
                    )
    {
        String  defaultFilename = option.defaultArgument;
        if (defaultFilename == null) {
            throw new IllegalArgumentException( "option not for file: " + option );
        }

        String  filename = prefix + defaultFilename;
        File  file = new File( _workingDir, filename );

        return file;
    }



    /**
     * If an output file location is an URL,
     * the output from the interpreter is written to a local working file.
     */
    private void _prepareOutputFiles()
    {

    }



    /**
     *
     */
    private void _preProcess()
    throws OvalInterpreterException
    {
        _prepareInputFiles();
        _prepareOutputFiles();
    }



    /**
     * TODO: Send all the output files to the given locations.
     */
    private void _postProcess(
                    final Options netOptions
                    )
    throws OvalInterpreterException
    {
    }



    /**
     * TODO: Send all the error results to the given locations.
     * @param netOptions
     */
    private void _postErrorProcess(
                    final Options netOptions
                    )
    {
    }



    /**
     * Starts a new OVAL interpreter process.
     */
    @Override
    public int execute()
    throws OvalInterpreterException
    {
        Options  netOptions = getOptions().clone();
        _preProcess();

        int  exitValue = super.execute();
        if (exitValue == 0) {
            _postProcess( netOptions );
        } else {
            _postErrorProcess( netOptions );
        }

        return exitValue;
    }





    // REST ////////////////////////////////////////////////////////


    protected RestTemplate _getRestTemplate()
    {
        return (new RestTemplate());
    }



    /**
     * REST: GET
     */
    protected void _restGetOvalDefinitions(
                    final URL location,
                    final File file
                    )
    throws OvalInterpreterException
    {
        _LOG_.debug( "GET OVAL Definitions: location=" + location
                        + ", local tmp file=" + file );

        URI  uri = null;
        try {
            uri = location.toURI();
                      //throws URISyntaxException
        } catch (Exception ex) {
            throw new OvalInterpreterException( ex );
        }

        RestTemplate  rest = _getRestTemplate();
        try {
            XmlFileResponseExtractor  extractor =
                new XmlFileResponseExtractor( file );
            AcceptHeaderRequestCallback  callback =
                new AcceptHeaderRequestCallback( _ACCEPT_MEDIA_TYPES_ );
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
     * REST: POST
     */
    protected void _restPostOvalResults(
                    final URL location,
                    final File file
                    )
    throws OvalInterpreterException
    {
        _LOG_.debug( "POST OVAL Results: location=" + location
                        + ", file=" + file );

        URI  uri = null;
        try {
            uri = location.toURI();
                      //throws URISyntaxException
        } catch (Exception ex) {
            throw new OvalInterpreterException( ex );
        }

        RestTemplate  rest = _getRestTemplate();
        try {
            XmlFileRequestCallback  callback = new XmlFileRequestCallback( file );
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



    /**
     * A simple callback for the Spring RestTemplate.
     */
    private static class AcceptHeaderRequestCallback
    implements RequestCallback
    {

        private final List<MediaType>  _accept;



        private AcceptHeaderRequestCallback(
                        final List<MediaType> accept
                        )
        {
            _accept = accept;
        }



        @Override
        public void doWithRequest(
                        final ClientHttpRequest request
                        )
        throws IOException
        {
            request.getHeaders().setAccept( _accept );
        }
    }

}
// OvalInterpreter

