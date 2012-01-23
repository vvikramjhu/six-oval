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

import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.sc.EntityItemIntType;
import jp.go.aist.six.oval.model.sc.ItemType;



/**
 * The lockoutpolicy item enumerates various attributes 
 * associated with lockout information for users and global groups 
 * in the security database.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class LockoutPolicyItem
    extends ItemType
{

    private EntityItemIntType  force_logoff;
    //{0..1}

    private EntityItemIntType  lockout_duration;
    //{0..1}

    private EntityItemIntType  lockout_observation_window;
    //{0..1}

    private EntityItemIntType  lockout_threshold;
    //{0..1}



    /**
     * Constructor.
     */
    public LockoutPolicyItem()
    {
        this( 0 );
    }


    public LockoutPolicyItem(
                    final int id
                    )
    {
        super( id );

        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.lockoutpolicy;
    }



    /**
     */
    public void setForceLogoff(
                    final EntityItemIntType force_logoff
                    )
    {
        this.force_logoff = force_logoff;
    }


    public EntityItemIntType getForceLogoff()
    {
        return this.force_logoff;
    }



    /**
     */
    public void setLockoutDuration(
                    final EntityItemIntType lockout_duration
                    )
    {
        this.lockout_duration = lockout_duration;
    }


    public EntityItemIntType getLockoutDuration()
    {
        return this.lockout_duration;
    }



    /**
     */
    public void setLockoutObservationWindow(
                    final EntityItemIntType lockout_observation_window
                    )
    {
        this.lockout_observation_window = lockout_observation_window;
    }


    public EntityItemIntType getLockoutObservationWindow()
    {
        return this.lockout_observation_window;
    }



    /**
     */
    public void setLockoutThreshold(
                    final EntityItemIntType lockout_threshold
                    )
    {
        this.lockout_threshold = lockout_threshold;
    }


    public EntityItemIntType getLockoutThreshold()
    {
        return this.lockout_threshold;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "lockoutpolicy_item[" + super.toString()
                        + ", force_logoff="                 + getForceLogoff()
                        + ", lockout_duration="             + getLockoutDuration()
                        + ", lockout_obervation_window="    + getLockoutObservationWindow()
                        + ", lockout_threshold="            + getLockoutThreshold()
             + "]";
    }

}
//LockoutPolicyItem
