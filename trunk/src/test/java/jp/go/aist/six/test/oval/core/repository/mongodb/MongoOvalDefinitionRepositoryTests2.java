package jp.go.aist.six.test.oval.core.repository.mongodb;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalDefinitionRepository;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.common.ClassEnumeration;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.DefinitionsElement;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.repository.CommonQueryParams;
import jp.go.aist.six.oval.repository.DefinitionQueryParams;
import jp.go.aist.six.oval.repository.DefinitionsElementQueryParams;
import jp.go.aist.six.oval.repository.QueryParams;
import jp.go.aist.six.test.oval.core.OvalContentCategory;
import jp.go.aist.six.test.oval.core.OvalCoreTestBase;
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
public class MongoOvalDefinitionRepositoryTests2
extends OvalCoreTestBase
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
    //  support methods
    ////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////
    //  test data
    ////////////////////////////////////////////////////////////////

    /**
     * DefinitionsElement.
     *
     *  QueryParams               params,
     *  DefinitionsElement.Type[] types
     */
    @DataProvider( name="DATA.oval.repository.query_params.definitions_element" )
    public Object[][] provideRepositoryQueryParamsOvalDefDefinitionsElement()
    {
        // common: order, count
        DefinitionsElementQueryParams  params1 = new DefinitionsElementQueryParams();
        params1.setType( DefinitionsElement.Type.TEST.value() );
        params1.setOrder( "id" );
        params1.setCount( "3" );

        return new Object[][] {
                        {
                            params1,
                            new DefinitionsElement.Type[] { DefinitionsElement.Type.TEST }
                        }
        };
    }



    /**
     * Definition.
     *
     *  Class<DefinitionType>     object_type,
     *  DefinitionsElement.Type   type,
     *  QueryParams               params
     */
    @DataProvider( name="DATA.oval.repository.query_params.definition" )
    public Object[][] provideRepositoryQueryParamsOvalDefDefinition()
    {
        // common: order, count
        DefinitionQueryParams  params1 = new DefinitionQueryParams();
        params1.setOrder( "id" );
        params1.setCount( "3" );

        // common: order, count, startIndex
        DefinitionQueryParams  params2 = new DefinitionQueryParams();
        params2.setOrder( "id" );
        params2.setCount( "2" );
        params2.setStartIndex( "4" );

        // common: order, count, startIndex
        DefinitionQueryParams  params3 = new DefinitionQueryParams();
        params3.setOrder( "-id" );
        params3.setCount( "5" );

        // common: searchTerms, order
        DefinitionQueryParams  params4 = new DefinitionQueryParams();
        params4.setOrder( "id" );
        params4.setSearchTerms( "linux-def:s" );

        // common: searchTerms, order
        DefinitionQueryParams  params5 = new DefinitionQueryParams();
        params5.setOrder( "-id" );
        params5.setSearchTerms( "negate" );

        // element: version
        DefinitionQueryParams  params11 = new DefinitionQueryParams();
        params11.setVersion( "7" );

        // element: id
        DefinitionQueryParams  params12 = new DefinitionQueryParams();
        params12.setId( "oval:org.mitre.oval.test:def:889" );

        // element: id
        DefinitionQueryParams  params13 = new DefinitionQueryParams();
        params13.setId( "oval:org.mitre.oval.test:def:889,oval:org.mitre.oval.test:def:121,oval:org.mitre.oval.test:def:140" );

        // element: id
        DefinitionQueryParams  params14 = new DefinitionQueryParams();
        params14.setId( "oval:org.mitre.oval.test:def:1000" );

        // definition: definitionClass
        DefinitionQueryParams  params21 = new DefinitionQueryParams();
        params21.setDefinitionClass( "compliance" );

        // definition: family
        DefinitionQueryParams  params22 = new DefinitionQueryParams();
        params22.setFamily( "unix" );

        // definition: platform
        DefinitionQueryParams  params23 = new DefinitionQueryParams();
        params23.setPlatform( "Microsoft Windows XP" );

        // definition: product
        DefinitionQueryParams  params24 = new DefinitionQueryParams();
        params24.setProduct( "Mozilla Firefox,Mozilla Thunderbird" );

        // definition: refId
        DefinitionQueryParams  params25 = new DefinitionQueryParams();
        params25.setRefId( "CVE-2010-0176" );

        // definition: refSource
        DefinitionQueryParams  params26 = new DefinitionQueryParams();
        params26.setRefSource( "CPE" );

        // definition: cve
        DefinitionQueryParams  params27 = new DefinitionQueryParams();
        params27.setCve( "CVE-2010-*" );

        // definition: cve
        DefinitionQueryParams  params28 = new DefinitionQueryParams();
        params28.setCve( "CVE-2011-*,CVE-2010-0176" );

        return new Object[][] {
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params1
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params2
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params3
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params4
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params5
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params11
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params12
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params13
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params14
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params21
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params22
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params23
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params24
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params25
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params26
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params27
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params28
                        }
        };
    }




    ////////////////////////////////////////////////////////////////
    //  test methods
    ////////////////////////////////////////////////////////////////

    /**
     * saveOvalDefinitions(oval_defs), findOvalDefinitionsById(id)
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.def.oval_definitions",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.repository.saveOvalDefinitions",
                                    "CONTROL.oval.repository.findOvalDefinitionsById"
                                    }
//                    dependsOnGroups={ "CONTROL.oval.repository.saveElement" },
                    ,dataProvider="DATA.oval.def.oval_definitions"
                    ,alwaysRun=true
                    )
    public void testSaveOvalDefinitionsAndFindById(
                    final OvalContentCategory       category,
                    final String                    schema_version,
                    final Class<OvalDefinitions>    object_type,
                    final Family                    family,
                    final String                    dirpath,
                    final String                    xml_filepath,
                    final OvalDefinitions           expected_object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        File[]  files = _toXmlFileList( dirpath, xml_filepath );
        for (File  file : files) {
            Reporter.log( "  * file= " + file, true );
            OvalDefinitions  oval_defs = _unmarshalFromFile( object_type, file.getCanonicalPath(), expected_object );
            _printOvalIds( oval_defs.getDefinitions() );

            Reporter.log( ">>> saveOvalDefinitions(oval_defs)...", true );
            String  p_id = _getDefinitionRepository().saveOvalDefinitions( oval_defs );
            Reporter.log( "<<< ...saveOvalDefinitions(oval_defs)", true );
            Reporter.log( "  @ ID: " + p_id, true );
            Assert.assertNotNull( p_id );

            Reporter.log( ">>> findOvalDefinitionsById(id)...", true );
            OvalDefinitions  p_oval_defs = _getDefinitionRepository().findOvalDefinitionsById( p_id );
            Reporter.log( "<<< ...findOvalDefinitionsById(id)", true );
            String  p_id2 = p_oval_defs.getPersistentID();
            Reporter.log( "  @ OVAL Definitions found: " + p_oval_defs, true );
            Assert.assertEquals( p_id, p_id2 );
            _printOvalIds( p_oval_defs.getDefinitions() );

            String    digest =   oval_defs.getDefinitionsDigest();
            String  p_digest = p_oval_defs.getDefinitionsDigest();
            Assert.assertEquals( digest, p_digest );
        }
    }



    //**************************************************************
    //  oval-def:element
    //**************************************************************

    /**
     * findElement(params), countElement(params)
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.def.element",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.repository.findElementByQuery",
                                    "CONTROL.oval.repository.countElementByQuery"
                                    }
                    ,dependsOnGroups={ "CONTROL.oval.repository.saveOvalDefinitions" }
                    ,dataProvider="DATA.oval.repository.query_params.definitions_element"
//                    ,alwaysRun=true
                    )
    public void testFindElementAndCountElementByQuery(
                    final QueryParams               params,
                    final DefinitionsElement.Type[] types
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////", true );
        Reporter.log( ">>> findElement(params)...", true );
        Reporter.log( "  * params: " + params, true );

        List<DefinitionsElement>  element_list = _getDefinitionRepository().findElement( params );
        Reporter.log( "<<< ...findElement(params)", true );
        Assert.assertNotNull( element_list );
        Reporter.log( "  @ #Elements: " + element_list.size(), true );
        _printOvalIds( element_list );

        if (element_list.size() > 0) {
            Collection<DefinitionsElement.Type>  type_set = Arrays.asList( types );
            for (DefinitionsElement  e : element_list) {
                Assert.assertTrue( type_set.contains( e.ovalGetElementType() ) );
            }
        }


        String  count_param = params.get( CommonQueryParams.Key.COUNT );
        //If the "count" param is specified, finxXxx() methods returns at most "count" objects.
        //The countXxx() method ignore the "count" param.
        //And then, the number of results does not equal to the number returned from the countXxx() methods.
        if (count_param == null) {
            Reporter.log( ">>> countElement(params)...", true );
            long  count = _getDefinitionRepository().countElement( params );
            Reporter.log( "<<< ...countElement(params)", true );
            Reporter.log( "  @ #Elements: " + count, true );

            Assert.assertEquals( element_list.size(), count );
        }
    }



    //**************************************************************
    //  oval-def:definition
    //**************************************************************

    /**
     * findDefinition(), countDefinition()
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.def.definition",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.repository.findDefinition",
                                    "CONTROL.oval.repository.countDefinition"
                                    }
                    ,dependsOnGroups={ "CONTROL.oval.repository.saveOvalDefinitions" }
                    ,alwaysRun=true
                    )
    public void testFindDefinitionAndCount()
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

        Assert.assertEquals( def_list.size(), count );
    }



    /**
     * findDefinitionById(oval_id)
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.def.definition",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.repository.findDefinitionById"
                                    },
                    dependsOnGroups={ "CONTROL.oval.repository.findDefinition" }
                    ,dataProvider="DATA.oval.def.definition"
                    ,alwaysRun=true
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
                                    "MODEL.oval.def.definition",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.repository.findDefinitionByQuery"
                                    },
                    dependsOnGroups={ "CONTROL.oval.repository.findDefinitionById" },
                    dataProvider="DATA.oval.repository.query_params.definition",
                    alwaysRun=true
                    )
    public void testFindDefinitionAndCountByQuery(
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


}
//
