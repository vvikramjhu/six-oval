/**
 * SIX OVAL - http://code.google.com/p/six-oval/
 * Copyright (C) 2010
 *   National Institute of Advanced Industrial Science and Technology (AIST)
 *   Registration Number: H22PRO-1124
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.go.aist.six.oval.core.repository.morphia;

import java.util.List;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.repository.OvalRepository;
import jp.go.aist.six.oval.repository.OvalRepositoryException;
import jp.go.aist.six.util.query.QueryParams;
import jp.go.aist.six.util.query.QueryResults;



/**
 * An implementation of OvalRepository using MongoDB.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class MongoOvalRepository
    extends MongoOvalDefinitionRepository
    implements OvalRepository
{

//    /**
//     * Logger.
//     */
//    private static final Logger  _LOG_ =
//        LoggerFactory.getLogger( MongoOvalDefinitionResultRepository.class );



    /**
     * Constructor.
     */
    public MongoOvalRepository()
    {
    }



    //**************************************************************
    //  OvalResultsRepository
    //**************************************************************

    public OvalResults findOvalResultsById(
                    final String id
                    )
    {
        OvalResults  p_object = null;
        try {
            p_object = getDatabase().findById( OvalResults.class, id );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return p_object;
    }



    public QueryResults<OvalResults> findOvalResults()
    {
        List<OvalResults>  p_list = null;
        try {
            p_list = getDatabase().find( OvalResults.class );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return new QueryResults<OvalResults>( p_list );
    }



    public QueryResults<OvalResults> findOvalResults(
                    final QueryParams params
                    )
    {
        List<OvalResults>  p_list = null;
        try {
            p_list = getDatabase().find( OvalResults.class, params );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return new QueryResults<OvalResults>( p_list );
    }



    public QueryResults<String> findOvalResultsId()
    {
        List<String>  list = null;
        try {
            list = getDatabase().findId( OvalResults.class );
//            keys = dao.findIds(); // this code does NOT work. why???
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return new QueryResults<String>( list );
    }



    public QueryResults<String> findOvalResultsId(
                    final QueryParams params
                    )
    {
        List<String>  p_list = null;
        try {
            p_list = getDatabase().findId( OvalResults.class, params );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return new QueryResults<String>( p_list );
    }



    public long countOvalResults()
    {
        long  count = 0L;
        try {
            count = getDatabase().count( OvalResults.class );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return count;
    }



    public long countOvalResults(
                    final QueryParams params
                    )
    {
        long  count = 0L;
        try {
            count = getDatabase().count( OvalResults.class, params );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return count;
    }



    public String saveOvalResults(
                    final OvalResults oval_results
                    )
    {
        String  id = null;
        try {
            id = getDatabase().save( OvalResults.class, oval_results );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return id;
    }



    //=====================================================================
    // OvalSystemCharacteristics
    //=====================================================================

    public OvalSystemCharacteristics findOvalSystemCharacteristicsById(
                    final String id
                    )
    {
        OvalSystemCharacteristics  p_object = null;
        try {
            p_object = getDatabase().findById( OvalSystemCharacteristics.class, id );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return p_object;
    }



    public QueryResults<OvalSystemCharacteristics> findOvalSystemCharacteristics()
    {
        List<OvalSystemCharacteristics>  p_list = null;
        try {
            p_list = getDatabase().find( OvalSystemCharacteristics.class );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return new QueryResults<OvalSystemCharacteristics>( p_list );
    }



    public QueryResults<OvalSystemCharacteristics> findOvalSystemCharacteristics(
                    final QueryParams params
                    )
    {
        List<OvalSystemCharacteristics>  p_list = null;
        try {
            p_list = getDatabase().find( OvalSystemCharacteristics.class, params );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return new QueryResults<OvalSystemCharacteristics>( p_list );
    }



    public QueryResults<String> findOvalSystemCharacteristicsId()
    {
        List<String>  list = null;
        try {
            list = getDatabase().findId( OvalSystemCharacteristics.class );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return new QueryResults<String>( list );
    }



    public QueryResults<String> findOvalSystemCharacteristicsId(
                    final QueryParams params
                    )
    {
        List<String>  p_list = null;
        try {
            p_list = getDatabase().findId( OvalSystemCharacteristics.class, params );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return new QueryResults<String>( p_list );
    }



    public long countOvalSystemCharacteristics()
    {
        long  count = 0L;
        try {
            count = getDatabase().count( OvalSystemCharacteristics.class );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return count;
    }



    public long countOvalSystemCharacteristics(
                    final QueryParams params
                    )
    {
        long  count = 0L;
        try {
            count = getDatabase().count( OvalSystemCharacteristics.class, params );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return count;
    }



    public String saveOvalSystemCharacteristics(
                    final OvalSystemCharacteristics oval_sc
                    )
    {
        String  id = null;
        try {
            id = getDatabase().save( OvalSystemCharacteristics.class, oval_sc );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return id;
    }

}
//
