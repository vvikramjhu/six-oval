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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseExtractor;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class FileResponseExtractor
    implements ResponseExtractor<File>
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( FileResponseExtractor.class );



    /**
     * The file to which the HTTP response body is written.
     */
    private File  _file;



    /**
     * Constructor.
     */
    protected FileResponseExtractor()
    {
    }


    public FileResponseExtractor(
                    final File file
                    )
    {
        _file = file;
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



    //**************************************************************
    //  ResponseExtractor<T>
    //**************************************************************

    @Override
    public File extractData(
                    final ClientHttpResponse response
                    )
    throws IOException
    {
        _LOG_.debug( "writing response: file=" + _file );

        Reader  reader = new BufferedReader( new InputStreamReader( response.getBody() ) );
        Writer  writer = new BufferedWriter( new FileWriter( _file ) );
        _io( reader, writer );

        return _file;
    }

}
// FileResponseExtractor

