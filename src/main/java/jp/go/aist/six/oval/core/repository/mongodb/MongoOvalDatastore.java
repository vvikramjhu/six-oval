package jp.go.aist.six.oval.core.repository.mongodb;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import jp.go.aist.six.oval.repository.OvalRepositoryException;
import jp.go.aist.six.util.persist.Persistable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.code.morphia.dao.DAO;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.QueryResults;



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
    private final Map<Class<?>, DAO<?, ?>>  _daoMap =
        new HashMap<Class<?>, DAO<?, ?>>();



    /**
     * Constructor.
     */
    public MongoOvalDatastore()
    {
    }



    /**
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



    //**************************************************************
    //  DAORegistry
    //**************************************************************

    @Override
    public <T, K> DAO<T, K> getDAO(
                    final Class<T> entityClass
                    )
    {
        if (entityClass == null) {
            throw new IllegalArgumentException( "null entity class" );
        }

        @SuppressWarnings( "unchecked" )
        DAO<T, K>  dao = (DAO<T, K>)_daoMap.get( entityClass );
        if (dao == null) {
            throw new IllegalArgumentException(
                            "unknown entity class: " + entityClass );
        }

        return dao;
    }



    //**************************************************************

//    @PrePersist
//    public void prePersist(
//                    final OvalDefinitions oval_definitions
//                    )
//    {
//        DAO<TestType, ObjectId>  testDAO = getDAO( TestType.class );
//        TestsType  tests = oval_definitions.getTests();
//        if (tests != null) {
//            for (TestType  test : tests.getTest()) {
//                testDAO.save( test );
//            }
//        }
//    }



    //**************************************************************
    //  Datastore
    //**************************************************************

    /**
     */
    public <K, T extends Persistable<K>>
    T get(
                    final Class<T> type,
                    final K id
                    )
    throws OvalRepositoryException
    {
        _LOG_.debug( "type=" + type + ", id=" + id );

        T  p_object = null;
        try {
            p_object = getDAO( type ).get( id );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return p_object;
    }



    /**
     *
     * @param type
     * @param query
     * @return
     * @throws OvalRepositoryException
     */
    public <K, T extends Persistable<K>>
    QueryResults<T> find(
                    final Class<T> type
                    )
    throws OvalRepositoryException
    {
        _LOG_.debug( "type=" + type );

        QueryResults<T>  results = null;
        try {
            results = getDAO( type ).find();
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return results;
    }



    /**
     *
     * @param type
     * @param query
     * @return
     * @throws OvalRepositoryException
     */
    public <K, T extends Persistable<K>>
    QueryResults<T> find(
                    final Class<T> type,
                    final Query<T> query
                    )
    throws OvalRepositoryException
    {
        _LOG_.debug( "type=" + type + ", query=" + query );

        QueryResults<T>  results = null;
        try {
            results = getDAO( type ).find( query );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return results;
    }

}
//
