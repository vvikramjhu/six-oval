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

package jp.go.aist.six.oval.model.v5.independent;

import jp.go.aist.six.oval.model.common.FamilyEnumeration;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;



/**
 * The EntityStateFamily type defines a string entity value that is
 * restricted to a set of enumerations.
 * Each valid enumeration is a high-level family of system operating system.
 * The empty string is also allowed to support empty elements
 * associated with variable references.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityStateFamilyType
    extends EntityStateStringType
{

    /**
     * Constructor.
     */
    public EntityStateFamilyType()
    {
    }


    public EntityStateFamilyType(
                    final String content
                    )
    {
        super( content );
    }



    //**************************************************************
    //  EntityBaseType
    //**************************************************************

    @Override
    public void setContent(
                    final String content
                    )
    {
        if (content != null) {
            //validation
            FamilyEnumeration.fromValue( content );
        }

        super.setContent( content );
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
        if (!(obj instanceof EntityStateFamilyType)) {
            return false;
        }

        return super.equals( obj );
    }

}
// EntityStateFamilyType
