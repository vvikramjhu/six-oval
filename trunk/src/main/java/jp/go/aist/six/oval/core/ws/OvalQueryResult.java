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

package jp.go.aist.six.oval.core.ws;

import java.io.Serializable;
import java.util.Date;



/**
 * A helper class for feeds.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalQueryResult
    implements Serializable
{

    private Date  _timestamp;
    //{1..1}

    private OvalQueryResultElements  _elements;


    private OpenSearchResponse  _openSearchResponse;


//    private final List<AtomLink>  _link = new ArrayList<AtomLink>();
//    //{0..*}




    /**
     * Constructor.
     */
    public OvalQueryResult()
    {
    }



    /**
     */
    public void setTimestamp(
                    final Date timestamp
                    )
    {
        this._timestamp = timestamp;
    }


    public Date getTimestamp()
    {
        return _timestamp;
    }



    /**
     */
    public void setElements(
                    final OvalQueryResultElements elements
                    )
    {
        this._elements = elements;
    }


    public OvalQueryResultElements getElements()
    {
        return this._elements;
    }



    /**
     */
    public void setOpenSearchResponse(
                    final OpenSearchResponse osResponse
                    )
    {
        this._openSearchResponse = osResponse;
    }


    public OpenSearchResponse getOpenSearchResponse()
    {
        return this._openSearchResponse;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "OvalQueryResult[timestamp=" + getTimestamp()
             + ", " + getOpenSearchResponse()
             + ", elements=" + getElements()
             + "]"
             ;
    }

}
// OvalQueryResult
