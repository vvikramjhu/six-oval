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

import jp.go.aist.six.oval.model.system.ItemStatus;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: LinuxEvrPkgInfoItem.java 763 2010-05-10 08:30:29Z akihito $
 */
public abstract class LinuxEvrPkgInfoItem
    extends LinuxPkgInfoItem
{

    private String  _release;
    //{oval-sc:EntityItemStringType, 0..1}

    private String  _epoch;
    //{oval-sc:EntityItemStringType, 0..1}

    private String  _evr;
    //{oval-sc:EntityItemStringType, 0..1}



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
                    final ItemStatus status
                    )
    {
        super( id, status );
    }


    /**
     * Constructor.
     */
    public LinuxEvrPkgInfoItem(
                    final int id,
                    final ItemStatus status,
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
                    final String arch,
                    final String name,
                    final String version,
                    final String release,
                    final String epoch,
                    final String evr
                    )
    {
        this( id, DEFAULT_STATUS, name, arch, epoch, release, version, evr );
    }


    /**
     * Constructor.
     */
    public LinuxEvrPkgInfoItem(
                    final int id,
                    final ItemStatus status,
                    final String arch,
                    final String name,
                    final String version,
                    final String release,
                    final String epoch,
                    final String evr
                    )
    {
        this( id, status );
        setName( name );
        setArch( arch );
        setEpoch( epoch );
        setRelease( release);
        setVersion( version );
        setEvr( evr );
    }



    public void setRelease(
                    final String release
                    )
    {
        _release = release;
    }


    public String getRelease()
    {
        return _release;
    }



    public void setEpoch(
                    final String epoch
                    )
    {
        _epoch = epoch;
    }


    public String getEpoch()
    {
        return _epoch;
    }



    public void setEvr(
                    final String evr
                    )
    {
        _evr = evr;
    }


    public String getEvr()
    {
        return _evr;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return super.toString()
                        + ", evr=" + getEvr();
    }

}
// LinuxEvrPkgInfoItem
