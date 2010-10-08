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

import jp.go.aist.six.oval.model.sc.EntityItemString;
import jp.go.aist.six.oval.model.sc.Item;
import jp.go.aist.six.oval.model.sc.Status;
import java.util.EnumMap;
import java.util.Map;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class LinuxPkgInfoItem
    extends Item
{

    protected Map<LinuxPkgProperty,EntityItemString>  _properties =
        new EnumMap<LinuxPkgProperty,EntityItemString>( LinuxPkgProperty.class );

//    private EntityItemString  _name;
//    //{0..1}
//
//    private EntityItemString  _arch;
//    //{0..1}
//
//    private EntityItemString  _version;
//    //{0..1}



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
                    final Status status
                    )
    {
        super( id, status );
    }


    /**
     * Constructor.
     */
    public LinuxPkgInfoItem(
                    final int id,
                    final Status status,
                    final String name
                    )
    {
        this( id, status, null, name, null );
    }


    /**
     * Constructor.
     */
    public LinuxPkgInfoItem(
                    final int id,
                    final Status status,
                    final EntityItemString name
                    )
    {
        this( id, status, (EntityItemString)null, name, (EntityItemString)null );
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
                    final Status status,
                    final String arch,
                    final String name,
                    final String version
                    )
    {
        super( id, status );

        if (arch != null) {
            setArch( new EntityItemString( arch ) );
        }

        if (name != null) {
            setName( new EntityItemString( name ) );
        }

        if (version != null) {
            setVersion( new EntityItemString( version ) );
        }
    }


    /**
     * Constructor.
     */
    public LinuxPkgInfoItem(
                    final int id,
                    final Status status,
                    final EntityItemString arch,
                    final EntityItemString name,
                    final EntityItemString version
                    )
    {
        super( id, status );

        setArch( arch);
        setName( name );
        setVersion( version );
    }



    public void setArch(
                    final EntityItemString arch
                    )
    {
        _properties.put( LinuxPkgProperty.ARCH, arch );
//        _arch = arch;
    }


    public EntityItemString getArch()
    {
        return _properties.get( LinuxPkgProperty.ARCH );
//        return _arch;
    }



    public void setName(
                    final EntityItemString name
                    )
    {
        _properties.put( LinuxPkgProperty.NAME, name );
//        _name = name;
    }


    public EntityItemString getName()
    {
        return _properties.get( LinuxPkgProperty.NAME );
//        return _name;
    }



    public void setVersion(
                    final EntityItemString version
                    )
    {
        _properties.put( LinuxPkgProperty.VERSION, version );
//        _version = version;
    }


    public EntityItemString getVersion()
    {
        return _properties.get( LinuxPkgProperty.VERSION );
//        return _version;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return super.toString()
                        + ", arch=" + getArch()
                        + ", name=" + getName()
                        + ", version=" + getVersion();
    }

}
// LinuxPkgInfoItem
