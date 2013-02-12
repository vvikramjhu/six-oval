/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
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

package jp.go.aist.six.oval.core.repository.mongodb;

import java.util.ArrayList;
import java.util.List;
import jp.go.aist.six.oval.core.model.EntityUtil;
import jp.go.aist.six.oval.model.ElementType;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.DefinitionsElement;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.StateType;
import jp.go.aist.six.oval.model.definitions.SystemObjectType;
import jp.go.aist.six.oval.model.definitions.TestType;
import jp.go.aist.six.oval.model.definitions.VariableType;
import jp.go.aist.six.oval.repository.CommonQueryParams;
import jp.go.aist.six.oval.repository.DefinitionsElementQueryParams;
import jp.go.aist.six.oval.repository.OvalDefinitionRepository;
import jp.go.aist.six.oval.repository.OvalRepositoryException;
import jp.go.aist.six.oval.repository.QueryParams;
import jp.go.aist.six.oval.repository.QueryResults;



/**
 * An implementation of OvalRepository using MongoDB.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class MongoOvalDefinitionRepository
    implements OvalDefinitionRepository
{

//    /**
//     * Logger.
//     */
//    private static final Logger  _LOG_ =
//        LoggerFactory.getLogger( MongoOvalDefinitionRepository.class );



    private MongoOvalDatabase  _database;



    /**
     * Constructor.
     */
    public MongoOvalDefinitionRepository()
    {
    }



    /**
     *
     */
    public void setDatabase(
                    final MongoOvalDatabase datastore
                    )
    {
        _database = datastore;
    }


    public MongoOvalDatabase getDatabase()
    {
        return _database;
    }




    /**
     */
    protected static <T> QueryResults<T> _buildQueryResults(
                    final QueryParams params,
                    final List<T> elements
                    )
    {
        QueryResults<T>  r = _buildQueryResults( elements );

        if (params != null) {
            String  key = CommonQueryParams.Key.COUNT;
            if (params.containsKey( key )) {
                r.setItemsPerPage( (long)r.size() );
            }

            key = CommonQueryParams.Key.START_INDEX;
            if (params.containsKey( key )) {
                int  index = params.getAsInt( key );
                r.setStartIndex( (long)index );
            }
        }

        return r;
    }


    protected static <T> QueryResults<T> _buildQueryResults(
                    final List<T> elements
                    )
    {
        return new QueryResults<T>( elements );
    }




    //*********************************************************************
    //  implements OvalDefinitionRepository
    //*********************************************************************

    //=====================================================================
    // Definition
    //=====================================================================

    @Override
    public DefinitionType findDefinitionById(
                    final String oval_id
                    )
    {
//        long  ts_start = System.currentTimeMillis();

        DefinitionType  p_object = null;
        try {
            p_object = _database.findById( DefinitionType.class, oval_id );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

//        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
        return p_object;
    }



    @Override
    public QueryResults<DefinitionType> findDefinition()
    {
        List<DefinitionType>  p_list = null;
        try {
            p_list = _database.find( DefinitionType.class );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return new QueryResults<DefinitionType>( p_list );
//        return p_list;
    }



    @Override
    public QueryResults<DefinitionType> findDefinition(
                    final QueryParams params
                    )
    {
        List<DefinitionType>  p_list = null;
        try {
            p_list = _database.find( DefinitionType.class, params );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return new QueryResults<DefinitionType>( p_list );
    }



    @Override
    public QueryResults<String> findDefinitionId()
    {
        List<String>  p_list = null;
        try {
            p_list = _database.findId( DefinitionType.class );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return new QueryResults<String>( p_list );
    }



    @Override
    public QueryResults<String> findDefinitionId(
                    final QueryParams params
                    )
    {
        List<String>  p_list = null;
        try {
            p_list = _database.findId( DefinitionType.class, params );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return new QueryResults<String>( p_list );
    }



    @Override
    public long countDefinition()
    {
        long  count = 0L;
        try {
            count = _database.count( DefinitionType.class );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return count;
    }



    @Override
    public long countDefinition(
                    final QueryParams params
                    )
    {
        long  count = 0L;
        try {
            count = _database.count( DefinitionType.class, params );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return count;
    }



    @Override
    public String saveDefinition(
                    final DefinitionType def
                    )
    {
        String  p_id = null;
        try {
            p_id = _database.save( DefinitionType.class, def );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return p_id;
    }



    //=====================================================================
    // definitions element (Definition, Test, Object, State, Variable)
    //=====================================================================

    @Override
    public DefinitionsElement findElementById(
                    final String oval_id
                    )
    {
        Class<? extends DefinitionsElement>  objectType = EntityUtil.javaTypeOf( oval_id );
        DefinitionsElement p_object = null;
        try {
            p_object = _database.findById( objectType, oval_id );
        } catch (OvalRepositoryException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return p_object;
    }



    @Override
    public QueryResults<DefinitionsElement> findElement(
                    final QueryParams params
                    )
    {
        List<DefinitionsElement>  p_list = null;
        try {
            QueryParams  adjustedParams = null;
            if (params == null) {
                adjustedParams = new QueryParams();
            } else {
                adjustedParams = QueryParams.class.cast( params.clone() );
            }
            String  type = adjustedParams.get( DefinitionsElementQueryParams.Key.TYPE );

            List<? extends DefinitionsElement>  p_sub_list = null;
            if (type == null) {
                p_list = new ArrayList<DefinitionsElement>();
                p_sub_list = _database.find( DefinitionType.class,   adjustedParams );
                p_list.addAll( p_sub_list );
                p_sub_list = _database.find( TestType.class,         adjustedParams );
                p_list.addAll( p_sub_list );
                p_sub_list = _database.find( SystemObjectType.class, adjustedParams );
                p_list.addAll( p_sub_list );
                p_sub_list = _database.find( StateType.class,        adjustedParams );
                p_list.addAll( p_sub_list );
                p_sub_list = _database.find( VariableType.class,     adjustedParams );
                p_list.addAll( p_sub_list );
            } else {
                adjustedParams.remove( DefinitionsElementQueryParams.Key.TYPE );
                Class<? extends DefinitionsElement>  java_type = EntityUtil.javaTypeOf( ElementType.fromValue( type ) );
                try {
                    p_sub_list = _database.find( java_type, adjustedParams );
                    p_list = new ArrayList<DefinitionsElement>( p_sub_list );
                } catch (Exception ex) {
                    throw new OvalRepositoryException( ex );
                }
            }
        } catch (OvalRepositoryException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return new QueryResults<DefinitionsElement>( p_list );
    }



    //TODO: How can we sort the result of elements obtained from multiple collections?

//    public List<String> findElementId(
//                    final QueryParams params
//                    )
//    throws OvalRepositoryException
//    {
//    }



    @Override
    public QueryResults<String> findElementId(
                    final QueryParams params
                    )
    {
        List<String>  p_list = null;
        try {
            QueryParams  adjusted_params = null;
            if (params == null) {
                adjusted_params = new QueryParams();
            } else {
                adjusted_params = QueryParams.class.cast( params.clone() );
            }
            String  element_type = adjusted_params.get( DefinitionsElementQueryParams.Key.TYPE );

            if (element_type == null) {
                p_list = new ArrayList<String>();
                List<String>  p_sub_list = null;
                p_sub_list = _database.findId( DefinitionType.class,   adjusted_params );
                p_list.addAll( p_sub_list );
                p_sub_list = _database.findId( TestType.class,         adjusted_params );
                p_list.addAll( p_sub_list );
                p_sub_list = _database.findId( SystemObjectType.class, adjusted_params );
                p_list.addAll( p_sub_list );
                p_sub_list = _database.findId( StateType.class,        adjusted_params );
                p_list.addAll( p_sub_list );
                p_sub_list = _database.findId( VariableType.class,     adjusted_params );
                p_list.addAll( p_sub_list );
            } else {
                adjusted_params.remove( DefinitionsElementQueryParams.Key.TYPE );
                Class<? extends DefinitionsElement>  java_type = EntityUtil.javaTypeOf( ElementType.fromValue( element_type ) );
                try {
                    p_list = _database.findId( java_type, adjusted_params );
                } catch (Exception ex) {
                    throw new OvalRepositoryException( ex );
                }
            }
        } catch (OvalRepositoryException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return new QueryResults<String>( p_list );
    }




    @Override
    public long countElement(
                    final QueryParams params
                    )
    {
        long  p_count = 0L;
        try {
            QueryParams  adjustedParams = null;
            if (params == null) {
                adjustedParams = new QueryParams();
            } else {
                adjustedParams = QueryParams.class.cast( params.clone() );
            }
            String  type = adjustedParams.get( DefinitionsElementQueryParams.Key.TYPE );

            if (type == null) {
                long  p_sub_count = 0L;
                p_sub_count = _database.count( DefinitionType.class,   adjustedParams );
                p_count += p_sub_count;
                p_sub_count = _database.count( TestType.class,         adjustedParams );
                p_count += p_sub_count;
                p_sub_count = _database.count( SystemObjectType.class, adjustedParams );
                p_count += p_sub_count;
                p_sub_count = _database.count( StateType.class,        adjustedParams );
                p_count += p_sub_count;
                p_sub_count = _database.count( VariableType.class,     adjustedParams );
                p_count += p_sub_count;
            } else {
                adjustedParams.remove( DefinitionsElementQueryParams.Key.TYPE );
                Class<? extends DefinitionsElement>  objectType = EntityUtil.javaTypeOf( ElementType.fromValue( type ) );
//                Class<? extends DefinitionsElement>  objectType = EntityUtil.objectTypeOf( DefinitionsElement.Type.fromValue( type ) );
//                Class<? extends DefinitionsElement>  objectType = _toObjectType( DefinitionsElement.Type.fromValue( type ) );
                try {
                    p_count = _database.count( objectType, adjustedParams );
                } catch (Exception ex) {
                    throw new OvalRepositoryException( ex );
                }
            }
        } catch (OvalRepositoryException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

//        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
        return p_count;
    }



    @Override
    public String saveElement(
                    final DefinitionsElement element
                    )
    {
        ElementType  type = element.ovalGetType();
        String  id = null;
        try {
            if (ElementType.DEFINITION == type) {
                id = _database.save(   DefinitionType.class,   DefinitionType.class.cast( element ) );
            } else if (ElementType.TEST == type) {
                id = _database.save(         TestType.class,         TestType.class.cast( element ) );
            } else if (ElementType.OBJECT == type) {
                id = _database.save( SystemObjectType.class, SystemObjectType.class.cast( element ) );
            } else if (ElementType.STATE == type) {
                id = _database.save(        StateType.class,        StateType.class.cast( element ) );
            } else if (ElementType.VARIABLE == type) {
                id = _database.save(     VariableType.class,     VariableType.class.cast( element ) );
            }
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return id;
    }



    //=====================================================================
    // OvalDefinitions
    //=====================================================================

    @Override
    public OvalDefinitions findOvalDefinitionsById(
                    final String id
                    )
    {
        OvalDefinitions  p_object = null;
        try {
            p_object = _database.findById( OvalDefinitions.class, id );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return p_object;
    }



    @Override
    public QueryResults<String> findOvalDefinitionsId()
    {
        List<String>  p_list = null;
        try {
            p_list = _database.findId( OvalDefinitions.class );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return new QueryResults<String>( p_list );
    }



    @Override
    public QueryResults<String> findOvalDefinitionsId(
                    final QueryParams params
                    )
    {
        List<String>  p_list = null;
        try {
            p_list = _database.findId( OvalDefinitions.class, params );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return new QueryResults<String>( p_list );
    }



    @Override
    public long countOvalDefinitions()
    {
        long  count = 0L;
        try {
            count = _database.count( OvalDefinitions.class );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return count;
    }



    @Override
    public long countOvalDefinitions(
                    final QueryParams params
                    )
    {
        long  count = 0L;
        try {
            count = _database.count( DefinitionType.class, params );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return count;
    }



    @Override
    public String saveOvalDefinitions(
                    final OvalDefinitions oval_defs
                    )
    {
        String  id = null;
        try {
            id = _database.save( OvalDefinitions.class, oval_defs );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return id;
    }

}
//
