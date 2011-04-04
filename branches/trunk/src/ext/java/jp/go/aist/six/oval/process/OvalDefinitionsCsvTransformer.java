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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;




/**
 * This transformer generates a CSV that represents an OVAL definitions.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalDefinitionsCsvTransformer
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( OvalDefinitionsCsvTransformer.class );



    /**
     * The XSLT stylesheet.
     */
    private static final String  _XSLT_RESOURCE_
    = "/jp/go/aist/six/oval/process/oval2csv.xsl";



    /**
     * The runtime representation of the stylesheet.
     */
    private static Templates  _TEMPLATES = null;



    /**
     *
     */
    private Source  _source;




    /**
     * Constructor.
     */
    public
    OvalDefinitionsCsvTransformer()
    {
    }



    /**
     */
    public
    void setSource( final Source source )
    throws IOException
    {
//        if (_LOG.isTraceEnabled()) {
//            _LOG.trace( "source: " + source );
//        }

        _source = source;
    }



    /**
     */
    public
    void setSource( final File file )
    throws IOException
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "source file: " + file );
        }

        BufferedReader  reader = new BufferedReader( new FileReader( file ) );
                                                     //throws FileNotFoundException
        _source = new StreamSource( reader );
    }



    /**
     *
     */
    public
    void setSource( final URL url )
    throws IOException
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "source URL: " + url );
        }

        BufferedReader  reader = new BufferedReader( new InputStreamReader( url.openStream() ) );
                                                                            //throws IOException
        _source = new StreamSource( reader );
    }



    /**
     */
    public
    void transform( final Result result )
    throws Exception
    {
        if (_source == null) {
            throw new IllegalStateException( "source is not specified yet" );
        }

        Transformer  transformer = _newTransformer();
                                   //throws TransformerConfigurationException
                                   //throws IOException
        transformer.transform( _source, result );
                    //throws TransformerException
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
    private
    Transformer _newTransformer()
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
    private static synchronized
    Templates _getTemplates()
    throws TransformerConfigurationException, IOException
    {
        if (_TEMPLATES != null) {
            return _TEMPLATES;
        }

        URL  url = OvalDefinitionsCsvTransformer.class.getResource( _XSLT_RESOURCE_ );
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "XSLT stylesheet URL: " + url );
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

}
// OvalDefinitionsCsvTransformer

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

