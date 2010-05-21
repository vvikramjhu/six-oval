/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
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

import jp.go.aist.six.oval.core.model.system.ItemType;
import jp.go.aist.six.oval.model.system.Item;
import jp.go.aist.six.oval.model.system.ItemStatus;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: UnameItem.java 772 2010-05-11 03:03:12Z akihito $
 */
public class UnameItem
    extends Item
{

    private String  _machineClass;
    //{oval-sc:EntityItemStringType, 0..1}

    private String  _nodeName;
    //{oval-sc:EntityItemStringType, 0..1}

    private String  _osName;
    //{oval-sc:EntityItemStringType, 0..1}

    private String  _osRelease;
    //{oval-sc:EntityItemStringType, 0..1}

    private String  _osVersion;
    //{oval-sc:EntityItemStringType, 0..1}

    private String  _processorType;
    //{oval-sc:EntityItemStringType, 0..1}



    /**
     * Constructor.
     */
    public UnameItem()
    {
    }


    /**
     * Constructor.
     */
    public UnameItem(
                    final int id
                    )
    {
        super( id );
    }


    /**
     * Constructor.
     */
    public UnameItem(
                    final int id,
                    final ItemStatus status
                    )
    {
        super( id, status );
    }



    public String getMachineClass()
    {
        return _machineClass;
    }


    public void setMachineClass(
                    final String machineClass
                    )
    {
        _machineClass = machineClass;
    }



    public String getNodeName()
    {
        return _nodeName;
    }



    public void setNodeName(
                    final String nodeName
                    )
    {
        _nodeName = nodeName;
    }



    public String getOsName()
    {
        return _osName;
    }


    public void setOsName(
                    final String osName
                    )
    {
        _osName = osName;
    }



    public String getOsRelease()
    {
        return _osRelease;
    }


    public void setOsRelease(
                    final String osRelease
                    )
    {
        _osRelease = osRelease;
    }



    public String getOsVersion()
    {
        return _osVersion;
    }


    public void setOsVersion(
                    final String osVersion
                    )
    {
        _osVersion = osVersion;
    }



    public String getProcessorType()
    {
        return _processorType;
    }



    public void setProcessorType(
                    final String processorType
                    )
    {
        _processorType = processorType;
    }



    //**************************************************************
    //  Item
    //**************************************************************

    @Override
    public ItemType getItemType()
    {
        return ItemType.UNIX_UNAME;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "uname_item[" + super.toString()
                        + ", machine_class=" + getMachineClass()
                        + ", node_name=" + getNodeName()
                        + ", os_name=" + getOsName()
                        + ", os_release=" + getOsRelease()
                        + ", os_version=" + getOsVersion()
                        + ", processor_type=" + getProcessorType()
                        + "]";
    }

}
// UnameItem
