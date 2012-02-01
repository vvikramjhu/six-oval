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
import jp.go.aist.six.oval.model.definitions.EntityStateBoolType;
import jp.go.aist.six.oval.model.definitions.EntityStateIntType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The process58 state defines the different metadata 
 * associate with a Windows process. 
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Process58State
    extends StateType
{

    //{0..1}
    private EntityStateStringType   command_line;
    private EntityStateIntType      pid;
    private EntityStateIntType      ppid;
    private EntityStateStringType   priority;
    private EntityStateStringType   image_path;
    private EntityStateStringType   current_dir;
    private EntityStateIntType      creation_time;
    private EntityStateBoolType     dep_enabled;
    private EntityStateStringType   primary_window_text;



    /**
     * Constructor.
     */
    public Process58State()
    {
        this( null, 0 );
    }


    public Process58State(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public Process58State(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.process58;
    }



    /**
     */
    public void setCommandLine(
                    final EntityStateStringType command_line
                    )
    {
        this.command_line = command_line;
    }


    public EntityStateStringType getCommandLine()
    {
        return this.command_line;
    }



    /**
     */
    public void setPid(
                    final EntityStateIntType pid
                    )
    {
        this.pid = pid;
    }


    public EntityStateIntType getPid()
    {
        return this.pid;
    }



    /**
     */
    public void setPpid(
                    final EntityStateIntType ppid
                    )
    {
        this.ppid = ppid;
    }


    public EntityStateIntType getPpid()
    {
        return this.ppid;
    }



    /**
     */
    public void setPriority(
                    final EntityStateStringType priority
                    )
    {
        this.priority = priority;
    }


    public EntityStateStringType getPriority()
    {
        return this.priority;
    }



    /**
     */
    public void setImagePath(
                    final EntityStateStringType image_path
                    )
    {
        this.image_path = image_path;
    }


    public EntityStateStringType getImagePath()
    {
        return this.image_path;
    }



    /**
     */
    public void setCurrentDir(
                    final EntityStateStringType current_dir
                    )
    {
        this.current_dir = current_dir;
    }


    public EntityStateStringType getCurrentDir()
    {
        return this.current_dir;
    }



    /**
     */
    public void setCreationTime(
                    final EntityStateIntType creation_time
                    )
    {
        this.creation_time = creation_time;
    }


    public EntityStateIntType getCreationTime()
    {
        return this.creation_time;
    }



    /**
     */
    public void setDepEnabled(
                    final EntityStateBoolType dep_enabled
                    )
    {
        this.dep_enabled = dep_enabled;
    }


    public EntityStateBoolType getDepEnabled()
    {
        return this.dep_enabled;
    }



    /**
     */
    public void setPrimaryWindowText(
                    final EntityStateStringType primary_window_text
                    )
    {
        this.primary_window_text = primary_window_text;
    }


    public EntityStateStringType getPrimaryWindowText()
    {
        return this.primary_window_text;
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
        if (!(obj instanceof Process58State)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "process58_state[" + super.toString()
             + ", command_line="        + getCommandLine()
             + ", pid="                 + getPid()
             + ", ppid="                + getPpid()
             + ", priority="            + getPriority()
             + ", image_path="          + getImagePath()
             + ", current_dir="         + getCurrentDir()
             + ", creation_time="       + getCreationTime()
             + ", dep_enabled="         + getDepEnabled()
             + ", primary_window_text=" + getPrimaryWindowText()
             + "]";
    }
}
//Process58State