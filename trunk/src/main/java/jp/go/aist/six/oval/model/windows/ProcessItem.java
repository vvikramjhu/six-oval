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
import jp.go.aist.six.oval.model.sc.EntityItemBoolType;
import jp.go.aist.six.oval.model.sc.EntityItemIntType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;
import jp.go.aist.six.oval.model.sc.StatusEnumeration;



/**
 * This item stores the information about running processes.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class ProcessItem
    extends ItemType
{

    //{0..1}
    private EntityItemStringType   command_line;
    private EntityItemIntType      pid;
    private EntityItemIntType      ppid;
    private EntityItemStringType   priority;
    private EntityItemStringType   image_path;
    private EntityItemStringType   current_dir;
    private EntityItemIntType      creation_time;
    private EntityItemBoolType     dep_enabled;
    private EntityItemStringType   primary_window_text;



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
        
        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.process;
    }



    /**
     */
    public void setCommandLine(
                    final EntityItemStringType command_line
                    )
    {
        this.command_line = command_line;
    }


    public EntityItemStringType getCommandLine()
    {
        return this.command_line;
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
                    final EntityItemStringType priority
                    )
    {
        this.priority = priority;
    }


    public EntityItemStringType getPriority()
    {
        return this.priority;
    }



    /**
     */
    public void setImagePath(
                    final EntityItemStringType image_path
                    )
    {
        this.image_path = image_path;
    }


    public EntityItemStringType getImagePath()
    {
        return this.image_path;
    }



    /**
     */
    public void setCurrentDir(
                    final EntityItemStringType current_dir
                    )
    {
        this.current_dir = current_dir;
    }


    public EntityItemStringType getCurrentDir()
    {
        return this.current_dir;
    }



    /**
     */
    public void setCreationTime(
                    final EntityItemIntType creation_time
                    )
    {
        this.creation_time = creation_time;
    }


    public EntityItemIntType getCreationTime()
    {
        return this.creation_time;
    }



    /**
     */
    public void setDepEnabled(
                    final EntityItemBoolType dep_enabled
                    )
    {
        this.dep_enabled = dep_enabled;
    }


    public EntityItemBoolType getDepEnabled()
    {
        return this.dep_enabled;
    }



    /**
     */
    public void setPrimaryWindowText(
                    final EntityItemStringType primary_window_text
                    )
    {
        this.primary_window_text = primary_window_text;
    }


    public EntityItemStringType getPrimaryWindowText()
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
        if (!(obj instanceof ProcessItem)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "process_item[" + super.toString()
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
//ProcessItem
