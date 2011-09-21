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
import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimpleType;
import jp.go.aist.six.oval.model.definitions.EntityStateEVRStringType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;



/**
 * The rpminfo state defines the different information
 * that can be used to evaluate the specified rpm.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RpmInfoState
    extends LinuxEvrPkgInfoState
{

    private EntityStateStringType  signature_keyid;
    //{0..1}



    /**
     * Constructor.
     */
    public RpmInfoState()
    {
        this( null, 0 );
    }


    public RpmInfoState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );

        _oval_platform_type = OvalPlatformType.linux;
        _oval_component_type = OvalComponentType.rpminfo;
    }



    public RpmInfoState version(
                    final EntityStateAnySimpleType version
                    )
    {
        setVersion( version );
        return this;
    }



    public RpmInfoState evr(
                    final EntityStateEVRStringType evr
                    )
    {
        setEvr( evr );
        return this;
    }



    /**
     */
    public void setSignatureKeyID(
                    final EntityStateStringType keyid
                    )
    {
        this.signature_keyid = keyid;
//        _setProperty( LinuxPkgProperty.SIGNATURE_KEYID, keyid );
    }


    public EntityStateStringType getSignatureKeyID()
    {
        return this.signature_keyid;
//        return _getProperty(
//                        LinuxPkgProperty.SIGNATURE_KEYID, EntityStateStringType.class );
    }


    public RpmInfoState signatureKeyID(
                    final EntityStateStringType keyid
                    )
    {
        setSignatureKeyID( keyid );
        return this;
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.LINUX_RPMINFO;
    }



    // **************************************************************
    // java.lang.Object
    // **************************************************************

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof RpmInfoState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "rpminfo_state[" + super.toString()
                        + ", signature_keyid=" + getSignatureKeyID()
//                        + ", " + String.valueOf( _getProperties() )
                        + "]";
    }

}
// RpmInfoState