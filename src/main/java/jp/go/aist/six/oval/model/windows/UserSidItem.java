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

import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.sc.EntityItemBoolType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;
import jp.go.aist.six.oval.model.sc.StatusEnumeration;



/**
 * The windows user_sid item allows the different groups (identified by SID)
 * that a user belongs to be collected.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class UserSidItem
    extends ItemType
{

    //{0..1}
    private EntityItemStringType       user_sid;
    private EntityItemBoolType         enabled;
    private EntityItemStringType       group_sid;



    /**
     * Constructor.
     */
    public UserSidItem()
    {
        this( 0 );
    }


    public UserSidItem(
                    final int id
                    )
    {
        this( id, null );
    }


    public UserSidItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        super( id, status );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.user_sid;
        _oval_family = Family.WINDOWS;
        _oval_component = ComponentType.USER_SID;
    }



    /**
     */
    public void setUserSid(
                    final EntityItemStringType user_sid
                    )
    {
        this.user_sid = user_sid;
    }


    public EntityItemStringType getUserSid()
    {
        return user_sid;
    }



    /**
     */
    public void setEnabled(
                    final EntityItemBoolType enabled
                    )
    {
        this.enabled = enabled;
    }


    public EntityItemBoolType getEnabled()
    {
        return enabled;
    }



    /**
     */
    public void setGroupSid(
                    final EntityItemStringType group_sid
                    )
    {
        this.group_sid = group_sid;
    }


    public EntityItemStringType getGroupSid()
    {
        return group_sid;
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
        if (!(obj instanceof UserSidItem)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "user_sid_item[" + super.toString()
                        + ", user_sid="     + getUserSid()
                        + ", enabled="      + getEnabled()
                        + ", group_sid="    + getGroupSid()
             + "]";
    }
}
//UserSidItem
