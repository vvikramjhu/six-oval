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

package jp.go.aist.six.oval.model.linux;

import jp.go.aist.six.oval.model.sc.EntityItemAnySimple;
import jp.go.aist.six.oval.model.sc.EntityItemBase;
import jp.go.aist.six.oval.model.sc.EntityItemString;
import jp.go.aist.six.oval.model.sc.Item;
import jp.go.aist.six.oval.model.sc.Status;
import java.util.EnumMap;
import java.util.Map;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class LinuxPkgInfoItem
    extends Item
{

    protected Map<LinuxPkgProperty, EntityItemBase>  _properties =
        new EnumMap<LinuxPkgProperty, EntityItemBase>( LinuxPkgProperty.class );

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
        this( id, status, (EntityItemString)null, name, (EntityItemAnySimple)null );
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
            setVersion( new EntityItemAnySimple( version ) );
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
                    final EntityItemAnySimple version
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
    }


    public EntityItemString getArch()
    {
        return (EntityItemString)_properties.get( LinuxPkgProperty.ARCH );
    }



    /**
     */
    public void setName(
                    final EntityItemString name
                    )
    {
        _properties.put( LinuxPkgProperty.NAME, name );
    }


    public EntityItemString getName()
    {
        return (EntityItemString)_properties.get( LinuxPkgProperty.NAME );
    }



    public void setVersion(
                    final EntityItemAnySimple version
                    )
    {
        _properties.put( LinuxPkgProperty.VERSION, version );
    }


    public EntityItemAnySimple getVersion()
    {
        return (EntityItemAnySimple)_properties.get( LinuxPkgProperty.VERSION );
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
