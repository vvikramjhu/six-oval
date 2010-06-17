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

package jp.go.aist.six.oval.model.windows;

import jp.go.aist.six.util.orm.AbstractPersistable;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: Behaviors.java 684 2010-04-24 14:36:18Z akihito $
 */
public class Behaviors
    extends AbstractPersistable
{

    public static final Behaviors  DEFAULT_VALUE = new Behaviors();



    public static final int  DEFAULT_MAX_DEPTH = -1;
    private int _maxDepth = DEFAULT_MAX_DEPTH;
    //{optional, default="-1"}

    public static final RecurseDirection  DEFAULT_RECURSE_DIRECTION = RecurseDirection.NONE;
    private RecurseDirection  _recurseDirection;
    //{optional, default="none"}



    /**
     * Constructor.
     */
    public Behaviors()
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

        if (!(obj instanceof Behaviors)) {
            return false;
        }

        Behaviors  other = (Behaviors)obj;
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
        return "Behaviors[max_depth=" + getMaxDepth()
                        + ", recurse_direction=" + getRecurseDirection()
                        + "]";
    }

}
// Behaviors
