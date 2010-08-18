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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.restlet.Context;
import org.restlet.data.Form;
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
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( OvalResultsResource.class );



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
    }



    //**************************************************************
    //  Resource
    //**************************************************************

    @Override
    public boolean allowPost()
    {
        return true;
    }



    // POST: create a new OvalResults, return the ID
    @Override
    public void acceptRepresentation(
                    final Representation entity
                    )
    throws ResourceException
    {
        Form  form = new Form( entity );
        String  xml = form.getFirstValue( "oval_results" );
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "content XML: length=" + xml.length() );
//          _LOG.trace( "content XML: " + xml );
        }

        Representation  rep = null;
        try {
            OvalResults  results = (OvalResults)_getOvalXml().unmarshalFromString( xml );
            String  pid = _getOvalStore().create( OvalResults.class, results );
            if (_LOG.isInfoEnabled()) {
                _LOG.info( "OVAL Results created: PID=" + pid );
            }
            getResponse().setStatus( Status.SUCCESS_CREATED );
            rep = new StringRepresentation( pid, MediaType.TEXT_PLAIN );
            rep.setIdentifier( getRequest().getResourceRef().getIdentifier()
                            + "/" + pid );
        } catch (Exception ex) {
            if (_LOG.isWarnEnabled()) {
                _LOG.warn( ex );
            }
            getResponse().setStatus( Status.SERVER_ERROR_INTERNAL );
            rep = new StringRepresentation(
                    "there was an error creating OvalResults",
                    MediaType.TEXT_PLAIN );
        }

        getResponse().setEntity( rep );
    }

}
// OvalResultsResource

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

