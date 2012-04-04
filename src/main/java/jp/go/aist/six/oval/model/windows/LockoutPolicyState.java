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
import jp.go.aist.six.oval.model.definitions.EntityStateIntType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The lockout policy state specifies the various attributes
 * associated with lockout information for users and global groups
 * in the security database.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class LockoutPolicyState
    extends StateType
{

    private EntityStateIntType  force_logoff;
    //{0..1}

    private EntityStateIntType  lockout_duration;
    //{0..1}

    private EntityStateIntType  lockout_observation_window;
    //{0..1}

    private EntityStateIntType  lockout_threshold;
    //{0..1}



    /**
     * Constructor.
     */
    public LockoutPolicyState()
    {
        this( null, 0 );
    }


    public LockoutPolicyState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.lockoutpolicy;
        _oval_family = Family.WINDOWS;
        _oval_component = Component.LOCKOUTPOLICY;
    }



    /**
     */
    public void setForceLogoff(
                    final EntityStateIntType force_logoff
                    )
    {
        this.force_logoff = force_logoff;
    }


    public EntityStateIntType getForceLogoff()
    {
        return force_logoff;
    }



    /**
     */
    public void setLockoutDuration(
                    final EntityStateIntType lockout_duration
                    )
    {
        this.lockout_duration = lockout_duration;
    }


    public EntityStateIntType getLockoutDuration()
    {
        return lockout_duration;
    }



    /**
     */
    public void setLockoutObservationWindow(
                    final EntityStateIntType lockout_observation_window
                    )
    {
        this.lockout_observation_window = lockout_observation_window;
    }


    public EntityStateIntType getLockoutObservationWindow()
    {
        return lockout_observation_window;
    }



    /**
     */
    public void setLockoutThreshold(
                    final EntityStateIntType lockout_threshold
                    )
    {
        this.lockout_threshold = lockout_threshold;
    }


    public EntityStateIntType getLockoutThreshold()
    {
        return lockout_threshold;
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
        if (!(obj instanceof LockoutPolicyState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "lockoutpolicy_state[" + super.toString()
                        + ", force_logoff="                 + getForceLogoff()
                        + ", lockout_duration="             + getLockoutDuration()
                        + ", lockout_obervation_window="    + getLockoutObservationWindow()
                        + ", lockout_threshold="            + getLockoutThreshold()
                        + "]";
    }

}
//LockoutPolicyState
