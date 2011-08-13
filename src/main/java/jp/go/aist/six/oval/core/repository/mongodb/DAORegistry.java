package jp.go.aist.six.oval.core.repository.mongodb;

import com.google.code.morphia.dao.DAO;



public interface DAORegistry
{

    /**
     */
    public <T, K> DAO<T, K> getDAO( Class<T> entityClass );

}
// DAORegistry
