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

package jp.go.aist.six.oval.model.unix;

import jp.go.aist.six.oval.model.common.AbstractRecurseFileBehaviors;



/**
 * The FileBehaviors type defines a number of behaviors
 * that allow a more detailed definition of the file_object being specified.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class FileBehaviors
    extends AbstractRecurseFileBehaviors
{

//    NOTE: AbstractBehaviors & AbstractFileBehaviors are distilled.


//    private RecurseEnumeration  recurse;
//    //{optional, default="symlinks and directories"}




    /**
     * Constructor.
     */
    public FileBehaviors()
    {
    }



//    /**
//     */
//    public void setRecurse(
//                    final RecurseEnumeration recurse
//                    )
//    {
//        this.recurse = recurse;
//    }
//
//
//    public RecurseEnumeration getRecurse()
//    {
//        return this.recurse;
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

//    @Override
//    public int hashCode()
//    {
//        return super.hashCode();
//    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof FileBehaviors)) {
            return false;
        }

        return super.equals( obj );
    }



//    @Override
//    public String toString()
//    {
//        return super.toString()
//                        + ", recurse=" + getRecurse()
//                        ;
//    }

}
//FileBehaviors
