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

import jp.go.aist.six.oval.model.results.OvalResults;
import org.restlet.Context;
import org.restlet.data.MediaType;
import org.restlet.data.Request;
import org.restlet.data.Response;
import org.restlet.data.Status;
import org.restlet.resource.Representation;
import org.restlet.resource.ResourceException;
import org.restlet.resource.StringRepresentation;
import org.restlet.resource.Variant;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalResultsResource
    extends BaseResource
{

    /**
     *
     */
    private String  _pid;



    /**
     * Constructor.
     */
    public OvalResultsResource(
                    final Context context,
                    final Request request,
                    final Response response
                    )
    {
        super( context, request, response );

        getVariants().add( new Variant(MediaType.APPLICATION_XML) );
        _pid = (String)getRequest().getAttributes().get( "id" );
    }



    //**************************************************************
    //  Resource
    //**************************************************************

    @Override
    public boolean allowPost()
    {
        return true;
    }



    // GET:
    @Override
    public Representation represent(
                    final Variant variant
                    )
    throws ResourceException
    {
        Representation  rep = null;
        try {
            OvalResults  object = _getOvalStore().get( OvalResults.class, _pid );
            String  xml = _getOvalXml().marshalToString( object );
            rep = new StringRepresentation( xml );
        } catch (Exception ex) {
            getResponse().setStatus( Status.SERVER_ERROR_INTERNAL );
            rep = new StringRepresentation(
                    "there was an error: " + ex.getMessage(),
                    MediaType.TEXT_PLAIN );
        }

        getResponse().setEntity( rep );

        return rep;
    }

}
// OvalResultsResource

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

