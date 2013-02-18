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
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class AbstractRecurseFileBehaviors
    extends AbstractFileBehaviors
{

    /**
     * The default recurseDirection: "symlinks and directories".
     */
    public static final RecurseEnumeration  DEFAULT_RECURSE =
        RecurseEnumeration.SYMLINKS_AND_DIRECTORIES;

    private String  recurse;
    //{optional, default='symlinks and directories'}



    /**
     * Constructor.
     */
    public AbstractRecurseFileBehaviors()
    {
    }



    /**
     */
    public void setRecurse(
                    final String recurse
                    )
    {
        if (recurse != null) {
            RecurseEnumeration.fromValue( recurse );
            // valid value!!!
        }

        this.recurse = recurse;
    }


    public String getRecurse()
    {
        return recurse;
    }


    public static String recurse(
                    final AbstractRecurseFileBehaviors behaviors
                    )
    {
        String  recurse = behaviors.getRecurse();
        return (recurse == null ? DEFAULT_RECURSE.value() : recurse );
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        result = prime * result + recurse( this ).hashCode();

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

        if (!(obj instanceof AbstractRecurseFileBehaviors)) {
            return false;
        }

        if (super.equals( obj )) {
            AbstractRecurseFileBehaviors  other = (AbstractRecurseFileBehaviors)obj;
            if (recurse( this ).equals( recurse( other ) )) {
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
//
