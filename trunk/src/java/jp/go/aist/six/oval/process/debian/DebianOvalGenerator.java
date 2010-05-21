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

package jp.go.aist.six.oval.process.debian;

import jp.go.aist.six.oval.model.definition.OvalDefinitions;
import jp.go.aist.six.oval.process.OvalGenerator;
import jp.go.aist.six.oval.process.OvalProcessStatus;
import jp.go.aist.six.oval.process.debian.builder.DebianOvalBuilder;
import jp.go.aist.six.oval.process.debian.dsa.Dsa;
import jp.go.aist.six.oval.process.debian.dsa.DsaParser;
import jp.go.aist.six.oval.service.Oval;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;




/**
 * Generates OVAL Definitions dedicated to Debian GNU/Linux.
 * The Debian Security Advisory pages are transformed to Definition documents.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: DebianOvalGenerator.java 521 2010-04-07 01:20:21Z akihito $
 * @see <a href="http://www.debian.org/security/index.en.html">Debian Security Information</a>
 */
public class DebianOvalGenerator
extends OvalGenerator
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( DebianOvalGenerator.class );


    public static class Attribute
    {
        public static final String  DSA_LOCATION = "dsa";
        public static final String  OVAL_DEFINITIONS_FILEPATH = "oval_definitions.filepath";
    }



    /**
     * The location of the DSA from which an OVAL Definition document is generated.
     */
    private String  _dsaLocation;



    /**
     * Constructor.
     */
    public DebianOvalGenerator()
    {
    }



    /**
     * Constructor.
     */
    public DebianOvalGenerator(
                    final String sourceDsaLocation
                    )
    {
        setSourceDsaLocation( sourceDsaLocation );
    }




    /**
     */
    public void setSourceDsaLocation(
                    final String location
                    )
    {
        _dsaLocation = location;
    }


    public String getSourceDsaLocation()
    {
        return _dsaLocation;
    }



    /**
     * default:
     *   "http://www.debian.org/security/2010/dsa-1974.en.html"
     *     ==> ovalfiles/dsa-1974.en.html_definitions.xml
     *   "dsa-1974.en.html"
     *     ==> ovalfiles/dsa-1974.en.html_definitions.xml
     */
    private OutputStream _getDefinitionOutputStream(
                    final OvalProcessStatus status
                    )
    {
        String  dsaLocation = getSourceDsaLocation();
        String  filepath = getOutputDefinitionLocation();
        if (filepath == null) {
            final String  pattern = "/";
            final String[]  tokens = dsaLocation.split( pattern );
            String  dsaFilepath = tokens[tokens.length - 1];
            if (dsaFilepath == null  ||  dsaFilepath.length() == 0) {
                dsaFilepath = "definitions.xml";
            }
            File  ovalfilesDir = new File( "ovalfiles" );
            if (ovalfilesDir.exists()  &&  ovalfilesDir.isDirectory()) {
                filepath = "ovalfiles/" + dsaFilepath + "_definitions.xml";
            } else {
                filepath = dsaFilepath;
            }
        }

        File  file = new File( filepath );
        final String  absFilepath = file.getAbsolutePath();
        if (_LOG.isDebugEnabled()) {
            _LOG.debug( "output OVAL definitions location...: file="
                            + absFilepath );
        }
        status.setAttribute( Attribute.OVAL_DEFINITIONS_FILEPATH, absFilepath );

        OutputStream  stream = null;
        try {
            stream = new FileOutputStream( file );
                     //@throws IOException (FileNotFoundException)
        } catch (Exception ex) {
            status.buildError( ex );
        }

        return stream;
    }



    /**
     */
    private void _saveDefinitionDocument(
                    final OvalDefinitions oval,
                    final OvalProcessStatus status
                    )
    {
        OutputStream  outStream = null;
        try {
            outStream = _getDefinitionOutputStream( status );
            if (! status.isError()) {
                Oval.getXml().marshal( oval, outStream );
                              //@throws OxmException
            }
        } catch (Exception ex) {
            status.buildError( ex );
        } finally {
            try {
                if (outStream != null) {
                    outStream.close();
                }
            } catch (Exception ex) {
                //negligible
            }
        }

        if (status.isError()) {
            return;
        }
    }



    /**
     */
    private InputStream _getDsaInputStream(
                    final OvalProcessStatus status
                    )
    throws MalformedURLException, IOException
    {
        String  location = getSourceDsaLocation();
        if (location == null) {
            throw new IllegalStateException(
                            "no input DSA location specified." );
        }

        status.setAttribute( Attribute.DSA_LOCATION, location );

        InputStream  stream = null;
        if (location.startsWith( "http://" )
                        ||  location.startsWith( "https://" )
                        ||  location.startsWith( "file://" )) {
            if (_LOG.isDebugEnabled()) {
                _LOG.debug( "opening DSA stream...: URL=" + location );
            }
            try {
                URL  url = new URL( location );
                           //@throws MalformedURLException
                stream = url.openStream();
                             //@throws IOException
            } catch (Exception ex) {
                status.buildError( ex );
            }
        } else {
            if (_LOG.isDebugEnabled()) {
                _LOG.debug( "opening DSA stream...: file=" + location );
            }
            File  file = new File( location );
            try {
                stream = new FileInputStream( file );
                         //@throws IOException (FileNotFoundException)
                status.setAttribute( "dsa", file.getAbsolutePath() );
            } catch (Exception ex) {
                status.buildError( ex );
            }
        }

        return stream;
    }



    /**
     *
     */
    private OvalDefinitions _parseDsa(
                    final OvalProcessStatus status
                    )
    {
        InputStream  inStream = null;
        Dsa  dsa = null;
        try {
            inStream = _getDsaInputStream( status );
            if (! status.isError()) {
                DsaParser  parser = new DsaParser();
                dsa = parser.parse( inStream );
                             //@throws DsaException, IOException
            }
        } catch (Exception ex) {
            status.buildError( ex );
        } finally {
            try {
                if (inStream != null) {
                    inStream.close();
                }
            } catch (Exception ex) {
                //negligible
            }
        }

        if (status.isError()) {
            return null;
        }

        DebianOvalBuilder  builder = new DebianOvalBuilder();
        OvalDefinitions  oval = null;
        try {
            oval = builder.createOvalDefinitions( dsa );
                           //@throws OvalProcessException
        } catch (Exception ex) {
            status.buildError( ex );
        }

        return oval;
    }



    //**************************************************************
    //  OvalGenerator
    //**************************************************************

    public OvalProcessStatus execute()
    {
        OvalProcessStatus  status = new OvalProcessStatus();

        OvalDefinitions  oval = _parseDsa( status );
        if (status.isError()) {
            return status;
        }

        _saveDefinitionDocument( oval, status );

        return status;
    }

}
// DebianOvalGenerator

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

