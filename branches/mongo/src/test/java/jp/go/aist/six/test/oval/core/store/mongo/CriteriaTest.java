package jp.go.aist.six.test.oval.core.store.mongo;

import java.util.Arrays;
import java.util.List;
import jp.go.aist.six.oval.model.v5.common.OperatorEnumeration;
import jp.go.aist.six.oval.model.v5.definitions.CriteriaType;
import jp.go.aist.six.oval.model.v5.definitions.CriterionType;
import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import com.google.code.morphia.dao.DAO;



public class CriteriaTest
{

    private static final String _SPRING_APP_CONTEXT_
    = "jp/go/aist/six/test/oval/core/store/mongo/mongo-context.xml";


    private ApplicationContext  _springContext;



    @BeforeClass( alwaysRun=true )
	public void setUp()
    throws Exception
	{
        _springContext = new ClassPathXmlApplicationContext( _SPRING_APP_CONTEXT_ );
	}



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "store.mongo" },
                    alwaysRun=true
                    )
    public void testSaveAndLoad()
    throws Exception
    {
        Reporter.log( "\n//// TEST: group=store.mongo"
                        + ", method=testSaveAndLoad",
                        true );

        // drop collection
//        DB  db = _mongo.getDB(  );
//        db.getCollection( "spring" ).drop();

        DAO<CriteriaType, ObjectId>  criteriaDAO = _springContext.getBean( "criteriaDAO", CriteriaDAO.class );
        criteriaDAO.getDatastore().getDB().getCollection( "test.criteria" ).drop();

        CriterionType  criterion1 = new CriterionType(
                        "oval:org.mitre.oval:tst:10688",
                        "Mozilla Seamonkey version less than 2.0"
                        );

        CriterionType  criterion2 = new CriterionType(
                        "oval:org.mitre.oval:tst:11460",
                        "Mozilla Seamonkey version 2.x and less than 2.0.4"
                        );

        CriteriaType  criteria = new CriteriaType( OperatorEnumeration.OR,
                        Arrays.asList( new CriterionType[] { criterion1, criterion2 } ) );

        Reporter.log( "save..." , true );
        Reporter.log( "  * object: " + criteria, true );
        criteriaDAO.save( criteria );

        Reporter.log( "load each object by concrete class...", true );
        CriteriaType  criteriap = criteriaDAO.get( criteria.getObjectId() );
        Reporter.log( "  @ object: " + criteriap, true );

        Reporter.log( "load objects...", true );
        List<CriteriaType>  list = criteriaDAO.find().asList();
        Reporter.log( "  @ #objects: " + list.size(), true );
        Reporter.log( "  @ objects: " + list, true );
    }

}
