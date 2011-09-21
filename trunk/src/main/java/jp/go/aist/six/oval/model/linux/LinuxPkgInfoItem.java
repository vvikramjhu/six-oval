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

import jp.go.aist.six.oval.model.common.DatatypeEnumeration;
import jp.go.aist.six.oval.model.sc.EntityItemAnySimpleType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;
import jp.go.aist.six.oval.model.sc.StatusEnumeration;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class LinuxPkgInfoItem
    extends ItemType
{

    private EntityItemStringType  name;
    //{0..1}

    private EntityItemStringType  arch;
    //{0..1}

    private EntityItemAnySimpleType  version;
    //{0..1}


//    protected Map<LinuxPkgProperty, EntityAttributeGroup>  _properties =
//        new EnumMap<LinuxPkgProperty, EntityAttributeGroup>( LinuxPkgProperty.class );


    /**
     * Constructor.
     */
    public LinuxPkgInfoItem()
    {
        this( 0 );
    }


    public LinuxPkgInfoItem(
                    final int id
                    )
    {
        this( id, null );
    }


    public LinuxPkgInfoItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        this( id, status, (EntityItemStringType)null );
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
        this( id, status,
                        (arch == null ? null : new EntityItemStringType( arch )),
                        (name == null ? null : new EntityItemStringType( name )),
                        (version == null ? null : new EntityItemAnySimpleType( version ))
                        );
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
    public void setName(
                    final EntityItemStringType name
                    )
    {
        this.name = name;
//        _properties.put( LinuxPkgProperty.NAME, name );
    }


    public EntityItemStringType getName()
    {
        return this.name;
//        return (EntityItemStringType)_properties.get( LinuxPkgProperty.NAME );
    }



    /**
     */
    public void setArch(
                    final EntityItemStringType arch
                    )
    {
        this.arch = arch;
//        _properties.put( LinuxPkgProperty.ARCH, arch );
    }


    public EntityItemStringType getArch()
    {
        return this.arch;
//        return (EntityItemStringType)_properties.get( LinuxPkgProperty.ARCH );
    }



    /**
     */
    public void setVersion(
                    final EntityItemAnySimpleType version
                    )
    {
        if (version != null) {
            DatatypeEnumeration  datatype = version.getDatatype();
            if (datatype != null) {
                if (datatype == DatatypeEnumeration.STRING
                                ||  datatype == DatatypeEnumeration.VERSION) {
                    // xsd:restriction satisfied.
                } else {
                    throw new IllegalArgumentException(
                                    "invalid version: datatype=" + datatype );
                }
            }
        }

        this.version = version;
//        _properties.put( LinuxPkgProperty.VERSION, version );
    }


    public EntityItemAnySimpleType getVersion()
    {
        return this.version;
//        return (EntityItemAnySimpleType)_properties.get( LinuxPkgProperty.VERSION );
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return super.toString()
             + ", name="    + getName()
             + ", arch="    + getArch()
             + ", version=" + getVersion()
             ;
    }

}
// LinuxPkgInfoItem
