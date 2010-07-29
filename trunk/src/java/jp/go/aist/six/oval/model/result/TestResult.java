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

package jp.go.aist.six.oval.model.result;

import jp.go.aist.six.oval.model.common.Check;
import jp.go.aist.six.oval.model.common.Existence;
import jp.go.aist.six.oval.model.common.Operator;
import jp.go.aist.six.util.orm.Dependent;
import java.util.ArrayList;
import java.util.Collection;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id: DefinitionResult.java 759 2010-05-10 06:56:29Z akihito $
 */
public class TestResult
    extends OvalResultElement
    implements Dependent<SystemResult>
{

//  private Collection<Message>  _messages = new ArrayList<Message>();


    private Collection<TestedItem>  _testedItem = new ArrayList<TestedItem>();
    //{0..*}


    private Collection<TestedVariable>  _testedVariable= new ArrayList<TestedVariable>();
    //{0..*}


    public static final int  DEFAULT_VARIABLE_INSTANCE = 1;
    private int  _variableInstance = DEFAULT_VARIABLE_INSTANCE;
    //{xsd:nonNegativeInteger, optional, default="1"}


    public static final Existence  DEFAULT_CHECK_EXISTENCE = Existence.AT_LEAST_ONE_EXISTS;
    private Existence  _checkExistence;
    //{optional, default="at_least_one_exists"}


    private Check  _check;
    //{required}


    public static final Operator  DEFAULT_STATE_OPERATOR = Operator.AND;
    private Operator  _stateOperator;
    //{optional, default="AND"}



    /**
     * Constructor.
     */
    public TestResult()
    {
    }


    /**
     * Constructor.
     */
    public TestResult(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public TestResult(
                    final String id,
                    final int version,
                    final Result result
                    )
    {
        super( id, version, result );
    }



    /**
     */
    public void setTestedItem(
                    final Collection<? extends TestedItem> items
                    )
    {
        _testedItem.clear();
        if (items != null  &&  items != _testedItem) {
            _testedItem.addAll( items );
        }
    }


    public Collection<TestedItem> getTestedItem()
    {
        return _testedItem;
    }


    /**
     */
    public void setTestedVariable(
                    final Collection<? extends TestedVariable> variables
                    )
    {
        _testedVariable.clear();
        if (variables != null  &&  variables != _testedVariable) {
            _testedVariable.addAll( variables );
        }
    }


    public Collection<TestedVariable> getTestedVariable()
    {
        return _testedVariable;
    }


    /**
     */
    public void setTestID(
                    final String id
                    )
    {
        setOvalID( id );
    }


    public String getTestID()
    {
        return getOvalID();
    }



    /**
     */
    public void setVariableInstance(
                    final int variableInstance
                    )
    {
        if (variableInstance < 0) {
            throw new IllegalArgumentException(
                            "negative variable instance: " + variableInstance );
        }

        _variableInstance = variableInstance;
    }


    public int getVariableInstance()
    {
        return _variableInstance;
    }



    /**
     */
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



    /**
     */
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
                    final Operator operator
                    )
    {
        _stateOperator = operator;
    }


    public Operator getStateOperator()
    {
        return (_stateOperator == null ? DEFAULT_STATE_OPERATOR : _stateOperator);
    }



    //**************************************************************
    //  Dependent
    //**************************************************************

    private SystemResult _master;



    public void setMasterObject(
                    final SystemResult master
                    )
    {
        _master = master;
    }



    public SystemResult getMasterObject()
    {
        return _master;
    }



    private String _masterPersistentID;



    public void setMasterPersistentID(
                    final String id
                    )
    {
        _masterPersistentID = id;
    }



    public String getMasterPersistentID()
    {
        if (_masterPersistentID == null) {
            SystemResult  master = getMasterObject();
            if (master != null) {
                setMasterPersistentID( master.getPersistentID() );
            }
        }

        return _masterPersistentID;
    }



    // **************************************************************
    // java.lang.Object
    // **************************************************************

    @Override
    public String toString()
    {
        return "TestResult[" + super.toString() + "]";
    }

}
// TestResult
