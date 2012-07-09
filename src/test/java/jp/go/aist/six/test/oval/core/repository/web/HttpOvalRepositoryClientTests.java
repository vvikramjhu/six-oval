package jp.go.aist.six.test.oval.core.repository.web;

import jp.go.aist.six.oval.core.repository.web.HttpOvalRepositoryClient;
import jp.go.aist.six.oval.model.ElementType;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.common.ClassEnumeration;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
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

        _repository_client = new HttpOvalRepositoryClient();
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
                                    "CONTROL.oval.repository.findDefinition"
                                    }
//                    ,dependsOnGroups={ "CONTROL.oval.repository.findDefinition" }
                    ,alwaysRun=true
                    )
    public void testFindDefinition()
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        Reporter.log( ">>> findDefinition()...", true );
        QueryResults<DefinitionType>  def = _repository_client.findDefinition();
        Reporter.log( "<<< ...findDefinition()", true );
        Reporter.log( "  @ response: " + def, true );
        Assert.assertNotNull( def );
//        Assert.assertEquals( def.getOvalId(), oval_id );
    }



}
//
