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
import jp.go.aist.six.oval.model.sc.EntityItemIntType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class ShadowItem
    extends ItemType
{

    //{0..1}
    private EntityItemStringType           username;
    private EntityItemStringType           password;
    private EntityItemIntType              chg_lst;
    private EntityItemIntType              chg_allow;
    private EntityItemIntType              chg_req;
    private EntityItemIntType              exp_warn;
    private EntityItemIntType              exp_inact;
    private EntityItemIntType              exp_date;
    private EntityItemStringType           flag;
    private EntityItemEncryptMethodType    encrypt_method;



    /**
     * Constructor.
     */
    public ShadowItem()
    {
        this( 0 );
    }


    public ShadowItem(
                    final int id
                    )
    {
        super( id );

        _oval_platform_type = OvalPlatformType.unix;
        _oval_component_type = OvalComponentType.shadow;
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
        return this.username;
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
        return this.password;
    }



    /**
     */
    public void setChgLst(
                    final EntityItemIntType chg_lst
                    )
    {
        this.chg_lst = chg_lst;
    }


    public EntityItemIntType getChgLst()
    {
        return this.chg_lst;
    }



    /**
     */
    public void setChgAllow(
                    final EntityItemIntType chg_allow
                    )
    {
        this.chg_allow = chg_allow;
    }


    public EntityItemIntType getChgAllow()
    {
        return this.chg_allow;
    }



    /**
     */
    public void setChgReq(
                    final EntityItemIntType chg_req
                    )
    {
        this.chg_req = chg_req;
    }


    public EntityItemIntType getChgReq()
    {
        return this.chg_req;
    }



    /**
     */
    public void setExpWarn(
                    final EntityItemIntType exp_warn
                    )
    {
        this.exp_warn = exp_warn;
    }


    public EntityItemIntType getExpWarn()
    {
        return this.exp_warn;
    }



    /**
     */
    public void setExpInact(
                    final EntityItemIntType exp_inact
                    )
    {
        this.exp_inact = exp_inact;
    }


    public EntityItemIntType getExpInact()
    {
        return this.exp_inact;
    }



    /**
     */
    public void setExpDate( 
                    final EntityItemIntType exp_date 
                    )
    {
        this.exp_date = exp_date;
    }

    
    public EntityItemIntType getExpDate()
    {
        return exp_date;
    }


    
    /**
     */
    public void setFlag( 
                    final EntityItemStringType flag 
                    )
    {
        this.flag = flag;
    }

    
    public EntityItemStringType getFlag()
    {
        return this.flag;
    }


    
    /**
     */
    public void setEncryptMethod( 
                    final EntityItemEncryptMethodType encrypt_method 
                    )
    {
        this.encrypt_method = encrypt_method;
    }

    
    public EntityItemEncryptMethodType getEncryptMethod()
    {
        return this.encrypt_method;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "shadow_item[" + super.toString()
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
//ShadowItem
