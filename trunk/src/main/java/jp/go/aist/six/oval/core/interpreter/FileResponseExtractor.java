/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.go.aist.six.oval.core.interpreter;

import java.io.File;
import java.io.IOException;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseExtractor;



/**
 * This utility writes an HTTP response body to a file.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class FileResponseExtractor
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
    protected FileResponseExtractor()
    {
    }


    public FileResponseExtractor(
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

