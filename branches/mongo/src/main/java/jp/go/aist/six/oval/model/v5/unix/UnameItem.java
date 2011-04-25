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

package jp.go.aist.six.oval.model.v5.unix;

import java.util.EnumMap;
import java.util.Map;
import jp.go.aist.six.oval.model.v5.PlatformEntityType;
import jp.go.aist.six.oval.model.v5.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.v5.sc.ItemType;
import jp.go.aist.six.oval.model.v5.sc.StatusEnumeration;



/**
 * Information about the hardware the machine is running on.
 * This information is the parsed equivalent of uname -a.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class UnameItem
    extends ItemType
{

    private final Map<UnameProperty,EntityItemStringType>  _properties =
        new EnumMap<UnameProperty,EntityItemStringType>( UnameProperty.class );

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


    public UnameItem(
                    final int id
                    )
    {
        super( id );
    }


    public UnameItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        super( id, status );
    }


    public UnameItem(
                    final int id,
                    final StatusEnumeration status,
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
            setMachineClass( new EntityItemStringType( machineClass ) );
        }

        if (nodeName != null) {
            setNodeName( new EntityItemStringType( nodeName ) );
        }

        if (osName != null) {
            setOsName( new EntityItemStringType( osName ) );
        }

        if (osRelease != null) {
            setOsRelease( new EntityItemStringType( osRelease ) );
        }

        if (osVersion != null) {
            setOsVersion( new EntityItemStringType( osVersion ) );
        }

        if (processorType != null) {
            setProcessorType( new EntityItemStringType( processorType ) );
        }
    }


    public UnameItem(
                    final int id,
                    final StatusEnumeration status,
                    final EntityItemStringType machineClass,
                    final EntityItemStringType nodeName,
                    final EntityItemStringType osName,
                    final EntityItemStringType osRelease,
                    final EntityItemStringType osVersion,
                    final EntityItemStringType processorType
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



    /**
     */
    public EntityItemStringType getMachineClass()
    {
        return _properties.get( UnameProperty.MACHINE_CLASS );
    }


    public void setMachineClass(
                    final EntityItemStringType machineClass
                    )
    {
        _properties.put( UnameProperty.MACHINE_CLASS, machineClass );
    }



    public EntityItemStringType getNodeName()
    {
        return _properties.get( UnameProperty.NODE_NAME );
    }



    public void setNodeName(
                    final EntityItemStringType nodeName
                    )
    {
        _properties.put( UnameProperty.NODE_NAME, nodeName );
    }



    /**
     */
    public EntityItemStringType getOsName()
    {
        return _properties.get( UnameProperty.OS_NAME );
    }


    public void setOsName(
                    final EntityItemStringType osName
                    )
    {
        _properties.put( UnameProperty.OS_NAME, osName );
    }



    /**
     */
    public EntityItemStringType getOsRelease()
    {
        return _properties.get( UnameProperty.OS_RELEASE );
    }


    public void setOsRelease(
                    final EntityItemStringType osRelease
                    )
    {
        _properties.put( UnameProperty.OS_RELEASE, osRelease );
    }



    /**
     */
    public EntityItemStringType getOsVersion()
    {
        return _properties.get( UnameProperty.OS_VERSION );
    }


    public void setOsVersion(
                    final EntityItemStringType osVersion
                    )
    {
        _properties.put( UnameProperty.OS_VERSION, osVersion );
    }



    /**
     */
    public EntityItemStringType getProcessorType()
    {
        return _properties.get( UnameProperty.PROCESSOR_TYPE );
    }



    public void setProcessorType(
                    final EntityItemStringType processorType
                    )
    {
        _properties.put( UnameProperty.PROCESSOR_TYPE, processorType );
    }



    //**************************************************************
    //  Item
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.UNIX_UNAME;
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
