package jp.go.aist.six.test.oval.core.repository.mongodb;

import java.io.File;
import java.util.List;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalDefinitionResultRepository;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.model.sc.SystemInfoType;
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
        params22.setHost( "host66" );

        // sc: IP
        OvalSystemCharacteristicsQueryParams  params23 = new OvalSystemCharacteristicsQueryParams();
        params23.setIp( "192.168.10." );

        // sc: MAC
        OvalSystemCharacteristicsQueryParams  params24 = new OvalSystemCharacteristicsQueryParams();
        params24.setMac( "00-50-56-C0-00-01" );


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
                                    "CONTROL.oval.repository.saveOvalSc",
                                    "CONTROL.oval.repository.findOvalScById"
                                    }
//                    dependsOnGroups={ "control:repository.saveElement" },
                    ,dataProvider="DATA.oval.sc.oval_system_characteristics"
                    ,alwaysRun=true
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
        }
    }



    /**
     * findOvalSc(params)
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.sc.oval_system_characteristics",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.repository.findOvalScByQuery"
                                    },
                    dependsOnGroups={ "CONTROL.oval.repository.saveOvalSc" },
                    dataProvider="DATA.oval.repository.query_params.oval_system_characteristics",
                    alwaysRun=true
                    )
    public void testFindOvalSc(
                    final Class<OvalSystemCharacteristics>  object_type,
                    final QueryParams                       params
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////", true );

        Reporter.log( ">>> findOvalSc(params)...", true );
        Reporter.log( "  * params: " + params, true );

        List<OvalSystemCharacteristics>  oval_sc_list = _getDefinitionResultRepository().findOvalSc( params );
        Reporter.log( "<<< ...findOvalSc(params)", true );
        Assert.assertNotNull( oval_sc_list );
        Reporter.log( "  @ #OVAL SC: " + oval_sc_list.size(), true );
        for (OvalSystemCharacteristics  oval_sc : oval_sc_list) {
            SystemInfoType  sys = oval_sc.getSystemInfo();
            Reporter.log( "  @ SC.system_info: " + sys, true );
        }
    }

}
//
