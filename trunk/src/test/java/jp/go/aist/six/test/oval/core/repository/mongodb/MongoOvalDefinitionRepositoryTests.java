package jp.go.aist.six.test.oval.core.repository.mongodb;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalDatastore;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalDefinitionRepository;
import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalEntity;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.common.ClassEnumeration;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.StateType;
import jp.go.aist.six.oval.model.definitions.SystemObjectType;
import jp.go.aist.six.oval.model.definitions.TestType;
import jp.go.aist.six.oval.model.definitions.VariableType;
import jp.go.aist.six.oval.repository.DefinitionQueryParams;
import jp.go.aist.six.oval.repository.OvalEntityQueryParams;
import jp.go.aist.six.oval.repository.QueryParams;
import jp.go.aist.six.test.oval.core.TestBase;
import jp.go.aist.six.test.oval.core.XmlFilenameFilter;
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
extends TestBase
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

        _oval_def_repository = _getContext().getBean( MongoOvalDefinitionRepository.class );
	}



    protected MongoOvalDefinitionRepository _getDefinitionRepository()
    {
        return _oval_def_repository;
    }



    //**************************************************************
    // test data
    //**************************************************************

    /**
     * Query parameters for OVAL Definition.
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

        // definition: refId
        DefinitionQueryParams  params_def3 = new DefinitionQueryParams();
        params_def3.setRefId( "CVE-2010-0176" );

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
                        ,
                        { params_def3 }
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
        params_common1.setType( "state" );
        params_common1.setOrder( "-version" );
        params_common1.setCount( "3" );

        // order, count, startIndex
        OvalEntityQueryParams  params_common2 = new OvalEntityQueryParams();
        params_common2.setType( "test" );
        params_common2.setOrder( "-version" );
        params_common2.setCount( "3" );
        params_common2.setStartIndex( "2" );

        // version
        OvalEntityQueryParams  params_entity1 = new OvalEntityQueryParams();
        params_entity1.setType( "object" );
        params_entity1.setVersion( "3" );

        // component
        OvalEntityQueryParams  params_entity2 = new OvalEntityQueryParams();
        params_entity2.setType( "test" );
        params_entity2.setComponent( "textfilecontent54" );

        // component, platform
        OvalEntityQueryParams  params_entity3 = new OvalEntityQueryParams();
        params_entity3.setType( "test" );
        params_entity3.setComponent( OvalComponentType.regkeyeffectiverights53.name() );
        params_entity3.setPlatform( OvalPlatformType.windows.name() );


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
                        ,
                        { params_entity2 }
                        ,
                        { params_entity3 }
        };
    }



    //**************************************************************
    // test methods
    //**************************************************************

    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.repository.mongodb.read" },
                    dependsOnMethods= { "testSaveOvalDefinitions" },
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
                    groups={ "oval.core.repository.mongodb.read" },
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
                    groups={ "oval.core.repository.mongodb.read" },
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
        Reporter.log( "* OVAL ID: " + oval_id, true );

        OvalEntity   p_object = _oval_def_repository.findEntityById( oval_id );
        Reporter.log( "  @ entity: " + p_object, true );
        if (p_object != null) {
            Assert.assertTrue( oval_id.equals( p_object.getOvalID() ) );
        }
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.repository.mongodb.read" },
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

        List<OvalEntity>  list = _oval_def_repository.findEntity( params );
        Assert.assertNotNull( list );
        Reporter.log( "#entities: " + list.size(), true );

        for (OvalEntity  p_def : list) {
            Reporter.log( "  @ entity: ID=" + p_def.getOvalID(), true );
        }
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.repository.mongodb.write" },
                    dataProvider="oval.test_content.def",
                    alwaysRun=true
                    )
    public void testSaveOvalDefinitions(
                    final Class<OvalDefinitions>          object_type,
                    final String            oval_schema_version,
                    final OvalPlatformType  platform,
                    final String            dirpath,
                    final String            xml_filepath,
                    final OvalDefinitions   expected_object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );
        Reporter.log( "* object type: " + object_type, true );
        Reporter.log( "* OVAL schema version: " + oval_schema_version, true );
        Reporter.log( "* platform: " + platform.name(), true );
        Reporter.log( "* dir: " + dirpath, true );
        Reporter.log( "* XML file: " + xml_filepath, true );

        File  dir = new File( dirpath );

        if (xml_filepath == null) {
            FilenameFilter  filter = new XmlFilenameFilter();
            File[]  files = dir.listFiles( filter );
            for (File  file : files) {
                Reporter.log( "  * file= " + file, true );
                _saveOvalDefinitions( file.getCanonicalPath(), expected_object );
            }
        } else {
            File  file = new File( dir, xml_filepath );
            Reporter.log( "  * file= " + file, true );
            _saveOvalDefinitions( file.getCanonicalPath(), expected_object );
        }

    }



    /**
     */
    private void _saveOvalDefinitions(
                    final String xmlFilepath,
                    final OvalDefinitions expectedObject
                    )
    throws Exception
    {
        OvalDefinitions  object = _unmarshalObject( OvalDefinitions.class, xmlFilepath, expectedObject );

        Reporter.log( "save..." , true );
        String  pid = _getDefinitionRepository().saveOvalDefinitions( object );
        Reporter.log( "  >>> object saved: pid=" + pid, true );

        Reporter.log( "find object...", true );
        OvalDefinitions  p_object = _getDefinitionRepository().findOvalDefinitionsById( pid );
        Reporter.log( "  @ object: " + p_object, true );

        for (DefinitionType  p_def : p_object.getDefinitions().getDefinition()) {
            Reporter.log( "  @ definition: " + p_def, true );
        }
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.repository.mongodb.write" },
                    alwaysRun=true
                    )
    public void testDeleteAll()
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        MongoOvalDatastore  ds = _getDefinitionRepository().getDatastore();

        ds.delete( OvalDefinitions.class );
        ds.delete( DefinitionType.class );
        ds.delete( TestType.class );
        ds.delete( SystemObjectType.class );
        ds.delete( StateType.class );
        ds.delete( VariableType.class );
    }

}
//
