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

package jp.go.aist.six.oval.core.interpreter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class FileIOHelper
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( FileIOHelper.class );



    /**
     * Constructor.
     */
    public FileIOHelper()
    {
    }



    /**
     * Reads data from the specified input stream and
     * writes them to the specified output stream.
     *
     * @return
     *  the size written to the output.
     */
    private static long _io(
                    final InputStream instream,
                    final OutputStream outstream
                    )
    throws IOException
    {
        BufferedInputStream  bin = new BufferedInputStream( instream );
        BufferedOutputStream  bout = new BufferedOutputStream( outstream );

        byte[]  buffer = new byte[512];
        long  totalSize = 0;
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
        }

        return totalSize;
    }



//    private static int _io(
//                    final Reader reader,
//                    final Writer writer
//                    )
//    throws IOException
//    {
//        char[]  buffer = new char[512];
//        int  totalSize = 0;
//        try {
//            while (true) {
//                int  n = reader.read( buffer );
//                                //@throws IOException
//                if (n == -1) {
//                    break;
//                }
//                writer.write( buffer, 0, n );
//                       //@throws IOException
//                totalSize += n;
//            }
//        } finally {
//            try {
//                reader.close();
//            } catch (Exception ex) {
//                //ignorable
//            }
//            try {
//                writer.close();
//            } catch (Exception ex) {
//                //ignorable
//            }
//        }
//
//        return totalSize;
//    }



    /**
     */
    public static long write(
                    final InputStream instream,
                    final File file
                    )
    throws IOException
    {
        _LOG_.debug( "write file=" + file );

        long  size = 0L;
        OutputStream  outstream = null;
        try {
            outstream = new FileOutputStream( file );
            size = _io( instream, outstream );
        } finally {
            try {
                outstream.close();
            } catch (Exception ex) {
                //ignorable
            }
        }

        _LOG_.debug( "write file finished: size=" + size );
        return size;
    }



    /**
     */
    public static long read(
                    final File file,
                    final OutputStream outstream
                    )
    throws IOException
    {
        _LOG_.debug( "read file: " + file );

        long  size = 0L;
        InputStream  instream = null;
        try {
            instream = new FileInputStream( file );
            size = _io( instream, outstream );
        } finally {
            try {
                instream.close();
            } catch (Exception ex) {
                //ignorable
            }
        }

        _LOG_.debug( "read file finished: size=" + size );
        return size;
    }

}
// FileIOHelper

