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

package jp.go.aist.six.oval.process.centos;

import jp.go.aist.six.oval.process.OvalGenerator;
import jp.go.aist.six.oval.process.OvalProcessStatus;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;




/**
 * Generates OVAL definitions dedicated to CentOS by transforming
 * the ones for Red Hat Enterprise Linux.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class CentOSOvalGenerator
extends OvalGenerator
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( CentOSOvalGenerator.class );




    /**
     * Status attributes.
     */
    public static class Attribute
    {
        public static final String  SOURCE_DEFINITION_LOCATION = "generator.centos.source";
    }
    //Attribute



    /**
     * The XSLT stylesheet.
     */
    private static final String  _XSLT_RESOURCE_
    = "/jp/go/aist/six/oval/process/centos/oval-rhel2centos.xsl";



    /**
     * The runtime representation of the stylesheet.
     */
    private static Templates  _TEMPLATES = null;



    /**
     */
    private String  _sourceRedhatDefinitionLocation;



    /**
     * Constructor.
     */
    public CentOSOvalGenerator()
    {
    }



    /**
     * Constructor.
     */
    public CentOSOvalGenerator(
                    final File sourceDefFile
                    )
    {
        setSourceRedhatDefinitionLocation( sourceDefFile.getAbsolutePath());
    }


    /**
     * Constructor.
     */
    public CentOSOvalGenerator(
                    final String sourceDefLocation
                    )
    {
        setSourceRedhatDefinitionLocation( sourceDefLocation );
    }



    /**
     */
    public void setSourceRedhatDefinitionLocation(
                    final String location
                    )
    {
        _sourceRedhatDefinitionLocation = location;
    }


    /**
     */
    public String getSourceRedhatDefinitionLocation()
    {
        return _sourceRedhatDefinitionLocation;
    }



    /**
     */
    private Source _getSource(
                    final OvalProcessStatus status
                    )
    {
        String  inputLocation = getSourceRedhatDefinitionLocation();
        if (inputLocation == null) {
            status.setError( true );
            status.setErrorMessage( "NO input OVAL Definition document specifed" );
            return null;
        }

        Source  source = null;
        if (inputLocation.startsWith( "http:" )
                        ||  inputLocation.startsWith( "https:" )
                        ||  inputLocation.startsWith( "file:" )) {
            source = new StreamSource( inputLocation );
            status.setAttribute( Attribute.SOURCE_DEFINITION_LOCATION, inputLocation );
        } else {
            File  file = new File( inputLocation );
            if (file.exists()  &&  file.isFile()  &&  file.canRead()) {
                source = new StreamSource( file );
                status.setAttribute( Attribute.SOURCE_DEFINITION_LOCATION,
                                file.getAbsolutePath() );
            } else {
                status.setError( true );
                status.setErrorMessage(
                                "input OVAL Definition document NOT found or access prohibited: "
                                + inputLocation );
                return null;
            }
        }

        return source;
    }



    /**
     */
    private Result _getResult(
                    final OvalProcessStatus status
                    )
    {
        String  outputLocation = getOutputDefinitionLocation();
        if (outputLocation == null) {
            outputLocation = DEFAULT_OUTPUT_DEFINITION_LOCATION;
        }

        File  file = new File( outputLocation );
        status.setAttribute( OvalGenerator.Attribute.OUTPUT_DEFINITION_LOCATION,
                        file.getAbsolutePath() );

        return (new StreamResult( file ) );
    }



    /**
     * Creates a new JAXP Transformer.
     * If there are parameters specified,
     * they are passed to the Transformer.
     *
     * @return
     *  a new JAXP Transformer.
     * @throws  TransformerConfigurationException
     *  if the creation of a Transformer object fails.
     * @throws  IOException
     *  if an IO error occurs to the stylesheet.
     */
    private Transformer _newTransformer()
    throws TransformerConfigurationException, IOException
    {
        Transformer  transformer = _getTemplates().newTransformer();
                                                   //throws TransformerConfigurationException

        return transformer;
    }



    /**
     * Returns a Templates object, i.e. a compiled XSLT stylesheet
     * of the specified URL.
     * Once the stylesheet is loaded, it is cached for the next time.
     * That is, firstly, the cache is searched for the URL.
     *
     * @param   stylesheet
     *  the URL of the stylesheet.
     * @return
     *  a Templates object.
     * @throws  TransformerConfigurationException
     *  if the loading of the XSLT stylesheet fails.
     * @throws  IOException
     *  if an IO error occurs to the stylesheet.
     */
    private static synchronized Templates _getTemplates()
    throws TransformerConfigurationException, IOException
    {
        if (_TEMPLATES != null) {
            return _TEMPLATES;
        }

        URL  url = CentOSOvalGenerator.class.getResource( _XSLT_RESOURCE_ );
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "RHEL2CentOS XSLT stylesheet URL: " + url );
        }

        InputStream  is = null;
        try {
            is = url.openStream();
                     //throws IOException

            _TEMPLATES = TransformerFactory.newInstance().newTemplates( new StreamSource( is ) );
                                                          //throws TransformerConfigurationException
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException io_ex) {
                // ignorable.
                if (_LOG.isWarnEnabled()) {
                    _LOG.warn( io_ex );
                }
            }
        }

        return _TEMPLATES;
    }



    //**************************************************************
    //  OvalGenerator
    //**************************************************************

    public OvalProcessStatus execute()
    {
        OvalProcessStatus  status = new OvalProcessStatus();

        Source  source = _getSource( status );
        if (status.isError()) {
            return status;
        }

        Result  result = _getResult( status );
        if (status.isError()) {
            return status;
        }

        try {
            Transformer  transformer = _newTransformer();
                                       //throws TransformerConfigurationException
                                       //throws IOException
            transformer.transform( source, result );
                        //throws TransformerException
        } catch (Exception ex) {
            status.buildError( ex );
            return status;
        }

        return status;
    }

}
// CentOSOvalGenerator

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

