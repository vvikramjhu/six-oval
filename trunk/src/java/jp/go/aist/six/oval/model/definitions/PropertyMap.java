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

import java.util.EnumMap;
import java.util.Iterator;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class PropertyMap<K extends Enum<K>>
    extends EnumMap<K, EntityBase>
{

    /**
     * Constructor.
     */
    public PropertyMap(
                    final Class<K> keyType
                    )
    {
        super( keyType );
    }



    /**
     */
    public Iterator<EntityBase> iterateProperties()
    {
        return values().iterator();
    }



    public <T extends EntityBase> T getProperty(
                    final K key,
                    final Class<T> type
                    )
    {
        EntityBase  p = get( key );
        return type.cast( p );
    }



    public void setProperty(
                    final K key,
                    final EntityBase value
                    )
    {
        put( key, value );
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
        if (!(PropertyMap.class.isInstance( obj ))) {
            return false;
        }

        return super.equals( obj );
    }

}
// PropertyMap
