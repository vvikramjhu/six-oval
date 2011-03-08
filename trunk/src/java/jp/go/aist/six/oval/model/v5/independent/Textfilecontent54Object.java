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

package jp.go.aist.six.oval.model.v5.independent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.v5.definitions.EntityAttributeGroup;
import jp.go.aist.six.oval.model.v5.definitions.EntityObjectIntType;
import jp.go.aist.six.oval.model.v5.definitions.EntityObjectStringType;
import jp.go.aist.six.oval.model.v5.definitions.EntityPropertyMap;
import jp.go.aist.six.oval.model.v5.definitions.Filter;
import jp.go.aist.six.oval.model.v5.definitions.SystemObjectType;



/**
 * The textfilecontent54 object is used by a textfilecontent test
 * to define the specific block(s) of text of a file(s) to be evaluated.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Textfilecontent54Object
    extends SystemObjectType
{

    private Textfilecontent54Behaviors  _behaviors;
    //{0..1}


    private final EntityPropertyMap<TextfilecontentProperty>  _properties =
        TextfilecontentProperty.createPropertyMap();


//    // xsd:choice( filepath | path+filename)
//
//    private EntityObjectString  _filepath;
//    //{1..1}
//
//    private EntityObjectString  _path;
//    //{1..1}
//
//    private EntityObjectString  _filename;
//    //{1..1}
//
//
//    private EntityObjectString  _pattern;
//    //{1..1}
//
//
//    private EntityObjectInt  _instance;
//    //{1..1}


    private final Collection<Filter>  _filter = new ArrayList<Filter>();
    //{0..*}



    /**
     * Constructor.
     */
    public Textfilecontent54Object()
    {
    }


    public Textfilecontent54Object(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    public Textfilecontent54Object(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );
    }


    public Textfilecontent54Object(
                    final String id,
                    final int version,
                    final String path,
                    final String filename,
                    final String pattern,
                    final String instance
                    )
    {
        this( id, version,
                        (path == null     ? null : new EntityObjectStringType( path )),
                        (filename == null ? null : new EntityObjectStringType( filename )),
                        (pattern == null  ? null : new EntityObjectStringType( pattern )),
                        (instance == null ? null : new EntityObjectIntType( instance ))
                        );
    }


    public Textfilecontent54Object(
                    final String id,
                    final int version,
                    final EntityObjectStringType path,
                    final EntityObjectStringType filename,
                    final EntityObjectStringType pattern,
                    final EntityObjectIntType instance
                    )
    {
        super( id, version );
        setPath( path );
        setFilename( filename );
        setPattern( pattern );
        setInstance( instance );
    }



    /**
     */
    public void setBehaviors(
                    final Textfilecontent54Behaviors behaviors
                    )
    {
        _behaviors = behaviors;
    }


    public Textfilecontent54Object behaviors(
                    final Textfilecontent54Behaviors behaviors
                    )
    {
        setBehaviors( behaviors );
        return this;
    }


    public Textfilecontent54Behaviors getBehaviors()
    {
        return _behaviors;
    }



    /**
     */
    public void setFilepath(
                    final EntityObjectStringType filepath
                    )
    {
        _properties.setProperty( TextfilecontentProperty.FILEPATH, filepath );
    }


    public Textfilecontent54Object filepath(
                    final EntityObjectStringType filepath
                    )
    {
        setFilepath( filepath );
        return this;
    }


    public EntityObjectStringType getFilepath()
    {
        return _properties.getProperty(
                        TextfilecontentProperty.FILEPATH, EntityObjectStringType.class );
    }



    /**
     */
    public void setPath(
                    final EntityObjectStringType path
                    )
    {
        _properties.setProperty( TextfilecontentProperty.PATH, path );
    }


    public Textfilecontent54Object path(
                    final EntityObjectStringType path
                    )
    {
        setPath( path );
        return this;
    }


    public EntityObjectStringType getPath()
    {
        return _properties.getProperty(
                        TextfilecontentProperty.PATH, EntityObjectStringType.class );
    }



    /**
     */
    public void setFilename(
                    final EntityObjectStringType filename
                    )
    {
        _properties.setProperty( TextfilecontentProperty.FILENAME, filename );
    }


    public Textfilecontent54Object filename(
                    final EntityObjectStringType filename
                    )
    {
        setFilename( filename );
        return this;
    }


    public EntityObjectStringType getFilename()
    {
        return _properties.getProperty(
                        TextfilecontentProperty.FILENAME, EntityObjectStringType.class );
    }



    /**
     */
    public void setPattern(
                    final EntityObjectStringType pattern
                    )
    {
        _properties.setProperty( TextfilecontentProperty.PATTERN, pattern );
    }


    public Textfilecontent54Object pattern(
                    final EntityObjectStringType pattern
                    )
    {
        setPattern( pattern );
        return this;
    }


    public EntityObjectStringType getPattern()
    {
        return _properties.getProperty(
                        TextfilecontentProperty.PATTERN, EntityObjectStringType.class );
    }



    /**
     */
    public void setInstance(
                    final EntityObjectIntType instance
                    )
    {
        _properties.setProperty( TextfilecontentProperty.INSTANCE, instance );
    }


    public Textfilecontent54Object instance(
                    final EntityObjectIntType instance
                    )
    {
        setInstance( instance );
        return this;
    }


    public EntityObjectIntType getInstance()
    {
        return _properties.getProperty(
                        TextfilecontentProperty.INSTANCE, EntityObjectIntType.class );
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


    public Textfilecontent54Object filter(
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
        return PlatformEntityType.INDEPENDENT_TEXTFILECONTENT54;
    }



    @Override
    public Iterator<EntityAttributeGroup> iterateProperties()
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
        if (!(obj instanceof Textfilecontent54Object)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "textfilecontent54_object[" + super.toString()
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
