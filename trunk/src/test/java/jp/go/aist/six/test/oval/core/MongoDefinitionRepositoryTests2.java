package jp.go.aist.six.test.oval.core;

import java.util.List;
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
public class MongoDefinitionRepositoryTests2
extends MongoTests
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
    //  test data
    ////////////////////////////////////////////////////////////////



    ////////////////////////////////////////////////////////////////
    //  test methods
    ////////////////////////////////////////////////////////////////

    /**
     */
    @org.testng.annotations.Test(
                    groups={
                                    "java:oval.core.repository.mongodb",
                                    "oval:oval.def",
                                    "operation:repository.find",
                                    "operation:repository.count"
                                    },
                    dependsOnGroups={ "operation:datastore.save" },
                    alwaysRun=true
                    )
    public void testFindAndCountDefinition()
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

        Assert.assertTrue( def_list.size() == count );
    }

}
//
