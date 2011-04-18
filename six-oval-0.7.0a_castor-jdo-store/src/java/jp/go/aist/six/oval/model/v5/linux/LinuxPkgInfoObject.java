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

package jp.go.aist.six.oval.model.v5.linux;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import jp.go.aist.six.oval.model.v5.definitions.EntityAttributeGroup;
import jp.go.aist.six.oval.model.v5.definitions.EntityObjectStringType;
import jp.go.aist.six.oval.model.v5.definitions.Filter;
import jp.go.aist.six.oval.model.v5.definitions.SystemObjectType;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class LinuxPkgInfoObject
    extends SystemObjectType
{

    private EntityObjectStringType  _name;
    //{1..1}


    private final Collection<Filter>  _filter = new ArrayList<Filter>();
    //{0..*}



    /**
     * Constructor.
     */
    public LinuxPkgInfoObject()
    {
    }


    public LinuxPkgInfoObject(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    public LinuxPkgInfoObject(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );
    }



    /**
     */
    public void setName(
                    final EntityObjectStringType name
                    )
    {
        _name = name;
    }


    public EntityObjectStringType getName()
    {
        return _name;
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
    //  State
    //**************************************************************

    @Override
    public Iterator<EntityAttributeGroup> iterateProperties()
    {
        EntityAttributeGroup  p = getName();
        return Collections.singletonList( p ).iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        EntityObjectStringType  name = getName();
        Collection<Filter>  filter = getFilter();
        return "name=" + (name == null ? null : name.getContent())
                        + ", filter=" + filter
                        + ", " + super.toString();
    }

}
// LinuxPkgInfoObject
