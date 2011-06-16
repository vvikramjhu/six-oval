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

package jp.go.aist.six.oval.model.v5;




/**
 * A base class for all the concrete behaviors.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class AbstractBehaviors
//    extends AbstractOvalObject
{

    /**
     * The default maxDepth: -1.
     */
    public static final Integer  DEFAULT_MAX_DEPTH = -1;

    private Integer  max_depth;
    //{optional, default='-1', minInclusive='-1'}


    /**
     * The default recurseDirection: "none".
     */
    public static final RecurseDirectionEnumeration  DEFAULT_RECURSE_DIRECTION =
        RecurseDirectionEnumeration.NONE;

    private RecurseDirectionEnumeration  recurse_direction;
    //{optional, default="none"}



    /**
     * Constructor.
     */
    public AbstractBehaviors()
    {
    }



    /**
     */
    public void setMaxDepth(
                    final Integer max_depth
                    )
    {
        if (max_depth != null) {
            if (max_depth < -1) {
                throw new IllegalArgumentException( "invalid maxDepth: " + max_depth );
            }
        }

        this.max_depth = max_depth;
    }


    public Integer getMaxDepth()
    {
        return this.max_depth;
    }


    protected final int _maxDepth()
    {
        Integer  maxDepth = getMaxDepth();
        return (maxDepth == null ? DEFAULT_MAX_DEPTH.intValue() : maxDepth.intValue());
    }



    /**
     */
    public void setRecurseDirection(
                    final RecurseDirectionEnumeration recurse_direction
                    )
    {
        this.recurse_direction = recurse_direction;
    }


    public RecurseDirectionEnumeration getRecurseDirection()
    {
        return this.recurse_direction;
    }


    protected final RecurseDirectionEnumeration _recurseDirection()
    {
        RecurseDirectionEnumeration  recurseDirection = getRecurseDirection();
        return (recurseDirection == null ? DEFAULT_RECURSE_DIRECTION : recurseDirection);
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        result = prime * result + _maxDepth();

        result = prime * result + _recurseDirection().hashCode();

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

        if (!(obj instanceof AbstractBehaviors)) {
            return false;
        }

        AbstractBehaviors  other = (AbstractBehaviors)obj;
        if (this._maxDepth() == other._maxDepth()) {
            if (this.getRecurseDirection() == other.getRecurseDirection()) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "max_depth=" + getMaxDepth()
                        + ", recurse_direction=" + getRecurseDirection()
                        ;
    }

}
// AbstractBehaviors
