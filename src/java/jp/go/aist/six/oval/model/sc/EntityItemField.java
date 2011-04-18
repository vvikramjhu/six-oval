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

package jp.go.aist.six.oval.model.sc;

import jp.go.aist.six.oval.model.common.Datatype;



/**
 * The EntityItemField defines an element with simple content that represents
 * a named field in a record that may contain any number of named fields.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityItemField
    extends EntityItemBase
{

    private String  _name;
    //{required}



    /**
     * Constructor.
     */
    public EntityItemField()
    {
    }


    /**
     * Constructor.
     */
    public EntityItemField(
                    final String data
                    )
    {
        this( data, DEFAULT_STATUS );
    }


    /**
     * Constructor.
     */
    public EntityItemField(
                    final String data,
                    final Status status
                    )
    {
        this( data, DEFAULT_DATATYPE, status );
    }


    /**
     * Constructor.
     */
    public EntityItemField(
                    final String data,
                    final Datatype datatype,
                    final Status status
                    )
    {
        super( data, datatype, status );
    }



    /**
     */
    public void setName(
                    final String name
                    )
    {
        _name = name;
    }


    public EntityItemField name(
                    final String name
                    )
    {
        setName( name );
        return this;
    }


    public String getName()
    {
        return _name;
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
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EntityItemField)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "[name=" + getName()
                        + ", " + super.toString()
                        + "]";
    }

}
// EntityItemField
