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
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The group_sid state enumerates the different users and subgroups 
 * directly associated with a Windows group.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class GroupSidState
    extends StateType
{

    //{0..1}
    private EntityStateStringType   group_sid;
    private EntityStateStringType   user_sid;
    private EntityStateStringType   subgroup_sid;



    /**
     * Constructor.
     */
    public GroupSidState()
    {
        this( null, 0 );
    }


    public GroupSidState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public GroupSidState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.group_sid;
    }



    /**
     */
    public void setGroupSid(
                    final EntityStateStringType group_sid
                    )
    {
        this.group_sid = group_sid;
    }


    public EntityStateStringType getGroupSid()
    {
        return this.group_sid;
    }



    /**
     */
    public void setUserSid(
                    final EntityStateStringType user_sid
                    )
    {
        this.user_sid = user_sid;
    }


    public EntityStateStringType getUserSid()
    {
        return this.user_sid;
    }



    /**
     */
    public void setSubgroupSid(
                    final EntityStateStringType subgroup_sid
                    )
    {
        this.subgroup_sid = subgroup_sid;
    }


    public EntityStateStringType getSubgroupSid()
    {
        return this.subgroup_sid;
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
        if (!(obj instanceof GroupSidState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "group_sid_state[" + super.toString()
             + ", group_sid="       + getGroupSid()
             + ", user_sid="        + getUserSid()
             + ", subgroup_sid="    + getSubgroupSid()
             + "]";
    }
}
//GroupSidState
