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

package jp.go.aist.six.oval.core.repository.mongodb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import jp.go.aist.six.oval.repository.OvalRepositoryException;
import jp.go.aist.six.util.persist.Persistable;
import com.google.code.morphia.Key;



/**
 * Some helper functions for Morphia.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class MorphiaHelper
{

//    /**
//     * Logger.
//     */
//    private static final Logger  _LOG_ =
//        LoggerFactory.getLogger( MorphiaHelper.class );



    /**
     * Constructor.
     */
    public MorphiaHelper()
    {
    }



    /**
     * Converts Morphia Key<T> list to K, i.e. "_id", list.
     */
    public static <K, T extends Persistable<K>>
    List<K> keys2IDs(
                    final Collection<Key<T>> keys
                    )
    throws OvalRepositoryException
    {
        List<K>  ids = new ArrayList<K>();
        if (keys != null ) {
            for (Key<T>  key : keys) {
                @SuppressWarnings( "unchecked" )
                K  id = (K)key.getId();
                ids.add( id );
            }
        }

        return ids;
    }

}
//

