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

package jp.go.aist.six.oval.interpreter;

import java.io.File;
import java.io.IOException;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseExtractor;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class XmlFileResponseExtractor
    implements ResponseExtractor<File>
{

//    /**
//     * Logger.
//     */
//    private static final Logger  _LOG_ =
//        LoggerFactory.getLogger( XmlFileResponseExtractor.class );



    /**
     * The file to which the HTTP response body is written.
     */
    private File  _file;



    /**
     * Constructor.
     */
    protected XmlFileResponseExtractor()
    {
    }


    public XmlFileResponseExtractor(
                    final File file
                    )
    {
        _file = file;
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
        FileIOHelper.write( response.getBody(), _file );

        return _file;
    }

}
// FileResponseExtractor

