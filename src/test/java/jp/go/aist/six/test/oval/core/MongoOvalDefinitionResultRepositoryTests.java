package jp.go.aist.six.test.oval.core;

import java.io.File;
import java.util.List;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalDefinitionResultRepository;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.model.sc.SystemInfoType;
import jp.go.aist.six.oval.repository.OvalSystemCharacteristicsQueryParams;
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
public class MongoOvalDefinitionResultRepositoryTests
extends OvalCoreTests
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

        _oval_res_repository = _getContext().getBean( "mongoOvalDefinitionResultRepository", MongoOvalDefinitionResultRepository.class );
	}



    protected MongoOvalDefinitionResultRepository _getDefinitionResultRepository()
    {
        return _oval_res_repository;
    }



    ////////////////////////////////////////////////////////////////
    //  test data
    ////////////////////////////////////////////////////////////////

    /**
     * OVAL SC document.
     *
     *  Class<OvalSystemCharacteristics>    object_type,
     *  QueryParams                         params
     */
    @DataProvider( name="DATA.oval.repository.query_params.sc.oval_sc" )
    public Object[][] provideRepositoryQueryParamsOvalSystemCharacteristics()
    {
        // common: order, count
        OvalSystemCharacteristicsQueryParams  params01 = new OvalSystemCharacteristicsQueryParams();
        params01.setOrder( "_id" );
        params01.setCount( "3" );

        // common: order, count, startIndex
        OvalSystemCharacteristicsQueryParams  params02 = new OvalSystemCharacteristicsQueryParams();
        params02.setOrder( "_id" );
        params02.setCount( "2" );
        params02.setStartIndex( "4" );

        // common: order, count, startIndex
        OvalSystemCharacteristicsQueryParams  params03 = new OvalSystemCharacteristicsQueryParams();
        params03.setOrder( "-_id" );
        params03.setCount( "5" );

        // sc: host
        OvalSystemCharacteristicsQueryParams  params21 = new OvalSystemCharacteristicsQueryParams();
        params21.setHost( "host55.foo.com" );

        // sc: host
        OvalSystemCharacteristicsQueryParams  params22 = new OvalSystemCharacteristicsQueryParams();
        params22.setHost( "host100" );

        // sc: IP
        OvalSystemCharacteristicsQueryParams  params23 = new OvalSystemCharacteristicsQueryParams();
        params23.setIp( "192.168" );

        // sc: MAC
        OvalSystemCharacteristicsQueryParams  params24 = new OvalSystemCharacteristicsQueryParams();
        params24.setMac( "00-0C-29-37-69-D8" );


        return new Object[][] {
                        {
                            jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics.class,
                            params01
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics.class,
                            params02
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics.class,
                            params03
                        }
                        ,

                        {
                            jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics.class,
                            params21
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics.class,
                            params22
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics.class,
                            params23
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics.class,
                            params24
                        }
        };
    }





    ////////////////////////////////////////////////////////////////
    //  test methods
    ////////////////////////////////////////////////////////////////

    /**
     * saveOvalResults(oval_results), findOvalResultsById(id)
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.res",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.repository.saveOvalResults"
                                    },
//                    dependsOnGroups={ "control:repository.saveElement" },
                    dataProvider="DATA.oval.res.oval_results",
                    alwaysRun=true
                    )
    public void testSaveOvalResultsAndFindById(
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
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        File[]  files = _toXmlFileList( dirpath, xml_filepath );
        for (File  file : files) {
            OvalResults  oval_results = _unmarshalFromFile( object_type, file.getCanonicalPath(), expected_object );
            _saveOvalResultsAndFindById( oval_results );
        }
    }



    protected OvalResults _saveOvalResultsAndFindById(
                    final OvalResults oval_results
                    )
    throws Exception
    {
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

        OvalDefinitions  oval_defs = oval_results.getOvalDefinitions();
        if (oval_defs != null) {
            OvalDefinitions  p_oval_defs = p_oval_results.getOvalDefinitions();
            Assert.assertNotNull( p_oval_defs );
            String    digest =   oval_defs.getDefinitionsDigest();
            String  p_digest = p_oval_defs.getDefinitionsDigest();
            Assert.assertEquals( digest, p_digest );
        }

        return p_oval_results;
    }



    //**************************************************************
    //  OVAL SC
    //**************************************************************

    /**
     * findOvalSc(params)
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.sc",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.repository.querySc"
                                    },
//                    dependsOnGroups={ "CONTROL.oval.repository.findOvalScById" },
                    dataProvider="DATA.oval.repository.query_params.sc.oval_sc",
                    alwaysRun=true
                    )
    public void testFindOvalSc(
                    final Class<OvalSystemCharacteristics>  object_type,
                    final QueryParams                       params
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );
        Reporter.log( ">>> findOvalSc(params)...", true );
        Reporter.log( "  * params: " + params, true );

        List<OvalSystemCharacteristics>  oval_sc_list = _getDefinitionResultRepository().findOvalSc( params );
        Reporter.log( "<<< ...findOvalSc(params)", true );
        Assert.assertNotNull( oval_sc_list );
        Reporter.log( "  @ #Oval SC: " + oval_sc_list.size(), true );
        for (OvalSystemCharacteristics  oval_sc : oval_sc_list) {
            SystemInfoType  sys = oval_sc.getSystemInfo();
            Reporter.log( "  @ SC.system_info: " + sys, true );
        }


//        Reporter.log( ">>> findDefinitionId(params)...", true );
//        Reporter.log( "  * params: "          + params, true );
//
//        List<String>  def_id_list = _getDefinitionResultRepository().findDefinitionId( params );
//        Reporter.log( "<<< ...findDefinitionId(params)", true );
//        Assert.assertNotNull( def_id_list );
//        Reporter.log( "  @ #IDs: " + def_id_list.size(), true );
//
//        Assert.assertEquals( def_list.size(), def_id_list.size() );


//        String  count_param = params.get( CommonQueryParams.Key.COUNT );
//        //If the "count" param is specified, finxXxx() methods returns at most "count" objects.
//        //And then, the number of results does not equal to the number returned from the countXxx() methods.
//        if (count_param == null) {
//            Reporter.log( ">>> countDefinition(params)...", true );
//            long  count = _getDefinitionRepository().countDefinition( params );
//            Reporter.log( "<<< ...countDefinition(params)", true );
//            Reporter.log( "  @ #Definitions: " + count, true );
//
//            Assert.assertEquals( def_list.size(), count );
//        }
    }



    /**
     * saveOvalSc(oval_results), findOvalScById(id)
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.sc",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.repository.saveOvalSc",
                                    "CONTROL.oval.repository.findOvalScById"
                                    }
//                    dependsOnGroups={ "control:repository.saveElement" },
                    ,dataProvider="DATA.oval.sc.oval_sc"
                    ,alwaysRun=true
                    )
    public void testSaveOvalScAndFindById(
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
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        File[]  files = _toXmlFileList( dirpath, xml_filepath );
        for (File  file : files) {
            OvalSystemCharacteristics  oval_results = _unmarshalFromFile( object_type, file.getCanonicalPath(), expected_object );
            _saveOvalScAndFindById( oval_results );
        }
    }



    protected OvalSystemCharacteristics _saveOvalScAndFindById(
                    final OvalSystemCharacteristics oval_sc
                    )
    throws Exception
    {
        Reporter.log( ">>> saveOvalSc(oval_sc)...", true );
        String  p_id = _getDefinitionResultRepository().saveOvalSc( oval_sc );
        Reporter.log( "<<< ...saveOvalSc(oval_sc)", true );
        Reporter.log( "  @ persistent ID: " + p_id, true );
        Assert.assertNotNull( p_id );

        Reporter.log( ">>> findOvalScById(id)...", true );
        OvalSystemCharacteristics  p_oval_sc = _getDefinitionResultRepository().findOvalScById( p_id );
        Reporter.log( "<<< ...findOvalScById(id)", true );
        Assert.assertNotNull( p_oval_sc );
        String  p_id2 = p_oval_sc.getPersistentID();
        Assert.assertEquals( p_id, p_id2 );
        Assert.assertEquals( oval_sc.getGenerator(), p_oval_sc.getGenerator() );
        Assert.assertEquals( oval_sc.getSystemInfo(), p_oval_sc.getSystemInfo() );

        return p_oval_sc;
    }

}
//
