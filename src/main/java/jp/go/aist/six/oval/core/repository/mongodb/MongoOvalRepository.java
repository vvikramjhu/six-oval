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
import jp.go.aist.six.oval.model.OvalObject;
import jp.go.aist.six.oval.repository.OvalRepository;
import jp.go.aist.six.oval.repository.OvalRepositoryException;
import jp.go.aist.six.oval.repository.QueryResult;
import jp.go.aist.six.util.persist.Persistable;
import jp.go.aist.six.util.search.Binding;
import jp.go.aist.six.util.search.Limit;
import jp.go.aist.six.util.search.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.code.morphia.Key;
import com.google.code.morphia.dao.DAO;
import com.google.code.morphia.query.Query;



/**
 * An implementation of OvalRepository using MongoDB.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class MongoOvalRepository
    implements OvalRepository
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( MongoOvalRepository.class );



    /**
     * The data store sole instance.
     */
    private MongoDatastore  _datastore;




    /**
     * Constructor.
     */
    public MongoOvalRepository()
    {
    }



    /**
     */
    public void setDatastore(
                    final MongoDatastore datastore
                    )
    {
        _datastore = datastore;
    }



    /**
     */
    protected <K, T extends OvalObject & Persistable<K>>
    DAO<T, K> _getDAO( final Class<T> type )
    {
        return _datastore.getDAO( type );
    }



    /**
     * Converts Morphia Key<T> list to K, i.e. "_id", list.
     */
    private <K, T extends OvalObject & Persistable<K>>
    List<K> _keys2IDs(
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



    //**************************************************************
    //  OvalRepository
    //**************************************************************

    @Override
    public <K, T extends OvalObject & Persistable<K>>
    T get(
                    final Class<T> type,
                    final K id
                    )
    throws OvalRepositoryException
    {
        _LOG_.debug( "type=" + type + ", id=" + id );

        T  p_object = null;
        try {
            p_object = _getDAO( type ).get( id );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return p_object;
    }



    @Override
    public <K, T extends OvalObject & Persistable<K>>
    K create(
                    final Class<T> type,
                    final T object
                    )
    throws OvalRepositoryException
    {
        _LOG_.debug( "type=" + type + ", object=" + object );

        K  id = null;
        try {
            DAO<T, K>  dao = _getDAO( type );
            K  pid = object.getPersistentID();
            if (pid != null) {
                boolean  exists = dao.exists( "_id", pid );
                if (exists) {
                    throw new OvalRepositoryException( "object already persistent: ID=" + pid );
                }
            }

            dao.save( object );
            id = object.getPersistentID();
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return id;
    }



    @Override
    public <K, T extends OvalObject & Persistable<K>>
    T save(
                    final Class<T> type,
                    final T object
                    )
    throws OvalRepositoryException
    {
        _LOG_.debug( "type=" + type + ", object=" + object );

        try {
            _getDAO( type ).save( object );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return object;
    }



    @Override
    public <K, T extends OvalObject & Persistable<K>>
    QueryResult<T> find(
                    final Class<T> type
                    )
    throws OvalRepositoryException
    {
        _LOG_.debug( "type=" + type );

        List<T>  list = null;
        try {
            list = _getDAO( type ).find().asList();
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        _LOG_.debug( "#objects found: " + (list == null ? 0 : list.size()) );
        QueryResult<T>  result = new QueryResult<T>( list );

        return result;
    }



    @Override
    public <K, T extends OvalObject & Persistable<K>>
    QueryResult<T> find(
                    final Class<T> type,
                    final Binding filter
                    )
    throws OvalRepositoryException
    {
        _LOG_.debug( "type=" + type + ", filter: " + filter );

        List<T>  list = null;
        try {
            DAO<T, K>  dao = _getDAO( type );
            Query<T>  query = dao.createQuery();
            query = MorphiaQueryBuilder.build( query, filter );
            list = dao.find( query ).asList();
        } catch (OvalRepositoryException or_ex) {
            throw or_ex;
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        _LOG_.debug( "#objects found: " + (list == null ? 0 : list.size()) );
        QueryResult<T>  result = new QueryResult<T>( list );

        return result;
    }



    @Override
    public <K, T extends OvalObject & Persistable<K>>
    QueryResult<T> find(
                    final Class<T> type,
                    final Binding filter,
                    final List<? extends Order> ordering,
                    final Limit limit
                    )
    throws OvalRepositoryException
    {
        _LOG_.debug( "type=" + type + ", filter: " + filter
                        + ", ordering=" + ordering + ", limit=" + limit );

        List<T>  list = null;
        try {
            DAO<T, K>  dao = _getDAO( type );
            Query<T>  query = dao.createQuery();
            query = MorphiaQueryBuilder.build( query, filter, ordering, limit );
            list = dao.find( query ).asList();
        } catch (OvalRepositoryException or_ex) {
            throw or_ex;
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        _LOG_.debug( "#objects found: " + (list == null ? 0 : list.size()) );
        QueryResult<T>  result = new QueryResult<T>( list );

        return result;
    }



//    public <K, T extends OvalObject & Persistable<K>>
//    QueryResult<T> find(
//                    final Class<T> type,
//                    final QueryParams params
//                    )
//    throws OvalRepositoryException
//    {
//        _LOG_.debug( "type=" + type + ", params: " + params );
//
//        List<T>  list = null;
//        try {
//            DAO<T, K>  dao = _getDAO( type );
//            Query<T>  query = dao.createQuery();
//            _buildQuery( type, params, query );
//
//            list = dao.find( query ).asList();
//        } catch (Exception ex) {
//            throw new OvalRepositoryException( ex );
//        }
//
//        _LOG_.debug( "#objects found: " + (list == null ? 0 : list.size()) );
//        QueryResult<T>  result = new QueryResult<T>( list );
//
//        return result;
//    }


    //////
    public <K, T extends OvalObject & Persistable<K>>
    QueryResult<T> find(
                    final Class<T> type,
                    final QueryBuilder builder
                    )
    throws OvalRepositoryException
    {
        _LOG_.debug( "type=" + type );

        List<T>  list = null;
        try {
            DAO<T, K>  dao = _getDAO( type );
            Query<T>  query = dao.createQuery();
            query = builder.build( query );

            list = dao.find( query ).asList();
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        _LOG_.debug( "#objects found: " + (list == null ? 0 : list.size()) );
        QueryResult<T>  result = new QueryResult<T>( list );

        return result;
    }






    @Override
    public <K, T extends OvalObject & Persistable<K>>
    QueryResult<K> findIDs(
                    final Class<T> type
                    )
    throws OvalRepositoryException
    {
        _LOG_.debug( "type=" + type );

        List<Key<T>>  keys = null;
        try {
            keys = _getDAO( type ).find().asKeyList();
//            keys = dao.findIds(); // this code does NOT work. why???
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        _LOG_.debug( "#IDs found: " + keys.size() );
        QueryResult<K>  result = new QueryResult<K>( _keys2IDs( keys ) );

        return result;
    }


    @Override
    public <K, T extends OvalObject & Persistable<K>>
    QueryResult<K> findIDs(
                    final Class<T> type,
                    final Binding filter
                    )
    throws OvalRepositoryException
    {
        _LOG_.debug( "type=" + type + ", filter: " + filter );

        List<Key<T>>  keys = null;
        try {
            DAO<T, K>  dao = _getDAO( type );
            Query<T>  query = dao.createQuery();
            query = MorphiaQueryBuilder.build( query, filter );
            keys = dao.find( query ).asKeyList();
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        _LOG_.debug( "#IDs found: " + keys.size() );
        QueryResult<K>  result = new QueryResult<K>( _keys2IDs( keys ) );

        return result;
    }


    @Override
    public <K, T extends OvalObject & Persistable<K>>
    QueryResult<K> findIDs(
                    final Class<T> type,
                    final Binding filter,
                    final List<? extends Order> ordering,
                    final Limit limit
                    )
    throws OvalRepositoryException
    {
        _LOG_.debug( "type=" + type + ", filter: " + filter );

        List<Key<T>>  keys = null;
        try {
            DAO<T, K>  dao = _getDAO( type );
            Query<T>  query = dao.createQuery();
            query = MorphiaQueryBuilder.build( query, filter, ordering, limit );
            keys = dao.find( query ).asKeyList();
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        _LOG_.debug( "#IDs found: " + keys.size() );
        QueryResult<K>  result = new QueryResult<K>( _keys2IDs( keys ) );

        return result;
    }




    public <K, T extends OvalObject & Persistable<K>>
    QueryResult<K> findIDs(
                    final Class<T> type,
                    final QueryBuilder builder
                    )
    throws OvalRepositoryException
    {
        _LOG_.debug( "type=" + type );

        List<Key<T>>  keys = null;
        try {
            DAO<T, K>  dao = _getDAO( type );
            Query<T>  q = dao.createQuery();
            q = builder.build( q );

            keys = dao.find( q ).asKeyList();
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        List<K>  ids = _keys2IDs( keys );
        _LOG_.debug( "#IDs found: " + ids.size() );

        QueryResult<K>  result = new QueryResult<K>( ids );
        return result;
    }



    @Override
    public <K, T extends OvalObject & Persistable<K>>
    long count(
                    final Class<T> type
                    )
    throws OvalRepositoryException
    {
        _LOG_.debug( "type=" + type );

        long  count = 0;
        try {
            count = _getDAO( type ).count();
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        _LOG_.debug( "count: " + count );

        return count;
    }


    @Override
    public <K, T extends OvalObject & Persistable<K>>
    long count(
                    final Class<T> type,
                    final Binding filter
                    )
    throws OvalRepositoryException
    {
        _LOG_.debug( "type=" + type );

        long  count = 0;
        try {
            DAO<T, K>  dao = _getDAO( type );
            Query<T>  query = dao.createQuery();
            query = MorphiaQueryBuilder.build( query, filter );
            count = dao.count( query );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        _LOG_.debug( "count: " + count );

        return count;
    }



//    //==============================================================
//    // oval-def:definition
//    //==============================================================
//
//    /**
//     */
//    @Override
//    public DefinitionType getDefinition(
//                    final String oval_id,
//                    final int oval_version
//                    )
//    throws OvalRepositoryException
//    {
//        _LOG_.debug( "oval id=" + oval_id + ", version=" + oval_version );
//
//        DefinitionType  def = null;
//        try {
//            DAO<DefinitionType, String>  dao = _getDAO( DefinitionType.class );
//            Query<DefinitionType>  query = dao.createQuery();
//            query.filter( "oval_id", oval_id );
//            query.filter( "oval_version", oval_version );
//
//            def = dao.findOne( query );
//            if (def == null) {
//                _LOG_.debug( "no definition found: oval id=" + oval_id
//                                + ", version=" + oval_version);
//            }
//        } catch (Exception ex) {
//            throw new OvalRepositoryException( ex );
//        }
//
//        return def;
//    }
//
//
//
//    @Override
//    public DefinitionType getDefinition(
//                    final String oval_id
//                    )
//    throws OvalRepositoryException
//    {
//        _LOG_.debug( "oval ID: " + oval_id );
//
//        DefinitionType  def = null;
//        try {
//            DAO<DefinitionType, String>  dao = _getDAO( DefinitionType.class );
//            Query<DefinitionType>  query = dao.createQuery().filter( "oval_id", oval_id );
//            def = dao.findOne( query );
//
//            if (def == null) {
//                _LOG_.debug( "no definition found: oval ID=" + oval_id );
//            }
//        } catch (Exception ex) {
//            throw new OvalRepositoryException( ex );
//        }
//
//        return def;
//    }

}
// MongoOvalRepository

