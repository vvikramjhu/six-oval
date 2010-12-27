package jp.go.aist.six.test.oval.core.store.inherit;

import jp.go.aist.six.oval.core.store.OvalStore;
import jp.go.aist.six.oval.core.xml.OvalXml;
import jp.go.aist.six.oval.model.common.Check;
import jp.go.aist.six.oval.model.common.Existence;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalStoreTest.java 1079 2010-12-24 10:35:24Z nakamura5akihito $
 */
public class OvalStoreInheritTest
{

    private OvalContextInherit  _context = null;

    private OvalXml  _xml = null;
    private OvalStore  _store = null;



    /**
     */
    public OvalStoreInheritTest()
    {
    }


    /**
     */
    @BeforeClass( alwaysRun=true )
    public void setUp()
    throws Exception
    {
        _context = new OvalContextInherit();
    }



    protected OvalContextInherit _getContext()
    throws Exception
    {
        return _context;
    }



    protected OvalXml _getXml()
    throws Exception
    {
        if (_xml == null) {
            _xml = _context.getXml();
        }

        return _xml;
    }



    protected OvalStore _getStore()
    throws Exception
    {
        if (_store == null) {
            _store = _context.getStore();
        }

        return _store;
    }




    public static final Test  TEST_WINDOWS_REGISTRY_3019_INHERIT =
        new RegistryTest( "oval:org.mitre.oval:tst:3019", 2,
                        "Win2K/XP/2003/Vista/2008 service pack 2 is installed",
                        Check.AT_LEAST_ONE )
    .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
    .object( "oval:org.mitre.oval:obj:717" )
    .state( "oval:org.mitre.oval:ste:2827" );





    @DataProvider( name="definitions.test.inherit" )
    public Object[][] provideDefinitionsTestInherit()
    {
        return new Object[][] {
//                        // independent family
//                        {
//                            Test.class,
//                            "test/data/definitions/test-independent-family_oval-99.xml",
//                            "/oval_definitions/tests/family_test",
//                            DefinitionsSample.TEST_INDEPENDENT_FAMILY_99,
//                            "marshalled_test-independent-family_oval-99.xml"
//                        }
//                        ,
//                        // independent textfilecontent
//                        {
//                            Test.class,
//                            "test/data/definitions/test-independent-textfilecontent_oval-11150.xml",
//                            "/oval_definitions/tests/textfilecontent_test",
//                            DefinitionsSample.TEST_INDEPENDENT_TEXTFILECONTENT_11150,
//                            "marshalled_test-independent-textfilecontent_oval-11150.xml"
//                        }
//                        ,
//                        // independent textfilecontent54
//                        {
//                            Test.class,
//                            "test/data/definitions/test-independent-textfilecontent54_oval-41853.xml",
//                            "/oval_definitions/tests/textfilecontent54_test",
//                            DefinitionsSample.TEST_INDEPENDENT_TEXTFILECONTENT54_41853,
//                            "marshalled_test-independent-textfilecontent54_oval-41853.xml"
//                        }
//                        ,
//                        // independent unknown
//                        {
//                            Test.class,
//                            "test/data/definitions/test-independent-unknown_oval-2531.xml",
//                            "/oval_definitions/tests/unknown_test",
//                            DefinitionsSample.TEST_INDEPENDENT_UNKNOWN_2531,
//                            "marshalled_test-independent-unknown_oval-2531.xml"
//                        }
//                        ,
//                        // linux dpkginfo
//                        {
//                            Test.class,
//                            "test/data/definitions/test-linux-dpkginfo_oval-19402.xml",
//                            "/oval_definitions/tests/dpkginfo_test",
//                            DefinitionsSample.TEST_LINUX_DPKGINFO_19402,
//                            "marshalled_test-linux-dpkginfo_oval-19402.xml"
//                        }
//                        ,
//                        // linux rpminfo
//                        {
//                            Test.class,
//                            "test/data/definitions/test-linux-rpminfo_rhsa-20100061002.xml",
//                            "/oval_definitions/tests/rpminfo_test",
//                            DefinitionsSample.TEST_LINUX_RPMINFO_20100061002,
//                            "marshalled_test-linux-rpminfo_rhsa-20100061002.xml"
//                        }
//                        ,
//                        // unix uname
//                        {
//                            Test.class,
//                            "test/data/definitions/test-unix-uname_oval-11195.xml",
//                            "/oval_definitions/tests/uname_test",
//                            DefinitionsSample.TEST_UNIX_UNAME_11195,
//                            "marshalled_test-unix-uname_oval-11195.xml"
//                        }
//                        ,
//                        // windows file, with 2 States
//                        {
//                            Test.class,
//                            "test/data/definitions/test-windows-file_oval-10629.xml",
//                            "/oval_definitions/tests/file_test",
//                            DefinitionsSample.TEST_WINDOWS_FILE_10629,
//                            "marshalled_test-windows-file_oval-10629.xml"
//                        }
//                        ,
//                        // windows file
//                        {
//                            Test.class,
//                            "test/data/definitions/test-windows-file_oval-2339.xml",
//                            "/oval_definitions/tests/file_test",
//                            DefinitionsSample.TEST_WINDOWS_FILE_2339,
//                            "marshalled_test-windows-file_oval-2339.xml"
//                        }
//                        ,
//                        // windows metabase, without State
//                        {
//                            Test.class,
//                            "test/data/definitions/test-windows-metabase_oval-709.xml",
//                            "/oval_definitions/tests/metabase_test",
//                            DefinitionsSample.TEST_WINDOWS_METABASE_709,
//                            "marshalled_test-windows-metabase_oval-709.xml"
//                        }
//                        ,
                        // windows registry
                        {
                            Test.class,
                            TEST_WINDOWS_REGISTRY_3019_INHERIT
                        }
        };
    }



    //==============================================================
    //  test
    //==============================================================

    @org.testng.annotations.Test(
                    groups={"oval.core.store", "definitions.test"},
                    dataProvider="definitions.test.inherit",
                    alwaysRun=true
                    )
    public <T extends Test> void testStoreDefinitionsTestInherit(
                    final Class<Test> type,
                    final T object
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////////////////////////", true );
        Reporter.log( "  * object: " + object, true );
        Reporter.log( "  * object type: " + type, true );

        Reporter.log( "sync..." , true );
        long  time = System.currentTimeMillis();
        Test  p_object = _getStore().sync( type, object );
        String  p_id = p_object.getPersistentID();
        Reporter.log( "...sync done: " + (System.currentTimeMillis() - time) + "(ms)", true );
        Reporter.log( "  @ pid=" + p_id, true );

        Test  p_test = _getStore().load( type, p_id );
        Reporter.log( "  @ object=" + p_test, true );
        Reporter.log( "  @ object type=" + p_test.getClass().getName(), true );

        // update
        p_test.setComment( "modified comment" );
        Reporter.log( "update..." , true );
        time = System.currentTimeMillis();
//        _getStore().sync( type, p_test );
        _getStore().update( type, p_test );
        p_id = p_test.getPersistentID();
        Reporter.log( "...update done: " + (System.currentTimeMillis() - time) + "(ms)", true );

        Reporter.log( "load...", true );
        Reporter.log( "  - pid=" + p_id, true );
        time = System.currentTimeMillis();
        p_object = _getStore().load( type, p_id );
        Reporter.log( "...load done: " + (System.currentTimeMillis() - time) + "(ms)", true );
        Reporter.log( "  @ object=" + p_object, true );
//        Reporter.log( "  @ entity type=" + p_object.getEntityType(), true );
        Reporter.log( "  @ object type=" + p_object.getClass().getName(), true );
    }

}
// OvalStoreInheritTest

