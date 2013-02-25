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
import jp.go.aist.six.oval.repository.DefinitionsElementQueryParams;
import jp.go.aist.six.oval.repository.OvalDatabase;
import jp.go.aist.six.oval.repository.OvalDefinitionRepository;
import jp.go.aist.six.oval.repository.OvalRepositoryException;
import jp.go.aist.six.util.query.CommonQueryParams;
import jp.go.aist.six.util.query.QueryParams;
import jp.go.aist.six.util.query.QueryResults;



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



    private OvalDatabase  _database;



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
                    final OvalDatabase datastore
                    )
    {
        _database = datastore;
    }


    protected OvalDatabase _getDatabase()
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

    public DefinitionType findDefinitionById(
                    final String oval_id
                    )
    {
//        long  ts_start = System.currentTimeMillis();

        DefinitionType  p_object = null;
        try {
            p_object = _getDatabase().findById( DefinitionType.class, oval_id );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

//        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
        return p_object;
    }



    public QueryResults<DefinitionType> findDefinition()
    {
        List<DefinitionType>  p_list = null;
        try {
            p_list = _getDatabase().find( DefinitionType.class );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return new QueryResults<DefinitionType>( p_list );
//        return p_list;
    }



    public QueryResults<DefinitionType> findDefinition(
                    final QueryParams params
                    )
    {
        List<DefinitionType>  p_list = null;
        try {
            p_list = _getDatabase().find( DefinitionType.class, params );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return new QueryResults<DefinitionType>( p_list );
    }



    public QueryResults<String> findDefinitionId()
    {
        List<String>  p_list = null;
        try {
            p_list = _getDatabase().findId( DefinitionType.class );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return new QueryResults<String>( p_list );
    }



    public QueryResults<String> findDefinitionId(
                    final QueryParams params
                    )
    {
        List<String>  p_list = null;
        try {
            p_list = _getDatabase().findId( DefinitionType.class, params );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return new QueryResults<String>( p_list );
    }



    public long countDefinition()
    {
        long  count = 0L;
        try {
            count = _getDatabase().count( DefinitionType.class );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return count;
    }



    public long countDefinition(
                    final QueryParams params
                    )
    {
        long  count = 0L;
        try {
            count = _getDatabase().count( DefinitionType.class, params );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return count;
    }



    public String saveDefinition(
                    final DefinitionType def
                    )
    {
        String  p_id = null;
        try {
            p_id = _getDatabase().save( DefinitionType.class, def );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return p_id;
    }



    //=====================================================================
    // definitions element (Definition, Test, Object, State, Variable)
    //=====================================================================

    public DefinitionsElement findElementById(
                    final String oval_id
                    )
    {
        Class<? extends DefinitionsElement>  objectType = EntityUtil.javaTypeOf( oval_id );
        DefinitionsElement p_object = null;
        try {
            p_object = _getDatabase().findById( objectType, oval_id );
        } catch (OvalRepositoryException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return p_object;
    }



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
                p_sub_list = _getDatabase().find( DefinitionType.class,   adjustedParams );
                p_list.addAll( p_sub_list );
                p_sub_list = _getDatabase().find( TestType.class,         adjustedParams );
                p_list.addAll( p_sub_list );
                p_sub_list = _getDatabase().find( SystemObjectType.class, adjustedParams );
                p_list.addAll( p_sub_list );
                p_sub_list = _getDatabase().find( StateType.class,        adjustedParams );
                p_list.addAll( p_sub_list );
                p_sub_list = _getDatabase().find( VariableType.class,     adjustedParams );
                p_list.addAll( p_sub_list );
            } else {
                adjustedParams.remove( DefinitionsElementQueryParams.Key.TYPE );
                Class<? extends DefinitionsElement>  java_type = EntityUtil.javaTypeOf( ElementType.fromValue( type ) );
                try {
                    p_sub_list = _getDatabase().find( java_type, adjustedParams );
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
                p_sub_list = _getDatabase().findId( DefinitionType.class,   adjusted_params );
                p_list.addAll( p_sub_list );
                p_sub_list = _getDatabase().findId( TestType.class,         adjusted_params );
                p_list.addAll( p_sub_list );
                p_sub_list = _getDatabase().findId( SystemObjectType.class, adjusted_params );
                p_list.addAll( p_sub_list );
                p_sub_list = _getDatabase().findId( StateType.class,        adjusted_params );
                p_list.addAll( p_sub_list );
                p_sub_list = _getDatabase().findId( VariableType.class,     adjusted_params );
                p_list.addAll( p_sub_list );
            } else {
                adjusted_params.remove( DefinitionsElementQueryParams.Key.TYPE );
                Class<? extends DefinitionsElement>  java_type = EntityUtil.javaTypeOf( ElementType.fromValue( element_type ) );
                try {
                    p_list = _getDatabase().findId( java_type, adjusted_params );
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
                p_sub_count = _getDatabase().count( DefinitionType.class,   adjustedParams );
                p_count += p_sub_count;
                p_sub_count = _getDatabase().count( TestType.class,         adjustedParams );
                p_count += p_sub_count;
                p_sub_count = _getDatabase().count( SystemObjectType.class, adjustedParams );
                p_count += p_sub_count;
                p_sub_count = _getDatabase().count( StateType.class,        adjustedParams );
                p_count += p_sub_count;
                p_sub_count = _getDatabase().count( VariableType.class,     adjustedParams );
                p_count += p_sub_count;
            } else {
                adjustedParams.remove( DefinitionsElementQueryParams.Key.TYPE );
                Class<? extends DefinitionsElement>  objectType = EntityUtil.javaTypeOf( ElementType.fromValue( type ) );
//                Class<? extends DefinitionsElement>  objectType = EntityUtil.objectTypeOf( DefinitionsElement.Type.fromValue( type ) );
//                Class<? extends DefinitionsElement>  objectType = _toObjectType( DefinitionsElement.Type.fromValue( type ) );
                try {
                    p_count = _getDatabase().count( objectType, adjustedParams );
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



    public String saveElement(
                    final DefinitionsElement element
                    )
    {
        ElementType  type = element.ovalGetType();
        String  id = null;
        try {
            if (ElementType.DEFINITION == type) {
                id = _getDatabase().save(   DefinitionType.class,   DefinitionType.class.cast( element ) );
            } else if (ElementType.TEST == type) {
                id = _getDatabase().save(         TestType.class,         TestType.class.cast( element ) );
            } else if (ElementType.OBJECT == type) {
                id = _getDatabase().save( SystemObjectType.class, SystemObjectType.class.cast( element ) );
            } else if (ElementType.STATE == type) {
                id = _getDatabase().save(        StateType.class,        StateType.class.cast( element ) );
            } else if (ElementType.VARIABLE == type) {
                id = _getDatabase().save(     VariableType.class,     VariableType.class.cast( element ) );
            }
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return id;
    }



    //=====================================================================
    // OvalDefinitions
    //=====================================================================

    public OvalDefinitions findOvalDefinitionsById(
                    final String id
                    )
    {
        OvalDefinitions  p_object = null;
        try {
            p_object = _getDatabase().findById( OvalDefinitions.class, id );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return p_object;
    }



    public QueryResults<String> findOvalDefinitionsId()
    {
        List<String>  p_list = null;
        try {
            p_list = _getDatabase().findId( OvalDefinitions.class );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return new QueryResults<String>( p_list );
    }



    public QueryResults<String> findOvalDefinitionsId(
                    final QueryParams params
                    )
    {
        List<String>  p_list = null;
        try {
            p_list = _getDatabase().findId( OvalDefinitions.class, params );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return new QueryResults<String>( p_list );
    }



    public long countOvalDefinitions()
    {
        long  count = 0L;
        try {
            count = _getDatabase().count( OvalDefinitions.class );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return count;
    }



    public long countOvalDefinitions(
                    final QueryParams params
                    )
    {
        long  count = 0L;
        try {
            count = _getDatabase().count( DefinitionType.class, params );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return count;
    }



    public String saveOvalDefinitions(
                    final OvalDefinitions oval_defs
                    )
    {
        String  id = null;
        try {
            id = _getDatabase().save( OvalDefinitions.class, oval_defs );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return id;
    }

}
//
