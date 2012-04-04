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
import java.util.EnumMap;
import java.util.List;
import jp.go.aist.six.oval.model.OvalId;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.DefinitionsElement;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.StateType;
import jp.go.aist.six.oval.model.definitions.SystemObjectType;
import jp.go.aist.six.oval.model.definitions.TestType;
import jp.go.aist.six.oval.model.definitions.VariableType;
import jp.go.aist.six.oval.repository.OvalDefinitionRepository;
import jp.go.aist.six.oval.repository.DefinitionsElementQueryParams;
import jp.go.aist.six.oval.repository.OvalRepositoryException;
import jp.go.aist.six.oval.repository.QueryParams;



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


    public MongoOvalDatastore getDatastore()
    {
        return _datastore;
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
    throws OvalRepositoryException
    {
//        long  ts_start = System.currentTimeMillis();

        DefinitionType  p_object = null;
        try {
            p_object = _datastore.findById( DefinitionType.class, oval_id );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

//        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
        return p_object;
    }



    @Override
    public List<DefinitionType> findDefinition()
    throws OvalRepositoryException
    {
//        long  ts_start = System.currentTimeMillis();

        List<DefinitionType>  p_list = null;
        try {
            p_list = _datastore.find( DefinitionType.class );
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
    throws OvalRepositoryException
    {
//        long  ts_start = System.currentTimeMillis();

        List<DefinitionType>  p_list = null;
        try {
            p_list = _datastore.find( DefinitionType.class, params );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

//        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
        return p_list;
    }



    @Override
    public long countDefinition()
    throws OvalRepositoryException
    {
//        long  ts_start = System.currentTimeMillis();

        long  count = 0L;
        try {
            count = _datastore.count( DefinitionType.class );
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
    throws OvalRepositoryException
    {
        long  count = 0L;
        try {
            count = _datastore.count( DefinitionType.class, params );
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
    // entities (Definition, Test, Object, State, Variable)
    //==============================================================

    /**
     * OVAL entity type - Java class mapping.
     */
    private static EnumMap<OvalId.Type, Class<? extends DefinitionsElement>>  _TYPE_MAP_ =
                    new EnumMap<OvalId.Type, Class<? extends DefinitionsElement>>( OvalId.Type.class );

    static {
            _TYPE_MAP_.put( OvalId.Type.def, DefinitionType.class );
            _TYPE_MAP_.put( OvalId.Type.tst, TestType.class );
            _TYPE_MAP_.put( OvalId.Type.obj, SystemObjectType.class );
            _TYPE_MAP_.put( OvalId.Type.ste, StateType.class );
            _TYPE_MAP_.put( OvalId.Type.var, VariableType.class );
    }


    /**
     */
    private Class<? extends DefinitionsElement> _objectTypeOf(
                    final String oval_id
                    )
    throws OvalRepositoryException
    {
        Class<? extends DefinitionsElement>  objectType = null;

        try {
            OvalId  id = new OvalId( oval_id );
            OvalId.Type  id_type = id.getType();
            objectType = _TYPE_MAP_.get( id_type );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        if (objectType == null) {
            throw new OvalRepositoryException( "unknown OVAL entity type in OVAL-ID: " + oval_id );
        }

        return objectType;
    }



    /**
     */
    private Class<? extends DefinitionsElement> _objectTypeOf(
                    final DefinitionsElement.Type entity_type
                    )
    throws OvalRepositoryException
    {
        OvalId.Type  id_type = entity_type.getOvalIdType();
        Class<? extends DefinitionsElement>  objectType = _TYPE_MAP_.get( id_type );

        return objectType;
    }

//    private Class<? extends DefinitionsElement> _objectTypeOf(
//                    final OvalEntityType entity_type
//                    )
//    throws OvalRepositoryException
//    {
//        OvalId.Type  id_type = entity_type.idType();
//        Class<? extends DefinitionsElement>  objectType = _TYPE_MAP_.get( id_type );
//
//        return objectType;
//    }



//    /**
//     */
//    private Class<? extends OvalEntity> _objectTypeOf(
//                    final OvalEntity entity
//                    )
//    throws OvalRepositoryException
//    {
//        return _objectTypeOf( entity.getOvalID() );
//    }



    @Override
    public DefinitionsElement findEntityById(
                    final String oval_id
                    )
    throws OvalRepositoryException
    {
//        long  ts_start = System.currentTimeMillis();

        Class<? extends DefinitionsElement>  objectType = _objectTypeOf( oval_id );
        DefinitionsElement p_object = null;
        try {
            p_object = _datastore.findById( objectType, oval_id );
        } catch (OvalRepositoryException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

//        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
        return p_object;
    }



    @Override
    public List<DefinitionsElement> findEntity(
                    final QueryParams params
                    )
    throws OvalRepositoryException
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
                p_sub_list = _datastore.find( DefinitionType.class,   adjustedParams );
                p_list.addAll( p_sub_list );
                p_sub_list = _datastore.find( TestType.class,         adjustedParams );
                p_list.addAll( p_sub_list );
                p_sub_list = _datastore.find( SystemObjectType.class, adjustedParams );
                p_list.addAll( p_sub_list );
                p_sub_list = _datastore.find( StateType.class,        adjustedParams );
                p_list.addAll( p_sub_list );
                p_sub_list = _datastore.find( VariableType.class,     adjustedParams );
                p_list.addAll( p_sub_list );
            } else {
                adjustedParams.remove( DefinitionsElementQueryParams.Key.TYPE );
                Class<? extends DefinitionsElement>  objectType = _objectTypeOf( DefinitionsElement.Type.fromValue( type ) );
//                Class<? extends DefinitionsElement>  objectType = _objectTypeOf( OvalEntityType.valueOf( type ) );
                try {
                    p_sub_list = _datastore.find( objectType, adjustedParams );
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



    @Override
    public long countEntity(
                    final QueryParams params
                    )
    throws OvalRepositoryException
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
                p_sub_count = _datastore.count( DefinitionType.class,   adjustedParams );
                p_count += p_sub_count;
                p_sub_count = _datastore.count( TestType.class,         adjustedParams );
                p_count += p_sub_count;
                p_sub_count = _datastore.count( SystemObjectType.class, adjustedParams );
                p_count += p_sub_count;
                p_sub_count = _datastore.count( StateType.class,        adjustedParams );
                p_count += p_sub_count;
                p_sub_count = _datastore.count( VariableType.class,     adjustedParams );
                p_count += p_sub_count;
            } else {
                adjustedParams.remove( DefinitionsElementQueryParams.Key.TYPE );
                Class<? extends DefinitionsElement>  objectType = _objectTypeOf( DefinitionsElement.Type.fromValue( type ) );
//                Class<? extends DefinitionsElement>  objectType = _objectTypeOf( OvalEntityType.valueOf( type ) );
                try {
                    p_count = _datastore.count( objectType, adjustedParams );
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
    public String saveEntity(
                    final DefinitionsElement entity
                    )
    throws OvalRepositoryException
    {
//        @SuppressWarnings( "unchecked" )
//        Class<T>  objectType = (Class<T>)_objectTypeOf( entity );
        String  id = null;
        try {
            if (entity instanceof DefinitionType) {
                id = _datastore.save( DefinitionType.class, DefinitionType.class.cast( entity ) );
            } else if (entity instanceof TestType) {
                id = _datastore.save( TestType.class, TestType.class.cast( entity ) );
            } else if (entity instanceof TestType) {
                id = _datastore.save( SystemObjectType.class, SystemObjectType.class.cast( entity ) );
            } else if (entity instanceof StateType) {
                id = _datastore.save( StateType.class, StateType.class.cast( entity ) );
            } else if (entity instanceof VariableType) {
                id = _datastore.save( VariableType.class, VariableType.class.cast( entity ) );
            }
//            id = _datastore.save( objectType, entity );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return id;
    }

//    public  <T extends OvalEntity>
//    String saveEntity(
//                    final T entity
//                    )
//    throws OvalRepositoryException
//    {
////        long  ts_start = System.currentTimeMillis();
//
//        @SuppressWarnings( "unchecked" )
//        Class<T>  objectType = (Class<T>)_objectTypeOf( entity );
//        String  id = null;
//        try {
//            id = _datastore.save( objectType, entity );
//        } catch (Exception ex) {
//            throw new OvalRepositoryException( ex );
//        }
//
////        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
//        return id;
//    }


    // backup
//    @Override
//    public <T extends OvalEntity> String saveEntity(
//                    final T entity
//                    )
//    throws OvalRepositoryException
//    {
////        long  ts_start = System.currentTimeMillis();
//
//        @SuppressWarnings( "unchecked" )
//        Class<T>  objectType = (Class<T>)_objectTypeOf( entity );
//        String  id = null;
//        try {
//            id = _datastore.save( objectType, entity );
////            if (entity instanceof DefinitionType) {
////                id = _datastore.save( DefinitionType.class, (DefinitionType)entity );
////            } else if (entity instanceof TestType) {
////                id = _datastore.save( TestType.class, (TestType)entity );
////            } else if (entity instanceof SystemObjectType) {
////                id = _datastore.save( SystemObjectType.class, (SystemObjectType)entity );
////            } else if (entity instanceof StateType) {
////                id = _datastore.save( StateType.class, (StateType)entity );
////            } else if (entity instanceof VariableType) {
////                id = _datastore.save( VariableType.class, (VariableType)entity );
////            }
//        } catch (Exception ex) {
//            throw new OvalRepositoryException( ex );
//        }
//
////        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
//        return id;
//    }



//    @Override
//    public List<String> saveEntities(
//                    final OvalDefinitions oval_defs
//                    )
//    throws OvalRepositoryException
//    {
////        long  ts_start = System.currentTimeMillis();
//
//        List<String>  id_list = new ArrayList<String>();
//        try {
//            DefinitionsType  defs = oval_defs.getDefinitions();
//            if (defs != null) {
//                List<String>  def_id_list = _saveEntities( DefinitionType.class, defs.getDefinition() );
//                id_list.addAll( def_id_list );
//            }
//
//            TestsType  tests = oval_defs.getTests();
//            if (tests != null) {
//                List<String>  tst_id_list = _saveEntities( TestType.class, tests.getTest() );
//                id_list.addAll( tst_id_list );
//            }
//
//            SystemObjectsType  objects = oval_defs.getObjects();
//            if (objects != null) {
//                List<String>  obj_id_list = _saveEntities( SystemObjectType.class, objects.getObject() );
//                id_list.addAll( obj_id_list );
//            }
//
//            StatesType  states = oval_defs.getStates();
//            if (states != null) {
//                List<String>  ste_id_list = _saveEntities( StateType.class, states.getState() );
//                id_list.addAll( ste_id_list );
//            }
//
//            VariablesType  variables = oval_defs.getVariables();
//            if (variables != null) {
//                List<String>  var_id_list = _saveEntities( VariableType.class, variables.getVariable() );
//                id_list.addAll( var_id_list );
//            }
//        } catch (Exception ex) {
//            throw new OvalRepositoryException( ex );
//        }
//
////        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
//        return id_list;
//    }



    //==============================================================
    // OvalDefinitions
    //==============================================================

    @Override
    public OvalDefinitions findOvalDefinitionsById(
                    final String id
                    )
    throws OvalRepositoryException
    {
//        long  ts_start = System.currentTimeMillis();

        OvalDefinitions  p_object = null;
        try {
            p_object = _datastore.findById( OvalDefinitions.class, id );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

//        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
        return p_object;
    }



    protected <T extends DefinitionsElement> List<String> _saveEntities(
                    final Class<T> type,
                    final Collection<T> entity_list
                    )
    throws OvalRepositoryException
    {
        List<String>  id_list = new ArrayList<String>();
        for (T  entity : entity_list) {
            String  id = _datastore.save( type, entity );
            id_list.add( id );
        }

        return id_list;
    }



    @Override
    public String saveOvalDefinitions(
                    final OvalDefinitions oval_defs
                    )
    throws OvalRepositoryException
    {
//        long  ts_start = System.currentTimeMillis();

        String  id = null;
        try {
            id = _datastore.save( OvalDefinitions.class, oval_defs );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

//        _LOG_.info( "elapsed time (ms): " +  (System.currentTimeMillis() - ts_start) );
        return id;
    }

}
//MongoOvalDefinitionRepository
