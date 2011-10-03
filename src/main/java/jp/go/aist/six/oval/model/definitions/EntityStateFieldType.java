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

import jp.go.aist.six.oval.model.common.CheckEnumeration;
import jp.go.aist.six.oval.model.common.DatatypeEnumeration;
import jp.go.aist.six.oval.model.common.OperationEnumeration;




/**
 * The EntityStateFieldType defines an element with simple content
 * that represents a named field in a record that may contain
 * any number of named fields.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class EntityStateFieldType
    extends EntityAttributeGroup
{

    private String  name;
    //{required, pattern="[^A-Z]+"}


    public static final CheckEnumeration  DEFAULT_ENTITY_CHECK =
        CheckEnumeration.ALL;

    private CheckEnumeration  entity_check;
    //{optional, default="all"}



    private String  content;
    //{simpleContent, base="xsd:anySimpleType"}



    /**
     * Constructor.
     */
    public EntityStateFieldType()
    {
    }


    public EntityStateFieldType(
                    final String content
                    )
    {
        setContent( content );
    }


    public EntityStateFieldType(
                    final String name,
                    final DatatypeEnumeration datatype,
                    final OperationEnumeration operation,
                    final Boolean mask,
                    final String var_ref,
                    final CheckEnumeration var_check,
                    final String content
                    )
    {
        super( datatype, operation, mask, var_ref, var_check );
        setName( name );
        setContent( content );
    }


    public EntityStateFieldType(
                    final String name,
                    final String datatype,
                    final String operation,
                    final Boolean mask,
                    final String var_ref,
                    final String var_check,
                    final String content
                    )
    {
        super( datatype, operation, mask, var_ref, var_check );
        setName( name );
        setContent( content );
    }



    /**
     */
    public void setName(
                    final String name
                    )
    {
        this.name = name;
    }


    public String getName()
    {
        return this.name;
    }



    /**
     */
    public void setEntityCheck(
                    final CheckEnumeration entity_check
                    )
    {
        this.entity_check = entity_check;
    }


    public CheckEnumeration getEntityCheck()
    {
        return this.entity_check;
    }


    public static final CheckEnumeration entityCheck(
                    final EntityStateFieldType esft
                    )
    {
        if (esft == null) {
            throw new IllegalArgumentException( "null EntityStateFieldType" );
        }

        CheckEnumeration  entity_check = esft.getEntityCheck();
        if (entity_check == null) {
            entity_check = DEFAULT_ENTITY_CHECK;
        }

        return entity_check;
    }



    /**
     */
    public void setContent(
                    final String content
                    )
    {
        this.content = content;
    }


    public String getContent()
    {
        return this.content;
    }



   //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        String  name = getName();
        result = prime * result + ((name == null) ? 0 : name.hashCode());

        String  content = getContent();
        result = prime * result + ((content == null) ? 0 : content.hashCode());

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

        if (!(obj instanceof EntityStateFieldType)) {
            return false;
        }

        EntityStateFieldType  other = (EntityStateFieldType)obj;
        if (super.equals( obj )) {
            final String  other_name = other.getName();
            final String   this_name =  this.getName();
            if (this_name == other_name
                            ||  (this_name != null
                                        &&  this_name.equals( other_name ))) {
                final String  other_content = other.getContent();
                final String   this_content =  this.getContent();
                if (this_content == other_content
                                ||  (this_content != null
                                                &&  this_content.equals( other_content ))) {
                    return true;
                }
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "" + getContent()
                        + ", name=" + getName()
                        + ", " + super.toString()
                        ;
    }

}
//EntityStateFieldType
