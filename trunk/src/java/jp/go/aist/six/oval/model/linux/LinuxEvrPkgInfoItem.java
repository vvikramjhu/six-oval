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

import jp.go.aist.six.oval.model.system.EntityItemString;
import jp.go.aist.six.oval.model.system.Status;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: LinuxEvrPkgInfoItem.java 763 2010-05-10 08:30:29Z akihito $
 */
public abstract class LinuxEvrPkgInfoItem
    extends LinuxPkgInfoItem
{

//    private EntityItemString  _release;
//    //{0..1}
//
//    private EntityItemString  _epoch;
//    //{0..1}
//
//    private EntityItemString  _evr;
//    //{0..1}



    /**
     * Constructor.
     */
    public LinuxEvrPkgInfoItem()
    {
    }


    /**
     * Constructor.
     */
    public LinuxEvrPkgInfoItem(
                    final int id
                    )
    {
        super( id );
    }


    /**
     * Constructor.
     */
    public LinuxEvrPkgInfoItem(
                    final int id,
                    final Status status
                    )
    {
        super( id, status );
    }


    /**
     * Constructor.
     */
    public LinuxEvrPkgInfoItem(
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
    public LinuxEvrPkgInfoItem(
                    final int id,
                    final Status status,
                    final EntityItemString name
                    )
    {
        super( id, status, name );
    }



    /**
     * Constructor.
     */
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


    /**
     * Constructor.
     */
    public LinuxEvrPkgInfoItem(
                    final int id,
                    final Status status,
                    final String arch,
                    final String name,
                    final String version,
                    final String release,
                    final String epoch,
                    final String evr
                    )
    {
        super( id, status, arch, name, version );

        if (epoch != null) {
            setEpoch( new EntityItemString( epoch ) );
        }

        if (release != null) {
            setRelease( new EntityItemString( release ) );
        }

        if (evr != null) {
            setEvr( new EntityItemString( evr ) );
        }
    }


    /**
     * Constructor.
     */
    public LinuxEvrPkgInfoItem(
                    final int id,
                    final Status status,
                    final EntityItemString arch,
                    final EntityItemString name,
                    final EntityItemString version,
                    final EntityItemString release,
                    final EntityItemString epoch,
                    final EntityItemString evr
                    )
    {
        super( id, status, arch, name, version );

        setEpoch( epoch );
        setRelease( release );
        setEvr( evr );
    }



    public void setRelease(
                    final EntityItemString release
                    )
    {
        _properties.put( LinuxPkgProperty.RELEASE, release );
//        _release = release;
    }


    public EntityItemString getRelease()
    {
        return _properties.get( LinuxPkgProperty.RELEASE );
    }



    public void setEpoch(
                    final EntityItemString epoch
                    )
    {
        _properties.put( LinuxPkgProperty.EPOCH, epoch );
//        _epoch = epoch;
    }


    public EntityItemString getEpoch()
    {
        return _properties.get( LinuxPkgProperty.EPOCH );
    }



    public void setEvr(
                    final EntityItemString evr
                    )
    {
        _properties.put( LinuxPkgProperty.EVR, evr );
//        _evr = evr;
    }


    public EntityItemString getEvr()
    {
        return _properties.get( LinuxPkgProperty.EVR );
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return super.toString()
                        + ", evr=" + getEvr();
    }

}
// LinuxEvrPkgInfoItem
