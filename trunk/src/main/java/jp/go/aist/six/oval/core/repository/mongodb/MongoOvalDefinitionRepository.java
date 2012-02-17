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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.go.aist.six.oval.core.ws.MongoWebQueryBuilder;
import jp.go.aist.six.oval.model.OvalObject;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.repository.OvalDefinitionRepository;
import jp.go.aist.six.oval.repository.OvalRepositoryException;
import jp.go.aist.six.oval.repository.QueryParams;
import jp.go.aist.six.util.persist.Persistable;
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
public class MongoOvalDefinitionRepository
    implements OvalDefinitionRepository, DAORegistry
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( MongoOvalDefinitionRepository.class );



    /**
     * DAOs
     */
    private final Map<Class<?>, DAO<?, ?>>  _daoMap = new HashMap<Class<?>, DAO<?, ?>>();



    /**
     * Constructor.
     */
    public MongoOvalDefinitionRepository()
    {
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



    /**
     *
     */
    protected <K, T extends Persistable<K>>
    T _findObjectById(
                    final Class<T> type,
                    final K id
                    )
    throws OvalRepositoryException
    {
        _LOG_.debug( "type=" + type + ", ID=" + id );

        T  p_object = null;
        try {
            p_object = getDAO( type ).get( id );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        _LOG_.debug( "object ID= " + id + ": " + (p_object == null ? "NOT found" : "found") );
        return p_object;
    }



    /**
     * Retrieves the resources.
     */
    protected <K, T extends Persistable<K>>
    List<T> _findObject(
                    final Class<T> type,
                    final QueryParams params
                    )
    throws OvalRepositoryException
    {
        _LOG_.debug( "type=" + type + ", params=" + params );

        List<T>  list = null;
        try {
            DAO<T, K>  dao = getDAO( type );
            if (params == null) {
                list = dao.find().asList();
            } else {
                Query<T>  query = dao.createQuery();
                QueryBuilder  builder = MongoWebQueryBuilder.createInstance( type, params );
                query = builder.build( query );

                list = dao.find( query ).asList();
            }
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        _LOG_.debug( "#objects found: " + (list == null ? 0 : list.size()) );
        return list;
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
            throw new IllegalArgumentException( "entity class NOT specified (null)" );
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
    //  OvalDefinitionRepository
    //**************************************************************

    @Override
    public DefinitionType findDefinitionById(
                    final String oval_id
                    )
    throws OvalRepositoryException
    {
        DefinitionType  p_object = _findObjectById( DefinitionType.class, oval_id );

        return p_object;

    }



    /**
     * Returns all the Definitions.
     *
     * @return
     *  all the Definitions in the repository.
     */
    @Override
    public List<DefinitionType> findDefinition()
    throws OvalRepositoryException
    {
        List<DefinitionType>  list = _findObject( DefinitionType.class, null );

        return list;
    }



    /**
     * Searches for the OVAL Definitions that match the specified query parameters.
     *
     * @param   params
     *  the query parameters.
     * @return
     *  the Definitions.
     */
    @Override
    public List<DefinitionType> findDefinition(
                    final QueryParams params
                    )
    throws OvalRepositoryException
    {
        List<DefinitionType>  list = _findObject( DefinitionType.class, params );

        return list;
    }


}
//
