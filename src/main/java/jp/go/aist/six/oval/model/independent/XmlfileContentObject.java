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
import jp.go.aist.six.oval.model.definitions.EntityObjectIntType;
import jp.go.aist.six.oval.model.definitions.EntityObjectStringType;
import jp.go.aist.six.oval.model.definitions.Filter;
import jp.go.aist.six.oval.model.definitions.Set;
import jp.go.aist.six.oval.model.definitions.SystemObjectType;



/**
 * The textfilecontent54 object is used by a textfilecontent test
 * to define the specific block(s) of text of a file(s) to be evaluated.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class TextfileContent54Object
    extends SystemObjectType
{
    // XSD model:
    // choice(
    //         set
    //         sequence(
    //                   behaviors
    //                   choice(
    //                           filepath
    //                           sequence( path filename )
    //                   )
    //                   pattern
    //                   instance
    //                   filter
    //          )
    // )

    private Set  set;
    //{1..1}


    private TextfileContent54Behaviors  behaviors;
    //{0..1}


    private EntityObjectStringType  filepath;
    //{1..1}

    private EntityObjectStringType  path;
    //{1..1}

    private EntityObjectStringType  filename;
    //{1..1}


    private EntityObjectStringType  pattern;
    //{1..1}


    private EntityObjectIntType  instance;
    //{1..1}


//    private final EntityPropertyMap<TextfileContentProperty>  _properties =
//        TextfileContentProperty.createPropertyMap();



    private final Collection<Filter>  filter = new ArrayList<Filter>();
    //{0..*}



    /**
     * Constructor.
     */
    public TextfileContent54Object()
    {
        this( null, 0 );
    }


    public TextfileContent54Object(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public TextfileContent54Object(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.independent;
        _oval_component_type = OvalComponentType.textfilecontent54;
    }


//    public TextfileContent54Object(
//                    final String id,
//                    final int version,
//                    final String path,
//                    final String filename,
//                    final String pattern,
//                    final String instance
//                    )
//    {
//        this( id, version,
//                        (path == null     ? null : new EntityObjectStringType( path )),
//                        (filename == null ? null : new EntityObjectStringType( filename )),
//                        (pattern == null  ? null : new EntityObjectStringType( pattern )),
//                        (instance == null ? null : new EntityObjectIntType( instance ))
//                        );
//    }
//
//
//    public TextfileContent54Object(
//                    final String id,
//                    final int version,
//                    final EntityObjectStringType path,
//                    final EntityObjectStringType filename,
//                    final EntityObjectStringType pattern,
//                    final EntityObjectIntType instance
//                    )
//    {
//        super( id, version );
//        setPath( path );
//        setFilename( filename );
//        setPattern( pattern );
//        setInstance( instance );
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
                    final TextfileContent54Behaviors behaviors
                    )
    {
        this.behaviors = behaviors;
    }


    public TextfileContent54Behaviors getBehaviors()
    {
        return this.behaviors;
    }


    public TextfileContent54Object behaviors(
                    final TextfileContent54Behaviors behaviors
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
//        _properties.setProperty( TextfileContentProperty.FILEPATH, filepath );
    }


    public EntityObjectStringType getFilepath()
    {
        return this.filepath;
//        return _properties.getProperty(
//                        TextfileContentProperty.FILEPATH, EntityObjectStringType.class );
    }


    public TextfileContent54Object filepath(
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
//        _properties.setProperty( TextfileContentProperty.PATH, path );
    }


    public EntityObjectStringType getPath()
    {
        return path;
//        return _properties.getProperty(
//                        TextfileContentProperty.PATH, EntityObjectStringType.class );
    }


    public TextfileContent54Object path(
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
//        _properties.setProperty( TextfileContentProperty.FILENAME, filename );
    }


    public EntityObjectStringType getFilename()
    {
        return this.filename;
//        return _properties.getProperty(
//                        TextfileContentProperty.FILENAME, EntityObjectStringType.class );
    }


    public TextfileContent54Object filename(
                    final EntityObjectStringType filename
                    )
    {
        setFilename( filename );
        return this;
    }



    /**
     */
    public void setPattern(
                    final EntityObjectStringType pattern
                    )
    {
        this.pattern = pattern;
//        _properties.setProperty( TextfileContentProperty.PATTERN, pattern );
    }


    public EntityObjectStringType getPattern()
    {
        return this.pattern;
//        return _properties.getProperty(
//                        TextfileContentProperty.PATTERN, EntityObjectStringType.class );
    }


    public TextfileContent54Object pattern(
                    final EntityObjectStringType pattern
                    )
    {
        setPattern( pattern );
        return this;
    }



    /**
     */
    public void setInstance(
                    final EntityObjectIntType instance
                    )
    {
        this.instance = instance;
//        _properties.setProperty( TextfileContentProperty.INSTANCE, instance );
    }


    public EntityObjectIntType getInstance()
    {
        return this.instance;
//        return _properties.getProperty(
//                        TextfileContentProperty.INSTANCE, EntityObjectIntType.class );
    }


    public TextfileContent54Object instance(
                    final EntityObjectIntType instance
                    )
    {
        setInstance( instance );
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
        return this.filter.iterator();
    }


    public TextfileContent54Object filter(
                    final Filter filter
                    )
    {
        addFilter( filter );
        return this;
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
        if (!(obj instanceof TextfileContent54Object)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "textfilecontent54_object[" + super.toString()
                        + ", set=" + getSet()
                        + ", behaviors=" + getBehaviors()
                        + ", filepath=" + getFilepath()
                        + ", path=" + getPath()
                        + ", filename=" + getFilename()
                        + ", pattern=" + getPattern()
                        + ", instance=" + getInstance()
                        + ", filter=" + getFilter()
                        + "]";
    }

}
// TextFileContent54Object
