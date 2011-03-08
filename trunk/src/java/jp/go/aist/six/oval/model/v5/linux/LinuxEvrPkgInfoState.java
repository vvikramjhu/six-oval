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

import jp.go.aist.six.oval.model.v5.definitions.EntityStateAnySimpleType;
import jp.go.aist.six.oval.model.v5.definitions.EntityStateEVRStringType;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class LinuxEvrPkgInfoState
    extends LinuxPkgInfoState
{

//    private EntityStateAnySimple  _epoch;
//    //{0..1}
//
//    private EntityStateAnySimple  _release;
//    //{0..1}
//
//    private EntityStateEVRString  _evr;
//    //{0..1}



    /**
     * Constructor.
     */
    public LinuxEvrPkgInfoState()
    {
    }


    public LinuxEvrPkgInfoState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }



    /**
     */
    public void setEpoch(
                    final EntityStateAnySimpleType epoch
                    )
    {
        _setProperty( LinuxPkgProperty.EPOCH, epoch );
    }


    public EntityStateAnySimpleType getEpoch()
    {
        return _getProperty(
                        LinuxPkgProperty.EPOCH, EntityStateAnySimpleType.class );
    }



    /**
     */
    public void setRelease(
                    final EntityStateAnySimpleType release
                    )
    {
        _setProperty( LinuxPkgProperty.RELEASE, release );
    }


    public EntityStateAnySimpleType getRelease()
    {
        return _getProperty(
                        LinuxPkgProperty.RELEASE, EntityStateAnySimpleType.class );
    }



    /**
     */
    public void setEvr(
                    final EntityStateEVRStringType evr
                    )
    {
        _setProperty( LinuxPkgProperty.EVR, evr );
    }


    public EntityStateEVRStringType getEvr()
    {
        return _getProperty(
                        LinuxPkgProperty.EVR, EntityStateEVRStringType.class );
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

}
// LinuxEvrPkgInfoState
