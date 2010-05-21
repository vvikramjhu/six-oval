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

package jp.go.aist.six.oval.core.service.restlet;

import jp.go.aist.six.oval.service.OvalStore;
import jp.go.aist.six.oval.service.OvalXml;
import org.restlet.Context;
import org.restlet.data.MediaType;
import org.restlet.data.Request;
import org.restlet.data.Response;
import org.restlet.data.Status;
import org.restlet.resource.DomRepresentation;
import org.restlet.resource.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.IOException;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: BaseResource.java 440 2010-03-23 05:11:44Z akihito $
 */
public abstract class BaseResource
    extends Resource
{

    /**
     * Constructor.
     */
    public BaseResource(
                    final Context context,
                    final Request request,
                    final Response response
                    )
    {
        super( context, request, response );
    }




    /**
     *
     */
    protected OvalStore _getOvalStore()
    throws Exception
    {
        return ((OvalApplication)getApplication())._getOvalStore();
    }


    protected OvalXml _getOvalXml()
    throws Exception
    {
        return ((OvalApplication)getApplication())._getOvalXml();
    }



    /**
     *
     */
    protected void _generateErrorRepresentation(
                    final Response response,
                    final String message,
                    final String code
                    )
    {
        response.setStatus( Status.CLIENT_ERROR_NOT_FOUND );

        try {
            DomRepresentation  rep = new DomRepresentation( MediaType.TEXT_XML );
            Document  doc = rep.getDocument();

            Element  code_el = doc.createElement( "code" );
            code_el.appendChild( doc.createTextNode( code ) );

            Element  message_el = doc.createElement( "message" );
            message_el.appendChild( doc.createTextNode( message ) );

            Element  error_el = doc.createElement( "error" );
            error_el.appendChild( code_el );
            error_el.appendChild( message_el );

            response.setEntity( rep );
        } catch (IOException io_ex) {
            //TODO:
        }
    }

}
// BaseResource

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

