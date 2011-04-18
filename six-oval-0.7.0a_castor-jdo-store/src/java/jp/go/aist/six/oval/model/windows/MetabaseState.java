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
import jp.go.aist.six.oval.model.definitions.EntityPropertyMap;
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimple;
import jp.go.aist.six.oval.model.definitions.EntityStateInt;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.State;
import java.util.Iterator;



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

    private EntityPropertyMap<MetabaseProperty>  _properties =
        MetabaseProperty.createPropertyMap();



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
        return _properties.getProperty(
                        MetabaseProperty.KEY, EntityStateString.class );
    }


    public void setKey(
                    final EntityStateString key
                    )
    {
        _properties.setProperty( MetabaseProperty.KEY, key );
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
        return _properties.getProperty(
                        MetabaseProperty.ID, EntityStateInt.class );
    }


    public void setID(
                    final EntityStateInt id
                    )
    {
        _properties.setProperty( MetabaseProperty.ID, id );
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
        return _properties.getProperty(
                        MetabaseProperty.NAME, EntityStateString.class );
    }


    public void setName(
                    final EntityStateString name
                    )
    {
        _properties.setProperty( MetabaseProperty.NAME, name );
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
        return _properties.getProperty(
                        MetabaseProperty.USER_TYPE, EntityStateString.class );
    }


    public void setUserType(
                    final EntityStateString userType
                    )
    {
        _properties.setProperty( MetabaseProperty.USER_TYPE, userType );
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
        return _properties.getProperty(
                        MetabaseProperty.DATA_TYPE, EntityStateString.class );
    }


    public void setDataType(
                    final EntityStateString dataType
                    )
    {
        _properties.setProperty( MetabaseProperty.DATA_TYPE, dataType );
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
        return _properties.getProperty(
                        MetabaseProperty.DATA, EntityStateAnySimple.class );
    }


    public void setData(
                    final EntityStateAnySimple data
                    )
    {
        _properties.setProperty( MetabaseProperty.DATA, data );
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
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.WINDOWS_METABASE;
    }



    @Override
    public Iterator<EntityBase> iterateProperties()
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
