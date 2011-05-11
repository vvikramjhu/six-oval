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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.v5.PlatformEntityType;
import jp.go.aist.six.oval.model.v5.definitions.EntityObjectIntType;
import jp.go.aist.six.oval.model.v5.definitions.EntityObjectStringType;
import jp.go.aist.six.oval.model.v5.definitions.EntityPropertyMap;
import jp.go.aist.six.oval.model.v5.definitions.Filter;
import jp.go.aist.six.oval.model.v5.definitions.SystemObjectType;



/**
 * The metabase object is used by a metabase test to define
 * the specific metabase item(s) to be evaluated.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class MetabaseObject
    extends SystemObjectType
{

    private final EntityPropertyMap<MetabaseProperty>  _properties =
        MetabaseProperty.createPropertyMap();


//    private EntityObjectString  _key;
//    //{0..1}
//
//    private EntityObjectInt  _id;
//    //{0..1, nillable="true"}


    private final Collection<Filter>  _filter = new ArrayList<Filter>();
    //{0..*}



    /**
     * Constructor.
     */
    public MetabaseObject()
    {
    }


    public MetabaseObject(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    public MetabaseObject(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );
    }


    public MetabaseObject(
                    final String id,
                    final int version,
                    final String mbKey,
                    final String mbID
                    )
    {
        this( id, version,
                        (mbKey == null ? null : new EntityObjectStringType( mbKey )),
                        (mbID  == null ? null : new EntityObjectIntType( mbID ))
        );
    }


    public MetabaseObject(
                    final String id,
                    final int version,
                    final EntityObjectStringType mbKey,
                    final EntityObjectIntType mbID
                    )
    {
        super( id, version );
        setKey( mbKey );
        setID( mbID );
    }



    /**
     */
    public void setKey(
                    final EntityObjectStringType key
                    )
    {
        _properties.setProperty( MetabaseProperty.KEY, key );
    }


    public MetabaseObject key(
                    final EntityObjectStringType key
                    )
    {
        setKey( key );
        return this;
    }


    public EntityObjectStringType getKey()
    {
        return _properties.getProperty(
                        MetabaseProperty.KEY, EntityObjectStringType.class );
    }



    /**
     */
    public void setID(
                    final EntityObjectIntType id
                    )
    {
        _properties.setProperty( MetabaseProperty.ID, id );
    }


    public MetabaseObject ID(
                    final EntityObjectIntType id
                    )
    {
        setID( id );
        return this;
    }


    public EntityObjectIntType getID()
    {
        return _properties.getProperty(
                        MetabaseProperty.ID, EntityObjectIntType.class );
    }



    /**
     */
    public void setFilter(
                    final Collection<? extends Filter> filters
                    )
    {
        if (_filter != filters) {
            _filter.clear();
            if (filters != null  &&  filters.size() > 0) {
                _filter.addAll( filters );
            }
        }
    }


    public boolean addFilter(
                    final Filter filter
                    )
    {
        if (filter == null) {
            return false;
        }

        return _filter.add( filter );
    }


    public MetabaseObject filter(
                    final Filter filter
                    )
    {
        addFilter( filter );
        return this;
    }


    public Collection<Filter> getFilter()
    {
        return _filter;
    }


    public Iterator<Filter> iterateFilter()
    {
        return _filter.iterator();
    }



    //**************************************************************
    //  SystemObject
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.WINDOWS_METABASE;
    }



//    @Override
//    public Iterator<EntityAttributeGroup> iterateProperties()
//    {
//        return _properties.iterateProperties();
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
        if (!(obj instanceof MetabaseObject)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "metabase_object[" + super.toString()
                        + ", key=" + getKey()
                        + ", id=" + getID()
                        + ", filter=" + getFilter()
                        + "]";
    }

}
// MetabaseObject
