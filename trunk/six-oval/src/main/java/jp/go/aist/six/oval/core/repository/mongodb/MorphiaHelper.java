/**
 * SIX OVAL - http://code.google.com/p/six-oval/
 * Copyright (C) 2010
 *   National Institute of Advanced Industrial Science and Technology (AIST)
 *   Registration Number: H22PRO-1124
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
     * Converts Morphia Key<T> to K, i.e. "_id".
     *
     * @throws  OvalRepositoryException
     */
    public static final <K, T extends Persistable<K>>
    K key2Id(
                    final Key<T> key
                    )
    {
        @SuppressWarnings( "unchecked" )
        K  id = (K)key.getId();
        return id;
    }



    /**
     * Converts Morphia Key<T> list to K, i.e. "_id", list.
     *
     * @throws  OvalRepositoryException
     */
    public static final <K, T extends Persistable<K>>
    List<K> keys2Ids(
                    final Collection<Key<T>> keys
                    )
    {
        List<K>  ids = new ArrayList<K>();
        if (keys != null ) {
            for (Key<T>  key : keys) {
                ids.add( key2Id( key ) );
            }
        }

        return ids;
    }

}
//

