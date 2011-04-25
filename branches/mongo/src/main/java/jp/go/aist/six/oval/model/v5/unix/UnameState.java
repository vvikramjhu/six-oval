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

import java.util.Iterator;
import jp.go.aist.six.oval.model.v5.PlatformEntityType;
import jp.go.aist.six.oval.model.v5.definitions.EntityAttributeGroup;
import jp.go.aist.six.oval.model.v5.definitions.EntityPropertyMap;
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

    private final EntityPropertyMap<UnameProperty>  _properties =
        UnameProperty.createPropertyMap();



    /**
     * Constructor.
     */
    public UnameState()
    {
    }


    public UnameState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    public UnameState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );
    }



    /**
     */
    public void setMachineClass(
                    final EntityStateStringType machineClass
                    )
    {
        _properties.setProperty( UnameProperty.MACHINE_CLASS, machineClass );
    }


    public UnameState machineClass(
                    final EntityStateStringType machineClass
                    )
    {
        setMachineClass( machineClass );
        return this;
    }


    public EntityStateStringType getMachineClass()
    {
        return _properties.getProperty(
                        UnameProperty.MACHINE_CLASS, EntityStateStringType.class );
    }



    /**
     */
    public void setNodeName(
                    final EntityStateStringType nodeName
                    )
    {
        _properties.setProperty( UnameProperty.NODE_NAME, nodeName );
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
        return _properties.getProperty(
                        UnameProperty.NODE_NAME, EntityStateStringType.class );
    }



    /**
     */
    public void setOsName(
                    final EntityStateStringType name
                    )
    {
        _properties.setProperty( UnameProperty.OS_NAME, name );
    }


    public UnameState osName(
                    final EntityStateStringType name
                    )
    {
        setOsName( name );
        return this;
    }


    public EntityStateStringType getOsName()
    {
        return _properties.getProperty(
                        UnameProperty.OS_NAME, EntityStateStringType.class );
    }



    /**
     */
    public void setOsRelease(
                    final EntityStateStringType release
                    )
    {
        _properties.setProperty( UnameProperty.OS_RELEASE, release );
    }


    public UnameState osRelease(
                    final EntityStateStringType release
                    )
    {
        setOsRelease( release );
        return this;
    }


    public EntityStateStringType getOsRelease()
    {
        return _properties.getProperty(
                        UnameProperty.OS_RELEASE, EntityStateStringType.class );
    }



    /**
     */
    public void setOsVersion(
                    final EntityStateStringType version
                    )
    {
        _properties.setProperty( UnameProperty.OS_VERSION, version );
    }


    public UnameState osVersion(
                    final EntityStateStringType version
                    )
    {
        setOsVersion( version );
        return this;
    }


    public EntityStateStringType getOsVersion()
    {
        return _properties.getProperty(
                        UnameProperty.OS_VERSION, EntityStateStringType.class );
    }



    /**
     */
    public void setProcessorType(
                    final EntityStateStringType type
                    )
    {
        _properties.setProperty( UnameProperty.PROCESSOR_TYPE, type );
    }


    public UnameState processorType(
                    final EntityStateStringType type
                    )
    {
        setProcessorType( type );
        return this;
    }


    public EntityStateStringType getProcessorType()
    {
        return _properties.getProperty(
                        UnameProperty.PROCESSOR_TYPE, EntityStateStringType.class );
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.UNIX_UNAME;
    }



    @Override
    public Iterator<EntityAttributeGroup> iterateProperties()
    {
        return _properties.iterateProperties();
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
        if (!(obj instanceof UnameState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "uname_state[" + super.toString()
                        + ", " + String.valueOf( _properties )
                        + "]";
    }

}
// UnameState
