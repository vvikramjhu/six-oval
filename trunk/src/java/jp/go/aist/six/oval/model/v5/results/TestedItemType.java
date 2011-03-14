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

import jp.go.aist.six.oval.model.AbstractOvalObject;
import jp.go.aist.six.util.persist.Dependent;



/**
 * The TestedItem holds a reference to a system characteristic item
 * that matched the object specified in a test.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class TestedItemType
    extends AbstractOvalObject
    implements Dependent<TestType>
{

    private int  _itemID;
    //{required}


    private ResultEnumeration  _result;
    //{required}



    /**
     * Constructor.
     */
    public TestedItemType()
    {
    }


    public TestedItemType(
                    final int itemID,
                    final ResultEnumeration result
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
                    final ResultEnumeration result
                    )
    {
        _result = result;
    }


    public ResultEnumeration getResult()
    {
        return _result;
    }



    //**************************************************************
    //  Dependent
    //**************************************************************

    private TestType  _master;



    @Override
    public void setMasterObject(
                    final TestType master
                    )
    {
        _master = master;
    }



    @Override
    public TestType getMasterObject()
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

        ResultEnumeration  result = getResult();
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

        if (!(obj instanceof TestedItemType)) {
            return false;
        }

        TestedItemType  other = (TestedItemType)obj;
        int  other_itemID = other.getItemID();
        int   this_itemID =  this.getItemID();
        if (this_itemID == other_itemID) {
            ResultEnumeration  other_reault = other.getResult();
            ResultEnumeration   this_result =  this.getResult();
            if (this_result == other_reault) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "tested_item[item_id=" + getItemID()
                        + ", result=" + getResult()
                        + "]";
    }

}
// TestedItemType
