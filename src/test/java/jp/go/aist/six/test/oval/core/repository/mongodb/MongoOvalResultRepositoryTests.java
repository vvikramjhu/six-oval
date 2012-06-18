package jp.go.aist.six.test.oval.core.repository.mongodb;

import java.io.File;
import java.util.List;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalDefinitionResultRepository;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.results.DefinitionType;
import jp.go.aist.six.oval.model.results.DefinitionsType;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.results.ResultsType;
import jp.go.aist.six.oval.model.results.SystemType;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.model.sc.SystemInfoType;
import jp.go.aist.six.oval.repository.OvalResultsQueryParams;
import jp.go.aist.six.oval.repository.OvalSystemCharacteristicsQueryParams;
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
public class MongoOvalResultRepositoryTests
extends OvalCoreTestBase
{

    private MongoOvalDefinitionResultRepository  _oval_res_repository;



    /**
     */
    @Override
    @BeforeClass( alwaysRun=true )
    public void setUp()
    throws Exception
    {
        super.setUp();

        _oval_res_repository = OvalContext.getBean( "mongoOvalDefinitionResultRepository", MongoOvalDefinitionResultRepository.class );
    }



    protected MongoOvalDefinitionResultRepository _getDefinitionResultRepository()
    {
        return _oval_res_repository;
    }



    ////////////////////////////////////////////////////////////////
    //  test data
    ////////////////////////////////////////////////////////////////

    /**
     * OVAL Results document.
     *
     *  Class<OvalSystemCharacteristics>    object_type,
     *  QueryParams                         params
     */
    @DataProvider( name="DATA.oval.repository.query_params.oval_results" )
    public Object[][] provideRepositoryQueryParamsOvalResults()
    {
        // sc: host
        OvalResultsQueryParams  params21 = new OvalResultsQueryParams();
        params21.setHost( "host66.foo.com" );

        // sc: host
        OvalResultsQueryParams  params22 = new OvalResultsQueryParams();
        params22.setHost( "*.bar.com" );

        // sc: IP
        OvalResultsQueryParams  params23 = new OvalResultsQueryParams();
        params23.setIp( "192.168.10.*" );

        // sc: MAC
        OvalResultsQueryParams  params24 = new OvalResultsQueryParams();
        params24.setMac( "00-50-56-C0-00-01" );

        // sc: OS
        OvalResultsQueryParams  params25 = new OvalResultsQueryParams();
        params25.setOs( "Windows*" );

        // sc: OS
        OvalResultsQueryParams  params26 = new OvalResultsQueryParams();
        params26.setOs( "Linux" );


        // res: definition
        OvalResultsQueryParams  params31 = new OvalResultsQueryParams();
        params31.setDefinition( "oval:org.mitre.oval:def:6210" );

        OvalResultsQueryParams  params32 = new OvalResultsQueryParams();
        params32.setDefinition( "oval:org.mitre.oval:def:6210,oval:org.mitre.oval:def:12514" );


        // res: definition true
        OvalResultsQueryParams  params33 = new OvalResultsQueryParams();
        params33.setDefinitionTrue( "oval:org.mitre.oval:def:6210" );

        OvalResultsQueryParams  params34 = new OvalResultsQueryParams();
        params34.setDefinitionTrue( "oval:org.mitre.oval:def:11985" );

        OvalResultsQueryParams  params35 = new OvalResultsQueryParams();
        params35.setDefinitionTrue( "oval:org.mitre.oval:def:11985,oval:org.mitre.oval:def:12514" );

        OvalResultsQueryParams  params36 = new OvalResultsQueryParams();
        params36.setOs( "Linux" );
        params36.setDefinitionTrue( "oval:com.redhat.rhsa:def:20100332" );



        return new Object[][] {
                        {
                            "21",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params21
                        }
                        ,
                        {
                            "22",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params22
                        }
                        ,
                        {
                            "23",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params23
                        }
                        ,
                        {
                            "24",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params24
                        }
                        ,
                        {
                            "25",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params25
                        }
                        ,
                        {
                            "26",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params26
                        }
                        ,
                        {
                            "31",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params31
                        }
                        ,
                        {
                            "32",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params32
                        }
                        ,
                        {
                            "33",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params33
                        }
                        ,
                        {
                            "34",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params34
                        }
                        ,
                        {
                            "35",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params35
                        }
                        ,
                        {
                            "36",
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            params36
                        }
        };
    }



    /**
     * OVAL SC document.
     *
     *  Class<OvalSystemCharacteristics>    object_type,
     *  QueryParams                         params
     */
    @DataProvider( name="DATA.oval.repository.query_params.oval_system_characteristics" )
    public Object[][] provideRepositoryQueryParamsOvalSystemCharacteristics()
    {
        // common: order, count
        OvalSystemCharacteristicsQueryParams  params01 = new OvalSystemCharacteristicsQueryParams();
        params01.setOrder( "_id" );
        params01.setCount( "2" );

        // common: order, count, startIndex
        OvalSystemCharacteristicsQueryParams  params02 = new OvalSystemCharacteristicsQueryParams();
        params02.setOrder( "_id" );
        params02.setCount( "1" );
        params02.setStartIndex( "3" );

        // common: order, count, startIndex
        OvalSystemCharacteristicsQueryParams  params03 = new OvalSystemCharacteristicsQueryParams();
        params03.setOrder( "-_id" );
        params03.setCount( "5" );

        // sc: host
        OvalSystemCharacteristicsQueryParams  params21 = new OvalSystemCharacteristicsQueryParams();
        params21.setHost( "host55.foo.com" );

        // sc: host
        OvalSystemCharacteristicsQueryParams  params22 = new OvalSystemCharacteristicsQueryParams();
        params22.setHost( "*.bar.com" );

        // sc: IP
        OvalSystemCharacteristicsQueryParams  params23 = new OvalSystemCharacteristicsQueryParams();
        params23.setIp( "192.168.10.*" );

        // sc: MAC
        OvalSystemCharacteristicsQueryParams  params24 = new OvalSystemCharacteristicsQueryParams();
        params24.setMac( "00-50-56-C0-00-01" );


        // sc: OS
        OvalSystemCharacteristicsQueryParams  params31 = new OvalSystemCharacteristicsQueryParams();
        params31.setOs( "Windows*" );


        // sc: OS version
        OvalSystemCharacteristicsQueryParams  params41 = new OvalSystemCharacteristicsQueryParams();
        params41.setOsVersion( "6.1.7601" );

        // sc: OS version
        OvalSystemCharacteristicsQueryParams  params42 = new OvalSystemCharacteristicsQueryParams();
        params42.setOs( "Windows*" );
        params42.setOsVersion( "<6" );

        // sc: OS version
        OvalSystemCharacteristicsQueryParams  params43 = new OvalSystemCharacteristicsQueryParams();
        params43.setOs( "Windows*" );
        params43.setOsVersion( ">6.1" );

        // sc: OS version
        OvalSystemCharacteristicsQueryParams  params44 = new OvalSystemCharacteristicsQueryParams();
        params44.setOsVersion( "!6.1.7601" );



        return new Object[][] {
                        {
                            "01",
                            jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics.class,
                            params01
                        }
                        ,
                        {
                            "02",
                            jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics.class,
                            params02
                        }
                        ,
                        {
                            "03",
                            jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics.class,
                            params03
                        }
                        ,

                        {
                            "21",
                            jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics.class,
                            params21
                        }
                        ,
                        {
                            "22",
                            jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics.class,
                            params22
                        }
                        ,
                        {
                            "23",
                            jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics.class,
                            params23
                        }
                        ,
                        {
                            "24",
                            jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics.class,
                            params24
                        }
                        ,
                        {
                            "31",
                            jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics.class,
                            params31
                        }
                        ,
                        {
                            "41",
                            jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics.class,
                            params41
                        }
                        ,
                        {
                            "42",
                            jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics.class,
                            params42
                        }
                        ,
                        {
                            "43",
                            jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics.class,
                            params43
                        }
                        ,
                        {
                            "44",
                            jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics.class,
                            params44
                        }
        };
    }



    ////////////////////////////////////////////////////////////////
    //  test methods
    ////////////////////////////////////////////////////////////////

    //**************************************************************
    //  OVAL Results
    //**************************************************************

    /**
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.res.oval_results",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.repository.saveOvalResults",
                                    "CONTROL.oval.repository.findOvalResultsById"
                                    }
                    ,dependsOnGroups={ "CONTROL.oval.repository.findOvalSystemCharacteristicsByQuery" }
                    ,dataProvider="DATA.oval.res.oval_results"
//                    ,alwaysRun=true
                    )
    public void testSaveOvalResultsAndFindOvalResultsById(
                    final OvalContentCategory   category,
                    final String                schema_version,
                    final Class<OvalResults>    object_type,
                    final Family                family,
                    final String                dirpath,
                    final String                xml_filepath,
                    final OvalResults           expected_object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////", true );

        File[]  files = _toXmlFileList( dirpath, xml_filepath );

        for (File  file : files) {
            OvalResults  oval_results = _unmarshalFromFile( object_type, file.getCanonicalPath(), expected_object );
            Reporter.log( ">>> saveOvalResults(oval_results)...", true );
            String  p_id = _getDefinitionResultRepository().saveOvalResults( oval_results );
            Reporter.log( "<<< ...saveOvalResults(oval_results)", true );
            Reporter.log( "  @ persistent ID: " + p_id, true );
            Assert.assertNotNull( p_id );

            Reporter.log( ">>> findOvalResultsById(id)...", true );
            OvalResults  p_oval_results = _getDefinitionResultRepository().findOvalResultsById( p_id );
            Reporter.log( "<<< ...findOvalResultsById(id)", true );
            Assert.assertNotNull( p_oval_results );
            String  p_id2 = p_oval_results.getPersistentID();
            Assert.assertEquals( p_id, p_id2 );
            Assert.assertEquals( oval_results.getGenerator(), p_oval_results.getGenerator() );

            OvalDefinitions    oval_defs =   oval_results.getOvalDefinitions();
            if (oval_defs != null) {
                OvalDefinitions  p_oval_defs = p_oval_results.getOvalDefinitions();
                Assert.assertEquals( oval_defs.getDefinitionsDigest(), p_oval_defs.getDefinitionsDigest() );
            }
        }
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.res.oval_results",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.repository.findOvalResults",
                                    "CONTROL.oval.repository.findOvalResultsId",
                                    "CONTROL.oval.repository.countOvalResults"
                                    }
                    ,dependsOnGroups={ "CONTROL.oval.repository.saveOvalResults" }
//                    ,alwaysRun=true
                    )
    public void testFindOvalResultsAndFindOvalResultsIdAndCountOvalResults()
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////", true );

        Reporter.log( ">>> countOvalResults()...", true );
        long  count = _getDefinitionResultRepository().countOvalResults();
        Reporter.log( "<<< ...countOvalResults()", true );

        Reporter.log( ">>> findOvalResults()...", true );
        List<OvalResults>  res_list = _getDefinitionResultRepository().findOvalResults();
        Reporter.log( "<<< ...findOvalResults()", true );
        Assert.assertNotNull( res_list );
        Assert.assertEquals( count, res_list.size() );

        Reporter.log( ">>> findOvalResultsId()...", true );
        List<String>  id_list = _getDefinitionResultRepository().findOvalResultsId();
        Reporter.log( "<<< ...findOvalResultsId()", true );
        Assert.assertNotNull( id_list );
        Assert.assertEquals( count, id_list.size() );

        for (OvalResults  res : res_list) {
            String  id = res.getPersistentID();
            Assert.assertTrue( id_list.contains( id ) );
        }
    }



    /**
     * findOvalResults(params)
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.res.oval_results",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.repository.findOvalResultsByQuery"
                                    }
                    ,dependsOnGroups={ "CONTROL.oval.repository.findOvalResults" }
                    ,dataProvider="DATA.oval.repository.query_params.oval_results"
//                    ,alwaysRun=true
                    )
    public void testFindOvalResults(
                    final String                data_id,
                    final Class<OvalResults>    object_type,
                    final QueryParams           params
                    )
    throws Exception
    {
        Reporter.log( "\n" + data_id + "//////////////////////////////////////////////////////////", true );

        Reporter.log( ">>> findOvalResults(params)...", true );
        Reporter.log( "  * params: " + params, true );

        List<OvalResults>  oval_results_list = _getDefinitionResultRepository().findOvalResults( params );
        Reporter.log( "<<< ...findOvalResults(params)", true );
        Assert.assertNotNull( oval_results_list );
        Reporter.log( "  @ #OVAL Results: " + oval_results_list.size(), true );
        for (OvalResults  oval_results : oval_results_list) {
            Reporter.log( "  @ ID: " + oval_results.getPersistentID(), true );
            ResultsType  results = oval_results.getResults();
            for (SystemType  sys : results.getSystem()) {
                SystemInfoType  sys_info = sys.getOvalSystemCharacteristics().getSystemInfo();
                Reporter.log( "    SC.system_info: " + sys_info, true );

                DefinitionsType  defs = sys.getDefinitions();
                for (DefinitionType  def : defs.getDefinition()) {
                    Reporter.log( "    def: ID=" + def.getOvalId() + ", result=" + def.getResult(), true );
                }
            }
        }
    }



    //**************************************************************
    //  OVAL SC
    //**************************************************************

    /**
     * saveOvalSc(oval_sc), findOvalScById(id)
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.sc.oval_system_characteristics",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.repository.saveOvalSystemCharacteristics",
                                    "CONTROL.oval.repository.findOvalSystemCharacteristicsById"
                                    }
                    ,dataProvider="DATA.oval.sc.oval_system_characteristics"
//                    ,alwaysRun=true
                    )
    public void testSaveOvalScAndFindOvalScById(
                    final OvalContentCategory               category,
                    final String                            schema_version,
                    final Class<OvalSystemCharacteristics>  object_type,
                    final Family                            family,
                    final String                            dirpath,
                    final String                            xml_filepath,
                    final OvalSystemCharacteristics         expected_object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////", true );

        File[]  files = _toXmlFileList( dirpath, xml_filepath );

        for (File  file : files) {
            OvalSystemCharacteristics  oval_sc = _unmarshalFromFile( object_type, file.getCanonicalPath(), expected_object );
            Reporter.log( ">>> saveOvalSc(oval_sc)...", true );
            String  p_id = _getDefinitionResultRepository().saveOvalSystemCharacteristics( oval_sc );
            Reporter.log( "<<< ...saveOvalSc(oval_sc)", true );
            Reporter.log( "  @ persistent ID: " + p_id, true );
            Assert.assertNotNull( p_id );

            Reporter.log( ">>> findOvalScById(id)...", true );
            OvalSystemCharacteristics  p_oval_sc = _getDefinitionResultRepository().findOvalSystemCharacteristicsById( p_id );
            Reporter.log( "<<< ...findOvalScById(id)", true );
            Assert.assertNotNull( p_oval_sc );
            String  p_id2 = p_oval_sc.getPersistentID();
            Assert.assertEquals( p_id, p_id2 );
            Assert.assertEquals( oval_sc.getGenerator(), p_oval_sc.getGenerator() );
            Assert.assertEquals( oval_sc.getSystemInfo(), p_oval_sc.getSystemInfo() );
        }
    }



    /**
     * findOvalSc(params)
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.sc.oval_system_characteristics",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.repository.findOvalSystemCharacteristicsByQuery"
                                    }
                    ,dependsOnGroups={ "CONTROL.oval.repository.saveOvalSystemCharacteristics" }
                    ,dataProvider="DATA.oval.repository.query_params.oval_system_characteristics"
//                    ,alwaysRun=true
                    )
    public void testFindOvalSc(
                    final String                            data_id,
                    final Class<OvalSystemCharacteristics>  object_type,
                    final QueryParams                       params
                    )
    throws Exception
    {
        Reporter.log( "\n" + data_id + "//////////////////////////////////////////////////////////", true );

        Reporter.log( ">>> findOvalSc(params)...", true );
        Reporter.log( "  * params: " + params, true );

        List<OvalSystemCharacteristics>  oval_sc_list = _getDefinitionResultRepository().findOvalSystemCharacteristics( params );
        Reporter.log( "<<< ...findOvalSc(params)", true );
        Assert.assertNotNull( oval_sc_list );
        Reporter.log( "  @ #OVAL SC: " + oval_sc_list.size(), true );
        for (OvalSystemCharacteristics  oval_sc : oval_sc_list) {
            Reporter.log( "  @ SC._id: " + oval_sc.getPersistentID(), true );
            SystemInfoType  sys = oval_sc.getSystemInfo();
            Reporter.log( "    system_info: " + sys, true );
        }
    }

}
//
