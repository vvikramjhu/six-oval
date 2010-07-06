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
import jp.go.aist.six.oval.model.system.EntityItemString;
import jp.go.aist.six.oval.model.system.Item;
import jp.go.aist.six.oval.model.system.Status;
import java.util.EnumMap;
import java.util.Map;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class UnameItem
    extends Item
{

    private Map<UnameProperty,EntityItemString>  _properties =
        new EnumMap<UnameProperty,EntityItemString>( UnameProperty.class );

//   private EntityItemString  _machineClass;
//    //{0..1}
//
//    private EntityItemString  _nodeName;
//    //{0..1}
//
//    private EntityItemString  _osName;
//    //{0..1}
//
//    private EntityItemString  _osRelease;
//    //{0..1}
//
//    private EntityItemString  _osVersion;
//    //{0..1}
//
//    private EntityItemString  _processorType;
//    //{0..1}



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
                    final Status status
                    )
    {
        super( id, status );
    }



    /**
     * Constructor.
     */
    public UnameItem(
                    final int id,
                    final Status status,
                    final String machineClass,
                    final String nodeName,
                    final String osName,
                    final String osRelease,
                    final String osVersion,
                    final String processorType
                    )
    {
        this( id, status );

        if (machineClass != null) {
            setMachineClass( new EntityItemString( machineClass ) );
        }

        if (nodeName != null) {
            setNodeName( new EntityItemString( nodeName ) );
        }

        if (osName != null) {
            setOsName( new EntityItemString( osName ) );
        }

        if (osRelease != null) {
            setOsRelease( new EntityItemString( osRelease ) );
        }

        if (osVersion != null) {
            setOsVersion( new EntityItemString( osVersion ) );
        }

        if (processorType != null) {
            setProcessorType( new EntityItemString( processorType ) );
        }
    }


    /**
     * Constructor.
     */
    public UnameItem(
                    final int id,
                    final Status status,
                    final EntityItemString machineClass,
                    final EntityItemString nodeName,
                    final EntityItemString osName,
                    final EntityItemString osRelease,
                    final EntityItemString osVersion,
                    final EntityItemString processorType
                    )
    {
        this( id, status );
        setMachineClass( machineClass );
        setNodeName( nodeName );
        setOsName( osName );
        setOsRelease( osRelease );
        setOsVersion( osVersion );
        setProcessorType( processorType );
    }



    public EntityItemString getMachineClass()
    {
        return _properties.get( UnameProperty.MACHINE_CLASS );
    }


    public void setMachineClass(
                    final EntityItemString machineClass
                    )
    {
        _properties.put( UnameProperty.MACHINE_CLASS, machineClass );
    }



    public EntityItemString getNodeName()
    {
        return _properties.get( UnameProperty.NODE_NAME );
    }



    public void setNodeName(
                    final EntityItemString nodeName
                    )
    {
        _properties.put( UnameProperty.NODE_NAME, nodeName );
    }



    public EntityItemString getOsName()
    {
        return _properties.get( UnameProperty.OS_NAME );
    }


    public void setOsName(
                    final EntityItemString osName
                    )
    {
        _properties.put( UnameProperty.OS_NAME, osName );
    }



    public EntityItemString getOsRelease()
    {
        return _properties.get( UnameProperty.OS_RELEASE );
    }


    public void setOsRelease(
                    final EntityItemString osRelease
                    )
    {
        _properties.put( UnameProperty.OS_RELEASE, osRelease );
    }



    public EntityItemString getOsVersion()
    {
        return _properties.get( UnameProperty.OS_VERSION );
    }


    public void setOsVersion(
                    final EntityItemString osVersion
                    )
    {
        _properties.put( UnameProperty.OS_VERSION, osVersion );
    }



    public EntityItemString getProcessorType()
    {
        return _properties.get( UnameProperty.PROCESSOR_TYPE );
    }



    public void setProcessorType(
                    final EntityItemString processorType
                    )
    {
        _properties.put( UnameProperty.PROCESSOR_TYPE, processorType );
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
