/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
