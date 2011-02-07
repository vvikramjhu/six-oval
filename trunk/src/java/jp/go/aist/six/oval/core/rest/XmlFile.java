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

package jp.go.aist.six.oval.core.rest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class XmlFile
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( XmlFile.class );



    /**
     * Constructor.
     */
    public XmlFile()
    {
    }



    /**
     * @return
     */
    private static int _io(
                    final InputStream instream,
                    final OutputStream outstream
                    )
    throws IOException
    {
        BufferedInputStream  bin = new BufferedInputStream( instream );
        BufferedOutputStream  bout = new BufferedOutputStream( outstream );

        byte[]  buffer = new byte[512];
        int  totalSize = 0;
        try {
            while (true) {
                int  n = bin.read( buffer );
                             //@throws IOException
                if (n == -1) {
                    break;
                }
                bout.write( buffer, 0, n );
                     //@throws IOException
                totalSize += n;
            }
        } finally {
            try {
                bout.flush();
            } catch (Exception ex) {
                //ignorable
            }
            try {
                bout.close();
            } catch (Exception ex) {
                //ignorable
            }
            try {
                bin.close();
            } catch (Exception ex) {
                //ignorable
            }
        }

        return totalSize;
    }



    /**
     * @return
     */
    private static int _io(
                    final Reader reader,
                    final Writer writer
                    )
    throws IOException
    {
        char[]  buffer = new char[512];
        int  totalSize = 0;
        try {
            while (true) {
                int  n = reader.read( buffer );
                                //@throws IOException
                if (n == -1) {
                    break;
                }
                writer.write( buffer, 0, n );
                       //@throws IOException
                totalSize += n;
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

        return totalSize;
    }



    /**
     */
    public static int write(
                    final InputStream instream,
                    final File file
                    )
    throws IOException
    {
        _LOG_.debug( "writing response: file=" + file );

        return _io( instream, (new FileOutputStream( file )) );
    }
//    {
//        _LOG_.debug( "writing response: file=" + file );
//
//        Reader  reader = new BufferedReader( new InputStreamReader( instream ) );
//        Writer  writer = new BufferedWriter( new FileWriter( file ) );
//        _io( reader, writer );
//    }



    /**
     */
    public static int read(
                    final File file,
                    final OutputStream outstream
                    )
    throws IOException
    {
        _LOG_.debug( "reading request: file=" + file );

        return _io( (new FileInputStream( file )), outstream );
    }
//    {
//        _LOG_.debug( "writing response: file=" + file );
//
//        Reader  reader = new BufferedReader( new FileReader( file ) );
//        Writer  writer = new BufferedWriter( new OutputStreamWriter( outstream ) );
//        _io( reader, writer );
//    }

}
// FileResponseExtractor

