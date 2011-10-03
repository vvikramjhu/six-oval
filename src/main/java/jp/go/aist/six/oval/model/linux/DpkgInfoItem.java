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

import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.sc.EntityItemAnySimpleType;
import jp.go.aist.six.oval.model.sc.EntityItemEVRStringType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.StatusEnumeration;



/**
 * The dpkginfo item stores DPKG package info.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class DpkgInfoItem
    extends LinuxEvrPkgInfoItem
{

    /**
     * Constructor.
     */
    public DpkgInfoItem()
    {
        this( 0 );
    }


    public DpkgInfoItem(
                    final int id
                    )
    {
        this( id, DEFAULT_STATUS );
    }


    public DpkgInfoItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        this( id, status, (EntityItemStringType)null );
    }


    public DpkgInfoItem(
                    final int id,
                    final StatusEnumeration status,
                    final String name
                    )
    {
        this( id, status,
                        (name == null ? null : new EntityItemStringType( name ))
                        );
    }


    public DpkgInfoItem(
                    final int id,
                    final StatusEnumeration status,
                    final EntityItemStringType name
                    )
    {
        this( id, status,
                        (EntityItemStringType)null,
                        name,
                        (EntityItemAnySimpleType)null,
                        (EntityItemAnySimpleType)null,
                        (EntityItemAnySimpleType)null,
                        (EntityItemEVRStringType)null
                        );
    }


    public DpkgInfoItem(
                    final int id,
                    final String arch,
                    final String name,
                    final String version,
                    final String release,
                    final String epoch,
                    final String evr
                    )
    {
        this( id, DEFAULT_STATUS, arch, name, version, release, epoch, evr );
    }


    public DpkgInfoItem(
                    final int id,
                    final StatusEnumeration status,
                    final String arch,
                    final String name,
                    final String version,
                    final String release,
                    final String epoch,
                    final String evr
                    )
    {
        this( id, status,
                        (arch == null ? null : new EntityItemStringType( arch )),
                        (name == null ? null : new EntityItemStringType( name )),
                        (version == null ? null : new EntityItemAnySimpleType( version )),
                        (release == null ? null : new EntityItemAnySimpleType( release )),
                        (epoch == null ? null : new EntityItemAnySimpleType( epoch )),
                        (evr == null ? null : new EntityItemEVRStringType( evr ))
                        );
    }


    public DpkgInfoItem(
                    final int id,
                    final StatusEnumeration status,
                    final EntityItemStringType arch,
                    final EntityItemStringType name,
                    final EntityItemAnySimpleType version,
                    final EntityItemAnySimpleType release,
                    final EntityItemAnySimpleType epoch,
                    final EntityItemEVRStringType evr
                    )
    {
        super( id, status, arch, name, version, release, epoch, evr );

        _oval_platform_type = OvalPlatformType.linux;
        _oval_component_type = OvalComponentType.dpkginfo;
    }



    /**
     */
    public DpkgInfoItem name(
                    final String name
                    )
    {
        setName( new EntityItemStringType( name ) );
        return this;
    }


    public DpkgInfoItem name(
                    final EntityItemStringType name
                    )
    {
        setName( name );
        return this;
    }



    /**
     */
    public DpkgInfoItem arch(
                    final String arch
                    )
    {
        setArch( new EntityItemStringType( arch ) );
        return this;
    }


    public DpkgInfoItem epoch(
                    final String epoch
                    )
    {
        setEpoch( new EntityItemAnySimpleType( epoch ) );
        return this;
    }



    /**
     */
    public DpkgInfoItem release(
                    final String release
                    )
    {
        setRelease( new EntityItemAnySimpleType( release ) );
        return this;
    }


    public DpkgInfoItem version(
                    final String version
                    )
    {
        setVersion( new EntityItemAnySimpleType( version ) );
        return this;
    }



    /**
     */
    public DpkgInfoItem evr(
                    final String evr
                    )
    {
        setEvr( new EntityItemEVRStringType( evr ) );
        return this;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "dpkginfo_item[" + super.toString()
             + "]";
    }

}
// DpkgInfoItem
