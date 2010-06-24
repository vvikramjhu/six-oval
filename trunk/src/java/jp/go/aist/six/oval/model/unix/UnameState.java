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

import jp.go.aist.six.oval.core.model.ComponentType;
import jp.go.aist.six.oval.model.definition.EntityStateStringType;
import jp.go.aist.six.oval.model.definition.State;
import java.util.EnumMap;
import java.util.Map;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class UnameState
    extends State
{

    private Map<UnameProperty,EntityStateStringType>  _properties =
        new EnumMap<UnameProperty,EntityStateStringType>( UnameProperty.class );



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
     *
     */
    protected Map<UnameProperty,EntityStateStringType> _getProperties()
    {
        return _properties;
    }



    /**
     */
    public void setMachineClass(
                    final EntityStateStringType machineClass
                    )
    {
        _properties.put( UnameProperty.MACHINE_CLASS, machineClass );
    }


    public EntityStateStringType getMachineClass()
    {
        return _properties.get( UnameProperty.MACHINE_CLASS );
    }



    /**
     */
    public void setNodeName(
                    final EntityStateStringType nodeName
                    )
    {
        _properties.put( UnameProperty.NODE_NAME, nodeName );
    }


    public EntityStateStringType getNodeName()
    {
        return _properties.get( UnameProperty.NODE_NAME );
    }



    /**
     */
    public void setOsName(
                    final EntityStateStringType name
                    )
    {
        _properties.put( UnameProperty.OS_NAME, name );
    }


    public EntityStateStringType getOsName()
    {
        return _properties.get( UnameProperty.OS_NAME );
    }



    /**
     */
    public void setOsRelease(
                    final EntityStateStringType release
                    )
    {
        _properties.put( UnameProperty.OS_RELEASE, release );
    }


    public EntityStateStringType getOsRelease()
    {
        return _properties.get( UnameProperty.OS_RELEASE );
    }



    /**
     */
    public void setOsVersion(
                    final EntityStateStringType version
                    )
    {
        _properties.put( UnameProperty.OS_VERSION, version );
    }


    public EntityStateStringType getOsVersion()
    {
        return _properties.get( UnameProperty.OS_VERSION );
    }



    /**
     */
    public void setProcessorType(
                    final EntityStateStringType type
                    )
    {
        _properties.put( UnameProperty.PROCESSOR_TYPE, type );
    }


    public EntityStateStringType getProcessorType()
    {
        return _properties.get( UnameProperty.PROCESSOR_TYPE );
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public ComponentType getStateType()
    {
        return ComponentType.UNIX_UNAME;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        result = prime * result + _getProperties().hashCode();

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof UnameState)) {
            return false;
        }

        if (super.equals( obj )) {
            UnameState  other = (UnameState)obj;
            Map<UnameProperty,EntityStateStringType>  other_props = other._getProperties();
            Map<UnameProperty,EntityStateStringType>   this_props =  this._getProperties();
            if (this_props == other_props
                            ||  (this_props != null  &&  this_props.equals( other_props ))) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "UnameState[" + super.toString() + "]";
    }

}
// UnameState
