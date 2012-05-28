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

import java.util.HashMap;
import java.util.Iterator;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityMap<K extends Enum<K>>
    extends HashMap<K, EntityAttributeGroup>
{

    /**
     * constructor.
     */
    public EntityMap()
    {
    }



    /**
     */
    public Iterator<EntityAttributeGroup> iterateEntity()
    {
        return values().iterator();
    }



    /**
     */
    public <T extends EntityAttributeGroup> T getEntity(
                    final K key,
                    final Class<T> type
                    )
    {
        EntityAttributeGroup  e = get( key );
        return type.cast( e );
    }



    /**
     */
    public void setEntity(
                    final K key,
                    final EntityAttributeGroup value
                    )
    {
        put( key, value );
    }

}
//public class EntityMap<K extends Enum<K>>
//extends EnumMap<K, EntityAttributeGroup>
//{
//
///**
// * constructor.
// */
//public EntityMap(
//                final Class<K> keyType
//                )
//{
//    super( keyType );
//}
//
//
//
///**
// */
//public Iterator<EntityAttributeGroup> iterateEntities()
//{
//    return values().iterator();
//}
//
//
//
///**
// */
//public <T extends EntityAttributeGroup> T getEntity(
//                final K key,
//                final Class<T> type
//                )
//{
//    EntityAttributeGroup  p = get( key );
//    return type.cast( p );
//}
//
//
//
///**
// */
//public void setEntity(
//                final K key,
//                final EntityAttributeGroup value
//                )
//{
//    put( key, value );
//}
//
//}
//
