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
import jp.go.aist.six.oval.model.definitions.EntityBase;
import jp.go.aist.six.oval.model.definitions.EntityStateRecord;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.State;
import java.util.Iterator;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Wmi57State
    extends State
{

    private WmiProperty.EntityMap  _properties = WmiProperty.createEntityMap();

//    private EnumMap<WmiProperty, EntityBase>  _properties =
//        new EnumMap<WmiProperty, EntityBase>( WmiProperty.class );



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
        _properties.setProperty( WmiProperty.NAMESPACE, namespace );
//        _setProperty( WmiProperty.NAMESPACE, namespace );
    }


    public EntityStateString getNamespace()
    {
        return _properties.getProperty( WmiProperty.NAMESPACE, EntityStateString.class );
//        return _getProperty( WmiProperty.NAMESPACE, EntityStateString.class );
    }



    /**
     */
    public void setWql(
                    final EntityStateString wql
                    )
    {
        _properties.setProperty( WmiProperty.WQL, wql );
//        _setProperty( WmiProperty.WQL, wql );
    }


    public EntityStateString getWql()
    {
        return _properties.getProperty( WmiProperty.WQL, EntityStateString.class );
//        return _getProperty( WmiProperty.WQL, EntityStateString.class );
    }



    /**
     */
    public void setResult(
                    final EntityStateRecord result
                    )
    {
        _properties.setProperty( WmiProperty.RESULT, result );
//        _setProperty( WmiProperty.RESULT, result );
    }


    public EntityStateRecord getResult()
    {
        return _properties.getProperty( WmiProperty.RESULT, EntityStateRecord.class );
//        return _getProperty( WmiProperty.RESULT, EntityStateRecord.class );
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
    public Iterator<EntityBase> iterateProperties()
    {
        return _properties.iterateProperties();
//        return _properties.values().iterator();
    }



//    protected <T extends EntityStateBase> T _getProperty(
//                    final WmiProperty key,
//                    final Class<T> type
//                    )
//    {
//        EntityBase  p = _properties.get( key );
//        return type.cast( p );
//    }
//
//
//
//    protected void _setProperty(
//                    final WmiProperty key,
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
