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
