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

import jp.go.aist.six.oval.model.AbstractFileBehaviors;
import jp.go.aist.six.oval.model.Recurse;



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
    extends AbstractFileBehaviors
{

    /**
     * The default recurseDirection: "symlinks and directories".
     */
    public static final Recurse  DEFAULT_RECURSE = Recurse.SYMLINKS_AND_DIRECTORIES;
    private Recurse  _recurse;
    //{optional, default='symlinks and directories'}



    /**
     * Constructor.
     */
    public FileBehaviors()
    {
    }



    /**
     */
    public void setRecurse(
                    final Recurse recurse
                    )
    {
        _recurse = recurse;
    }


    public Recurse getRecurse()
    {
        return (_recurse == null
                        ? DEFAULT_RECURSE
                        : _recurse);
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        Recurse  r = getRecurse();
        result = prime * result + ((r == null) ? 0 : r.hashCode());

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

        if (!(obj instanceof FileBehaviors)) {
            return false;
        }

        FileBehaviors  other = (FileBehaviors)obj;
        if (this.getMaxDepth() == other.getMaxDepth()) {
            Recurse  other_r = other.getRecurse();
            Recurse   this_r =  this.getRecurse();
            if (this_r == other_r) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return super.toString()
                        + ", recurse=" + getRecurse()
                        ;
    }

}
// FileBehaviors
