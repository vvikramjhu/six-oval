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
import jp.go.aist.six.oval.model.definitions.EntityStateBase;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.State;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;



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

    private Map<UnameProperty, EntityStateBase>  _properties =
        new EnumMap<UnameProperty, EntityStateBase>( UnameProperty.class );



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



//    /**
//     *
//     */
//    protected Map<UnameProperty, EntityStateString> _getProperties()
//    {
//        return _properties;
//    }



    /**
     */
    public void setMachineClass(
                    final EntityStateString machineClass
                    )
    {
        _setStateProperty( UnameProperty.MACHINE_CLASS, machineClass );
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
        return _getStateProperty( UnameProperty.MACHINE_CLASS, EntityStateString.class );
    }



    /**
     */
    public void setNodeName(
                    final EntityStateString nodeName
                    )
    {
        _setStateProperty( UnameProperty.NODE_NAME, nodeName );
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
        return _getStateProperty( UnameProperty.NODE_NAME, EntityStateString.class );
    }



    /**
     */
    public void setOsName(
                    final EntityStateString name
                    )
    {
        _setStateProperty( UnameProperty.OS_NAME, name );
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
        return _getStateProperty( UnameProperty.OS_NAME, EntityStateString.class );
    }



    /**
     */
    public void setOsRelease(
                    final EntityStateString release
                    )
    {
        _setStateProperty( UnameProperty.OS_RELEASE, release );
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
        return _getStateProperty( UnameProperty.OS_RELEASE, EntityStateString.class );
    }



    /**
     */
    public void setOsVersion(
                    final EntityStateString version
                    )
    {
        _setStateProperty( UnameProperty.OS_VERSION, version );
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
        return _getStateProperty( UnameProperty.OS_VERSION, EntityStateString.class );
    }



    /**
     */
    public void setProcessorType(
                    final EntityStateString type
                    )
    {
        _setStateProperty( UnameProperty.PROCESSOR_TYPE, type );
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
        return _getStateProperty( UnameProperty.PROCESSOR_TYPE, EntityStateString.class );
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
    public Iterator<EntityStateBase> iterateProperties()
    {
        return _properties.values().iterator();
    }



    protected <T extends EntityStateBase> T _getStateProperty(
                    final UnameProperty key,
                    final Class<T> type
                    )
    {
        EntityStateBase  p = _properties.get( key );
        return type.cast( p );
    }



    protected void _setStateProperty(
                    final UnameProperty key,
                    final EntityStateBase value
                    )
    {
        _properties.put( key, value );
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
        return "uname_state[" + super.toString() + "]";
    }

}
// UnameState
