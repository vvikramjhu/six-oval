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

package jp.go.aist.six.oval.model.independent;

import jp.go.aist.six.oval.model.common.AbstractRecurseFileBehaviors;
import jp.go.aist.six.oval.model.common.RecurseEnumeration;



/**
 * The FileBehaviors type defines a number of behaviors
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
//    private RecurseEnumeration  recurse;
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

}
// FileBehaviors
