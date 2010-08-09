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

import jp.go.aist.six.oval.model.EntityType;
import jp.go.aist.six.oval.model.definitions.EntityObjectString;
import jp.go.aist.six.oval.model.definitions.SystemObject;



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
                    final EntityObjectString path
                    )
    {
        _path = path;
    }


    /**
     */
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


    /**
     */
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


    /**
     */
    public EntityObjectString getLine()
    {
        return _line;
    }



    //**************************************************************
    //  SystemObject
    //**************************************************************

    @Override
    public EntityType getObjectType()
    {
        return EntityType.INDEPENDENT_TEXTFILECONTENT;
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
