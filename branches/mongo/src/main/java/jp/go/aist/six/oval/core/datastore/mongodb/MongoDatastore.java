package jp.go.aist.six.oval.core.datastore.mongodb;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.code.morphia.Key;
import com.google.code.morphia.dao.DAO;



public class MongoDatastore
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( MongoDatastore.class );



    /**
     * Class - DAO
     */
    private final Map<Class<?>, DAO<?, ?>>  _daoMapping =
        new HashMap<Class<?>, DAO<?, ?>>();



    /**
     * Constructor.
     */
    public MongoDatastore()
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
            _daoMapping.put( entityClass, dao );
        }
    }



    /**
     */
    public <T, K> DAO<T, K> getDAO(
                    final Class<T> entityClass
                    )
    {
        if (entityClass == null) {
            throw new IllegalArgumentException( "null entity class" );
        }

        @SuppressWarnings( "unchecked" )
        DAO<T, K>  dao = (DAO<T, K>)_daoMapping.get( entityClass );

        if (dao == null) {
            throw new IllegalArgumentException(
                            "unknown entity class: " + entityClass );
        }

        return dao;
    }



    //**************************************************************
    //  Datastore
    //**************************************************************

    public <T, K> Key<T> save(
                    final Class<T> type,
                    final T object
                    )
    {
        Key<T>  key = getDAO( type ).save( object );

        return key;
    }



}
// MongoDatastore
