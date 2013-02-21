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

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.google.code.morphia.dao.DAO;
import com.mongodb.Mongo;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class BaseDAO<T, K>
    extends BasicDAO<T, K>
{

    private DAORegistry  _registry;


    /**
     * Constructor.
     */
    public BaseDAO(
                    final Class<T> entityClass,
                    final Datastore ds
                    )
    {
        super( entityClass, ds );
    }


    public BaseDAO(
                    final Class<T> entityClass,
                    final Mongo mongo,
                    final Morphia morphia,
                    final String dbName
                    )
    {
        super( entityClass, mongo, morphia, dbName );
    }



    /**
     */
    public void setDAORegistry(
                    final DAORegistry registry
                    )
    {
        this._registry = registry;
    }



    /**
     */
    protected <S, J> DAO<S, J> _getForwardingDAO(
                    final Class<S> entityClass
                    )
    {
        if (this._registry != null) {
            return this._registry.getDAO( entityClass );
        }

        throw new IllegalArgumentException(
                        "unknown entity class: " + entityClass );
    }

}
//

