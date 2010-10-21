package jp.go.aist.six.test.oval.core.store;

import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.State;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import jp.go.aist.six.oval.model.definitions.Test;
import jp.go.aist.six.test.oval.core.DefinitionsSample;
import jp.go.aist.six.test.oval.core.OvalSample;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StoreDefinitionsTest
    extends StoreTestBase
{

    /**
     */
    public StoreDefinitionsTest()
    {
    }



    //==============================================================
    //  oval_definitions
    //==============================================================

    @DataProvider( name="definitions.oval_definitions" )
    public Object[][] provideDefinitionsOvalDefinitions()
    {
        return new Object[][] {
//                        // Mitre, CVE-2009-4019, MySQL
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/oval-definitions_CVE-2009-4019_MySQL.xml",
//                            "/oval_definitions",
//                            OvalSample.OVAL_DEFINITIONS_8500
//                        }
//                        ,
//                        // Red Hat, CVE-2010-0176, Firefox/xulrunner on RHEL
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/oval-definitions_CVE-2010-0176_rhsa20100332.xml",
//                            "/oval_definitions",
//                            null
//                        }
//                        ,
//                        // Mitre, CVE-2010-0176, Firefox/xulrunner on Debian
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/oval-definitions_CVE-2010-0176_DSA-2027.xml",
//                            "/oval_definitions",
//                            null
//                        }
//                        ,
//                        // Mitre, vulnerability, Windows XP, OVAL Schema 5.8
                          // Java OutOfMemoryError!!!
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/20101012_vulnerability_microsoft.windows.xp.xml",
//                            "/oval_definitions",
//                            null
//                        }
//                        ,
                        // Mitre, vulnerability, Windows XP, OVAL Schema 5.8 textfilecontent54 entities
                        {
                            OvalDefinitions.class,
                            "test/data/definitions/oval-definitions_windows-def-11757.xml",
                            "/oval_definitions",
                            null
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
        _testStoreSync( type, filepath, xpath, expected );
//        _testOvalDefinitions( type, filepath, xpath, expected );
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
        _testStoreSync( type, filepath, xpath, expected );
    }



    //==============================================================
    //  test
    //==============================================================

    @org.testng.annotations.Test(
                    groups={"oval.core.store", "definitions.test"},
                    dataProvider="definitions.test",
                    alwaysRun=true
                    )
    public <T extends Test> void testStoreDefinitionsTest(
                    final Class<T> type,
                    final String sourceFilepath,
                    final String xpath,
                    final T expected
                    )
    throws Exception
    {
        _testStoreSync( type, sourceFilepath, xpath, expected );
    }



    //==============================================================
    //  object
    //==============================================================

    @org.testng.annotations.Test(
                    groups={"oval.core.store", "definitions.object"},
                    dataProvider="definitions.object",
                    alwaysRun=true
                    )
    public <T extends SystemObject> void testDefinitionsObject(
                    final Class<T> type,
                    final String sourceFilepath,
                    final String xpath,
                    final T expected
                    )
    throws Exception
    {
        _testStoreSync( type, sourceFilepath, xpath, expected );
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
                            DefinitionsSample.STATE_INDEPENDENT_FAMILY_99
                        }
                        ,
                        // independent : textfilecontent
                        {
                            State.class,
                            "test/data/definitions/state-textfilecontent_oval-ste-5132_1.xml",
                            "oval_definitions/states/independent:textfilecontent_state",
                            DefinitionsSample.STATE_INDEPENDENT_TEXTFILECONTENT_5132
                        }
                        ,
                        // independent : textfilecontent54
                        {
                            State.class,
                            "test/data/definitions/state-independent-textfilecontent54_11440.xml",
                            "oval_definitions/states/independent:textfilecontent54_state",
                            DefinitionsSample.STATE_INDEPENDENT_TEXTFILECONTENT54_11440
                        }
                        ,
                        // windows : file
                        {
                            State.class,
                            "test/data/definitions/state-file_oval-ste-2190_1.xml",
                            "oval_definitions/states/windows:file_state",
                            DefinitionsSample.STATE_WINDOWS_FILE_2190
                        }
                        ,
                        // windows : metabase
                        {
                            State.class,
                            "test/data/definitions/state-metabase_oval-ste-537_1.xml",
                            "oval_definitions/states/windows:metabase_state",
                            DefinitionsSample.STATE_WINDOWS_METABASE_537
                        }
                        ,
                        // windows : registry
                        {
                            State.class,
                            "test/data/definitions/state-registry_oval-ste-1205_1.xml",
                            "oval_definitions/states/windows:registry_state",
                            DefinitionsSample.STATE_WINDOWS_REGISTRY_1205
                        }
                        ,
                        // linux : dpkginfo
                        {
                            State.class,
                            "test/data/definitions/state-dpkginfo_oval-ste-5797_1.xml",
                            "oval_definitions/states/linux:dpkginfo_state",
                            DefinitionsSample.STATE_LINUX_DPKGINFO_5797
                        }
                        ,
                        // linux : rpminfo/evr
                        {
                            State.class,
                            "test/data/definitions/state-rpminfo_rhsa-ste-20100061004_301.xml",
                            "oval_definitions/states/linux:rpminfo_state",
                            DefinitionsSample.STATE_LINUX_RPMINFO_20100061004
                        }
                        ,
                        // linux : rpminfo/version
                        {
                            State.class,
                            "test/data/definitions/state-linux-rpminfo_rhsa-20100061003.xml",
                            "oval_definitions/states/linux:rpminfo_state",
                            DefinitionsSample.STATE_LINUX_RPMINFO_20100061003
                        }
                        ,
                        // linux : rpminfo/signature_keyid
                        {
                            State.class,
                            "test/data/definitions/state-rpminfo_rhsa-ste-20100061002_301.xml",
                            "oval_definitions/states/linux:rpminfo_state",
                            DefinitionsSample.STATE_LINUX_RPMINFO_20100061002
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
        _testStoreSync( type, filepath, xpath, expected );
    }



}
// DefinitionsTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

