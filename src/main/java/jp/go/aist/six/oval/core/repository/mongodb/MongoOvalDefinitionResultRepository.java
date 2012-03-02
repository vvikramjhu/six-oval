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
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.repository.OvalRepositoryException;
import jp.go.aist.six.oval.repository.OvalResultRepository;
import jp.go.aist.six.oval.repository.QueryParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * An implementation of OvalRepository using MongoDB.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class MongoOvalDefinitionResultRepository
    extends MongoOvalDefinitionRepository
    implements OvalResultRepository
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( MongoOvalDefinitionResultRepository.class );



    /**
     * Constructor.
     */
    public MongoOvalDefinitionResultRepository()
    {
    }



    //**************************************************************
    //  OvalResultsRepository
    //**************************************************************

    @Override
    public OvalResults findOvalResultsById(
                    final String id
                    )
    throws OvalRepositoryException
    {
//        long  ts_start = System.currentTimeMillis();

        OvalResults  p_object = null;
        try {
            p_object = getDatastore().findById( OvalResults.class, id );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

//        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
        return p_object;
    }



    @Override
    public List<OvalResults> findOvalResults()
    throws OvalRepositoryException
    {
//        long  ts_start = System.currentTimeMillis();

        List<OvalResults>  p_list = null;
        try {
            p_list = getDatastore().find( OvalResults.class );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

//        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
        return p_list;
    }



    @Override
    public List<OvalResults> findOvalResults(
                    final QueryParams params
                    )
    throws OvalRepositoryException
    {
//        long  ts_start = System.currentTimeMillis();

        List<OvalResults>  p_list = null;
        try {
            p_list = getDatastore().find( OvalResults.class, params );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

//        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
        return p_list;
    }



    @Override
    public List<String> findOvalResultsIds()
    throws OvalRepositoryException
    {
//        long  ts_start = System.currentTimeMillis();

        List<String>  list = null;
        try {
            list = getDatastore().findIds( OvalResults.class );
//            keys = dao.findIds(); // this code does NOT work. why???
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

//        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
        return list;
    }



    @Override
    public List<String> findOvalResultsIds(
                    final QueryParams params
                    )
    throws OvalRepositoryException
    {
//        long  ts_start = System.currentTimeMillis();

        List<String>  p_list = null;
        try {
            p_list = getDatastore().findIds( OvalResults.class, params );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

//        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
        return p_list;
    }



    @Override
    public long countOvalResults()
    throws OvalRepositoryException
    {
//        long  ts_start = System.currentTimeMillis();

        long  count = 0L;
        try {
            count = getDatastore().count( OvalResults.class );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

//        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
        return count;
    }



    @Override
    public String saveOvalResults(
                    final OvalResults oval_results
                    )
    throws OvalRepositoryException
    {
//        long  ts_start = System.currentTimeMillis();

        String  id = null;
        try {
            id = getDatastore().save( OvalResults.class, oval_results );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

//        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
        return id;
    }

}
//
