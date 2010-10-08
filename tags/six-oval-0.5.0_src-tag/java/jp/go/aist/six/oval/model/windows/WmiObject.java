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

import jp.go.aist.six.oval.model.EntityType;
import jp.go.aist.six.oval.model.definitions.EntityObjectString;
import jp.go.aist.six.oval.model.definitions.EntityTypeHelper;
import jp.go.aist.six.oval.model.definitions.SystemObject;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class WmiObject
    extends SystemObject
{

    private EntityObjectString  _namespace;
    //{0..1}

    private EntityObjectString  _wql;
    //{0..1}



    /**
     * Constructor.
     */
    public WmiObject()
    {
    }


    /**
     * Constructor.
     */
    public WmiObject(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public WmiObject(
                    final String id,
                    final int version,
                    final String namespace,
                    final String wql
                    )
    {
        this( id, version,
                        (namespace == null ? null : (new EntityObjectString( namespace ))),
                        (wql == null ? null : (new EntityObjectString( wql )))
        );
    }


    /**
     * Constructor.
     */
    public WmiObject(
                    final String id,
                    final int version,
                    final EntityObjectString namespace,
                    final EntityObjectString wql
                    )
    {
        super( id, version );

        setNamespace( namespace );
        setWql( wql );
    }



    public void setNamespace(
                    final EntityObjectString namespace
                    )
    {
        _namespace = namespace;
    }


    public EntityObjectString getNamespace()
    {
        return _namespace;
    }



    public void setWql(
                    final EntityObjectString wql
                    )
    {
        _wql = wql;
    }


    public EntityObjectString getWql()
    {
        return _wql;
    }



    //**************************************************************
    //  SystemObject
    //**************************************************************

    @Override
    public EntityType getEntityType()
    {
        return EntityType.WINDOWS_WMI;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        EntityObjectString  namespace = getNamespace();
        result = prime * result + ((namespace == null) ? 0 : namespace.hashCode());

        EntityObjectString  wql = getWql();
        result = prime * result + ((wql == null) ? 0 : wql.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof WmiObject)) {
            return false;
        }

        if (super.equals( obj )) {
            WmiObject  other = (WmiObject)obj;
            EntityObjectString  other_wql = other.getWql();
            EntityObjectString   this_wql =  this.getWql();
            if (EntityTypeHelper.equals( this_wql, other_wql )) {
                EntityObjectString  other_namespace = other.getNamespace();
                EntityObjectString   this_namespace =  this.getNamespace();
                if (EntityTypeHelper.equals( this_namespace, other_namespace )) {
                    return true;
                }
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "WqlObject[" + super.toString()
                        + ", namespace=" + getNamespace()
                        + ", wql=" + getWql()
                        + "]";
    }

}
// WqlObject
