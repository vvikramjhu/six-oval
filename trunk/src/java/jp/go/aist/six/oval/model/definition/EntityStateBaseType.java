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

package jp.go.aist.six.oval.model.definition;

import jp.go.aist.six.oval.model.common.Check;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class EntityStateBaseType
    extends EntityBaseType
{

    public static final Check  DEFAULT_ENTITY_CHECK = Check.ALL;
    private Check  _entityCheck;
    //{optional, default="all"}

    public static final Check  DEFAULT_VARIABLE_CHECK = Check.ALL;
    private Check  _varCheck = DEFAULT_VARIABLE_CHECK;
    //{optional, default="all"}



    /**
     * Constructor.
     */
    public EntityStateBaseType()
    {
    }



    public void setEntityCheck(
                    final Check check
                    )
    {
        _entityCheck = check;
    }


    public Check getEntityCheck()
    {
        return (_entityCheck == null ? DEFAULT_ENTITY_CHECK : _entityCheck);
    }



    public void setVarCheck(
                    final Check check
                    )
    {
        _varCheck = check;
    }


    public Check getVarCheck()
    {
        return (_varCheck == null ? DEFAULT_ENTITY_CHECK : _varCheck);
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        Check  e_check = getEntityCheck();
        result = prime * result + ((e_check == null) ? 0 : e_check.hashCode());

        Check  v_check = getVarCheck();
        result = prime * result + ((v_check == null) ? 0 : v_check.hashCode());

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

        if (!(obj instanceof EntityStateBaseType)) {
            return false;
        }

        if (super.equals( obj )) {
            EntityStateBaseType  other = (EntityStateBaseType)obj;
            Check  other_e_check = other.getEntityCheck();
            Check   this_e_check =  this.getEntityCheck();
            if (this_e_check == other_e_check) {
                Check  other_v_check = other.getVarCheck();
                Check   this_v_check =  this.getVarCheck();
                if (this_v_check == other_v_check) {
                    return true;
                }
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return super.toString()
                        + ", entity_check=" + getEntityCheck()
                        + ", var_check=" + getVarCheck();
    }

}
// EntityStateBaseType
