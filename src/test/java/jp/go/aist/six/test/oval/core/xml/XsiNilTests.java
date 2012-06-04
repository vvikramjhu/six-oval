package jp.go.aist.six.test.oval.core.xml;

import java.io.File;
import jp.go.aist.six.oval.model.OvalObject;
import jp.go.aist.six.oval.model.definitions.EntityObjectStringType;
import jp.go.aist.six.oval.model.windows.FileAuditedPermissionsObject;
import jp.go.aist.six.test.oval.core.OvalCoreTestBase;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;



/**
 * Tests: OvalXmlMapper.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class XsiNilTests
    extends OvalCoreTestBase
{

    /**
     */
    public XsiNilTests()
    {
    }



    private File  _tmp_dir = null;



    /**
     */
    @Override
    @BeforeClass( alwaysRun=true )
    public void setUp()
    throws Exception
    {
        super.setUp();

        String  tmp_dirpath = System.getProperty( "java.io.tmpdir" );
        _tmp_dir = new File( tmp_dirpath, "six-oval" );
        _tmp_dir.mkdirs();
    }



    ////////////////////////////////////////////////////////////////
    //  test data
    ////////////////////////////////////////////////////////////////

    /**
     */
    @DataProvider( name="DATA.oval.def.nil" )
    public Object[][] provideOvalObjectNil()
    {
        FileAuditedPermissionsObject  obj_01 = new FileAuditedPermissionsObject(
                        "oval:org.mitre.oval.test:obj:529", 1
                        );
        obj_01.setPath( new EntityObjectStringType( "C:\\Program Files\\Internet Explorer") );
//        obj_01.setFilename( new EntityObjectStringType() );
        obj_01.setTrusteeName( new EntityObjectStringType( "ADMINISTRATOR" ) );


        return new Object[][] {
                        {
                            "01",
                            FileAuditedPermissionsObject.class,
                            obj_01
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
                                    "MODEL.oval.def",
                                    "PACKAGE.oval.core.xml",
                                    "CONTROL.xml.marshal"
                                    }
                    ,dataProvider="DATA.oval.def.nil"
                    ,alwaysRun=true
                    )
    public <T extends OvalObject> void testXsiNilMarshal(
                    final String    test_id,
                    final Class<T>  type,
                    final T         object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////", true );

        String  dst_xml_filepath = "marshalled_" + test_id + ".xml";
        File  dst_xml_file = new File( _tmp_dir, dst_xml_filepath );

        _marshalToFile( object, dst_xml_file.getCanonicalPath() );
    }

}
//
