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

import jp.go.aist.six.oval.model.common.CheckEnumeration;
import jp.go.aist.six.oval.model.common.DatatypeEnumeration;
import jp.go.aist.six.oval.model.common.OperationEnumeration;




/**
 * The EntitySimpleBaseType complex type is an abstract type
 * that defines the default attributes associated with every simple entity.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class EntitySimpleBaseType
    extends EntityAttributeGroup
{

    private String  content;
    //{simpleContent, base="xsd:anySimpleType"}



    /**
     * Constructor.
     */
    public EntitySimpleBaseType()
    {
    }


    public EntitySimpleBaseType(
                    final String content
                    )
    {
        setContent( content );
    }


    public EntitySimpleBaseType(
                    final DatatypeEnumeration datatype,
                    final OperationEnumeration operation,
                    final Boolean mask,
                    final String var_ref,
                    final CheckEnumeration var_check,
                    final String content
                    )
    {
        super( datatype, operation, mask, var_ref, var_check );
        setContent( content );
    }


    public EntitySimpleBaseType(
                    final String datatype,
                    final String operation,
                    final Boolean mask,
                    final String var_ref,
                    final String var_check,
                    final String content
                    )
    {
        super( datatype, operation, mask, var_ref, var_check );
        setContent( content );
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

        if (!(obj instanceof EntitySimpleBaseType)) {
            return false;
        }

        EntitySimpleBaseType  other = (EntitySimpleBaseType)obj;
        if (super.equals( obj )) {
            final String  other_content = other.getContent();
            final String   this_content =  this.getContent();
            if (this_content == other_content
                            ||  (this_content != null
                                        &&  this_content.equals( other_content ))) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "" + getContent()
                        + ", " + super.toString()
                        ;
    }

}
// EntitySimpleBaseType
