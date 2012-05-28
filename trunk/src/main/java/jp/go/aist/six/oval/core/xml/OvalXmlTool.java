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

package jp.go.aist.six.oval.core.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.util.xml.OxmException;
import jp.go.aist.six.util.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalXmlTool
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( OvalXmlTool.class );



    public static void main(
                    final String[] args
                    )
    {
        _LOG_.debug( "args=" + Arrays.toString( args ) );
        if (args.length == 0 ) {
            System.exit( 0 );
        }

        final String cmd = args[0];
        _LOG_.debug( "cmd=" + cmd );

        OvalXmlTool  tool = new OvalXmlTool();
        if (cmd.equals( "-dump" )) {
            if (args.length == 2) {
                String  source = args[1];
                _LOG_.debug( "source=" + source );
                tool.dump( source );
            }
        } else {
            _LOG_.debug( "unknown command: " + cmd );
        }
    }




    private final XmlMapper  _mapper;



    /**
     * Constructor.
     */
    public OvalXmlTool()
    {
        _mapper = OvalContext.INSTANCE.getXmlMapper();
    }



    /**
     */
    public void dump(
                    final InputStream stream
                    )
    {
        Object  obj = unmarshal( stream );
        System.out.println( obj );
    }


    public void dump(
                    final String source
                    )
    {
        InputStream  stream = null;

        if (source.startsWith( "http://" )  ||  source.startsWith( "https://" )) {
            try {
                URL  url = new URL( source );
                stream = url.openStream();
            } catch (MalformedURLException m_ex) {
                throw new OxmException( m_ex );
            } catch (IOException io_ex) {
                throw new OxmException( io_ex );
            }

        } else {
            File  file = new File( source );
            if (file.exists()  &&  file.canRead()) {
                try {
                    stream = new FileInputStream( file );
                } catch (FileNotFoundException io_ex) {
                    throw new OxmException( io_ex );
                }
            } else {
                throw new OxmException( "no such file: " + source );
            }
        }

        dump( stream );
    }



    //**************************************************************
    //  XmlMapper
    //**************************************************************


    public Object unmarshal(
                    final InputStream stream
                    )
    throws OxmException
    {
        return _mapper.unmarshal( stream );
    }



    public Object unmarshal(
                    final File file
                    )
    throws OxmException
    {
        InputStream  stream = null;
        try {
            stream = new FileInputStream( file );
        } catch (FileNotFoundException ex) {
            throw new OxmException( ex );
        }

        return unmarshal( stream );
    }

}
//

