package jp.go.aist.six.oval.core.repository.mongodb;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.go.aist.six.oval.core.ws.MongoWebQueryBuilder;
import jp.go.aist.six.oval.repository.QueryParams;
import jp.go.aist.six.util.persist.Persistable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.code.morphia.Key;
import com.google.code.morphia.dao.DAO;
import com.google.code.morphia.query.Query;



/**
 * A datastore for OVAL entities.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class MongoOvalDatastore
    implements DAORegistry
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( MongoOvalDatastore.class );



    /**
     * Class - DAO
     */
    private final Map<Class<?>, DAO<?, ?>>  _daoMap = new HashMap<Class<?>, DAO<?, ?>>();



    /**
     * Constructor.
     */
    public MongoOvalDatastore()
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


    ////////////////////////////////////////////////////////////////
    //  data access methods
    ////////////////////////////////////////////////////////////////

    /**
     *
     */
    public <K, T extends Persistable<K>>
    T findById(
                    final Class<T> type,
                    final K id
                    )
    {
       _LOG_.debug( "type=" + type + ", ID=" + id );

       T  p_object = getDAO( type ).get( id );

       _LOG_.debug( (p_object == null ? "object NOT found" : "object found") );
       return p_object;
   }



   /**
    */
   public <K, T extends Persistable<K>>
   List<T> find(
                   final Class<T> type
                   )
   {
       _LOG_.debug( "type=" + type );

       DAO<T, K>  dao = getDAO( type );
       List<T>  list = dao.find().asList();

       _LOG_.debug( "#objects found: " + (list == null ? 0 : list.size()) );
       return list;
   }



   /**
    */
   public <K, T extends Persistable<K>>
   List<T> find(
                   final Class<T> type,
                   final QueryParams params
                   )
   {
       _LOG_.debug( "type=" + type + ", params=" + params );

       DAO<T, K>  dao = getDAO( type );
       List<T>  list = null;
       if (params == null) {
           list = dao.find().asList();
       } else {
           Query<T>  query = dao.createQuery();
           QueryBuilder  builder = MongoWebQueryBuilder.createInstance( type, params );
           query = builder.build( query );
           _LOG_.debug( "query=" + query );
           list = dao.find( query ).asList();
       }

       _LOG_.debug( "#objects found: " + (list == null ? 0 : list.size()) );
       return list;
   }



   public <K, T extends Persistable<K>>
   List<K> findIds(
                   final Class<T> type
                   )
   {
       _LOG_.debug( "type=" + type );

       DAO<T, K>  dao = getDAO( type );
       List<Key<T>>  list = dao.find().asKeyList();

       _LOG_.debug( "#IDs found: " + (list == null ? 0 : list.size()) );
       return MorphiaHelper.keys2Ids( list );
   }



   public <K, T extends Persistable<K>>
   List<K> findIds(
                   final Class<T> type,
                   final QueryParams params
                   )
   {
       _LOG_.debug( "type=" + type + ", params=" + params );

       DAO<T, K>  dao = getDAO( type );
       List<Key<T>>  list = null;
       if (params == null) {
           list = dao.find().asKeyList();
       } else {
           Query<T>  query = dao.createQuery();
           QueryBuilder  builder = MongoWebQueryBuilder.createInstance( type, params );
           query = builder.build( query );
           _LOG_.debug( "query=" + query );
           list = dao.find( query ).asKeyList();
       }

       _LOG_.debug( "#IDs found: " + (list == null ? 0 : list.size()) );
       return MorphiaHelper.keys2Ids( list );
   }



   /**
    */
   public <K, T extends Persistable<K>>
   long count(
                   final Class<T> type
                   )
   {
       _LOG_.debug( "type=" + type );

       DAO<T, K>  dao = getDAO( type );
       long  count = dao.count();

       _LOG_.debug( "count: " + count );
       return count;
   }



   public <K, T extends Persistable<K>>
   K save(
                   final Class<T> type,
                   final T object
                   )
   {
      _LOG_.debug( "type=" + type );

      Key<T>  key = getDAO( type ).save( object );
      K  id = MorphiaHelper.key2Id( key );

      _LOG_.debug( "id: " + id );
      return id;
  }



   public <K, T extends Persistable<K>>
   void deleteById(
                   final Class<T> type,
                   final K id
                   )
   {
       _LOG_.debug( "type=" + type + ", ID=" + id );

      getDAO( type ).deleteById( id );
   }



   public <K, T extends Persistable<K>>
   void delete(
                   final Class<T> type
                   )
   {
       _LOG_.debug( "type=" + type );

       List<K>  id_list = findIds( type );
       DAO<T, K>  dao = getDAO( type );
       for (K  id : id_list) {
           dao.deleteById( id );
       }
   }





   //**************************************************************
   //  DAORegistry
   //**************************************************************

   @Override
   public <T, K> DAO<T, K> getDAO(
                   final Class<T> objectType
                   )
   {
       if (objectType == null) {
           throw new IllegalArgumentException( "object type NOT specified (null)" );
       }

       @SuppressWarnings( "unchecked" )
       DAO<T, K>  dao = (DAO<T, K>)_daoMap.get( objectType );
       if (dao == null) {
           throw new IllegalArgumentException(
                           "unknown entity class: " + objectType );
       }

       return dao;
   }

}
//
