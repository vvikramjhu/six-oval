package jp.go.aist.six.test.oval.core.repository.mongodb;

import jp.go.aist.six.oval.core.repository.mongodb.OvalDefinitionsGenerator;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.DefinitionsElement;
import jp.go.aist.six.oval.repository.DefinitionQueryParams;
import jp.go.aist.six.oval.repository.QueryParams;
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
public class OvalDefinitionsGeneratorTests
extends OvalCoreTestBase
{

    private OvalDefinitionsGenerator  _oval_defs_generator;



    /**
     */
    @Override
    @BeforeClass( alwaysRun=true )
	public void setUp()
    throws Exception
	{
        super.setUp();

        _oval_defs_generator = new OvalDefinitionsGenerator();
	}



    protected OvalDefinitionsGenerator _getGenerator()
    {
        return _oval_defs_generator;
    }



    ////////////////////////////////////////////////////////////////
    //  support methods
    ////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////
    //  test data
    ////////////////////////////////////////////////////////////////

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

        // element: id
        DefinitionQueryParams  params17 = new DefinitionQueryParams();
        params17.setId( "oval:org.mitre.oval.test:def:9*" );

        // element: id - extend_definition, var_ref
        DefinitionQueryParams  params18 = new DefinitionQueryParams();
        params18.setId( "oval:org.mitre.oval.test:def:712,oval:org.mitre.oval.test:def:283" );


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
//                        {
//                            "04",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params04
//                        }
//                        ,
//                        {
//                            "05",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params05
//                        }
//                        ,
//                        {
//                            "06",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params06
//                        }
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
//                            "17",
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params17
//                        }
//                      ,
                      {
                          "18",
                          jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                          DefinitionsElement.Type.DEFINITION,
                          params18
                      }
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
     * generateByQuery(params)
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.def.oval_definitions",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.generator.generateByQuery"
                                    },
//                    dependsOnGroups={ "CONTROL.oval.repository.findDefinitionById" },
                    dataProvider="DATA.oval.repository.query_params.definition",
                    alwaysRun=true
                    )
    public void testGenerateByQuery(
                    final String                    dataId,
                    final Class<DefinitionType>     object_type,
                    final DefinitionsElement.Type   type,
                    final QueryParams               params
                    )
    throws Exception
    {
        Reporter.log( "\n" + dataId + " //////////////////////////////////////////////////////////", true );
        Reporter.log( ">>> generateByQuery(params)...", true );
        Reporter.log( "  * params: "          + params, true );

        String  pid = _getGenerator().generateByQuery( params );
        Reporter.log( "<<< ...generateByQuery(params)", true );
        Assert.assertNotNull( pid );
        Reporter.log( "  @ persistent ID: " + pid, true );
    }


}
//
