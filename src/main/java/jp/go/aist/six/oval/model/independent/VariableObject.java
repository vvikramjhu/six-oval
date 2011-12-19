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

package jp.go.aist.six.oval.model.independent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.definitions.Filter;
import jp.go.aist.six.oval.model.definitions.Set;
import jp.go.aist.six.oval.model.definitions.SystemObjectType;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class VariableObject
    extends SystemObjectType
{
    // XSD model:
    // choice(
    //         set
    //         sequence(
    //                   var_ref
    //                   filter
    //          )
    // )

    private Set  set;

    private EntityObjectVvariableRefType  var_ref;
    //{1..1}

    private final Collection<Filter>  filter = new ArrayList<Filter>();
    //{0..*}



    /**
     * Constructor.
     */
    public VariableObject()
    {
        this( null, 0 );
    }


    public VariableObject(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public VariableObject(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.independent;
        _oval_component_type = OvalComponentType.variable;
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
        return this.set;
    }



    /**
     */
    public void setVarRef(
                    final EntityObjectVvariableRefType var_ref
                    )
    {
        this.var_ref = var_ref;
    }


    public EntityObjectVvariableRefType getVarRef()
    {
        return this.var_ref;
    }



    /**
     */
    public void setFilter(
                    final Collection<? extends Filter> filters
                    )
    {
        if (this.filter != filters) {
            this.filter.clear();
            if (filters != null  &&  filters.size() > 0) {
                this.filter.addAll( filters );
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
        return this.filter;
    }


    public Iterator<Filter> iterateFilter()
    {
        return this.filter.iterator();
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
        if (!(obj instanceof VariableObject)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "variable_object[" + super.toString()
                        + ", set="      + getSet()
                        + ", var_ref="  + getVarRef()
                        + ", filter="   + getFilter()
                       + "]";
    }

}
//VariableObject
