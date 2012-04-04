package jp.go.aist.six.test.oval.core.repository.mongodb;

import java.io.File;
import java.io.FilenameFilter;
import jp.go.aist.six.oval.core.repository.mongodb.MongoDatastore;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.test.oval.core.CoreTestBase;
import jp.go.aist.six.test.oval.core.XmlFilenameFilter;
import jp.go.aist.six.util.persist.Persistable;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;



public class MongoDatastoreTest
    extends CoreTestBase
{

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



    /**
     */
    private <K, T extends Persistable<K>> void _testSaveAndLoad(
                    final Class<T> type,
                    final String xmlFilepath,
                    final T expectedObject
                    )
    throws Exception
    {
        Reporter.log( "target object type: " + type, true );

        T  object = _unmarshalWithValidation( type, xmlFilepath, expectedObject );

        Reporter.log( "save..." , true );
        Reporter.log( "  * object: " + object, true );

        K  pid = _datastore.create( type, object );
        Reporter.log( "  >>> object created: pid=" + pid, true );

        Reporter.log( "load each object by concrete class...", true );
        T  p_object = _datastore.load( type, pid );
        Reporter.log( "  @ object: " + p_object, true );

        if (p_object instanceof OvalDefinitions) {
            OvalDefinitions  p_oval_defs = OvalDefinitions.class.cast( p_object );
            for (DefinitionType  p_def : p_oval_defs.getDefinitions().getDefinition()) {
                Reporter.log( "  @ definition: " + p_def, true );
            }
        }
    }



    //**************************************************************
    // objected are read from XML
    //**************************************************************

    @Override
    @DataProvider( name="oval.xml" )
    public Object[][] provideOvalXml()
    {
        return new Object[][] {
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/OvalTestContent/5.10/windows/ind-def_family_test.xml",
//                            null
//                        }
                        /* Windows */
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            "test/resources/OvalTestContent/5.10/windows",
                            null,
                            null
                        }
                        ,
                        /* linux */
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            "test/resources/OvalTestContent/5.10/linux",
                            null,
                            null
                        }
        };

    }


    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.repository.mongodb.saveAndLoad" },
                    dataProvider="oval.test_content",
                    alwaysRun=true
                    )
    public <K, T extends Persistable<K>> void testSaveAndLoad(
                    final Class<T>          object_type,
                    final String            oval_schema_version,
                    final Family            family,
                    final String            dirpath,
                    final String            xmlFilepath,
                    final T                 expectedObject
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );
        Reporter.log( "// using OVAL Test Content", true );
        Reporter.log( "* OVAL schema version: " + oval_schema_version, true );
        Reporter.log( "* family: " + family, true );

        File  dir = new File( dirpath );

        if (xmlFilepath == null) {
            FilenameFilter  filter = new XmlFilenameFilter();
            File[]  files = dir.listFiles( filter );
            for (File  file : files) {
                Reporter.log( "  * file= " + file, true );
                _testSaveAndLoad( object_type, file.getCanonicalPath(), expectedObject );
            }
        } else {
            File  file = new File( dir, xmlFilepath );
            Reporter.log( "  * file= " + file, true );
            _testSaveAndLoad( object_type, file.getCanonicalPath(), expectedObject );
        }
    }

}
