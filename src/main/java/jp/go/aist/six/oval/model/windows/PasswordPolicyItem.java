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
import jp.go.aist.six.oval.model.sc.ItemType;



/**
 * The password policy item specific policy items associated with passwords.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class PasswordPolicyItem
    extends ItemType
{

    //{0..1}
    private EntityItemIntType  max_passwd_age;
    private EntityItemIntType  min_passwd_age;
    private EntityItemIntType  min_passwd_len;
    private EntityItemIntType  password_hist_len;
    private EntityItemBoolType  password_complexity;
    private EntityItemBoolType  reversible_encryption;



    /**
     * Constructor.
     */
    public PasswordPolicyItem()
    {
        this( 0 );
    }


    public PasswordPolicyItem(
                    final int id
                    )
    {
        super( id );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.passwordpolicy;
        _oval_family = Family.WINDOWS;
        _oval_component = Component.PASSWORDPOLICY;
    }



    /**
     */
    public void setMaxPasswdAge(
                    final EntityItemIntType max_passwd_age
                    )
    {
        this.max_passwd_age = max_passwd_age;
    }


    public EntityItemIntType getMaxPasswdAge()
    {
        return max_passwd_age;
    }



    /**
     */
    public void setMinPasswdAge(
                    final EntityItemIntType min_passwd_age
                    )
    {
        this.min_passwd_age = min_passwd_age;
    }


    public EntityItemIntType getMinPasswdAge()
    {
        return min_passwd_age;
    }



    /**
     */
    public void setMinPasswdLen(
                    final EntityItemIntType min_passwd_len
                    )
    {
        this.min_passwd_len = min_passwd_len;
    }


    public EntityItemIntType getMinPasswdLen()
    {
        return min_passwd_len;
    }



    /**
     */
    public void setPasswordHistLen(
                    final EntityItemIntType password_hist_len
                    )
    {
        this.password_hist_len = password_hist_len;
    }


    public EntityItemIntType getPasswordHistLen()
    {
        return password_hist_len;
    }



    /**
     */
    public void setPasswordComplexity(
                    final EntityItemBoolType password_complexity
                    )
    {
        this.password_complexity = password_complexity;
    }


    public EntityItemBoolType getPasswordComplexity()
    {
        return password_complexity;
    }



    /**
     */
    public void setReversibleEncryption(
                    final EntityItemBoolType reversible_encryption
                    )
    {
        this.reversible_encryption = reversible_encryption;
    }


    public EntityItemBoolType getReversibleEncryption()
    {
        return reversible_encryption;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "passwordpolicy_item[" + super.toString()
                        + ", max_passwd_age="           + getMaxPasswdAge()
                        + ", min_passwd_age="           + getMinPasswdAge()
                        + ", min_passwd_len="           + getMinPasswdLen()
                        + ", password_hist_len="        + getPasswordHistLen()
                        + ", password_complexity="      + getPasswordComplexity()
                        + ", reversible_encryption="    + getReversibleEncryption()
             + "]";
    }

}
//PasswordPolicyItem
