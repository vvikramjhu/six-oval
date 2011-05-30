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

package jp.go.aist.six.oval.model.v5.definitions;

import jp.go.aist.six.oval.model.v5.common.CheckEnumeration;



/**
 * The EntityStateBase type is an abstract type that extends
 * the EntityBase and is used by the entities within an OVAL State.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class EntityStateSimpleBaseType
    extends EntitySimpleBaseType
{

    public static final CheckEnumeration  DEFAULT_ENTITY_CHECK = CheckEnumeration.ALL;
    private CheckEnumeration  _entityCheck;
    //{optional, default="all"}



    /**
     * Constructor.
     */
    public EntityStateSimpleBaseType()
    {
    }


    public EntityStateSimpleBaseType(
                    final String content
                    )
    {
        super( content );
    }



    /**
     */
    public void setEntityCheck(
                    final CheckEnumeration check
                    )
    {
        _entityCheck = check;
    }


    public CheckEnumeration getEntityCheck()
    {
        return _entityCheck;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        CheckEnumeration  e_check = getEntityCheck();
        result = prime * result + ((e_check == null) ? 0 : e_check.hashCode());

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

        if (!(obj instanceof EntityStateSimpleBaseType)) {
            return false;
        }

        if (super.equals( obj )) {
            EntityStateSimpleBaseType  other = (EntityStateSimpleBaseType)obj;
            CheckEnumeration  other_e_check = other.getEntityCheck();
            CheckEnumeration   this_e_check =  this.getEntityCheck();
            if (this_e_check == null) {
                this_e_check = DEFAULT_ENTITY_CHECK;
            }
            if (other_e_check == null) {
                other_e_check = DEFAULT_ENTITY_CHECK;
            }
            if (this_e_check == other_e_check) {
                    return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return super.toString()
                        + ", entity_check=" + getEntityCheck()
                        ;
    }

}
// EntityStateSimpleBaseType
