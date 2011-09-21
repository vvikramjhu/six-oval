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

package jp.go.aist.six.oval.model.sc;

import jp.go.aist.six.oval.model.v5.Oval5Object;




/**
 * The ItemReference specifies an item in the system characteristics.
 * This reference is used to link global OVAL Objects to specific items.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class ReferenceType
    implements Oval5Object
//    implements Dependent<SystemObjectType>
{

    private int  item_ref;
    //{required, oval:ItemIDPattern}



    /**
     * Constructor.
     */
    public ReferenceType()
    {
    }


    public ReferenceType(
                    final int item_ref
                    )
    {
        setItemRef( item_ref );
    }



    /**
     */
    public void setItemRef(
                    final int item_ref
                    )
    {
        this.item_ref = item_ref;
    }


    public int getItemRef()
    {
        return this.item_ref;
    }



//    //**************************************************************
//    //  Dependent
//    //**************************************************************
//
//    private SystemObjectType  _master;
//
//
//
//    @Override
//    public void setMasterObject(
//                    final SystemObjectType master
//                    )
//    {
//        _master = master;
//    }
//
//
//    @Override
//    public SystemObjectType getMasterObject()
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
        int  result = 17;

        result = prime * result + getItemRef();

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ReferenceType)) {
            return false;
        }

        ReferenceType  other = (ReferenceType)obj;
        if (this.getItemRef() == other.getItemRef()) {
            return true;
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "[item_ref=" + getItemRef()
                        + "]";
    }

}
// ReferenceType
