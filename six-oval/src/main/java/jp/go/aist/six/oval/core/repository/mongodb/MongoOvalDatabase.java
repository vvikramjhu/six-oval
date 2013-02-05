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

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.go.aist.six.oval.model.OvalObject;
import jp.go.aist.six.oval.repository.CommonQueryParams;
import jp.go.aist.six.oval.repository.OvalDatabase;
import jp.go.aist.six.oval.repository.OvalRepositoryException;
import jp.go.aist.six.oval.repository.QueryParams;
import jp.go.aist.six.util.persist.Persistable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.code.morphia.Key;
import com.google.code.morphia.dao.DAO;
import com.google.code.morphia.query.Query;



/**
 * A MongoDB-based implementation of the OvalDatastore.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class MongoOvalDatabase
    implements OvalDatabase, DAORegistry
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( MongoOvalDatabase.class );



    /**
     * Class - DAO
     */
    private final Map<Class<?>, DAO<?, ?>>  _daoMap = new HashMap<Class<?>, DAO<?, ?>>();



    /**
     * Constructor.
     */
    public MongoOvalDatabase()
    {
    }



    /**
     * DAO list injection point.
     */
    public void setDAO(
                    final Collection<? extends DAO<?, ?>> daoList
                                    )
    {
        for (DAO<?, ?> dao : daoList) {
            if (dao == null) {
                continue;
            }

            Class<?>  entityClass = dao.getEntityClass();
            _LOG_.debug( "adding DAO: " + entityClass );
            _daoMap.put( entityClass, dao );

            if (dao instanceof BaseDAO) {
                BaseDAO.class.cast( dao ).setDAORegistry( this );
            }
        }
    }


//    private final void _startOperation(
//                    final String operation_name,
//                    final String message
//                    )
//    {
//        _LOG_.info( operation_name + ": " + message );
//    }
//
//
//    private final void _endOperation(
//                    final String operation_name,
//                    final long start_timestamp,
//                    final String message
//                    )
//    {
//        _LOG_.info( operation_name
//                        + ": elapsed time (ms)="
//                        +  (System.currentTimeMillis() - start_timestamp) );
//        _LOG_.debug( message );
//    }



    //*********************************************************************
    //  OvalDatastore
    //*********************************************************************

    @Override
    public <K, T extends Persistable<K> & OvalObject>
    T findById(
                    final Class<T> type,
                    final K id
                    )
    {
       _LOG_.info( "findById: type=" + type + ", ID=" + id );
       long  ts_start = System.currentTimeMillis();

       T  p_object = getDAO( type ).get( id );

       _LOG_.info( "findById: elapsed time (ms)=" +  (System.currentTimeMillis() - ts_start) );
       _LOG_.debug( (p_object == null ? "findById: object NOT found" : "findById: object found") );
       return p_object;
   }



    @Override
    public <K, T extends Persistable<K> & OvalObject>
    List<T> find(
                    final Class<T> type
                    )
    {
        return find( type, null );

//       _LOG_.info( "find: type=" + type );
//       long  ts_start = System.currentTimeMillis();
//
//       DAO<T, K>  dao = getDAO( type );
//       List<T>  list = dao.find().asList();
//
//       _LOG_.info( "find: elapsed time (ms)=" +  (System.currentTimeMillis() - ts_start) );
//       _LOG_.debug( "find: #objects=" + (list == null ? 0 : list.size()) );
//       return list;
    }



    @Override
    public <K, T extends Persistable<K> & OvalObject>
    List<T> find(
                    final Class<T> type,
                    final QueryParams params
                    )
    {
        _LOG_.info( "find: type=" + type + ", params=" + params );
        long ts_start = System.currentTimeMillis();

        DAO<T, K> dao = getDAO( type );
        List<T> list = null;
        if (params == null) {
            list = dao.find().asList();
        } else {
            Query<T> query = dao.createQuery();
            QueryBuilder builder = MongoQueryBuilder.createInstance( type, params );
            query = builder.build( query );
            _LOG_.debug( "query=" + query );
            list = dao.find( query ).asList();
        }

        _LOG_.info( "find: elapsed time (ms)="
                        + (System.currentTimeMillis() - ts_start) );
        _LOG_.debug( "find: #objects=: " + (list == null ? 0 : list.size()) );
        return list;
    }



    @Override
    public <K, T extends Persistable<K> & OvalObject>
    List<K> findId(
                    final Class<T> type
                    )
    {
        _LOG_.info( "findId: type=" + type );
        long ts_start = System.currentTimeMillis();

        DAO<T, K> dao = getDAO( type );
        List<Key<T>> list = dao.find().asKeyList();

        _LOG_.info( "findId: elapsed time (ms)="
                        + (System.currentTimeMillis() - ts_start) );
        _LOG_.debug( "findId: #IDs=: " + (list == null ? 0 : list.size()) );
        return MorphiaHelper.keys2Ids( list );
    }



    @Override
    public <K, T extends Persistable<K> & OvalObject>
    List<K> findId(
                    final Class<T> type,
                    final QueryParams params
                    )
    {
        _LOG_.debug( "findId: type=" + type + ", params=" + params );
        long ts_start = System.currentTimeMillis();

        DAO<T, K> dao = getDAO( type );
        List<Key<T>> list = null;
        if (params == null) {
            list = dao.find().asKeyList();
        } else {
            Query<T> query = dao.createQuery();
            QueryBuilder builder = MongoQueryBuilder.createInstance( type, params );
            query = builder.build( query );
            _LOG_.debug( "query=" + query );
            list = dao.find( query ).asKeyList();
        }

        _LOG_.info( "findId: elapsed time (ms)="
                        + (System.currentTimeMillis() - ts_start) );
        _LOG_.debug( "findId: #IDs=: " + (list == null ? 0 : list.size()) );
        return MorphiaHelper.keys2Ids( list );
    }



    @Override
    public <K, T extends Persistable<K> & OvalObject>
    long count(
                    final Class<T> type
                    )
    {
        _LOG_.info( "count: type=" + type );
        long ts_start = System.currentTimeMillis();

        DAO<T, K> dao = getDAO( type );
        long count = dao.count();

        _LOG_.info( "count: elapsed time (ms)="
                        + (System.currentTimeMillis() - ts_start) );
        _LOG_.debug( "count: count=" + count );
        return count;
    }



    @Override
    public <K, T extends Persistable<K> & OvalObject>
    long count(
                    final Class<T> type,
                    final QueryParams params
                    )
    {
        _LOG_.info( "count: type=" + type + ", params=" + params );
        long ts_start = System.currentTimeMillis();

        DAO<T, K> dao = getDAO( type );
        long count = 0L;
        if (params == null) {
            count = dao.count();
        } else {
            // NOTE: count() query ignores the "count" parameter.
            QueryParams adjusted_params = params;
            if (params.containsKey( CommonQueryParams.Key.COUNT )) {
                try {
                    adjusted_params = QueryParams.class.cast( params.clone() );
                } catch (CloneNotSupportedException ex) {
                    throw new OvalRepositoryException( ex );
                }

                adjusted_params.remove( CommonQueryParams.Key.COUNT );
            }

            Query<T> query = dao.createQuery();
            QueryBuilder builder = MongoQueryBuilder.createInstance( type, adjusted_params );
            query = builder.build( query );
            _LOG_.debug( "query=" + query );
            count = dao.count( query );
        }

        _LOG_.info( "count: elapsed time (ms)="
                        + (System.currentTimeMillis() - ts_start) );
        _LOG_.debug( "count: count=" + count );
        return count;
    }



    @Override
    public <K, T extends Persistable<K> & OvalObject>
    K save(
                    final Class<T> type,
                    final T object
                    )
    {
        _LOG_.info( "save: type=" + type );
        long ts_start = System.currentTimeMillis();

        Key<T> key = getDAO( type ).save( object );
        K id = MorphiaHelper.key2Id( key );

        _LOG_.info( "save: elapsed time (ms)="
                        + (System.currentTimeMillis() - ts_start) );
        _LOG_.info( "save: ID=" + id );
        return id;
   }



    @Override
    public <K, T extends Persistable<K> & OvalObject>
    void deleteById(
                    final Class<T> type,
                    final K id
                    )
    {
        _LOG_.info( "deleteById: type=" + type + ", ID=" + id );
        long ts_start = System.currentTimeMillis();

        getDAO( type ).deleteById( id );

        _LOG_.info( "deleteById: elapsed time (ms)="
                        + (System.currentTimeMillis() - ts_start) );
    }



    @Override
    public <K, T extends Persistable<K> & OvalObject>
    void delete(
                    final Class<T> type
                    )
    {
        _LOG_.debug( "delete: type=" + type );
        long ts_start = System.currentTimeMillis();

        /*
         * TODO: performance Is it possible to delete all the objects by query?
         * dao.deleteByQuery( Query q )
         */
        List<K> id_list = findId( type );
        DAO<T, K> dao = getDAO( type );
        for (K id : id_list) {
            dao.deleteById( id );
        }

        _LOG_.info( "delete: elapsed time (ms)="
                        + (System.currentTimeMillis() - ts_start) );
    }



    //**********************************************************************
    //  DAORegistry
    //**********************************************************************

    @Override
    public <T, K> DAO<T, K> getDAO(
                    final Class<T> objectType
                    )
    {
        if (objectType == null) {
            throw new IllegalArgumentException( "object type NOT specified (null)" );
        }

        @SuppressWarnings( "unchecked" )
        DAO<T, K> dao = (DAO<T, K>)_daoMap.get( objectType );
        if (dao == null) {
            throw new IllegalArgumentException( "unknown entity class: "
                            + objectType );
        }

        return dao;
    }

}
//
