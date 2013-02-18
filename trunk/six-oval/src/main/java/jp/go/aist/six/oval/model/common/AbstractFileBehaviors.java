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

package jp.go.aist.six.oval.model.common;





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
    public static final RecurseFileSystemEnumeration  DEFAULT_RECURSE_FILE_SYSTEM =
        RecurseFileSystemEnumeration.ALL;

    private RecurseFileSystemEnumeration  recurse_file_system;
    //{optional, default="all"}



    /**
     * Constructor.
     */
    public AbstractFileBehaviors()
    {
    }



    /**
     */
    public void setRecurseFileSystem(
                    final RecurseFileSystemEnumeration recurse_file_system
                    )
    {
        this.recurse_file_system = recurse_file_system;
    }


    public RecurseFileSystemEnumeration getRecurseFileSystem()
    {
        return recurse_file_system;
    }


    protected final RecurseFileSystemEnumeration _recurseFileSystem()
    {
        RecurseFileSystemEnumeration  recurseFileSystem = getRecurseFileSystem();
        return (recurseFileSystem == null ? DEFAULT_RECURSE_FILE_SYSTEM : recurseFileSystem);
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        result = prime * result + _recurseFileSystem().hashCode();

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
            if (this.getRecurseFileSystem() == other.getRecurseFileSystem()) {
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
