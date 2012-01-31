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

package jp.go.aist.six.oval.model.linux;

import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.sc.EntityItemBoolType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;
import jp.go.aist.six.oval.model.sc.StatusEnumeration;



/**
 * This item describes the current and pending status of a SELinux boolean. 
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class SelinuxBooleanItem
    extends ItemType
{

    //{0..1}
    private EntityItemStringType           name;
    private EntityItemBoolType             current_status;
    private EntityItemBoolType             pending_status;



    /**
     * Constructor.
     */
    public SelinuxBooleanItem()
    {
        this( 0 );
    }


    public SelinuxBooleanItem(
                    final int id
                    )
    {
        this( id, null );
    }


    public SelinuxBooleanItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        super( id, status );
        
        _oval_platform_type = OvalPlatformType.linux;
        _oval_component_type = OvalComponentType.selinuxboolean;
    }



    /**
     */
    public void setName(
                    final EntityItemStringType name
                    )
    {
        this.name = name;
    }


    public EntityItemStringType getName()
    {
        return this.name;
    }



    /**
     */
    public void setCurrentStatus(
                    final EntityItemBoolType current_status
                    )
    {
        this.current_status = current_status;
    }


    public EntityItemBoolType getCurrentStatus()
    {
        return this.current_status;
    }



    /**
     */
    public void setPendingStatus(
                    final EntityItemBoolType pending_status
                    )
    {
        this.pending_status = pending_status;
    }


    public EntityItemBoolType getPendingStatus()
    {
        return this.pending_status;
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
        if (!(obj instanceof SelinuxBooleanItem)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "selinuxboolean_item[" + super.toString()
                        + ", name="             + getName()
                        + ", current_status="   + getCurrentStatus()
                        + ", pending_status="   + getPendingStatus()
             + "]";
    }

}
//SelinuxBooleanItem
