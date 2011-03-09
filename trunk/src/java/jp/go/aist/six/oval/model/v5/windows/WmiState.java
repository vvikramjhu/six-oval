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

package jp.go.aist.six.oval.model.v5.windows;

import java.util.Iterator;
import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.v5.definitions.EntityAttributeGroup;
import jp.go.aist.six.oval.model.v5.definitions.EntityPropertyMap;
import jp.go.aist.six.oval.model.v5.definitions.EntityStateAnySimpleType;
import jp.go.aist.six.oval.model.v5.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.v5.definitions.StateType;



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

    private final EntityPropertyMap<WmiProperty>  _properties =
        WmiProperty.createPropertyMap();



//    private EntityStateString  _namespace;
//    //{0..1}
//
//    private EntityStateString  _wql;
//    //{0..1}
//
//    private EntityStateAnySimple  _result;
//    //{0..1}



    /**
     * Constructor.
     */
    public WmiState()
    {
    }


    public WmiState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }



    /**
     */
    public void setNamespace(
                    final EntityStateStringType namespace
                    )
    {
        _properties.setProperty( WmiProperty.NAMESPACE, namespace );
    }


    public EntityStateStringType getNamespace()
    {
        return _properties.getProperty(
                        WmiProperty.NAMESPACE, EntityStateStringType.class );
    }



    /**
     */
    public void setWql(
                    final EntityStateStringType wql
                    )
    {
        _properties.setProperty( WmiProperty.WQL, wql );
    }


    public EntityStateStringType getWql()
    {
        return _properties.getProperty(
                        WmiProperty.WQL, EntityStateStringType.class );
    }



    /**
     */
    public void setResult(
                    final EntityStateAnySimpleType result
                    )
    {
        _properties.setProperty( WmiProperty.RESULT, result );
    }


    public EntityStateAnySimpleType getResult()
    {
        return _properties.getProperty(
                        WmiProperty.RESULT, EntityStateAnySimpleType.class );
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.WINDOWS_WMI;
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
        if (!(obj instanceof WmiState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "wmi_state[" + super.toString()
                        + ", " + String.valueOf( _properties )
                        + "]";
    }

}
// WqlState
