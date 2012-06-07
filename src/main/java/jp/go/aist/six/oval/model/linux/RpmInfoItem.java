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

import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.common.DatatypeEnumeration;
import jp.go.aist.six.oval.model.sc.EntityItemAnySimpleType;
import jp.go.aist.six.oval.model.sc.EntityItemEVRStringType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;
import jp.go.aist.six.oval.model.sc.StatusEnumeration;



/**
 * The rpminfo item stores rpm info.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RpmInfoItem
    extends ItemType
{

    //{0..1}
    private EntityItemStringType        name;
    private EntityItemStringType        arch;
    private EntityItemAnySimpleType     epoch;
    private EntityItemAnySimpleType     release;
    private EntityItemAnySimpleType     version;
    private EntityItemEVRStringType     evr;
    private EntityItemStringType        signature_keyid;
    private EntityItemStringType        extended_name;
    private EntityItemStringType        filepath;



    /**
     * Constructor.
     */
    public RpmInfoItem()
    {
        this( 0 );
    }


    public RpmInfoItem(
                    final int id
                    )
    {
        this( id, DEFAULT_STATUS );
    }


    public RpmInfoItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        super( id, status );

//        _oval_platform_type = OvalPlatformType.linux;
//        _oval_component_type = OvalComponentType.rpminfo;
        _oval_family = Family.LINUX;
        _oval_component = ComponentType.RPMINFO;
    }

//    public RpmInfoItem(
//                    final int id
//                    )
//    {
//        this( id,
//                        (String)null,
//                        (String)null,
//                        (String)null,
//                        (String)null,
//                        (String)null,
//                        (String)null,
//                        (String)null
//                        );
//    }
//
//
//
//    public RpmInfoItem(
//                    final int id,
//                    final String arch,
//                    final String name,
//                    final String version,
//                    final String release,
//                    final String epoch,
//                    final String evr,
//                    final String sigkeyid
//                    )
//    {
//        super( id, arch, name, version, release, epoch, evr );
//
//        if (sigkeyid != null) {
//            setSignatureKeyId( new EntityItemStringType( sigkeyid ) );
//        }
//
//        _oval_platform_type = OvalPlatformType.linux;
//        _oval_component_type = OvalComponentType.rpminfo;
//    }


//    public RpmInfoItem(
//                    final int id,
//                    final EntityItemStringType arch,
//                    final EntityItemStringType name,
//                    final EntityItemAnySimpleType version,
//                    final EntityItemAnySimpleType release,
//                    final EntityItemAnySimpleType epoch,
//                    final EntityItemEVRStringType evr,
//                    final EntityItemStringType sigkeyid
//                    )
//    {
//        super( id, arch, name, version, release, epoch, evr );
//
//        setSignatureKeyID( sigkeyid );
//    }



    /**
     */
    public void setName(
                    final EntityItemStringType name
                    )
    {
        this.name = name;
    }


    public EntityItemStringType getName()
    {
        return name;
    }


    public RpmInfoItem name(
                    final String name
                    )
    {
        setName( new EntityItemStringType( name ) );
        return this;
    }


    public RpmInfoItem name(
                    final EntityItemStringType name
                    )
    {
        setName( name );
        return this;
    }




    /**
     */
    public void setArch(
                    final EntityItemStringType arch
                    )
    {
        this.arch = arch;
    }


    public EntityItemStringType getArch()
    {
        return arch;
    }


    public RpmInfoItem arch(
                    final String arch
                    )
    {
        setArch( new EntityItemStringType( arch ) );
        return this;
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
                    //validation: xsd:restriction satisfied.
                } else {
                    throw new IllegalArgumentException(
                                    "invalid epoch: datatype=" + datatype );
                }
            }
        }

        this.epoch = epoch;
    }


    public EntityItemAnySimpleType getEpoch()
    {
        return epoch;
    }


    public RpmInfoItem epoch(
                    final String epoch
                    )
    {
        setEpoch( new EntityItemAnySimpleType( epoch ) );
        return this;
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
    }


    public EntityItemAnySimpleType getRelease()
    {
        return release;
    }


    public RpmInfoItem release(
                    final String release
                    )
    {
        setRelease( new EntityItemAnySimpleType( release ) );
        return this;
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
    }


    public EntityItemAnySimpleType getVersion()
    {
        return version;
    }


    public RpmInfoItem version(
                    final String version
                    )
    {
        setVersion( new EntityItemAnySimpleType( version ) );
        return this;
    }



    /**
     */
    public void setEvr(
                    final EntityItemEVRStringType evr
                    )
    {
        this.evr = evr;
    }


    public EntityItemEVRStringType getEvr()
    {
        return evr;
    }


    public RpmInfoItem evr(
                    final String evr
                    )
    {
        setEvr( new EntityItemEVRStringType( evr ) );
        return this;
    }



    /**
     */
    public void setSignatureKeyId(
                    final EntityItemStringType signature_keyid
                    )
    {
        this.signature_keyid = signature_keyid;
    }


    public EntityItemStringType getSignatureKeyId()
    {
        return signature_keyid;
    }


    public RpmInfoItem signatureKeyId(
                    final String signature_keyid
                    )
    {
        setSignatureKeyId( new EntityItemStringType( signature_keyid ) );
        return this;
    }



    /**
     */
    public void setExtendedName(
                    final EntityItemStringType extended_name
                    )
    {
        this.extended_name = extended_name;
    }


    public EntityItemStringType getExtendedName()
    {
        return extended_name;
    }



    /**
     */
    public void setFilepath(
                    final EntityItemStringType filepath
                    )
    {
        this.filepath = filepath;
    }


    public EntityItemStringType getFilepath()
    {
        return filepath;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "rpminfo_item[" + super.toString()
                        + ", name="         + getName()
                        + ", arch="         + getArch()
                        + ", epoch="        + getEpoch()
                        + ", release="      + getRelease()
                        + ", version="      + getVersion()
                        + ", evr="          + getEvr()
                        + ", signature_keyid="  + getSignatureKeyId()
                        + ", extended_name="    + getExtendedName()
                        + ", filepath="     + getFilepath()
             + "]";
    }

}
//RpmInfoItem
