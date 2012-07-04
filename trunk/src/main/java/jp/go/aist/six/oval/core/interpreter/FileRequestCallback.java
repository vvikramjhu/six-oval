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
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.web.client.RequestCallback;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class FileRequestCallback
    implements RequestCallback
{

//    /**
//     * Logger.
//     */
//    private static final Logger  _LOG_ =
//        LoggerFactory.getLogger( FileRequestCallback.class );



    /**
     * The file from which the HTTP request body is read.
     */
    private File  _file;


    /**
     * The media type of the file.
     */
    private MediaType  _contentType;



    /**
     * Constructor.
     */
    protected FileRequestCallback()
    {
    }


    public FileRequestCallback(
                    final File file,
                    final MediaType contentType
                    )
    {
        _file = file;
        _contentType = contentType;
    }



    //**************************************************************
    //  RequestCallback
    //**************************************************************

    @Override
    public void doWithRequest(
                    final ClientHttpRequest request
                    )
    throws IOException
    {
        HttpHeaders  headers = request.getHeaders();
        headers.setContentType( _contentType );
//        headers.setContentType( MediaType.APPLICATION_XML );

        long  size = FileIOHelper.read( _file, request.getBody() );
        headers.setContentLength( size );
    }

}
//FileRequestCallback

