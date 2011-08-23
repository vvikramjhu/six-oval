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

import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.v5.PlatformEntityType;
import jp.go.aist.six.oval.model.v5.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.v5.definitions.StateType;



/**
 * The uname state defines the information about the hardware
 * the machine is running one.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class UnameState
    extends StateType
{

    private EntityStateStringType  machine_class;
    //{0..1}

    private EntityStateStringType  node_name;
    //{0..1}

    private EntityStateStringType  os_name;
    //{0..1}

    private EntityStateStringType  os_release;
    //{0..1}

    private EntityStateStringType  os_version;
    //{0..1}

    private EntityStateStringType  processor_type;
    //{0..1}



//    private final EntityPropertyMap<UnameProperty>  _properties =
//        UnameProperty.createPropertyMap();



    /**
     * Constructor.
     */
    public UnameState()
    {
        this( null, 0 );
    }


    public UnameState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public UnameState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.unix;
        _oval_component_type = OvalComponentType.uname;
    }



    /**
     */
    public void setMachineClass(
                    final EntityStateStringType machine_class
                    )
    {
        this.machine_class = machine_class;
//        _properties.setProperty( UnameProperty.MACHINE_CLASS, machineClass );
    }


    public EntityStateStringType getMachineClass()
    {
        return this.machine_class;
//        return _properties.getProperty(
//                        UnameProperty.MACHINE_CLASS, EntityStateStringType.class );
    }


    public UnameState machineClass(
                    final EntityStateStringType machine_class
                    )
    {
        setMachineClass( machine_class );
        return this;
    }



    /**
     */
    public void setNodeName(
                    final EntityStateStringType node_name
                    )
    {
        this.node_name = node_name;
//        _properties.setProperty( UnameProperty.NODE_NAME, nodeName );
    }


    public UnameState nodeName(
                    final EntityStateStringType nodeName
                    )
    {
        setNodeName( nodeName );
        return this;
    }


    public EntityStateStringType getNodeName()
    {
        return this.node_name;
//        return _properties.getProperty(
//                        UnameProperty.NODE_NAME, EntityStateStringType.class );
    }



    /**
     */
    public void setOsName(
                    final EntityStateStringType os_name
                    )
    {
        this.os_name = os_name;
//        _properties.setProperty( UnameProperty.OS_NAME, name );
    }


    public EntityStateStringType getOsName()
    {
        return this.os_name;
//        return _properties.getProperty(
//                        UnameProperty.OS_NAME, EntityStateStringType.class );
    }


    public UnameState osName(
                    final EntityStateStringType os_name
                    )
    {
        setOsName( os_name );
        return this;
    }



    /**
     */
    public void setOsRelease(
                    final EntityStateStringType os_release
                    )
    {
        this.os_release = os_release;
//        _properties.setProperty( UnameProperty.OS_RELEASE, release );
    }


    public EntityStateStringType getOsRelease()
    {
        return this.os_release;
//        return _properties.getProperty(
//                        UnameProperty.OS_RELEASE, EntityStateStringType.class );
    }


    public UnameState osRelease(
                    final EntityStateStringType release
                    )
    {
        setOsRelease( release );
        return this;
    }



    /**
     */
    public void setOsVersion(
                    final EntityStateStringType os_version
                    )
    {
        this.os_version = os_version;
//        _properties.setProperty( UnameProperty.OS_VERSION, version );
    }


    public EntityStateStringType getOsVersion()
    {
        return this.os_version;
//        return _properties.getProperty(
//                        UnameProperty.OS_VERSION, EntityStateStringType.class );
    }


    public UnameState osVersion(
                    final EntityStateStringType os_version
                    )
    {
        setOsVersion( os_version );
        return this;
    }



    /**
     */
    public void setProcessorType(
                    final EntityStateStringType type
                    )
    {
        this.processor_type = type;
//        _properties.setProperty( UnameProperty.PROCESSOR_TYPE, type );
    }


    public EntityStateStringType getProcessorType()
    {
        return this.processor_type;
//        return _properties.getProperty(
//                        UnameProperty.PROCESSOR_TYPE, EntityStateStringType.class );
    }


    public UnameState processorType(
                    final EntityStateStringType type
                    )
    {
        setProcessorType( type );
        return this;
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.UNIX_UNAME;
    }



//    @Override
//    public Iterator<EntityAttributeGroup> iterateProperties()
//    {
//        return _properties.iterateProperties();
//    }



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
        if (!(obj instanceof UnameState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "uname_state[" + super.toString()
                        + ", machine_class=" + getMachineClass()
                        + ", node_name=" + getNodeName()
                        + ", os_name=" + getOsName()
                        + ", os_release=" + getOsRelease()
                        + ", os_version=" + getOsVersion()
                        + ", processor_type=" + getProcessorType()
//                        + ", " + String.valueOf( _properties )
                        + "]";
    }

}
// UnameState
