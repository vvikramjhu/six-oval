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

package jp.go.aist.six.oval.model.windows;

import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.definitions.EntityStateBoolType;
import jp.go.aist.six.oval.model.definitions.EntityStateIntType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The sharedresource state defines the different metadata 
 * associated with a Windows shared resource.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class SharedResourceState
    extends StateType
{

    //{0..1}
    private EntityStateStringType   netname;
    private EntityStateSharedResourceTypeType      shared_type;
    private EntityStateIntType      max_uses;
    private EntityStateIntType      current_uses;
    private EntityStateStringType   local_path;
    private EntityStateBoolType     access_read_permission;
    private EntityStateBoolType     access_write_permission;
    private EntityStateBoolType     access_create_permission;
    private EntityStateBoolType     access_exec_permission;
    private EntityStateBoolType     access_delete_permission;
    private EntityStateBoolType     access_atrib_permission;
    private EntityStateBoolType     access_perm_permission;
    private EntityStateBoolType     access_all_permission;

    

    /**
     * Constructor.
     */
    public SharedResourceState()
    {
        this( null, 0 );
    }


    public SharedResourceState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public SharedResourceState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.sharedresource;
    }



    /**
     */
    public void setNetname(
                    final EntityStateStringType netname
                    )
    {
        this.netname = netname;
    }


    public EntityStateStringType getNetname()
    {
        return this.netname;
    }



    /**
     */
    public void setSharedType(
                    final EntityStateSharedResourceTypeType shared_type
                    )
    {
        this.shared_type = shared_type;
    }


    public EntityStateSharedResourceTypeType getSharedType()
    {
        return this.shared_type;
    }



    /**
     */
    public void setMaxUses(
                    final EntityStateIntType max_uses
                    )
    {
        this.max_uses = max_uses;
    }


    public EntityStateIntType getMaxUses()
    {
        return this.max_uses;
    }



    /**
     */
    public void setCurrentUses(
                    final EntityStateIntType current_uses
                    )
    {
        this.current_uses = current_uses;
    }


    public EntityStateIntType getCurrentUses()
    {
        return this.current_uses;
    }



    /**
     */
    public void setLocalPath(
                    final EntityStateStringType local_path
                    )
    {
        this.local_path = local_path;
    }


    public EntityStateStringType getLocalPath()
    {
        return this.local_path;
    }



    /**
     */
    public void setAccessReadPermission(
                    final EntityStateBoolType access_read_permission
                    )
    {
        this.access_read_permission = access_read_permission;
    }


    public EntityStateBoolType getAccessReadPermission()
    {
        return this.access_read_permission;
    }



    /**
     */
    public void setAccessWritePermission(
                    final EntityStateBoolType access_write_permission
                    )
    {
        this.access_write_permission = access_write_permission;
    }


    public EntityStateBoolType getAccessWritePermission()
    {
        return this.access_write_permission;
    }



    /**
     */
    public void setAccessCreatePermission(
                    final EntityStateBoolType access_create_permission
                    )
    {
        this.access_create_permission = access_create_permission;
    }


    public EntityStateBoolType getAccessCreatePermission()
    {
        return this.access_create_permission;
    }



    /**
     */
    public void setAccessExecPermission(
                    final EntityStateBoolType access_exec_permission
                    )
    {
        this.access_exec_permission = access_exec_permission;
    }


    public EntityStateBoolType getAccessExecPermission()
    {
        return this.access_exec_permission;
    }



    /**
     */
    public void setAccessDeletePermission(
                    final EntityStateBoolType access_delete_permission
                    )
    {
        this.access_delete_permission = access_delete_permission;
    }


    public EntityStateBoolType getAccessDeletePermission()
    {
        return this.access_delete_permission;
    }



    /**
     */
    public void setAccessAtribPermission(
                    final EntityStateBoolType access_atrib_permission
                    )
    {
        this.access_atrib_permission = access_atrib_permission;
    }


    public EntityStateBoolType getAccessAtribPermission()
    {
        return this.access_atrib_permission;
    }



    /**
     */
    public void setAccessPermPermission(
                    final EntityStateBoolType access_perm_permission
                    )
    {
        this.access_perm_permission = access_perm_permission;
    }


    public EntityStateBoolType getAccessPermPermission()
    {
        return this.access_perm_permission;
    }



    /**
     */
    public void setAccessAllPermission(
                    final EntityStateBoolType access_all_permission
                    )
    {
        this.access_all_permission = access_all_permission;
    }


    public EntityStateBoolType getAccessAllPermission()
    {
        return this.access_all_permission;
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
        if (!(obj instanceof SharedResourceState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "sharedresource_state[" + super.toString()
             + ", netname="                     + getNetname()
             + ", shared_type="                 + getSharedType()
             + ", max_uses="                    + getMaxUses()
             + ", current_users="               + getCurrentUses()
             + ", local_path="                  + getLocalPath()
             + ", access_read_permission="      + getAccessReadPermission()
             + ", access_write_permission="     + getAccessWritePermission()
             + ", access_create_permission="    + getAccessCreatePermission()
             + ", access_exec_permission="      + getAccessExecPermission()
             + ", access_delete_permission="    + getAccessDeletePermission()
             + ", access_atrib_permission="     + getAccessAtribPermission()
             + ", access_perm_permission="      + getAccessPermPermission()
             + ", access_all_permission="       + getAccessAllPermission()
             + "]";
    }
}
//SharedResourceState
