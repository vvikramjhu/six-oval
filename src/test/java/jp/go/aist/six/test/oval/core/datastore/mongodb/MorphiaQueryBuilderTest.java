package jp.go.aist.six.test.oval.core.datastore.mongodb;

import java.util.List;
import jp.go.aist.six.oval.core.datastore.mongodb.MongoDatastore;
import jp.go.aist.six.oval.core.datastore.mongodb.MorphiaQueryBuilder;
import jp.go.aist.six.oval.model.OvalObject;
import jp.go.aist.six.oval.model.v5.common.ClassEnumeration;
import jp.go.aist.six.util.persist.Persistable;
import jp.go.aist.six.util.search.Binding;
import jp.go.aist.six.util.search.Limit;
import jp.go.aist.six.util.search.Order;
import jp.go.aist.six.util.search.RelationalBinding;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import com.google.code.morphia.dao.DAO;
import com.google.code.morphia.query.Query;



public class MorphiaQueryBuilderTest
{

    private static final String _SPRING_MONGO_CONTEXT_
    = "six-oval_spring-context.xml";


    private MongoDatastore  _datastore;



    /**
     */
    @BeforeClass( alwaysRun=true )
	public void setUp()
    throws Exception
	{
        ApplicationContext  context =  new ClassPathXmlApplicationContext( _SPRING_MONGO_CONTEXT_ );
        _datastore = context.getBean( MongoDatastore.class );
	}



    @DataProvider( name="oval.query" )
    public Object[][] provideOvalQuery()
    {
        return new Object[][] {
                      {
                          jp.go.aist.six.oval.model.v5.definitions.DefinitionType.class,
                          new RelationalBinding( "class", ClassEnumeration.VULNERABILITY ),
                          null,
                          new Limit( 10, 0 )
                      }
        };

    }


    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.datastore.mongodb.MorphiaQueryBuilder" },
                    dataProvider="oval.query",
                    alwaysRun=true
                    )
    public <K, T extends OvalObject & Persistable<K>> void testBuild(
                    final Class<T> type,
                    final Binding filter,
                    final List<? extends Order> orders,
                    final Limit limit
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        Reporter.log( "* target type: " + type, true );
        Reporter.log( "* target filter: " + filter, true );

        DAO<T, K>  dao = _datastore.getDAO( type );
        Query<T>  query = dao.createQuery();
        Reporter.log( "* initial query: " + query, true );

        MorphiaQueryBuilder<T>  builder = new MorphiaQueryBuilder<T>( query, filter );
        query = builder.build();
        Reporter.log( "@ built query: " + query, true );

        if (orders != null  ||  limit != null) {
            query = builder.build( orders, limit );
            Reporter.log( "@ built query with orders and limit: " + query, true );
        }
    }

}
// MorphiaQueryBuilderTest
