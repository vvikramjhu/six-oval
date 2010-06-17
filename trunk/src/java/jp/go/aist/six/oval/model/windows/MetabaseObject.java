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

package jp.go.aist.six.oval.model.windows;

import jp.go.aist.six.oval.core.model.ComponentType;
import jp.go.aist.six.oval.model.definition.EntityObjectIntType;
import jp.go.aist.six.oval.model.definition.EntityObjectStringType;
import jp.go.aist.six.oval.model.definition.EntityTypeHelper;
import jp.go.aist.six.oval.model.definition.SystemObject;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class MetabaseObject
    extends SystemObject
{

    private EntityObjectStringType  _key;
    //{0..1}

    private EntityObjectIntType  _id;
    //{0..1, nillable="true"}



    /**
     * Constructor.
     */
    public MetabaseObject()
    {
    }


    /**
     * Constructor.
     */
    public MetabaseObject(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public MetabaseObject(
                    final String id,
                    final int version,
                    final String mbKey,
                    final String mbID
                    )
    {
        this( id, version,
                        new EntityObjectStringType( mbKey ),
                        new EntityObjectIntType( mbID )
        );
    }


    /**
     * Constructor.
     */
    public MetabaseObject(
                    final String id,
                    final int version,
                    final EntityObjectStringType mbKey,
                    final EntityObjectIntType mbID
                    )
    {
        super( id, version );
        setKey( mbKey );
        setID( mbID );
    }



    public void setKey(
                    final EntityObjectStringType key
                    )
    {
        _key = key;
    }


    public EntityObjectStringType getKey()
    {
        return _key;
    }



    public void setID(
                    final EntityObjectIntType id
                    )
    {
        _id = id;
    }


    public EntityObjectIntType getID()
    {
        return _id;
    }



    //**************************************************************
    //  SystemObject
    //**************************************************************

    @Override
    public ComponentType getSystemObjectType()
    {
        return ComponentType.WINDOWS_METABASE;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        EntityObjectStringType  key = getKey();
        result = prime * result + ((key == null) ? 0 : key.hashCode());

        EntityObjectIntType  id = getID();
        result = prime * result + ((id == null) ? 0 : id.hashCode());

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
        if (!(obj instanceof MetabaseObject)) {
            return false;
        }

        if (super.equals( obj )) {
            MetabaseObject  other = (MetabaseObject)obj;
            EntityObjectIntType  other_id = other.getID();
            EntityObjectIntType   this_id =  this.getID();
            if (EntityTypeHelper.equals( this_id, other_id)) {
                EntityObjectStringType  other_key = other.getKey();
                EntityObjectStringType   this_key =  this.getKey();
                if (EntityTypeHelper.equals( this_key, other_key)) {
                    return true;
                }
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "MetabaseObject[" + super.toString()
                        + ", key=" + getKey()
                        + ", id=" + getID()
                        + "]";
    }

}
// MetabaseObject
