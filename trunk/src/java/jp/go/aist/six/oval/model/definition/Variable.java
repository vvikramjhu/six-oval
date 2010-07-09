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

import jp.go.aist.six.oval.model.CommentedOvalEntity;
import jp.go.aist.six.oval.model.ObjectType;
import jp.go.aist.six.oval.model.common.Datatype;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class Variable
    extends CommentedOvalEntity
{

    private Datatype  _datatype;
    //{required}



    /**
     * Constructor.
     */
    public Variable()
    {
    }


    /**
     * Constructor.
     */
    public Variable(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }



    /**
     * Constructor.
     */
    public Variable(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );
    }



    /**
     * Constructor.
     */
    public Variable(
                    final String id,
                    final int version,
                    final String comment,
                    final Datatype datatype
                    )
    {
        this( id, version, comment );
        setDatatype( datatype );
    }



    public void setDatatype(
                    final Datatype datatype
                    )
    {
        _datatype = datatype;
    }



    public Datatype getDatatype()
    {
        return _datatype;
    }



    public void setObjectType(
                    final ObjectType type
                    )
    {
    }


    public abstract ObjectType getObjectType();



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
        if (!(obj instanceof Variable)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return super.toString()
                        + ", datatype=" + getDatatype();
    }

}
// Variable
