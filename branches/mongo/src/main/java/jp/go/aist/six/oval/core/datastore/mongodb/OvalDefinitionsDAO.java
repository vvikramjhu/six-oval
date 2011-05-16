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
import org.bson.types.ObjectId;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.dao.DAO;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalDefinitionsDAO
    extends BaseDAO<OvalDefinitions, ObjectId>
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
        StatesType  states = oval_definitions.getStates();
        if (states != null) {
            DAO<StateType, ObjectId>  dao = _getForwardingDAO( StateType.class );
            for (StateType  test : states.getState()) {
                dao.save( test );
            }
        }

        SystemObjectsType  objects = oval_definitions.getObjects();
        if (objects != null) {
            DAO<SystemObjectType, ObjectId>  dao = _getForwardingDAO( SystemObjectType.class );
            for (SystemObjectType  object : objects.getObject()) {
                dao.save( object );
            }
        }

        TestsType  tests = oval_definitions.getTests();
        if (tests != null) {
            DAO<TestType, ObjectId>  dao = _getForwardingDAO( TestType.class );
            for (TestType  test : tests.getTest()) {
                dao.save( test );
            }
        }

        DefinitionsType  definitions = oval_definitions.getDefinitions();
        if (definitions != null) {
            DAO<DefinitionType, ObjectId>  dao = _getForwardingDAO( DefinitionType.class );
            for (DefinitionType  definition : definitions.getDefinition()) {
                dao.save( definition );
            }
        }

        return super.save( oval_definitions );
    }

}
// OvalDefinitionsDAO

