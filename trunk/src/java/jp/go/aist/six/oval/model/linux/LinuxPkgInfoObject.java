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

package jp.go.aist.six.oval.model.linux;

import jp.go.aist.six.oval.model.definitions.EntityObjectString;
import jp.go.aist.six.oval.model.definitions.SystemObject;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class LinuxPkgInfoObject
    extends SystemObject
{

    private EntityObjectString  _name;
    //{1..1}



    /**
     * Constructor.
     */
    public LinuxPkgInfoObject()
    {
    }


    /**
     * Constructor.
     */
    public LinuxPkgInfoObject(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }



    /**
     * Constructor.
     */
    public LinuxPkgInfoObject(
                    final String id,
                    final int version,
                    final String name
                    )
    {
        this( id, version,
                        (name == null ? null : (new EntityObjectString( name )))
                        );
    }


    /**
     * Constructor.
     */
    public LinuxPkgInfoObject(
                    final String id,
                    final int version,
                    final EntityObjectString name
                    )
    {
        super( id, version );
        setName( name );
    }



//    public void setName(
//                    final String name
//                    )
//    {
//        setName( new EntityObjectStringType( name ) );
//    }


    public void setName(
                    final EntityObjectString name
                    )
    {
        _name = name;
    }


    public EntityObjectString getName()
    {
        return _name;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        EntityObjectString  name = getName();
        result = prime * result + ((name == null) ? 0 : name.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof LinuxPkgInfoObject)) {
            return false;
        }

        if (super.equals( obj )) {
            LinuxPkgInfoObject  other = (LinuxPkgInfoObject)obj;
            EntityObjectString  other_name = other.getName();
            EntityObjectString   this_name =  this.getName();
            if (this_name == other_name
                            ||  (this_name != null  &&  this_name.equals( other_name ))) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        EntityObjectString  name = getName();
        return "name=" + (name == null ? null : name.getData())
                        + ", " + super.toString();
    }

}
// LinuxPkgInfoObject
