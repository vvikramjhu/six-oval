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

import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.definitions.EntityObjectString;
import jp.go.aist.six.oval.model.definitions.Filter;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;



/**
 * The rpmverify object is used by a rpmverity test to define
 * a set of files within a set of RPMs to verify.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RpmVerifyObject
    extends SystemObject
{

    private RpmVerifyBehaviors  _behaviors;
    //{0..1}


    private EntityObjectString  _name;
    //{1..1}


    private EntityObjectString  _filepath;
    //{1..1}


    private Collection<Filter>  _filter = new ArrayList<Filter>();
    //{0..*}



    /**
     * Constructor.
     */
    public RpmVerifyObject()
    {
    }


    /**
     * Constructor.
     */
    public RpmVerifyObject(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public RpmVerifyObject(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );
    }



    /**
     */
    public void setBehaviors(
                    final RpmVerifyBehaviors behaviors
                    )
    {
        _behaviors = behaviors;
    }


    public RpmVerifyBehaviors getBehaviors()
    {
        return _behaviors;
    }



    /**
     */
    public void setName(
                    final EntityObjectString name
                    )
    {
        _name = name;
    }


    public EntityObjectString getName()
    {
        return _name;
    }



    /**
     */
    public void setFilepath(
                    final EntityObjectString filepath
                    )
    {
        _filepath = filepath;
    }


    public EntityObjectString getFilepath()
    {
        return _filepath;
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


    public RpmVerifyObject filter(
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
        return PlatformEntityType.LINUX_RPMVERIFY;
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
        if (!(obj instanceof RpmVerifyObject)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "rpmverify_object[" + super.toString()
                        + ", behaviors=" + getBehaviors()
                        + ", name=" + getName()
                        + ", filepath=" + getFilepath()
                        + ", filter=" + getFilter()
                        + "]";
    }

}
// RpmVerifyObject
