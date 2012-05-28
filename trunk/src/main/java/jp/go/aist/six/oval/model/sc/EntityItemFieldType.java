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




/**
 * The EntityItemFieldType defines an element with simple content
 * that represents a named field in a record that may contain any number of named fields.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityItemFieldType
    extends EntityAttributeGroup
{

    private String  content;
    //{simpleContent, base="xsd:anySimpleType"}

    private String  name;
    //{required, pattern value="[^A-Z]+"}



    /**
     * Constructor.
     */
    public EntityItemFieldType()
    {
    }


    public EntityItemFieldType(
                    final String content
                    )
    {
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
        return content;
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
        return name;
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

        String  name = getName();
        result = prime * result + ((name == null) ? 0 : name.hashCode());

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

        if (!(obj instanceof EntityItemFieldType)) {
            return false;
        }

        if (super.equals( obj )) {
            EntityItemFieldType  other = (EntityItemFieldType)obj;
            String  other_name = other.getName();
            String   this_name =  this.getName();
            if (this_name == other_name
                            ||  (this_name != null  &&  this_name.equals( other_name ))) {
                String  other_content = other.getContent();
                String   this_content =  this.getContent();
                if (this_content == other_content
                                ||  (this_content != null  &&  this_content.equals( other_content ))) {
                    return true;
                }
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "" + super.toString()
                        + ", name=" + getName()
                        + ", " + getContent()
                        ;
    }

}
//
