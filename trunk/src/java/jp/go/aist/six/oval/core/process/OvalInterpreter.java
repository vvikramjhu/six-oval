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

package jp.go.aist.six.oval.core.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.go.aist.six.oval.core.rest.XmlFileRequestCallback;
import jp.go.aist.six.oval.core.rest.XmlFileResponseExtractor;
import jp.go.aist.six.oval.core.service.OvalContext;
import jp.go.aist.six.oval.process.OvalInterpreterException;
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
public class OvalInterpreter
{

    private static enum Property
    {
        EXECUTABLE(       "six.oval.interpreter.executable", "ovaldi", null ),
        WORKING_DIR(      "six.oval.interpreter.dir",        null,     null ),
        TMP_DIR(          "java.io.tmpdir",                  null,     null ),
        OVAL_DEFINITIONS( null,                              null,     "-o" ),
        TMP_OVAL_DEFINITIONS( null,                          null,     null ),
        OVAL_RESULTS(     null,                              null,     "-r" ),
        TMP_OVAL_RESULTS( null,                              null,     null ),
        NO_VERIFY(        null,                              null,     "-m" ),
        OVAL_XML(         "six.oval.interpreter.xml",        null,     "-a" ),
        LOG_LEVEL(        "six.oval.interpreter.log",        null,     "-l" )
        ;


        final String  property;
        final String  defaultValue;  //NOT ovaldi default, but SIX default
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
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( OvalInterpreter.class );



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


    private static final List<MediaType>  _ACCEPT_MEDIA_TYPES_ =
        Arrays.asList( new MediaType[] { MediaType.APPLICATION_XML } );



    /**
     * Constructor.
     */
    public OvalInterpreter()
    {
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
     *
     */
    protected void _preProcess()
    throws OvalInterpreterException
    {
        // GET definitions.xml
        URL  url = _toUrl( getOvalDefinitions() );
        if (url != null) {
            try {
                File  tmpFile = File.createTempFile( "oval-definitions", ".xml", new File( _getTmpDir() ) );
                _restGetOvalDefinitions( url, tmpFile );
                _setTmpOvalDefinitions( tmpFile.getAbsolutePath() );
            } catch (IOException ex) {
                throw new OvalInterpreterException( ex );
            }
        }

        // tmp results.xml
        url = _toUrl( getOvalResults() );
        if (url != null) {
            try {
                File  tmpFile = File.createTempFile( "oval-results", ".xml", new File( _getTmpDir() ) );
                _setTmpOvalResults( tmpFile.getAbsolutePath() );
            } catch (IOException ex) {
                throw new OvalInterpreterException( ex );
            }
        }
    }



    /**
     *
     */
    private void _postProcess()
    throws OvalInterpreterException
    {
        String  tmpOvalResults = _getTmpOvalResults();
        if (tmpOvalResults == null) {
            return;
        }

        URL  postUrl = _toUrl( getOvalResults() );
        _restPostOvalResults( postUrl, (new File( tmpOvalResults )) );
    }



    /**
     */
    private List<String> _createCommand()
    {
        List<String>  command = new ArrayList<String>();

        command.add( getExecutable() );
        command.add( Property.NO_VERIFY.commandOption );

        String  logLevel = _getLogLevel();
        if (logLevel != null) {
            command.add( Property.LOG_LEVEL.commandOption );
            command.add( logLevel );
        }

        String  xmlDir = getOvalXmlDir();
        if (xmlDir != null) {
            command.add( Property.OVAL_XML.commandOption );
            command.add( xmlDir );
        }

        // -o URL
        String  ovalDefinitions = _getTmpOvalDefinitions();
        if (ovalDefinitions == null) {
            // -o local_file
            ovalDefinitions = getOvalDefinitions();
        }
        if (ovalDefinitions != null) {
            command.add( Property.OVAL_DEFINITIONS.commandOption );
            command.add( ovalDefinitions );
        }

        // -r URL
        String  ovalResults = _getTmpOvalResults();
        if (ovalResults == null) {
            // -r local_file
            ovalResults = getOvalResults();
        }
        if (ovalResults != null) {
            command.add( Property.OVAL_RESULTS.commandOption );
            command.add( ovalResults );
        }

        _LOG_.debug( "command: " + String.valueOf( command ) );
        return command;
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
     * Starts a new OVAL interpreter process.
     */
    public int execute()
    throws OvalInterpreterException
    {
        _preProcess();

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
        if (exitValue == 0) {
            _postProcess();
        }

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



    // properties //


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
    private String _getTmpDir()
    {
        return _getConfigValue( Property.TMP_DIR );
    }


    /**
     */
    private String _getLogLevel()
    {
        return _getConfigValue( Property.LOG_LEVEL );
    }


    /**
     *
     */
    private void _setTmpOvalDefinitions(
                    final String value
                    )
    {
        _setConfigValue( Property.TMP_OVAL_DEFINITIONS, value );
    }


    private String _getTmpOvalDefinitions()
    {
        return _getConfigValue( Property.TMP_OVAL_DEFINITIONS );
    }



    /**
     *
     */
    private void _setTmpOvalResults(
                    final String value
                       )
    {
        _setConfigValue( Property.TMP_OVAL_RESULTS, value );
    }


   private String _getTmpOvalResults()
   {
       return _getConfigValue( Property.TMP_OVAL_RESULTS );
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



    /**
     */
    public void setOvalXmlDir(
                    final String dirpath
                    )
    {
        _setConfigValue( Property.OVAL_XML, dirpath );
    }


    public String getOvalXmlDir()
    {
        return _getConfigValue( Property.OVAL_XML );
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

