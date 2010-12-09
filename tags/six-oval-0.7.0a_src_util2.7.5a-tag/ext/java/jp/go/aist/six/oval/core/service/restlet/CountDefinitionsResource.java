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

import jp.go.aist.six.oval.model.definitions.Definition;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restlet.Context;
import org.restlet.data.MediaType;
import org.restlet.data.Request;
import org.restlet.data.Response;
import org.restlet.data.Status;
import org.restlet.resource.Representation;
import org.restlet.resource.ResourceException;
import org.restlet.resource.StringRepresentation;
import org.restlet.resource.Variant;
import java.io.PrintWriter;
import java.io.StringWriter;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class CountDefinitionsResource
    extends BaseResource
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( CountDefinitionsResource.class );




    /**
     * Constructor.
     */
    public CountDefinitionsResource(
                    final Context context,
                    final Request request,
                    final Response response
                    )
    {
        super( context, request, response );

        getVariants().add( new Variant(MediaType.APPLICATION_XML) );
    }



    //**************************************************************
    //  Resource
    //**************************************************************

    // GET:
    @Override
    public Representation represent(
                    final Variant variant
                    )
    throws ResourceException
    {
        Representation  rep = null;
        try {
            int  count = _getOvalStore().countAll( Definition.class );
//            int  count = 100;
            getResponse().setStatus( Status.SUCCESS_OK );
            rep = new StringRepresentation( String.valueOf( count ), MediaType.TEXT_PLAIN );
        } catch (Exception ex) {
            if (_LOG.isWarnEnabled()) {
                _LOG.warn( ex );
                StringWriter  s = new StringWriter();
                ex.printStackTrace( new PrintWriter( s ) );
                _LOG.warn( s.toString() );
            }
            getResponse().setStatus( Status.SERVER_ERROR_INTERNAL );
            rep = new StringRepresentation(
                    "there was an error",
                    MediaType.TEXT_PLAIN );
        }

        getResponse().setEntity( rep );

        return rep;
    }

}
// OvalResultsResource

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

