package jp.go.aist.six.test.oval.core;

import java.io.File;
import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.OvalId;
import jp.go.aist.six.oval.model.OvalIdContainer;
import jp.go.aist.six.oval.model.definitions.DefinitionsElement;
import jp.go.aist.six.util.persist.Persistable;
import org.testng.Reporter;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalIdTests
    extends OvalCoreTestBase
{


    ////////////////////////////////////////////////////////////////
    //  support methods
    ////////////////////////////////////////////////////////////////



    ////////////////////////////////////////////////////////////////
    //  test data
    ////////////////////////////////////////////////////////////////



    ////////////////////////////////////////////////////////////////
    //  test methods
    ////////////////////////////////////////////////////////////////


    private static final OvalIdContainer  oval_id_list = new OvalIdContainer();



    /**
     */
    @org.testng.annotations.Test(
                    groups={
                                    "java:oval.core.xml",
                                    "data:oval",
                                    "control:xmlmapper"
                                    },
                    dataProvider="data:oval.def.element",
                    alwaysRun=true
                    )
    public <K, T extends Persistable<K>>
    void testSaveOvalDefOvalDefinitions(
                    final OvalContentCategory       category,
                    final String                    schema_version,
                    final Class<T>                  object_type,
                    final DefinitionsElement.Type   type,
                    final Family                    family,
                    final Component                 component,
                    final String                    oval_id,
                    final T                         expected_object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        Reporter.log( ">>> marshalling OvalId...", true );
        Reporter.log( "  * id: " + oval_id, true );

        OvalId  id = new OvalId( oval_id );
        File  file = new File( "oval_id_" + id.getNamespace() + "_" + id.getIdValue() + ".xml" );
        Reporter.log( "  * XML file: " + file, true );
        _marshalToFile( id, file.getCanonicalPath() );
        Reporter.log( "<<< ...marshalling done", true );

        oval_id_list.addId( id );
        Reporter.log( ">>> marshalling OvalIdContainer...", true );
        File  list_file = new File( "oval_id_list_" + id.getNamespace() + "_" + id.getIdValue() + ".xml" );
        Reporter.log( "  * XML file: " + list_file, true );
        _marshalToFile( oval_id_list, list_file.getCanonicalPath() );
        Reporter.log( "<<< ...marshalling done", true );
    }

}
//
