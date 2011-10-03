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




/**
 * The rpminfo item stores rpm info.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RpmInfoItem
    extends LinuxEvrPkgInfoItem
{

    private EntityItemStringType  signature_keyid;
    //{0..1}



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
        this( id,
                        (String)null,
                        (String)null,
                        (String)null,
                        (String)null,
                        (String)null,
                        (String)null,
                        (String)null
                        );
    }



    public RpmInfoItem(
                    final int id,
                    final String arch,
                    final String name,
                    final String version,
                    final String release,
                    final String epoch,
                    final String evr,
                    final String sigkeyid
                    )
    {
        super( id, arch, name, version, release, epoch, evr );

        if (sigkeyid != null) {
            setSignatureKeyID( new EntityItemStringType( sigkeyid ) );
        }

        _oval_platform_type = OvalPlatformType.linux;
        _oval_component_type = OvalComponentType.rpminfo;
    }


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
    public void setSignatureKeyID(
                    final EntityItemStringType signature_keyid
                    )
    {
        this.signature_keyid = signature_keyid;
//        _properties.put( LinuxPkgProperty.SIGNATURE_KEYID, signatureKeyID);
    }


    public EntityItemStringType getSignatureKeyID()
    {
        return this.signature_keyid;
//        return (EntityItemStringType)_properties.get( LinuxPkgProperty.SIGNATURE_KEYID );
    }


    public RpmInfoItem signatureKeyID(
                    final String signature_keyid
                    )
    {
        setSignatureKeyID( new EntityItemStringType( signature_keyid ) );
        return this;
    }



    /**
     */
    public RpmInfoItem name(
                    final String name
                    )
    {
        setName( new EntityItemStringType( name ) );
        return this;
    }


    public RpmInfoItem arch(
                    final String arch
                    )
    {
        setArch( new EntityItemStringType( arch ) );
        return this;
    }


    public RpmInfoItem epoch(
                    final String epoch
                    )
    {
        setEpoch( new EntityItemAnySimpleType( epoch ) );
        return this;
    }


    public RpmInfoItem release(
                    final String release
                    )
    {
        setRelease( new EntityItemAnySimpleType( release ) );
        return this;
    }


    public RpmInfoItem version(
                    final String version
                    )
    {
        setVersion( new EntityItemAnySimpleType( version ) );
        return this;
    }


    public RpmInfoItem evr(
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
        return "rpminfo_item[" + super.toString()
             + ", sig_keyid=" + getSignatureKeyID()
             + "]";
    }

}
// RpmInfoItem
