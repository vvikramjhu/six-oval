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

package jp.go.aist.six.oval.model.linux;

import jp.go.aist.six.oval.model.common.AbstractRecurseFileBehaviors;
import jp.go.aist.six.oval.model.common.RecurseEnumeration;



/**
 * The FileBehaviors defines a number of behaviors
 * that allow a more detailed definition of a set of files
 * or file related items to collect.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class FileBehaviors
    extends AbstractRecurseFileBehaviors
{

//    /**
//     * The default recurseDirection: "symlinks and directories".
//     */
//    public static final RecurseEnumeration  DEFAULT_RECURSE =
//        RecurseEnumeration.SYMLINKS_AND_DIRECTORIES;
//
//    private String  recurse;
//    //{optional, default='symlinks and directories'}



    /**
     * Constructor.
     */
    public FileBehaviors()
    {
    }



    //**************************************************************
    //  AbstractRecurseFileBehaviors
    //**************************************************************

    @Override
    public void setRecurse(
                    final String recurse
                    )
    {
        if (recurse != null) {
            if (RecurseEnumeration.DIRECTORIES.value().equals( recurse )
                            ||  RecurseEnumeration.SYMLINKS.value().equals( recurse )
                            ||  RecurseEnumeration.SYMLINKS_AND_DIRECTORIES.value().equals( recurse )
                            ) {
                // valid value!!!
            }
        }

        super.setRecurse( recurse );
    }


//    public String getRecurse()
//    {
//        return this.recurse;
//    }
//
//
//    public static String recurse(
//                    final FileBehaviors behaviors
//                    )
//    {
//        String  recurse = behaviors.getRecurse();
//        return (recurse == null ? DEFAULT_RECURSE.value() : recurse );
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
        if (this == obj) {
            return true;
        }

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
