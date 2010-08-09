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

import jp.go.aist.six.oval.model.EntityType;
import jp.go.aist.six.oval.model.definitions.EntityStateBase;
import jp.go.aist.six.oval.model.definitions.EntityStateInt;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.State;
import java.util.EnumMap;
import java.util.Map;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class FileState
    extends State
{

    private Map<FileProperty, EntityStateBase>  _properties =
        new EnumMap<FileProperty, EntityStateBase>( FileProperty.class );
    //EntityStateBaseType{0..1}

//    private EntityStateStringType  _filepath;
//    private EntityStateStringType  _path;
//    private EntityStateStringType  _filename;
//    private EntityStateStringType  _owner;
//    private EntityStateIntType  _size;
//    private EntityStateIntType  _aTime;
//    private EntityStateIntType  _cTime;
//    private EntityStateIntType  _mTime;
//    private EntityStateStringType  _msChecksum;

//    private EntityStateStringType  _version;
//    //{0..1}

//    private EntityStateFileType  _type;
//    private EntityStateStringType  _developmentClass;
//    private EntityStateStringType  _company;
//    private EntityStateStringType  _internalName;
//    private EntityStateStringType  _language;
//    private EntityStateStringType  _originalFilename;
//    private EntityStateStringType  _productName;
//    private EntityStateStringType  _productVersion;




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
     */
    protected Map<FileProperty, EntityStateBase> _getProperties()
    {
        return _properties;
    }



    /**
     */
    public void setFilepath(
                    final EntityStateString filepath
                    )
    {
        _properties.put( FileProperty.FILEPATH, filepath );
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
                    final EntityStateString version
                    )
    {
        _properties.put( FileProperty.VERSION, version );
    }


    public EntityStateString getVersion()
    {
        return (EntityStateString)_properties.get( FileProperty.VERSION );
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


    public EntityStateString getInteralName()
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


    public EntityStateString getOrigianlFilename()
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
                    final EntityStateString version
                    )
    {
        _properties.put( FileProperty.PRODUCT_VERSION, version );
    }


    public EntityStateString getProductVersion()
    {
        return (EntityStateString)_properties.get( FileProperty.PRODUCT_VERSION );
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public EntityType getObjectType()
    {
        return EntityType.WINDOWS_FILE;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  hash = super.hashCode();

        hash = prime * hash + _getProperties().hashCode();

        return hash;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof FileState)) {
            return false;
        }

        if (super.equals( obj )) {
            FileState  other = (FileState)obj;
            Map<FileProperty, EntityStateBase>  other_props = other._getProperties();
            Map<FileProperty, EntityStateBase>   this_props =  this._getProperties();
            if (this_props == other_props
                            ||  (this_props != null  &&  this_props.equals( other_props ))) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "FileState[" + super.toString()
                        + ", " + _getProperties()
                        + "]";
    }

}
// FileState
