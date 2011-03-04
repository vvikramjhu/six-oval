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

import jp.go.aist.six.oval.model.AbstractBehaviors;



/**
 * A base class for all the concrete file behaviors.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class AbstractFileBehaviors
    extends AbstractBehaviors
{

    /**
     * The default recurseFileSystem: "all".
     */
    public static final RecurseFileSystemEnumeration  DEFAULT_RECURSE_FILE_SYSTEM = RecurseFileSystemEnumeration.ALL;
    private RecurseFileSystemEnumeration  _recurseFileSystem;
    //{optional, default='all'}



    /**
     * Constructor.
     */
    public AbstractFileBehaviors()
    {
    }



    /**
     */
    public void setRecurseFileSystem(
                    final RecurseFileSystemEnumeration fileSystem
                    )
    {
        _recurseFileSystem = fileSystem;
    }


    public RecurseFileSystemEnumeration getRecurseFileSystem()
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
        int  result = super.hashCode();

        RecurseFileSystemEnumeration  rfs = getRecurseFileSystem();
        result = prime * result + ((rfs == null) ? 0 : rfs.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof AbstractFileBehaviors)) {
            return false;
        }

        if (super.equals( obj )) {
            AbstractFileBehaviors  other = (AbstractFileBehaviors)obj;
            RecurseFileSystemEnumeration  other_rfs = other.getRecurseFileSystem();
            RecurseFileSystemEnumeration   this_rfs =  this.getRecurseFileSystem();
            if (this_rfs == other_rfs) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return super.toString()
                        + ", recurse_file_system=" + getRecurseFileSystem()
                        ;
    }

}
// AbstractFileBehaviors
