package jp.go.aist.six.test.oval.core.datastore.mongodb;

import java.util.List;
import jp.go.aist.six.oval.core.datastore.mongodb.DefinitionDAO;
import jp.go.aist.six.oval.core.datastore.mongodb.MongoService;
import jp.go.aist.six.oval.core.datastore.mongodb.StateDAO;
import jp.go.aist.six.oval.core.datastore.mongodb.SystemObjectDAO;
import jp.go.aist.six.oval.core.datastore.mongodb.TestDAO;
import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;
import jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.v5.definitions.StateType;
import jp.go.aist.six.oval.model.v5.definitions.SystemObjectType;
import jp.go.aist.six.oval.model.v5.definitions.TestType;
import jp.go.aist.six.test.oval.core.CoreTestBase;
import jp.go.aist.six.test.oval.core.DefinitionsSample;
import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import com.google.code.morphia.dao.DAO;



public class MongoTest
    extends CoreTestBase
{

    private static final String _SPRING_MONGO_CONTEXT_
    = "jp/go/aist/six/test/oval/core/datastore/mongodb/mongo-context.xml";


    private ApplicationContext  _mongoContext;



    /**
     */
    @Override
    @BeforeClass( alwaysRun=true )
	public void setUp()
    throws Exception
	{
        super.setUp();

        _mongoContext = new ClassPathXmlApplicationContext( _SPRING_MONGO_CONTEXT_ );
	}



    protected <T> T _readObjectFromXml(
                    final Class<T> type,
                    final String sourceFilepath,
                    final T expected
                    )
    throws Exception
    {
        T  entity = _unmarshalWithValidation( type, sourceFilepath, "", expected );
        return entity;
    }



    //**************************************************************
    // objected are read from XML
    //**************************************************************

    @DataProvider( name="oval.definitions.oval_definitions.xml" )
    public Object[][] provideOvalObjectXml()
    {
        return new Object[][] {
                        // def:7222, windows, vulnerability, CVE-2010-0176
                        {
                            jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions.class,
                            "test/resources/data/oval-definitions-5/oval_vulnerability_windows_def7222_definitions-5.xml",
                            null
                        }
        };

    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.datastore.mongodb", "oval.definitions.oval_definitions" },
                    dataProvider="oval.definitions.oval_definitions.xml",
                    alwaysRun=true
                    )
    public void testSaveAndLoadObject(
                    final Class<OvalDefinitions> type,
                    final String xmlFilepath,
                    final OvalDefinitions expectedObject
                    )
    throws Exception
    {
        Reporter.log( "\n//// TEST: group=oval.core.datastore.mongodb oval.definitions.oval_definitions"
                        + ", method=testSaveAndLoadEntity",
                        true );

        OvalDefinitions  object = _readObjectFromXml( OvalDefinitions.class, xmlFilepath, expectedObject );

        MongoService  mongo = _mongoContext.getBean( MongoService.class );

        Reporter.log( "save..." , true );
        Reporter.log( "  * object: " + object, true );

        for (DefinitionType  def : object.getDefinitions()) {
            mongo.getDAO( DefinitionType.class ).save( def );
        }
        mongo.getDAO( OvalDefinitions.class ).save( object );


        Reporter.log( "load each object by concrete class...", true );
        OvalDefinitions  p_object = mongo.getDAO( OvalDefinitions.class ).get( object.getObjectId() );
        Reporter.log( "  @ object: " + p_object, true );
        for (DefinitionType  p_def : p_object.getDefinitions()) {
            Reporter.log( "  @ definition: " + p_def, true );
        }

//        Reporter.log( "load objects...", true );
//        List<StateType>  list = dao.find().asList();
//        Reporter.log( "  @ #objects: " + list.size(), true );
//        Reporter.log( "  @ objects: " + list, true );
    }


    @Override
    @DataProvider( name="oval.entity" )
    public Object[][] provideOvalDefinitionsOvalDefinitions()
    {
        return new Object[][] {
                        {
                            DefinitionType.class,
                            DefinitionsSample.DEF_7222
                        }
        };
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.datastore.mongodb.datastore" },
                    dataProvider="oval.entity",
                    alwaysRun=true
                    )
    public <T> void testSaveAndLoadEntityUsingDatastoreService(
                    final Class<T> entityType,
                    final T entity
                    )
    throws Exception
    {
        Reporter.log( "\n//// TEST: group=oval.core.datastore.mongodb.datastore"
                        + ", method=testSaveAndLoadEntityUsingDatastoreService",
                        true );

        MongoService  mongo = _mongoContext.getBean( MongoService.class );

        Reporter.log( "save..." , true );
        Reporter.log( "  * object: " + entity, true );
        mongo.getDAO( entityType ).save( entity );
    }



    //**************************************************************
    //

    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.datastore.mongodb", "oval.definitions.state" },
                    alwaysRun=true
                    )
    public void testOvalDefinitionsState()
    throws Exception
    {
        Reporter.log( "\n//// TEST: group=oval.core.datastore.mongodb, oval.definitions.state"
                        + ", method=testOvalDefinitionsState",
                        true );

        DAO<StateType, ObjectId>  dao = _mongoContext.getBean( StateDAO.class );
        dao.getCollection().drop();

        StateType  entity = DefinitionsSample.STE_5310;

        Reporter.log( "save..." , true );
        Reporter.log( "  * object: " + entity, true );
        dao.save( entity );

        Reporter.log( "load each object by concrete class...", true );
        StateType  p_entity = dao.get( entity.getObjectId() );
        Reporter.log( "  @ object: " + p_entity, true );

        Reporter.log( "load objects...", true );
        List<StateType>  list = dao.find().asList();
        Reporter.log( "  @ #objects: " + list.size(), true );
        Reporter.log( "  @ objects: " + list, true );
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.datastore.mongodb", "oval.definitions.object" },
                    alwaysRun=true
                    )
    public void testOvalDefinitionsObject()
    throws Exception
    {
        Reporter.log( "\n//// TEST: group=oval.core.datastore.mongodb, oval.definitions.object"
                        + ", method=testOvalDefinitionsObject",
                        true );

        DAO<SystemObjectType, ObjectId>  dao = _mongoContext.getBean( SystemObjectDAO.class );
        dao.getCollection().drop();

        SystemObjectType  entity = DefinitionsSample.OBJ_6886;

        Reporter.log( "save..." , true );
        Reporter.log( "  * object: " + entity, true );
        dao.save( entity );

        Reporter.log( "load each object by concrete class...", true );
        SystemObjectType  p_entity = dao.get( entity.getObjectId() );
        Reporter.log( "  @ object: " + p_entity, true );

        Reporter.log( "load objects...", true );
        List<SystemObjectType>  list = dao.find().asList();
        Reporter.log( "  @ #objects: " + list.size(), true );
        Reporter.log( "  @ objects: " + list, true );
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

        DAO<TestType, ObjectId>  dao = _mongoContext.getBean( TestDAO.class );
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

        DAO<DefinitionType, ObjectId>  definitionDAO = _mongoContext.getBean( DefinitionDAO.class );
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
