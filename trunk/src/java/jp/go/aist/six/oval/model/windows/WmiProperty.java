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

package jp.go.aist.six.oval.model.windows;

import jp.go.aist.six.oval.model.definitions.EntityBase;
import java.util.EnumMap;
import java.util.Iterator;



/**
 * The Windows WMI properties.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum WmiProperty
{
    NAMESPACE,  //EntityStateString
    WQL,        //EntityStateInt
    RESULT;     //EntityStateAnySimple/Wmi, EntityStateRecord/Wmi57



    /**
     */
    public static EntityMap createEntityMap()
    {
        return (new EntityMap());
    }



    /**
     */
    public static class EntityMap
    extends EnumMap<WmiProperty, EntityBase>
    {

        public EntityMap()
        {
            super( WmiProperty.class );
        }



        public Iterator<EntityBase> iterateProperties()
        {
            return values().iterator();
        }



        public <T extends EntityBase> T getProperty(
                        final WmiProperty key,
                        final Class<T> type
                        )
        {
            EntityBase  p = get( key );
            return type.cast( p );
        }



        public void setProperty(
                        final WmiProperty key,
                        final EntityBase value
                        )
        {
            put( key, value );
        }

    }
    //EntityMap

}
// WmiProperty
