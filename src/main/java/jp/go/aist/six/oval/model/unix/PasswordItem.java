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

import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.sc.EntityItemIntType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class PasswordItem
    extends ItemType
{

    //{0..1}
    private EntityItemStringType   username;
    private EntityItemStringType   password;
    private EntityItemIntType      user_id;
    private EntityItemIntType      group_id;
    private EntityItemStringType   gcos;
    private EntityItemStringType   home_dir;
    private EntityItemStringType   login_shell;
    private EntityItemIntType      last_login;



    /**
     * Constructor.
     */
    public PasswordItem()
    {
        this( 0 );
    }


    public PasswordItem(
                    final int id
                    )
    {
        super( id );

//        _oval_platform_type = OvalPlatformType.unix;
//        _oval_component_type = OvalComponentType.password;
        _oval_family = Family.UNIX;
        _oval_component = Component.PASSWORD;
    }



    /**
     */
    public void setUsername(
                    final EntityItemStringType username
                    )
    {
        this.username = username;
    }


    public EntityItemStringType getUsername()
    {
        return username;
    }



    /**
     */
    public void setPassword(
                    final EntityItemStringType password
                    )
    {
        this.password = password;
    }


    public EntityItemStringType getPassword()
    {
        return password;
    }



    /**
     */
    public void setUserId(
                    final EntityItemIntType user_id
                    )
    {
        this.user_id = user_id;
    }


    public EntityItemIntType getUserId()
    {
        return user_id;
    }



    /**
     */
    public void setGroupId(
                    final EntityItemIntType group_id
                    )
    {
        this.group_id = group_id;
    }


    public EntityItemIntType getGroupId()
    {
        return group_id;
    }



    /**
     */
    public void setGcos(
                    final EntityItemStringType gcos
                    )
    {
        this.gcos = gcos;
    }


    public EntityItemStringType getGcos()
    {
        return gcos;
    }



    /**
     */
    public void setHomeDir(
                    final EntityItemStringType home_dir
                    )
    {
        this.home_dir = home_dir;
    }


    public EntityItemStringType getHomeDir()
    {
        return home_dir;
    }



    /**
     */
    public void setLoginShell(
                    final EntityItemStringType login_shell
                    )
    {
        this.login_shell = login_shell;
    }


    public EntityItemStringType getLoginShell()
    {
        return login_shell;
    }



    /**
     */
    public void setLastLogin(
                    final EntityItemIntType last_login
                    )
    {
        this.last_login = last_login;
    }


    public EntityItemIntType getLastLogin()
    {
        return last_login;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "password_item[" + super.toString()
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
//passwordItem
