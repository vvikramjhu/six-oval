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

package jp.go.aist.six.oval.core.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import jp.go.aist.six.oval.OvalException;
import jp.go.aist.six.oval.core.datastore.mongodb.MongoDatastore;
import jp.go.aist.six.oval.model.OvalObject;
import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;
import jp.go.aist.six.oval.repository.OvalRepository;
import jp.go.aist.six.oval.repository.QueryParams;
import jp.go.aist.six.oval.repository.QueryResult;
import jp.go.aist.six.util.persist.Persistable;
import jp.go.aist.six.util.persist.PersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.code.morphia.Key;
import com.google.code.morphia.dao.DAO;
import com.google.code.morphia.query.Query;



/**
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



    private final MongoQueryBuilder  _queryBuilder = new MongoQueryBuilder();



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



    //**************************************************************
    //  OvalRepository
    //**************************************************************

    @Override
    public <K, T extends OvalObject & Persistable<K>>
    T get(
                    final Class<T> type,
                    final K id
                    )
    throws OvalException
    {
        _LOG_.debug( "type=" + type + ", id=" + id );

        T  p_object = null;
        try {
            DAO<T, K>  dao = _datastore.getDAO( type );
            p_object = dao.get( id );
        } catch (PersistenceException ex) {
            throw new OvalException( ex );
        }

        return p_object;
    }



    @Override
    public <K, T extends OvalObject & Persistable<K>>
    K create(
                    final Class<T> type,
                    final T object
                    )
    throws OvalException
    {
        _LOG_.debug( "type=" + type + ", object=" + object );

        if (object instanceof Persistable) {
        } else {
            throw new OvalException( "object is not Persistable type: " + object.getClass() );
        }

        K  id = null;
        try {
            DAO<T, K>  dao = _datastore.getDAO( type );
            dao.save( object );
            id = object.getPersistentID();
        } catch (PersistenceException ex) {
            throw new OvalException( ex );
        }

        return id;
    }



    @Override
    public <K, T extends OvalObject & Persistable<K>>
    QueryResult<T> find(
                    final Class<T> type,
                    final QueryParams params
                    )
    throws OvalException
    {
        _LOG_.debug( "type=" + type + ", params: " + params );

        List<T>  list = null;
        try {
            DAO<T, String>  dao = _datastore.getDAO( type );
            Query<T>  q = dao.createQuery();
            _queryBuilder.buildQuery( q, params );

//            if (params != null) {
//                params.buildQuery( q );
//            }

            list = dao.find( q ).asList();
        } catch (Exception ex) {
            throw new OvalException( ex );
        }

        _LOG_.debug( "#objects found: " + (list == null ? 0 : list.size()) );
        QueryResult<T>  result = new QueryResult<T>( list );

        return result;
    }



    @Override
    public <K, T extends OvalObject & Persistable<K>>
    Collection<K> findIDs(
                    final Class<T> type
                    )
    throws OvalException
    {
        _LOG_.debug( "type=" + type );

        List<Key<T>>  keys = null;
        try {
            DAO<T, K>  dao = _datastore.getDAO( type );
            keys = dao.find().asKeyList(); //dao.findIds();
//            keys = dao.findIds();
        } catch (PersistenceException ex) {
            throw new OvalException( ex );
        }

        Collection<K>  ids = _keys2IDs( keys );
        _LOG_.debug( "#IDs found: " + ids.size() );

        return ids;

    }


    @Override
    public <K, T extends OvalObject & Persistable<K>>
    Collection<K> findIDs(
                    final Class<T> type,
                    final QueryParams params
                    )
    throws OvalException
    {
        _LOG_.debug( "type=" + type + ", params: " + params );

        List<Key<T>>  keys = null;
        try {
            DAO<T, String>  dao = _datastore.getDAO( type );
            Query<T>  q = dao.createQuery();
            _queryBuilder.buildQuery( q, params );

//            if (params != null) {
//                params.buildQuery( q );
//            }

            keys = dao.find( q ).asKeyList();
        } catch (Exception ex) {
            throw new OvalException( ex );
        }

        Collection<K>  ids = _keys2IDs( keys );
        _LOG_.debug( "#IDs found: " + ids.size() );

        return ids;
    }



    private <K, T extends OvalObject & Persistable<K>>
    Collection<K> _keys2IDs(
                    final Collection<Key<T>> keys
                    )
    throws OvalException
    {
        Collection<K>  ids = new ArrayList<K>();
        if (keys != null ) {
            for (Key<T>  key : keys) {
                @SuppressWarnings( "unchecked" )
                K  id = (K)key.getId();
                ids.add( id );
            }
        }

        return ids;
    }



    //==============================================================
    // oval_definitions
    //==============================================================



    //==============================================================
    // definition
    //==============================================================

    /**
     */
    @Override
    public DefinitionType getDefinition(
                    final String oval_id,
                    final String oval_version
                    )
    throws OvalException
    {
        _LOG_.debug( "oval id=" + oval_id + ", version=" + oval_version );

        DefinitionType  def = null;
        try {
            DAO<DefinitionType, String>  dao = _datastore.getDAO( DefinitionType.class );
            Query<DefinitionType>  q = dao.createQuery().filter( "oval_id", oval_id );

            if (oval_version == null  ||  "latest".equalsIgnoreCase( oval_version )) {
                q.order( "-oval_version" );
            } else {
                q.filter( "oval_version", Integer.valueOf( oval_version ) );
            }

            def = dao.findOne( q );
            if (def == null) {
                _LOG_.debug( "no definition found: oval id=" + oval_id );
            } else {
                _LOG_.debug( "definition found: persistent id=" + def.getPersistentID() );
            }
        } catch (Exception ex) {
            throw new OvalException( ex );
        }

        return def;
    }



    @Override
    public DefinitionType getLatestDefinition(
                    final String oval_id
                    )
    throws OvalException
    {
        _LOG_.debug( "oval id: " + oval_id );

        DefinitionType  def = null;
        try {
            DAO<DefinitionType, String>  dao = _datastore.getDAO( DefinitionType.class );
            Query<DefinitionType>  q = dao.createQuery().filter( "oval_id", oval_id ).order( "-oval_version" );

            def = dao.findOne( q );
            if (def == null) {
                _LOG_.debug( "no definition found: oval id=" + oval_id );
            } else {
                _LOG_.debug( "definition found: persistent id=" + def.getPersistentID() );
            }
        } catch (Exception ex) {
            throw new OvalException( ex );
        }

        return def;
    }



    //==============================================================
    // /oval_system_characteristics
    //==============================================================



    //==============================================================
    // Results
    //==============================================================

}
// MongoOvalRepository

