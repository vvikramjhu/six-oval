package jp.go.aist.six.test.oval.core.repository.mongodb;

import java.io.FilenameFilter;
import java.util.List;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalDefinitionResultsRepository;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.repository.OvalResultsQueryParams;
import jp.go.aist.six.oval.repository.QueryParams;
import jp.go.aist.six.test.oval.core.TestBase;
import jp.go.aist.six.test.oval.core.XmlFilenameFilter;
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
extends TestBase
{

    private MongoOvalDefinitionResultsRepository  _oval_repository;



    /**
     */
    @Override
    @BeforeClass( alwaysRun=true )
	public void setUp()
    throws Exception
	{
        super.setUp();

        _oval_repository = _getContext().getBean( MongoOvalDefinitionResultsRepository.class );
	}



    protected MongoOvalDefinitionResultsRepository _getResultsRepository()
    {
        return _oval_repository;
    }



    //**************************************************************
    // test data
    //**************************************************************

    /**
     * Query parameters for OVAL Results document.
     */
    @DataProvider( name="oval.repository.results.queryParams" )
    public Object[][] provideOvalResultRepositoryQueryParams()
    {
        // primary_host_name
        OvalResultsQueryParams  params1 = new OvalResultsQueryParams();
        params1.setPrimary_host_name( "host1" );

        // primary_host_name
        OvalResultsQueryParams  params2 = new OvalResultsQueryParams();
        params2.setPrimary_host_name( "host2" );

        // primary_host_name
        OvalResultsQueryParams  params3 = new OvalResultsQueryParams();
        params3.setResult_true_def( "oval:org.mitre.oval.test:def:600" );

        return new Object[][] {
                        { params1 }
                        ,
                        { params2 }
                        ,
                        { params3 }
        };
    }





    //**************************************************************
    // test methods
    //**************************************************************

    /**
                    dependsOnMethods= { "testSaveOvalResults" },
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.repository.mongodb" },
                    dataProvider="oval.repository.results.queryParams",
                    alwaysRun=true
                    )
    public void testFindOvalResultsByQueryParams(
                    final QueryParams params
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        List<OvalResults>  oval_results_list = _getResultsRepository().findOvalResults( params );
        Assert.assertNotNull( oval_results_list );
        Reporter.log( "#oval_results: " + oval_results_list.size(), true );

        for (OvalResults  p_oval_results : oval_results_list) {
            Reporter.log( "  @ persistent ID=" + p_oval_results.getPersistentID(), true );
        }
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.repository.mongodb" },
                    dataProvider="oval.test_content.res",
                    alwaysRun=true
                    )
    public void testSaveOvalResults(
                    final Class<OvalResults>          object_type,
                    final String            oval_schema_version,
                    final OvalPlatformType  platform,
                    final String            dirpath,
                    final String            xml_filepath,
                    final OvalResults       expected_object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );
        Reporter.log( "* object type: " + object_type, true );
        Reporter.log( "* OVAL schema version: " + oval_schema_version, true );
        Reporter.log( "* platform: " + platform.name(), true );
        Reporter.log( "* dir: " + dirpath, true );
        Reporter.log( "* XML file: " + xml_filepath, true );

        File  dir = new File( dirpath );

        if (xml_filepath == null) {
            FilenameFilter  filter = new XmlFilenameFilter();
            File[]  files = dir.listFiles( filter );
            for (File  file : files) {
                Reporter.log( "  * file= " + file, true );
                _saveOvalResults( file.getCanonicalPath(), expected_object );
            }
        } else {
            File  file = new File( dir, xml_filepath );
            Reporter.log( "  * file= " + file, true );
            _saveOvalResults( file.getCanonicalPath(), expected_object );
        }

    }



    /**
     */
    private void _saveOvalResults(
                    final String xml_filepath,
                    final OvalResults expected_object
                    )
    throws Exception
    {
        OvalResults  object = _unmarshalObject( OvalResults.class, xml_filepath, expected_object );

        Reporter.log( "save..." , true );
        String  pid = _getResultsRepository().saveOvalResults( object );
        Reporter.log( "  >>> object saved: pid=" + pid, true );

        Reporter.log( "find object...", true );
        OvalResults  p_object = _getResultsRepository().findOvalResultsById( pid );
        Reporter.log( "  @ object: " + p_object, true );
    }



}
//
