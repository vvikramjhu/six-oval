package jp.go.aist.six.oval.core.datastore.mongodb;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.code.morphia.dao.DAO;



public class MongoService
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( MongoService.class );



    /**
     * Class - DAO
     */
    private final Map<Class<?>, DAO<?, ?>>  _daoMap =
        new HashMap<Class<?>, DAO<?, ?>>();



    /**
     * Constructor.
     */
    public MongoService()
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
        DAO<T, K>  dao = (DAO<T, K>)_daoMap.get( entityClass );

        if (dao == null) {
            throw new IllegalArgumentException(
                            "unknown entity class: " + entityClass );
        }

        return dao;
    }




}
// MongoService
