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

package jp.go.aist.six.oval.model.unix;

import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.definitions.EntityStateIntType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The password state defines the different information associated with the system passwords.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class PasswordState
    extends StateType
{

    //{0..1}
    private EntityStateStringType   username;
    private EntityStateStringType   password;
    private EntityStateIntType      user_id;
    private EntityStateIntType      group_id;
    private EntityStateStringType   gcos;
    private EntityStateStringType   home_dir;
    private EntityStateStringType   login_shell;
    private EntityStateIntType      last_login;



    
    /**
     * Constructor.
     */
    public PasswordState()
    {
        this( null, 0 );
    }


    public PasswordState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public PasswordState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.unix;
        _oval_component_type = OvalComponentType.password;
    }



    /**
     */
    public void setUsername(
                    final EntityStateStringType username
                    )
    {
        this.username = username;
    }


    public EntityStateStringType getUsername()
    {
        return this.username;
    }



    /**
     */
    public void setPassword(
                    final EntityStateStringType password
                    )
    {
        this.password = password;
    }


    public EntityStateStringType getPassword()
    {
        return this.password;
    }



    /**
     */
    public void setUserId(
                    final EntityStateIntType user_id
                    )
    {
        this.user_id = user_id;
    }


    public EntityStateIntType getUserId()
    {
        return this.user_id;
    }



    /**
     */
    public void setGroupId(
                    final EntityStateIntType group_id
                    )
    {
        this.group_id = group_id;
    }


    public EntityStateIntType getGroupId()
    {
        return this.group_id;
    }



    /**
     */
    public void setGcos(
                    final EntityStateStringType gcos
                    )
    {
        this.gcos = gcos;
    }


    public EntityStateStringType getGcos()
    {
        return this.gcos;
    }



    /**
     */
    public void setHomeDir(
                    final EntityStateStringType home_dir
                    )
    {
        this.home_dir = home_dir;
    }


    public EntityStateStringType getHomeDir()
    {
        return this.home_dir;
    }



    /**
     */
    public void setLoginShell(
                    final EntityStateStringType login_shell
                    )
    {
        this.login_shell = login_shell;
    }


    public EntityStateStringType getLoginShell()
    {
        return this.login_shell;
    }



    /**
     */
    public void setLastLogin( 
                    final EntityStateIntType last_login 
                    )
    {
        this.last_login = last_login;
    }

    
    public EntityStateIntType getLastLogin()
    {
        return last_login;
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
        if (!(obj instanceof PasswordState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "password_state[" + super.toString()
             + ", username="        + getUsername()
             + ", password="        + getPassword()
             + ", user_id="         + getUserId()
             + ", group_id="        + getGroupId()
             + ", gcos="            + getGcos()
             + ", home_dir="        + getHomeDir()
             + ", login_shell="     + getLoginShell()
             + ", last_login="      + getLastLogin()
             + "]";
    }

}
//PasswordState
