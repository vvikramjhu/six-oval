package jp.go.aist.six.oval.core.datastore.mongodb;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.google.code.morphia.dao.DAO;
import com.mongodb.Mongo;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class BaseDao<T, K>
    extends BasicDAO<T, K>
{

    private DAORegistry  _registry;


    /**
     * Constructor.
     */
    public BaseDao(
                    final Class<T> entityClass,
                    final Datastore ds
                    )
    {
        super( entityClass, ds );
    }


    public BaseDao(
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
// OvalDefinitionsDAO

