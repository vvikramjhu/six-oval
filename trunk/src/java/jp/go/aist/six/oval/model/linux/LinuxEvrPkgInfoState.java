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

import jp.go.aist.six.oval.core.model.definition.EntityTypeHelper;
import jp.go.aist.six.oval.model.definition.EntityStateStringType;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: LinuxEvrPkgInfoState.java 725 2010-05-07 02:27:17Z akihito $
 */
public abstract class LinuxEvrPkgInfoState
    extends LinuxPkgInfoState
{

    private EntityStateStringType  _epoch;
    //{0..1}

    private EntityStateStringType  _release;
    //{0..1}

    private EntityStateStringType  _evr;
    //{0..1}



    /**
     * Constructor.
     */
    public LinuxEvrPkgInfoState()
    {
    }


    /**
     * Constructor.
     */
    public LinuxEvrPkgInfoState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }



    public void setEpoch(
                    final EntityStateStringType epoch
                    )
    {
        _epoch = epoch;
    }


    public EntityStateStringType getEpoch()
    {
        return _epoch;
    }



    public void setRelease(
                    final EntityStateStringType release
                    )
    {
        _release = release;
    }


    public EntityStateStringType getRelease()
    {
        return _release;
    }



    public void setEvr(
                    final EntityStateStringType evr
                    )
    {
        _evr = evr;
    }


    public EntityStateStringType getEvr()
    {
        return _evr;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        EntityStateStringType  epoch = getEpoch();
        result = prime * result + ((epoch == null) ? 0 : epoch.hashCode());

        EntityStateStringType  release = getRelease();
        result = prime * result + ((release == null) ? 0 : release.hashCode());

        EntityStateStringType  evr = getEvr();
        result = prime * result + ((evr == null) ? 0 : evr.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof LinuxEvrPkgInfoState)) {
            return false;
        }

        if (super.equals( obj )) {
            LinuxEvrPkgInfoState  other = (LinuxEvrPkgInfoState)obj;
            if (EntityTypeHelper.equals( this.getEvr(), other.getEvr() )) {
                if (EntityTypeHelper.equals( this.getEpoch(), other.getEpoch() )) {
                    if (EntityTypeHelper.equals( this.getRelease(), other.getRelease() )) {
                        return true;
                    }
                }
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return super.toString()
                        + ", release=" + getRelease()
                        + ", epoch=" + getEpoch()
                        + ", evr=" + getEvr();
    }

}
// LinuxEvrPkgInfoState
