package jp.go.aist.six.test.oval.core;

import java.io.File;
import java.util.List;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalDefinitionRepository;
import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.common.ClassEnumeration;
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
import jp.go.aist.six.oval.repository.CommonQueryParams;
import jp.go.aist.six.oval.repository.QueryParams;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;



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

    /**
     * OVAL Definitions documents.
     *
     * Test method params:
     *   OvalContentCategory    category,
     *   String                 schema_version,
     *   Class<T>               object_type,
     *   Family                 family,
     *   String                 dirpath,
     *   String                 filename
     *   T                      expected_object
     */
    @DataProvider( name="DATA.oval.def.oval_definitions.repository.save-element" )
    public Object[][] provideOvalDefOvalDefinitionsRepositorySaveElement()
    {
        return new Object[][] {
//mitre repository//
                        {
                            OvalContentCategory.MITRE_REPOSITORY,
                            "5.10.1",
                            OvalDefinitions.class,
                            Family.WINDOWS,
                            "test/resources/mitre_repository/oval-5.10/def",
                            "oval-5.10.1_def-12953_CVE-2011-1987.xml",      //Windows, Excel vulnerability
                            null
                        }
        };

    }



    /**
     * OVAL Definitions documents.
     *
     * Test method params:
     *   OvalContentCategory    category,
     *   String                 schema_version,
     *   Class<T>               object_type,
     *   Family                 family,
     *   String                 dirpath,
     *   String                 filename
     *   T                      expected_object
     */
    @DataProvider( name="DATA.oval.def.oval_definitions.repository.save-oval-definitions" )
    public Object[][] provideOvalDefOvalDefinitionsRepositorySaveOvalDefinitions()
    {
        return new Object[][] {
//mitre repository//
                        {
                            OvalContentCategory.MITRE_REPOSITORY,
                            "5.10.1",
                            OvalDefinitions.class,
                            Family.WINDOWS,
                            "test/resources/mitre_repository/oval-5.10/def",
                            "oval-5.10.1_def-14809_CVE-2011-4371.xml",      //Windows, Acrobat vulnerability
                            null
                        }
        };

    }



    ////////////////////////////////////////////////////////////////
    //  test methods
    ////////////////////////////////////////////////////////////////

    /**
     * findDefinition(), countDefinition()
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.def",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.repository.findDefinition",
                                    "CONTROL.oval.repository.countDefinition"
                                    },
                    dependsOnGroups={ "CONTROL.oval.core.repository.mongodb.datastore.save" },
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
                                    "MODEL.oval.def",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.repository.findDefinitionById"
                                    },
                    dependsOnGroups={ "CONTROL.oval.repository.findDefinition" },
                    dataProvider="DATA.oval.def.definition",
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
     * findDefinition(params), findDefinitionId(params), countDefinition(params)
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.def",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.repository.queryDefinition"
                                    },
                    dependsOnGroups={ "CONTROL.oval.repository.findDefinitionById" },
                    dataProvider="DATA.oval.repository.query_params.def.definition",
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
        Reporter.log( "  * params: "          + params, true );

        List<DefinitionType>  def_list = _getDefinitionRepository().findDefinition( params );
        Reporter.log( "<<< ...findDefinition(params)", true );
        Assert.assertNotNull( def_list );
        Reporter.log( "  @ #Definition: " + def_list.size(), true );
        _printOvalIds( def_list );


        Reporter.log( ">>> findDefinitionId(params)...", true );
        Reporter.log( "  * params: "          + params, true );

        List<String>  def_id_list = _getDefinitionRepository().findDefinitionId( params );
        Reporter.log( "<<< ...findDefinitionId(params)", true );
        Assert.assertNotNull( def_id_list );
        Reporter.log( "  @ #IDs: " + def_id_list.size(), true );

        Assert.assertEquals( def_list.size(), def_id_list.size() );


        String  count_param = params.get( CommonQueryParams.Key.COUNT );
        //If the "count" param is specified, finxXxx() methods returns at most "count" objects.
        //And then, the number of results does not equal to the number returned from the countXxx() methods.
        if (count_param == null) {
            Reporter.log( ">>> countDefinition(params)...", true );
            long  count = _getDefinitionRepository().countDefinition( params );
            Reporter.log( "<<< ...countDefinition(params)", true );
            Reporter.log( "  @ #Definitions: " + count, true );

            Assert.assertEquals( def_list.size(), count );
        }
    }



    ////////////////////////////////////////////////////////////////
    //  definitions element
    ////////////////////////////////////////////////////////////////

    /**
     * findElementById(oval_id): definition
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.def",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.repository.findElementById"
                                    },
                    dependsOnGroups={ "CONTROL.oval.repository.queryDefinition" },
                    dataProvider="DATA.oval.def.element",
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
                                    "MODEL.oval.def",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.repository.findElementById"
                                    },
                    dependsOnGroups={ "CONTROL.oval.repository.queryDefinition" },
                    dataProvider="DATA.oval.def.definition",
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
                                    "MODEL.oval.def",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.repository.queryElement"
                                    },
                    dependsOnGroups={ "CONTROL.oval.repository.findElementById" },
                    dataProvider="DATA.oval.repository.query_params.def.element",
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



    /**
     * saveElement(element)
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.def",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.repository.saveElement"
                                    },
                    dependsOnGroups={ "CONTROL.oval.repository.queryElement" },
                    dataProvider="DATA.oval.def.oval_definitions.repository.save-element",
                    alwaysRun=true
                    )
    public void testSaveElement(
                    final OvalContentCategory   category,
                    final String                schema_version,
                    final Class<OvalDefinitions> object_type,
                    final Family                family,
                    final String                dirpath,
                    final String                xml_filepath,
                    final OvalDefinitions       expected_object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        File[]  files = _toXmlFileList( dirpath, xml_filepath );
        for (File  file : files) {
            Reporter.log( "  * file= " + file, true );
            OvalDefinitions  oval_defs = _unmarshalFromFile( object_type, file.getCanonicalPath(), expected_object );
            _saveElements( oval_defs );
        }
    }



    private void _saveElements(
                    final OvalDefinitions oval_definitions
                    )
    throws Exception
    {
        VariablesType  variables = oval_definitions.getVariables();
        if (variables != null) {
            for (VariableType  variable : variables.getVariable()) {
                _saveElement( variable, true );
            }
        }

        StatesType  states = oval_definitions.getStates();
        if (states != null) {
            for (StateType  state : states.getState()) {
                _saveElement( state, true );
            }
        }

        SystemObjectsType  objects = oval_definitions.getObjects();
        if (objects != null) {
            for (SystemObjectType  object : objects.getObject()) {
                _saveElement( object, true );
            }
        }

        TestsType  tests = oval_definitions.getTests();
        if (tests != null) {
            for (TestType  test : tests.getTest()) {
                _saveElement( test, true );
            }
        }

        DefinitionsType  definitions = oval_definitions.getDefinitions();
        if (definitions != null) {
            for (DefinitionType  definition : definitions.getDefinition()) {
                _saveElement( definition, true );
            }
        }

    }



    protected <K, T extends DefinitionsElement>
    void _saveElement(
                    final T         element,
                    final boolean   to_load
                    )
    throws Exception
    {
        Reporter.log( ">>> saveElement(element)...", true );

        String  oval_id = element.getOvalID();
        Reporter.log( "  * OVAL-ID: " + oval_id, true );

        String  p_oval_id = _getDefinitionRepository().saveElement( element );
        Reporter.log( "<<< ...saveElement(element)", true );
        Assert.assertEquals( p_oval_id, oval_id );

        if (to_load) {
            Reporter.log( ">>> findElementById(oval_id)...", true );
            DefinitionsElement  p_element = _getDefinitionRepository().findElementById( oval_id );
            Reporter.log( "<<< ...findElementById(oval_id)", true );
            p_oval_id = p_element.getOvalID();
            Reporter.log( "  @ OVAL-ID: " + p_oval_id, true );
            Assert.assertEquals( oval_id, p_oval_id );
            Assert.assertEquals( element.ovalGetElementType(), p_element.ovalGetElementType() );
        }
    }



    ////////////////////////////////////////////////////////////////
    //  OVAL Definitions document
    ////////////////////////////////////////////////////////////////

    /*
     * Saving and loading OVAL Definitions documents are tested in the super class MongoTests.
     */

    /**
     * saveOvalDefinitions(oval_defs)
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.def",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.repository.saveOvalDefinitions"
                                    },
                    dependsOnGroups={ "CONTROL.oval.repository.saveElement" },
                    dataProvider="DATA.oval.def.oval_definitions.repository.save-oval-definitions",
                    alwaysRun=true
                    )
    public void testSaveOvalDefinitions(
                    final OvalContentCategory   category,
                    final String                schema_version,
                    final Class<OvalDefinitions> object_type,
                    final Family                family,
                    final String                dirpath,
                    final String                xml_filepath,
                    final OvalDefinitions       expected_object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        File[]  files = _toXmlFileList( dirpath, xml_filepath );
        for (File  file : files) {
            Reporter.log( "  * file= " + file, true );
            OvalDefinitions  oval_defs = _unmarshalFromFile( object_type, file.getCanonicalPath(), expected_object );

            Reporter.log( ">>> saveOvalDefinitions(oval_defs)...", true );
            String  p_id = _getDefinitionRepository().saveOvalDefinitions( oval_defs );
            Reporter.log( "<<< ...saveOvalDefinitions(oval_defs)", true );
            Reporter.log( "  @ ID: " + p_id, true );
            Assert.assertNotNull( p_id );

            Reporter.log( ">>> findOvalDefinitionsById(id)...", true );
            OvalDefinitions  p_oval_defs = _getDefinitionRepository().findOvalDefinitionsById( p_id );
            Reporter.log( "<<< ...findOvalDefinitionsById(id)", true );
            String  p_id2 = p_oval_defs.getPersistentID();
            Reporter.log( "  @ OVAL Definitions doc: " + p_oval_defs, true );
            Assert.assertEquals( p_id, p_id2 );

            String    digest =   oval_defs.getDefinitionsDigest();
            String  p_digest = p_oval_defs.getDefinitionsDigest();
            Assert.assertEquals( digest, p_digest );
        }
    }

}
//
