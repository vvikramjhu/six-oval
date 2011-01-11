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
import jp.go.aist.six.oval.model.definitions.EntityStateBase;
import jp.go.aist.six.oval.model.definitions.EntityStateRecord;
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
 */
public class Wmi57State
    extends State
{

    protected static enum Property
    {
        NAMESPACE,  //EntityStateString     {0..1}
        WQL,        //EntityStateInt        {0..1}
        RESULT;     //EntityStateRecord     {0..1}
    }

    private Map<Property, EntityStateBase>  _properties =
        new EnumMap<Property, EntityStateBase>( Property.class );



//    private EntityStateString  _namespace;
//    //{0..1}
//
//    private EntityStateString  _wql;
//    //{0..1}
//
//    private EntityStateRecord  _result;
//    //{0..1}



    /**
     * Constructor.
     */
    public Wmi57State()
    {
    }


    /**
     * Constructor.
     */
    public Wmi57State(
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
        _setStateProperty( Property.NAMESPACE, namespace );
    }


    public EntityStateString getNamespace()
    {
        return _getStateProperty( Property.NAMESPACE, EntityStateString.class );
    }



    /**
     */
    public void setWql(
                    final EntityStateString wql
                    )
    {
        _setStateProperty( Property.WQL, wql );
    }


    public EntityStateString getWql()
    {
        return _getStateProperty( Property.WQL, EntityStateString.class );
    }



    /**
     */
    public void setResult(
                    final EntityStateRecord result
                    )
    {
        _setStateProperty( Property.RESULT, result );
    }


    public EntityStateRecord getResult()
    {
        return _getStateProperty( Property.RESULT, EntityStateRecord.class );
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.WINDOWS_WMI57;
    }



    @Override
    public Iterator<EntityStateBase> iterateStateProperties()
    {
        return _properties.values().iterator();
    }



    protected <T extends EntityStateBase> T _getStateProperty(
                    final Property key,
                    final Class<T> type
                    )
    {
        EntityStateBase  p = _properties.get( key );
        return type.cast( p );
    }



    protected void _setStateProperty(
                    final Property key,
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
        if (!(obj instanceof Wmi57State)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "wmi57_state[" + super.toString()
                        + ", " + String.valueOf( _properties )
                        + "]";
    }

}
// Wql57State
