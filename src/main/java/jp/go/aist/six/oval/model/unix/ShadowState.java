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
 * The shadows state defines the different information associated with the system shadow file.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class ShadowState
    extends StateType
{

    //{0..1}
    private EntityStateStringType           username;
    private EntityStateStringType           password;
    private EntityStateIntType              chg_lst;
    private EntityStateIntType              chg_allow;
    private EntityStateIntType              chg_req;
    private EntityStateIntType              exp_warn;
    private EntityStateIntType              exp_inact;
    private EntityStateIntType              exp_date;
    private EntityStateStringType           flag;
    private EntityStateEncryptMethodType    encrypt_method;


    
    /**
     * Constructor.
     */
    public ShadowState()
    {
        this( null, 0 );
    }


    public ShadowState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public ShadowState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.unix;
        _oval_component_type = OvalComponentType.shadow;
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
    public void setChgLst(
                    final EntityStateIntType chg_lst
                    )
    {
        this.chg_lst = chg_lst;
    }


    public EntityStateIntType getChgLst()
    {
        return this.chg_lst;
    }



    /**
     */
    public void setChgAllow(
                    final EntityStateIntType chg_allow
                    )
    {
        this.chg_allow = chg_allow;
    }


    public EntityStateIntType getChgAllow()
    {
        return this.chg_allow;
    }



    /**
     */
    public void setChgReq(
                    final EntityStateIntType chg_req
                    )
    {
        this.chg_req = chg_req;
    }


    public EntityStateIntType getChgReq()
    {
        return this.chg_req;
    }



    /**
     */
    public void setExpWarn(
                    final EntityStateIntType exp_warn
                    )
    {
        this.exp_warn = exp_warn;
    }


    public EntityStateIntType getExpWarn()
    {
        return this.exp_warn;
    }



    /**
     */
    public void setExpInact(
                    final EntityStateIntType exp_inact
                    )
    {
        this.exp_inact = exp_inact;
    }


    public EntityStateIntType getExpInact()
    {
        return this.exp_inact;
    }



    /**
     */
    public void setExpDate( 
                    final EntityStateIntType exp_date 
                    )
    {
        this.exp_date = exp_date;
    }

    
    public EntityStateIntType getExpDate()
    {
        return exp_date;
    }


    
    /**
     */
    public void setFlag( 
                    final EntityStateStringType flag 
                    )
    {
        this.flag = flag;
    }

    
    public EntityStateStringType getFlag()
    {
        return this.flag;
    }


    
    /**
     */
    public void setEncryptMethod( 
                    final EntityStateEncryptMethodType encrypt_method 
                    )
    {
        this.encrypt_method = encrypt_method;
    }

    
    public EntityStateEncryptMethodType getEncryptMethod()
    {
        return this.encrypt_method;
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
        if (!(obj instanceof ShadowState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "shadow_state[" + super.toString()
             + ", username="        + getUsername()
             + ", password="        + getPassword()
             + ", chg_lst="         + getChgLst()
             + ", chg_allow="       + getChgAllow()
             + ", chg_req="         + getChgReq()
             + ", exp_warn="        + getExpWarn()
             + ", exp_inact="       + getExpInact()
             + ", exp_date="        + getExpDate()
             + ", flag="            + getFlag()
             + ", encrypt_method="  + getEncryptMethod()
             + "]";
    }

}
//ShadowState
