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

import jp.go.aist.six.oval.model.ObjectType;
import jp.go.aist.six.oval.model.common.Datatype;
import jp.go.aist.six.oval.model.sc.EntityItemBase;
import jp.go.aist.six.oval.model.sc.EntityItemInt;
import jp.go.aist.six.oval.model.sc.EntityItemString;
import jp.go.aist.six.oval.model.sc.Item;
import jp.go.aist.six.oval.model.sc.Status;
import java.util.EnumMap;
import java.util.Map;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class FileItem
    extends Item
{

    private Map<FileProperty, EntityItemBase>  _properties =
        new EnumMap<FileProperty, EntityItemBase>( FileProperty.class );


//    private String  _filepath;
//    private String  _path;
//    private String  _filename;
//    private String  _owner;
//    private long  _size;
//    private long  _aTime;
//    private long  _cTime;
//    private long  _mTime;
//    private String  _msChecksum;
//    private String  _version;
//    private FileType  _type;
//    private String  _developmentClass;
//    private String  _company;
//    private String  _internalName;
//    private String  _language;
//    private String  _originalFilename;
//    private String  _productName;
//    private String  _productVersion;



    /**
     * Constructor.
     */
    public FileItem()
    {
    }


    /**
     * Constructor.
     */
    public FileItem(
                    final int id
                    )
    {
        super( id );
    }


    /**
     * Constructor.
     */
    public FileItem(
                    final int id,
                    final Status status
                    )
    {
        super( id, status );
    }


//    /**
//     * Constructor.
//     */
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


    /**
     * Constructor.
     */
    public FileItem(
                    final int id,
                    final Status status,
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
                    final FileType type,
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
        setFilepath( new EntityItemString( filepath ) );
        setPath( new EntityItemString( path ) );
        setFilename( new EntityItemString( filename ) );
        setOwner( new EntityItemString( owner ) );
        setSize( new EntityItemInt( size, Datatype.INT ) );
        setATime( new EntityItemInt( atime, Datatype.INT ) );
        setCTime( new EntityItemInt( ctime, Datatype.INT ) );
        setMTime( new EntityItemInt( mtime, Datatype.INT ) );
        setMsChecksum( new EntityItemString( checksum ) );
        setVersion( new EntityItemString( version, Datatype.VERSION ) );
        setType( new EntityItemFileType( type ) );
        setDevelopmentClass( new EntityItemString( devclass ) );
        setCompany( new EntityItemString( company ) );
        setInternalName( new EntityItemString( internalname ) );
        setLanguage( new EntityItemString( language ) );
        setOriginalFilename( new EntityItemString( originalFilename ) );
        setProductName( new EntityItemString( productName ) );
        setProductVersion( new EntityItemString( productVersion ) );
    }


    /**
     * Constructor.
     */
    public FileItem(
                    final int id,
                    final Status status,
                    final EntityItemString filepath,
                    final EntityItemString path,
                    final EntityItemString filename,
                    final EntityItemString owner,
                    final EntityItemInt size,
                    final EntityItemInt atime,
                    final EntityItemInt ctime,
                    final EntityItemInt mtime,
                    final EntityItemString checksum,
                    final EntityItemString version,
                    final EntityItemFileType type,
                    final EntityItemString devclass,
                    final EntityItemString company,
                    final EntityItemString internalname,
                    final EntityItemString language,
                    final EntityItemString originalFilename,
                    final EntityItemString productName,
                    final EntityItemString productVersion
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



    public EntityItemString getFilepath()
    {
        return (EntityItemString)_properties.get( FileProperty.FILEPATH );
    }


    public void setFilepath(
                    final EntityItemString filepath
                    )
    {
        _properties.put( FileProperty.FILEPATH, filepath );
    }



    public EntityItemString getPath()
    {
        return (EntityItemString)_properties.get( FileProperty.PATH );
    }


    public void setPath(
                    final EntityItemString path
                    )
    {
        _properties.put( FileProperty.PATH, path );
    }



    public EntityItemString getFilename()
    {
        return (EntityItemString)_properties.get( FileProperty.FILENAME );
    }


    public void setFilename(
                    final EntityItemString filename
                    )
    {
        _properties.put( FileProperty.FILENAME, filename );
    }



    public EntityItemString getOwner()
    {
        return (EntityItemString)_properties.get( FileProperty.OWNER );
    }


    public void setOwner(
                    final EntityItemString owner
                    )
    {
        _properties.put( FileProperty.OWNER, owner );
    }



    public EntityItemInt getSize()
    {
        return (EntityItemInt)_properties.get( FileProperty.SIZE );
    }


    public void setSize(
                    final EntityItemInt size
                    )
    {
        _properties.put( FileProperty.SIZE, size );
    }



    public EntityItemInt getATime()
    {
        return (EntityItemInt)_properties.get( FileProperty.A_TIME );
    }


    public void setATime(
                    final EntityItemInt aTime
                    )
    {
        _properties.put( FileProperty.A_TIME, aTime );
    }



    public EntityItemInt getCTime()
    {
        return (EntityItemInt)_properties.get( FileProperty.C_TIME );
    }


    public void setCTime(
                    final EntityItemInt cTime
                    )
    {
        _properties.put( FileProperty.C_TIME, cTime );
    }



    public EntityItemInt getMTime()
    {
        return (EntityItemInt)_properties.get( FileProperty.M_TIME );
    }


    public void setMTime(
                    final EntityItemInt mTime
                    )
    {
        _properties.put( FileProperty.M_TIME, mTime );
    }



    public EntityItemString getMsChecksum()
    {
        return (EntityItemString)_properties.get( FileProperty.MS_CHECKSUM );
    }


    public void setMsChecksum(
                    final EntityItemString msChecksum
                    )
    {
        _properties.put( FileProperty.MS_CHECKSUM, msChecksum );
    }



    public EntityItemString getVersion()
    {
        return (EntityItemString)_properties.get( FileProperty.VERSION );
    }



    public void setVersion(
                    final EntityItemString version
                    )
    {
        _properties.put( FileProperty.VERSION, version );
    }



    public EntityItemFileType getType()
    {
        return (EntityItemFileType)_properties.get( FileProperty.TYPE );
    }


    public void setType(
                    final EntityItemFileType type
                    )
    {
        _properties.put( FileProperty.TYPE, type );
    }



    public EntityItemString getDevelopmentClass()
    {
        return (EntityItemString)_properties.get( FileProperty.DEVELOPMENT_CLASS );
    }


    public void setDevelopmentClass(
                    final EntityItemString developmentClass
                    )
    {
        _properties.put( FileProperty.DEVELOPMENT_CLASS, developmentClass );
    }



    public EntityItemString getCompany()
    {
        return (EntityItemString)_properties.get( FileProperty.COMPANY );
    }


    public void setCompany(
                    final EntityItemString company
                    )
    {
        _properties.put( FileProperty.COMPANY, company );
    }



    public EntityItemString getInternalName()
    {
        return (EntityItemString)_properties.get( FileProperty.INTERNAL_NAME );
    }



    public void setInternalName(
                    final EntityItemString internalName
                    )
    {
        _properties.put( FileProperty.INTERNAL_NAME, internalName );
    }



    public EntityItemString getLanguage()
    {
        return (EntityItemString)_properties.get( FileProperty.LANGUAGE );
    }


    public void setLanguage(
                    final EntityItemString language
                    )
    {
        _properties.put( FileProperty.LANGUAGE, language );
    }



    public EntityItemString getOriginalFilename()
    {
        return (EntityItemString)_properties.get( FileProperty.ORIGINAL_FILENAME );
    }


    public void setOriginalFilename(
                    final EntityItemString originalFilename
                    )
    {
        _properties.put( FileProperty.ORIGINAL_FILENAME, originalFilename );
    }



    public EntityItemString getProductName()
    {
        return (EntityItemString)_properties.get( FileProperty.PRODUCT_NAME );
    }


    public void setProductName(
                    final EntityItemString productName
                    )
    {
        _properties.put( FileProperty.PRODUCT_NAME, productName );
    }



    public EntityItemString getProductVersion()
    {
        return (EntityItemString)_properties.get( FileProperty.PRODUCT_VERSION );
    }


    public void setProductVersion(
                    final EntityItemString productVersion
                    )
    {
        _properties.put( FileProperty.PRODUCT_VERSION, productVersion );
    }



    //**************************************************************
    //  Item
    //**************************************************************

    @Override
    public ObjectType getObjectType()
    {
        return ObjectType.WINDOWS_FILE;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "FileItem[" + super.toString()
                        + ", " + _properties
                        + "]";
    }

}
// FileItem
