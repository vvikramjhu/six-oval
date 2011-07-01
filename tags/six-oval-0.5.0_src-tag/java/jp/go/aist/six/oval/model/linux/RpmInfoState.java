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

import jp.go.aist.six.oval.model.EntityType;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.EntityTypeHelper;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class RpmInfoState
    extends LinuxEvrPkgInfoState
{

    private EntityStateString  _signatureKeyID;
    //{0..1}


    /**
     * Constructor.
     */
    public RpmInfoState()
    {
    }


    /**
     * Constructor.
     */
    public RpmInfoState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }



    public RpmInfoState version(
                    final EntityStateString version
                    )
    {
        setVersion( version );
        return this;
    }



    public RpmInfoState evr(
                    final EntityStateString evr
                    )
    {
        setEvr( evr );
        return this;
    }



    public void setSignatureKeyID(
                    final EntityStateString keyid
                    )
    {
        _signatureKeyID = keyid;
    }


    public RpmInfoState signatureKeyID(
                    final EntityStateString keyid
                    )
    {
        setSignatureKeyID( keyid );
        return this;
    }



    public EntityStateString getSignatureKeyID()
    {
        return _signatureKeyID;
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public EntityType getEntityType()
    {
        return EntityType.LINUX_RPMINFO;
    }



    // **************************************************************
    // java.lang.Object
    // **************************************************************

    @Override
    public int hashCode()
    {
        final int prime = 37;
        int result = super.hashCode();

        EntityStateString  sig = getSignatureKeyID();
        result = prime * result + ((sig == null) ? 0 : sig.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof RpmInfoState)) {
            return false;
        }

        if (super.equals( obj )) {
            RpmInfoState other = (RpmInfoState)obj;
            if (EntityTypeHelper.equals( this.getSignatureKeyID(),
                            other.getSignatureKeyID() )) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "RpmInfoState[" + super.toString()
                        + ", signature_keyid=" + getSignatureKeyID()
                        + "]";
    }

}
// RpmInfoState