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

    private EntityItemAnySimpleType  epoch;
    //{0..1}

    private EntityItemAnySimpleType  release;
    //{0..1}

    private EntityItemEVRStringType  evr;
    //{0..1}



    /**
     * Constructor.
     */
    public LinuxEvrPkgInfoItem()
    {
        this( 0 );
    }


    public LinuxEvrPkgInfoItem(
                    final int id
                    )
    {
        this( id, DEFAULT_STATUS );
    }


    public LinuxEvrPkgInfoItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        this( id, status, (EntityItemStringType)null );
    }


    public LinuxEvrPkgInfoItem(
                    final int id,
                    final StatusEnumeration status,
                    final String name
                    )
    {
        this( id, status,
                        (name == null ? null : new EntityItemStringType( name ))
                        );
    }


    public LinuxEvrPkgInfoItem(
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
        this( id, status,
                        (arch == null ? null : new EntityItemStringType( arch )),
                        (name == null ? null : new EntityItemStringType( name )),
                        (version == null ? null : new EntityItemAnySimpleType( version )),
                        (release == null ? null : new EntityItemAnySimpleType( release )),
                        (epoch == null ? null : new EntityItemAnySimpleType( epoch )),
                        (evr == null ? null : new EntityItemEVRStringType( evr ))
                        );
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
    public void setEpoch(
                    final EntityItemAnySimpleType epoch
                    )
    {
        if (epoch != null) {
            DatatypeEnumeration  datatype = epoch.getDatatype();
            if (datatype != null) {
                if (datatype == DatatypeEnumeration.STRING
                                ||  datatype == DatatypeEnumeration.INT) {
                    // xsd:restriction satisfied.
                } else {
                    throw new IllegalArgumentException(
                                    "invalid epoch: datatype=" + datatype );
                }
            }
        }

        this.epoch = epoch;
//        _properties.put( LinuxPkgProperty.EPOCH, epoch );
    }


    public EntityItemAnySimpleType getEpoch()
    {
        return this.epoch;
//        return (EntityItemAnySimpleType)_properties.get( LinuxPkgProperty.EPOCH );
    }



    /**
     */
    public void setRelease(
                    final EntityItemAnySimpleType release
                    )
    {
        if (release != null) {
            DatatypeEnumeration  datatype = release.getDatatype();
            if (datatype != null) {
                if (datatype == DatatypeEnumeration.STRING
                                ||  datatype == DatatypeEnumeration.VERSION) {
                    // xsd:restriction satisfied.
                } else {
                    throw new IllegalArgumentException(
                                    "invalid release: datatype=" + datatype );
                }
            }
        }

        this.release = release;
//        _properties.put( LinuxPkgProperty.RELEASE, release );
    }


    public EntityItemAnySimpleType getRelease()
    {
        return this.release;
//        return (EntityItemAnySimpleType)_properties.get( LinuxPkgProperty.RELEASE );
    }



    /**
     */
    public void setEvr(
                    final EntityItemEVRStringType evr
                    )
    {
        this.evr = evr;
//        _properties.put( LinuxPkgProperty.EVR, evr );
    }


    public EntityItemEVRStringType getEvr()
    {
        return this.evr;
//        return (EntityItemEVRStringType)_properties.get( LinuxPkgProperty.EVR );
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return super.toString()
             + ", epoch="   + getEpoch()
             + ", release=" + getRelease()
             + ", evr="     + getEvr()
             ;
    }

}
// LinuxEvrPkgInfoItem
