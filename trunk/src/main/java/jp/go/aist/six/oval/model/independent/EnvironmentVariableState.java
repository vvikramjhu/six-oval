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

package jp.go.aist.six.oval.model.independent;

import java.util.ArrayList;
import java.util.Collection;
import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimpleType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The environmentvariable state contains three entities that are used
 * to check the name of the specified environment variable,
 * the process ID of the process from which the environment variable
 * was retrieved, and the value associated with the environment variable.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.8:
 *             Replaced by the environmentvariable58 state and
 *             will be removed in a future version of the language.
 */
@Deprecated
public class EnvironmentVariableState
    extends StateType
{

    private EntityStateStringType  name;
    //{0..1}

    private EntityStateAnySimpleType  value;
    //{0..1}



    /**
     * Constructor.
     */
    public EnvironmentVariableState()
    {
        this( null, 0 );
    }


    public EnvironmentVariableState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public EnvironmentVariableState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

//        _oval_platform_type = OvalPlatformType.independent;
//        _oval_component_type = OvalComponentType.environmentvariable;
        _oval_family = Family.INDEPENDENT;
        _oval_component = Component.ENVIRONMENTVARIABLE;
    }



    /**
     */
    public void setName(
                    final EntityStateStringType pattern
                    )
    {
        name = pattern;
    }


    public EntityStateStringType getName()
    {
        return name;
    }



    /**
     */
    public void setValue(
                    final EntityStateAnySimpleType value
                    )
    {
        this.value = value;
    }


    public EntityStateAnySimpleType getValue()
    {
        return value;
    }



    //*********************************************************************
    //  DefinitionsElement
    //*********************************************************************

    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();
        ref_list.add( getName() );
        ref_list.add( getValue() );

        return ref_list;
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
        if (!(obj instanceof EnvironmentVariableState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "environmentvariable_state[" + super.toString()
                        + ", name="      + getName()
                        + ", value="     + getValue()
                        + "]";
    }

}
// EnvironmentVariableState
