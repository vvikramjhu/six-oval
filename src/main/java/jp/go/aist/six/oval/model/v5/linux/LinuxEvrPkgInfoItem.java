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

import jp.go.aist.six.oval.model.v5.sc.EntityItemAnySimpleType;
import jp.go.aist.six.oval.model.v5.sc.EntityItemEVRStringType;
import jp.go.aist.six.oval.model.v5.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.v5.sc.StatusEnumeration;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class LinuxEvrPkgInfoItem
    extends LinuxPkgInfoItem
{

//    private EntityItemStringType  _release;
//    //{0..1}
//
//    private EntityItemStringType  _epoch;
//    //{0..1}
//
//    private EntityItemStringType  _evr;
//    //{0..1}



    /**
     * Constructor.
     */
    public LinuxEvrPkgInfoItem()
    {
    }


    public LinuxEvrPkgInfoItem(
                    final int id
                    )
    {
        super( id );
    }


    public LinuxEvrPkgInfoItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        super( id, status );
    }


    public LinuxEvrPkgInfoItem(
                    final int id,
                    final StatusEnumeration status,
                    final String name
                    )
    {
        super( id, status, name );
    }


    public LinuxEvrPkgInfoItem(
                    final int id,
                    final StatusEnumeration status,
                    final EntityItemStringType name
                    )
    {
        super( id, status, name );
    }



    public LinuxEvrPkgInfoItem(
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


    public LinuxEvrPkgInfoItem(
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
        super( id, status, arch, name, version );

        if (epoch != null) {
            setEpoch( new EntityItemAnySimpleType( epoch ) );
        }

        if (release != null) {
            setRelease( new EntityItemAnySimpleType( release ) );
        }

        if (evr != null) {
            setEvr( new EntityItemEVRStringType( evr ) );
        }
    }


    public LinuxEvrPkgInfoItem(
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
        super( id, status, arch, name, version );

        setEpoch( epoch );
        setRelease( release );
        setEvr( evr );
    }



    /**
     */
    public void setRelease(
                    final EntityItemAnySimpleType release
                    )
    {
        _properties.put( LinuxPkgProperty.RELEASE, release );
    }


    public EntityItemAnySimpleType getRelease()
    {
        return (EntityItemAnySimpleType)_properties.get( LinuxPkgProperty.RELEASE );
    }



    /**
     */
    public void setEpoch(
                    final EntityItemAnySimpleType epoch
                    )
    {
        _properties.put( LinuxPkgProperty.EPOCH, epoch );
    }


    public EntityItemAnySimpleType getEpoch()
    {
        return (EntityItemAnySimpleType)_properties.get( LinuxPkgProperty.EPOCH );
    }



    /**
     */
    public void setEvr(
                    final EntityItemEVRStringType evr
                    )
    {
        _properties.put( LinuxPkgProperty.EVR, evr );
    }


    public EntityItemEVRStringType getEvr()
    {
        return (EntityItemEVRStringType)_properties.get( LinuxPkgProperty.EVR );
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return super.toString()
                        + ", evr=" + getEvr();
    }

}
// LinuxEvrPkgInfoItem
