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
        _properties.put( FileProperty.FILEPATH, filepath );
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
        return (EntityStateString)_properties.get( FileProperty.FILEPATH );
    }



    /**
     */
    public void setPath(
                    final EntityStateString path
                    )
    {
        _properties.put( FileProperty.PATH, path );
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
        return (EntityStateString)_properties.get( FileProperty.PATH );
    }



    /**
     */
    public void setFilename(
                    final EntityStateString filanem
                    )
    {
        _properties.put( FileProperty.FILENAME, filanem );
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
        return (EntityStateString)_properties.get( FileProperty.FILENAME );
    }



    /**
     */
    public void setOwner(
                    final EntityStateString owner
                    )
    {
        _properties.put( FileProperty.OWNER, owner );
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
        return (EntityStateString)_properties.get( FileProperty.OWNER );
    }



    /**
     */
    public void setSize(
                    final EntityStateInt size
                    )
    {
        _properties.put( FileProperty.SIZE, size );
    }


    public EntityStateInt getSize()
    {
        return (EntityStateInt)_properties.get( FileProperty.SIZE );
    }



    /**
     */
    public void setATime(
                    final EntityStateInt atime
                    )
    {
        _properties.put( FileProperty.A_TIME, atime );
    }


    public EntityStateInt getATime()
    {
        return (EntityStateInt)_properties.get( FileProperty.A_TIME );
    }



    /**
     */
    public void setCTime(
                    final EntityStateInt ctime
                    )
    {
        _properties.put( FileProperty.C_TIME, ctime );
    }


    public EntityStateInt getCTime()
    {
        return (EntityStateInt)_properties.get( FileProperty.C_TIME );
    }



    /**
     */
    public void setMTime(
                    final EntityStateInt mtime
                    )
    {
        _properties.put( FileProperty.M_TIME, mtime );
    }


    public EntityStateInt getMTime()
    {
        return (EntityStateInt)_properties.get( FileProperty.M_TIME );
    }



    /**
     */
    public void setMSChecksum(
                    final EntityStateString checksum
                    )
    {
        _properties.put( FileProperty.MS_CHECKSUM, checksum );
    }


    public EntityStateString getMSChecksum()
    {
        return (EntityStateString)_properties.get( FileProperty.MS_CHECKSUM );
    }



    /**
     */
    public void setVersion(
                    final EntityStateVersion version
                    )
    {
        _properties.put( FileProperty.VERSION, version );
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
        return (EntityStateVersion)_properties.get( FileProperty.VERSION );
    }



    /**
     */
    public void setType(
                    final EntityStateFileType type
                    )
    {
        _properties.put( FileProperty.TYPE, type );
    }


    public EntityStateFileType getType()
    {
        return (EntityStateFileType)_properties.get( FileProperty.TYPE );
    }



    /**
     */
    public void setDevelopmentClass(
                    final EntityStateString developmentClass
                    )
    {
        _properties.put( FileProperty.DEVELOPMENT_CLASS, developmentClass );
    }


    public EntityStateString getDevelopmentClass()
    {
        return (EntityStateString)_properties.get( FileProperty.DEVELOPMENT_CLASS );
    }



    /**
     */
    public void setCompany(
                    final EntityStateString company
                    )
    {
        _properties.put( FileProperty.COMPANY, company );
    }


    public EntityStateString getCompany()
    {
        return (EntityStateString)_properties.get( FileProperty.COMPANY );
    }



    /**
     */
    public void setInternalName(
                    final EntityStateString internalName
                    )
    {
        _properties.put( FileProperty.INTERNAL_NAME, internalName );
    }


    public EntityStateString getInternalName()
    {
        return (EntityStateString)_properties.get( FileProperty.INTERNAL_NAME );
    }



    /**
     */
    public void setLanguage(
                    final EntityStateString language
                    )
    {
        _properties.put( FileProperty.LANGUAGE, language );
    }


    public EntityStateString getLanguage()
    {
        return (EntityStateString)_properties.get( FileProperty.LANGUAGE );
    }



    /**
     */
    public void setOriginalFilename(
                    final EntityStateString filename
                    )
    {
        _properties.put( FileProperty.ORIGINAL_FILENAME, filename );
    }


    public EntityStateString getOriginalFilename()
    {
        return (EntityStateString)_properties.get( FileProperty.ORIGINAL_FILENAME );
    }



    /**
     */
    public void setProductName(
                    final EntityStateString name
                    )
    {
        _properties.put( FileProperty.PRODUCT_NAME, name );
    }


    public EntityStateString getProductName()
    {
        return (EntityStateString)_properties.get( FileProperty.PRODUCT_NAME );
    }



    /**
     */
    public void setProductVersion(
                    final EntityStateVersion version
                    )
    {
        _properties.put( FileProperty.PRODUCT_VERSION, version );
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
        return (EntityStateVersion)_properties.get( FileProperty.PRODUCT_VERSION );
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.WINDOWS_FILE;
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
