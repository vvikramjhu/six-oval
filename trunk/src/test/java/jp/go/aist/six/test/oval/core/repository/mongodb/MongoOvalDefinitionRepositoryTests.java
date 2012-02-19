package jp.go.aist.six.test.oval.core.repository.mongodb;

import java.util.List;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalDefinitionRepository;
import jp.go.aist.six.oval.model.OvalEntity;
import jp.go.aist.six.oval.model.common.ClassEnumeration;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.repository.DefinitionQueryParams;
import jp.go.aist.six.oval.repository.OvalEntityQueryParams;
import jp.go.aist.six.oval.repository.QueryParams;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;



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
    // test data
    //**************************************************************

    /**
     * Query parameters for OVAL Definitions.
     */
    @DataProvider( name="oval.repository.definition.queryParams" )
    public Object[][] provideOvalDefinitionRepositoryDefinitionQueryParams()
    {
        // common: order, count
        DefinitionQueryParams  params_common1 = new DefinitionQueryParams();
        params_common1.setOrder( "-version" );
        params_common1.setCount( "3" );

        // common: order, count, startIndex
        DefinitionQueryParams  params_common2 = new DefinitionQueryParams();
        params_common2.setOrder( "-version" );
        params_common2.setCount( "3" );
        params_common2.setStartIndex( "2" );

        // entity: version
        DefinitionQueryParams  params_entity1 = new DefinitionQueryParams();
        params_entity1.setVersion( "3" );

        // definition: class
        DefinitionQueryParams  params_def1 = new DefinitionQueryParams();
        params_def1.setDefinitionClass( ClassEnumeration.COMPLIANCE.value() );

        // definition: title
        DefinitionQueryParams  params_def2 = new DefinitionQueryParams();
        params_def2.setTitle( "ind-def:f" );

        return new Object[][] {
                        { params_common1 }
                        ,
                        { params_common2 }
                        ,
                        { params_entity1 }
                        ,
                        { params_def1 }
                        ,
                        { params_def2 }
        };
    }



    @DataProvider( name="oval.repository.entity.oval_id" )
    public Object[][] provideOvalDefinitionRepositoryEntityOvalId()
    {
        return new Object[][] {
                        { "oval:org.mitre.oval.test:tst:826" }
                        ,
                        { "oval:org.mitre.oval.test:obj:400" }
        };
    }



    /**
     * Query parameters for OVAL entities.
     */
    @DataProvider( name="oval.repository.entity.queryParams" )
    public Object[][] provideOvalDefinitionRepositoryEntityQueryParams()
    {
        // order, count
        OvalEntityQueryParams  params_common1 = new OvalEntityQueryParams();
        params_common1.setType( "ste" );
        params_common1.setOrder( "-version" );
        params_common1.setCount( "3" );

        // order, count, startIndex
        OvalEntityQueryParams  params_common2 = new OvalEntityQueryParams();
        params_common2.setType( "tst" );
        params_common2.setOrder( "-version" );
        params_common2.setCount( "3" );
        params_common2.setStartIndex( "2" );

        // version
        OvalEntityQueryParams  params_entity1 = new OvalEntityQueryParams();
        params_entity1.setType( "obj" );
        params_entity1.setVersion( "3" );

//        // class
//        DefinitionQueryParams  params_def1 = new DefinitionQueryParams();
//        params_def1.setDefinitionClass( ClassEnumeration.COMPLIANCE.value() );
//
//        // definition: title
//        DefinitionQueryParams  params_def2 = new DefinitionQueryParams();
//        params_def2.setTitle( "ind-def:f" );

        return new Object[][] {
                        { params_common1 }
                        ,
                        { params_common2 }
                        ,
                        { params_entity1 }
//                        ,
//                        { params_def1 }
//                        ,
//                        { params_def2 }
        };
    }



    //**************************************************************
    // test methods
    //**************************************************************

    /**
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
        long  count = _oval_def_repository.countDefinition();
        Assert.assertNotNull( def_list );
        Reporter.log( "#Definitions: " + def_list.size(), true );
        Reporter.log( "count: " + count, true );
        Assert.assertTrue( def_list.size() == count );

        for (DefinitionType  p_def : def_list) {
            Reporter.log( "  @ definition: ID=" + p_def.getOvalID(), true );
        }
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.repository.mongodb" },
                    dataProvider="oval.repository.definition.queryParams",
                    dependsOnMethods= { "testFindDefinition" },
                    alwaysRun=true
                    )
    public void testFindDefinitionByQueryParams(
                    final QueryParams params
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        List<DefinitionType>  def_list = _oval_def_repository.findDefinition( params );
        Assert.assertNotNull( def_list );
        Reporter.log( "#Definitions: " + def_list.size(), true );

        for (DefinitionType  p_def : def_list) {
            Reporter.log( "  @ definition: ID=" + p_def.getOvalID(), true );
        }
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.repository.mongodb" },
                    dataProvider="oval.repository.entity.oval_id",
                    dependsOnMethods= { "testFindDefinition" },
                    alwaysRun=true
                    )
    public void testFindEntityById(
                    final String oval_id
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        OvalEntity   p_object = _oval_def_repository.findEntityById( oval_id );
        Reporter.log( "  @ entity: " + p_object, true );
        Assert.assertTrue( oval_id.equals( p_object.getOvalID() ) );
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.repository.mongodb" },
                    dataProvider="oval.repository.entity.queryParams",
                    dependsOnMethods= { "testFindDefinition" },
                    alwaysRun=true
                    )
    public void testFindEntityByQueryParams(
                    final QueryParams params
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        List<? extends OvalEntity>  def_list = _oval_def_repository.findEntity( params );
        Assert.assertNotNull( def_list );
        Reporter.log( "#entities: " + def_list.size(), true );

        for (OvalEntity  p_def : def_list) {
            Reporter.log( "  @ entity: ID=" + p_def.getOvalID(), true );
        }
    }



}
//
