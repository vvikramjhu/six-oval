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

import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.EntityStateIntType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The partition state defines the different information
 * associated with a partition.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class PartitionState
    extends StateType
{

    //{0..1}
    private EntityStateStringType   mount_point;
    private EntityStateStringType   device;
    private EntityStateStringType   uuid;
    private EntityStateStringType   fs_type;
    private EntityStateStringType   mount_options;
    private EntityStateIntType      total_space;
    private EntityStateIntType      space_used;
    private EntityStateIntType      space_left;



    /**
     * Constructor.
     */
    public PartitionState()
    {
        this( null, 0 );
    }


    public PartitionState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public PartitionState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

//        _oval_platform_type = OvalPlatformType.linux;
//        _oval_component_type = OvalComponentType.partition;
        _oval_family = Family.LINUX;
        _oval_component = Component.PARTITION;
    }



    /**
     */
    public void setMountPoint(
                    final EntityStateStringType mount_point
                    )
    {
        this.mount_point = mount_point;
    }


    public EntityStateStringType getMountPoint()
    {
        return mount_point;
    }



    /**
     */
    public void setDevice(
                    final EntityStateStringType device
                    )
    {
        this.device = device;
    }


    public EntityStateStringType getDevice()
    {
        return device;
    }



    /**
     */
    public void setUuid(
                    final EntityStateStringType uuid
                    )
    {
        this.uuid = uuid;
    }


    public EntityStateStringType getUuid()
    {
        return uuid;
    }



    /**
     */
    public void setFsType(
                    final EntityStateStringType fs_type
                    )
    {
        this.fs_type = fs_type;
    }


    public EntityStateStringType getFsType()
    {
        return fs_type;
    }



    /**
     */
    public void setMountOptions(
                    final EntityStateStringType mount_options
                    )
    {
        this.mount_options = mount_options;
    }


    public EntityStateStringType getMountOptions()
    {
        return mount_options;
    }



    /**
     */
    public void setTotalSpace(
                    final EntityStateIntType total_space
                    )
    {
        this.total_space = total_space;
    }


    public EntityStateIntType getTotalSpace()
    {
        return total_space;
    }



    /**
     */
    public void setSpaceUsed(
                    final EntityStateIntType space_used
                    )
    {
        this.space_used = space_used;
    }


    public EntityStateIntType getSpaceUsed()
    {
        return space_used;
    }



    /**
     */
    public void setSpaceLeft(
                    final EntityStateIntType space_left
                    )
    {
        this.space_left = space_left;
    }


    public EntityStateIntType getSpaceLeft()
    {
        return space_left;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

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
        if (!(obj instanceof PartitionState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "partition_state[" + super.toString()
                        + ", mount_point="      + getMountPoint()
                        + ", device="           + getDevice()
                        + ", uuid="             + getUuid()
                        + ", fs_type="          + getFsType()
                        + ", mount_options="    + getMountOptions()
                        + ", total_space="      + getTotalSpace()
                        + ", space_used="       + getSpaceUsed()
                        + ", space_left="       + getSpaceLeft()
                        + "]";
    }

}
//PartitionState
