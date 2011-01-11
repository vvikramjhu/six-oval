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

import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimple;
import jp.go.aist.six.oval.model.definitions.EntityStateBase;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.State;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.7:
 *             Replaced by the wmi57 state and
 *             will be removed in a future version of the language.
 */
public class WmiState
    extends State
{

    private Map<WmiProperty, EntityStateBase>  _properties =
        new EnumMap<WmiProperty, EntityStateBase>( WmiProperty.class );



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


    /**
     * Constructor.
     */
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
                    final EntityStateString namespace
                    )
    {
        _setStateProperty( WmiProperty.NAMESPACE, namespace );
    }


    public EntityStateString getNamespace()
    {
        return _getStateProperty( WmiProperty.NAMESPACE, EntityStateString.class );
    }



    /**
     */
    public void setWql(
                    final EntityStateString wql
                    )
    {
        _setStateProperty( WmiProperty.WQL, wql );
    }


    public EntityStateString getWql()
    {
        return _getStateProperty( WmiProperty.WQL, EntityStateString.class );
    }



    /**
     */
    public void setResult(
                    final EntityStateAnySimple result
                    )
    {
        _setStateProperty( WmiProperty.RESULT, result );
    }


    public EntityStateAnySimple getResult()
    {
        return _getStateProperty( WmiProperty.RESULT, EntityStateAnySimple.class );
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
    public Iterator<EntityStateBase> iterateStateProperties()
    {
        return _properties.values().iterator();
    }



    protected <T extends EntityStateBase> T _getStateProperty(
                    final WmiProperty key,
                    final Class<T> type
                    )
    {
        EntityStateBase  p = _properties.get( key );
        return type.cast( p );
    }



    protected void _setStateProperty(
                    final WmiProperty key,
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
