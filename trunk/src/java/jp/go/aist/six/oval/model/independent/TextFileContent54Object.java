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

import jp.go.aist.six.oval.model.EntityType;
import jp.go.aist.six.oval.model.definitions.EntityObjectInt;
import jp.go.aist.six.oval.model.definitions.EntityObjectString;
import jp.go.aist.six.oval.model.definitions.Filter;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;



/**
 * The textfilecontent54 object is used by a textfilecontent test
 * to define the specific block(s) of text of a file(s) to be evaluated.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class TextFileContent54Object
    extends SystemObject
{

    private TextFileContent54Behaviors  _behaviors;
    //{0..1}


    // xsd:choice( filepath | path+filename)

    private EntityObjectString  _filepath;
    //{1..1}

    private EntityObjectString  _path;
    //{1..1}

    private EntityObjectString  _filename;
    //{1..1}


    private EntityObjectString  _pattern;
    //{1..1}


    private EntityObjectInt  _instance;
    //{1..1}


    private Collection<Filter>  _filter = new ArrayList<Filter>();
    //{0..*}



    /**
     * Constructor.
     */
    public TextFileContent54Object()
    {
    }


    /**
     * Constructor.
     */
    public TextFileContent54Object(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public TextFileContent54Object(
                    final String id,
                    final int version,
                    final String path,
                    final String filename,
                    final String pattern,
                    final String instance
                    )
    {
        this( id, version,
                        new EntityObjectString( path ),
                        new EntityObjectString( filename ),
                        new EntityObjectString( pattern ),
                        new EntityObjectInt( instance )
                        );
    }


    /**
     * Constructor.
     */
    public TextFileContent54Object(
                    final String id,
                    final int version,
                    final EntityObjectString path,
                    final EntityObjectString filename,
                    final EntityObjectString pattern,
                    final EntityObjectInt instance
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
                    final TextFileContent54Behaviors behaviors
                    )
    {
        _behaviors = behaviors;
    }


    public TextFileContent54Object behaviors(
                    final TextFileContent54Behaviors behaviors
                    )
    {
        setBehaviors( behaviors );
        return this;
    }


    public TextFileContent54Behaviors getBehaviors()
    {
        return _behaviors;
    }



    /**
     */
    public void setFilepath(
                    final EntityObjectString filepath
                    )
    {
        _filepath = filepath;
    }


    public TextFileContent54Object filepath(
                    final EntityObjectString filepath
                    )
    {
        setFilepath( filepath );
        return this;
    }


    public EntityObjectString getFilepath()
    {
        return _filepath;
    }



    /**
     */
    public void setPath(
                    final EntityObjectString path
                    )
    {
        _path = path;
    }


    public TextFileContent54Object path(
                    final EntityObjectString path
                    )
    {
        setPath( path );
        return this;
    }


    public EntityObjectString getPath()
    {
        return _path;
    }



    /**
     */
    public void setFilename(
                    final EntityObjectString filename
                    )
    {
        _filename = filename;
    }


    public TextFileContent54Object filename(
                    final EntityObjectString filename
                    )
    {
        setFilename( filename );
        return this;
    }


    public EntityObjectString getFilename()
    {
        return _filename;
    }



    /**
     */
    public void setPattern(
                    final EntityObjectString pattern
                    )
    {
        _pattern = pattern;
    }


    public TextFileContent54Object pattern(
                    final EntityObjectString pattern
                    )
    {
        setPattern( pattern );
        return this;
    }


    public EntityObjectString getPattern()
    {
        return _pattern;
    }



    /**
     */
    public void setInstance(
                    final EntityObjectInt instance
                    )
    {
        _instance = instance;
    }


    public TextFileContent54Object instance(
                    final EntityObjectInt instance
                    )
    {
        setInstance( instance );
        return this;
    }


    public EntityObjectInt getInstance()
    {
        return _instance;
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


    public TextFileContent54Object filter(
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
    public EntityType getEntityType()
    {
        return EntityType.INDEPENDENT_TEXTFILECONTENT54;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        TextFileContent54Behaviors  behaviors = getBehaviors();
        result = prime * result + ((behaviors == null) ? 0 : behaviors.hashCode());

        EntityObjectString  filepath = getFilepath();
        result = prime * result + ((filepath == null) ? 0 : filepath.hashCode());

        EntityObjectString  path = getPath();
        result = prime * result + ((path == null) ? 0 : path.hashCode());

        EntityObjectString  filename = getFilename();
        result = prime * result + ((filename == null) ? 0 : filename.hashCode());

        EntityObjectString  pattern = getPattern();
        result = prime * result + ((pattern == null) ? 0 : pattern.hashCode());

        EntityObjectInt  instance = getInstance();
        result = prime * result + ((instance == null) ? 0 : instance.hashCode());

        Collection<Filter>  filter = getFilter();
        result = prime * result + ((filter == null) ? 0 : filter.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof TextFileContent54Object)) {
            return false;
        }

        if (super.equals( obj )) {
            TextFileContent54Object  other = (TextFileContent54Object)obj;
            TextFileContent54Behaviors  otherBehaviors = other.getBehaviors();
            TextFileContent54Behaviors   thisBehaviors =  this.getBehaviors();
            if (thisBehaviors == otherBehaviors
                            ||  (thisBehaviors != null  &&  thisBehaviors.equals( otherBehaviors ))) {
                EntityObjectString  otherFilepath = other.getFilepath();
                EntityObjectString   thisFilepath =  this.getFilepath();
                if (thisFilepath == otherFilepath
                                ||  (thisFilepath != null  &&  thisFilepath.equals( otherFilepath ))) {
                    EntityObjectString  otherPath = other.getPath();
                    EntityObjectString   thisPath =  this.getPath();
                    if (thisPath == otherPath
                                    ||  (thisPath != null  &&  thisPath.equals( otherPath ))) {
                        EntityObjectString  otherFilename = other.getFilename();
                        EntityObjectString   thisFilename =  this.getFilename();
                        if (thisFilename == otherFilename
                                        ||  (thisFilename != null  &&  thisFilename.equals( otherFilename ))) {
                            EntityObjectString  otherPattern = other.getPattern();
                            EntityObjectString   thisPattern =  this.getPattern();
                            if (thisPattern == otherPattern
                                            ||  (thisPattern != null  &&  thisPattern.equals( otherPattern ))) {
                                EntityObjectInt  otherInstance = other.getInstance();
                                EntityObjectInt   thisInstance =  this.getInstance();
                                if (thisInstance == otherInstance
                                                ||  (thisInstance != null  &&  thisInstance.equals( otherInstance ))) {
                                    Collection<Filter>  otherFilter = other.getFilter();
                                    Collection<Filter>   thisFilter =  this.getFilter();
                                    if (thisFilter == otherFilter
                                                    ||  (thisFilter != null  &&  thisFilter.equals( otherFilter ))) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return false;
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
