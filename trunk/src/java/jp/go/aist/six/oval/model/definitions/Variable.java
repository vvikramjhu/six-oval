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

package jp.go.aist.six.oval.model.definitions;

import jp.go.aist.six.oval.model.CommentedOvalEntity;
import jp.go.aist.six.oval.model.EntityType;
import jp.go.aist.six.oval.model.common.Datatype;



/**
 * The OVAL Variable describes different sources
 * for obtaining a value(s) for the variable.
 * There are currently three types of variables;
 * local, external, and constant.
 *
 * <p>Properties:</p>
 * <ul>
 *   <li>id (required)</li>
 *   <li>version (required)</li>
 *   <li>datatype (required)</li>
 *   <li>comment (required)</li>
 *   <li>deprecated (optional -- default='false')</li>
 *   <li>Signature (0..1): currently NOT supported.</li>
 * </ul>
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class Variable
//public abstract class Variable
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



    /**
     */
    public void setEntityType(
                    final EntityType type
                    )
    {
    }


//    public abstract EntityType getEntityType();
    public EntityType getEntityType()
    {
        return EntityType.UNKNOWN;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return super.toString()
                        + ", datatype=" + getDatatype();
    }

}
// Variable
