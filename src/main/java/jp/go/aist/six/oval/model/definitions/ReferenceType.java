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

package jp.go.aist.six.oval.model.definitions;

import jp.go.aist.six.oval.model.v5.Oval5Object;



/**
 * A link from the OVAL Definition to a definitive external reference.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class ReferenceType
    implements Oval5Object
{

    private String  source;
    //{required}


    private String  ref_id;
    //{required}


    private String  ref_url;
    //{optional, xsd:anyURI}



    /**
     * Constructor.
     */
    public ReferenceType()
    {
    }


    public ReferenceType(
                    final String source,
                    final String ref_id
                    )
    {
        this( source, ref_id, null );
    }


    public ReferenceType(
                    final String source,
                    final String ref_id,
                    final String ref_url
                    )
    {
        setSource( source );
        setRefID( ref_id );
        setRefURL( ref_url );
    }



    /**
     */
    public void setSource(
                    final String source
                    )
    {
        this.source = source;
    }


    public String getSource()
    {
        return this.source;
    }



    /**
     */
    public void setRefID(
                    final String ref_id
                    )
    {
        this.ref_id = ref_id;
    }


    public String getRefID()
    {
        return this.ref_id;
    }



    /**
     */
    public void setRefURL(
                    final String ref_url
                    )
    {
        this.ref_url = ref_url;
    }


    public String getRefURL()
    {
        return this.ref_url;
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
