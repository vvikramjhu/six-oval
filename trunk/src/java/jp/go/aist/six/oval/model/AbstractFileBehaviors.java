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

package jp.go.aist.six.oval.model;

import jp.go.aist.six.util.castor.AbstractPersistable;



/**
 * A base class for all the concrete file behaviors.
 * File behaviors defines a number of behaviors
 * that allow a more detailed definition of a set of files
 * or file related items to collect.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class AbstractFileBehaviors
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
    //{optional, default='none'}


    /**
     * The default recurseFileSystem: "all".
     */
    public static final RecurseFileSystem  DEFAULT_RECURSE_FILE_SYSTEM = RecurseFileSystem.ALL;
    private RecurseFileSystem  _recurseFileSystem;
    //{optional, default='all'}



    /**
     * Constructor.
     */
    public AbstractFileBehaviors()
    {
    }



    /**
     */
    public void setMaxDepth(
                    final int maxDepth
                    )
    {
        if (maxDepth < -1) {
            throw new IllegalArgumentException( "invalid maxDepth: " + maxDepth );
        }

        _maxDepth = maxDepth;
    }


    public int getMaxDepth()
    {
        return _maxDepth;
    }



    /**
     */
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



    /**
     */
    public void setRecurseFileSystem(
                    final RecurseFileSystem fileSystem
                    )
    {
        _recurseFileSystem = fileSystem;
    }


    public RecurseFileSystem getRecurseFileSystem()
    {
        return (_recurseFileSystem == null
                        ? DEFAULT_RECURSE_FILE_SYSTEM
                        : _recurseFileSystem);
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

        RecurseFileSystem  rfs = getRecurseFileSystem();
        result = prime * result + ((rfs == null) ? 0 : rfs.hashCode());

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

        if (!(obj instanceof AbstractFileBehaviors)) {
            return false;
        }

        AbstractFileBehaviors  other = (AbstractFileBehaviors)obj;
        if (this.getMaxDepth() == other.getMaxDepth()) {
            RecurseDirection  other_rd = other.getRecurseDirection();
            RecurseDirection   this_rd =  this.getRecurseDirection();
            if (this_rd == other_rd) {
                RecurseFileSystem  other_rfs = other.getRecurseFileSystem();
                RecurseFileSystem   this_rfs =  this.getRecurseFileSystem();
                if (this_rfs == other_rfs) {
                    return true;
                }
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "max_depth=" + getMaxDepth()
                        + ", recurse_direction=" + getRecurseDirection()
                        + ", recurse_file_system=" + getRecurseFileSystem()
                        ;
    }

}
// AbstractFileBehaviors
