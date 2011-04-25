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

package jp.go.aist.six.oval.model.v5.windows;

import java.util.Iterator;
import jp.go.aist.six.oval.model.v5.PlatformEntityType;
import jp.go.aist.six.oval.model.v5.definitions.EntityAttributeGroup;
import jp.go.aist.six.oval.model.v5.definitions.EntityPropertyMap;
import jp.go.aist.six.oval.model.v5.definitions.EntityStateIntType;
import jp.go.aist.six.oval.model.v5.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.v5.definitions.EntityStateVersionType;
import jp.go.aist.six.oval.model.v5.definitions.StateType;



/**
 * The file state defines the different metadata associate with a Windows file.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class FileState
    extends StateType
{

    private final EntityPropertyMap<FileProperty>  _properties =
        FileProperty.createPropertyMap();



    /**
     * Constructor.
     */
    public FileState()
    {
    }


    public FileState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


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
                    final EntityStateStringType filepath
                    )
    {
        _properties.setProperty( FileProperty.FILEPATH, filepath );
    }


    public FileState filepath(
                    final EntityStateStringType filepath
                    )
    {
        setFilepath( filepath );
        return this;
    }


    public EntityStateStringType getFilepath()
    {
        return _properties.getProperty(
                        FileProperty.FILEPATH, EntityStateStringType.class );
    }



    /**
     */
    public void setPath(
                    final EntityStateStringType path
                    )
    {
        _properties.setProperty( FileProperty.PATH, path );
    }


    public FileState path(
                    final EntityStateStringType path
                    )
    {
        setPath( path );
        return this;
    }


    public EntityStateStringType getPath()
    {
        return _properties.getProperty(
                        FileProperty.PATH, EntityStateStringType.class );
    }



    /**
     */
    public void setFilename(
                    final EntityStateStringType filename
                    )
    {
        _properties.setProperty( FileProperty.FILENAME, filename );
    }


    public FileState filename(
                    final EntityStateStringType filename
                    )
    {
        setFilename( filename );
        return this;
    }


    public EntityStateStringType getFilename()
    {
        return _properties.getProperty(
                        FileProperty.FILENAME, EntityStateStringType.class );
    }



    /**
     */
    public void setOwner(
                    final EntityStateStringType owner
                    )
    {
        _properties.setProperty( FileProperty.OWNER, owner );
    }


    public FileState owner(
                    final EntityStateStringType owner
                    )
    {
        setOwner( owner );
        return this;
    }


    public EntityStateStringType getOwner()
    {
        return _properties.getProperty(
                        FileProperty.OWNER, EntityStateStringType.class );
    }



    /**
     */
    public void setSize(
                    final EntityStateIntType size
                    )
    {
        _properties.setProperty( FileProperty.SIZE, size );
    }


    public EntityStateIntType getSize()
    {
        return _properties.getProperty(
                        FileProperty.SIZE, EntityStateIntType.class );
    }



    /**
     */
    public void setATime(
                    final EntityStateIntType atime
                    )
    {
        _properties.setProperty( FileProperty.A_TIME, atime );
    }


    public EntityStateIntType getATime()
    {
        return _properties.getProperty(
                        FileProperty.A_TIME, EntityStateIntType.class );
    }



    /**
     */
    public void setCTime(
                    final EntityStateIntType ctime
                    )
    {
        _properties.setProperty( FileProperty.C_TIME, ctime );
    }


    public EntityStateIntType getCTime()
    {
        return _properties.getProperty(
                        FileProperty.C_TIME, EntityStateIntType.class );
    }



    /**
     */
    public void setMTime(
                    final EntityStateIntType mtime
                    )
    {
        _properties.setProperty( FileProperty.M_TIME, mtime );
    }


    public EntityStateIntType getMTime()
    {
        return _properties.getProperty(
                        FileProperty.M_TIME, EntityStateIntType.class );
    }



    /**
     */
    public void setMSChecksum(
                    final EntityStateStringType checksum
                    )
    {
        _properties.setProperty( FileProperty.MS_CHECKSUM, checksum );
    }


    public EntityStateStringType getMSChecksum()
    {
        return _properties.getProperty(
                        FileProperty.MS_CHECKSUM, EntityStateStringType.class );
    }



    /**
     */
    public void setVersion(
                    final EntityStateVersionType version
                    )
    {
        _properties.setProperty( FileProperty.VERSION, version );
    }


    public FileState version(
                    final EntityStateVersionType version
                    )
    {
        setVersion( version );
        return this;
    }


    public EntityStateVersionType getVersion()
    {
        return _properties.getProperty(
                        FileProperty.VERSION, EntityStateVersionType.class );
    }



    /**
     */
    public void setType(
                    final EntityStateFileTypeType type
                    )
    {
        _properties.setProperty( FileProperty.TYPE, type );
    }


    public EntityStateFileTypeType getType()
    {
        return _properties.getProperty(
                        FileProperty.TYPE, EntityStateFileTypeType.class );
    }



    /**
     */
    public void setDevelopmentClass(
                    final EntityStateStringType developmentClass
                    )
    {
        _properties.setProperty( FileProperty.DEVELOPMENT_CLASS, developmentClass );
    }


    public EntityStateStringType getDevelopmentClass()
    {
        return _properties.getProperty(
                        FileProperty.DEVELOPMENT_CLASS, EntityStateStringType.class );
    }



    /**
     */
    public void setCompany(
                    final EntityStateStringType company
                    )
    {
        _properties.setProperty( FileProperty.COMPANY, company );
    }


    public EntityStateStringType getCompany()
    {
        return _properties.getProperty(
                        FileProperty.COMPANY, EntityStateStringType.class );
    }



    /**
     */
    public void setInternalName(
                    final EntityStateStringType internalName
                    )
    {
        _properties.setProperty( FileProperty.INTERNAL_NAME, internalName );
    }


    public EntityStateStringType getInternalName()
    {
        return _properties.getProperty(
                        FileProperty.INTERNAL_NAME, EntityStateStringType.class );
    }



    /**
     */
    public void setLanguage(
                    final EntityStateStringType language
                    )
    {
        _properties.setProperty( FileProperty.LANGUAGE, language );
    }


    public EntityStateStringType getLanguage()
    {
        return _properties.getProperty(
                        FileProperty.LANGUAGE, EntityStateStringType.class );
    }



    /**
     */
    public void setOriginalFilename(
                    final EntityStateStringType filename
                    )
    {
        _properties.setProperty( FileProperty.ORIGINAL_FILENAME, filename );
    }


    public EntityStateStringType getOriginalFilename()
    {
        return _properties.getProperty(
                        FileProperty.ORIGINAL_FILENAME, EntityStateStringType.class );
    }



    /**
     */
    public void setProductName(
                    final EntityStateStringType name
                    )
    {
        _properties.setProperty( FileProperty.PRODUCT_NAME, name );
    }


    public EntityStateStringType getProductName()
    {
        return _properties.getProperty(
                        FileProperty.PRODUCT_NAME, EntityStateStringType.class );
    }



    /**
     */
    public void setProductVersion(
                    final EntityStateVersionType version
                    )
    {
        _properties.setProperty( FileProperty.PRODUCT_VERSION, version );
    }


    public FileState productVersion(
                    final EntityStateVersionType version
                    )
    {
        setProductVersion( version );
        return this;
    }


    public EntityStateVersionType getProductVersion()
    {
        return _properties.getProperty(
                        FileProperty.PRODUCT_VERSION, EntityStateVersionType.class );
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
    public Iterator<EntityAttributeGroup> iterateProperties()
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
