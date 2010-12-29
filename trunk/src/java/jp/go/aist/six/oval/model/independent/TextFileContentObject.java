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

import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.definitions.EntityObjectString;
import jp.go.aist.six.oval.model.definitions.SystemObject;



/**
 * The textfilecontent object is used by a text file content test
 * to define the specific line(s) of a file(s) to be evaluated.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.4:
 *             Replaced by the textfilecontent54 object and
 *             will be removed in version 6.0 of the language.
 */
public class TextFileContentObject
    extends SystemObject
{

    private FileBehaviors  _behaviors;
    //{0..1}


    private EntityObjectString  _path;
    //{1..1}

    private EntityObjectString  _filename;
    //{1..1}

    private EntityObjectString  _line;
    //{1..1}



    /**
     * Constructor.
     */
    public TextFileContentObject()
    {
    }


    /**
     * Constructor.
     */
    public TextFileContentObject(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public TextFileContentObject(
                    final String id,
                    final int version,
                    final String path,
                    final String filename,
                    final String line
                    )
    {
        this( id, version,
                        new EntityObjectString( path ),
                        new EntityObjectString( filename ),
                        new EntityObjectString( line)
                        );
    }


    /**
     * Constructor.
     */
    public TextFileContentObject(
                    final String id,
                    final int version,
                    final EntityObjectString path,
                    final EntityObjectString filename,
                    final EntityObjectString line
                    )
    {
        super( id, version );
        setPath( path );
        setFilename( filename );
        setLine( line );
    }



    /**
     */
    public void setBehaviors(
                    final FileBehaviors behaviors
                    )
    {
        _behaviors = behaviors;
    }


    public TextFileContentObject behaviors(
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
    public void setPath(
                    final EntityObjectString path
                    )
    {
        _path = path;
    }


    public TextFileContentObject path(
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


    public TextFileContentObject filename(
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
    public void setLine(
                    final EntityObjectString line
                    )
    {
        _line = line;
    }


    public TextFileContentObject line(
                    final EntityObjectString line
                    )
    {
        setLine( line );
        return this;
    }


    public EntityObjectString getLine()
    {
        return _line;
    }



    //**************************************************************
    //  SystemObject
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.INDEPENDENT_TEXTFILECONTENT;
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
        if (!(obj instanceof TextFileContentObject)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "textfilecontent_object[" + super.toString()
                        + ", behaviors=" + getBehaviors()
                        + ", path=" + getPath()
                        + ", filename=" + getFilename()
                        + ", line=" + getLine()
                        + "]";
    }

}
// TextFileContentObject
