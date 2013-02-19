/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.go.aist.six.oval.model.definitions;

import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.ElementType;
import jp.go.aist.six.oval.model.OvalObject;



/**
 * A State reference to be used by OVAL States.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class StateRefType
    implements ElementRef, OvalObject
//    implements Dependent<TestType>
{

    private String  state_ref;
    //{required}



    /**
     * Constructor.
     */
    public StateRefType()
    {
    }


    /**
     * Constructor.
     */
    public StateRefType(
                    final String state_ref
                    )
    {
        setStateRef( state_ref );
    }



    /**
     */
    public void setStateRef(
                    final String state_ref
                    )
    {
        this.state_ref = state_ref;
    }


    public String getStateRef()
    {
        return state_ref;
    }



    //**************************************************************
    //  ElementRef
    //**************************************************************

    public String ovalGetRefId()
    {
        return getStateRef();
    }



    public ElementType ovalGetRefType()
    {
        return ElementType.STATE;
    }



//    //**************************************************************
//    //  Dependent
//    //**************************************************************
//
//    private TestType  _master;
//
//
//
//    @Override
//    public void setMasterObject(
//                    final TestType master
//                    )
//    {
//        _master = master;
//    }
//
//
//    @Override
//    public TestType getMasterObject()
//    {
//        return _master;
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        String  id = getStateRef();
        result = prime * result + ((id == null) ? 0 : id.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ElementRef)) {
            return false;
        }

        StateRefType  other = (StateRefType)obj;
        String  other_id = other.getStateRef();
        String   this_id =  this.getStateRef();
        if (this_id == other_id
                        ||  (this_id != null  &&  this_id.equals( other_id ))) {
            return true;
        }

        return false;
    }



    @Override
    public String toString()
    {
        return getStateRef();
    }

}
//
