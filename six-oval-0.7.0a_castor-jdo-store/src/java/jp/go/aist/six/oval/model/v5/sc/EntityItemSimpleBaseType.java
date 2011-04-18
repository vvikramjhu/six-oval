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

package jp.go.aist.six.oval.model.v5.sc;




/**
 * The EntityItemBase is an abstract type that serves as the base type
 * for all item entities.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class EntityItemSimpleBaseType
    extends EntityAttributeGroup
{

    private String  _content;
    //{simpleContent, base="xsd:anySimpleType"}



    /**
     * Constructor.
     */
    public EntityItemSimpleBaseType()
    {
    }


    public EntityItemSimpleBaseType(
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
        _content = content;
    }


    public String getContent()
    {
        return _content;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        String  data = getContent();
        result = prime * result + ((data == null) ? 0 : data.hashCode());

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

        if (!(obj instanceof EntityItemSimpleBaseType)) {
            return false;
        }

        if (super.equals( obj )) {
            EntityItemSimpleBaseType  other = (EntityItemSimpleBaseType)obj;
            String  other_content = other.getContent();
            String   this_content =  this.getContent();
            if (this_content == other_content
                            ||  (this_content != null  &&  this_content.equals( other_content ))) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "" + getContent()
                        + super.toString()
                        ;
    }

}
// EntityItemSimpleBaseType
