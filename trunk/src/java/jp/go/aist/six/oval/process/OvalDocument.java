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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalDocument
{

    /**
     * Constructor.
     */
    public OvalDocument()
    {
    }



    /**
     */
    public static void write(
                    final Reader reader,
                    final File file
                    )
    throws IOException
    {
        Reader  bufferedReader = reader;
        if (bufferedReader instanceof BufferedReader) {
        } else {
            bufferedReader = new BufferedReader( reader );
        }

        Writer  bufferedWriter = new BufferedWriter( new FileWriter( file ) );

        _io( bufferedReader, bufferedWriter );
    }



    public static void read(
                    final Writer writer,
                    final File file
                    )
    throws IOException
    {
        Reader  bufferedReader = new BufferedReader( new InputStreamReader(
                        new FileInputStream( file ), Charset.forName( "UTF-8" ) ) );
        // The character set should be specified to parse XML
        // containing Japanese characters.

        Writer  bufferedWriter = writer;
        if (bufferedWriter instanceof BufferedWriter) {
        } else {
            bufferedWriter = new BufferedWriter( writer );
        }
        _io( bufferedReader, bufferedWriter );
    }



    /**
     */
    private static void _io(
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

}
// OvalDocument

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

