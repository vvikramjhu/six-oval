package jp.go.aist.six.test.oval.core.store;

import jp.go.aist.six.oval.model.OvalEntity;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.State;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import jp.go.aist.six.oval.model.definitions.Test;
import jp.go.aist.six.test.oval.core.CoreTestBase;
import jp.go.aist.six.test.oval.core.OvalSample;
import jp.go.aist.six.test.oval.core.Validators;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StoreDefinitionsTest
    extends CoreTestBase
{

    /**
     */
    public StoreDefinitionsTest()
    {
    }



    /**
     */
    private <T extends OvalEntity> void _testOvalEntity(
                    final Class<T> type,
                    final String filepath,
                    final String xpath,
                    final T expected
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////////////////////////", true );
        Reporter.log( "  * object type: " + type, true );

        T  object = _readObjectFromXmlFile( type, filepath, xpath, expected );
        Assert.assertNotNull( object );

        _syncOvalEntity( type, object );
    }



    /**
     */
    protected <T extends OvalEntity> void _syncOvalEntity(
                    final Class<T> type,
                    final T object
                    )
    throws Exception
    {
        Reporter.log( "sync OvalEntity: " + object.getOvalID(), true );
        long  time = System.currentTimeMillis();
        T  persistent = _getStore().sync( type, object );
        Reporter.log( "...sync done: " + (System.currentTimeMillis() - time) + "(ms)", true );

        String  pid = persistent.getPersistentID();
        Reporter.log( "  @ pid=" + pid, true );

        Reporter.log( "get object...", true );
        Reporter.log( "  - pid=" + pid, true );
        time = System.currentTimeMillis();
        T  persistent2 = _getStore().get( type, pid );
        Reporter.log( "...get done: " + (System.currentTimeMillis() - time) + "(ms)", true );

        Reporter.log( "  @ get: object=" + persistent2, true );
        Reporter.log( "validating...", true );
        Validators.validator( type ).equals( persistent2, object );
        Reporter.log( "...validation OK", true );
    }



    /**
     */
    private void _testOvalDefinitions(
                    final Class<OvalDefinitions> type,
                    final String filepath,
                    final String xpath,
                    final OvalDefinitions expected
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////////////////////////", true );
        Reporter.log( "  * object type: " + type, true );

        OvalDefinitions  object = _readObjectFromXmlFile( type, filepath, xpath, expected );
        Assert.assertNotNull( object );

        _syncOvalDefinitions( object );
    }



    /**
     */
    protected void _syncOvalDefinitions(
                    final OvalDefinitions object
                    )
    throws Exception
    {
        Reporter.log( "sync OvalDefinitions..." , true );
        long  time = System.currentTimeMillis();
        OvalDefinitions  persistent = _getStore().sync( OvalDefinitions.class, object );
        Reporter.log( "...sync done: " + (System.currentTimeMillis() - time) + "(ms)", true );

        String  pid = persistent.getPersistentID();
        Reporter.log( "  @ pid=" + pid, true );

        Reporter.log( "get object...", true );
        Reporter.log( "  - pid=" + pid, true );
        time = System.currentTimeMillis();
        OvalDefinitions  persistent2 = _getStore().get( OvalDefinitions.class, pid );
        Reporter.log( "...get done: " + (System.currentTimeMillis() - time) + "(ms)", true );

        Reporter.log( "  @ get: object=" + persistent2, true );
        Reporter.log( "validating...", true );
        Validators.validator( OvalDefinitions.class ).equals( persistent2, object );
        Reporter.log( "...validation OK", true );
    }




    //==============================================================
    //  oval_definitions
    //==============================================================

    @DataProvider( name="definitions.oval_definitions" )
    public Object[][] provideDefinitionsOvalDefinitions()
    {
        return new Object[][] {
                        // Mitre, CVE-2009-4019, MySQL
                        {
                            OvalDefinitions.class,
                            "test/data/definitions/oval-definitions_CVE-2009-4019_MySQL.xml",
                            "/oval_definitions",
                            OvalSample.OVAL_DEFINITIONS_8500
                        }
        };
    }


    @org.testng.annotations.Test(
                    groups={"oval.core.store", "definitions.oval_definitions"},
                    dataProvider="definitions.oval_definitions",
                    alwaysRun=true
                    )
    public void testDefinitionsOvalDefinitions(
                    final Class<OvalDefinitions> type,
                    final String filepath,
                    final String xpath,
                    final OvalDefinitions expected
                    )
    throws Exception
    {
        _testOvalDefinitions( type, filepath, xpath, expected );
    }




    //==============================================================
    //  definition
    //==============================================================

    @DataProvider( name="definitions.definition" )
    public Object[][] provideDefinitionsDefinition()
    {
        return new Object[][] {
                        // Mitre, windows, vulnerability, MySQL 5.1
                        {
                            Definition.class,
                            "test/data/definitions/definition_oval-def-8500_1.xml",
                            "oval_definitions/definitions/definition",
                            OvalSample.DEFINITION_8500
                        }
                        ,
                        // Mitre, windows, inverntory, MySQL 5.1
                        {
                            Definition.class,
                            "test/data/definitions/definition_oval-def-8297_1.xml",
                            "oval_definitions/definitions/definition",
                            OvalSample.DEFINITION_8297
                        }
                        ,
                        // Red Hat, unix, patch, firefox
                        {
                            Definition.class,
                            "test/data/definitions/definition_rhsa-def-20100332_301.xml",
                            "oval_definitions/definitions/definition",
                            OvalSample.DEFINITION_20100332
                        }
        };
    }



    @org.testng.annotations.Test(
                    groups={"oval.core.store", "definitions.definition"},
                    dataProvider="definitions.definition",
                    alwaysRun=true
                    )
    public <T extends Definition> void testDefinitionsDefinition(
                    final Class<T> type,
                    final String filepath,
                    final String xpath,
                    final T expected
                    )
    throws Exception
    {
        _testOvalEntity( type, filepath, xpath, expected );
    }



    //==============================================================
    //  test
    //==============================================================

    @DataProvider( name="definitions.test" )
    public Object[][] provideDefinitionsTest()
    {
        return new Object[][] {
                        // independent : family
                        {
                            Test.class,
                            "test/data/definitions/test-family_oval-tst-99_1.xml",
                            "oval_definitions/tests/independent:family_test",
                            OvalSample.TEST_FAMILY_99
                        }
                        ,
                        // independent : textfilecontent
                        {
                            Test.class,
                            "test/data/definitions/test-textfilecontent_oval-tst-11150_1.xml",
                            "oval_definitions/tests/independent:textfilecontent_test",
                            OvalSample.TEST_TEXTFILECONTENT_11150
                        }
                        ,
                        // independent : unknown
                        {
                            Test.class,
                            "test/data/definitions/test-unknown_oval-tst-2531_1.xml",
                            "oval_definitions/tests/independent:unknown_test",
                            OvalSample.TEST_UNKNOWN_2531
                        }
                        ,
                        // linux : DpkgInfo
                        {
                            Test.class,
                            "test/data/definitions/test-dpkginfo_oval-tst-19402_1.xml",
                            "oval_definitions/tests/linux:dpkginfo_test",
                            OvalSample.TEST_DPKGINFO_19402
                        }
                        ,
                        // linux : RpmInfo
                        {
                            Test.class,
                            "test/data/definitions/test-rpminfo_rhsa-tst-20100061002_301.xml",
                            "oval_definitions/tests/linux:rpminfo_test",
                            OvalSample.TEST_RPMINFO_20100061002
                        }
                        ,
                        // unix : uname
                        {
                            Test.class,
                            "test/data/definitions/test-uname_oval-tst-11195_1.xml",
                            "oval_definitions/tests/unix:uname_test",
                            OvalSample.TEST_UNAME_11195
                        }
                        ,
                        // windows : File
                        {
                            Test.class,
                            "test/data/definitions/test-file_oval-tst-2339_1.xml",
                            "oval_definitions/tests/windows:file_test",
                            OvalSample.TEST_FILE_2339
                        }
                        ,
                        // windows : File 2
                        {
                            Test.class,
                            "test/data/definitions/test-file_oval-tst-10629_1.xml",
                            "oval_definitions/tests/windows:file_test",
                            OvalSample.TEST_FILE_10629
                        }
                        ,
                        // windows : Metabase test
                        {
                            Test.class,
                            "test/data/definitions/test-metabase_oval-tst-709_2.xml",
                            "oval_definitions/tests/windows:metabase_test",
                            OvalSample.TEST_METABASE_709
                        }
                        ,
                        // windows : Registry test
                        {
                            Test.class,
                            "test/data/definitions/test-registry_oval-tst-3019_2.xml",
                            "oval_definitions/tests/windows:registry_test",
                            OvalSample.TEST_REGISTRY_3019
                        }
        };
    }



    @org.testng.annotations.Test(
                    groups={"oval.core.store", "definitions.test"},
                    dataProvider="definitions.test",
                    alwaysRun=true
                    )
    public <T extends Test> void testDefinitionsTest(
                    final Class<T> type,
                    final String filepath,
                    final String xpath,
                    final T expected
                    )
    throws Exception
    {
        _testOvalEntity( type, filepath, xpath, expected );
    }



    //==============================================================
    //  state
    //==============================================================

    @DataProvider( name="definitions.state" )
    public Object[][] provideDefinitionsState()
    {
        return new Object[][] {
                        // independent : family
                        {
                            State.class,
                            "test/data/definitions/state-family_oval-ste-99_2.xml",
                            "oval_definitions/states/independent:family_state",
                            OvalSample.STATE_FAMILY_99
                        }
                        ,
                        // independent : textfilecontent
                        {
                            State.class,
                            "test/data/definitions/state-textfilecontent_oval-ste-5132_1.xml",
                            "oval_definitions/states/independent:textfilecontent_state",
                            OvalSample.STATE_TEXTFILECONTENT_5132
                        }
                        ,
                        // windows : file
                        {
                            State.class,
                            "test/data/definitions/state-file_oval-ste-2190_1.xml",
                            "oval_definitions/states/windows:file_state",
                            OvalSample.STATE_FILE_2190
                        }
                        ,
                        // windows : metabase
                        {
                            State.class,
                            "test/data/definitions/state-metabase_oval-ste-537_1.xml",
                            "oval_definitions/states/windows:metabase_state",
                            OvalSample.STATE_METABASE_537
                        }
                        ,
                        // windows : registry
                        {
                            State.class,
                            "test/data/definitions/state-registry_oval-ste-1205_1.xml",
                            "oval_definitions/states/windows:registry_state",
                            OvalSample.STATE_REGISTRY_1205
                        }
                        ,
                        // linux : dpkginfo
                        {
                            State.class,
                            "test/data/definitions/state-dpkginfo_oval-ste-5797_1.xml",
                            "oval_definitions/states/linux:dpkginfo_state",
                            OvalSample.STATE_DPKGINFO_5797
                        }
                        ,
                        // linux : rpminfo/evr
                        {
                            State.class,
                            "test/data/definitions/state-rpminfo_rhsa-ste-20100061004_301.xml",
                            "oval_definitions/states/linux:rpminfo_state",
                            OvalSample.STATE_RPMINFO_20100061004
                        }
                        ,
                        // linux : rpminfo/version
                        {
                            State.class,
                            "test/data/definitions/state-rpminfo_rhsa-ste-20100061003_301.xml",
                            "oval_definitions/states/linux:rpminfo_state",
                            OvalSample.STATE_RPMINFO_20100061003
                        }
                        ,
                        // linux : rpminfo/signature_keyid
                        {
                            State.class,
                            "test/data/definitions/state-rpminfo_rhsa-ste-20100061002_301.xml",
                            "oval_definitions/states/linux:rpminfo_state",
                            OvalSample.STATE_RPMINFO_20100061002
                        }
        };

    }



    @org.testng.annotations.Test(
                    groups={"oval.core.store", "definitions.state"},
                    dataProvider="definitions.state",
                    alwaysRun=true
                    )
    public <T extends State> void testDefinitionsState(
                    final Class<T> type,
                    final String filepath,
                    final String xpath,
                    final T expected
                    )
    throws Exception
    {
        _testOvalEntity( type, filepath, xpath, expected );
    }



    //==============================================================
    //  object
    //==============================================================

    @DataProvider( name="definitions.object" )
    public Object[][] provideDefinitionsObject()
    {
        return new Object[][] {
                        // independent : family
                        {
                            SystemObject.class,
                            "test/data/definitions/object-family_oval-obj-99_1.xml",
                            "oval_definitions/objects/independent:family_object",
                            OvalSample.OBJECT_FAMILY_99
                        }
                        ,
                        // independent : textfilecontent
                        {
                            SystemObject.class,
                            "test/data/definitions/object-textfilecontent_oval-obj-7326_1.xml",
                            "oval_definitions/objects/independent:textfilecontent_object",
                            OvalSample.OBJECT_TEXTFILECONTENT_7326
                        }
                        ,
                        // linux : dpkginfo
                        {
                            SystemObject.class,
                            "test/data/definitions/object-dpkginfo_oval-obj-10648_1.xml",
                            "oval_definitions/objects/linux:dpkginfo_object",
                            OvalSample.OBJECT_DPKGINFO_10648
                        }
                        ,
                        // linux : rpminfo
                        {
                            SystemObject.class,
                            "test/data/definitions/object-rpminfo_rhsa-obj-20100061001_301.xml",
                            "oval_definitions/objects/linux:rpminfo_object",
                            OvalSample.OBJECT_RPMINFO_20100061001
                        }
                        ,
                        // unux : uname
                        {
                            SystemObject.class,
                            "test/data/definitions/object-uname_oval-obj-2759_1.xml",
                            "oval_definitions/objects/unix:uname_object",
                            OvalSample.OBJECT_UNAME_2759
                        }
                        ,
//                        // windows : file
                        {
                            SystemObject.class,
                            "test/data/definitions/object-file_oval-obj-222_1.xml",
                            "oval_definitions/objects/windows:file_object",
                            OvalSample.OBJECT_FILE_222
                        }
                        ,
                        // windows : metabase
                        {
                            SystemObject.class,
                            "test/data/definitions/object-metabase_oval-obj-556_2.xml",
                            "oval_definitions/objects/windows:metabase_object",
                            OvalSample.OBJECT_METABASE_556
                        }
                        ,
                        // windows : registry
                        {
                            SystemObject.class,
                            "test/data/definitions/object-registry_oval-obj-717_1.xml",
                            "oval_definitions/objects/windows:registry_object",
                            OvalSample.OBJECT_REGISTRY_717
                        }
        };
    }



    @org.testng.annotations.Test(
                    groups={"oval.core.store", "definitions.object"},
                    dataProvider="definitions.object",
                    alwaysRun=true
                    )
    public <T extends SystemObject> void testDefinitionsObject(
                    final Class<T> type,
                    final String filepath,
                    final String xpath,
                    final T expected
                    )
    throws Exception
    {
        _testOvalEntity( type, filepath, xpath, expected );
    }

}
// DefinitionsTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

