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
import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.v5.PlatformEntityType;
import jp.go.aist.six.oval.model.v5.definitions.EntityObjectStringType;
import jp.go.aist.six.oval.model.v5.definitions.Filter;
import jp.go.aist.six.oval.model.v5.definitions.SystemObjectType;



/**
 * The file object is used by a file test to define the specific file(s)
 * to be evaluated.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class FileObject
    extends SystemObjectType
{

    private FileBehaviors  behaviors;
    //{0..1}

    //TODO: XSD model.
    // sequence(
    //           behaviors
    //           choice(
    //                      filepath
    //                      sequence(
    //                                 path
    //                                 filename
    //                              )
    //                 )
    //           filter
    //         )

    private EntityObjectStringType  filepath;
    //{1..1}

    private EntityObjectStringType  path;
    //{1..1}

    private EntityObjectStringType  filename;
    //{1..1, nillable="true"}

//    private final EntityPropertyMap<FileProperty>  _properties =
//        FileProperty.createPropertyMap();


    private final Collection<Filter>  filter = new ArrayList<Filter>();
    //{0..*}



    /**
     * Constructor.
     */
    public FileObject()
    {
        this( null, 0 );
    }


    public FileObject(
                    final String id,
                    final int version
                    )
    {
        super( id, version );

        oval_platform_type = OvalPlatformType.windows;
        oval_component_type = OvalComponentType.file;
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
    public void setBehaviors(
                    final FileBehaviors behaviors
                    )
    {
        this.behaviors = behaviors;
    }


    public FileBehaviors getBehaviors()
    {
        return this.behaviors;
    }


    public FileObject behaviors(
                    final FileBehaviors behaviors
                    )
    {
        setBehaviors( behaviors );
        return this;
    }


    /**
     */
    public void setFilepath(
                    final EntityObjectStringType filepath
                    )
    {
        this.filepath = filepath;
//        _properties.setProperty( FileProperty.FILEPATH, filepath );
    }


    public EntityObjectStringType getFilepath()
    {
        return this.filepath;
//        return _properties.getProperty(
//                        FileProperty.FILEPATH, EntityObjectStringType.class );
    }


    public FileObject filepath(
                    final EntityObjectStringType filepath
                    )
    {
        setFilepath( filepath );
        return this;
    }



    /**
     */
    public void setPath(
                    final EntityObjectStringType path
                    )
    {
        this.path = path;
//        _properties.setProperty( FileProperty.PATH, path );
    }


    public EntityObjectStringType getPath()
    {
        return this.path;
//        return _properties.getProperty(
//                        FileProperty.PATH, EntityObjectStringType.class );
    }


    public FileObject path(
                    final EntityObjectStringType path
                    )
    {
        setPath( path );
        return this;
    }



    /**
     */
    public void setFilename(
                    final EntityObjectStringType filename
                    )
    {
        this.filename = filename;
//        _properties.setProperty( FileProperty.FILENAME, filename);
    }


    public EntityObjectStringType getFilename()
    {
        return this.filename;
//        return _properties.getProperty(
//                        FileProperty.FILENAME, EntityObjectStringType.class );
    }


    public FileObject filename(
                    final EntityObjectStringType filename
                    )
    {
        setFilename( filename );
        return this;
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


    public FileObject filter(
                    final Filter filter
                    )
    {
        addFilter( filter );
        return this;
    }


    //**************************************************************
    //  SystemObject
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.WINDOWS_FILE;
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
        if (!(obj instanceof FileObject)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "file_object[" + super.toString()
                        + ", behaviors=" + getBehaviors()
                        + ", filepath=" + getFilepath()
                        + ", path=" + getPath()
                        + ", filename=" + getFilename()
                        + ", filter=" + getFilter()
                        + "]";
    }

}
// FileObject
