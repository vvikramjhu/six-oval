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
                    final EntityItemAnySimple version,
                    final EntityItemAnySimple release,
                    final EntityItemAnySimple epoch,
                    final EntityItemEVRString evr
                    )
    {
        super( id, status, arch, name, version, release, epoch, evr );
    }



    /**
     */
    public DpkgInfoItem name(
                    final String name
                    )
    {
        setName( new EntityItemString( name ) );
        return this;
    }


    public DpkgInfoItem name(
                    final EntityItemString name
                    )
    {
        setName( name );
        return this;
    }


    public DpkgInfoItem arch(
                    final String arch
                    )
    {
        setArch( new EntityItemString( arch ) );
        return this;
    }


    public DpkgInfoItem epoch(
                    final String epoch
                    )
    {
        setEpoch( new EntityItemAnySimple( epoch ) );
        return this;
    }


    public DpkgInfoItem release(
                    final String release
                    )
    {
        setRelease( new EntityItemAnySimple( release ) );
        return this;
    }


    public DpkgInfoItem version(
                    final String version
                    )
    {
        setVersion( new EntityItemAnySimple( version ) );
        return this;
    }


    public DpkgInfoItem evr(
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
        return EntityType.LINUX_DPKGINFO;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "dpkginfo_item[" + super.toString()
                        + "]";
    }

}
// DpkgInfoItem
