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

import java.util.EnumMap;
import java.util.Map;
import jp.go.aist.six.oval.model.v5.PlatformEntityType;
import jp.go.aist.six.oval.model.v5.sc.EntityAttributeGroup;
import jp.go.aist.six.oval.model.v5.sc.EntityItemIntType;
import jp.go.aist.six.oval.model.v5.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.v5.sc.EntityItemVersionType;
import jp.go.aist.six.oval.model.v5.sc.ItemType;
import jp.go.aist.six.oval.model.v5.sc.StatusEnumeration;



/**
 * The file item describes Windows file metadata.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class FileItem
    extends ItemType
{

    private final Map<FileProperty, EntityAttributeGroup>  _properties =
        new EnumMap<FileProperty, EntityAttributeGroup>( FileProperty.class );



    /**
     * Constructor.
     */
    public FileItem()
    {
    }


    public FileItem(
                    final int id
                    )
    {
        super( id );
    }


    public FileItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        super( id, status );
    }


//    public FileItem(
//                    final int id,
//                    final Status status,
//                    final String path,
//                    final String filename,
//                    final String owner,
//                    final String company,
//                    final String productName,
//                    final String productVersion
//                    )
//    {
//        this( id, status );
//        setPath( path );
//        setFilename( filename );
//        setOwner( owner );
//        setCompany( company );
//        setProductName( productName );
//        setProductVersion( productVersion );
//    }


    public FileItem(
                    final int id,
                    final StatusEnumeration status,
                    final String filepath,
                    final String path,
                    final String filename,
                    final String owner,
                    final long size,
                    final long atime,
                    final long ctime,
                    final long mtime,
                    final String checksum,
                    final String version,
                    final FileTypeEnumeration type,
                    final String devclass,
                    final String company,
                    final String internalname,
                    final String language,
                    final String originalFilename,
                    final String productName,
                    final String productVersion
                    )
    {
        this( id, status );
        setFilepath( new EntityItemStringType( filepath ) );
        setPath( new EntityItemStringType( path ) );
        setFilename( new EntityItemStringType( filename ) );
        setOwner( new EntityItemStringType( owner ) );
        setSize( new EntityItemIntType( size ) );
        setATime( new EntityItemIntType( atime ) );
        setCTime( new EntityItemIntType( ctime ) );
        setMTime( new EntityItemIntType( mtime ) );
        setMsChecksum( new EntityItemStringType( checksum ) );
        setVersion( new EntityItemVersionType( version ) );
        setType( new EntityItemFileTypeType( type ) );
        setDevelopmentClass( new EntityItemStringType( devclass ) );
        setCompany( new EntityItemStringType( company ) );
        setInternalName( new EntityItemStringType( internalname ) );
        setLanguage( new EntityItemStringType( language ) );
        setOriginalFilename( new EntityItemStringType( originalFilename ) );
        setProductName( new EntityItemStringType( productName ) );
        setProductVersion( new EntityItemVersionType( productVersion ) );
    }


    public FileItem(
                    final int id,
                    final StatusEnumeration status,
                    final EntityItemStringType filepath,
                    final EntityItemStringType path,
                    final EntityItemStringType filename,
                    final EntityItemStringType owner,
                    final EntityItemIntType size,
                    final EntityItemIntType atime,
                    final EntityItemIntType ctime,
                    final EntityItemIntType mtime,
                    final EntityItemStringType checksum,
                    final EntityItemVersionType version,
                    final EntityItemFileTypeType type,
                    final EntityItemStringType devclass,
                    final EntityItemStringType company,
                    final EntityItemStringType internalname,
                    final EntityItemStringType language,
                    final EntityItemStringType originalFilename,
                    final EntityItemStringType productName,
                    final EntityItemVersionType productVersion
                    )
    {
        this( id, status );
        setFilepath( filepath );
        setPath( path );
        setFilename( filename );
        setOwner( owner );
        setSize( size );
        setATime( atime );
        setCTime( ctime );
        setMTime( mtime );
        setMsChecksum( checksum );
        setVersion( version );
        setType( type );
        setDevelopmentClass( devclass );
        setCompany( company );
        setInternalName( internalname );
        setLanguage( language );
        setOriginalFilename( originalFilename );
        setProductName( productName );
        setProductVersion( productVersion );
    }



    /**
     */
    public EntityItemStringType getFilepath()
    {
        return (EntityItemStringType)_properties.get( FileProperty.FILEPATH );
    }


    public void setFilepath(
                    final EntityItemStringType filepath
                    )
    {
        _properties.put( FileProperty.FILEPATH, filepath );
    }


    public FileItem filepath(
                    final String filepath
                    )
    {
        setFilepath( new EntityItemStringType( filepath ) );
        return this;
    }



    /**
     */
    public EntityItemStringType getPath()
    {
        return (EntityItemStringType)_properties.get( FileProperty.PATH );
    }


    public void setPath(
                    final EntityItemStringType path
                    )
    {
        _properties.put( FileProperty.PATH, path );
    }


    public FileItem path(
                    final String path
                    )
    {
        setPath( new EntityItemStringType( path ) );
        return this;
    }



    /**
     */
    public EntityItemStringType getFilename()
    {
        return (EntityItemStringType)_properties.get( FileProperty.FILENAME );
    }


    public void setFilename(
                    final EntityItemStringType filename
                    )
    {
        _properties.put( FileProperty.FILENAME, filename );
    }


    public FileItem filename(
                    final String filename
                    )
    {
        setFilename( new EntityItemStringType( filename ) );
        return this;
    }



    /**
     */
    public EntityItemStringType getOwner()
    {
        return (EntityItemStringType)_properties.get( FileProperty.OWNER );
    }


    public void setOwner(
                    final EntityItemStringType owner
                    )
    {
        _properties.put( FileProperty.OWNER, owner );
    }


    public FileItem owner(
                    final String owner
                    )
    {
        setOwner( new EntityItemStringType( owner ) );
        return this;
    }



    /**
     */
    public EntityItemIntType getSize()
    {
        return (EntityItemIntType)_properties.get( FileProperty.SIZE );
    }


    public void setSize(
                    final EntityItemIntType size
                    )
    {
        _properties.put( FileProperty.SIZE, size );
    }


    public FileItem size(
                    final String size
                    )
    {
        setSize( new EntityItemIntType( size ) );
        return this;
    }



    public EntityItemIntType getATime()
    {
        return (EntityItemIntType)_properties.get( FileProperty.A_TIME );
    }


    public void setATime(
                    final EntityItemIntType atime
                    )
    {
        _properties.put( FileProperty.A_TIME, atime );
    }


    public FileItem aTime(
                    final String atime
                    )
    {
        setATime( new EntityItemIntType( atime ) );
        return this;
    }



    public EntityItemIntType getCTime()
    {
        return (EntityItemIntType)_properties.get( FileProperty.C_TIME );
    }


    public void setCTime(
                    final EntityItemIntType cTime
                    )
    {
        _properties.put( FileProperty.C_TIME, cTime );
    }


    public FileItem cTime(
                    final String ctime
                    )
    {
        setCTime( new EntityItemIntType( ctime ) );
        return this;
    }



    public EntityItemIntType getMTime()
    {
        return (EntityItemIntType)_properties.get( FileProperty.M_TIME );
    }


    public void setMTime(
                    final EntityItemIntType mTime
                    )
    {
        _properties.put( FileProperty.M_TIME, mTime );
    }


    public FileItem mTime(
                    final String mtime
                    )
    {
        setMTime( new EntityItemIntType( mtime ) );
        return this;
    }



    public EntityItemStringType getMsChecksum()
    {
        return (EntityItemStringType)_properties.get( FileProperty.MS_CHECKSUM );
    }


    public void setMsChecksum(
                    final EntityItemStringType checksum
                    )
    {
        _properties.put( FileProperty.MS_CHECKSUM, checksum );
    }


    public FileItem msChecksum(
                    final String msChecksum
                    )
    {
        setMsChecksum( new EntityItemStringType( msChecksum ) );
        return this;
    }



    public EntityItemVersionType getVersion()
    {
        return (EntityItemVersionType)_properties.get( FileProperty.VERSION );
    }



    public void setVersion(
                    final EntityItemVersionType version
                    )
    {
        _properties.put( FileProperty.VERSION, version );
    }


    public FileItem version(
                    final String version
                    )
    {
        setVersion( new EntityItemVersionType( version ) );
        return this;
    }



    public EntityItemFileTypeType getType()
    {
        return (EntityItemFileTypeType)_properties.get( FileProperty.TYPE );
    }


    public void setType(
                    final EntityItemFileTypeType type
                    )
    {
        _properties.put( FileProperty.TYPE, type );
    }


    public FileItem type(
                    final FileTypeEnumeration type
                    )
    {
        setType( new EntityItemFileTypeType( type ) );
        return this;
    }



    public EntityItemStringType getDevelopmentClass()
    {
        return (EntityItemStringType)_properties.get( FileProperty.DEVELOPMENT_CLASS );
    }


    public void setDevelopmentClass(
                    final EntityItemStringType developmentClass
                    )
    {
        _properties.put( FileProperty.DEVELOPMENT_CLASS, developmentClass );
    }


    public FileItem developmentClass(
                    final String developmentClass
                    )
    {
        setDevelopmentClass( new EntityItemStringType( developmentClass ) );
        return this;
    }



    public EntityItemStringType getCompany()
    {
        return (EntityItemStringType)_properties.get( FileProperty.COMPANY );
    }


    public void setCompany(
                    final EntityItemStringType company
                    )
    {
        _properties.put( FileProperty.COMPANY, company );
    }


    public FileItem company(
                    final String company
                    )
    {
        setCompany( new EntityItemStringType( company ) );
        return this;
    }



    public EntityItemStringType getInternalName()
    {
        return (EntityItemStringType)_properties.get( FileProperty.INTERNAL_NAME );
    }


    public void setInternalName(
                    final EntityItemStringType internalName
                    )
    {
        _properties.put( FileProperty.INTERNAL_NAME, internalName );
    }


    public FileItem internalName(
                    final String internalName
                    )
    {
        setInternalName( new EntityItemStringType( internalName ) );
        return this;
    }



    public EntityItemStringType getLanguage()
    {
        return (EntityItemStringType)_properties.get( FileProperty.LANGUAGE );
    }


    public void setLanguage(
                    final EntityItemStringType language
                    )
    {
        _properties.put( FileProperty.LANGUAGE, language );
    }


    public FileItem language(
                    final String language
                    )
    {
        setLanguage( new EntityItemStringType( language ) );
        return this;
    }



    public EntityItemStringType getOriginalFilename()
    {
        return (EntityItemStringType)_properties.get( FileProperty.ORIGINAL_FILENAME );
    }


    public void setOriginalFilename(
                    final EntityItemStringType originalFilename
                    )
    {
        _properties.put( FileProperty.ORIGINAL_FILENAME, originalFilename );
    }


    public FileItem originalFilename(
                    final String originalFilename
                    )
    {
        setOriginalFilename( new EntityItemStringType( originalFilename ) );
        return this;
    }



    public EntityItemStringType getProductName()
    {
        return (EntityItemStringType)_properties.get( FileProperty.PRODUCT_NAME );
    }


    public void setProductName(
                    final EntityItemStringType productName
                    )
    {
        _properties.put( FileProperty.PRODUCT_NAME, productName );
    }


    public FileItem productName(
                    final String productName
                    )
    {
        setProductName( new EntityItemStringType( productName ) );
        return this;
    }



    public EntityItemVersionType getProductVersion()
    {
        return (EntityItemVersionType)_properties.get( FileProperty.PRODUCT_VERSION );
    }


    public void setProductVersion(
                    final EntityItemVersionType productVersion
                    )
    {
        _properties.put( FileProperty.PRODUCT_VERSION, productVersion );
    }


    public FileItem productVersion(
                    final String productVersion
                    )
    {
        setProductVersion( new EntityItemVersionType( productVersion ) );
        return this;
    }



    //**************************************************************
    //  Item
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
    public String toString()
    {
        return "file_item[" + super.toString()
                        + ", " + _properties
                        + "]";
    }

}
// FileItem
