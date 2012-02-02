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
import jp.go.aist.six.oval.model.definitions.EntityStateBoolType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The runlevel state holds information about 
 * whether a specific service is scheduled to start or stop at a given runlevel.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RunlevelState
    extends StateType
{

    //{0..1}
    private EntityStateStringType       service_name;
    private EntityStateStringType       runlevel;
    private EntityStateBoolType         start;
    private EntityStateBoolType         kill;



    /**
     * Constructor.
     */
    public RunlevelState()
    {
        this( null, 0 );
    }


    public RunlevelState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public RunlevelState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.unix;
        _oval_component_type = OvalComponentType.runlevel;
    }



    /**
     */
    public void setServiceName(
                    final EntityStateStringType service_name
                    )
    {
        this.service_name = service_name;
    }


    public EntityStateStringType getServiceName()
    {
        return this.service_name;
    }



    /**
     */
    public void setRunlevel(
                    final EntityStateStringType runlevel
                    )
    {
        this.runlevel = runlevel;
    }


    public EntityStateStringType getRunlevel()
    {
        return this.runlevel;
    }



    /**
     */
    public void setStart(
                    final EntityStateBoolType start
                    )
    {
        this.start = start;
    }


    public EntityStateBoolType getStart()
    {
        return this.start;
    }



    /**
     */
    public void setKill(
                    final EntityStateBoolType kill
                    )
    {
        this.kill = kill;
    }


    public EntityStateBoolType getKill()
    {
        return this.kill;
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
        if (!(obj instanceof RunlevelState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "runlevel_state[" + super.toString()
                        + ", service_name="     + getServiceName()
                        + ", runlevel="         + getRunlevel()
                        + ", start="            + getStart()
                        + ", kill="             + getKill()
             + "]";
    }

}
//RunlevelState
