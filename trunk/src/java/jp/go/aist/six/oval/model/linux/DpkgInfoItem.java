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
import jp.go.aist.six.oval.model.sc.EntityItemString;
import jp.go.aist.six.oval.model.sc.Status;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class DpkgInfoItem
    extends LinuxEvrPkgInfoItem
{

    /**
     * Constructor.
     */
    public DpkgInfoItem()
    {
    }


    /**
     * Constructor.
     */
    public DpkgInfoItem(
                    final int id
                    )
    {
        super( id );
    }


    /**
     * Constructor.
     */
    public DpkgInfoItem(
                    final int id,
                    final Status status
                    )
    {
        super( id, status );
    }


    /**
     * Constructor.
     */
    public DpkgInfoItem(
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
    public DpkgInfoItem(
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
    public DpkgInfoItem(
                    final int id,
                    final String arch,
                    final String name,
                    final String version,
                    final String release,
                    final String epoch,
                    final String evr
                    )
    {
        super( id, name, arch, epoch, release, version, evr );
    }


    /**
     * Constructor.
     */
    public DpkgInfoItem(
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
        super( id, status, arch, name, version, release, epoch, evr );
    }


    /**
     * Constructor.
     */
    public DpkgInfoItem(
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
        super( id, status, arch, name, version, release, epoch, evr );
    }



    //**************************************************************
    //  Item
    //**************************************************************

    @Override
    public EntityType getObjectType()
    {
        return EntityType.LINUX_DPKGINFO;
    }



    //**************************************************************
    //  DpkgInfoItem
    //**************************************************************


    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "DpkgInfoItem[" + super.toString()
                        + "]";
    }

}
// DpkgInfoItem
