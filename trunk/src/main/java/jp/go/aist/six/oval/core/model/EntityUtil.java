package jp.go.aist.six.oval.core.model;

import java.util.Collection;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;
import jp.go.aist.six.oval.OvalException;
import jp.go.aist.six.oval.model.ElementContainer;
import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.OvalId;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.DefinitionsElement;
import jp.go.aist.six.oval.model.definitions.DefinitionsType;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.StateType;
import jp.go.aist.six.oval.model.definitions.StatesType;
import jp.go.aist.six.oval.model.definitions.SystemObjectType;
import jp.go.aist.six.oval.model.definitions.SystemObjectsType;
import jp.go.aist.six.oval.model.definitions.TestType;
import jp.go.aist.six.oval.model.definitions.TestsType;
import jp.go.aist.six.oval.model.definitions.VariableType;
import jp.go.aist.six.oval.model.definitions.VariablesType;
import jp.go.aist.six.oval.repository.OvalRepositoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public final class EntityUtil
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( EntityUtil.class );



    /**
     */
    public static boolean containsElement(
                    final OvalDefinitions oval_defs,
                    final String oval_id
                    )
    throws OvalException
    {
        DefinitionsElement.Type  element_type = DefinitionsElement.Type.fromOvalId( oval_id );
        ElementContainer<? extends DefinitionsElement>  container = null;
        if (element_type == DefinitionsElement.Type.DEFINITION) {
            container = oval_defs.getDefinitions();
        } else if (element_type == DefinitionsElement.Type.TEST) {
            container = oval_defs.getTests();
        } else if (element_type == DefinitionsElement.Type.OBJECT) {
            container = oval_defs.getObjects();
        } else if (element_type == DefinitionsElement.Type.STATE) {
            container = oval_defs.getStates();
        } else if (element_type == DefinitionsElement.Type.VARIABLE) {
            container = oval_defs.getVariables();
        }

        if (container == null) {
            return false;
        }

        return container.containsOvalId( oval_id );
    }



    /**
     */
    public static boolean addElement(
                    final OvalDefinitions oval_defs,
                    final DefinitionsElement element
                    )
    throws OvalException
    {
        DefinitionsElement.Type  element_type = element.ovalGetElementType();

        boolean  added = false;
        if (element_type == DefinitionsElement.Type.DEFINITION) {
            DefinitionsType  definitions = oval_defs.getDefinitions();
            if (definitions == null) {
                definitions = new DefinitionsType();
                oval_defs.setDefinitions( definitions );
            }
            added = definitions.addDefinition( toDefinition( element ) );

        } else if (element_type == DefinitionsElement.Type.TEST) {
            TestsType  tests = oval_defs.getTests();
            if (tests == null) {
                tests = new TestsType();
                oval_defs.setTests( tests );
            }
            added = tests.addTest( toTest( element ) );

        } else if (element_type == DefinitionsElement.Type.OBJECT) {
            SystemObjectsType  objects = oval_defs.getObjects();
            if (objects == null) {
                objects = new SystemObjectsType();
                oval_defs.setObjects( objects );
            }
            added = objects.addObject( toObject( element ) );

        } else if (element_type == DefinitionsElement.Type.STATE) {
            StatesType  states = oval_defs.getStates();
            if (states == null) {
                states = new StatesType();
                oval_defs.setStates( states );
            }
            added = states.addState( toState( element ) );

        } else if (element_type == DefinitionsElement.Type.VARIABLE) {
            VariablesType  variables = oval_defs.getVariables();
            if (variables == null) {
                variables = new VariablesType();
                oval_defs.setVariables( variables );
            }
            added = variables.addVariable( toVariable( element ) );
        }

        return added;
    }



    ///////////////////////////////////////////////////////////////////////
    //  type conversion
    ///////////////////////////////////////////////////////////////////////

    public static DefinitionType toDefinition(
                    final DefinitionsElement element
                    )
    {
        return DefinitionType.class.cast( element );
    }


    public static TestType toTest(
                    final DefinitionsElement element
                    )
    {
        return TestType.class.cast( element );
    }


    public static SystemObjectType toObject(
                    final DefinitionsElement element
                    )
    {
        return SystemObjectType.class.cast( element );
    }


    public static StateType toState(
                    final DefinitionsElement element
                    )
    {
        return StateType.class.cast( element );
    }


    public static VariableType toVariable(
                    final DefinitionsElement element
                    )
    {
        return VariableType.class.cast( element );
    }



    ///////////////////////////////////////////////////////////////////////
    //  type mapping
    ///////////////////////////////////////////////////////////////////////

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
    public static Class<? extends DefinitionsElement> objectTypeOf(
                    final String oval_id
                    )
    throws OvalException
    {
        OvalId.Type  id_type = null;
        try {
            id_type = OvalId.typeOf( oval_id );
        } catch (Exception ex) {
            throw new OvalRepositoryException( ex );
        }

        return objectTypeOf( id_type );
    }



    public static Class<? extends DefinitionsElement> objectTypeOf(
                    final OvalId.Type id_type
                    )
    throws OvalException
    {
        Class<? extends DefinitionsElement>  object_type = _TYPE_MAP_.get( id_type );
        if (object_type == null) {
            throw new OvalRepositoryException( "unknown OVAL-ID type: " + id_type );
        }

        return object_type;
    }



    public static Class<? extends DefinitionsElement> objectTypeOf(
                    final DefinitionsElement.Type type
                    )
    throws OvalRepositoryException
    {
        return objectTypeOf( type.getOvalIdType() );
    }



    ///////////////////////////////////////////////////////////////////////
    //  reference
    ///////////////////////////////////////////////////////////////////////

    /**
     */
    public static Collection<String> getElementRefId(
                    final DefinitionsElement element
                    )
    {
        _LOG_.debug( "OVAL ID: " + element.getOvalID() );
        Set<String>  ids = new HashSet<String>();
        Collection<ElementRef>  ref_list = element.ovalGetElementRef();
        for (ElementRef  e : ref_list) {
            if (e == null) {
                continue;
            }
            String  id = e.ovalGetRefId();
            if (id != null  &&  id.length() > 0) {
                ids.add( id );
            }
        }

        _LOG_.debug( "referencing OVAL IDs: " + String.valueOf( ids ) );
        return ids;
    }



//    /**
//     */
//    public static Collection<String> collectVariableId(
//                    final EntityAttributeGroup[] entity_list
//                    )
//    {
//        Set<String>  ids = new HashSet<String>();
//
//        if (entity_list == null  ||  entity_list.length == 0) {
//            // Do nothing.
//        } else {
//            for (EntityAttributeGroup  e : entity_list) {
//                ids.add( e.getVarRef() );
//            }
//        }
//
//        return ids;
//    }

}
//

