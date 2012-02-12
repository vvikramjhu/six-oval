package jp.go.aist.six.test.oval.core.repository.mongodb;

import java.util.List;
import jp.go.aist.six.oval.core.repository.mongodb.DefinitionDAO;
import jp.go.aist.six.oval.core.repository.mongodb.MongoDatastore;
import jp.go.aist.six.oval.core.repository.mongodb.StateDAO;
import jp.go.aist.six.oval.core.repository.mongodb.SystemObjectDAO;
import jp.go.aist.six.oval.core.repository.mongodb.TestDAO;
import jp.go.aist.six.oval.core.repository.mongodb.VariableDAO;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.StateType;
import jp.go.aist.six.oval.model.definitions.SystemObjectType;
import jp.go.aist.six.oval.model.definitions.TestType;
import jp.go.aist.six.oval.model.definitions.VariableType;
import jp.go.aist.six.test.oval.core.CoreTestBase;
import jp.go.aist.six.test.oval.core.DefinitionsSample;
import jp.go.aist.six.util.persist.Persistable;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import com.google.code.morphia.dao.DAO;



public class MongoOvalRepositoryTest
    extends CoreTestBase
{

//    private static final String _SPRING_MONGO_CONTEXT_
//    = "context_repository.xml";
//    = "six-oval_spring-context.xml";
//    = "jp/go/aist/six/test/oval/core/datastore/mongodb/mongo-context.xml";


    private MongoDatastore  _datastore;



    /**
     */
    @Override
    @BeforeClass( alwaysRun=true )
	public void setUp()
    throws Exception
	{
        super.setUp();

        _datastore = _getContext().getBean( MongoDatastore.class );
	}



    protected <T> T _readObjectFromXml(
                    final Class<T> type,
                    final String sourceFilepath,
                    final T expected
                    )
    throws Exception
    {
        T  entity = _unmarshalWithValidation( type, sourceFilepath, expected );
        return entity;
    }



    //**************************************************************
    // objected are read from XML
    //**************************************************************

    @Override
    @DataProvider( name="oval.xml" )
    public Object[][] provideOvalXml()
    {
        return new Object[][] {
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            "test/resources/OvalTestContent/5.10/windows/ind-def_family_test.xml",
                            null
                        }
                        /* Windows */
//                        // def:7222 version=3, windows, vulnerability, CVE-2010-0176
//                        {
//                            jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/oval5.7_def7222-3_v_windows_CVE-2010-0176.xml",
//                            null
//                        }
//                        ,
//
//                        // def:7222 version=5, windows, vulnerability, CVE-2010-0176
//                        {
//                            jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/oval5.9_def7222-5_v_windows_CVE-2010-0176.xml",
//                            null
//                        }
//                      ,
//                      // ---> results
//                        {
//                            jp.go.aist.six.oval.model.v5.results.OvalResults.class,
//                            "test/resources/data/oval5/oval5.9_def7222-5_v_windows_CVE-2010-0176_results.xml",
//                            null
//                        }
//                        ,
//                        {
//                            jp.go.aist.six.oval.model.results.OvalResults.class,
//                            "test/resources/data/oval5/oval5.10_def7222-5_v_windows_CVE-2010-0176_results.xml",
//                            null
//                        }
//                  ,
//                        // def:12313, windows, vulnerability, CVE-2011-0031
//                      {
//                          jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                          "test/resources/data/oval5/oval5.9_def12313-5_v_windows_CVE-2011-0031.xml",
//                          null
//                      }
//                      ,
//
//                      // def:7120, windows, vulnerability, CVE-2010-0820
//                      {
//                          jp.go.aist.six.oval.model.v5.results.OvalResults.class,
//                          "test/resources/data/oval-results-5/oval-5.9_def7120_vulnerability_windows_results.xml",
//                          null
//                      }
//
                        /* Debian 5 */
//                        // def:7432, debian, patch, DSA-2027
//                        {
//                            jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/oval5.9_def7432-3_p_debian5_DSA2027.xml",
//                            null
//                        }
//                      ,
//                      // ---> results
//                        {
//                            jp.go.aist.six.oval.model.results.OvalResults.class,
//                            "test/resources/data/oval5/oval5.9_def7432-3_p_debian5_DSA-2027_results.xml",
//                            null
//                        }
        };

    }


    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.repository.mongodb.saveAndLoad" },
                    dataProvider="oval.xml",
                    alwaysRun=true
                    )
    public <K, T extends Persistable<K>> void testSaveAndLoad(
                    final Class<T> type,
                    final String xmlFilepath,
                    final T expectedObject
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        Reporter.log( "target object type: " + type, true );

        T  object = _readObjectFromXml( type, xmlFilepath, expectedObject );

        Reporter.log( "save..." , true );
        Reporter.log( "  * object: " + object, true );

//        for (DefinitionType  def : object.getDefinitions().getDefinition()) {
//            mongo.getDAO( DefinitionType.class ).save( def );
//        }

        K  pid = _datastore.create( type, object );
        Reporter.log( "  >>> object created: pid=" + pid, true );

        Reporter.log( "load each object by concrete class...", true );
        T  p_object = _datastore.load( type, object.getPersistentID() );
        Reporter.log( "  @ object: " + p_object, true );

        if (p_object instanceof OvalDefinitions) {
            OvalDefinitions  p_oval_defs = (OvalDefinitions)p_object;
            for (DefinitionType  p_def : p_oval_defs.getDefinitions().getDefinition()) {
                Reporter.log( "  @ definition: " + p_def, true );
            }
        }
    }
//    {
//        Reporter.log( "\n//////////////////////////////////////////////////////////",
//                        true );
//
//        Reporter.log( "target object type: " + type, true );
//
//        T  object = _readObjectFromXml( type, xmlFilepath, expectedObject );
//
//        MongoService  mongo = _mongoContext.getBean( MongoService.class );
//
//        Reporter.log( "save..." , true );
//        Reporter.log( "  * object: " + object, true );
//
////        for (DefinitionType  def : object.getDefinitions().getDefinition()) {
////            mongo.getDAO( DefinitionType.class ).save( def );
////        }
//        mongo.getDAO( type ).save( object );
//
//
//        Reporter.log( "load each object by concrete class...", true );
//        T  p_object = mongo.getDAO( type ).get( object.getPersistentID() );
//        Reporter.log( "  @ object: " + p_object, true );
//        if (p_object instanceof OvalDefinitions) {
//            OvalDefinitions  p_oval_defs = (OvalDefinitions)p_object;
//            for (DefinitionType  p_def : p_oval_defs.getDefinitions().getDefinition()) {
//                Reporter.log( "  @ definition: " + p_def, true );
//            }
//        }
//    }


    @Override
    @DataProvider( name="oval.definitions.oval_definitions.xml" )
    public Object[][] provideOvalDefinitionsXml()
    {
        return new Object[][] {
                        // def:7120, windows, vulnerability, CVE-2010-0820
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            "test/resources/data/oval-definitions-5/oval_windows_vulnerability_def7120_definitions5.9.xml",
                            null
                        }
        };

    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.repository.mongodb", "oval.definitions.oval_definitions" },
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

        Reporter.log( "save..." , true );
        Reporter.log( "  * object: " + object, true );

//        for (DefinitionType  def : object.getDefinitions().getDefinition()) {
//            mongo.getDAO( DefinitionType.class ).save( def );
//        }
        _datastore.getDAO( OvalDefinitions.class ).save( object );


        Reporter.log( "load each object by concrete class...", true );
        OvalDefinitions  p_object = _datastore.getDAO( OvalDefinitions.class ).get( object.getPersistentID() );
        Reporter.log( "  @ object: " + p_object, true );
        for (DefinitionType  p_def : p_object.getDefinitions().getDefinition()) {
            Reporter.log( "  @ definition: " + p_def, true );
        }

//        Reporter.log( "load objects...", true );
//        List<StateType>  list = dao.find().asList();
//        Reporter.log( "  @ #objects: " + list.size(), true );
//        Reporter.log( "  @ objects: " + list, true );
    }


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
                    groups={ "oval.core.repository.mongodb.datastore" },
                    dataProvider="oval.entity",
                    alwaysRun=true
                    )
    public <T> void testSaveAndLoadEntityUsingDatastoreService(
                    final Class<T> entityType,
                    final T entity
                    )
    throws Exception
    {
        Reporter.log( "\n//// TEST: group=oval.core.repository.mongodb.datastore"
                        + ", method=testSaveAndLoadEntityUsingDatastoreService",
                        true );

        Reporter.log( "save..." , true );
        Reporter.log( "  * object: " + entity, true );
        _datastore.getDAO( entityType ).save( entity );
    }



    //**************************************************************
    //

    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.repository.mongodb", "oval.definitions.variable" },
                    alwaysRun=true
                    )
    public void testOvalDefinitionsVariable()
    throws Exception
    {
        Reporter.log( "\n//// TEST: group=oval.core.repository.mongodb, oval.definitions.variable"
                        + ", method=testOvalDefinitionsVariable",
                        true );

        DAO<VariableType, String>  dao = _getContext().getBean( VariableDAO.class );
        dao.getCollection().drop();

        VariableType  entity = DefinitionsSample.VAR_200;

        Reporter.log( "save..." , true );
        Reporter.log( "  * object: " + entity, true );
        dao.save( entity );

        Reporter.log( "load each object by concrete class...", true );
        VariableType  p_entity = dao.get( entity.getPersistentID() );
        Reporter.log( "  @ object: " + p_entity, true );

        Reporter.log( "load objects...", true );
        List<VariableType>  list = dao.find().asList();
        Reporter.log( "  @ #objects: " + list.size(), true );
        Reporter.log( "  @ objects: " + list, true );
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.repository.mongodb", "oval.definitions.state" },
                    alwaysRun=true
                    )
    public void testOvalDefinitionsState()
    throws Exception
    {
        Reporter.log( "\n//// TEST: group=oval.core.repository.mongodb, oval.definitions.state"
                        + ", method=testOvalDefinitionsState",
                        true );

        DAO<StateType, String>  dao = _getContext().getBean( StateDAO.class );
        dao.getCollection().drop();

        StateType  entity = DefinitionsSample.STE_5310;

        Reporter.log( "save..." , true );
        Reporter.log( "  * object: " + entity, true );
        dao.save( entity );

        Reporter.log( "load each object by concrete class...", true );
        StateType  p_entity = dao.get( entity.getPersistentID() );
        Reporter.log( "  @ object: " + p_entity, true );

        Reporter.log( "load objects...", true );
        List<StateType>  list = dao.find().asList();
        Reporter.log( "  @ #objects: " + list.size(), true );
        Reporter.log( "  @ objects: " + list, true );
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.repository.mongodb", "oval.definitions.object" },
                    alwaysRun=true
                    )
    public void testOvalDefinitionsObject()
    throws Exception
    {
        Reporter.log( "\n//// TEST: group=oval.core.repository.mongodb, oval.definitions.object"
                        + ", method=testOvalDefinitionsObject",
                        true );

        DAO<SystemObjectType, String>  dao = _getContext().getBean( SystemObjectDAO.class );
        dao.getCollection().drop();

        SystemObjectType  entity = DefinitionsSample.OBJ_6886;

        Reporter.log( "save..." , true );
        Reporter.log( "  * object: " + entity, true );
        dao.save( entity );

        Reporter.log( "load each object by concrete class...", true );
        SystemObjectType  p_entity = dao.get( entity.getPersistentID() );
        Reporter.log( "  @ object: " + p_entity, true );

        Reporter.log( "load objects...", true );
        List<SystemObjectType>  list = dao.find().asList();
        Reporter.log( "  @ #objects: " + list.size(), true );
        Reporter.log( "  @ objects: " + list, true );
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.repository.mongodb", "oval.definitions.test" },
                    alwaysRun=true
                    )
    public void testOvalDefinitionsTest()
    throws Exception
    {
        Reporter.log( "\n//// TEST: group=oval.core.repository.mongodb, oval.definitions.test"
                        + ", method=testOvalDefinitionsTest",
                        true );

        DAO<TestType, String>  dao = _getContext().getBean( TestDAO.class );
        dao.getCollection().drop();

        TestType  entity = DefinitionsSample.TST_11127;

        Reporter.log( "save..." , true );
        Reporter.log( "  * object: " + entity, true );
        dao.save( entity );

        Reporter.log( "load each object by concrete class...", true );
        TestType  p_entity = dao.get( entity.getPersistentID() );
        Reporter.log( "  @ object: " + p_entity, true );

        Reporter.log( "load objects...", true );
        List<TestType>  list = dao.find().asList();
        Reporter.log( "  @ #objects: " + list.size(), true );
        Reporter.log( "  @ objects: " + list, true );
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.repository.mongodb", "oval.definitions.definition" },
                    alwaysRun=true
                    )
    public void testOvalDefinitionsDefinition()
    throws Exception
    {
        Reporter.log( "\n//// TEST: group=oval.core.repository.mongodb, oval.definitions.definition"
                        + ", method=testSaveAndLoadDefinition",
                        true );

        DAO<DefinitionType, String>  definitionDAO = _getContext().getBean( DefinitionDAO.class );
        definitionDAO.getCollection().drop();
//        definitionDAO.getDatastore().getDB().getCollection( "oval.definitions.definition" ).drop();

        DefinitionType  def = DefinitionsSample.DEF_7222;

        Reporter.log( "save..." , true );
        Reporter.log( "  * object: " + def, true );
        definitionDAO.save( def );

        Reporter.log( "load each object by concrete class...", true );
        DefinitionType  p_def = definitionDAO.get( def.getPersistentID() );
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
