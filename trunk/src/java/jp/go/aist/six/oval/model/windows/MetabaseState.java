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

import jp.go.aist.six.oval.core.model.ComponentType;
import jp.go.aist.six.oval.model.definition.EntityStateAnyType;
import jp.go.aist.six.oval.model.definition.EntityStateIntType;
import jp.go.aist.six.oval.model.definition.EntityStateStringType;
import jp.go.aist.six.oval.model.definition.State;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: MetabaseState.java 715 2010-05-06 07:05:49Z akihito $
 */
public class MetabaseState
    extends State
{

    private EntityStateStringType  _key;
    //{0..1}

    private EntityStateIntType  _id;
    //{0..1}

    private EntityStateStringType  _name;
    //{0..1}

    private EntityStateStringType  _userType;
    //{0..1}

    private EntityStateStringType  _dataType;
    //{0..1}

    private EntityStateAnyType  _data;
    //{0..1}



    /**
     * Constructor.
     */
    public MetabaseState()
    {
    }


    /**
     * Constructor.
     */
    public MetabaseState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }




    /**
     */
    public EntityStateStringType getKey()
    {
        return _key;
    }


    /**
     */
    public void setKey(
                    final EntityStateStringType key
                    )
    {
        _key = key;
    }



    /**
     */
    public EntityStateIntType getID()
    {
        return _id;
    }


    /**
     */
    public void setID(
                    final EntityStateIntType id
                    )
    {
        _id = id;
    }



    /**
     */
    public EntityStateStringType getName()
    {
        return _name;
    }


    /**
     */
    public void setName(
                    final EntityStateStringType name
                    )
    {
        _name = name;
    }



    /**
     */
    public EntityStateStringType getUserType()
    {
        return _userType;
    }


    /**
     */
    public void setUserType(
                    final EntityStateStringType userType
                    )
    {
        _userType = userType;
    }



    /**
     */
    public EntityStateStringType getDataType()
    {
        return _dataType;
    }


    /**
     */
    public void setDataType(
                    final EntityStateStringType dataType
                    )
    {
        _dataType = dataType;
    }



    /**
     */
    public EntityStateAnyType getData()
    {
        return _data;
    }


    /**
     */
    public void setData(
                    final EntityStateAnyType data
                    )
    {
        _data = data;
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public ComponentType getStateType()
    {
        return ComponentType.WINDOWS_METABASE;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        EntityStateStringType  key = getKey();
        result = prime * result + ((key == null) ? 0 : key.hashCode());

        EntityStateIntType  id = getID();
        result = prime * result + ((id == null) ? 0 : id.hashCode());

        EntityStateStringType  name = getName();
        result = prime * result + ((name == null) ? 0 : name.hashCode());

        EntityStateStringType  userType = getUserType();
        result = prime * result + ((userType == null) ? 0 : userType.hashCode());

        EntityStateStringType  dataType = getDataType();
        result = prime * result + ((dataType == null) ? 0 : dataType.hashCode());

        EntityStateAnyType  data = getData();
        result = prime * result + ((data == null) ? 0 : data.hashCode());

        return result;
    }



    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof MetabaseState)) {
            return false;
        }

        if (super.equals( obj )) {
            MetabaseState  other = (MetabaseState)obj;
            EntityStateStringType  other_key = other.getKey();
            EntityStateStringType   this_key =  this.getKey();
            if (this_key == other_key
                            ||  (this_key != null  &&  this_key.equals( other_key ))) {
                EntityStateIntType  other_id = other.getID();
                EntityStateIntType   this_id =  this.getID();
                if (this_id == other_id
                                ||  (this_id != null  &&  this_id.equals( other_id ))) {
                    EntityStateStringType  other_name = other.getName();
                    EntityStateStringType   this_name =  this.getName();
                    if (this_name == other_name
                                    ||  (this_name != null  &&  this_name.equals( other_name ))) {
                        EntityStateStringType  other_userType = other.getUserType();
                        EntityStateStringType   this_userType =  this.getUserType();
                        if (this_userType == other_userType
                                        ||  (this_userType != null  &&  this_userType.equals( other_userType ))) {
                            EntityStateStringType  other_dataType = other.getDataType();
                            EntityStateStringType   this_dataType =  this.getDataType();
                            if (this_dataType == other_dataType
                                            ||  (this_dataType != null  &&  this_dataType.equals( other_dataType ))) {
                                EntityStateAnyType  other_data = other.getData();
                                EntityStateAnyType   this_data =  this.getData();
                                if (this_data == other_data
                                                ||  (this_data != null  &&  this_data.equals( other_data ))) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }

        return false;
    }



    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "MetabaseState[" + super.toString() + "]";
    }

}
// MetabaseState
