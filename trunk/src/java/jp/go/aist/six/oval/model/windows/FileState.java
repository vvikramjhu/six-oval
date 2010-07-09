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
import jp.go.aist.six.oval.model.definition.EntityStateBase;
import jp.go.aist.six.oval.model.definition.EntityStateString;
import jp.go.aist.six.oval.model.definition.State;
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

    private Map<FileProperty,EntityStateBase>  _properties =
        new EnumMap<FileProperty,EntityStateBase>( FileProperty.class );
    //EntityStateBaseType{0..1}

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
     *
     */
    protected Map<FileProperty,EntityStateBase> _getProperties()
    {
        return _properties;
    }



    /**
     */
    public void setVersion(
                    final EntityStateString version
                    )
    {
        _properties.put( FileProperty.VERSION, version );
//        _version = version;
    }


    /**
     */
    public EntityStateString getVersion()
    {
        return (EntityStateString)_properties.get( FileProperty.VERSION );
//        return _version;
    }



    //**************************************************************
    //  State
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
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        result = prime * result + _getProperties().hashCode();
//        EntityStateStringType  version = getVersion();
//        result = prime * result + ((version == null) ? 0 : version.hashCode());

        return result;
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
            Map<FileProperty,EntityStateBase>  other_props = other._getProperties();
            Map<FileProperty,EntityStateBase>   this_props =  this._getProperties();
            if (this_props == other_props
                            ||  (this_props != null  &&  this_props.equals( other_props ))) {
                return true;
            }
//            EntityStateStringType  other_version = other.getVersion();
//            EntityStateStringType   this_version =  this.getVersion();
//            if (EntityTypeHelper.equals( this_version, other_version )) {
//                return true;
//            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "FileState[" + super.toString()
                        + ", version=" + getVersion()
                        + "]";
    }

}
// FileState
