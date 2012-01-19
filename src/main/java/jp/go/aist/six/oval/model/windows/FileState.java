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

import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.definitions.EntityStateIntType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.EntityStateVersionType;
import jp.go.aist.six.oval.model.definitions.StateType;
import jp.go.aist.six.oval.model.windows.EntityStateWindowsViewType;



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

    //{0..1}
    private EntityStateStringType    filepath;
    private EntityStateStringType    path;
    private EntityStateStringType    filename;
    private EntityStateStringType    owner;
    private EntityStateIntType       size;
    private EntityStateIntType       a_time;
    private EntityStateIntType       c_time;
    private EntityStateIntType       m_time;
    private EntityStateStringType    ms_checksum;
    private EntityStateVersionType   version;
    private EntityStateFileTypeType  type;
    private EntityStateStringType    development_class;
    private EntityStateStringType    company;
    private EntityStateStringType    internal_name;
    private EntityStateStringType    language;
    private EntityStateStringType    original_filename;
    private EntityStateStringType    product_name;
    private EntityStateVersionType   product_version;
    
    private EntityStateWindowsViewType  windows_view;
    //{0..1}



    /**
     * Constructor.
     */
    public FileState()
    {
        this( null, 0 );
    }


    public FileState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public FileState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.file;
    }



    /**
     */
    public void setFilepath(
                    final EntityStateStringType filepath
                    )
    {
        this.filepath = filepath;
//        _properties.setProperty( FileProperty.FILEPATH, filepath );
    }


    public EntityStateStringType getFilepath()
    {
        return this.filepath;
//        return _properties.getProperty(
//                        FileProperty.FILEPATH, EntityStateStringType.class );
    }


    public FileState filepath(
                    final EntityStateStringType filepath
                    )
    {
        setFilepath( filepath );
        return this;
    }



    /**
     */
    public void setPath(
                    final EntityStateStringType path
                    )
    {
        this.path = path;
//        _properties.setProperty( FileProperty.PATH, path );
    }


    public EntityStateStringType getPath()
    {
        return this.path;
//        return _properties.getProperty(
//                        FileProperty.PATH, EntityStateStringType.class );
    }


    public FileState path(
                    final EntityStateStringType path
                    )
    {
        setPath( path );
        return this;
    }



    /**
     */
    public void setFilename(
                    final EntityStateStringType filename
                    )
    {
        this.filename = filename;
//        _properties.setProperty( FileProperty.FILENAME, filename );
    }


    public EntityStateStringType getFilename()
    {
        return this.filename;
//        return _properties.getProperty(
//                        FileProperty.FILENAME, EntityStateStringType.class );
    }


    public FileState filename(
                    final EntityStateStringType filename
                    )
    {
        setFilename( filename );
        return this;
    }



    /**
     */
    public void setOwner(
                    final EntityStateStringType owner
                    )
    {
        this.owner = owner;
//        _properties.setProperty( FileProperty.OWNER, owner );
    }


    public EntityStateStringType getOwner()
    {
        return this.owner;
//        return _properties.getProperty(
//                        FileProperty.OWNER, EntityStateStringType.class );
    }


    public FileState owner(
                    final EntityStateStringType owner
                    )
    {
        setOwner( owner );
        return this;
    }



    /**
     */
    public void setSize(
                    final EntityStateIntType size
                    )
    {
        this.size = size;
//        _properties.setProperty( FileProperty.SIZE, size );
    }


    public EntityStateIntType getSize()
    {
        return this.size;
//        return _properties.getProperty(
//                        FileProperty.SIZE, EntityStateIntType.class );
    }



    /**
     */
    public void setATime(
                    final EntityStateIntType a_time
                    )
    {
        this.a_time = a_time;
//        _properties.setProperty( FileProperty.A_TIME, a_time );
    }


    public EntityStateIntType getATime()
    {
        return this.a_time;
//        return _properties.getProperty(
//                        FileProperty.A_TIME, EntityStateIntType.class );
    }



    /**
     */
    public void setCTime(
                    final EntityStateIntType c_time
                    )
    {
        this.c_time = c_time;
//        _properties.setProperty( FileProperty.C_TIME, c_time );
    }


    public EntityStateIntType getCTime()
    {
        return this.c_time;
//        return _properties.getProperty(
//                        FileProperty.C_TIME, EntityStateIntType.class );
    }



    /**
     */
    public void setMTime(
                    final EntityStateIntType m_time
                    )
    {
        this.m_time = m_time;
//        _properties.setProperty( FileProperty.M_TIME, m_time );
    }


    public EntityStateIntType getMTime()
    {
        return this.m_time;
//        return _properties.getProperty(
//                        FileProperty.M_TIME, EntityStateIntType.class );
    }



    /**
     */
    public void setMsChecksum(
                    final EntityStateStringType ms_checksum
                    )
    {
        this.ms_checksum = ms_checksum;
//        _properties.setProperty( FileProperty.MS_CHECKSUM, ms_checksum );
    }


    public EntityStateStringType getMsChecksum()
    {
        return this.ms_checksum;
//        return _properties.getProperty(
//                        FileProperty.MS_CHECKSUM, EntityStateStringType.class );
    }



    /**
     */
    public void setVersion(
                    final EntityStateVersionType version
                    )
    {
        this.version = version;
//        _properties.setProperty( FileProperty.VERSION, version );
    }


    public EntityStateVersionType getVersion()
    {
        return this.version;
//        return _properties.getProperty(
//                        FileProperty.VERSION, EntityStateVersionType.class );
    }


    public FileState version(
                    final EntityStateVersionType version
                    )
    {
        setVersion( version );
        return this;
    }



    /**
     */
    public void setType(
                    final EntityStateFileTypeType type
                    )
    {
        this.type = type;
//        _properties.setProperty( FileProperty.TYPE, type );
    }


    public EntityStateFileTypeType getType()
    {
        return this.type;
//        return _properties.getProperty(
//                        FileProperty.TYPE, EntityStateFileTypeType.class );
    }



    /**
     */
    public void setDevelopmentClass(
                    final EntityStateStringType development_class
                    )
    {
        this.development_class = development_class;
//        _properties.setProperty( FileProperty.DEVELOPMENT_CLASS, development_class );
    }


    public EntityStateStringType getDevelopmentClass()
    {
        return this.development_class;
//        return _properties.getProperty(
//                        FileProperty.DEVELOPMENT_CLASS, EntityStateStringType.class );
    }



    /**
     */
    public void setCompany(
                    final EntityStateStringType company
                    )
    {
        this.company = company;
//        _properties.setProperty( FileProperty.COMPANY, company );
    }


    public EntityStateStringType getCompany()
    {
        return this.company;
//        return _properties.getProperty(
//                        FileProperty.COMPANY, EntityStateStringType.class );
    }



    /**
     */
    public void setInternalName(
                    final EntityStateStringType internal_name
                    )
    {
        this.internal_name = internal_name;
//        _properties.setProperty( FileProperty.INTERNAL_NAME, internal_name );
    }


    public EntityStateStringType getInternalName()
    {
        return this.internal_name;
//        return _properties.getProperty(
//                        FileProperty.INTERNAL_NAME, EntityStateStringType.class );
    }



    /**
     */
    public void setLanguage(
                    final EntityStateStringType language
                    )
    {
        this.language = language;
//        _properties.setProperty( FileProperty.LANGUAGE, language );
    }


    public EntityStateStringType getLanguage()
    {
        return this.language;
//        return _properties.getProperty(
//                        FileProperty.LANGUAGE, EntityStateStringType.class );
    }



    /**
     */
    public void setOriginalFilename(
                    final EntityStateStringType original_filename
                    )
    {
        this.original_filename = original_filename;
    }


    public EntityStateStringType getOriginalFilename()
    {
        return this.original_filename;
    }



    /**
     */
    public void setProductName(
                    final EntityStateStringType product_name
                    )
    {
        this.product_name = product_name;
//        _properties.setProperty( FileProperty.PRODUCT_NAME, product_name );
    }


    public EntityStateStringType getProductName()
    {
        return this.product_name;
//        return _properties.getProperty(
//                        FileProperty.PRODUCT_NAME, EntityStateStringType.class );
    }



    /**
     */
    public void setProductVersion(
                    final EntityStateVersionType product_version
                    )
    {
        this.product_version = product_version;
//        _properties.setProperty( FileProperty.PRODUCT_VERSION, product_version );
    }


    public EntityStateVersionType getProductVersion()
    {
        return this.product_version;
//        return _properties.getProperty(
//                        FileProperty.PRODUCT_VERSION, EntityStateVersionType.class );
    }


    public FileState productVersion(
                    final EntityStateVersionType product_version
                    )
    {
        setProductVersion( product_version );
        return this;
    }



    /**
     */
    public void setWindowsView(
                    final EntityStateWindowsViewType windows_view
                    )
    {
        this.windows_view = windows_view;
    }


    public EntityStateWindowsViewType getWindowsView()
    {
        return this.windows_view;
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
             + ", filepath="            + getFilepath()
             + ", path="                + getPath()
             + ", filename="            + getFilename()
             + ", owner="               + getOwner()
             + ", size="                + getSize()
             + ", a_time="              + getATime()
             + ", c_time="              + getCTime()
             + ", m_time="              + getMTime()
             + ", ms_checksum="         + getMsChecksum()
             + ", version="             + getVersion()
             + ", type="                + getType()
             + ", development_class="   + getDevelopmentClass()
             + ", company="             + getCompany()
             + ", internal_name="       + getInternalName()
             + ", language="            + getLanguage()
             + ", original_filename="   + getOriginalFilename()
             + ", product_name="        + getProductName()
             + ", product_version="     + getProductVersion()
             + ", windows_view="        + getWindowsView()
             + "]";
    }

}
// FileState
