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

import jp.go.aist.six.oval.core.model.ComponentType;
import jp.go.aist.six.oval.model.definition.EntityObjectStringType;
import jp.go.aist.six.oval.model.definition.SystemObject;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: TextFileContentObject.java 696 2010-04-26 10:22:00Z akihito $
 */
public class TextFileContentObject
    extends SystemObject
{

//    private Behaviors  _behaviors;
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
                    final String filename
                    )
    {
        super( id, version );
        setPath( path );
        setFilename( filename );
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




    public void setPath(
                    final String path
                    )
    {
        setPath( new EntityObjectStringType( path ) );
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



    public void setFilename(
                    final String filename
                    )
    {
        setFilename( new EntityObjectStringType( filename ) );
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

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        return super.hashCode();
    }



    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
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



    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "FamilyObject[" + super.toString()
                        + "]";
    }

}
// TextFileContentObject
