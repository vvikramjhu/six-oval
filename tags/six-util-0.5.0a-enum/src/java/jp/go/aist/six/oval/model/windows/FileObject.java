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

import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.common.Behaviors;
import jp.go.aist.six.oval.model.definition.EntityObjectString;
import jp.go.aist.six.oval.model.definition.EntityTypeHelper;
import jp.go.aist.six.oval.model.definition.SystemObject;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
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
    private EntityObjectString  _filepath;
    //{1..1}

    private EntityObjectString  _path;
    //{1..1}

    private EntityObjectString  _filename;
    //{1..1, nillable="true"}



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



    public void setBehaviors(
                    final FileBehaviors behaviors
                    )
    {
        _behaviors = behaviors;
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
        _filepath = filepath;
    }


    /**
     */
    public EntityObjectString getFilepath()
    {
        return _filepath;
    }



    public void setPath(
                    final EntityObjectString path
                    )
    {
        _path = path;
    }


    public EntityObjectString getPath()
    {
        return _path;
    }



    public void setFilename(
                    final EntityObjectString filename
                    )
    {
        _filename = filename;
    }


    public EntityObjectString getFilename()
    {
        return _filename;
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

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        Behaviors  behaviors = getBehaviors();
        result = prime * result + ((behaviors == null) ? 0 : behaviors.hashCode());

        EntityObjectString  path = getPath();
        result = prime * result + ((path == null) ? 0 : path.hashCode());

        EntityObjectString  filename = getFilename();
        result = prime * result + ((filename == null) ? 0 : filename.hashCode());

        return result;
    }


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
            EntityObjectString  other_filename = other.getFilename();
            EntityObjectString   this_filename =  this.getFilename();
            if (EntityTypeHelper.equals( this_filename, other_filename )) {
                EntityObjectString  other_path = other.getPath();
                EntityObjectString   this_path =  this.getPath();
                if (EntityTypeHelper.equals( this_path, other_path)) {
                    FileBehaviors  other_behaviors = other.getBehaviors();
                    FileBehaviors   this_behaviors =  this.getBehaviors();
                    if (this_behaviors == other_behaviors
                                    ||  (this_behaviors != null  &&  this_behaviors.equals( other_behaviors ))) {
                        return true;
                    }
                }
            }
        }

        return false;
    }



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
