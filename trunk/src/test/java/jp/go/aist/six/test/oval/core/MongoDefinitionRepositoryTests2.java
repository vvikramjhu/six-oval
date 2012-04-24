package jp.go.aist.six.test.oval.core;

import java.util.List;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalDefinitionRepository;
import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.common.ClassEnumeration;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.DefinitionsElement;
import jp.go.aist.six.oval.repository.CommonQueryParams;
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
                                    "data:oval.def",
                                    "control:repository.findDefinition",
                                    "control:repository.countDefinition"
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
                                    "data:oval.def",
                                    "control:repository.findDefinitionById"
                                    },
                    dependsOnGroups={ "control:repository.findDefinition" },
                    dataProvider="data:oval.def.definition",
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
                                    "data:oval.def",
                                    "control:repository.queryDefinition"
                                    },
                    dependsOnGroups={ "control:repository.findDefinitionById" },
                    dataProvider="data:oval.repository.query_params.def.definition",
                    alwaysRun=true
                    )
    public void testFindAndCountDefinition(
                    final Class<DefinitionType>     object_type,
                    final DefinitionsElement.Type   type,
                    final QueryParams               params
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );
        Reporter.log( ">>> findDefinition(params)...", true );
        Reporter.log( "* object type: "     + object_type, true );
//        Reporter.log( "* type: "            + type, true );
        Reporter.log( "* params: "          + params, true );

        List<DefinitionType>  def_list = _getDefinitionRepository().findDefinition( params );
        Reporter.log( "<<< ...findDefinitionById(params)", true );
        Assert.assertNotNull( def_list );
        Reporter.log( "* #objects: " + def_list.size(), true );
        _printOvalIds( def_list );

        Reporter.log( ">>> countDefinition(params)...", true );
        long  count = _getDefinitionRepository().countDefinition( params );
        Reporter.log( "<<< ...countDefinition(params)", true );
        Reporter.log( "  @ #Definitions: " + count, true );

        Assert.assertTrue( def_list.size() == count );
    }



    ////////////////////////////////////////////////////////////////
    //  definitions element
    ////////////////////////////////////////////////////////////////

    /**
     * findElementById(oval_id): definition
     */
    @org.testng.annotations.Test(
                    groups={
                                    "java:oval.core.repository.mongodb",
                                    "data:oval.def",
                                    "control:repository.findElementById"
                                    },
                    dependsOnGroups={ "control:repository.queryDefinition" },
                    dataProvider="data:oval.def.element",
                    alwaysRun=true
                    )
    public void testFindElementById(
                    final OvalContentCategory       category,
                    final String                    schema_version,
                    final Class<DefinitionsElement> object_type,
                    final DefinitionsElement.Type   type,
                    final Family                    family,
                    final Component                 component,
                    final String                    oval_id,
                    final DefinitionsElement        expected_object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );
        Reporter.log( ">>> findElementById(oval_id)...", true );
        Reporter.log( "  * type: "       + type, true );
        Reporter.log( "  * family: "     + family, true );
        Reporter.log( "  * component: "  + component, true );
        Reporter.log( "  * oval_id: "    + oval_id, true );

        DefinitionsElement  element = _getDefinitionRepository().findElementById( oval_id );
        Reporter.log( "<<< ...findElementById(oval_id)", true );
        Reporter.log( "  @ element: " + element, true );
        Assert.assertNotNull( element );
        Assert.assertEquals( element.getOvalID(), oval_id );
    }



    /**
     * findElementById(oval_id): test, object, state, variable
     */
    @org.testng.annotations.Test(
                    groups={
                                    "java:oval.core.repository.mongodb",
                                    "data:oval.def",
                                    "control:repository.findElementById"
                                    },
                    dependsOnGroups={ "control:repository.queryDefinition" },
                    dataProvider="data:oval.def.definition",
                    alwaysRun=true
                    )
    public void testFindElementById(
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

        Reporter.log( ">>> findElementById(oval_id)...", true );
        Reporter.log( "  * type: "       + type, true );
        Reporter.log( "  * oval_id: "    + oval_id, true );

        DefinitionsElement  def = _getDefinitionRepository().findElementById( oval_id );
        Reporter.log( "<<< ...findElementById(oval_id)", true );
        Reporter.log( "  @ element: " + def, true );
        Assert.assertNotNull( def );
        Assert.assertEquals( def.getOvalID(), oval_id );
    }



    /**
     * findElement(params)
     */
    @org.testng.annotations.Test(
                    groups={
                                    "java:oval.core.repository.mongodb",
                                    "data:oval.def",
                                    "control.repository.queryElement"
                                    },
                    dependsOnGroups={ "control:repository.findElementById" },
                    dataProvider="data:oval.repository.query_params.def.element",
                    alwaysRun=true
                    )
    public void testFindAndCountElement(
                    final Class<? extends DefinitionsElement>   object_type,
                    final DefinitionsElement.Type               type,
                    final QueryParams                           params
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );
        Reporter.log( ">>> findElement(params)...", true );
        Reporter.log( "* object type: "     + object_type, true );
        Reporter.log( "* type: "            + type, true );
        Reporter.log( "* params: "          + params, true );

        List<DefinitionsElement>  element_list = _getDefinitionRepository().findElement( params );
        Reporter.log( "<<< ...findElementById(params)", true );
        Assert.assertNotNull( element_list );
        Reporter.log( "* #objects: " + element_list.size(), true );
        _printOvalIds( element_list );

        String  count_param = params.get( CommonQueryParams.Key.COUNT );
        //If the "count" param is specified, finxXxx() methods returns at most "count" objects.
        //And then, the number of results does not equal to the number returned from the countXxx() methods.
        if (count_param == null) {
            Reporter.log( ">>> countElement(params)...", true );
            long  count = _getDefinitionRepository().countElement( params );
            Reporter.log( "<<< ...countElement(params)", true );
            Reporter.log( "  @ #elements: " + count, true );

            Assert.assertTrue( element_list.size() == count );
        }
    }

}
//
