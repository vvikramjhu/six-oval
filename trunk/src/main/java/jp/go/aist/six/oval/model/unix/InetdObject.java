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

package jp.go.aist.six.oval.model.unix;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.EntityObjectStringType;
import jp.go.aist.six.oval.model.definitions.Filter;
import jp.go.aist.six.oval.model.definitions.Set;
import jp.go.aist.six.oval.model.definitions.SystemObjectType;



/**
 * The inetd object is used by an inetd test
 * to define the specific protocol-service to be evaluated.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class InetdObject
    extends SystemObjectType
{

    //TODO: XSD model.

    private Set  set;
    //{1..1}

    private EntityObjectStringType  protocol;
    //{1..1}

    private EntityObjectStringType  service_name;
    //{1..1}

    private final Collection<Filter>  filter = new ArrayList<Filter>();
    //{0..*}



    /**
     * Constructor.
     */
    public InetdObject()
    {
        this( null, 0 );
    }


    public InetdObject(
                    final String id,
                    final int version
                    )
    {
        super( id, version );

//        _oval_platform_type = OvalPlatformType.unix;
//        _oval_component_type = OvalComponentType.inetd;
        _oval_family = Family.UNIX;
        _oval_component = Component.INETD;
    }


//    public FileObject(
//                    final String id,
//                    final int version,
//                    final String comment
//                    )
//    {
//        super( id, version, comment );
//    }
//
//
//    public FileObject(
//                    final String id,
//                    final int version,
//                    final String path,
//                    final String filename
//                    )
//    {
//        this( id, version,
//                        new EntityObjectStringType( path ),
//                        new EntityObjectStringType( filename )
//        );
//    }
//
//
//    public FileObject(
//                    final String id,
//                    final int version,
//                    final EntityObjectStringType path,
//                    final EntityObjectStringType filename
//                    )
//    {
//        super( id, version );
//        setPath( path );
//        setFilename( filename );
//    }



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
    public void setProtocol(
                    final EntityObjectStringType protocol
                    )
    {
        this.protocol = protocol;
    }


    public EntityObjectStringType getProtocol()
    {
        return protocol;
    }



    /**
     */
    public void setServiceName(
                    final EntityObjectStringType service_name
                    )
    {
        this.service_name = service_name;
    }


    public EntityObjectStringType getServiceName()
    {
        return service_name;
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
        if (!(obj instanceof InetdObject)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "inetd_object[" + super.toString()
                        + ", set="          + getSet()
                        + ", protocol="     + getProtocol()
                        + ", service_name=" + getServiceName()
                        + ", filter="       + getFilter()
                        + "]";
    }

}
//InetdObject