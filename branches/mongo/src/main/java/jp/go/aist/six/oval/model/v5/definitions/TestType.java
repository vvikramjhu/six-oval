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

package jp.go.aist.six.oval.model.v5.definitions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.v5.CommentedOvalEntity;
import jp.go.aist.six.oval.model.v5.PlatformEntityType;
import jp.go.aist.six.oval.model.v5.common.CheckEnumeration;
import jp.go.aist.six.oval.model.v5.common.ExistenceEnumeration;
import jp.go.aist.six.oval.model.v5.common.OperatorEnumeration;



/**
 * The Test is used to compare an object(s) against a defined state.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class TestType
    extends CommentedOvalEntity
{

    private NotesType  _notes;
    //{0..1}


    public static final ExistenceEnumeration  DEFAULT_CHECK_EXISTENCE = ExistenceEnumeration.AT_LEAST_ONE_EXISTS;
    private ExistenceEnumeration  _checkExistence;
    //{optional, default="at_least_one_exists"}


    private CheckEnumeration  _check;
    //{required}


    public static final OperatorEnumeration  DEFAULT_STATE_OPERATOR = OperatorEnumeration.AND;
    private OperatorEnumeration  _stateOperator;
    //{optional, default="AND"}


    private SystemObjectRefType  _objectRef;
    //{1..1}
    //{0/UnknownTest}


    private final Collection<StateRefType>  _stateRef = new ArrayList<StateRefType>();
    // {0..*}



    /**
     * Constructor.
     */
    public TestType()
    {
    }


    public TestType(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    public TestType(
                    final String id,
                    final int version,
                    final String comment,
                    final CheckEnumeration check
                    )
    {
        super( id, version, comment );
        setCheck( check );
    }



    /**
     */
    public void setNotes(
                    final NotesType notes
                    )
    {
        _notes = notes;
    }


    public NotesType getNotes()
    {
        return _notes;
    }



    /**
     */
    public TestType checkExistence(
                    final ExistenceEnumeration existence
                    )
    {
        setCheckExistence( existence );
        return this;
    }


    public void setCheckExistence(
                    final ExistenceEnumeration existence
                    )
    {
        _checkExistence = existence;
    }


    public ExistenceEnumeration getCheckExistence()
    {
        return _checkExistence;
    }



    /**
     */
    public TestType check(
                    final CheckEnumeration check
                    )
    {
        setCheck( check );
        return this;
    }


    public void setCheck(
                    final CheckEnumeration check
                    )
    {
        _check = check;
    }


    public CheckEnumeration getCheck()
    {
        return _check;
    }



    /**
     */
    public TestType stateOperator(
                    final OperatorEnumeration stateOperator
                    )
    {
        setStateOperator( stateOperator );
        return this;
    }


    public void setStateOperator(
                    final OperatorEnumeration stateOperator
                    )
    {
        _stateOperator = stateOperator;
    }


    /**
     */
    public OperatorEnumeration getStateOperator()
    {
        return _stateOperator;
    }



    public TestType object(
                    final SystemObjectRefType objectRef
                    )
    {
        setObject( objectRef );
        return this;
    }


    public TestType object(
                    final String objectRef
                    )
    {
        return object( new SystemObjectRefType( objectRef ) );
    }


    public void setObject(
                    final SystemObjectRefType objectRef
                    )
    {
        _objectRef = objectRef;
    }


    public SystemObjectRefType getObject()
    {
        return _objectRef;
    }



    public TestType state(
                    final StateRefType stateRef
                    )
    {
        _stateRef.add( stateRef );
        return this;
    }


    public TestType state(
                    final String stateRef
                    )
    {
        return state( new StateRefType( stateRef ) );
    }


    public void setState(
                    final Collection<? extends StateRefType> stateRefs
                    )
    {
        if (stateRefs != _stateRef) {
            _stateRef.clear();
            if (stateRefs != null  &&  stateRefs.size() > 0) {
                _stateRef.addAll( stateRefs );
            }
        }
    }


    public Collection<StateRefType> getState()
    {
        return _stateRef;
    }


    public Iterator<StateRefType> iterateState()
    {
        return _stateRef.iterator();
    }


    public void clearState()
    {
        _stateRef.clear();
    }


    /**
     */
    public void setEntityType(
                    final PlatformEntityType type
                    )
    {
    }


//    public abstract EntityType getEntityType();
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.UNKNOWN;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return super.toString()
                        + ", check_existence=" + getCheckExistence()
                        + ", check=" + getCheck()
                        + ", state_operator=" + getStateOperator()
                        + ", object_ref=" + getObject()
                        + ", state_ref=" + getState();
//                      + ", notes=" + getNotes();
    }

}
// TestType
