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
import java.util.ArrayList;
import java.util.Collection;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class ComplexTest
    extends Test
{

    private SystemObjectRef  _objectRef;
    //{oval-def:ObjectRefType, 1..1}

    private Collection<StateRef>  _stateRef = new ArrayList<StateRef>();
    // windows#file_test: {0..*}



    /**
     * Constructor.
     */
    public ComplexTest()
    {
    }


    /**
     * Constructor.
     */
    public ComplexTest(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public ComplexTest(
                    final String id,
                    final int version,
                    final Check check
                    )
    {
        super( id, version, check );
    }



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



    public void setState(
                    final Collection<? extends StateRef> ref
                    )
    {
        _stateRef.clear();
        if (ref != null) {
            _stateRef.addAll( ref );
        }
    }


    public Collection<StateRef> getState()
    {
        return _stateRef;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        SystemObjectRef  object = getObject();
        result = prime * result + ((object == null) ? 0 : object.hashCode());

        Collection<StateRef>  state = getState();
        result = prime * result + ((state == null) ? 0 : state.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof ComplexTest)) {
            return false;
        }

        if (super.equals( obj )) {
            ComplexTest  other = (ComplexTest)obj;
            SystemObjectRef  other_object = other.getObject();
            SystemObjectRef   this_object =  this.getObject();
            if (this_object == other_object
                            ||  (this_object != null  &&  this_object.equals( other_object ))) {
                Collection<StateRef>  other_state = other.getState();
                Collection<StateRef>   this_state =  this.getState();
                if (this_state == other_state
                                ||  (this_state != null  &&  this_state.equals( other_state ))) {
                    return true;
                }
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return super.toString()
                        + ", object_ref=" + getObject()
                        + ", state_ref=" + getState();
    }

}
// ComplexTest
