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

import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimpleType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.7:
 *             Replaced by the wmi57 state and
 *             will be removed in a future version of the language.
 */
@Deprecated
public class WmiState
    extends StateType
{

    private EntityStateStringType  namespace;
    //{0..1}

    private EntityStateStringType  wql;
    //{0..1}

    private EntityStateAnySimpleType  result;
    //{0..1}


//    private final EntityPropertyMap<WmiProperty>  _properties =
//        WmiProperty.createPropertyMap();




    /**
     * Constructor.
     */
    public WmiState()
    {
        this( null, 0 );
    }


    public WmiState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.wmi;
        _oval_family = Family.WINDOWS;
        _oval_component = Component.WMI;
    }



    /**
     */
    public void setNamespace(
                    final EntityStateStringType namespace
                    )
    {
        this.namespace = namespace;
//        _properties.setProperty( WmiProperty.NAMESPACE, namespace );
    }


    public EntityStateStringType getNamespace()
    {
        return namespace;
//        return _properties.getProperty(
//                        WmiProperty.NAMESPACE, EntityStateStringType.class );
    }



    /**
     */
    public void setWql(
                    final EntityStateStringType wql
                    )
    {
        this.wql = wql;
//        _properties.setProperty( WmiProperty.WQL, wql );
    }


    public EntityStateStringType getWql()
    {
        return wql;
//        return _properties.getProperty(
//                        WmiProperty.WQL, EntityStateStringType.class );
    }



    /**
     */
    public void setResult(
                    final EntityStateAnySimpleType result
                    )
    {
        this.result = result;
//        _properties.setProperty( WmiProperty.RESULT, result );
    }


    public EntityStateAnySimpleType getResult()
    {
        return result;
//        return _properties.getProperty(
//                        WmiProperty.RESULT, EntityStateAnySimpleType.class );
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
        if (!(obj instanceof WmiState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "wmi_state[" + super.toString()
                        + ", " + getNamespace()
                        + ", " + getWql()
                        + ", " + getResult()
//                        + ", " + String.valueOf( _properties )
                        + "]";
    }

}
//WmiState
