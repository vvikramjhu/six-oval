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




    //**************************************************************
    //  OvalDefinitionRepository
    //**************************************************************

    //==============================================================
    // Definition
    //==============================================================

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
    public List<DefinitionType> findDefinition()
    {
//        long  ts_start = System.currentTimeMillis();

        List<DefinitionType>  p_list = null;
        try {
            p_list = _database.find( DefinitionType.class );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

//        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
        return p_list;
    }



    @Override
    public List<DefinitionType> findDefinition(
                    final QueryParams params
                    )
    {
//        long  ts_start = System.currentTimeMillis();

        List<DefinitionType>  p_list = null;
        try {
            p_list = _database.find( DefinitionType.class, params );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

//        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
        return p_list;
    }



    @Override
    public QueryResults<DefinitionType> findDefinitionByQuery(
                    final QueryParams params
                    )
    {
        List<DefinitionType>  p_list = null;
        try {
            p_list = _database.find( DefinitionType.class, params );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return _buildQueryResults( params, p_list );
    }



    @Override
    public List<String> findDefinitionId(
                    final QueryParams params
                    )
    {
        List<String>  p_list = null;
        try {
            p_list = _database.findId( DefinitionType.class, params );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return p_list;
    }



    @Override
    public long countDefinition()
    {
//        long  ts_start = System.currentTimeMillis();

        long  count = 0L;
        try {
            count = _database.count( DefinitionType.class );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

//        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
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



//    public String saveDefinition(
//                    final DefinitionType def
//                    )
//    throws OvalRepositoryException
//    {
//        String  p_id = null;
//        try {
//            p_id = _datastore.save( DefinitionType.class, def );
//        } catch (Exception ex) {
//            throw new OvalRepositoryException( ex );
//        }
//
//        return p_id;
//    }



    //==============================================================
    // definitions element (Definition, Test, Object, State, Variable)
    //==============================================================

//    /**
//     * OVAL entity type - Java class mapping.
//     */
//    private static EnumMap<OvalId.Type, Class<? extends DefinitionsElement>>  _TYPE_MAP_ =
//                    new EnumMap<OvalId.Type, Class<? extends DefinitionsElement>>( OvalId.Type.class );
//
//    static {
//            _TYPE_MAP_.put( OvalId.Type.def, DefinitionType.class );
//            _TYPE_MAP_.put( OvalId.Type.tst, TestType.class );
//            _TYPE_MAP_.put( OvalId.Type.obj, SystemObjectType.class );
//            _TYPE_MAP_.put( OvalId.Type.ste, StateType.class );
//            _TYPE_MAP_.put( OvalId.Type.var, VariableType.class );
//    }


    /**
     */
//    private Class<? extends DefinitionsElement> _toObjectType(
//                    final String oval_id
//                    )
//    throws OvalRepositoryException
//    {
//        OvalId.Type  id_type = null;
//        try {
//            id_type = OvalId.typeOf( oval_id );
//        } catch (Exception ex) {
//            throw new OvalRepositoryException( ex );
//        }
//
//        return _toObjectType( id_type );
//    }



//    private Class<? extends DefinitionsElement> _toObjectType(
//                    final OvalId.Type type
//                    )
//    throws OvalRepositoryException
//    {
//        Class<? extends DefinitionsElement>  object_type = _TYPE_MAP_.get( type );
//        if (object_type == null) {
//            throw new OvalRepositoryException( "unknown OVAL-ID type: " + type );
//        }
//
//        return object_type;
//    }


//    private Class<? extends DefinitionsElement> _toObjectType(
//                    final DefinitionsElement.Type type
//                    )
//    throws OvalRepositoryException
//    {
//        return _toObjectType( type.getOvalIdType() );
//    }



    @Override
    public DefinitionsElement findElementById(
                    final String oval_id
                    )
    {
        Class<? extends DefinitionsElement>  objectType = EntityUtil.javaTypeOf( oval_id );
//        Class<? extends DefinitionsElement>  objectType = EntityUtil.objectTypeOf( oval_id );
//        Class<? extends DefinitionsElement>  objectType = _toObjectType( oval_id );
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
    public List<DefinitionsElement> findElement(
                    final QueryParams params
                    )
    {
//        long  ts_start = System.currentTimeMillis();

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
                Class<? extends DefinitionsElement>  objectType = EntityUtil.javaTypeOf( ElementType.fromValue( type ) );
//                Class<? extends DefinitionsElement>  objectType = EntityUtil.objectTypeOf( DefinitionsElement.Type.fromValue( type ) );
//                Class<? extends DefinitionsElement>  objectType = _toObjectType( DefinitionsElement.Type.fromValue( type ) );
                try {
                    p_sub_list = _database.find( objectType, adjustedParams );
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

//        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
        return p_list;
    }



    //TODO: How can we sort the result of elements obtained from multiple collections?

//    public List<String> findElementId(
//                    final QueryParams params
//                    )
//    throws OvalRepositoryException
//    {
//    }



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
                    final DefinitionsElement entity
                    )
    {
//        @SuppressWarnings( "unchecked" )
//        Class<T>  objectType = (Class<T>)_objectTypeOf( entity );
        String  id = null;
        try {
            if (entity instanceof DefinitionType) {
                id = _database.save( DefinitionType.class, DefinitionType.class.cast( entity ) );
            } else if (entity instanceof TestType) {
                id = _database.save( TestType.class, TestType.class.cast( entity ) );
            } else if (entity instanceof SystemObjectType) {
                id = _database.save( SystemObjectType.class, SystemObjectType.class.cast( entity ) );
            } else if (entity instanceof StateType) {
                id = _database.save( StateType.class, StateType.class.cast( entity ) );
            } else if (entity instanceof VariableType) {
                id = _database.save( VariableType.class, VariableType.class.cast( entity ) );
            }
//            id = _datastore.save( objectType, entity );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return id;
    }



    //==============================================================
    // OvalDefinitions
    //==============================================================

    @Override
    public OvalDefinitions findOvalDefinitionsById(
                    final String id
                    )
    {
//        long  ts_start = System.currentTimeMillis();

        OvalDefinitions  p_object = null;
        try {
            p_object = _database.findById( OvalDefinitions.class, id );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

//        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
        return p_object;
    }



    //TODO: Remove!
//    protected <T extends DefinitionsElement> List<String> _saveEntities(
//                    final Class<T> type,
//                    final Collection<T> entity_list
//                    )
//    throws OvalRepositoryException
//    {
//        List<String>  id_list = new ArrayList<String>();
//        for (T  entity : entity_list) {
//            String  id = _datastore.save( type, entity );
//            id_list.add( id );
//        }
//
//        return id_list;
//    }



    @Override
    public String saveOvalDefinitions(
                    final OvalDefinitions oval_defs
                    )
    {
//        long  ts_start = System.currentTimeMillis();

        String  id = null;
        try {
            id = _database.save( OvalDefinitions.class, oval_defs );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

//        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
        return id;
    }

}
//
