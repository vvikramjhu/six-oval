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

import jp.go.aist.six.util.castor.AbstractPersistable;
import jp.go.aist.six.util.orm.Dependent;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id: OvalResultElement.java 739 2010-05-07 08:11:01Z akihito $
 */
public class TestedItem
    extends AbstractPersistable
    implements Dependent<TestResult>
{

    private int  _itemID;
    //{required}


    private Result  _result;
    //{required}



    /**
     * Constructor.
     */
    public TestedItem()
    {
    }


    /**
     * Constructor.
     */
    public TestedItem(
                    final int itemID,
                    final Result result
                    )
    {
        setItemID( itemID );
        setResult( result );
    }



    /**
     */
    public void setItemID(
                    final int id
                    )
    {
        _itemID = id;
    }


    public int getItemID()
    {
        return _itemID;
    }



    public void setResult(
                    final Result result
                    )
    {
        _result = result;
    }


    public Result getResult()
    {
        return _result;
    }



    //**************************************************************
    //  Dependent
    //**************************************************************

    private TestResult  _master;



    public void setMasterObject(
                    final TestResult master
                    )
    {
        _master = master;
    }



    public TestResult getMasterObject()
    {
        return _master;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  hash = 17;

        int  itemID = getItemID();
        hash = prime * hash + itemID;

        Result  result = getResult();
        hash = prime * hash + ((result == null) ? 0 : result.hashCode());

        return hash;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TestedItem)) {
            return false;
        }

        TestedItem  other = (TestedItem)obj;
        int  other_itemID = other.getItemID();
        int   this_itemID =  this.getItemID();
        if (this_itemID == other_itemID) {
            Result  other_reault = other.getResult();
            Result   this_result =  this.getResult();
            if (this_result == other_reault) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "TestedItem[item_id=" + getItemID()
                        + ", result=" + getResult()
                        + "]";
    }

}
// TestedItem
