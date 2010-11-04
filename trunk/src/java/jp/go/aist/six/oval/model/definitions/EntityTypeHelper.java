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



/**
 * A helper class for EntityBase instances.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: EntityTypeHelper.java 440 2010-03-23 05:11:44Z akihito $
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityTypeHelper
{

    public static boolean equals(
                    final EntityBase obj1,
                    final EntityBase obj2
                    )
    {
        if (obj1 == obj2  ||  (obj1 != null  &&  obj1.equals( obj2 ))) {
            return true;
        }

        return false;
    }

}
// EntityTypeHelper
