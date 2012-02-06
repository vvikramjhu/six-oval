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

package jp.go.aist.six.oval.model.linux;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.definitions.EntityObjectStringType;
import jp.go.aist.six.oval.model.definitions.Filter;
import jp.go.aist.six.oval.model.definitions.Set;
import jp.go.aist.six.oval.model.definitions.SystemObjectType;



/**
 * The rpminfo object is used by a rpminfo test to define
 * the object to be evaluated.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RpmInfoObject
    extends SystemObjectType
{

    //TODO: XSD model
    // xsd:choice(
    //            set
    //            xsd:sequence(
    //                     behaviors
    //                     name
    //                     filter
    //            )
    // )


    private Set  set;
    //{1..1}

    private RpmInfoBehaviors  behaviors;
    //{0..1}

    private EntityObjectStringType  name;
    //{1..1}

    private final Collection<Filter>  filter = new ArrayList<Filter>();
    //{0..*}



    
    /**
     * Constructor.
     */
    public RpmInfoObject()
    {
        this( null, 0 );
    }


    public RpmInfoObject(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public RpmInfoObject(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.linux;
        _oval_component_type = OvalComponentType.rpminfo;
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
    public void setBehaviors(
                    final RpmInfoBehaviors behaviors
                    )
    {
        this.behaviors = behaviors;
    }


    public RpmInfoBehaviors getBehaviors()
    {
        return this.behaviors;
    }



    /**
     */
    public void setName(
                    final EntityObjectStringType name
                    )
    {
        this.name = name;
    }


    public EntityObjectStringType getName()
    {
        return this.name;
    }


    public RpmInfoObject name(
                    final EntityObjectStringType name
                    )
    {
        setName( name );
        return this;
    }


    public RpmInfoObject name(
                    final String name
                    )
    {
        return name( new EntityObjectStringType( name ) );
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
        if (!(obj instanceof RpmInfoObject)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "rpminfo_object[" + super.toString()
                        + ", set="      + getSet()
                        + ", behaviors="    + getBehaviors()
                        + ", name="     + getName()
                        + ", filter="   + getFilter()
                        + "]";
    }

}
//RpmInfoObject
