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
 * The Windows group item allows the different users and subgroups, 
 * that directly belong to specific groups (identified by name), to be collected.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class GroupItem
    extends ItemType
{

    private EntityItemStringType  group;
    //{0..1}

    private final Collection<EntityItemStringType>  user =
        new ArrayList<EntityItemStringType>();
    //{0..*}

    private final Collection<EntityItemStringType>  subgroup =
                    new ArrayList<EntityItemStringType>();
    //{0..*}



    /**
     * Constructor.
     */
    public GroupItem()
    {
        this( 0 );
    }


    public GroupItem(
                    final int id
                    )
    {
        super( id );

        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.group;
    }



    /**
     */
    public EntityItemStringType getGroup()
    {
        return this.group;
    }


    public void setGroup(
                    final EntityItemStringType group
                    )
    {
        this.group = group;
    }



    /**
     */
    public void setUser(
                    final Collection<? extends EntityItemStringType> users
                    )
    {
        if (this.user != users) {
            this.user.clear();
            if (users != null  &&  users.size() > 0) {
                this.user.addAll( users );
            }
        }
    }


    public Collection<EntityItemStringType> getUser()
    {
        return this.user;
    }


    public Iterator<EntityItemStringType> iterateUser()
    {
        return this.user.iterator();
    }



    /**
     */
    public void setSubgroup(
                    final Collection<? extends EntityItemStringType> subgroups
                    )
    {
        if (this.subgroup != subgroups) {
            this.subgroup.clear();
            if (subgroups != null  &&  subgroups.size() > 0) {
                this.subgroup.addAll( subgroups );
            }
        }
    }


    public Collection<EntityItemStringType> getSubgroup()
    {
        return this.subgroup;
    }


    public Iterator<EntityItemStringType> iterateSubgroup()
    {
        return this.subgroup.iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "group_item[" + super.toString()
             + ", group="       + getGroup()
             + ", user="        + getUser()
             + ", subgroup="    + getSubgroup()
             + "]";
    }

}
//GroupItem
