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
import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.EntityStateBoolType;
import jp.go.aist.six.oval.model.definitions.EntityStateIntType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The passwordpolicy state specifies the various policies associated with passwords.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class PasswordPolicyState
    extends StateType
{

    //{0..1}
    private EntityStateIntType  max_passwd_age;
    private EntityStateIntType  min_passwd_age;
    private EntityStateIntType  min_passwd_len;
    private EntityStateIntType  password_hist_len;
    private EntityStateBoolType  password_complexity;
    private EntityStateBoolType  reversible_encryption;



    /**
     * Constructor.
     */
    public PasswordPolicyState()
    {
        this( null, 0 );
    }


    public PasswordPolicyState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.passwordpolicy;
        _oval_family = Family.WINDOWS;
        _oval_component = ComponentType.PASSWORDPOLICY;
    }



    /**
     */
    public void setMaxPasswdAge(
                    final EntityStateIntType max_passwd_age
                    )
    {
        this.max_passwd_age = max_passwd_age;
    }


    public EntityStateIntType getMaxPasswdAge()
    {
        return max_passwd_age;
    }



    /**
     */
    public void setMinPasswdAge(
                    final EntityStateIntType min_passwd_age
                    )
    {
        this.min_passwd_age = min_passwd_age;
    }


    public EntityStateIntType getMinPasswdAge()
    {
        return min_passwd_age;
    }



    /**
     */
    public void setMinPasswdLen(
                    final EntityStateIntType min_passwd_len
                    )
    {
        this.min_passwd_len = min_passwd_len;
    }


    public EntityStateIntType getMinPasswdLen()
    {
        return min_passwd_len;
    }



    /**
     */
    public void setPasswordHistLen(
                    final EntityStateIntType password_hist_len
                    )
    {
        this.password_hist_len = password_hist_len;
    }


    public EntityStateIntType getPasswordHistLen()
    {
        return password_hist_len;
    }



    /**
     */
    public void setPasswordComplexity(
                    final EntityStateBoolType password_complexity
                    )
    {
        this.password_complexity = password_complexity;
    }


    public EntityStateBoolType getPasswordComplexity()
    {
        return password_complexity;
    }



    /**
     */
    public void setReversibleEncryption(
                    final EntityStateBoolType reversible_encryption
                    )
    {
        this.reversible_encryption = reversible_encryption;
    }


    public EntityStateBoolType getReversibleEncryption()
    {
        return reversible_encryption;
    }



    //*********************************************************************
    //  DefinitionsElement
    //*********************************************************************

    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();

        ref_list.add( getMaxPasswdAge() );
        ref_list.add( getMinPasswdAge() );
        ref_list.add( getMinPasswdLen() );
        ref_list.add( getPasswordHistLen() );
        ref_list.add( getPasswordComplexity() );
        ref_list.add( getReversibleEncryption() );

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
        if (!(obj instanceof PasswordPolicyState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "passwordpolicy_state[" + super.toString()
                        + ", max_passwd_age="           + getMaxPasswdAge()
                        + ", min_passwd_age="           + getMinPasswdAge()
                        + ", min_passwd_len="           + getMinPasswdLen()
                        + ", password_hist_len="        + getPasswordHistLen()
                        + ", password_complexity="      + getPasswordComplexity()
                        + ", reversible_encryption="    + getReversibleEncryption()
                        + "]";
    }

}
//PasswordPolicyState
