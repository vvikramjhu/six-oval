package jp.go.aist.six.oval.core.datastore.mongodb;

import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;
import jp.go.aist.six.oval.model.v5.definitions.DefinitionsType;
import jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.v5.definitions.StateType;
import jp.go.aist.six.oval.model.v5.definitions.StatesType;
import jp.go.aist.six.oval.model.v5.definitions.SystemObjectType;
import jp.go.aist.six.oval.model.v5.definitions.SystemObjectsType;
import jp.go.aist.six.oval.model.v5.definitions.TestType;
import jp.go.aist.six.oval.model.v5.definitions.TestsType;
import jp.go.aist.six.oval.model.v5.definitions.VariableType;
import jp.go.aist.six.oval.model.v5.definitions.VariablesType;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.dao.DAO;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalDefinitionsDAO
    extends BaseDAO<OvalDefinitions, String>
{

    /**
     */
    public OvalDefinitionsDAO(
                    final Datastore ds
                    )
    {
        super( OvalDefinitions.class, ds );
    }



    //**************************************************************
    //  DAO
    //**************************************************************

    @Override
    public Key<OvalDefinitions> save(
                    final OvalDefinitions oval_definitions
                    )
    {
        VariablesType  variables = oval_definitions.getVariables();
        if (variables != null) {
            DAO<VariableType, String>  dao = _getForwardingDAO( VariableType.class );
            for (VariableType  variable : variables.getVariable()) {
                dao.save( variable );
            }
        }

        StatesType  states = oval_definitions.getStates();
        if (states != null) {
            DAO<StateType, String>  dao = _getForwardingDAO( StateType.class );
            for (StateType  state : states.getState()) {
                dao.save( state );
            }
        }

        SystemObjectsType  objects = oval_definitions.getObjects();
        if (objects != null) {
            DAO<SystemObjectType, String>  dao = _getForwardingDAO( SystemObjectType.class );
            for (SystemObjectType  object : objects.getObject()) {
                dao.save( object );
            }
        }

        TestsType  tests = oval_definitions.getTests();
        if (tests != null) {
            DAO<TestType, String>  dao = _getForwardingDAO( TestType.class );
            for (TestType  test : tests.getTest()) {
                dao.save( test );
            }
        }

        DefinitionsType  definitions = oval_definitions.getDefinitions();
        if (definitions != null) {
            DAO<DefinitionType, String>  dao = _getForwardingDAO( DefinitionType.class );
            for (DefinitionType  definition : definitions.getDefinition()) {
                dao.save( definition );
            }
        }

        //compute the digest!!!
        oval_definitions.getDefinitionsDigest();

        return super.save( oval_definitions );
    }

}
// OvalDefinitionsDAO

