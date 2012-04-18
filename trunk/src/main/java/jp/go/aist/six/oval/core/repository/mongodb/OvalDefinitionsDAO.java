package jp.go.aist.six.oval.core.repository.mongodb;

import jp.go.aist.six.oval.model.common.GeneratorType;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.DefinitionsType;
import jp.go.aist.six.oval.model.definitions.ElementReferencingMap;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.StateType;
import jp.go.aist.six.oval.model.definitions.StatesType;
import jp.go.aist.six.oval.model.definitions.SystemObjectType;
import jp.go.aist.six.oval.model.definitions.SystemObjectsType;
import jp.go.aist.six.oval.model.definitions.TestType;
import jp.go.aist.six.oval.model.definitions.TestsType;
import jp.go.aist.six.oval.model.definitions.VariableType;
import jp.go.aist.six.oval.model.definitions.VariablesType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.dao.DAO;
import com.google.code.morphia.query.Query;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalDefinitionsDAO
    extends BaseDAO<OvalDefinitions, String>
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( OvalDefinitionsDAO.class );



    /**
     */
    public OvalDefinitionsDAO(
                    final Datastore ds
                    )
    {
        super( OvalDefinitions.class, ds );
    }



    protected Key<OvalDefinitions> _findUniqueKey(
                    final OvalDefinitions oval_definitions
                    )
    {
        Query<OvalDefinitions>  q = createQuery();

        GeneratorType  generator = oval_definitions.getGenerator();
        q.filter( "generator.timestamp",      generator.getTimestamp() );
        q.filter( "generator.schema_version", generator.getSchemaVersion() );

        String  digest = oval_definitions.getDefinitionsDigest();
        q.filter( "definitions_digest", digest );

        _LOG_.debug( "find unique: query=" + q );
        Key<OvalDefinitions>  id = find( q ).getKey();
        _LOG_.debug( "find unique: id=" + id );

        return id;
    }



    //**************************************************************
    //  DAO
    //**************************************************************

    @Override
    public Key<OvalDefinitions> save(
                    final OvalDefinitions oval_definitions
                    )
    {
        Key<OvalDefinitions>  key = _findUniqueKey( oval_definitions );
        if (key != null) {
            oval_definitions.setPersistentID( String.valueOf( key.getId() ) );
            return key;
        }

        VariablesType  variables = oval_definitions.getVariables();
        if (variables != null) {
            DAO<VariableType, String>  dao = _getForwardingDAO( VariableType.class );
            for (VariableType  variable : variables.getVariable()) {
                variable.generator( oval_definitions.getGenerator() );
                dao.save( variable );
            }
        }

        StatesType  states = oval_definitions.getStates();
        if (states != null) {
            DAO<StateType, String>  dao = _getForwardingDAO( StateType.class );
            for (StateType  state : states.getState()) {
                state.generator( oval_definitions.getGenerator() );
                dao.save( state );
            }
        }

        SystemObjectsType  objects = oval_definitions.getObjects();
        if (objects != null) {
            DAO<SystemObjectType, String>  dao = _getForwardingDAO( SystemObjectType.class );
            for (SystemObjectType  object : objects.getObject()) {
                object.generator( oval_definitions.getGenerator() );
                dao.save( object );
            }
        }

        TestsType  tests = oval_definitions.getTests();
        if (tests != null) {
            DAO<TestType, String>  dao = _getForwardingDAO( TestType.class );
            for (TestType  test : tests.getTest()) {
                test.generator( oval_definitions.getGenerator() );
                dao.save( test );
            }
        }

        DefinitionsType  definitions = oval_definitions.getDefinitions();
        if (definitions != null) {
            DAO<DefinitionType, String>  dao = _getForwardingDAO( DefinitionType.class );
            DAO<ElementReferencingMap, String>  assoc_dao = _getForwardingDAO( ElementReferencingMap.class );
            for (DefinitionType  definition : definitions.getDefinition()) {
                definition.generator( oval_definitions.getGenerator() );
                dao.save( definition );

                //TODO: Move this to DefinitionDAO!!!
                ElementReferencingMap  assoc = new ElementReferencingMap( definition );
                assoc_dao.save( assoc );
            }
        }

        //compute the digest!!!
        oval_definitions.getDefinitionsDigest();

        return super.save( oval_definitions );
    }

}
// OvalDefinitionsDAO

