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

import jp.go.aist.six.oval.model.common.Behaviors;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class FileBehaviors
    extends Behaviors
{

    public static final RecurseFileSystem  DEFAULT_RECURSE_DIRECTION = RecurseFileSystem.ALL;
    private RecurseFileSystem  _recurseFileSystem;
    //{optional, default="all"}



    /**
     * Constructor.
     */
    public FileBehaviors()
    {
    }



    /**
     */
    public void setRecurseFileSystem(
                    final RecurseFileSystem recurseFileSystem
                    )
    {
        _recurseFileSystem = recurseFileSystem;
    }


    /**
     */
    public RecurseFileSystem getRecurseFileSystem()
    {
        return _recurseFileSystem;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        RecurseFileSystem  r = getRecurseFileSystem();
        result = prime * result + ((r == null) ? 0 : r.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof FileBehaviors)) {
            return false;
        }

        if (super.equals( obj )) {
            FileBehaviors  other = (FileBehaviors)obj;
            RecurseFileSystem  other_r = other.getRecurseFileSystem();  // enum
            RecurseFileSystem   this_r =  this.getRecurseFileSystem();
            if (this_r == other_r) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "FileBehaviors[" + super.toString()
                        + ", recurse_file_system=" + getRecurseFileSystem()
                        + "]";
    }

}
// FileBehaviors
