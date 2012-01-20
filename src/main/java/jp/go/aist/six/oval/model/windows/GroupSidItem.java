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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;



/**
 * The Windows group_sid item allows the different users and subgroups, 
 * that directly belong to specific groups (identified by SID), to be collected.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class GroupSidItem
    extends ItemType
{

    private EntityItemStringType  group_sid;
    //{0..1}

    private final Collection<EntityItemStringType>  user_sid =
        new ArrayList<EntityItemStringType>();
    //{0..*}

    private final Collection<EntityItemStringType>  subgroup_sid =
                    new ArrayList<EntityItemStringType>();
    //{0..*}



    /**
     * Constructor.
     */
    public GroupSidItem()
    {
        this( 0 );
    }


    public GroupSidItem(
                    final int id
                    )
    {
        super( id );

        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.group_sid;
    }



    /**
     */
    public EntityItemStringType getGroupSid()
    {
        return this.group_sid;
    }


    public void setGroupSid(
                    final EntityItemStringType group_sid
                    )
    {
        this.group_sid = group_sid;
    }



    /**
     */
    public void setUserSid(
                    final Collection<? extends EntityItemStringType> user_sids
                    )
    {
        if (this.user_sid != user_sids) {
            this.user_sid.clear();
            if (user_sids != null  &&  user_sids.size() > 0) {
                this.user_sid.addAll( user_sids );
            }
        }
    }


    public Collection<EntityItemStringType> getUserSid()
    {
        return this.user_sid;
    }


    public Iterator<EntityItemStringType> iterateUserSid()
    {
        return this.user_sid.iterator();
    }



    /**
     */
    public void setSubgroupSid(
                    final Collection<? extends EntityItemStringType> subgroup_sids
                    )
    {
        if (this.subgroup_sid != subgroup_sids) {
            this.subgroup_sid.clear();
            if (subgroup_sids != null  &&  subgroup_sids.size() > 0) {
                this.subgroup_sid.addAll( subgroup_sids );
            }
        }
    }


    public Collection<EntityItemStringType> getSubgroupSid()
    {
        return this.subgroup_sid;
    }


    public Iterator<EntityItemStringType> iterateSubgroupSid()
    {
        return this.subgroup_sid.iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "group_sid_item[" + super.toString()
             + ", group_sid="       + getGroupSid()
             + ", user_sid="        + getUserSid()
             + ", subgroup_sid="    + getSubgroupSid()
             + "]";
    }

}
//GroupSidItem
