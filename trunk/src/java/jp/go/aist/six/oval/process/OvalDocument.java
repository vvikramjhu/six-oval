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

import jp.go.aist.six.util.net.RestletHttp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restlet.data.Form;
import org.restlet.data.Reference;
import org.restlet.data.Response;
import org.restlet.data.Status;
import org.restlet.resource.Representation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Map;




/**
 * An extension of the OvaldiCommand.
 * The extension includes:
 * getting the OVAL definitions via HTTP GET method,
 * and sending OVAL results via HTTP POST method.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: NetOvalInterpreter.java 619 2010-04-19 02:01:06Z akihito $
 */
public class NetOvalInterpreter
implements OvalProcessor
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( NetOvalInterpreter.class );



//    public static void main( final String[] args )
//    {
//        System.out.println( "=================================" );
//        System.out.println( "SIX OVAL Interpreter, v0.3.0: " + (new Date()) );
//        System.out.println( "  * started: " + (new Date()) );
//
//        NetOvalInterpreter  proc = new NetOvalInterpreter( args );
//        OvalProcessStatus  status = proc.execute();
//
//        System.out.println( "  * finished: " + (new Date()) );
//        for (String  attr : status.getAttributeNames()) {
//            System.out.println( "  @" + attr
//                            + ": " + status.getAttribute( attr ) );
//        }
//
//        if (status.isError()) {
//            System.out.println( "  ERROR: " + status.getErrorMessage() );
//            Exception  ex = status.getErrorCause();
//            if (ex != null) {
//                System.out.println( "  cause: " + status.getErrorCause() );
//            }
//            System.exit( 1 );
//        } else {
//            System.exit( 0 );
//        }
//    }


    // HTTP Options:
    public static final String  OPT_HTTP_POST_RESULTS = "-post";

    public static final String  OVAL_RESULTS_PARAM_NAME = "oval_results";


    public static class Attribute
    {
        public static final String  OVALDI_EXIT_VALUE   = "ovaldi.exit_value";
        public static final String  OVALDI_LOG          = "ovaldi.log";
        public static final String  HTTP_CREATED        = "http.created";
        public static final String  HTTP_STATUS_CODE    = "http.status_code";
        public static final String  HTTP_STATUS_NAME    = "http.status_name";
        public static final String  HTTP_METHOD         = "http.method";

    }



    private OvaldiCommand  _ovaldi;
    private String  _postURL;

    private RestletHttp  _http;



    /**
     * Constructor.
     */
    public NetOvalInterpreter()
    {
    }



    /**
     * Constructor.
     */
    public NetOvalInterpreter(
                    final String executable,
                    final Map<String,String> options,
                    final String md5
                    )
    {
        _ovaldi = new OvaldiCommand( executable, options, md5 );
        if (options != null) {
            setHttpPostResults( options.get( OPT_HTTP_POST_RESULTS ) );
        }
    }



    /**
     * Constructor.
     */
    public NetOvalInterpreter(
                    final String[] cmdarray
                    )
    {
        _ovaldi = new OvaldiCommand( cmdarray );
        _configure( cmdarray );
    }



    /**
     */
    private void _configure(
                    final String[] cmdarray
                    )
    {
        final int  size = cmdarray.length;
        try {
            // cmdarray[0] is ovaldi executable
            for (int  i = 1; i < size; i++) {
                if (cmdarray[i].equals( OPT_HTTP_POST_RESULTS )) {
                    setHttpPostResults( cmdarray[ ++i ] );
                }
            }
        } catch (IndexOutOfBoundsException ex) {
            throw new IllegalArgumentException(
                            "invalid command argument specified" );
        }
    }



    /**
     */
    protected void _setOvaldiCommand(
                    final OvaldiCommand ovaldi
                    )
    {
        _ovaldi = ovaldi;
    }


    /**
     */
    protected OvaldiCommand _getOvaldiCommand()
    {
        return _ovaldi;
    }





    /**
     */
    public String getHttpPostResults()
    {
        return _postURL;
    }


    public void setHttpPostResults(
                    final String location
                    )
    {
        _postURL = location;
    }



    /**
     */
    private synchronized RestletHttp _getHttp()
    {
        if (_http == null) {
            _http = new RestletHttp();
        }

        return _http;
    }




    /**
     */
    protected OvalProcessStatus _httpGet(
                    final String url,
                    final File resource
                    )
    {
        OvalProcessStatus  status = new OvalProcessStatus();
        Response  response = _getHttp().get( url );
        Status  http_status = response.getStatus();
        status.setError( http_status.isError() );
        status.setAttribute( Attribute.HTTP_METHOD, "GET" );
        status.setAttribute( Attribute.HTTP_STATUS_CODE, http_status.getCode() );
        status.setAttribute( Attribute.HTTP_STATUS_NAME, http_status.getName() );

        try {
            Reader  reader = new BufferedReader( response.getEntity().getReader() );
            Writer  writer = new BufferedWriter( new FileWriter( resource ) );
            _io( reader, writer );
        } catch (Exception ex) {
            status.buildError( ex );
            return status;
        }

        return status;
    }



    protected OvalProcessStatus _httpPost(
                    final String url,
                    final String resourceName,
                    final File resource
                    )
    {
        StringWriter  sw = new StringWriter();
        try {
//            Reader  reader = new BufferedReader( new FileReader( resource ) );
            Reader  reader = new BufferedReader( new InputStreamReader(
                            new FileInputStream( resource ), Charset.forName( "UTF-8" ) ) );
            // The character set should be specified to parse XML
            // containing Japanese characters.

            Writer  writer = new BufferedWriter( sw );
            _io( reader, writer );
        } catch (Exception ex) {
            return (new OvalProcessStatus());
        }

        String  value = sw.toString();
        Form  form = new Form();
        form.add( resourceName, value );
        Representation  rep = form.getWebRepresentation();
        Response  response = _getHttp().post( url, rep );
        Status  http_status = response.getStatus();

        OvalProcessStatus  status = new OvalProcessStatus();
        status.setError( http_status.isError() );
        status.setAttribute( Attribute.HTTP_METHOD, "POST" );
        status.setAttribute( Attribute.HTTP_STATUS_CODE, http_status.getCode() );
        status.setAttribute( Attribute.HTTP_STATUS_NAME, http_status.getName() );
        Reference  createdLocation = response.getEntity().getIdentifier();
        if (createdLocation != null) {
            status.setAttribute( Attribute.HTTP_CREATED, createdLocation.toString() );
        }

        return status;
    }



    /**
     */
    private void _io(
                    final Reader reader,
                    final Writer writer
                    )
    throws IOException
    {
        char[]  buffer = new char[512];
        try {
            while (true) {
                int  n = reader.read( buffer );
                                //@throws IOException
                if (n == -1) {
                    break;
                }
                writer.write( buffer, 0, n );
                       //@throws IOException
            }
        } finally {
            try {
                reader.close();
            } catch (Exception ex) {
                //ignorable
            }
            try {
                writer.close();
            } catch (Exception ex) {
                //ignorable
            }
        }
    }




    private OvalProcessStatus _executeOvaldi()
    {
        Process  process = null;
        try {
            process = _getOvaldiCommand().execute();
                              //@throws IOException
                              //@throws SecurityException
                              //@throws NullPointerException, IndexOutOfBoundsException
        } catch (Exception ex) {
            return (new OvalProcessStatus( ex ));
        }

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

        } catch (Exception ex) {
           return (new OvalProcessStatus( ex ));
        } finally {
            try {
                exitValue = process.waitFor();
                                    //throws InterruptedException
                reader.close();
                       //throws IOException
            } catch (Exception ex) {
                // ignorable.
                if (_LOG.isWarnEnabled()) {
                    _LOG.warn( ex.getMessage() );
                }
            }
        }

        OvalProcessStatus  status = new OvalProcessStatus();
        status.setAttribute( Attribute.OVALDI_EXIT_VALUE, new Integer( exitValue ) );
        status.setAttribute( Attribute.OVALDI_LOG, log.toString() );

        return status;
    }



    //**************************************************************
    //  OvalProcessor
    //**************************************************************

    public OvalProcessStatus execute()
    {
        // HTTP GET if required.
        OvalProcessStatus  httpGetStatus = null;
        String  inputDefinitions = _ovaldi.getInputDefinitions();
        if (inputDefinitions.startsWith( "http:" )
                        ||  inputDefinitions.startsWith( "https:" )) {
            File  ovalDefinitionsFile = null;
            try {
                ovalDefinitionsFile = File.createTempFile( "oval-d_", ".xml" );
                                       //@throws IOException
            } catch (Exception ex) {
                return (new OvalProcessStatus( ex ));
            }
            httpGetStatus = _httpGet( inputDefinitions, ovalDefinitionsFile );
            if (httpGetStatus.isError()) {
                return httpGetStatus;
            }
            inputDefinitions = ovalDefinitionsFile.getAbsolutePath();
            _ovaldi.setInputDefinitions( inputDefinitions );
        }

        OvalProcessStatus  status = _executeOvaldi();
        status.mergeAttributes( httpGetStatus );
        if (status.isError()) {
            return status;
        }

        // HTTP POST if required.
        String  postURL = getHttpPostResults();
        if (postURL != null) {
            File  ovalResultsFile = new File( _ovaldi.getOutputResults() );

            OvalProcessStatus  httpPostStatus =
                _httpPost( postURL, OVAL_RESULTS_PARAM_NAME, ovalResultsFile);

            httpPostStatus.mergeAttributes( status );
            status = httpPostStatus;
        }

        return status;
    }

}
// NetOvaldiProcessor

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

