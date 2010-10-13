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

import jp.go.aist.six.oval.model.RecurseDirection;
import jp.go.aist.six.util.castor.AbstractPersistable;



/**
 * A base class for all the concrete Behaviors.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class FileBehaviors
    extends AbstractPersistable
{

    /**
     * The default maxDepth: -1.
     */
    public static final int  DEFAULT_MAX_DEPTH = -1;
    private int _maxDepth = DEFAULT_MAX_DEPTH;
    //{optional, default='-1', minInclusive='-1'}


    /**
     * The default recurseDirection: "none".
     */
    public static final RecurseDirection  DEFAULT_RECURSE_DIRECTION = RecurseDirection.NONE;
    private RecurseDirection  _recurseDirection;
    //{optional, default="none"}



    /**
     * Constructor.
     */
    public FileBehaviors()
    {
    }



    public void setMaxDepth(
                    final int maxDepth
                    )
    {
        _maxDepth = maxDepth;
    }


    public int getMaxDepth()
    {
        return _maxDepth;
    }



    public void setRecurseDirection(
                    final RecurseDirection direction
                    )
    {
        _recurseDirection = direction;
    }


    public RecurseDirection getRecurseDirection()
    {
        return (_recurseDirection == null
                        ? DEFAULT_RECURSE_DIRECTION
                        : _recurseDirection);
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        result = prime * result + getMaxDepth();

        RecurseDirection  rd = getRecurseDirection();
        result = prime * result + ((rd == null) ? 0 : rd.hashCode());

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
            RecurseDirection  other_rd = other.getRecurseDirection();
            RecurseDirection   this_rd =  this.getRecurseDirection();
            if (this_rd == other_rd) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "max_depth=" + getMaxDepth()
                        + ", recurse_direction=" + getRecurseDirection();
    }

}
// FileBehaviors
