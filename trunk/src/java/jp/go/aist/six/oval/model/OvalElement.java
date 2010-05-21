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

package jp.go.aist.six.oval.model;

import jp.go.aist.six.util.orm.Persistable;



/**
 * An OVAL entity or an analysis result.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id: OvalElement.java 635 2010-04-20 09:29:15Z akihito $
 */
public abstract class OvalElement
    implements Persistable
{

    private String  _ovalID;
    //{oval:DefinitionIDPattern, required}

    private int  _ovalVersion;
    //{xsd:nonNegativeInteger, required}



    /**
     * Constructor.
     */
    public OvalElement()
    {
    }


    /**
     * Constructor.
     */
    public OvalElement(
                    final String id,
                    final int version
                    )
    {
        setOvalID( id );
        setOvalVersion( version );
    }



    public void setOvalID(
                    final String id
                    )
    {
        _ovalID = id;
    }


    public String getOvalID()
    {
        return _ovalID;
    }



    public
    void setOvalVersion(
                    final int version
                    )
    {
        _ovalVersion = version;
    }


    public int getOvalVersion()
    {
        return _ovalVersion;
    }



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

        String  id = getOvalID();
        result = prime * result + ((id == null) ? 0 : id.hashCode());

        result = prime * result + getOvalVersion();

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

        if (!(obj instanceof OvalElement)) {
            return false;
        }

        OvalElement  other = (OvalElement)obj;
        String  other_id = other.getOvalID();
        String   this_id =  this.getOvalID();
        if (this_id == other_id
                        ||  (this_id != null  &&  this_id.equals( other_id ))) {
            if (this.getOvalVersion() == other.getOvalVersion()) {
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
        return "id=" + getOvalID()
                + ", version=" + getOvalVersion();
    }

}
// OvalElement
