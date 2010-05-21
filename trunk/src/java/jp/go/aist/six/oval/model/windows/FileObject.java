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

package jp.go.aist.six.oval.model.windows;

import jp.go.aist.six.oval.core.model.ComponentType;
import jp.go.aist.six.oval.core.model.definition.EntityTypeHelper;
import jp.go.aist.six.oval.model.definition.EntityObjectStringType;
import jp.go.aist.six.oval.model.definition.SystemObject;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: FileObject.java 696 2010-04-26 10:22:00Z akihito $
 */
public class FileObject
    extends SystemObject
{

    private Behaviors  _behaviors;// = Behaviors.DEFAULT_VALUE;
    //{0..1}

    private EntityObjectStringType  _path;// = new EntityObjectStringType();
    //{1..1}

    private EntityObjectStringType  _filename;// = new EntityObjectStringType();
    //{1..1, nillable}




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
    public FileObject(
                    final String id,
                    final int version,
                    final EntityObjectStringType path,
                    final EntityObjectStringType filename
                    )
    {
        super( id, version );
        setPath( path );
        setFilename( filename );
    }




    public void setFilename(
                    final String filename
                    )
    {
        setFilename( new EntityObjectStringType( filename ) );
    }


    public void setFilename(
                    final EntityObjectStringType filename
                    )
    {
        _filename = filename;
    }


    public EntityObjectStringType getFilename()
    {
        return _filename;
    }



    public void setPath(
                    final String path
                    )
    {
        setPath( new EntityObjectStringType( path ) );
    }


    public void setPath(
                    final EntityObjectStringType path
                    )
    {
        _path = path;
    }


    public EntityObjectStringType getPath()
    {
        return _path;
    }



    public void setBehaviors(
                    final Behaviors behaviors
                    )
    {
        _behaviors = behaviors;
    }


    public Behaviors getBehaviors()
    {
        return _behaviors;
    }



    //**************************************************************
    //  SystemObject
    //**************************************************************

    @Override
    public ComponentType getSystemObjectType()
    {
        return ComponentType.WINDOWS_FILE;
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
        final int  prime = 37;
        int  result = super.hashCode();

        Behaviors  behaviors = getBehaviors();
        result = prime * result + ((behaviors == null) ? 0 : behaviors.hashCode());

        EntityObjectStringType  path = getPath();
        result = prime * result + ((path == null) ? 0 : path.hashCode());

        EntityObjectStringType  filename = getFilename();
        result = prime * result + ((filename == null) ? 0 : filename.hashCode());

        return result;
    }


    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof FileObject)) {
            return false;
        }

        if (super.equals( obj )) {
            FileObject  other = (FileObject)obj;
            EntityObjectStringType  other_filename = other.getFilename();
            EntityObjectStringType   this_filename =  this.getFilename();
            if (EntityTypeHelper.equals( this_filename, other_filename )) {
                EntityObjectStringType  other_path = other.getPath();
                EntityObjectStringType   this_path =  this.getPath();
                if (EntityTypeHelper.equals( this_path, other_path)) {
                    Behaviors  other_behaviors = other.getBehaviors();
                    Behaviors   this_behaviors =  this.getBehaviors();
                    if (this_behaviors == other_behaviors
                                    ||  (this_behaviors != null  &&  this_behaviors.equals( other_behaviors ))) {
                        return true;
                    }
                }
            }
        }

        return false;
    }



    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "FileObject[" + super.toString()
                        + ", behaviors=" + getBehaviors()
                        + ", path=" + getPath()
                        + ", filename=" + getFilename()
                        + "]";
    }

}
// FileObject
