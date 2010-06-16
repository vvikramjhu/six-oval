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

import jp.go.aist.six.oval.core.model.definition.EntityTypeHelper;
import jp.go.aist.six.oval.model.definition.EntityStateStringType;
import jp.go.aist.six.oval.model.definition.State;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: LinuxPkgInfoState.java 725 2010-05-07 02:27:17Z akihito $
 */
public abstract class LinuxPkgInfoState
    extends State
{

    private EntityStateStringType  _name;
    //{0..1}

    private EntityStateStringType  _arch;
    //{0..1}

    private EntityStateStringType  _version;
    //{0..1}



    /**
     * Constructor.
     */
    public LinuxPkgInfoState()
    {
    }


    /**
     * Constructor.
     */
    public LinuxPkgInfoState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }




    public void setName(
                    final EntityStateStringType name
                    )
    {
        _name = name;
    }


    public EntityStateStringType getName()
    {
        return _name;
    }



    public void setArch(
                    final EntityStateStringType arch
                    )
    {
        _arch = arch;
    }


    public EntityStateStringType getArch()
    {
        return _arch;
    }



    public void setVersion(
                    final EntityStateStringType version
                    )
    {
        _version = version;
    }


    public EntityStateStringType getVersion()
    {
        return _version;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        EntityStateStringType  name = getName();
        result = prime * result + ((name == null) ? 0 : name.hashCode());

        EntityStateStringType  arch = getArch();
        result = prime * result + ((arch == null) ? 0 : arch.hashCode());

        EntityStateStringType  version = getVersion();
        result = prime * result + ((version == null) ? 0 : version.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof LinuxPkgInfoState)) {
            return false;
        }

        if (super.equals( obj )) {
            LinuxPkgInfoState  other = (LinuxPkgInfoState)obj;
            if (EntityTypeHelper.equals( this.getVersion(), other.getVersion() )) {
                if (EntityTypeHelper.equals( this.getName(), other.getName() )) {
                    if (EntityTypeHelper.equals( this.getArch(), other.getArch() )) {
                        return true;
                    }
                }
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return super.toString()
                        + ", arch=" + getArch()
                        + ", name=" + getName()
                        + ", version=" + getVersion();
    }

}
// LinuxPkgInfoState
