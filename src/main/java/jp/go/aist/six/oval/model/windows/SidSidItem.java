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
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;
import jp.go.aist.six.oval.model.sc.StatusEnumeration;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class SidSidItem
    extends ItemType
{

    //{0..1}
    private EntityItemStringType   trustee_sid;
    private EntityItemStringType   trustee_name;
    private EntityItemStringType   trustee_domain;



    /**
     * Constructor.
     */
    public SidSidItem()
    {
        this( 0 );
    }


    public SidSidItem(
                    final int id
                    )
    {
        this( id, null );
    }


    public SidSidItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        super( id, status );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.sid_sid;
        _oval_family = Family.WINDOWS;
        _oval_component = ComponentType.SID_SID;
    }



    /**
     */
    public void setTrusteeSid(
                    final EntityItemStringType trustee_sid
                    )
    {
        this.trustee_sid = trustee_sid;
    }


    public EntityItemStringType getTrusteeSid()
    {
        return trustee_sid;
    }



    /**
     */
    public void setTrusteeName(
                    final EntityItemStringType trustee_name
                    )
    {
        this.trustee_name = trustee_name;
    }


    public EntityItemStringType getTrusteeName()
    {
        return trustee_name;
    }



    /**
     */
    public void setTrusteeDomain(
                    final EntityItemStringType trustee_domain
                    )
    {
        this.trustee_domain = trustee_domain;
    }


    public EntityItemStringType getTrusteeDomain()
    {
        return trustee_domain;
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
        if (!(obj instanceof SidSidItem)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "sid_sid_item[" + super.toString()
                        + ", trustee_sid="     + getTrusteeSid()
                        + ", trustee_name="    + getTrusteeName()
                        + ", trustee_domain="  + getTrusteeDomain()
             + "]";
    }
}
//SidSidItem
