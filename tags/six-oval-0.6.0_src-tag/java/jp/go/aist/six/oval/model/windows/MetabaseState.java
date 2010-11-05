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

import jp.go.aist.six.oval.model.EntityType;
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimple;
import jp.go.aist.six.oval.model.definitions.EntityStateBase;
import jp.go.aist.six.oval.model.definitions.EntityStateInt;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.State;
import java.util.EnumMap;
import java.util.Map;



/**
 * The metabase state defines the different metadata
 * associate with a metabase item.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class MetabaseState
    extends State
{

    protected static enum Property
    {
        KEY,        //EntityStateString     {0..1}
        ID,         //EntityStateInt        {0..1}
        NAME,       //EntityStateString     {0..1}
        USER_TYPE,  //EntityStateString     {0..1}
        DATA_TYPE,  //EntityStateString     {0..1}
        DATA;       //EntityStateAnySimple  {0..1}
    }

    private Map<Property,EntityStateBase>  _properties =
        new EnumMap<Property,EntityStateBase>( Property.class );



    /**
     * Constructor.
     */
    public MetabaseState()
    {
    }


    /**
     * Constructor.
     */
    public MetabaseState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }



    /**
     */
    public EntityStateString getKey()
    {
        return (EntityStateString)_properties.get( Property.KEY );
    }


    public void setKey(
                    final EntityStateString key
                    )
    {
        _properties.put( Property.KEY, key );
    }


    public MetabaseState key(
                    final EntityStateString key
                    )
    {
        setKey( key );
        return this;
    }



    /**
     */
    public EntityStateInt getID()
    {
        return (EntityStateInt)_properties.get( Property.ID );
    }


    public void setID(
                    final EntityStateInt id
                    )
    {
        _properties.put( Property.ID, id );
    }


    public MetabaseState ID(
                    final EntityStateInt id
                    )
    {
        setID( id );
        return this;
    }



    /**
     */
    public EntityStateString getName()
    {
        return (EntityStateString)_properties.get( Property.NAME );
    }


    public void setName(
                    final EntityStateString name
                    )
    {
        _properties.put( Property.NAME, name );
    }


    public MetabaseState name(
                    final EntityStateString name
                    )
    {
        setName( name );
        return this;
    }



    /**
     */
    public EntityStateString getUserType()
    {
        return (EntityStateString)_properties.get( Property.USER_TYPE );
    }


    public void setUserType(
                    final EntityStateString userType
                    )
    {
        _properties.put( Property.USER_TYPE, userType );
    }


    public MetabaseState userType(
                    final EntityStateString userType
                    )
    {
        setUserType( userType );
        return this;
    }



    /**
     */
    public EntityStateString getDataType()
    {
        return (EntityStateString)_properties.get( Property.DATA_TYPE );
    }


    public void setDataType(
                    final EntityStateString dataType
                    )
    {
        _properties.put( Property.DATA_TYPE, dataType );
    }


    public MetabaseState dataType(
                    final EntityStateString dataType
                    )
    {
        setDataType( dataType );
        return this;
    }



    /**
     */
    public EntityStateAnySimple getData()
    {
        return (EntityStateAnySimple)_properties.get( Property.DATA );
    }


    public void setData(
                    final EntityStateAnySimple data
                    )
    {
        _properties.put( Property.DATA, data );
    }


    public MetabaseState data(
                    final EntityStateAnySimple data
                    )
    {
        setData( data );
        return this;
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public EntityType getEntityType()
    {
        return EntityType.WINDOWS_METABASE;
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
        if (!(obj instanceof MetabaseState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "metabase_state[" + super.toString()
                        + ", " + String.valueOf( _properties )
                        + "]";
    }

}
// MetabaseState
