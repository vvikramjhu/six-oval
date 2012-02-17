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

import java.util.List;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.repository.OvalDefinitionRepository;
import jp.go.aist.six.oval.repository.OvalRepositoryException;
import jp.go.aist.six.oval.repository.QueryParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * An implementation of OvalRepository using MongoDB.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class MongoOvalDefinitionRepository
    implements OvalDefinitionRepository
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( MongoOvalDefinitionRepository.class );



    private MongoOvalDatastore  _datastore;



    /**
     * Constructor.
     */
    public MongoOvalDefinitionRepository()
    {
    }




    /**
     *
     */
    public void setDatastore(
                    final MongoOvalDatastore datastore
                    )
    {
        _datastore = datastore;
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
        long  ts_start = System.currentTimeMillis();

        DefinitionType  p_object = null;
        try {
            p_object = _datastore.findById( DefinitionType.class, oval_id );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
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
        long  ts_start = System.currentTimeMillis();

        List<DefinitionType>  p_list = null;
        try {
            p_list = _datastore.find( DefinitionType.class );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
        return p_list;
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
        long  ts_start = System.currentTimeMillis();

        List<DefinitionType>  p_list = null;
        try {
            p_list = _datastore.find( DefinitionType.class, params );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
        return p_list;
    }

}
//
