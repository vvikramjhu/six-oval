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

package jp.go.aist.six.oval.model.definition;

import jp.go.aist.six.oval.model.common.Check;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class SimpleTest
    extends Test
{

    private SystemObjectRef  _objectRef;
    //{oval-def:ObjectRefType, 1..1}

    private StateRef  _stateRef;
    //{oval-def:StateRefType, 0..*}
    // independent#family_test: {0..*}
    // independent#textfilecontent_test: {0..*}
    // linux#dpkginfo_test: {0..*}
    // linux#rpminfo_test: {0..*}
    // unix#uname_test: {0..*}
    // windows#file_test: {0..*}
    // windows#metabase_test: {0..*}
    // windows#registry_test: {0..*}
    // windows#wmi_test: {0..*}



    /**
     * Constructor.
     */
    public SimpleTest()
    {
    }


    /**
     * Constructor.
     */
    public SimpleTest(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public SimpleTest(
                    final String id,
                    final int version,
                    final Check check
                    )
    {
        super( id, version, check );
    }



//    public void setObjectID(
//                    final String ovalID
//                    )
//    {
//        _objectID = ovalID;
//    }
//
//
//    public String getObjectID()
//    {
//        return _objectID;
//    }
//
//
//
//    public void setStateID(
//                    final String ovalID
//                    )
//    {
//        _stateID = ovalID;
//    }
//
//
//    public String getStateID()
//    {
//        return _stateID;
//    }



    public void setObject(
                    final SystemObjectRef ref
                    )
    {
        _objectRef = ref;
    }


    public SystemObjectRef getObject()
    {
        return _objectRef;
    }



    public void setSingleState(
                    final StateRef ref
                    )
    {
        _stateRef = ref;
    }


    public StateRef getSingleState()
    {
        return _stateRef;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

//    @Override
//    public int hashCode()
//    {
//        final int  prime = 37;
//        int  result = super.hashCode();
//
//        SystemObjectRef  object = getObject();
//        result = prime * result + ((object == null) ? 0 : object.hashCode());
//
//        StateRef  state = getState();
//        result = prime * result + ((state == null) ? 0 : state.hashCode());
//
//        return result;
//    }
//
//
//
//    @Override
//    public boolean equals(
//                    final Object obj
//                    )
//    {
//        if (!(obj instanceof SimpleTest)) {
//            return false;
//        }
//
//        if (super.equals( obj )) {
//            SimpleTest  other = (SimpleTest)obj;
//            SystemObjectRef  other_object = other.getObject();
//            SystemObjectRef   this_object =  this.getObject();
//            if (this_object == other_object
//                            ||  (this_object != null  &&  this_object.equals( other_object ))) {
//                StateRef  other_state = other.getState();
//                StateRef   this_state =  this.getState();
//                if (this_state == other_state
//                                ||  (this_state != null  &&  this_state.equals( other_state ))) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
//
//
//
//    @Override
//    public String toString()
//    {
//        return super.toString()
//                        + ", object_ref=" + getObject()
//                        + ", state_ref=" + getState();
//    }

}
// SimpleTest
