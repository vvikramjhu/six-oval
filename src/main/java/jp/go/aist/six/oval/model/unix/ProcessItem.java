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
import jp.go.aist.six.oval.model.sc.StatusEnumeration;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.8:
 *             Replaced by the process58 item.
 */
public class ProcessItem
    extends ItemType
{

    //{0..1}
    private EntityItemStringType   command;
    private EntityItemStringType   exec_time;
    private EntityItemIntType      pid;
    private EntityItemIntType      ppid;
    private EntityItemIntType      priority;
    private EntityItemIntType      ruid;
    private EntityItemStringType   scheduling_class;
    private EntityItemStringType   start_time;
    private EntityItemStringType   tty;
    private EntityItemIntType      user_id;



    /**
     * Constructor.
     */
    public ProcessItem()
    {
        this( 0 );
    }


    public ProcessItem(
                    final int id
                    )
    {
        this( id, null );
    }


    public ProcessItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        super( id, status );

        _oval_platform_type = OvalPlatformType.unix;
        _oval_component_type = OvalComponentType.process;
    }



    /**
     */
    public void setCommand(
                    final EntityItemStringType command
                    )
    {
        this.command = command;
    }


    public EntityItemStringType getCommand()
    {
        return this.command;
    }



    /**
     */
    public void setExecTime(
                    final EntityItemStringType exec_time
                    )
    {
        this.exec_time = exec_time;
    }


    public EntityItemStringType getExecTime()
    {
        return this.exec_time;
    }



    /**
     */
    public void setPid(
                    final EntityItemIntType pid
                    )
    {
        this.pid = pid;
    }


    public EntityItemIntType getPid()
    {
        return this.pid;
    }



    /**
     */
    public void setPpid(
                    final EntityItemIntType ppid
                    )
    {
        this.ppid = ppid;
    }


    public EntityItemIntType getPpid()
    {
        return this.ppid;
    }



    /**
     */
    public void setPriority(
                    final EntityItemIntType priority
                    )
    {
        this.priority = priority;
    }


    public EntityItemIntType getPriority()
    {
        return this.priority;
    }



    /**
     */
    public void setRuid(
                    final EntityItemIntType ruid
                    )
    {
        this.ruid = ruid;
    }


    public EntityItemIntType getRuid()
    {
        return this.ruid;
    }



    /**
     */
    public void setSchedulingClass(
                    final EntityItemStringType scheduling_class
                    )
    {
        this.scheduling_class = scheduling_class;
    }


    public EntityItemStringType getSchedulingClass()
    {
        return this.scheduling_class;
    }



    /**
     */
    public void setStartTime(
                    final EntityItemStringType start_time
                    )
    {
        this.start_time = start_time;
    }


    public EntityItemStringType getStartTime()
    {
        return this.start_time;
    }



    /**
     */
    public void setTty(
                    final EntityItemStringType tty
                    )
    {
        this.tty = tty;
    }


    public EntityItemStringType getTty()
    {
        return this.tty;
    }



    /**
     */
    public void setUserId(
                    final EntityItemIntType user_id
                    )
    {
        this.user_id = user_id;
    }


    public EntityItemIntType getUserId()
    {
        return this.user_id;
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
        if (!(obj instanceof ProcessItem)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "process_item[" + super.toString()
                        + ", command="              + getCommand()
                        + ", exec_time="            + getExecTime()
                        + ", pid="                  + getPid()
                        + ", ppid="                 + getPpid()
                        + ", priority="             + getPriority()
                        + ", ruid="                 + getRuid()
                        + ", scheduling_class="     + getSchedulingClass()
                        + ", start_time="           + getStartTime()
                        + ", tty="                  + getTty()
                        + ", user_id="              + getUserId()
             + "]";
    }

}
//ProcessItem
