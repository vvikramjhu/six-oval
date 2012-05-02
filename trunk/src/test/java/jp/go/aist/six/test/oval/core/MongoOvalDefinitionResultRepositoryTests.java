package jp.go.aist.six.test.oval.core;

import java.io.File;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalDefinitionResultRepository;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.results.OvalResults;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;



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

//    /**
//     * OVAL Results documents.
//     *
//     * Test method params:
//     *   OvalContentCategory    category,
//     *   String                 schema_version,
//     *   Class<T>               object_type,
//     *   Family                 family,
//     *   String                 dirpath,
//     *   String                 filename
//     *   T                      expected_object
//     */
//    @DataProvider( name="data:oval.res.oval_results.repository.save-oval-results" )
//    public Object[][] provideOvalResOvalResultsRepositorySaveOvalResults()
//    {
//        return new Object[][] {
//                        {
//                            OvalContentCategory.MITRE_REPOSITORY,
//                            "5.10.1",
//                            OvalResults.class,
//                            Family.WINDOWS,
//                            "test/resources/mitre_repository/oval-5.10/res/windows",
//                            null,
//                            null
//                        }
//        };
//
//    }



    ////////////////////////////////////////////////////////////////
    //  test methods
    ////////////////////////////////////////////////////////////////

    /**
     * saveOvalResults(oval_results), findOvalResultsById(id)
     */
    @org.testng.annotations.Test(
                    groups={
                                    "java:oval.core.repository.mongodb",
                                    "data:oval.res",
                                    "control:repository.saveOvalResults"
                                    },
//                    dependsOnGroups={ "control:repository.saveElement" },
                    dataProvider="data:oval.res.oval_results",
                    alwaysRun=true
                    )
    public void testSaveOvalResults(
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

}
//
