package jp.go.aist.six.test.oval.core.repository.mongodb;

import java.util.List;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalDefinitionRepository;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;



/**
 * Tests: OVAL Repository using MongoDB.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class MongoOvalDefinitionRepositoryTests
{

    private MongoOvalDefinitionRepository  _oval_def_repository;



    /**
     */
    @BeforeClass( alwaysRun=true )
	public void setUp()
    throws Exception
	{
        _oval_def_repository = OvalContext.INSTANCE.getBean( MongoOvalDefinitionRepository.class );
	}



    //**************************************************************
    // tests
    //**************************************************************

    /**
                    dataProvider="oval.xml",
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.repository.mongodb" },
                    alwaysRun=true
                    )
    public void testFindDefinition(
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        List<DefinitionType>  def_list = _oval_def_repository.findDefinition();
        Assert.assertNotNull( def_list );
        Reporter.log( "#Definitions: " + def_list.size(), true );

        for (DefinitionType  p_def : def_list) {
            Reporter.log( "  @ definition: ID=" + p_def.getOvalID(), true );
        }
    }
}
//
