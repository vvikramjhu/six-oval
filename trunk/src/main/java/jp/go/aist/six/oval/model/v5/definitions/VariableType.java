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

import jp.go.aist.six.oval.model.CommentedOvalEntity;
import jp.go.aist.six.oval.model.OvalEntityType;
import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.common.DatatypeEnumeration;
import com.google.code.morphia.annotations.Entity;



/**
 * The OVAL Variable describes different sources
 * for obtaining a value(s) for the variable.
 * There are currently three types of variables;
 * local, external, and constant.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
@Entity( "oval.d.variable" )
public class VariableType
    extends CommentedOvalEntity
{

    private DatatypeEnumeration  datatype;
    //{required}



    /**
     * Constructor.
     */
    public VariableType()
    {
        this( null, 0 );
    }


    public VariableType(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public VariableType(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        this( id, version, comment, null );
    }


    public VariableType(
                    final String id,
                    final int version,
                    final String comment,
                    final DatatypeEnumeration datatype
                    )
    {
        super( id, version, comment );
        setDatatype( datatype );

        _oval_entity_type = OvalEntityType.variable;
    }



    /**
     */
    public void setDatatype(
                    final DatatypeEnumeration datatype
                    )
    {
        this.datatype = datatype;
    }


    public DatatypeEnumeration getDatatype()
    {
        return this.datatype;
    }



    /**
     */
    public void setEntityType(
                    final PlatformEntityType type
                    )
    {
    }


//    public abstract EntityType getEntityType();
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.UNKNOWN;
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
// VariableType
