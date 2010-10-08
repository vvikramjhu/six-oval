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

import jp.go.aist.six.oval.model.EntityType;
import jp.go.aist.six.oval.model.definitions.State;



/**
 * The FamilyState contains a single entity that is used
 * to check the family associated with the system.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class FamilyState
    extends State
{

    private EntityStateFamily  _family;
    //{0..1}



    /**
     * Constructor.
     */
    public FamilyState()
    {
    }


    /**
     * Constructor.
     */
    public FamilyState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public FamilyState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );
    }




    /**
     */
    public EntityStateFamily getFamily()
    {
        return _family;
    }


    public void setFamily(
                    final EntityStateFamily family
                    )
    {
        _family = family;
    }


    public FamilyState family(
                    final EntityStateFamily family
                    )
    {
        setFamily( family );
        return this;
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public EntityType getEntityType()
    {
        return EntityType.INDEPENDENT_FAMILY;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        EntityStateFamily  family = getFamily();
        result = prime * result + ((family == null) ? 0 : family.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof FamilyState)) {
            return false;
        }

        if (super.equals( obj )) {
            FamilyState  other = (FamilyState)obj;
            EntityStateFamily  other_family = other.getFamily();
            EntityStateFamily   this_family =  this.getFamily();
            if (this_family == other_family
                            ||  (this_family != null  &&  this_family.equals( other_family ))) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "family_state[" + super.toString()
                        + ", family=" + getFamily()
                        + "]";
    }

}
// FamilyState
