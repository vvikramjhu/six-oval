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

package jp.go.aist.six.oval.model.v5;

import com.google.code.morphia.annotations.Transient;




/**
 * An OVAL entity or an object to refer an entity.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class OvalElement
//    extends AbstractOvalObject
    implements Comparable<OvalElement>
{

    private String  oval_id;
    //{required, oval:DefinitionIDPattern}

    private int  oval_version;
    //{required, xsd:nonNegativeInteger}


    /**
     * ovalID + ":" + ovalVersion
     */
    @Transient
    private transient String  _ovalGlobalRef;



    /**
     * Constructor.
     */
    public OvalElement()
    {
    }


    /**
     * Constructor.
     *
     * @param   id
     *  the OVAL-ID of the entity.
     * @param   version
     *  the version of the entity.
     */
    public OvalElement(
                    final String id,
                    final int version
                    )
    {
        setOvalID( id );
        setOvalVersion( version );
    }



    /**
     * Sets the OVAL-ID.
     *
     * @param   id
     *  the OVAL-ID.
     */
    public void setOvalID(
                    final String id
                    )
    {
        this.oval_id = id;
    }


    /**
     * Retuens the OVAL-ID.
     *
     * @return
     *  the OVAL-ID.
     */
    public String getOvalID()
    {
        return this.oval_id;
    }



    /**
     * Sets the version.
     *
     * @param   version
     *  the version.
     */
    public void setOvalVersion(
                    final int version
                    )
    {
        if (version < 0) {
            throw new IllegalArgumentException(
                            "negative version: " + version );
        }
        this.oval_version = version;
    }


    /**
     * Returns the version.
     *
     * @return
     *  the version.
     */
    public int getOvalVersion()
    {
        return this.oval_version;
    }



    /**
     */
    public static final String globalRefOf(
                    final OvalElement e
                    )
    {
        if (e == null) {
            throw new IllegalArgumentException( "null element" );
        }

        return globalRefOf( e.getOvalID(), e.getOvalVersion() );
    }


    public static final String globalRefOf(
                    final String id,
                    final int version
                    )
    {
        if (id == null || id.length() == 0) {
            throw new IllegalArgumentException( "null or empty ovalID" );
        }

        return id + ":" + version;
    }



    /**
     */
    public final void ovalSetGlobalRef(
                    final String gid
                    )
    {
        _ovalGlobalRef = gid;
    }


    public final String ovalGetGlobalRef()
    {
        if (_ovalGlobalRef == null) {
            _ovalGlobalRef = globalRefOf( this );
        }

        return _ovalGlobalRef;
    }



    //**************************************************************
    //  Comparable
    //**************************************************************

    @Override
    public int compareTo(
                    final OvalElement o
                    )
    {
        String  id1 = getOvalID();
        String  id2 = o.getOvalID();
        int  order = id1.compareTo( id2 );
        if (order != 0) {
            return order;
        }

        int  version1 = getOvalVersion();
        int  version2 = o.getOvalVersion();
        return (version1 - version2);
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

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



    @Override
    public String toString()
    {
        return "id=" + getOvalID()
                + ", version=" + getOvalVersion();
    }

}
// OvalElement
