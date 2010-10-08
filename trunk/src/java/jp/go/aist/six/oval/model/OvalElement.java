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

package jp.go.aist.six.oval.model;

import jp.go.aist.six.util.castor.AbstractPersistable;



/**
 * An OVAL entity or an object to refer an entity.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class OvalElement
    extends AbstractPersistable
    implements Comparable<OvalElement>
{

    private String  _ovalID;
    //{oval:DefinitionIDPattern, required}

    private int  _ovalVersion;
    //{xsd:nonNegativeInteger, required}


    /**
     * ovalID + ":" + ovalVersion
     */
    private transient String  _ovalGlobalID;



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
        _ovalID = id;
    }


    /**
     * Retuens the OVAL-ID.
     *
     * @return
     *  the OVAL-ID.
     */
    public String getOvalID()
    {
        return _ovalID;
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
        _ovalVersion = version;
    }


    /**
     * Returns the version.
     *
     * @return
     *  the version.
     */
    public int getOvalVersion()
    {
        return _ovalVersion;
    }



    /**
     */
    public static final String generateGlobalOvalID(
                    final OvalElement e
                    )
    {
        if (e == null) {
            throw new IllegalArgumentException( "null element" );
        }

        return generateGlobalOvalID( e.getOvalID(), e.getOvalVersion() );
    }


    public static final String generateGlobalOvalID(
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
    public void setOvalGlobalID(
                    final String gid
                    )
    {
        _ovalGlobalID = gid;
    }


    public String getOvalGlobalID()
    {
        if (_ovalGlobalID == null) {
            _ovalGlobalID = generateGlobalOvalID( this );
        }

        return _ovalGlobalID;
    }



    //**************************************************************
    //  Comparable
    //**************************************************************

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
