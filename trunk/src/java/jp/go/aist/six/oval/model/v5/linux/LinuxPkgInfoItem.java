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

package jp.go.aist.six.oval.model.v5.linux;

import java.util.EnumMap;
import java.util.Map;
import jp.go.aist.six.oval.model.v5.sc.EntityAttributeGroup;
import jp.go.aist.six.oval.model.v5.sc.EntityItemAnySimpleType;
import jp.go.aist.six.oval.model.v5.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.v5.sc.ItemType;
import jp.go.aist.six.oval.model.v5.sc.StatusEnumeration;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class LinuxPkgInfoItem
    extends ItemType
{

    protected Map<LinuxPkgProperty, EntityAttributeGroup>  _properties =
        new EnumMap<LinuxPkgProperty, EntityAttributeGroup>( LinuxPkgProperty.class );

//    private EntityItemStringType  _name;
//    //{0..1}
//
//    private EntityItemStringType  _arch;
//    //{0..1}
//
//    private EntityItemVersionType  _version;
//    //{0..1}



    /**
     * Constructor.
     */
    public LinuxPkgInfoItem()
    {
    }


    public LinuxPkgInfoItem(
                    final int id
                    )
    {
        super( id );
    }


    public LinuxPkgInfoItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        super( id, status );
    }


    public LinuxPkgInfoItem(
                    final int id,
                    final StatusEnumeration status,
                    final String name
                    )
    {
        this( id, status, null, name, null );
    }


    public LinuxPkgInfoItem(
                    final int id,
                    final StatusEnumeration status,
                    final EntityItemStringType name
                    )
    {
        this( id, status, (EntityItemStringType)null, name, (EntityItemAnySimpleType)null );
    }


    public LinuxPkgInfoItem(
                    final int id,
                    final String arch,
                    final String name,
                    final String version
                    )
    {
        this( id, DEFAULT_STATUS, arch, name, version );
    }


    public LinuxPkgInfoItem(
                    final int id,
                    final StatusEnumeration status,
                    final String arch,
                    final String name,
                    final String version
                    )
    {
        super( id, status );

        if (arch != null) {
            setArch( new EntityItemStringType( arch ) );
        }

        if (name != null) {
            setName( new EntityItemStringType( name ) );
        }

        if (version != null) {
            setVersion( new EntityItemAnySimpleType( version ) );
        }
    }


    public LinuxPkgInfoItem(
                    final int id,
                    final StatusEnumeration status,
                    final EntityItemStringType arch,
                    final EntityItemStringType name,
                    final EntityItemAnySimpleType version
                    )
    {
        super( id, status );

        setArch( arch);
        setName( name );
        setVersion( version );
    }



    /**
     */
    public void setArch(
                    final EntityItemStringType arch
                    )
    {
        _properties.put( LinuxPkgProperty.ARCH, arch );
    }


    public EntityItemStringType getArch()
    {
        return (EntityItemStringType)_properties.get( LinuxPkgProperty.ARCH );
    }



    /**
     */
    public void setName(
                    final EntityItemStringType name
                    )
    {
        _properties.put( LinuxPkgProperty.NAME, name );
    }


    public EntityItemStringType getName()
    {
        return (EntityItemStringType)_properties.get( LinuxPkgProperty.NAME );
    }



    /**
     */
    public void setVersion(
                    final EntityItemAnySimpleType version
                    )
    {
        _properties.put( LinuxPkgProperty.VERSION, version );
    }


    public EntityItemAnySimpleType getVersion()
    {
        return (EntityItemAnySimpleType)_properties.get( LinuxPkgProperty.VERSION );
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
