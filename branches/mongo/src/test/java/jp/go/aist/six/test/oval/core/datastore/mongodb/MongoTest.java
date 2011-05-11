package jp.go.aist.six.test.oval.core.datastore.mongodb;

import java.util.List;
import jp.go.aist.six.oval.core.datastore.mongodb.DefinitionDAO;
import jp.go.aist.six.oval.core.datastore.mongodb.TestDAO;
import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;
import jp.go.aist.six.oval.model.v5.definitions.TestType;
import jp.go.aist.six.test.oval.core.DefinitionsSample;
import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import com.google.code.morphia.dao.DAO;



public class MongoTest
{

    private static final String _SPRING_APP_CONTEXT_
    = "jp/go/aist/six/test/oval/core/datastore/mongodb/mongo-context.xml";


    private ApplicationContext  _springContext;



    /**
     */
    @BeforeClass( alwaysRun=true )
	public void setUp()
    throws Exception
	{
        _springContext = new ClassPathXmlApplicationContext( _SPRING_APP_CONTEXT_ );
	}



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.datastore.mongodb", "oval.definitions.test" },
                    alwaysRun=true
                    )
    public void testOvalDefinitionsTest()
    throws Exception
    {
        Reporter.log( "\n//// TEST: group=oval.core.datastore.mongodb, oval.definitions.test"
                        + ", method=testOvalDefinitionsTest",
                        true );

        DAO<TestType, ObjectId>  dao = _springContext.getBean( TestDAO.class );
        dao.getCollection().drop();

        TestType  entity = DefinitionsSample.TST_11127;

        Reporter.log( "save..." , true );
        Reporter.log( "  * object: " + entity, true );
        dao.save( entity );

        Reporter.log( "load each object by concrete class...", true );
        TestType  p_entity = dao.get( entity.getObjectId() );
        Reporter.log( "  @ object: " + p_entity, true );

        Reporter.log( "load objects...", true );
        List<TestType>  list = dao.find().asList();
        Reporter.log( "  @ #objects: " + list.size(), true );
        Reporter.log( "  @ objects: " + list, true );
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.datastore.mongodb", "oval.definitions.definition" },
                    alwaysRun=true
                    )
    public void testOvalDefinitionsDefinition()
    throws Exception
    {
        Reporter.log( "\n//// TEST: group=oval.core.datastore.mongodb, oval.definitions.definition"
                        + ", method=testSaveAndLoadDefinition",
                        true );

        DAO<DefinitionType, ObjectId>  definitionDAO = _springContext.getBean( DefinitionDAO.class );
        definitionDAO.getCollection().drop();
//        definitionDAO.getDatastore().getDB().getCollection( "oval.definitions.definition" ).drop();

        DefinitionType  def = DefinitionsSample.DEF_7222;

        Reporter.log( "save..." , true );
        Reporter.log( "  * object: " + def, true );
        definitionDAO.save( def );

        Reporter.log( "load each object by concrete class...", true );
        DefinitionType  p_def = definitionDAO.get( def.getObjectId() );
        Reporter.log( "  @ object: " + p_def, true );

        Reporter.log( "load objects...", true );
        List<DefinitionType>  list = definitionDAO.find().asList();
        Reporter.log( "  @ #objects: " + list.size(), true );
        Reporter.log( "  @ objects: " + list, true );
    }
//    /**
//     */
//    @org.testng.annotations.Test(
//                    groups={ "store.mongo" },
//                    alwaysRun=true
//                    )
//    public void testSaveAndLoad()
//    throws Exception
//    {
//        Reporter.log( "\n//// TEST: group=store.mongo"
//                        + ", method=testSaveAndLoad",
//                        true );
//
//        // drop collection
////        DB  db = _mongo.getDB(  );
////        db.getCollection( "spring" ).drop();
//
//        DAO<CriteriaType, ObjectId>  criteriaDAO = _springContext.getBean( "criteriaDAO", CriteriaDAO.class );
//        criteriaDAO.getDatastore().getDB().getCollection( "test.criteria" ).drop();
//
//        CriterionType  criterion1 = new CriterionType(
//                        "oval:org.mitre.oval:tst:10688",
//                        "Mozilla Seamonkey version less than 2.0"
//                        );
//
//        CriterionType  criterion2 = new CriterionType(
//                        "oval:org.mitre.oval:tst:11460",
//                        "Mozilla Seamonkey version 2.x and less than 2.0.4"
//                        );
//
//        CriteriaType  criteria1 = new CriteriaType( OperatorEnumeration.OR,
//                        Arrays.asList( new CriteriaElement[] { criterion1, criterion2 } ) );
//
//        ExtendDefinitionType  extdef1 = new ExtendDefinitionType(
//                        "oval:org.mitre.oval:def:6372",
//                        "Mozilla Seamonkey is installed"
//                        );
//
//        CriteriaType  criteria2 = new CriteriaType( OperatorEnumeration.AND,
//                        Arrays.asList( new CriteriaElement[] { extdef1, criteria1 } ) );
//
//        Reporter.log( "save..." , true );
//        Reporter.log( "  * object: " + criteria2, true );
//        criteriaDAO.save( criteria2 );
//
//        Reporter.log( "load each object by concrete class...", true );
//        CriteriaType  criteriap = criteriaDAO.get( criteria2.getObjectId() );
//        Reporter.log( "  @ object: " + criteriap, true );
//
//        Reporter.log( "load objects...", true );
//        List<CriteriaType>  list = criteriaDAO.find().asList();
//        Reporter.log( "  @ #objects: " + list.size(), true );
//        Reporter.log( "  @ objects: " + list, true );
//    }

}
