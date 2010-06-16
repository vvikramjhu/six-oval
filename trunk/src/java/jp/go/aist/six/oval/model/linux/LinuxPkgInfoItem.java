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

import jp.go.aist.six.oval.model.system.Item;
import jp.go.aist.six.oval.model.system.ItemStatus;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: LinuxPkgInfoItem.java 764 2010-05-10 08:47:46Z akihito $
 */
public abstract class LinuxPkgInfoItem
    extends Item
{

    private String  _name;
    //{oval-sc:EntityItemStringType, 0..1}

    private String  _arch;
    //{oval-sc:EntityItemStringType, 0..1}

    private String  _version;
    //{oval-sc:EntityItemStringType, 0..1}



    /**
     * Constructor.
     */
    public LinuxPkgInfoItem()
    {
    }


    /**
     * Constructor.
     */
    public LinuxPkgInfoItem(
                    final int id
                    )
    {
        super( id );
    }


    /**
     * Constructor.
     */
    public LinuxPkgInfoItem(
                    final int id,
                    final ItemStatus status
                    )
    {
        super( id, status );
    }


    /**
     * Constructor.
     */
    public LinuxPkgInfoItem(
                    final int id,
                    final ItemStatus status,
                    final String name
                    )
    {
        this( id, status );
        setName( name );
    }


    /**
     * Constructor.
     */
    public LinuxPkgInfoItem(
                    final int id,
                    final String arch,
                    final String name,
                    final String version
                    )
    {
        this( id, DEFAULT_STATUS, arch, name, version );
    }


    /**
     * Constructor.
     */
    public LinuxPkgInfoItem(
                    final int id,
                    final ItemStatus status,
                    final String arch,
                    final String name,
                    final String version
                    )
    {
        this( id, status );
        setArch( arch );
        setName( name );
        setVersion( version );
    }



    public void setArch(
                    final String arch
                    )
    {
        _arch = arch;
    }


    public String getArch()
    {
        return _arch;
    }



    public void setName(
                    final String name
                    )
    {
        _name = name;
    }


    public String getName()
    {
        return _name;
    }



    public void setVersion(
                    final String version
                    )
    {
        _version = version;
    }


    public String getVersion()
    {
        return _version;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return super.toString()
                        + ", arch=" + getArch()
                        + ", name=" + getName()
                        + ", version=" + getVersion()
                        + "]";
    }

}
// LinuxPkgInfoItem
