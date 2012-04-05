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

package jp.go.aist.six.oval.model.independent;

import jp.go.aist.six.oval.model.common.WindowsViewEnumeration;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;



/**
 * The EntityItemWindowsViewType restricts a string value
 * to a specific set of values: 32-bit and 64-bit.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityItemWindowsViewType
    extends EntityItemStringType
{

    /**
     * Constructor.
     */
    public EntityItemWindowsViewType()
    {
    }


    public EntityItemWindowsViewType(
                    final String content
                    )
    {
        super( content );
    }



    public EntityItemWindowsViewType(
                    final WindowsViewEnumeration content
                    )
    {
        super( (content == null ? null : content.value()) );
    }



    //**************************************************************
    //  EntityItemBase
    //**************************************************************

    @Override
    public void setContent(
                    final String content
                    )
    {
        if (content != null) {
            //validation
            WindowsViewEnumeration.fromValue( content );
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
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EntityItemWindowsViewType)) {
            return false;
        }

        return super.equals( obj );
    }

}
//EntityItemWindowsViewType
