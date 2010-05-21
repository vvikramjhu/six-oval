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
 * @version $Id: EntityObjectBaseType.java 705 2010-04-27 08:32:35Z akihito $
 */
public abstract class EntityObjectBaseType
    extends EntityBaseType
{

    public static final Check  DEFAULT_VARIABLE_CHECK = Check.ALL;
    private Check  _varCheck = DEFAULT_VARIABLE_CHECK;
    //{optional, default="all"}



    /**
     * Constructor.
     */
    public EntityObjectBaseType()
    {
    }



    public void setVariableCheck(
                    final Check check
                    )
    {
        _varCheck = check;
    }


    public Check getVariableCheck()
    {
        return _varCheck;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        Check  check = getVariableCheck();
        result = prime * result + ((check == null) ? 0 : check.hashCode());

        return result;
    }



    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EntityObjectBaseType)) {
            return false;
        }

        if (super.equals( obj )) {
            EntityObjectBaseType  other = (EntityObjectBaseType)obj;
            Check  other_check = other.getVariableCheck();
            Check   this_check =  this.getVariableCheck();
            if (this_check == other_check) {
                return true;
            }
        }

        return false;
    }



    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return super.toString()
                        + ", var_check=" + getVariableCheck();
    }

}
// EntityObjectBaseType
