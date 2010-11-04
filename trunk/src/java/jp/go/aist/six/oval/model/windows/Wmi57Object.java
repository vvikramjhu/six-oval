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
import jp.go.aist.six.oval.model.definitions.EntityObjectString;
import jp.go.aist.six.oval.model.definitions.Filter;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Wmi57Object
    extends SystemObject
{

    private EntityObjectString  _namespace;
    //{1..1}


    private EntityObjectString  _wql;
    //{1..1}


    private Collection<Filter>  _filter = new ArrayList<Filter>();
    //{0..*}



    /**
     * Constructor.
     */
    public Wmi57Object()
    {
    }


    /**
     * Constructor.
     */
    public Wmi57Object(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public Wmi57Object(
                    final String id,
                    final int version,
                    final String namespace,
                    final String wql
                    )
    {
        this( id, version,
                        (namespace == null ? null : (new EntityObjectString( namespace ))),
                        (wql == null ? null : (new EntityObjectString( wql )))
        );
    }


    /**
     * Constructor.
     */
    public Wmi57Object(
                    final String id,
                    final int version,
                    final EntityObjectString namespace,
                    final EntityObjectString wql
                    )
    {
        super( id, version );

        setNamespace( namespace );
        setWql( wql );
    }



    public void setNamespace(
                    final EntityObjectString namespace
                    )
    {
        _namespace = namespace;
    }


    public EntityObjectString getNamespace()
    {
        return _namespace;
    }



    public void setWql(
                    final EntityObjectString wql
                    )
    {
        _wql = wql;
    }


    public EntityObjectString getWql()
    {
        return _wql;
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
    public EntityType getEntityType()
    {
        return EntityType.WINDOWS_WMI57;
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
        if (!(obj instanceof Wmi57Object)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "wmi57_object[" + super.toString()
                        + ", namespace=" + getNamespace()
                        + ", wql=" + getWql()
                        + ", filter=" + getFilter()
                        + "]";
    }

}
// Wmi57Object
