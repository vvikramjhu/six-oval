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

import jp.go.aist.six.oval.model.definitions.EntityStateAnySimple;
import jp.go.aist.six.oval.model.definitions.EntityStateEVRString;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class LinuxEvrPkgInfoState
    extends LinuxPkgInfoState
{

    private EntityStateAnySimple  _epoch;
    //{0..1}

    private EntityStateAnySimple  _release;
    //{0..1}

    private EntityStateEVRString  _evr;
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
                    final EntityStateAnySimple epoch
                    )
    {
        _setStateProperty( LinuxPkgProperty.EPOCH, epoch );
//        _epoch = epoch;
    }


    public EntityStateAnySimple getEpoch()
    {
        return _getStateProperty( LinuxPkgProperty.EPOCH, EntityStateAnySimple.class );
//        return _epoch;
    }



    public void setRelease(
                    final EntityStateAnySimple release
                    )
    {
        _setStateProperty( LinuxPkgProperty.RELEASE, release );
//        _release = release;
    }


    public EntityStateAnySimple getRelease()
    {
        return _getStateProperty( LinuxPkgProperty.RELEASE, EntityStateAnySimple.class );
//        return _release;
    }



    public void setEvr(
                    final EntityStateEVRString evr
                    )
    {
        _setStateProperty( LinuxPkgProperty.EVR, evr );
//        _evr = evr;
    }


    public EntityStateEVRString getEvr()
    {
        return _getStateProperty( LinuxPkgProperty.EVR, EntityStateEVRString.class );
//        return _evr;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

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
