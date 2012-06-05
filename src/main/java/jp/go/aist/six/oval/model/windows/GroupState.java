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
import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The group state enumerates the different users and subgroups
 * directly associated with a Windows group.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class GroupState
    extends StateType
{

    //{0..1}
    private EntityStateStringType   group;
    private EntityStateStringType   user;
    private EntityStateStringType   subgroup;



    /**
     * Constructor.
     */
    public GroupState()
    {
        this( null, 0 );
    }


    public GroupState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public GroupState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.group;
        _oval_family = Family.WINDOWS;
        _oval_component = Component.GROUP;
    }



    /**
     */
    public void setGroup(
                    final EntityStateStringType group
                    )
    {
        this.group = group;
    }


    public EntityStateStringType getGroup()
    {
        return group;
    }



    /**
     */
    public void setUser(
                    final EntityStateStringType user
                    )
    {
        this.user = user;
    }


    public EntityStateStringType getUser()
    {
        return user;
    }



    /**
     */
    public void setSubgroup(
                    final EntityStateStringType subgroup
                    )
    {
        this.subgroup = subgroup;
    }


    public EntityStateStringType getSubgroup()
    {
        return subgroup;
    }



    //*********************************************************************
    //  DefinitionsElement
    //*********************************************************************

    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();
        ref_list.add( getGroup() );
        ref_list.add( getUser() );
        ref_list.add( getSubgroup() );

        return ref_list;
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
        if (!(obj instanceof GroupState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "group_state[" + super.toString()
             + ", group="       + getGroup()
             + ", user="        + getUser()
             + ", subgroup="    + getSubgroup()
             + "]";
    }
}
//GroupState
