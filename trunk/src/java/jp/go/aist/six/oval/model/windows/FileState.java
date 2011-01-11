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
import jp.go.aist.six.oval.model.definitions.EntityStateBase;
import jp.go.aist.six.oval.model.definitions.EntityStateInt;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.EntityStateVersion;
import jp.go.aist.six.oval.model.definitions.State;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;



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

    private Map<FileProperty, EntityStateBase>  _properties =
        new EnumMap<FileProperty, EntityStateBase>( FileProperty.class );
    //EntityStateBase{0..1}



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
        _setStateProperty( FileProperty.FILEPATH, filepath );
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
        return _getStateProperty( FileProperty.FILEPATH, EntityStateString.class );
    }



    /**
     */
    public void setPath(
                    final EntityStateString path
                    )
    {
        _setStateProperty( FileProperty.PATH, path );
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
        return _getStateProperty( FileProperty.PATH, EntityStateString.class );
    }



    /**
     */
    public void setFilename(
                    final EntityStateString filename
                    )
    {
        _setStateProperty( FileProperty.FILENAME, filename );
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
        return _getStateProperty( FileProperty.FILENAME, EntityStateString.class );
    }



    /**
     */
    public void setOwner(
                    final EntityStateString owner
                    )
    {
        _setStateProperty( FileProperty.OWNER, owner );
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
        return _getStateProperty( FileProperty.OWNER, EntityStateString.class );
    }



    /**
     */
    public void setSize(
                    final EntityStateInt size
                    )
    {
        _setStateProperty( FileProperty.SIZE, size );
    }


    public EntityStateInt getSize()
    {
        return _getStateProperty( FileProperty.SIZE, EntityStateInt.class );
    }



    /**
     */
    public void setATime(
                    final EntityStateInt atime
                    )
    {
        _setStateProperty( FileProperty.A_TIME, atime );
    }


    public EntityStateInt getATime()
    {
        return _getStateProperty( FileProperty.A_TIME, EntityStateInt.class );
    }



    /**
     */
    public void setCTime(
                    final EntityStateInt ctime
                    )
    {
        _setStateProperty( FileProperty.C_TIME, ctime );
    }


    public EntityStateInt getCTime()
    {
        return _getStateProperty( FileProperty.C_TIME, EntityStateInt.class );
    }



    /**
     */
    public void setMTime(
                    final EntityStateInt mtime
                    )
    {
        _setStateProperty( FileProperty.M_TIME, mtime );
    }


    public EntityStateInt getMTime()
    {
        return _getStateProperty( FileProperty.M_TIME, EntityStateInt.class );
    }



    /**
     */
    public void setMSChecksum(
                    final EntityStateString checksum
                    )
    {
        _setStateProperty( FileProperty.MS_CHECKSUM, checksum );
    }


    public EntityStateString getMSChecksum()
    {
        return _getStateProperty( FileProperty.MS_CHECKSUM, EntityStateString.class );
    }



    /**
     */
    public void setVersion(
                    final EntityStateVersion version
                    )
    {
        _setStateProperty( FileProperty.VERSION, version );
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
        return _getStateProperty( FileProperty.VERSION, EntityStateVersion.class );
    }



    /**
     */
    public void setType(
                    final EntityStateFileType type
                    )
    {
        _setStateProperty( FileProperty.TYPE, type );
    }


    public EntityStateFileType getType()
    {
        return _getStateProperty( FileProperty.TYPE, EntityStateFileType.class );
    }



    /**
     */
    public void setDevelopmentClass(
                    final EntityStateString developmentClass
                    )
    {
        _setStateProperty( FileProperty.DEVELOPMENT_CLASS, developmentClass );
    }


    public EntityStateString getDevelopmentClass()
    {
        return _getStateProperty( FileProperty.DEVELOPMENT_CLASS, EntityStateString.class );
    }



    /**
     */
    public void setCompany(
                    final EntityStateString company
                    )
    {
        _setStateProperty( FileProperty.COMPANY, company );
    }


    public EntityStateString getCompany()
    {
        return _getStateProperty( FileProperty.COMPANY, EntityStateString.class );
    }



    /**
     */
    public void setInternalName(
                    final EntityStateString internalName
                    )
    {
        _setStateProperty( FileProperty.INTERNAL_NAME, internalName );
    }


    public EntityStateString getInternalName()
    {
        return _getStateProperty( FileProperty.INTERNAL_NAME, EntityStateString.class );
    }



    /**
     */
    public void setLanguage(
                    final EntityStateString language
                    )
    {
        _setStateProperty( FileProperty.LANGUAGE, language );
    }


    public EntityStateString getLanguage()
    {
        return _getStateProperty( FileProperty.LANGUAGE, EntityStateString.class );
    }



    /**
     */
    public void setOriginalFilename(
                    final EntityStateString filename
                    )
    {
        _setStateProperty( FileProperty.ORIGINAL_FILENAME, filename );
    }


    public EntityStateString getOriginalFilename()
    {
        return _getStateProperty( FileProperty.ORIGINAL_FILENAME, EntityStateString.class );
    }



    /**
     */
    public void setProductName(
                    final EntityStateString name
                    )
    {
        _setStateProperty( FileProperty.PRODUCT_NAME, name );
    }


    public EntityStateString getProductName()
    {
        return _getStateProperty( FileProperty.PRODUCT_NAME, EntityStateString.class );
    }



    /**
     */
    public void setProductVersion(
                    final EntityStateVersion version
                    )
    {
        _setStateProperty( FileProperty.PRODUCT_VERSION, version );
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
        return _getStateProperty( FileProperty.PRODUCT_VERSION, EntityStateVersion.class );
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
    public Iterator<EntityStateBase> iterateStateProperties()
    {
        return _properties.values().iterator();
    }



    protected <T extends EntityStateBase> T _getStateProperty(
                    final FileProperty key,
                    final Class<T> type
                    )
    {
        EntityStateBase  p = _properties.get( key );
        return type.cast( p );
    }



    protected void _setStateProperty(
                    final FileProperty key,
                    final EntityStateBase value
                    )
    {
        _properties.put( key, value );
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
