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

package jp.go.aist.six.oval.model.v5.definitions;

import jp.go.aist.six.oval.model.v5.AbstractOvalObject;



/**
 * A link from the OVAL Definition to a definitive external reference.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class ReferenceType
    extends AbstractOvalObject
{

    private String  _source;
    //{required}


    private String  _refID;
    //{required}


    private String  _refURL;
    //{optional, xsd:anyURI}



    /**
     * Constructor.
     */
    public ReferenceType()
    {
    }


//    public ReferenceType(
//                    final String source,
//                    final String refID
//                    )
//    {
//        setSource( source );
//        setRefID( refID );
//    }
//
//
//    public ReferenceType(
//                    final String source,
//                    final String refID,
//                    final String refURL
//                    )
//    {
//        this( source, refID );
//        setRefURL( refURL );
//    }



    /**
     */
    public void setSource(
                    final String source
                    )
    {
        _source = source;
    }


    public String getSource()
    {
        return _source;
    }



    /**
     */
    public void setRefID(
                    final String id
                    )
    {
        _refID = id;
    }


    public String getRefID()
    {
        return _refID;
    }



    /**
     */
    public void setRefURL(
                    final String url
                    )
    {
        _refURL = url;
    }


    public String getRefURL()
    {
        return _refURL;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        String  source = getSource();
        result = prime * result + ((source == null) ? 0 : source.hashCode());

        String  id = getRefID();
        result = prime * result + ((id == null) ? 0 : id.hashCode());

//        String  url = getReferenceURL();
//        result = prime * result + ((url == null) ? 0 : url.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ReferenceType)) {
            return false;
        }

        ReferenceType  other = (ReferenceType)obj;
        String  other_id = other.getRefID();
        String   this_id =  this.getRefID();
        if (this_id == other_id
                        ||  (this_id != null
                                        &&  this_id.equals( other_id ))) {
            String  other_source = other.getSource();
            String   this_source =  this.getSource();
            if (this_source == other_source
                            ||  (this_source != null
                                            &&  this_source.equals( other_source ))) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "[source=" + getSource()
                        + ", ref_id=" + getRefID()
                        + ", ref_url=" + getRefURL()
                        + "]";
    }

}
// ReferenceType
