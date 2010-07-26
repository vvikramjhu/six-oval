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

import jp.go.aist.six.oval.model.CommentedOvalEntity;
import jp.go.aist.six.oval.model.ObjectType;
import jp.go.aist.six.oval.model.common.Check;
import jp.go.aist.six.oval.model.common.Existence;
import jp.go.aist.six.oval.model.common.Operator;
import java.util.ArrayList;
import java.util.Collection;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class Test
    extends CommentedOvalEntity //, Noted
{

    public static final Existence  DEFAULT_CHECK_EXISTENCE = Existence.AT_LEAST_ONE_EXISTS;
    private Existence  _checkExistence;
    //{optional, default="at_least_one_exists"}

    private Check  _check;
    //{required}

    public static final Operator  DEFAULT_STATE_OPERATOR = Operator.AND;
    private Operator  _stateOperator;
    //{optional, default="AND"}


    private Collection<StateRef>  _stateRef = new ArrayList<StateRef>();
    // windows#file_test: {0..*}

    public void setStateRef(
                    final Collection<? extends StateRef> ref
                    )
    {
        _stateRef.clear();
        if (ref != null) {
            _stateRef.addAll( ref );
        }
    }


    public Collection<StateRef> getStateRef()
    {
        return _stateRef;
    }





    /**
     * Constructor.
     */
    public Test()
    {
    }


    /**
     * Constructor.
     */
    public Test(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public Test(
                    final String id,
                    final int version,
                    final Check check
                    )
    {
        super( id, version );
        setCheck( check );
    }



    public void setCheckExistence(
                    final Existence existence
                    )
    {
        _checkExistence = existence;
    }


    public Existence getCheckExistence()
    {
        return (_checkExistence == null ? DEFAULT_CHECK_EXISTENCE : _checkExistence);
    }



    public void setCheck(
                    final Check check
                    )
    {
        _check = check;
    }


    public Check getCheck()
    {
        return _check;
    }



    /**
     */
    public void setStateOperator(
                    final Operator stateOperator
                    )
    {
        _stateOperator = stateOperator;
    }


    /**
     */
    public Operator getStateOperator()
    {
        return (_stateOperator == null ? DEFAULT_STATE_OPERATOR : _stateOperator);
    }



    public void setObjectType(
                    final ObjectType type
                    )
    {
    }


    public abstract ObjectType getObjectType();




    //**************************************************************
    //  Noted
    //**************************************************************

//    public void setNotes( final Notes notes )
//    {
//        _notes = notes;
//    }
//
//
//    public Notes getNotes()
//    {
//        return _notes;
//    }



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
        if (!(obj instanceof Test)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return super.toString()
                        + ", check_existence=" + getCheckExistence()
                        + ", check=" + getCheck()
                        + ", state_operator=" + getStateOperator();
//                        + ", notes=" + getNotes();
    }

}
// Test
