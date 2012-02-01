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
import jp.go.aist.six.oval.model.definitions.EntityStateBoolType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The selinuxboolean state defines the different information 
 * that can be used to evaluate the specified SELinux boolean.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class SelinuxBooleanState
    extends StateType
{

    //{0..1}
    private EntityStateStringType           name;
    private EntityStateBoolType             current_status;
    private EntityStateBoolType             pending_status;



    /**
     * Constructor.
     */
    public SelinuxBooleanState()
    {
        this( null, 0 );
    }


    public SelinuxBooleanState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public SelinuxBooleanState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.linux;
        _oval_component_type = OvalComponentType.selinuxboolean;
    }



    /**
     */
    public void setName(
                    final EntityStateStringType name
                    )
    {
        this.name = name;
    }


    public EntityStateStringType getName()
    {
        return this.name;
    }



    /**
     */
    public void setCurrentStatus(
                    final EntityStateBoolType current_status
                    )
    {
        this.current_status = current_status;
    }


    public EntityStateBoolType getCurrentStatus()
    {
        return this.current_status;
    }



    /**
     */
    public void setPendingStatus(
                    final EntityStateBoolType pending_status
                    )
    {
        this.pending_status = pending_status;
    }


    public EntityStateBoolType getPendingStatus()
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
        if (!(obj instanceof SelinuxBooleanState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "selinuxboolean_state[" + super.toString()
                        + ", name="             + getName()
                        + ", current_status="   + getCurrentStatus()
                        + ", pending_status="   + getPendingStatus()
             + "]";
    }

}
//SelinuxBooleanState