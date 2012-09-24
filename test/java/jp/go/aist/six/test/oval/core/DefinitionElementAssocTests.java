package jp.go.aist.six.test.oval.core;

import java.io.File;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.DefinitionsElementAssoc;
import jp.go.aist.six.oval.model.definitions.DefinitionsType;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.TestType;
import jp.go.aist.six.oval.model.definitions.TestsType;
import jp.go.aist.six.util.persist.Persistable;
import org.testng.Reporter;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class DefinitionElementAssocTests
    extends OvalCoreTestBase
{


//    /**
//     */
//    @Override
//    @BeforeClass( alwaysRun=true )
//	public void setUp()
//    throws Exception
//	{
//        super.setUp();
//
//	}



    ////////////////////////////////////////////////////////////////
    //  support methods
    ////////////////////////////////////////////////////////////////

    /**
     */
    private <K, T extends Persistable<K>>
    void _unmarshalFromFileAndCreateAssoc(
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
            _createAssoc( object_type, object );
        }
    }


    private <K, T extends Persistable<K>>
    void _createAssoc(
                    final Class<T>  object_type,
                    final T         object
                    )
    throws Exception
    {
        if (OvalDefinitions.class.isAssignableFrom( object_type )) {
            DefinitionsType  defs =  OvalDefinitions.class.cast( object ).getDefinitions();
            if (defs != null) {
                for (DefinitionType  def : defs.getDefinition()) {
                    DefinitionsElementAssoc  assoc = new DefinitionsElementAssoc( def );
                    Reporter.log( "  @ assoc= " + assoc, true );
                }
            }

            TestsType  tsts =  OvalDefinitions.class.cast( object ).getTests();
            if (tsts != null) {
                for (TestType  tst : tsts.getTest()) {
                    DefinitionsElementAssoc  assoc = new DefinitionsElementAssoc( tst );
                    Reporter.log( "  @ assoc= " + assoc, true );
                }
            }
        }
    }




    ////////////////////////////////////////////////////////////////
    //  test data
    ////////////////////////////////////////////////////////////////



    ////////////////////////////////////////////////////////////////
    //  test methods
    ////////////////////////////////////////////////////////////////

    /**
     */
    @org.testng.annotations.Test(
                    groups={
                                    "java:oval.core.repository",
                                    "oval:oval.def",
                                    "operation:datastore.save"
                                    },
                    dataProvider="oval.test_content.def",
                    alwaysRun=true
                    )
    public <K, T extends Persistable<K>>
    void testCreateDefAssoc(
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

        _unmarshalFromFileAndCreateAssoc( object_type, schema_version, family, dirpath, xml_filepath, expected_object );
    }

}
//
