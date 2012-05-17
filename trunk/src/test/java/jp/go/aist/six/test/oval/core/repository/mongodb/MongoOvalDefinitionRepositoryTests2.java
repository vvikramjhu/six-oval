package jp.go.aist.six.test.oval.core.repository.mongodb;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalDefinitionRepository;
import jp.go.aist.six.oval.model.Component;
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
        // order, count
        DefinitionsElementQueryParams  params01 = new DefinitionsElementQueryParams();
        params01.setType( DefinitionsElement.Type.TEST.value() );
        params01.setOrder( "id" );
        params01.setCount( "3" );

        // order, count, starIndex
        DefinitionsElementQueryParams  params02 = new DefinitionsElementQueryParams();
        params02.setType( DefinitionsElement.Type.TEST.value() );
        params02.setOrder( "id" );
        params02.setStartIndex( "3" );
        params02.setCount( "2" );

        // order, count
        DefinitionsElementQueryParams  params03 = new DefinitionsElementQueryParams();
        params03.setType( DefinitionsElement.Type.TEST.value() );
        params03.setOrder( "-id" );
        params03.setCount( "5" );

        // order, count
        DefinitionsElementQueryParams  params04 = new DefinitionsElementQueryParams();
        params04.setType( DefinitionsElement.Type.TEST.value() );
        params04.setOrder( "-version,-id" );
        params04.setCount( "5" );

        // searchTerms, order
        DefinitionsElementQueryParams  params05 = new DefinitionsElementQueryParams();
        params05.setType( DefinitionsElement.Type.STATE.value() );
        params05.setOrder( "id" );
        params05.setSearchTerms( "Validation" );

        // searchTerms, order
        DefinitionsElementQueryParams  params06 = new DefinitionsElementQueryParams();
        params06.setType( DefinitionsElement.Type.STATE.value() );
        params06.setOrder( "id" );
        params06.setSearchTerms( "Validation,security" );


        // OVAL ID (1) --- single
        DefinitionsElementQueryParams  params21 = new DefinitionsElementQueryParams();
        params21.setOrder( "id" );
        params21.setId( "oval:org.mitre.oval.test:tst:124" );

        // OVAL ID (2) --- multiple
        DefinitionsElementQueryParams  params22 = new DefinitionsElementQueryParams();
        params22.setOrder( "id" );
        params22.setId( "oval:org.mitre.oval.test:tst:124,oval:org.mitre.oval:tst:8775,oval:org.mitre.oval.test:tst:1180" );

        // OVAL ID (3) --- multiple, mixed types
        DefinitionsElementQueryParams  params23 = new DefinitionsElementQueryParams();
        params23.setOrder( "id" );
        params23.setId( "oval:org.mitre.oval.test:tst:124,oval:org.mitre.oval:obj:2156,oval:org.mitre.oval.test:ste:1002" );

        // OVAL ID (4) --- multiple, mixed types
        DefinitionsElementQueryParams  params24 = new DefinitionsElementQueryParams();
        params24.setOrder( "id" );
        params24.setId( "oval:org.mitre.oval.test:tst:124,oval:org.mitre.oval:obj:2156,oval:org.mitre.oval.test:ste:1002,oval:org.mitre.oval.test:def:889" );

        // OVAL ID (5) --- wildcard
        DefinitionsElementQueryParams  params25 = new DefinitionsElementQueryParams();
        params25.setOrder( "id" );
        params25.setId( "oval:org.mitre.oval.test:tst:9*" );

        // OVAL ID (6) --- list, wildcard
        DefinitionsElementQueryParams  params26 = new DefinitionsElementQueryParams();
        params26.setOrder( "id" );
        params26.setId( "oval:org.mitre.oval.test:tst:9*,oval:org.mitre.oval.test:ste:7*" );

        // OVAL version, order
        DefinitionsElementQueryParams  params31 = new DefinitionsElementQueryParams();
        params31.setType( DefinitionsElement.Type.TEST.value() );
        params31.setOrder( "id" );
        params31.setVersion( ">1" );


        // family (1) --- single
        DefinitionsElementQueryParams  params41 = new DefinitionsElementQueryParams();
        params41.setType( DefinitionsElement.Type.TEST.value() );
        params41.setOrder( "id" );
        params41.setFamily( Family.LINUX.value() );

        // family (2) --- list
        DefinitionsElementQueryParams  params42 = new DefinitionsElementQueryParams();
        params42.setType( DefinitionsElement.Type.TEST.value() );
        params42.setOrder( "id" );
        params42.setFamily( Family.LINUX.value() + "," + Family.UNIX.value() );


        // component (1) --- single
        DefinitionsElementQueryParams  params51 = new DefinitionsElementQueryParams();
        params51.setType( DefinitionsElement.Type.TEST.value() );
        params51.setOrder( "id" );
        params51.setComponent( Component.FAMILY.value() );

        // component (2) --- list
        DefinitionsElementQueryParams  params52 = new DefinitionsElementQueryParams();
        params52.setType( DefinitionsElement.Type.TEST.value() );
        params52.setOrder( "id" );
        params52.setComponent( new Component[] { Component.FILE, Component.PROCESS58 } );

        // component (3) --- family
        DefinitionsElementQueryParams  params53 = new DefinitionsElementQueryParams();
//        params53.setType( DefinitionsElement.Type.TEST.value() );
        params53.setOrder( "id" );
        params53.setComponent( Component.FILE );
        params53.setFamily( Family.WINDOWS.value() );


        return new Object[][] {
                        {
                            "01", params01,
                            new DefinitionsElement.Type[] { DefinitionsElement.Type.TEST }
                        }
                        ,
                        {
                            "02", params02,
                            new DefinitionsElement.Type[] { DefinitionsElement.Type.TEST }
                        }
                        ,
                        {
                            "03", params03,
                            new DefinitionsElement.Type[] { DefinitionsElement.Type.TEST }
                        }
                        ,
                        {
                            "04", params04,
                            new DefinitionsElement.Type[] { DefinitionsElement.Type.TEST }
                        }
                        ,
                        {
                            "05", params05,
                            new DefinitionsElement.Type[] { DefinitionsElement.Type.STATE }
                        }
                        ,
                        {
                            "06", params06,
                            new DefinitionsElement.Type[] { DefinitionsElement.Type.STATE }
                        }
                        ,
                        {
                            "21", params21,
                            new DefinitionsElement.Type[] { DefinitionsElement.Type.TEST }
                        }
                        ,
                        {
                            "22", params22,
                            new DefinitionsElement.Type[] { DefinitionsElement.Type.TEST }
                        }
                        ,
                        {
                            "23", params23,
                            new DefinitionsElement.Type[] {
                                            DefinitionsElement.Type.TEST,
                                            DefinitionsElement.Type.OBJECT,
                                            DefinitionsElement.Type.STATE
                                            }
                        }
                        ,
                        {
                            "24", params24,
                            new DefinitionsElement.Type[] {
                                            DefinitionsElement.Type.TEST,
                                            DefinitionsElement.Type.OBJECT,
                                            DefinitionsElement.Type.STATE,
                                            DefinitionsElement.Type.DEFINITION
                                            }
                        }
                        ,
                        {
                            "25", params25,
                            new DefinitionsElement.Type[] { DefinitionsElement.Type.TEST }
                        }
                        ,
                        {
                            "26", params26,
                            new DefinitionsElement.Type[] {
                                            DefinitionsElement.Type.TEST,
                                            DefinitionsElement.Type.STATE
                                            }
                        }
                        ,
                        {
                            "31", params31,
                            new DefinitionsElement.Type[] { DefinitionsElement.Type.TEST }
                        }
                        ,
                        {
                            "41", params41,
                            new DefinitionsElement.Type[] { DefinitionsElement.Type.TEST }
                        }
                        ,
                        {
                            "42", params42,
                            new DefinitionsElement.Type[] { DefinitionsElement.Type.TEST }
                        }
                        ,
                        {
                            "51", params51,
                            new DefinitionsElement.Type[] { DefinitionsElement.Type.TEST }
                        }
                        ,
                        {
                            "52", params52,
                            new DefinitionsElement.Type[] { DefinitionsElement.Type.TEST }
                        }
                        ,
                        {
                            "53", params53,
                            new DefinitionsElement.Type[] {
                                            DefinitionsElement.Type.TEST,
                                            DefinitionsElement.Type.OBJECT,
                                            DefinitionsElement.Type.STATE,
                                            DefinitionsElement.Type.DEFINITION
                                            }
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
        DefinitionQueryParams  params01 = new DefinitionQueryParams();
        params01.setOrder( "id" );
        params01.setCount( "3" );

        // common: order, count, startIndex
        DefinitionQueryParams  params02 = new DefinitionQueryParams();
        params02.setOrder( "id" );
        params02.setCount( "2" );
        params02.setStartIndex( "4" );

        // common: order, count, startIndex
        DefinitionQueryParams  params03 = new DefinitionQueryParams();
        params03.setOrder( "-id" );
        params03.setCount( "5" );

        // common: searchTerms, order
        DefinitionQueryParams  params04 = new DefinitionQueryParams();
        params04.setOrder( "id" );
        params04.setSearchTerms( "variable" );

        // common: searchTerms, order
        DefinitionQueryParams  params05 = new DefinitionQueryParams();
        params05.setOrder( "-id" );
        params05.setSearchTerms( "negate,MITRE" );

        // common: searchTerms, order
        DefinitionQueryParams  params06 = new DefinitionQueryParams();
        params06.setOrder( "id" );
        params06.setSearchTerms( "arithmetic,begin,concat,end,escape_regex,regex_capture,split,substring,time_difference" );

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
        params14.setId( "oval:org.mitre.oval.test:def:4*" );

        // element: id
        DefinitionQueryParams  params15 = new DefinitionQueryParams();
        params15.setId( "oval:org.mitre.oval.test:def:4*,oval:org.mitre.oval.test:def:5*" );

        // element: id
        DefinitionQueryParams  params16 = new DefinitionQueryParams();
        params16.setId( "oval:org.mitre.oval.test:def:4*,oval:org.mitre.oval.test:def:50" );


        // definition: definitionClass
        DefinitionQueryParams  params20 = new DefinitionQueryParams();
        params20.setDefinitionClass( "compliance" );

        // definition: definitionClass
        DefinitionQueryParams  params21 = new DefinitionQueryParams();
        params21.setDefinitionClass( "compliance,inventory" );

        // definition: family
        DefinitionQueryParams  params22 = new DefinitionQueryParams();
        params22.setFamily( "unix" );

        // definition: family
        DefinitionQueryParams  params23 = new DefinitionQueryParams();
        params23.setFamily( "windows,unix" );
        params23.setOrder( "family" );
        params23.setCount( "10" );


        // definition: platform
        DefinitionQueryParams  params31 = new DefinitionQueryParams();
        params31.setPlatform( "Microsoft Windows XP" );

        DefinitionQueryParams  params32 = new DefinitionQueryParams();
        params32.setPlatform( "Microsoft Windows XP*,Microsoft Windows 7*" );

        // definition: product
        DefinitionQueryParams  params41 = new DefinitionQueryParams();
        params41.setProduct( "Mozilla Firefox,Mozilla Thunderbird" );

        // definition: product
        DefinitionQueryParams  params42 = new DefinitionQueryParams();
        params42.setProduct( "Mozilla*" );


        // definition: refSource
        DefinitionQueryParams  params51 = new DefinitionQueryParams();
        params51.setRefSource( "CPE" );

        // definition: refSource
        DefinitionQueryParams  params52 = new DefinitionQueryParams();
        params52.setRefSource( "CPE,CVE" );

        // definition: refId
        DefinitionQueryParams  params55 = new DefinitionQueryParams();
        params55.setRefId( "CVE-2010-0176" );

        DefinitionQueryParams  params56 = new DefinitionQueryParams();
        params56.setRefId( "CVE-2010-*" );

        DefinitionQueryParams  params57 = new DefinitionQueryParams();
        params57.setRefId( "cpe:/a:microsoft:*" );

        DefinitionQueryParams  params58 = new DefinitionQueryParams();
        params58.setRefId( "cpe:/a:microsoft:*,cpe:/a:adobe:*" );


        // definition: cve
        DefinitionQueryParams  params61 = new DefinitionQueryParams();
        params61.setCve( "CVE-2010-*" );

        // definition: cve
        DefinitionQueryParams  params62 = new DefinitionQueryParams();
        params62.setCve( "CVE-2011-*,CVE-2010-0176" );

        return new Object[][] {
//                        {
//                            "01",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params01
//                        }
//                        ,
//                        {
//                            "02",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params02
//                        }
//                        ,
//                        {
//                            "03",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params03
//                        }
//                        ,
                        {
                            "04",
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params04
                        }
                        ,
                        {
                            "05",
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params05
                        }
                        ,
                        {
                            "06",
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params06
                        }
//                        ,
//                        {
//                            "11",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params11
//                        }
//                        ,
//                        {
//                            "12",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params12
//                        }
//                        ,
//                        {
//                            "13",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params13
//                        }
//                        ,
//                        {
//                            "14",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params14
//                        }
//                        ,
//                        {
//                            "15",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params15
//                        }
//                        ,
//                        {
//                            "16",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params16
//                        }
//                        ,
//                        {
//                            "20",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params20
//                        }
//                        ,
//                        {
//                            "21",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params21
//                        }
//                        ,
//                        {
//                            "22",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params22
//                        }
//                        ,
//                        {
//                            "23",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params23
//                        }
//                        ,
//                        {
//                            "31",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params31
//                        }
//                        ,
//                        {
//                            "32",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params32
//                        }
//                        ,
//                        {
//                            "41",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params41
//                        }
//                        ,
//                        {
//                            "42",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params42
//                        }
//                        ,
//                        {
//                            "51",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params51
//                        }
//                        ,
//                        {
//                            "52",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params52
//                        }
//                        ,
//                        {
//                            "55",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params55
//                        }
//                        ,
//                        {
//                            "56",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params56
//                        }
//                        ,
//                        {
//                            "57",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params57
//                        }
//                        ,
//                        {
//                            "58",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params58
//                        }
//                        ,
//                        {
//                            "61",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params61
//                        }
//                        ,
//                        {
//                            "62",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params62
//                        }
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
                    final String                    dataId,
                    final QueryParams               params,
                    final DefinitionsElement.Type[] types
                    )
    throws Exception
    {
        Reporter.log( "\n" + dataId + " //////////////////////////////////////////////////////////", true );
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
                    final String                    dataId,
                    final Class<DefinitionType>     object_type,
                    final DefinitionsElement.Type   type,
                    final QueryParams               params
                    )
    throws Exception
    {
        Reporter.log( "\n" + dataId + " //////////////////////////////////////////////////////////", true );
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


        Reporter.log( ">>> countDefinition(params)...", true );
        long  count = _getDefinitionRepository().countDefinition( params );
        Reporter.log( "<<< ...countDefinition(params)", true );
        Reporter.log( "  @ #Definitions: " + count, true );

        //If the "count" param is specified, finxXxx() methods returns at most "count" objects.
        //And then, the number of results does not equal to the number returned from the countXxx() methods.
        String  count_param = params.get( CommonQueryParams.Key.COUNT );
        if (count_param == null) {
            Assert.assertEquals( def_list.size(), count );
        }
    }


}
//
