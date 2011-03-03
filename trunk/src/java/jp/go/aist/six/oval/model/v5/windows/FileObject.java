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
import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.definitions.EntityBase;
import jp.go.aist.six.oval.model.definitions.EntityObjectString;
import jp.go.aist.six.oval.model.definitions.EntityPropertyMap;
import jp.go.aist.six.oval.model.definitions.Filter;
import jp.go.aist.six.oval.model.definitions.SystemObject;



/**
 * The file object is used by a file test to define the specific file(s)
 * to be evaluated.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class FileObject
    extends SystemObject
{

    private FileBehaviors  _behaviors;
    //{0..1}

    //TODO: schema 5.7 changes the content model.
    // sequence(
    //           behaviors,
    //           choice(
    //                      filepath,
    //                      sequence(
    //                                 path,
    //                                 filename
    //                              )
    //                 )
    //         )
//    private EntityObjectString  _filepath;
//    //{1..1}
//
//    private EntityObjectString  _path;
//    //{1..1}
//
//    private EntityObjectString  _filename;
//    //{1..1, nillable="true"}

    private final EntityPropertyMap<FileProperty>  _properties =
        FileProperty.createPropertyMap();



    private final Collection<Filter>  _filter = new ArrayList<Filter>();
    //{0..*}



    /**
     * Constructor.
     */
    public FileObject()
    {
    }


    /**
     * Constructor.
     */
    public FileObject(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public FileObject(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );
    }


    /**
     * Constructor.
     */
    public FileObject(
                    final String id,
                    final int version,
                    final String path,
                    final String filename
                    )
    {
        this( id, version,
                        new EntityObjectString( path ),
                        new EntityObjectString( filename )
        );
    }


    /**
     * Constructor.
     */
    public FileObject(
                    final String id,
                    final int version,
                    final EntityObjectString path,
                    final EntityObjectString filename
                    )
    {
        super( id, version );
        setPath( path );
        setFilename( filename );
    }



    /**
     */
    public void setBehaviors(
                    final FileBehaviors behaviors
                    )
    {
        _behaviors = behaviors;
    }


    public FileObject behaviors(
                    final FileBehaviors behaviors
                    )
    {
        setBehaviors( behaviors );
        return this;
    }


    public FileBehaviors getBehaviors()
    {
        return _behaviors;
    }


    /**
     */
    public void setFilepath(
                    final EntityObjectString filepath
                    )
    {
        _properties.setProperty( FileProperty.FILEPATH, filepath );
    }


    public FileObject filepath(
                    final EntityObjectString filepath
                    )
    {
        setFilepath( filepath );
        return this;
    }


    public EntityObjectString getFilepath()
    {
        return _properties.getProperty(
                        FileProperty.FILEPATH, EntityObjectString.class );
    }



    public void setPath(
                    final EntityObjectString path
                    )
    {
        _properties.setProperty( FileProperty.PATH, path );
    }


    public FileObject path(
                    final EntityObjectString path
                    )
    {
        setPath( path );
        return this;
    }


    public EntityObjectString getPath()
    {
        return _properties.getProperty(
                        FileProperty.PATH, EntityObjectString.class );
    }



    public void setFilename(
                    final EntityObjectString filename
                    )
    {
        _properties.setProperty( FileProperty.FILENAME, filename);
    }


    public FileObject filename(
                    final EntityObjectString filename
                    )
    {
        setFilename( filename );
        return this;
    }


    public EntityObjectString getFilename()
    {
        return _properties.getProperty(
                        FileProperty.FILENAME, EntityObjectString.class );
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


    public FileObject filter(
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
        return PlatformEntityType.WINDOWS_FILE;
    }



    @Override
    public Iterator<EntityBase> iterateProperties()
    {
        return _properties.iterateProperties();
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
