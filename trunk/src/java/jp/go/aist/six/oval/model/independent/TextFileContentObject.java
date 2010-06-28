/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
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

import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.definition.EntityObjectStringType;
import jp.go.aist.six.oval.model.definition.SystemObject;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class TextFileContentObject
    extends SystemObject
{

    private TextFileContentBehaviors  _behaviors;
    //{0..1}


    private EntityObjectStringType  _path;
    //{1..1}

    private EntityObjectStringType  _filename;
    //{1..1}

    private EntityObjectStringType  _line;
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
                        new EntityObjectStringType( path ),
                        new EntityObjectStringType( filename ),
                        new EntityObjectStringType( line)
                        );
    }


    /**
     * Constructor.
     */
    public TextFileContentObject(
                    final String id,
                    final int version,
                    final EntityObjectStringType path,
                    final EntityObjectStringType filename,
                    final EntityObjectStringType line
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
                    final TextFileContentBehaviors behaviors
                    )
    {
        _behaviors = behaviors;
    }


    /**
     */
    public TextFileContentBehaviors getBehaviors()
    {
        return _behaviors;
    }



    /**
     */
    public void setPath(
                    final EntityObjectStringType path
                    )
    {
        _path = path;
    }


    /**
     */
    public EntityObjectStringType getPath()
    {
        return _path;
    }



    /**
     */
    public void setFilename(
                    final EntityObjectStringType filename
                    )
    {
        _filename = filename;
    }


    /**
     */
    public EntityObjectStringType getFilename()
    {
        return _filename;
    }



    /**
     */
    public void setLine(
                    final EntityObjectStringType line
                    )
    {
        _line = line;
    }


    /**
     */
    public EntityObjectStringType getLine()
    {
        return _line;
    }



    //**************************************************************
    //  SystemObject
    //**************************************************************

    @Override
    public ComponentType getSystemObjectType()
    {
        return ComponentType.INDEPENDENT_TEXTFILECONTENT;
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
        return "TextFileContentObject[" + super.toString()
                        + ", path=" + getPath()
                        + ", filename=" + getFilename()
                        + ", line=" + getLine()
                        + "]";
    }

}
// TextFileContentObject
