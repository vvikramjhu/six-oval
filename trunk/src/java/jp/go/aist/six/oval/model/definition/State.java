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

import jp.go.aist.six.oval.core.model.ComponentType;
import jp.go.aist.six.oval.model.CommentedOvalEntity;
import jp.go.aist.six.oval.model.common.Operator;



/**
 * The abstract base class that is meant to be extended by the concrete states.
 * An OVAL State is a collection of one or more characteristics
 * pertaining to a specific object type.
 * The OVAL State is used by an OVAL Test to determine
 * if a set of items identified on a system meet
 * certain characteristics.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class State
    extends CommentedOvalEntity //, Noted
{

    public static final Operator  DEFAULT_OPERATOR = Operator.AND;

    private Operator  _operator;
    //{optional, default="AND"}
    // We found NO state with specific operator.



    /**
     * Constructor.
     */
    public State()
    {
    }


    /**
     * Constructor.
     */
    public State(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }



    public void setOperator(
                  final Operator operator
                  )
    {
      _operator = operator;
    }


    public Operator getOperator()
    {
        return (_operator == null ? DEFAULT_OPERATOR : _operator);
    }



    public void setStateType(
                    final ComponentType type
                    )
    {
    }


    public abstract ComponentType getStateType();



    //**************************************************************
    //  Noted
    //**************************************************************

    // We found NO state with specific notes.
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
        if (!(obj instanceof State)) {
            return false;
        }

        return super.equals( obj );
    }

}
// State
