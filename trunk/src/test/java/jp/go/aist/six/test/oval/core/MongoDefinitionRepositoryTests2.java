package jp.go.aist.six.test.oval.core;

import java.util.List;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalDefinitionRepository;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.common.ClassEnumeration;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.DefinitionsElement;
import jp.go.aist.six.oval.repository.QueryParams;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;



/**
 * Tests: OVAL Repository using MongoDB.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class MongoDefinitionRepositoryTests2
extends MongoTests
{

    private MongoOvalDefinitionRepository  _oval_def_repository;



    /**
     */
    @Override
    @BeforeClass( alwaysRun=true )
	public void setUp()
    throws Exception
	{
        super.setUp();

        _oval_def_repository = _getContext().getBean( "mongoOvalDefinitionRepository", MongoOvalDefinitionRepository.class );
	}



    protected MongoOvalDefinitionRepository _getDefinitionRepository()
    {
        return _oval_def_repository;
    }



    ////////////////////////////////////////////////////////////////
    //  test data
    ////////////////////////////////////////////////////////////////



    ////////////////////////////////////////////////////////////////
    //  test methods
    ////////////////////////////////////////////////////////////////

    /**
     * findDefinition(), countDefinition()
     */
    @org.testng.annotations.Test(
                    groups={
                                    "java:oval.core.repository.mongodb",
                                    "model:oval.def",
                                    "control:repository.find",
                                    "control:repository.count"
                                    },
                    dependsOnGroups={ "control:datastore.save" },
                    alwaysRun=true
                    )
    public void testFindAndCountDefinition()
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        Reporter.log( ">>> findDefinition()...", true );
        List<DefinitionType>  def_list = _getDefinitionRepository().findDefinition();
        Reporter.log( "<<< ...findDefinition()", true );
        Assert.assertNotNull( def_list );
        _printOvalIds( def_list );

        Reporter.log( ">>> countDefinition()...", true );
        long  count = _getDefinitionRepository().countDefinition();
        Reporter.log( "<<< ...countDefinition()", true );
        Reporter.log( "  @ #Definitions: " + count, true );

        Assert.assertTrue( def_list.size() == count );
    }



    /**
     * findDefinitionById(oval_id)
     */
    @org.testng.annotations.Test(
                    groups={
                                    "java:oval.core.repository.mongodb",
                                    "model:oval.def",
                                    "control:repository.findById"
                                    },
                    dependsOnGroups={ "control:repository.find" },
                    dataProvider="model:oval.def.definition",
                    alwaysRun=true
                    )
    public void testFindDefinitionById(
                    final OvalContentCategory       category,
                    final String                    schema_version,
                    final Class<DefinitionType>     object_type,
                    final DefinitionsElement.Type   type,
                    final ClassEnumeration          definition_class,
                    final Family                    family,
                    final String                    oval_id,
                    final DefinitionType            expected_object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        Reporter.log( ">>> findDefinitionById(oval_id)...", true );
        Reporter.log( "  * oval_id: " + oval_id, true );
        DefinitionType  def = _getDefinitionRepository().findDefinitionById( oval_id );
        Reporter.log( "<<< ...findDefinitionById(oval_id)", true );
        Assert.assertNotNull( def );
        Assert.assertEquals( def.getOvalID(), oval_id );
    }



    /**
     * findDefinition(params)
     */
    @org.testng.annotations.Test(
                    groups={
                                    "java:oval.core.repository.mongodb",
                                    "model:oval.def",
                                    "control:repository.query"
                                    },
                    dependsOnGroups={ "control:repository.findById" },
                    dataProvider="data:oval.repository.query_params.def",
                    alwaysRun=true
                    )
    public void testFindDefinition(
                    final Class<DefinitionType>     object_type,
                    final String                    schema_version,
                    final DefinitionsElement.Type   type,
                    final QueryParams               params
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );
        Reporter.log( ">>> findDefinition(params)...", true );
        Reporter.log( "* object type: "     + object_type, true );
        Reporter.log( "* schema version: "  + schema_version, true );
        Reporter.log( "* type: "            + type, true );
        Reporter.log( "* params: "          + params, true );

        List<DefinitionType>  def_list = _getDefinitionRepository().findDefinition( params );
        Reporter.log( "<<< ...findDefinitionById(params)", true );
        Assert.assertNotNull( def_list );
        Reporter.log( "* #objects: " + def_list.size(), true );
        _printOvalIds( def_list );
    }

}
//
