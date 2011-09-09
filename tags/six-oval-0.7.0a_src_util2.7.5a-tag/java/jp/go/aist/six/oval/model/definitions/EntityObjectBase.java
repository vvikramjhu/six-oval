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

package jp.go.aist.six.oval.model.definitions;

import jp.go.aist.six.oval.model.common.Check;
import jp.go.aist.six.oval.model.common.Datatype;
import jp.go.aist.six.oval.model.common.Operation;



/**
 * The EntityObjectBase type is an abstract type that extends
 * the EntityBase and is used by the entities within an OVAL Object.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class EntityObjectBase
    extends EntityBase
{

    public static final Check  DEFAULT_VAR_CHECK = Check.ALL;
    private Check  _varCheck;
    //{optional, default="all"}



    /**
     * Constructor.
     */
    public EntityObjectBase()
    {
    }


    /**
     * Constructor.
     */
    public EntityObjectBase(
                    final String data
                    )
    {
        super( data );
    }


    /**
     * Constructor.
     */
    public EntityObjectBase(
                    final String data,
                    final Operation operation
                    )
    {
        super( data, operation );
    }


    /**
     * Constructor.
     */
    public EntityObjectBase(
                    final String data,
                    final Datatype datatype,
                    final Operation operation
                    )
    {
        super( data, datatype, operation );
    }


    /**
     * Constructor.
     */
    public EntityObjectBase(
                    final String varRef,
                    final Check varCheck
                    )
    {
        setVarRef( varRef );
        setVarCheck( varCheck );
    }



    /**
     */
    public void setVarCheck(
                    final Check check
                    )
    {
        _varCheck = check;
    }


    public Check getVarCheck()
    {
        return (_varCheck == null ? DEFAULT_VAR_CHECK : _varCheck);
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        Check  check = getVarCheck();
        result = prime * result + ((check == null) ? 0 : check.hashCode());

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

        if (!(obj instanceof EntityObjectBase)) {
            return false;
        }

        if (super.equals( obj )) {
            EntityObjectBase  other = (EntityObjectBase)obj;
            Check  other_check = other.getVarCheck();
            Check   this_check =  this.getVarCheck();
            if (this_check == other_check) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "[" + super.toString()
                        + ", var_check=" + getVarCheck()
                        + "]";
    }

}
// EntityObjectBase