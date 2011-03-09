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

package jp.go.aist.six.oval.model.v5.independent;

import java.util.Collections;
import java.util.Iterator;
import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.v5.definitions.EntityAttributeGroup;
import jp.go.aist.six.oval.model.v5.definitions.StateType;



/**
 * The family state contains a single entity that is used
 * to check the family associated with the system.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class FamilyState
    extends StateType
{

    private EntityStateFamilyType  _family;
    //{0..1}



    /**
     * Constructor.
     */
    public FamilyState()
    {
    }


    public FamilyState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


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
    public EntityStateFamilyType getFamily()
    {
        return _family;
    }


    public void setFamily(
                    final EntityStateFamilyType family
                    )
    {
        _family = family;
    }


    public FamilyState family(
                    final EntityStateFamilyType family
                    )
    {
        setFamily( family );
        return this;
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.INDEPENDENT_FAMILY;
    }



    @Override
    public Iterator<EntityAttributeGroup> iterateProperties()
    {
        EntityAttributeGroup  p = getFamily();
        return Collections.singletonList( p ).iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof FamilyState)) {
            return false;
        }

        return super.equals( obj );
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
