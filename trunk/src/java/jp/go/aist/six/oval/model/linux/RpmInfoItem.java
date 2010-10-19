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

import jp.go.aist.six.oval.model.EntityType;
import jp.go.aist.six.oval.model.sc.EntityItemAnySimple;
import jp.go.aist.six.oval.model.sc.EntityItemEVRString;
import jp.go.aist.six.oval.model.sc.EntityItemString;
import jp.go.aist.six.oval.model.sc.Status;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RpmInfoItem
    extends LinuxEvrPkgInfoItem
{

//    private EntityItemString  _signatureKeyID;
//    //{0..1}



    /**
     * Constructor.
     */
    public RpmInfoItem()
    {
    }


    /**
     * Constructor.
     */
    public RpmInfoItem(
                    final int id
                    )
    {
        super( id );
    }


    /**
     * Constructor.
     */
    public RpmInfoItem(
                    final int id,
                    final Status status
                    )
    {
        super( id, status );
    }


    /**
     * Constructor.
     */
    public RpmInfoItem(
                    final int id,
                    final Status status,
                    final String name
                    )
    {
        super( id, status, name );
    }


    /**
     * Constructor.
     */
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
        this( id, DEFAULT_STATUS, arch, name, version, release, epoch, evr, sigkeyid );
    }


    /**
     * Constructor.
     */
    public RpmInfoItem(
                    final int id,
                    final Status status,
                    final String arch,
                    final String name,
                    final String version,
                    final String release,
                    final String epoch,
                    final String evr,
                    final String sigkeyid
                    )
    {
        super( id, status, arch, name, version, release, epoch, evr );

        if (sigkeyid != null) {
            setSignatureKeyID( new EntityItemString( sigkeyid ) );
        }
    }


    /**
     * Constructor.
     */
    public RpmInfoItem(
                    final int id,
                    final Status status,
                    final EntityItemString arch,
                    final EntityItemString name,
                    final EntityItemAnySimple version,
                    final EntityItemAnySimple release,
                    final EntityItemAnySimple epoch,
                    final EntityItemEVRString evr,
                    final EntityItemString sigkeyid
                    )
    {
        super( id, status, arch, name, version, release, epoch, evr );

        setSignatureKeyID( sigkeyid );
    }



    /**
     */
    public void setSignatureKeyID(
                    final EntityItemString signatureKeyID
                    )
    {
        _properties.put( LinuxPkgProperty.SIGNATURE_KEYID, signatureKeyID);
    }


    public EntityItemString getSignatureKeyID()
    {
        return (EntityItemString)_properties.get( LinuxPkgProperty.SIGNATURE_KEYID );
    }


    public RpmInfoItem signatureKeyID(
                    final String signatureKeyID
                    )
    {
        setSignatureKeyID( new EntityItemString( signatureKeyID ) );
        return this;
    }



    /**
     */
    public RpmInfoItem name(
                    final String name
                    )
    {
        setName( new EntityItemString( name ) );
        return this;
    }


    public RpmInfoItem arch(
                    final String arch
                    )
    {
        setArch( new EntityItemString( arch ) );
        return this;
    }


    public RpmInfoItem epoch(
                    final String epoch
                    )
    {
        setEpoch( new EntityItemAnySimple( epoch ) );
        return this;
    }


    public RpmInfoItem release(
                    final String release
                    )
    {
        setRelease( new EntityItemAnySimple( release ) );
        return this;
    }


    public RpmInfoItem version(
                    final String version
                    )
    {
        setVersion( new EntityItemAnySimple( version ) );
        return this;
    }


    public RpmInfoItem evr(
                    final String evr
                    )
    {
        setEvr( new EntityItemEVRString( evr ) );
        return this;
    }



    //**************************************************************
    //  Item
    //**************************************************************

    @Override
    public EntityType getEntityType()
    {
        return EntityType.LINUX_RPMINFO;
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
