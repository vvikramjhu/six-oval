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

import jp.go.aist.six.oval.core.model.system.ItemType;
import jp.go.aist.six.oval.model.system.Item;
import jp.go.aist.six.oval.model.system.Status;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class FileItem
    extends Item
{

    private String  _path;
    private String  _filename;
    private String  _owner;
    private long  _size;
    private long  _aTime;
    private long  _cTime;
    private long  _mTime;
    private String  _msChecksum;
    private String  _version;
    private FileType  _type;
    private String  _developmentClass;
    private String  _company;
    private String  _internalName;
    private String  _language;
    private String  _originalFilename;
    private String  _productName;
    private String  _productVersion;



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


    /**
     * Constructor.
     */
    public FileItem(
                    final int id,
                    final Status status,
                    final String path,
                    final String filename,
                    final String owner,
                    final String company,
                    final String productName,
                    final String productVersion
                    )
    {
        this( id, status );
        setPath( path );
        setFilename( filename );
        setOwner( owner );
        setCompany( company );
        setProductName( productName );
        setProductVersion( productVersion );
    }


    /**
     * Constructor.
     */
    public FileItem(
                    final int id,
                    final Status status,
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
        this( id, status, path, filename, owner, company, productName, productVersion );
        setSize( size );
        setATime( atime );
        setCTime( ctime );
        setMTime( mtime );
        setMsChecksum( checksum );
        setVersion( version );
        setType( type );
        setDevelopmentClass( devclass );
        setInternalName( internalname );
        setLanguage( language );
        setOriginalFilename( originalFilename );
    }



    public String getPath()
    {
        return _path;
    }


    public void setPath(
                    final String path
                    )
    {
        _path = path;
    }



    public String getFilename()
    {
        return _filename;
    }



    public void setFilename(
                    final String filename
                    )
    {
        _filename = filename;
    }



    public String getOwner()
    {
        return _owner;
    }



    public void setOwner(
                    final String owner
                    )
    {
        _owner = owner;
    }



    public long getSize()
    {
        return _size;
    }



    public void setSize(
                    final long size
                    )
    {
        _size = size;
    }



    public long getATime()
    {
        return _aTime;
    }



    public void setATime(
                    final long aTime
                    )
    {
        _aTime = aTime;
    }



    public long getCTime()
    {
        return _cTime;
    }



    public void setCTime(
                    final long cTime
                    )
    {
        _cTime = cTime;
    }



    public long getMTime()
    {
        return _mTime;
    }



    public void setMTime(
                    final long mTime
                    )
    {
        _mTime = mTime;
    }



    public String getMsChecksum()
    {
        return _msChecksum;
    }



    public void setMsChecksum(
                    final String msChecksum
                    )
    {
        _msChecksum = msChecksum;
    }



    public String getVersion()
    {
        return _version;
    }



    public void setVersion(
                    final String version
                    )
    {
        _version = version;
    }



    public FileType getType()
    {
        return _type;
    }



    public void setType(
                    final FileType type
                    )
    {
        _type = type;
    }



    public String getDevelopmentClass()
    {
        return _developmentClass;
    }



    public void setDevelopmentClass(
                    final String developmentClass
                    )
    {
        _developmentClass = developmentClass;
    }



    public String getCompany()
    {
        return _company;
    }



    public void setCompany(
                    final String company
                    )
    {
        _company = company;
    }



    public String getInternalName()
    {
        return _internalName;
    }



    public void setInternalName(
                    final String internalName
                    )
    {
        _internalName = internalName;
    }



    public String getLanguage()
    {
        return _language;
    }



    public void setLanguage(
                    final String language
                    )
    {
        _language = language;
    }



    public String getOriginalFilename()
    {
        return _originalFilename;
    }



    public void setOriginalFilename(
                    final String originalFilename
                    )
    {
        _originalFilename = originalFilename;
    }



    public String getProductName()
    {
        return _productName;
    }



    public void setProductName(
                    final String productName
                    )
    {
        _productName = productName;
    }



    public String getProductVersion()
    {
        return _productVersion;
    }



    public void setProductVersion(
                    final String productVersion
                    )
    {
        _productVersion = productVersion;
    }



    //**************************************************************
    //  Item
    //**************************************************************

    @Override
    public ItemType getItemType()
    {
        return ItemType.WINDOWS_FILE;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "FileItem [" + super.toString()
                        + ", path=" + getPath()
                        + ", filename=" + getFilename()
                        + ", owner=" + getOwner()
                        + ", company=" + getCompany()
                        + ", productName=" + getProductName()
                        + ", productVersion=" + getProductVersion()
                        + "]";
    }

}
// FileItem
