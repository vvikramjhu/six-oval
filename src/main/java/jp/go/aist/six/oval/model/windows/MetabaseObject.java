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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.EntityObjectIntType;
import jp.go.aist.six.oval.model.definitions.EntityObjectStringType;
import jp.go.aist.six.oval.model.definitions.Filter;
import jp.go.aist.six.oval.model.definitions.Set;
import jp.go.aist.six.oval.model.definitions.SystemObjectType;



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

    // XSD model:
    // choice(
    //          oval-def:set
    //          sequence(
    //                    key
    //                    id
    //                    filter
    //          )
    // )

    private Set  set;
    //{1..1}


    private EntityObjectStringType  key;
    //{1..1}

    private EntityObjectIntType  id;
    //{1..1, nillable="true"}


//    private final EntityPropertyMap<MetabaseProperty>  _properties =
//        MetabaseProperty.createPropertyMap();


    private final Collection<Filter>  filter = new ArrayList<Filter>();
    //{0..*}



    /**
     * Constructor.
     */
    public MetabaseObject()
    {
        this( null, 0 );
    }


    public MetabaseObject(
                    final String id,
                    final int version
                    )
    {
        this( id, version, (EntityObjectStringType)null, (EntityObjectIntType)null );
    }


    public MetabaseObject(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        this( id, version );
        setComment( comment );
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
        setId( mbID );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.metabase;
        _oval_family = Family.WINDOWS;
        _oval_component = ComponentType.METABASE;
    }



    /**
     */
    public void setSet(
                    final Set set
                    )
    {
        this.set = set;
    }


    public Set getSet()
    {
        return set;
    }



    /**
     */
    public void setKey(
                    final EntityObjectStringType key
                    )
    {
        this.key = key;
//        _properties.setProperty( MetabaseProperty.KEY, key );
    }


    public EntityObjectStringType getKey()
    {
        return key;
//        return _properties.getProperty(
//                        MetabaseProperty.KEY, EntityObjectStringType.class );
    }


    public MetabaseObject key(
                    final EntityObjectStringType key
                    )
    {
        setKey( key );
        return this;
    }



    /**
     */
    public void setId(
                    final EntityObjectIntType id
                    )
    {
        this.id = id;
//        _properties.setProperty( MetabaseProperty.ID, id );
    }


    public EntityObjectIntType getId()
    {
        return id;
//        return _properties.getProperty(
//                        MetabaseProperty.ID, EntityObjectIntType.class );
    }


    public MetabaseObject id(
                    final EntityObjectIntType id
                    )
    {
        setId( id );
        return this;
    }



    /**
     */
    public void setFilter(
                    final Collection<? extends Filter> filters
                    )
    {
        if (filter != filters) {
            filter.clear();
            if (filters != null  &&  filters.size() > 0) {
                filter.addAll( filters );
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

        return this.filter.add( filter );
    }


    public Collection<Filter> getFilter()
    {
        return filter;
    }


    public Iterator<Filter> iterateFilter()
    {
        return filter.iterator();
    }


    public MetabaseObject filter(
                    final Filter filter
                    )
    {
        addFilter( filter );
        return this;
    }



    //*********************************************************************
    //  DefinitionsElement
    //*********************************************************************

    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();

        ref_list.add( getKey() );
        ref_list.add( getId() );
        ref_list.addAll( getFilter() );

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
        if (!(obj instanceof MetabaseObject)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "metabase_object[" + super.toString()
                        + ", set=" + getSet()
                        + ", key=" + getKey()
                        + ", id=" + getId()
                        + ", filter=" + getFilter()
                        + "]";
    }

}
// MetabaseObject
