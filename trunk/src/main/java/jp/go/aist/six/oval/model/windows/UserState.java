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
import jp.go.aist.six.oval.model.definitions.EntityStateBoolType;
import jp.go.aist.six.oval.model.definitions.EntityStateIntType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The user state enumerates the different groups (identified by name)
 * that a Windows user might belong to.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class UserState
    extends StateType
{

    //{0..1}
    private EntityStateStringType       user;
    private EntityStateBoolType         enabled;
    private EntityStateStringType       group;
    private EntityStateIntType          last_logon;



    /**
     * Constructor.
     */
    public UserState()
    {
        this( null, 0 );
    }


    public UserState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public UserState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.user;
        _oval_family = Family.WINDOWS;
        _oval_component = Component.USER;
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
    public void setEnabled(
                    final EntityStateBoolType enabled
                    )
    {
        this.enabled = enabled;
    }


    public EntityStateBoolType getEnabled()
    {
        return enabled;
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
    public void setLastLogon(
                    final EntityStateIntType last_logon
                    )
    {
        this.last_logon = last_logon;
    }


    public EntityStateIntType getLastLogon()
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
        if (!(obj instanceof UserState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "user_state[" + super.toString()
                        + ", user="         + getUser()
                        + ", enabled="      + getEnabled()
                        + ", group="        + getGroup()
                        + ", last_logon="   + getLastLogon()
             + "]";
    }

}
//UserState
