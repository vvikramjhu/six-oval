/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.go.aist.six.oval.model.windows;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.EntityObjectStringType;
import jp.go.aist.six.oval.model.definitions.Filter;
import jp.go.aist.six.oval.model.definitions.Set;
import jp.go.aist.six.oval.model.definitions.SystemObjectType;



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

    private Set  set;
    //{1..1}


    private FileBehaviors  behaviors;
    //{0..1}

    private EntityObjectStringType  filepath;
    //{1..1}

    private EntityObjectStringType  path;
    //{1..1}

    private EntityObjectStringType  filename = new EntityObjectStringType();
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

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.file;
        _oval_family = Family.WINDOWS;
        _oval_component = ComponentType.FILE;
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
    public void setBehaviors(
                    final FileBehaviors behaviors
                    )
    {
        this.behaviors = behaviors;
    }


    public FileBehaviors getBehaviors()
    {
        return behaviors;
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
        return filepath;
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
        return path;
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
        return filename;
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
        if (filter != filterList) {
            filter.clear();
            if (filterList != null  &&  filterList.size() > 0) {
                filter.addAll( filterList );
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


    public FileObject filter(
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
        ref_list.add( getFilepath() );
        ref_list.add( getPath() );
        ref_list.add( getFilename() );
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
        if (!(obj instanceof FileObject)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "file_object[" + super.toString()
                        + ", set=" + getSet()
                        + ", behaviors=" + getBehaviors()
                        + ", filepath=" + getFilepath()
                        + ", path=" + getPath()
                        + ", filename=" + getFilename()
                        + ", filter=" + getFilter()
                        + "]";
    }

}
//FileObject
