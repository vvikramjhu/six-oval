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

import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.definitions.EntityBase;
import jp.go.aist.six.oval.model.definitions.EntityPropertyMap;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.State;
import java.util.Iterator;



/**
 * The uname state defines the information about the hardware
 * the machine is running one.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class UnameState
    extends State
{

    private EntityPropertyMap<UnameProperty>  _properties =
        UnameProperty.createPropertyMap();

//    private EnumMap<UnameProperty, EntityBase>  _properties =
//        new EnumMap<UnameProperty, EntityBase>( UnameProperty.class );



    /**
     * Constructor.
     */
    public UnameState()
    {
    }


    /**
     * Constructor.
     */
    public UnameState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
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
                    final EntityStateString machineClass
                    )
    {
        _properties.setProperty( UnameProperty.MACHINE_CLASS, machineClass );
//        _setStateProperty( UnameProperty.MACHINE_CLASS, machineClass );
    }


    public UnameState machineClass(
                    final EntityStateString machineClass
                    )
    {
        setMachineClass( machineClass );
        return this;
    }


    public EntityStateString getMachineClass()
    {
        return _properties.getProperty(
                        UnameProperty.MACHINE_CLASS, EntityStateString.class );
//        return _getStateProperty( UnameProperty.MACHINE_CLASS, EntityStateString.class );
    }



    /**
     */
    public void setNodeName(
                    final EntityStateString nodeName
                    )
    {
        _properties.setProperty( UnameProperty.NODE_NAME, nodeName );
    }


    public UnameState nodeName(
                    final EntityStateString nodeName
                    )
    {
        setNodeName( nodeName );
        return this;
    }


    public EntityStateString getNodeName()
    {
        return _properties.getProperty(
                        UnameProperty.NODE_NAME, EntityStateString.class );
    }



    /**
     */
    public void setOsName(
                    final EntityStateString name
                    )
    {
        _properties.setProperty( UnameProperty.OS_NAME, name );
    }


    public UnameState osName(
                    final EntityStateString name
                    )
    {
        setOsName( name );
        return this;
    }


    public EntityStateString getOsName()
    {
        return _properties.getProperty(
                        UnameProperty.OS_NAME, EntityStateString.class );
    }



    /**
     */
    public void setOsRelease(
                    final EntityStateString release
                    )
    {
        _properties.setProperty( UnameProperty.OS_RELEASE, release );
    }


    public UnameState osRelease(
                    final EntityStateString release
                    )
    {
        setOsRelease( release );
        return this;
    }


    public EntityStateString getOsRelease()
    {
        return _properties.getProperty(
                        UnameProperty.OS_RELEASE, EntityStateString.class );
    }



    /**
     */
    public void setOsVersion(
                    final EntityStateString version
                    )
    {
        _properties.setProperty( UnameProperty.OS_VERSION, version );
    }


    public UnameState osVersion(
                    final EntityStateString version
                    )
    {
        setOsVersion( version );
        return this;
    }


    public EntityStateString getOsVersion()
    {
        return _properties.getProperty(
                        UnameProperty.OS_VERSION, EntityStateString.class );
    }



    /**
     */
    public void setProcessorType(
                    final EntityStateString type
                    )
    {
        _properties.setProperty( UnameProperty.PROCESSOR_TYPE, type );
    }


    public UnameState processorType(
                    final EntityStateString type
                    )
    {
        setProcessorType( type );
        return this;
    }


    public EntityStateString getProcessorType()
    {
        return _properties.getProperty(
                        UnameProperty.PROCESSOR_TYPE, EntityStateString.class );
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
    public Iterator<EntityBase> iterateProperties()
    {
        return _properties.iterateProperties();
    }



//    protected <T extends EntityStateBase> T _getStateProperty(
//                    final UnameProperty key,
//                    final Class<T> type
//                    )
//    {
//        EntityBase  p = _properties.get( key );
//        return type.cast( p );
//    }
//
//
//
//    protected void _setStateProperty(
//                    final UnameProperty key,
//                    final EntityStateBase value
//                    )
//    {
//        _properties.put( key, value );
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
                        + ", " + String.valueOf( _properties )
                        + "]";
    }

}
// UnameState
