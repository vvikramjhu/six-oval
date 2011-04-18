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

package jp.go.aist.six.oval.model.v5.results;

import java.util.ArrayList;
import java.util.Collection;
import jp.go.aist.six.oval.model.v5.common.CheckEnumeration;
import jp.go.aist.six.oval.model.v5.common.ExistenceEnumeration;
import jp.go.aist.six.oval.model.v5.common.OperatorEnumeration;
import jp.go.aist.six.util.persist.Dependent;



/**
 * The TestResult provides a reference to every item
 * that matched the object section of the original test
 * as well as providing an overall test result based on those items.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class TestType
    extends OvalResultElement
    implements Dependent<SystemType>
{

    private final Collection<TestedItemType>  _testedItem = new ArrayList<TestedItemType>();
    //{0..*}


    private final Collection<TestedVariableType>  _testedVariable= new ArrayList<TestedVariableType>();
    //{0..*}


    public static final ExistenceEnumeration  DEFAULT_CHECK_EXISTENCE = ExistenceEnumeration.AT_LEAST_ONE_EXISTS;
    private ExistenceEnumeration  _checkExistence;
    //{optional, default="at_least_one_exists"}


    private CheckEnumeration  _check;
    //{required}


    public static final OperatorEnumeration  DEFAULT_STATE_OPERATOR = OperatorEnumeration.AND;
    private OperatorEnumeration  _stateOperator;
    //{optional, default="AND"}



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
                    final ResultEnumeration result
                    )
    {
        super( id, version, result );
    }



    /**
     */
    public void setTestedItem(
                    final Collection<? extends TestedItemType> items
                    )
    {
        if (items != _testedItem) {
            _testedItem.clear();
            if (items != null  &&  items != _testedItem) {
                _testedItem.addAll( items );
            }
        }
    }


    public boolean addTestedItem(
                    final TestedItemType item
                    )
    {
        return _testedItem.add( item );
    }


    public TestType testedItem(
                    final TestedItemType item
                    )
    {
        addTestedItem( item );
        return this;
    }


    public Collection<TestedItemType> getTestedItem()
    {
        return _testedItem;
    }


    /**
     */
    public void setTestedVariable(
                    final Collection<? extends TestedVariableType> variables
                    )
    {
        if (variables != _testedVariable) {
            _testedVariable.clear();
            if (variables != null  &&  variables != _testedVariable) {
                _testedVariable.addAll( variables );
            }
        }
    }


    public boolean addTestedVariable(
                    final TestedVariableType variable
                    )
    {
        return _testedVariable.add( variable );
    }


    public TestType testedVariable(
                    final TestedVariableType variable
                    )
    {
        addTestedVariable( variable );
        return this;
    }


    public Collection<TestedVariableType> getTestedVariable()
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
    public void setCheckExistence(
                    final ExistenceEnumeration existence
                    )
    {
        _checkExistence = existence;
    }


    public TestType checkExistence(
                    final ExistenceEnumeration existence
                    )
    {
        setCheckExistence( existence );
        return this;
    }


    public ExistenceEnumeration getCheckExistence()
    {
        return _checkExistence;
    }



    /**
     */
    public void setCheck(
                    final CheckEnumeration check
                    )
    {
        _check = check;
    }


    public TestType check(
                    final CheckEnumeration check
                    )
    {
        setCheck( check );
        return this;
    }


    public CheckEnumeration getCheck()
    {
        return _check;
    }



    /**
     */
    public void setStateOperator(
                    final OperatorEnumeration operator
                    )
    {
        _stateOperator = operator;
    }


    public TestType stateOperator(
                    final OperatorEnumeration operator
                    )
    {
        setStateOperator( operator );
        return this;
    }


    public OperatorEnumeration getStateOperator()
    {
        return _stateOperator;
    }



    //**************************************************************
    //  Dependent
    //**************************************************************

    private SystemType _master;



    @Override
    public void setMasterObject(
                    final SystemType master
                    )
    {
        _master = master;
    }



    @Override
    public SystemType getMasterObject()
    {
        return _master;
    }



//    private String _masterPersistentID;
//
//
//
//    public void setMasterPersistentID(
//                    final String id
//                    )
//    {
//        _masterPersistentID = id;
//    }
//
//
//
//    public String getMasterPersistentID()
//    {
//        if (_masterPersistentID == null) {
//            SystemResult  master = getMasterObject();
//            if (master != null) {
//                setMasterPersistentID( master.getPersistentID() );
//            }
//        }
//
//        return _masterPersistentID;
//    }



    // **************************************************************
    // java.lang.Object
    // **************************************************************

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
        if (!(obj instanceof TestType)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "test[" + super.toString()
                        + ", check_existence=" + getCheckExistence()
                        + ", check=" + getCheck()
                        + ", tested_item=" + getTestedItem()
                        + ", tested_variable=" + getTestedVariable()
                        + "]";
    }

}
// TestType
