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
import java.util.Iterator;
import jp.go.aist.six.oval.model.Oval5Object;
import jp.go.aist.six.oval.model.v5.common.MessageType;



/**
 * The TestedItem holds a reference to a system characteristic item
 * that matched the object specified in a test.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class TestedItemType
    implements Oval5Object
//    implements Dependent<TestType>
{

    private final Collection<MessageType>  message = new ArrayList<MessageType>();
    //{0..*}


    private int  item_id;
    //{required}


    private ResultEnumeration  result;
    //{required}



    /**
     * Constructor.
     */
    public TestedItemType()
    {
    }


    public TestedItemType(
                    final int item_id,
                    final ResultEnumeration result
                    )
    {
        setItemID( item_id );
        setResult( result );
    }



    /**
     */
    public void setMessage(
                    final Collection<? extends MessageType> message
                    )
    {
        if (this.message != message) {
            this.message.clear();
            if (message != null  &&  message.size() > 0) {
                this.message.addAll( message );
            }
        }
    }


    public Collection<MessageType> getMessage()
    {
        return this.message;
    }


    public Iterator<MessageType> iterateMessage()
    {
        return this.message.iterator();
    }



    /**
     */
    public void setItemID(
                    final int item_id
                    )
    {
        this.item_id = item_id;
    }


    public int getItemID()
    {
        return this.item_id;
    }



    public void setResult(
                    final ResultEnumeration result
                    )
    {
        this.result = result;
    }


    public ResultEnumeration getResult()
    {
        return this.result;
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
        int  hash = 17;

        int  item_id = getItemID();
        hash = prime * hash + item_id;

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
        int  other_item_id = other.getItemID();
        int   this_item_id =  this.getItemID();
        if (this_item_id == other_item_id) {
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
