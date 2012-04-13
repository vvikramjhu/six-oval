package jp.go.aist.six.test.oval.core;

import java.io.File;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalDatastore;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.DefinitionsElement;
import jp.go.aist.six.oval.repository.DefinitionQueryParams;
import jp.go.aist.six.util.persist.Persistable;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class MongoTests
    extends OvalCoreTests
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



    ////////////////////////////////////////////////////////////////
    //  support methods
    ////////////////////////////////////////////////////////////////

    /**
     */
    private <K, T extends Persistable<K>>
    void _unmarshalFromFileAndSaveToDatastore(
                    final Class<T>  object_type,
                    final String    schema_version,
                    final Family    family,
                    final String    dirpath,
                    final String    xml_filepath,
                    final T         expected_object
                    )
    throws Exception
    {
        Reporter.log( "* object type: "     + object_type, true );
        Reporter.log( "* schema version: "  + schema_version, true );
        Reporter.log( "* family: "          + family, true );
        Reporter.log( "* dir path: "        + dirpath, true );
        Reporter.log( "* XML file path: "   + xml_filepath, true );

        File[]  files = _toXmlFileList( dirpath, xml_filepath );
        for (File  file : files) {
            Reporter.log( "  * file= " + file, true );
            T  object = _unmarshalFromFile( object_type, file.getCanonicalPath(), expected_object );
            _saveToDatastore( object_type, object, true );
        }
    }


    private <K, T extends Persistable<K>>
    void _saveToDatastore(
                    final Class<T>  object_type,
                    final T         object,
                    final boolean   to_load
                    )
    throws Exception
    {
        _saveToDatastore( object_type, object, to_load, true );
    }


    protected <K, T extends Persistable<K>>
    void _saveToDatastore(
                    final Class<T>  object_type,
                    final T         object,
                    final boolean   to_load,
                    final boolean   to_log
                    )
    throws Exception
    {
        if (to_log) {
            Reporter.log( ">>> save..." , true );
            Reporter.log( "  * object type: " + object_type, true );
            Reporter.log( "  * object: " + object, true );
        }

        K  pid = _getDatastore().save( object_type, object );
        if (to_log) {
            Reporter.log( "<<< ...object saved: PID=" + pid, true );
        }

        if (to_load) {
            if (to_log) {
                Reporter.log( ">>> find object by PID...", true );
                Reporter.log( "   * PID: " + pid, true );
            }
            T  p_object = _getDatastore().findById( object_type, pid );
            if (to_log) {
                Reporter.log( "<<< ...object found", true );
                Reporter.log( "  @ object: " + p_object, true );
                _printObject( object_type, p_object );
            }
        }
    }



    ////////////////////////////////////////////////////////////////
    //  test data
    ////////////////////////////////////////////////////////////////

    /**
     * OVAL Definitions documents contained in the OVAL Test Content.
     *
     *  Class<DefinitionType>     object_type,
     *  String                    schema_version,
     *  DefinitionsElement.Type   type,
     *  QueryParams               params
     */
    @DataProvider( name="oval.repository.query_params.def" )
    public Object[][] provideQueryParamsDef()
    {
        // common: order, count
        DefinitionQueryParams  params1 = new DefinitionQueryParams();
        params1.setOrder( "id" );
        params1.setCount( "3" );

        // common: order, count, startIndex
        DefinitionQueryParams  params2 = new DefinitionQueryParams();
        params2.setOrder( "id" );
        params2.setCount( "2" );
        params2.setStartIndex( "4" );

        return new Object[][] {
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            "5.10",
                            DefinitionsElement.Type.DEFINITION,
                            params1
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            "5.10",
                            DefinitionsElement.Type.DEFINITION,
                            params2
                        }
        };
    }



    ////////////////////////////////////////////////////////////////
    //  test methods
    ////////////////////////////////////////////////////////////////

    /**
     */
    @org.testng.annotations.Test(
                    groups={
                                    "java:oval.core.repository.mongodb",
                                    "oval:oval.def",
                                    "operation:datastore.save"
                                    },
                    dataProvider="oval.test_content.def",
                    alwaysRun=true
                    )
    public <K, T extends Persistable<K>>
    void testSaveDef(
                    final Class<T>  object_type,
                    final String    schema_version,
                    final Family    family,
                    final String    dirpath,
                    final String    xml_filepath,
                    final T         expected_object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );
        _unmarshalFromFileAndSaveToDatastore( object_type, schema_version, family, dirpath, xml_filepath, expected_object );
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={
                                    "java:oval.core.repository.mongodb",
                                    "oval:oval.sc",
                                    "operation:datastore.save"
                                    },
                    dataProvider="oval.test_content.sc",
                    dependsOnMethods={ "testSaveDef" },
                    alwaysRun=true
                    )
    public <K, T extends Persistable<K>>
    void testSaveSc(
                    final Class<T>  object_type,
                    final String    schema_version,
                    final Family    family,
                    final String    dirpath,
                    final String    xml_filepath,
                    final T         expected_object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );
        _unmarshalFromFileAndSaveToDatastore( object_type, schema_version, family, dirpath, xml_filepath, expected_object );
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={
                                    "java:oval.core.repository.mongodb",
                                    "oval:oval.res",
                                    "operation:datastore.save"
                                    },
                    dataProvider="oval.test_content.res",
                    dependsOnMethods={ "testSaveSc" },
                    alwaysRun=true
                    )
    public <K, T extends Persistable<K>>
    void testSaveRes(
                    final Class<T>  object_type,
                    final String    schema_version,
                    final Family    family,
                    final String    dirpath,
                    final String    xml_filepath,
                    final T         expected_object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );
        _unmarshalFromFileAndSaveToDatastore( object_type, schema_version, family, dirpath, xml_filepath, expected_object );
    }

}
//
