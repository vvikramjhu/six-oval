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
import jp.go.aist.six.oval.model.common.CheckEnumeration;
import jp.go.aist.six.oval.model.common.ExistenceEnumeration;
import jp.go.aist.six.oval.model.common.OperatorEnumeration;



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
//    implements Dependent<SystemType>
{

    private final Collection<TestedItemType>  tested_item =
        new ArrayList<TestedItemType>();
    //{0..*}


    private final Collection<TestedVariableType>  tested_variable=
        new ArrayList<TestedVariableType>();
    //{0..*}


    public static final ExistenceEnumeration  DEFAULT_CHECK_EXISTENCE =
        ExistenceEnumeration.AT_LEAST_ONE_EXISTS;

    private ExistenceEnumeration  check_existence;
    //{optional, default="at_least_one_exists"}


    private CheckEnumeration  check;
    //{required}


    public static final OperatorEnumeration  DEFAULT_STATE_OPERATOR =
        OperatorEnumeration.AND;

    private OperatorEnumeration  state_operator;
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
                    final Collection<? extends TestedItemType> tested_item
                    )
    {
        if (tested_item != this.tested_item) {
            this.tested_item.clear();
            if (tested_item != null  &&  tested_item.size() > 0) {
                this.tested_item.addAll( tested_item );
            }
        }
    }


    public boolean addTestedItem(
                    final TestedItemType tested_item
                    )
    {
        return this.tested_item.add( tested_item );
    }


    public Collection<TestedItemType> getTestedItem()
    {
        return this.tested_item;
    }


    public TestType testedItem(
                    final TestedItemType item
                    )
    {
        addTestedItem( item );
        return this;
    }



    /**
     */
    public void setTestedVariable(
                    final Collection<? extends TestedVariableType> variableList
                    )
    {
        if (variableList != this.tested_variable) {
            this.tested_variable.clear();
            if (variableList != null  &&  variableList.size() > 0) {
                this.tested_variable.addAll( variableList );
            }
        }
    }


    public boolean addTestedVariable(
                    final TestedVariableType tested_variable
                    )
    {
        return this.tested_variable.add( tested_variable );
    }


    public Collection<TestedVariableType> getTestedVariable()
    {
        return this.tested_variable;
    }


    public TestType testedVariable(
                    final TestedVariableType variable
                    )
    {
        addTestedVariable( variable );
        return this;
    }



    /**
     */
    public void setTestID(
                    final String test_id
                    )
    {
        setOvalID( test_id );
    }


    public String getTestID()
    {
        return getOvalID();
    }



    /**
     */
    public void setCheckExistence(
                    final ExistenceEnumeration check_existence
                    )
    {
        this.check_existence = check_existence;
    }


    public ExistenceEnumeration getCheckExistence()
    {
        return this.check_existence;
    }


    public TestType checkExistence(
                    final ExistenceEnumeration check_existence
                    )
    {
        setCheckExistence( check_existence );
        return this;
    }



    /**
     */
    public void setCheck(
                    final CheckEnumeration check
                    )
    {
        this.check = check;
    }


    public CheckEnumeration getCheck()
    {
        return this.check;
    }


    public TestType check(
                    final CheckEnumeration check
                    )
    {
        setCheck( check );
        return this;
    }



    /**
     */
    public void setStateOperator(
                    final OperatorEnumeration state_operator
                    )
    {
        this.state_operator = state_operator;
    }


    public TestType stateOperator(
                    final OperatorEnumeration state_operator
                    )
    {
        setStateOperator( state_operator );
        return this;
    }


    public OperatorEnumeration getStateOperator()
    {
        return this.state_operator;
    }



//    //**************************************************************
//    //  Dependent
//    //**************************************************************
//
//    private SystemType _master;
//
//
//
//    @Override
//    public void setMasterObject(
//                    final SystemType master
//                    )
//    {
//        _master = master;
//    }
//
//
//
//    @Override
//    public SystemType getMasterObject()
//    {
//        return _master;
//    }



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
