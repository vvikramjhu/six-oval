package jp.go.aist.six.test.oval.core.repository.web;

import java.io.File;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.oval.core.repository.web.HttpOvalRepositoryClient;
import jp.go.aist.six.oval.model.ElementType;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.common.ClassEnumeration;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.DefinitionsElement;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.repository.DefinitionQueryParams;
import jp.go.aist.six.oval.repository.QueryResults;
import jp.go.aist.six.test.oval.core.OvalContentCategory;
import jp.go.aist.six.test.oval.core.OvalCoreTestBase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class HttpOvalRepositoryClientTests
    extends OvalCoreTestBase
{

    private HttpOvalRepositoryClient  _repository_client;



    /**
     */
    @Override
    @BeforeClass( alwaysRun=true )
	public void setUp()
    throws Exception
	{
        super.setUp();

        _repository_client = OvalContext.getInstance().getBean( HttpOvalRepositoryClient.class );
//        _repository_client = new HttpOvalRepositoryClient();

        Reporter.log( "  * base URL: " + _repository_client.getRepositoryBaseUrl(), true );
	}




    ////////////////////////////////////////////////////////////////
    //  support methods
    ////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////
    //  test data
    ////////////////////////////////////////////////////////////////


    ///////////////////////////////////////////////////////////////////////
    //  test methods
    ///////////////////////////////////////////////////////////////////////

    //*********************************************************************
    //  oval-def:definition
    //*********************************************************************

    /**
     * findDefinitionById(oval_id)
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.def.definition",
                                    "PACKAGE.oval.core.repository.web",
                                    "CONTROL.oval.repository.findDefinitionById"
                                    }
//                    ,dependsOnGroups={ "CONTROL.oval.repository.findDefinition" }
                    ,dataProvider="DATA.oval.def.definition"
                    ,alwaysRun=true
                    )
    public void testFindDefinitionById(
                    final OvalContentCategory       category,
                    final String                    schema_version,
                    final Class<DefinitionType>     object_type,
                    final ElementType   type,
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
        DefinitionType  def = _repository_client.findDefinitionById( oval_id );
        Reporter.log( "<<< ...findDefinitionById(oval_id)", true );
        Reporter.log( "  @ response: " + def, true );
        Assert.assertNotNull( def );
        Assert.assertEquals( def.getOvalId(), oval_id );
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.def.definition",
                                    "PACKAGE.oval.core.repository.web",
                                    "CONTROL.oval.repository.findDefinitionByQuery",
                                    "CONTROL.oval.repository.findDefinitionIdByQuery",
                                    "CONTROL.oval.repository.countDefinitionByQuery"
                                    }
//                    ,dependsOnGroups={ "CONTROL.oval.repository.findDefinition" }
                    ,alwaysRun=true
                    )
    public void testFindDefinition()
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        // definition: definitionClass
        DefinitionQueryParams  params20 = new DefinitionQueryParams();
        params20.setDefinitionClass( ClassEnumeration.COMPLIANCE );

        Reporter.log( ">>> findDefinition(params)...", true );
        QueryResults<DefinitionType>  def_results = _repository_client.findDefinition( params20 );
        Reporter.log( "<<< ...findDefinition(params)", true );
        Reporter.log( "  @ response: " + def_results, true );
        Assert.assertNotNull( def_results );

        Reporter.log( ">>> findDefinitionId(params)...", true );
        QueryResults<String>  id_results = _repository_client.findDefinitionId( params20 );
        Reporter.log( "<<< ...findDefinitionId(params)", true );
        Reporter.log( "  @ response: " + id_results, true );
        Assert.assertNotNull( id_results );

        Reporter.log( ">>> countDefinition(params)...", true );
        long  count_results = _repository_client.countDefinition( params20 );
        Reporter.log( "<<< ...countDefinition(params)", true );
        Reporter.log( "  @ response: " + count_results, true );


        Assert.assertEquals( def_results.size(), count_results );
        Assert.assertEquals(  id_results.size(), count_results );
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.def.element",
                                    "PACKAGE.oval.core.repository.web",
                                    "CONTROL.oval.repository.findElementById"
                                    }
//                    ,dependsOnGroups={ "CONTROL.oval.repository.findDefinition" }
                    ,alwaysRun=true
                    )
    public void testFindElementById()
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        String[]  ids = new String[] {
                        "oval:org.mitre.oval.test:tst:906",
                        "oval:org.mitre.oval.test:obj:427",
                        "oval:org.mitre.oval.test:ste:429",
                        "oval:org.mitre.oval.test:var:184"
        };

        for (String  id : ids) {
            Reporter.log( ">>> findElementById(oval_id)...", true );
            DefinitionsElement  element = _repository_client.findElementById( id );
            Reporter.log( "<<< ...findElementById(oval_id)", true );
            Reporter.log( "  @ response: " + element, true );
        }

    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.def.oval_definitions",
                                    "PACKAGE.oval.core.repository.web",
                                    "CONTROL.oval.repository.saveOvalDefinitions"
                                    }
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
            String  p_id = _repository_client.saveOvalDefinitions( oval_defs );
            Reporter.log( "<<< ...saveOvalDefinitions(oval_defs)", true );
            Reporter.log( "  @ ID: " + p_id, true );
            Assert.assertNotNull( p_id );

            Reporter.log( ">>> findOvalDefinitionsById(id)...", true );
            OvalDefinitions  p_oval_defs = _repository_client.findOvalDefinitionsById( p_id );
            Reporter.log( "<<< ...findOvalDefinitionsById(id)", true );
            Assert.assertNotNull( p_oval_defs );
            _printOvalIds( p_oval_defs.getDefinitions() );

            String    digest =   oval_defs.getDefinitionsDigest();
            String  p_digest = p_oval_defs.getDefinitionsDigest();
            Assert.assertEquals( digest, p_digest );
        }
    }




    ///////////////////////////////////////////////////////////////////////
    //  oval-res:oval_results
    ///////////////////////////////////////////////////////////////////////

    /**
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.res.oval_results",
                                    "PACKAGE.oval.core.repository.web",
                                    "CONTROL.oval.repository.findOvalResults",
                                    "CONTROL.oval.repository.findOvalResultsId",
                                    "CONTROL.oval.repository.countOvalResults"
                                    }
//                    ,dependsOnGroups={ "CONTROL.oval.repository.findDefinition" }
                    ,alwaysRun=true
                    )
    public void testFindOvalResults()
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        Reporter.log( ">>> findOvalResults()...", true );
        QueryResults<OvalResults>  res_results = _repository_client.findOvalResults();
        Reporter.log( "<<< ...findOvalResults()", true );
        Reporter.log( "  @ response: " + res_results, true );
        Assert.assertNotNull( res_results );

        Reporter.log( ">>> findOvalResultsId()...", true );
        QueryResults<String>  id_results = _repository_client.findOvalResultsId();
        Reporter.log( "<<< ...findOvalResultsId()", true );
        Reporter.log( "  @ response: " + id_results, true );
        Assert.assertNotNull( id_results );

        Reporter.log( ">>> countOvalResults()...", true );
        long  count_results = _repository_client.countOvalResults();
        Reporter.log( "<<< ...countOvalResults()", true );
        Reporter.log( "  @ response: " + count_results, true );


        Assert.assertEquals( res_results.size(), count_results );
        Assert.assertEquals(  id_results.size(), count_results );
    }




}
//
