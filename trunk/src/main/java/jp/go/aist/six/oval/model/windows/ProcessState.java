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
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The process state defines the different metadata
 * associate with a Windows process.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.8:
 *             Replaced by the process58 object and
 *             will be removed in a future version of the language.
 */
@Deprecated
public class ProcessState
    extends StateType
{

    //{0..1}
    private EntityStateStringType   command_line;
    private EntityStateIntType      pid;
    private EntityStateIntType      ppid;
    private EntityStateStringType   priority;
    private EntityStateStringType   image_path;
    private EntityStateStringType   current_dir;



    /**
     * Constructor.
     */
    public ProcessState()
    {
        this( null, 0 );
    }


    public ProcessState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public ProcessState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.process;
        _oval_family = Family.WINDOWS;
        _oval_component = Component.PROCESS;
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
        return command_line;
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
        return pid;
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
        return ppid;
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
        return priority;
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
        return image_path;
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
        return current_dir;
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
        if (!(obj instanceof ProcessState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "process_state[" + super.toString()
             + ", command_line="        + getCommandLine()
             + ", pid="                 + getPid()
             + ", ppid="                + getPpid()
             + ", priority="            + getPriority()
             + ", image_path="          + getImagePath()
             + ", current_dir="         + getCurrentDir()
             + "]";
    }
}
//ProcessState
