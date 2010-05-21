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

package jp.go.aist.six.oval.model.definition;

import jp.go.aist.six.util.orm.Persistable;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: Reference.java 630 2010-04-20 08:15:01Z akihito $
 */
public class Reference
    implements Persistable
{

    private String  _source;
    //{xsd:string, required}

    private String  _refID;
    //{xsd:string, required}

    private String  _refURL;
    //{xsd:anyURI, optional}



    /**
     * Constructor.
     */
    public Reference()
    {
    }


    /**
     * Constructor.
     */
    public Reference(
                    final String source,
                    final String refID,
                    final String refURL
                    )
    {
        setSource( source );
        setReferenceID( refID );
        setReferenceURL( refURL );
    }



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



    public void setReferenceID(
                    final String id
                    )
    {
        _refID= id;
    }



    public String getReferenceID()
    {
        return _refID;
    }



    public void setReferenceURL(
                    final String url
                    )
    {
        _refURL = url;
    }



    public String getReferenceURL()
    {
        return _refURL;
    }



    //**************************************************************
    //  Castor JDO support
    //**************************************************************

//    /**
//     * A bidirectional link.
//     */
//    private Definition  _definition;
//
//
//    public void setDefinition( final Definition def )
//    {
//        _definition = def;
//    }
//
//
//    public Definition getDefinition()
//    {
//        return _definition;
//    }



    //**************************************************************
    //  Persistable
    //**************************************************************

    /**
     * The persistent identifier.
     */
    private  String  _persistentID;


    public void setPersistentID(
                    final String id
                    )
    {
        _persistentID = id;
    }


    public String getPersistentID()
    {
        return _persistentID;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        String  source = getSource();
        result = prime * result + ((source == null) ? 0 : source.hashCode());

        String  id = getReferenceID();
        result = prime * result + ((id == null) ? 0 : id.hashCode());

//        String  url = getReferenceURL();
//        result = prime * result + ((url == null) ? 0 : url.hashCode());

        return result;
    }



    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Reference)) {
            return false;
        }

        Reference  other = (Reference)obj;
        String  other_id = other.getReferenceID();
        String   this_id =  this.getReferenceID();
        if (this_id == other_id
                        ||  (this_id != null  &&  this_id.equals( other_id ))) {
            String  other_source = other.getSource();
            String   this_source =  this.getSource();
            if (this_source == other_source
                            ||  (this_source != null  &&  this_source.equals( other_source ))) {
                return true;
            }
        }

        return false;
    }



    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Reference[source=" + getSource()
                        + ", ref_id=" + getReferenceID()
                        + ", ref_url=" + getReferenceURL()
                        + "]";
    }

}
// Reference
