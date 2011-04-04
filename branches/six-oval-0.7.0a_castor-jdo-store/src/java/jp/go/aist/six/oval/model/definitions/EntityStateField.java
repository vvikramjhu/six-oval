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

import jp.go.aist.six.oval.model.common.Datatype;
import jp.go.aist.six.oval.model.common.Operation;



/**
 * The EntityStateField defines an element with simple content
 * that represents a named field in a record that may contain
 * any number of named fields.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityStateField
    extends EntityStateBase
{

    private String  _name;
    //{required}



    /**
     * Constructor.
     */
    public EntityStateField()
    {
    }


    /**
     * Constructor.
     */
    public EntityStateField(
                    final String data
                    )
    {
        this( data, DEFAULT_OPERATION );
    }


    /**
     * Constructor.
     */
    public EntityStateField(
                    final String data,
                    final Operation operation
                    )
    {
        this( data, DEFAULT_DATATYPE, operation );
    }


    /**
     * Constructor.
     */
    public EntityStateField(
                    final String data,
                    final Datatype datatype,
                    final Operation operation
                    )
    {
        super( data, datatype, operation );
    }



    /**
     */
    public void setName(
                    final String name
                    )
    {
        _name = name;
    }


    public EntityStateField name(
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
        final int  prime = 37;
        int  hash = super.hashCode();

        String  name = getName();
        hash = prime * hash + ((name == null) ? 0 : name.hashCode());

        return hash;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof EntityStateField)) {
            return false;
        }

        if (super.equals( obj )) {
            EntityStateField  other = (EntityStateField)obj;
            String  otherName = other.getName();
            String   thisName =  this.getName();
            if (thisName == otherName
                            ||  (thisName != null  &&  thisName.equals( otherName ))) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "[name=" + getName()
                        + ", " + super.toString()
                        + "]";
    }

}
// EntityStateField
