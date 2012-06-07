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
import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.Family;
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

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.group;
        _oval_family = Family.WINDOWS;
        _oval_component = ComponentType.GROUP;
    }



    /**
     */
    public EntityItemStringType getGroup()
    {
        return group;
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
        if (user != users) {
            user.clear();
            if (users != null  &&  users.size() > 0) {
                user.addAll( users );
            }
        }
    }


    public Collection<EntityItemStringType> getUser()
    {
        return user;
    }


    public Iterator<EntityItemStringType> iterateUser()
    {
        return user.iterator();
    }



    /**
     */
    public void setSubgroup(
                    final Collection<? extends EntityItemStringType> subgroups
                    )
    {
        if (subgroup != subgroups) {
            subgroup.clear();
            if (subgroups != null  &&  subgroups.size() > 0) {
                subgroup.addAll( subgroups );
            }
        }
    }


    public Collection<EntityItemStringType> getSubgroup()
    {
        return subgroup;
    }


    public Iterator<EntityItemStringType> iterateSubgroup()
    {
        return subgroup.iterator();
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
