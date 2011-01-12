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

package jp.go.aist.six.oval.model.windows;

import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.definitions.EntityBase;
import jp.go.aist.six.oval.model.definitions.EntityStateInt;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.EntityStateVersion;
import jp.go.aist.six.oval.model.definitions.State;
import java.util.Iterator;



/**
 * The file state defines the different metadata associate with a Windows file.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class FileState
    extends State
{

    private FileProperty.EntityMap  _properties = FileProperty.createEntityMap();

//    private EnumMap<FileProperty, EntityBase>  _properties =
//        new EnumMap<FileProperty, EntityBase>( FileProperty.class );
//    //EntityStateBase{0..1}



    /**
     * Constructor.
     */
    public FileState()
    {
    }


    /**
     * Constructor.
     */
    public FileState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public FileState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );
    }



    /**
     */
    public void setFilepath(
                    final EntityStateString filepath
                    )
    {
        _properties.setProperty( FileProperty.FILEPATH, filepath );
    }


    public FileState filepath(
                    final EntityStateString filepath
                    )
    {
        setFilepath( filepath );
        return this;
    }


    public EntityStateString getFilepath()
    {
        return _properties.getProperty( FileProperty.FILEPATH, EntityStateString.class );
    }



    /**
     */
    public void setPath(
                    final EntityStateString path
                    )
    {
        _properties.setProperty( FileProperty.PATH, path );
    }


    public FileState path(
                    final EntityStateString path
                    )
    {
        setPath( path );
        return this;
    }


    public EntityStateString getPath()
    {
        return _properties.getProperty( FileProperty.PATH, EntityStateString.class );
    }



    /**
     */
    public void setFilename(
                    final EntityStateString filename
                    )
    {
        _properties.setProperty( FileProperty.FILENAME, filename );
    }


    public FileState filename(
                    final EntityStateString filename
                    )
    {
        setFilename( filename );
        return this;
    }


    public EntityStateString getFilename()
    {
        return _properties.getProperty( FileProperty.FILENAME, EntityStateString.class );
    }



    /**
     */
    public void setOwner(
                    final EntityStateString owner
                    )
    {
        _properties.setProperty( FileProperty.OWNER, owner );
    }


    public FileState owner(
                    final EntityStateString owner
                    )
    {
        setOwner( owner );
        return this;
    }


    public EntityStateString getOwner()
    {
        return _properties.getProperty( FileProperty.OWNER, EntityStateString.class );
    }



    /**
     */
    public void setSize(
                    final EntityStateInt size
                    )
    {
        _properties.setProperty( FileProperty.SIZE, size );
    }


    public EntityStateInt getSize()
    {
        return _properties.getProperty( FileProperty.SIZE, EntityStateInt.class );
    }



    /**
     */
    public void setATime(
                    final EntityStateInt atime
                    )
    {
        _properties.setProperty( FileProperty.A_TIME, atime );
    }


    public EntityStateInt getATime()
    {
        return _properties.getProperty( FileProperty.A_TIME, EntityStateInt.class );
    }



    /**
     */
    public void setCTime(
                    final EntityStateInt ctime
                    )
    {
        _properties.setProperty( FileProperty.C_TIME, ctime );
    }


    public EntityStateInt getCTime()
    {
        return _properties.getProperty( FileProperty.C_TIME, EntityStateInt.class );
    }



    /**
     */
    public void setMTime(
                    final EntityStateInt mtime
                    )
    {
        _properties.setProperty( FileProperty.M_TIME, mtime );
    }


    public EntityStateInt getMTime()
    {
        return _properties.getProperty( FileProperty.M_TIME, EntityStateInt.class );
    }



    /**
     */
    public void setMSChecksum(
                    final EntityStateString checksum
                    )
    {
        _properties.setProperty( FileProperty.MS_CHECKSUM, checksum );
    }


    public EntityStateString getMSChecksum()
    {
        return _properties.getProperty( FileProperty.MS_CHECKSUM, EntityStateString.class );
    }



    /**
     */
    public void setVersion(
                    final EntityStateVersion version
                    )
    {
        _properties.setProperty( FileProperty.VERSION, version );
    }


    public FileState version(
                    final EntityStateVersion version
                    )
    {
        setVersion( version );
        return this;
    }


    public EntityStateVersion getVersion()
    {
        return _properties.getProperty( FileProperty.VERSION, EntityStateVersion.class );
    }



    /**
     */
    public void setType(
                    final EntityStateFileType type
                    )
    {
        _properties.setProperty( FileProperty.TYPE, type );
    }


    public EntityStateFileType getType()
    {
        return _properties.getProperty( FileProperty.TYPE, EntityStateFileType.class );
    }



    /**
     */
    public void setDevelopmentClass(
                    final EntityStateString developmentClass
                    )
    {
        _properties.setProperty( FileProperty.DEVELOPMENT_CLASS, developmentClass );
    }


    public EntityStateString getDevelopmentClass()
    {
        return _properties.getProperty( FileProperty.DEVELOPMENT_CLASS, EntityStateString.class );
    }



    /**
     */
    public void setCompany(
                    final EntityStateString company
                    )
    {
        _properties.setProperty( FileProperty.COMPANY, company );
    }


    public EntityStateString getCompany()
    {
        return _properties.getProperty( FileProperty.COMPANY, EntityStateString.class );
    }



    /**
     */
    public void setInternalName(
                    final EntityStateString internalName
                    )
    {
        _properties.setProperty( FileProperty.INTERNAL_NAME, internalName );
    }


    public EntityStateString getInternalName()
    {
        return _properties.getProperty( FileProperty.INTERNAL_NAME, EntityStateString.class );
    }



    /**
     */
    public void setLanguage(
                    final EntityStateString language
                    )
    {
        _properties.setProperty( FileProperty.LANGUAGE, language );
    }


    public EntityStateString getLanguage()
    {
        return _properties.getProperty( FileProperty.LANGUAGE, EntityStateString.class );
    }



    /**
     */
    public void setOriginalFilename(
                    final EntityStateString filename
                    )
    {
        _properties.setProperty( FileProperty.ORIGINAL_FILENAME, filename );
    }


    public EntityStateString getOriginalFilename()
    {
        return _properties.getProperty( FileProperty.ORIGINAL_FILENAME, EntityStateString.class );
    }



    /**
     */
    public void setProductName(
                    final EntityStateString name
                    )
    {
        _properties.setProperty( FileProperty.PRODUCT_NAME, name );
    }


    public EntityStateString getProductName()
    {
        return _properties.getProperty( FileProperty.PRODUCT_NAME, EntityStateString.class );
    }



    /**
     */
    public void setProductVersion(
                    final EntityStateVersion version
                    )
    {
        _properties.setProperty( FileProperty.PRODUCT_VERSION, version );
    }


    public FileState productVersion(
                    final EntityStateVersion version
                    )
    {
        setProductVersion( version );
        return this;
    }


    public EntityStateVersion getProductVersion()
    {
        return _properties.getProperty( FileProperty.PRODUCT_VERSION, EntityStateVersion.class );
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.WINDOWS_FILE;
    }



    @Override
    public Iterator<EntityBase> iterateProperties()
    {
        return _properties.iterateProperties();
    }



//    protected <T extends EntityStateBase> T _getProperty(
//                    final FileProperty key,
//                    final Class<T> type
//                    )
//    {
//        EntityBase  p = _properties.get( key );
//        return type.cast( p );
//    }
//
//
//
//    protected void _setProperty(
//                    final FileProperty key,
//                    final EntityStateBase value
//                    )
//    {
//        _properties.put( key, value );
//    }



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
        if (!(obj instanceof FileState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "file_state[" + super.toString()
                        + ", " + String.valueOf( _properties )
                        + "]";
    }

}
// FileState
