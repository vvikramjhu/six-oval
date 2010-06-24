/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
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

import jp.go.aist.six.oval.core.model.system.ItemType;
import jp.go.aist.six.oval.model.system.EntityItemString;
import jp.go.aist.six.oval.model.system.Status;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: RpmInfoItem.java 763 2010-05-10 08:30:29Z akihito $
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
                    final String name,
                    final String arch,
                    final String epoch,
                    final String release,
                    final String version,
                    final String evr,
                    final String sigkeyid
                    )
    {
        this( id, DEFAULT_STATUS, name, arch, epoch, release, version, evr, sigkeyid );
    }


    /**
     * Constructor.
     */
    public RpmInfoItem(
                    final int id,
                    final Status status,
                    final String name,
                    final String arch,
                    final String epoch,
                    final String release,
                    final String version,
                    final String evr,
                    final String sigkeyid
                    )
    {
        super( id, status, name, arch, epoch, release, version, evr );

        if (sigkeyid != null) {
            setSignatureKeyID( new EntityItemString( sigkeyid ) );
        }
    }



    public void setSignatureKeyID(
                    final EntityItemString signatureKeyID
                    )
    {
        _properties.put( LinuxPkgProperty.SIGNATURE_KEYID, signatureKeyID);
    }


    public EntityItemString getSignatureKeyID()
    {
        return _properties.get( LinuxPkgProperty.SIGNATURE_KEYID );
    }



    //**************************************************************
    //  Item
    //**************************************************************

    @Override
    public ItemType getItemType()
    {
        return ItemType.LINUX_RPMINFO;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "RpmInfoItem[" + super.toString()
                        + ", sig_keyid=" + getSignatureKeyID()
                        + "]";
    }

}
// RpmInfoItem
