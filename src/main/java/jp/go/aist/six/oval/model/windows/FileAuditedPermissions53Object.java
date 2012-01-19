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
import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.definitions.EntityObjectStringType;
import jp.go.aist.six.oval.model.definitions.Filter;
import jp.go.aist.six.oval.model.definitions.Set;
import jp.go.aist.six.oval.model.definitions.SystemObjectType;



/**
 * The fileauditedpermissions53_object is used by a file audited permissions test 
 * to define the objects used to evaluate against the specified state. 
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class FileAuditedPermissions53Object
    extends SystemObjectType
{

    //TODO: XSD model.
	// choice(
	//    set
    //    sequence(
    //           behaviors
    //           choice(
    //                      filepath
    //                      sequence(
    //                                 path
    //                                 filename
    //                              )
    //           )
    //           trustee_sid
    //           filter
    //   )

    private Set  set;
    //{1..1}


    private FileAuditPermissions53Behaviors  behaviors;
    //{0..1}

    private EntityObjectStringType  filepath;
    //{1..1}

    private EntityObjectStringType  path;
    //{1..1}

    private EntityObjectStringType  filename;
    //{1..1, nillable="true"}

    private EntityObjectStringType  trustee_sid;
    //{1..1}

    private final Collection<Filter>  filter = new ArrayList<Filter>();
    //{0..*}



    /**
     * Constructor.
     */
    public FileAuditedPermissions53Object()
    {
        this( null, 0 );
    }


    public FileAuditedPermissions53Object(
                    final String id,
                    final int version
                    )
    {
        super( id, version );

        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.fileauditedpermissions53;
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
        return this.set;
    }



    /**
     */
    public void setBehaviors(
                    final FileAuditPermissions53Behaviors behaviors
                    )
    {
        this.behaviors = behaviors;
    }


    public FileAuditPermissions53Behaviors getBehaviors()
    {
        return this.behaviors;
    }



    /**
     */
    public void setFilepath(
                    final EntityObjectStringType filepath
                    )
    {
        this.filepath = filepath;
    }


    public EntityObjectStringType getFilepath()
    {
        return this.filepath;
    }



    /**
     */
    public void setPath(
                    final EntityObjectStringType path
                    )
    {
        this.path = path;
    }


    public EntityObjectStringType getPath()
    {
        return this.path;
    }



    /**
     */
    public void setFilename(
                    final EntityObjectStringType filename
                    )
    {
        this.filename = filename;
    }


    public EntityObjectStringType getFilename()
    {
        return this.filename;
    }



    /**
     */
    public void setTrusteeSid(
                    final EntityObjectStringType trustee_sid
                    )
    {
        this.trustee_sid = trustee_sid;
    }


    public EntityObjectStringType getTrusteeSid()
    {
        return this.trustee_sid;
    }



    /**
     */
    public void setFilter(
                    final Collection<? extends Filter> filterList
                    )
    {
        if (this.filter != filterList) {
            this.filter.clear();
            if (filterList != null  &&  filterList.size() > 0) {
                this.filter.addAll( filterList );
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
        if (!(obj instanceof FileAuditedPermissions53Object)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "fileauditedpermissions53_object[" + super.toString()
                        + ", set=" 			+ getSet()
                        + ", behaviors="	+ getBehaviors()
                        + ", filepath="		+ getFilepath()
                        + ", path=" 		+ getPath()
                        + ", filename=" 	+ getFilename()
                        + ", trustee_sid="	+ getTrusteeSid()
                        + ", filter=" 		+ getFilter()
                        + "]";
    }

}
//FileAuditedPermissions53Object
