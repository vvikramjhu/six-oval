package jp.go.aist.six.test.oval.core.repository.mongodb;

import java.io.File;
import java.io.FilenameFilter;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalDatastore;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.test.oval.core.TestBase;
import jp.go.aist.six.test.oval.core.XmlFilenameFilter;
import jp.go.aist.six.util.persist.Persistable;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;



/**
 * Tests: MongoOvalDatastore.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class MongoOvalDatastoreTests
    extends TestBase
{

    private MongoOvalDatastore  _datastore;



    /**
     */
    @Override
    @BeforeClass( alwaysRun=true )
	public void setUp()
    throws Exception
	{
        super.setUp();

        _datastore = _getContext().getBean( MongoOvalDatastore.class );
	}


    protected MongoOvalDatastore _getDatastore()
    throws Exception
    {
        return _datastore;
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

        T  object = _unmarshalObject( type, xmlFilepath, expectedObject );

        Reporter.log( "save..." , true );
        Reporter.log( "  * object: " + object, true );

        K  pid = _datastore.save( type, object );
        Reporter.log( "  >>> object created: pid=" + pid, true );

        Reporter.log( "load each object by concrete class...", true );
        T  p_object = _datastore.findById( type, pid );
        Reporter.log( "  @ object: " + p_object, true );

        if (p_object instanceof OvalDefinitions) {
            OvalDefinitions  p_oval_defs = OvalDefinitions.class.cast( p_object );
            for (DefinitionType  p_def : p_oval_defs.getDefinitions().getDefinition()) {
                Reporter.log( "  @ definition: " + p_def, true );
            }
        }
    }



    //**************************************************************
    // Test Methods
    //**************************************************************

    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.core.repository.mongodb" },
                    dataProvider="oval.test_content.def",
                    alwaysRun=true
                    )
    public <K, T extends Persistable<K>> void testSaveAndLoad(
                    final Class<T>          object_type,
                    final String            oval_schema_version,
                    final OvalPlatformType  platform,
                    final String            dirpath,
                    final String            xml_filepath,
                    final T                 expectedObject
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );
        Reporter.log( "// using OVAL Test Content", true );
        Reporter.log( "* OVAL schema version: " + oval_schema_version, true );
        Reporter.log( "* platform: " + platform.name(), true );

        File  dir = new File( dirpath );

        if (xml_filepath == null) {
            FilenameFilter  filter = new XmlFilenameFilter();
            File[]  files = dir.listFiles( filter );
            for (File  file : files) {
                Reporter.log( "  * file= " + file, true );
                _testSaveAndLoad( object_type, file.getCanonicalPath(), expectedObject );
            }
        } else {
            File  file = new File( dir, xml_filepath );
            Reporter.log( "  * file= " + file, true );
            _testSaveAndLoad( object_type, file.getCanonicalPath(), expectedObject );
        }
    }

}
