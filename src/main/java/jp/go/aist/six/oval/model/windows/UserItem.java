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

import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.sc.EntityItemBoolType;
import jp.go.aist.six.oval.model.sc.EntityItemIntType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;
import jp.go.aist.six.oval.model.sc.StatusEnumeration;



/**
 * The windows user item allows the different groups (identified by name)
 * that a user belongs to be collected.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class UserItem
    extends ItemType
{

    //{0..1}
    private EntityItemStringType       user;
    private EntityItemBoolType         enabled;
    private EntityItemStringType       group;
    private EntityItemIntType          last_logon;



    /**
     * Constructor.
     */
    public UserItem()
    {
        this( 0 );
    }


    public UserItem(
                    final int id
                    )
    {
        this( id, null );
    }


    public UserItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        super( id, status );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.user;
        _oval_family = Family.WINDOWS;
        _oval_component = Component.USER;
    }



    /**
     */
    public void setUser(
                    final EntityItemStringType user
                    )
    {
        this.user = user;
    }


    public EntityItemStringType getUser()
    {
        return user;
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
    public void setGroup(
                    final EntityItemStringType group
                    )
    {
        this.group = group;
    }


    public EntityItemStringType getGroup()
    {
        return group;
    }



    /**
     */
    public void setLastLogon(
                    final EntityItemIntType last_logon
                    )
    {
        this.last_logon = last_logon;
    }


    public EntityItemIntType getLastLogon()
    {
        return last_logon;
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
        if (!(obj instanceof UserItem)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "user_item[" + super.toString()
                        + ", user="         + getUser()
                        + ", enabled="      + getEnabled()
                        + ", group="        + getGroup()
                        + ", last_logon="   + getLastLogon()
             + "]";
    }
}
//UserItem
