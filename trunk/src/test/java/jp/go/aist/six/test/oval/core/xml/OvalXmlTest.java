package jp.go.aist.six.test.oval.core.xml;

import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.State;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import jp.go.aist.six.oval.model.definitions.Test;
import jp.go.aist.six.oval.model.definitions.Variable;
import jp.go.aist.six.oval.model.results.Content;
import jp.go.aist.six.oval.model.results.Directive;
import jp.go.aist.six.oval.model.results.Directives;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.Item;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.model.sc.SystemInfo;
import jp.go.aist.six.test.oval.core.CoreTestBase;
import jp.go.aist.six.test.oval.core.OvalSample;
import jp.go.aist.six.test.oval.core.ScSample;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalXmlTest
    extends CoreTestBase
{

    /**
     */
    public OvalXmlTest()
    {
    }



    /**
     */
    protected <T> void _testXml(
                    final Class<T> type,
                    final String sourceFilepath,
                    final String xpath,
                    final T expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        T  actual = _unmarshalWithValidation( type, sourceFilepath, xpath, expected );
        _marshal( actual, resultFilepath );
        _unmarshalWithValidation( type, resultFilepath, xpath, expected );
    }



    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  Definitions
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //==============================================================
    //  oval_definitions
    //==============================================================

    @DataProvider( name="definitions.oval_definitions" )
    public Object[][] provideOvalDefinitionsOvalDefinitions()
    {
        return new Object[][] {
                        // Red Hat, CVE-2010-0176, RHSA 20100332
                        {
                            OvalDefinitions.class,
                            "test/data/definitions/oval-definitions_rhsa-20100332_CVE-2010-0176.xml",
                            "/oval_definitions",
                            null,
                            "marshalled_oval-definitions_rhsa-20100332_CVE-2010-0176.xml"
                        }
//                      ,
//                        // Debian @Mitre, CVE-2010-0176, DSA-2027
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/oval-definitions_oval-7432_CVE-2010-0176_DSA-2027.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_oval-definitions_oval-7432_CVE-2010-0176_DSA-2027.xml"
//                        }
//                      ,
//                        // Windows @ Mitre, CVE-2009-4019, MySQL
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/oval-definitions_oval-8500_CVE-2009-4019_MySQL.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_oval-definitions_oval-8500_CVE-2009-4019_MySQL.xml"
//                        }
//                        ,
//                        // Debian 5.0 @ Mitre, all patches, 2010-10-12
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/20101012_patch_debian.gnu.linux.5.0.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_20101012_patch_debian.gnu.linux.5.0.xml"
//                        }
//                        ,
//                        // Debian 5.0 @ Mitre, all patches, 2010-10-12
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/20101012_inventory_debian.gnu.linux.5.0.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_20101012_inventory_debian.gnu.linux.5.0.xml"
//                        }
//                      ,
//                        // Windows Server 2008 @ Mitre, all the vulnerabilities
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/20101012_vulnerability_microsoft.windows.server.2008.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_20101012_vulnerability_microsoft.windows.server.2008.xml"
//                        }
//                        ,
//                        // Windows Server 2008 @ Mitre, all the vulnerabilities
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/20101012_inventory_microsoft.windows.server.2008.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_20101012_inventory_microsoft.windows.server.2008.xml"
//                        }
//                        ,
//                        // Windows XP @ Mitre, all the vulnerabilities
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/20101012_vulnerability_microsoft.windows.xp.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_20101012_vulnerability_microsoft.windows.xp.xml"
//                        }
//                        ,
//                        // Windows XP @ Mitre, inventory
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/20101012_inventory_microsoft.windows.xp.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_20101012_inventory_microsoft.windows.xp.xml"
//                        }
//                      ,
//
//
//
//                        // Windows 7 @ Mitre, all vulnerability, 2010-08-27
//                        {
//                            OvalDefinitions.class,
//                            "/oval_definitions",
//                            "test/data/definitions/20100827_vulnerability_microsoft.windows.7.xml",
//                            null,
//                            "marshalled_20100827_vulnerability_microsoft.windows.7.xml"
//                        }
//                        ,
//
//
//                        // Red Hat Enterprise Linux 5.0 @ Mitre, all vulnerabilities, 2010-08-30
//                        {
//                            OvalDefinitions.class,
//                            "/oval_definitions",
//                            "test/data/definitions/20100830_vulnerability_red.hat.enterprise.linux.5.xml",
//                            null,
//                            "marshalled_20100830_vulnerability_red.hat.enterprise.linux.5.xml"
//                        }
//                        ,
//
//                        // Red Hat Enterprise Linux @ Red Hat, all , 2010-08-26
//                        {
//                            OvalDefinitions.class,
//                            "/oval_definitions",
//                            "test/data/definitions/20100826_com.redhat.rhsa-all.xml",
//                            null,
//                            "marshalled_20100826_com.redhat.rhsa-all.xml"
//                        }
        };

    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "definitions.oval_definitions"},
                    dataProvider="definitions.oval_definitions",
                    alwaysRun=true
                    )
    public void testDefinitionsOvalDefinitions(
                    final Class<OvalDefinitions> type,
                    final String sourceFilepath,
                    final String xpath,
                    final OvalDefinitions expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );
        _testXml( type, sourceFilepath, xpath, expected, resultFilepath );
    }



    //==============================================================
    //  definition
    //==============================================================

    @DataProvider( name="definitions.definition" )
    public Object[][] provideOvalDefinitionsDefinition()
    {
        return new Object[][] {
                        // Windows @ Mitre, CVE-2009-4019, MySQL
                        {
                            Definition.class,
                            "test/data/definitions/definition_oval-8500.xml",
                            "/oval_definitions/definitions/definition",
                            OvalSample.DEFINITION_8500,
                            "marshalled_definition_oval-8500.xml"
                        }
        };

    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "definitions.definition"},
                    dataProvider="definitions.definition",
                    alwaysRun=true
                    )
    public void testDefinitionsDefinition(
                    final Class<Definition> type,
                    final String sourceFilepath,
                    final String xpath,
                    final Definition expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );
        _testXml( type, sourceFilepath, xpath, expected, resultFilepath );
    }



    //==============================================================
    //  def:test
    //==============================================================

    @DataProvider( name="definitions.test" )
    public Object[][] provideOvalDefinitionsTest()
    {
        return new Object[][] {
                        // independent family
                        {
                            Test.class,
                            "test/data/definitions/test-independent-family_oval-99.xml",
                            "/oval_definitions/tests/family_test",
                            OvalSample.TEST_INDEPENDENT_FAMILY_99,
                            "marshalled_test-independent-family_oval-99.xml"
                        }
                        ,
                        // independent textfilecontent
                        {
                            Test.class,
                            "test/data/definitions/test-independent-textfilecontent_oval-11150.xml",
                            "/oval_definitions/tests/textfilecontent_test",
                            OvalSample.TEST_INDEPENDENT_TEXTFILECONTENT_11150,
                            "marshalled_test-independent-textfilecontent_oval-11150.xml"
                        }
                        ,
                        // independent textfilecontent54
                        {
                            Test.class,
                            "test/data/definitions/test-independent-textfilecontent54_oval-41853.xml",
                            "/oval_definitions/tests/textfilecontent54_test",
                            OvalSample.TEST_INDEPENDENT_TEXTFILECONTENT54_41853,
                            "marshalled_test-independent-textfilecontent54_oval-41853.xml"
                        }
                        ,
                        // independent unknown
                        {
                            Test.class,
                            "test/data/definitions/test-independent-unknown_oval-2531.xml",
                            "/oval_definitions/tests/unknown_test",
                            OvalSample.TEST_INDEPENDENT_UNKNOWN_2531,
                            "marshalled_test-independent-unknown_oval-2531.xml"
                        }
                        ,
                        // linux dpkginfo
                        {
                            Test.class,
                            "test/data/definitions/test-linux-dpkginfo_oval-19402.xml",
                            "/oval_definitions/tests/dpkginfo_test",
                            OvalSample.TEST_LINUX_DPKGINFO_19402,
                            "marshalled_test-linux-dpkginfo_oval-19402.xml"
                        }
                        ,
                        // linux rpminfo
                        {
                            Test.class,
                            "test/data/definitions/test-linux-rpminfo_rhsa-20100061002.xml",
                            "/oval_definitions/tests/rpminfo_test",
                            OvalSample.TEST_LINUX_RPMINFO_20100061002,
                            "marshalled_test-linux-rpminfo_rhsa-20100061002.xml"
                        }
                        ,
                        // unix uname
                        {
                            Test.class,
                            "test/data/definitions/test-unix-uname_oval-11195.xml",
                            "/oval_definitions/tests/uname_test",
                            OvalSample.TEST_UNIX_UNAME_11195,
                            "marshalled_test-unix-uname_oval-11195.xml"
                        }
                        ,
                        // windows file, with 2 States
                        {
                            Test.class,
                            "test/data/definitions/test-windows-file_oval-10629.xml",
                            "/oval_definitions/tests/file_test",
                            OvalSample.TEST_WINDOWS_FILE_10629,
                            "marshalled_test-windows-file_oval-10629.xml"
                        }
                        ,
                        // windows file
                        {
                            Test.class,
                            "test/data/definitions/test-windows-file_oval-2339.xml",
                            "/oval_definitions/tests/file_test",
                            OvalSample.TEST_WINDOWS_FILE_2339,
                            "marshalled_test-windows-file_oval-2339.xml"
                        }
                        ,
                        // windows metabase, without State
                        {
                            Test.class,
                            "test/data/definitions/test-windows-metabase_oval-709.xml",
                            "/oval_definitions/tests/metabase_test",
                            OvalSample.TEST_WINDOWS_METABASE_709,
                            "marshalled_test-windows-metabase_oval-709.xml"
                        }
                        ,
                        // windows registry
                        {
                            Test.class,
                            "test/data/definitions/test-windows-registry_oval-3019.xml",
                            "/oval_definitions/tests/registry_test",
                            OvalSample.TEST_WINDOWS_REGISTRY_3019,
                            "marshalled_test-windows-registry_oval-3019.xml"
                        }
        };
    }


    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "definitions.test"},
                    dataProvider="definitions.test",
                    alwaysRun=true
                    )
    public void testDefinitionsTest(
                    final Class<Test> type,
                    final String sourceFilepath,
                    final String xpath,
                    final Test expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );
        _testXml( type, sourceFilepath, xpath, expected, resultFilepath );
    }



    //==============================================================
    //  def:object
    //==============================================================

    @DataProvider( name="definitions.object" )
    public Object[][] provideOvalDefinitionsObject()
    {
        return new Object[][] {
                        // independent family
                        {
                            SystemObject.class,
                            "test/data/definitions/object-independent-family_oval-99.xml",
                            "/oval_definitions/objects/family_object",
                            OvalSample.OBJECT_INDEPENDENT_FAMILY_99,
                            "marshalled_object-independent-family_oval-99.xml"
                        }
                        ,
                        // independent textfilecontent
                        {
                            SystemObject.class,
                            "test/data/definitions/object-independent-textfilecontent_oval-7326.xml",
                            "/oval_definitions/objects/textfilecontent_object",
                            OvalSample.OBJECT_INDEPENDENT_TEXTFILECONTENT_7326,
                            "marshalled_object-independent-textfilecontent_oval-7326.xml"
                        }
                        ,
                        // independent textfilecontent54
                        {
                            SystemObject.class,
                            "test/data/definitions/object-independent-textfilecontent54_oval-15567.xml",
                            "/oval_definitions/objects/textfilecontent54_object",
                            OvalSample.OBJECT_INDEPENDENT_TEXTFILECONTENT54_15567,
                            "marshalled_object-independent-textfilecontent54_oval-15567.xml"
                        }
                        ,
                        // linux dpkginfo
                        {
                            SystemObject.class,
                            "test/data/definitions/object-linux-dpkginfo_oval-10648.xml",
                            "/oval_definitions/objects/dpkginfo_object",
                            OvalSample.OBJECT_LINUX_DPKGINFO_10648,
                            "marshalled_object-linux-dpkginfo_oval-10648.xml"
                        }
                        ,
                        // linux rpminfo
                        {
                            SystemObject.class,
                            "test/data/definitions/object-linux-rpminfo_rhsa-20100061001.xml",
                            "/oval_definitions/objects/rpminfo_object",
                            OvalSample.OBJECT_LINUX_RPMINFO_20100061001,
                            "marshalled_object-linux-rpminfo_rhsa-20100061001.xml"
                        }
                        ,
                        // unix uname
                        {
                            SystemObject.class,
                            "test/data/definitions/object-unix-uname_oval-2759.xml",
                            "/oval_definitions/objects/uname_object",
                            OvalSample.OBJECT_UNAME_UNAME_2759,
                            "marshalled_object-unix-uname_oval-2759.xml"
                        }
                        ,
                        // windows file
                        {
                            SystemObject.class,
                            "test/data/definitions/object-windows-file_oval-222.xml",
                            "/oval_definitions/objects/file_object",
                            OvalSample.OBJECT_WINDOWS_FILE_222,
                            "marshalled_object-windows-file_oval-222.xml"
                        }
                        ,
                        // windows metabase
                        {
                            SystemObject.class,
                            "test/data/definitions/object-windows-metabase_oval-556.xml",
                            "/oval_definitions/objects/metabase_object",
                            OvalSample.OBJECT_WINDOWS_METABASE_556,
                            "marshalled_object-windows-metabase_oval-556.xml"
                        }
                        ,
                        // windows registry
                        {
                            SystemObject.class,
                            "test/data/definitions/object-windows-registry_oval-717.xml",
                            "/oval_definitions/objects/registry_object",
                            OvalSample.OBJECT_WINDOWS_REGISTRY_717,
                            "marshalled_object-windows-registry_oval-717.xml"
                        }
        };
    }


    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "definitions.object"},
                    dataProvider="definitions.object",
                    alwaysRun=true
                    )
    public void testDefinitionsObject(
                    final Class<SystemObject> type,
                    final String sourceFilepath,
                    final String xpath,
                    final SystemObject expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );
        _testXml( type, sourceFilepath, xpath, expected, resultFilepath );
    }



    //==============================================================
    //  def:state
    //==============================================================

    @DataProvider( name="definitions.state" )
    public Object[][] provideOvalDefinitionsState()
    {
        return new Object[][] {
                        // independent family
                        {
                            State.class,
                            "test/data/definitions/state-independent-family_oval-99.xml",
                            "/oval_definitions/states/family_state",
                            OvalSample.STATE_INDEPENDENT_FAMILY_99,
                            "marshalled_state-independent-family_oval-99.xml"
                        }
                        ,
                        // independent textfilecontent
                        {
                            State.class,
                            "test/data/definitions/state-independent-textfilecontent_oval-5132.xml",
                            "/oval_definitions/states/textfilecontent_state",
                            OvalSample.STATE_INDEPENDENT_TEXTFILECONTENT_5132,
                            "marshalled_state-independent-textfilecontent_oval-5132.xml"
                        }
                        ,
                        // independent textfilecontent54
                        {
                            State.class,
                            "test/data/definitions/state-independent-textfilecontent54_oval-11440.xml",
                            "/oval_definitions/states/textfilecontent54_state",
                            OvalSample.STATE_INDEPENDENT_TEXTFILECONTENT54_11440,
                            "marshalled_state-independent-textfilecontent54_oval-11440.xml"
                        }
                        ,
                        // linux dpkginfo
                        {
                            State.class,
                            "test/data/definitions/state-linux-dpkginfo_oval-5797.xml",
                            "/oval_definitions/states/dpkginfo_state",
                            OvalSample.STATE_LINUX_DPKGINFO_5797,
                            "marshalled_state-linux-dpkginfo_oval-5797.xml"
                        }
                        ,
                        // linux rpminfo
                        {
                            State.class,
                            "test/data/definitions/state-linux-rpminfo_rhsa-20100061002.xml",
                            "/oval_definitions/states/rpminfo_state",
                            OvalSample.STATE_LINUX_RPMINFO_20100061002,
                            "marshalled_state-linux-rpminfo_rhsa-20100061002.xml"
                        }
                        ,
                        // linux rpminfo
                        {
                            State.class,
                            "test/data/definitions/state-linux-rpminfo_rhsa-20100061003.xml",
                            "/oval_definitions/states/rpminfo_state",
                            OvalSample.STATE_LINUX_RPMINFO_20100061003,
                            "marshalled_state-linux-rpminfo_rhsa-20100061003.xml"
                        }
                        ,
                        // linux rpminfo
                        {
                            State.class,
                            "test/data/definitions/state-linux-rpminfo_rhsa-20100061004.xml",
                            "/oval_definitions/states/rpminfo_state",
                            OvalSample.STATE_LINUX_RPMINFO_20100061004,
                            "marshalled_state-linux-rpminfo_rhsa-20100061004.xml"
                        }
                        ,
                        // windows file
                        {
                            State.class,
                            "test/data/definitions/state-windows-file_oval-2190.xml",
                            "/oval_definitions/states/file_state",
                            OvalSample.STATE_WINDOWS_FILE_2190,
                            "marshalled_state-windows-file_oval-2190.xml"
                        }
                        ,
                        // windows metadata
                        {
                            State.class,
                            "test/data/definitions/state-windows-metabase_oval-537.xml",
                            "/oval_definitions/states/metadata_state",
                            OvalSample.STATE_WINDOWS_METABASE_537,
                            "marshalled_state-windows-metabase_oval-537.xml"
                        }
                        ,
                        // windows registry
                        {
                            State.class,
                            "test/data/definitions/state-windows-registry_oval-1205.xml",
                            "/oval_definitions/states/registry_state",
                            OvalSample.STATE_WINDOWS_REGISTRY_1205,
                            "marshalled_state-windows-registry_oval-1205.xml"
                        }
        };
    }


    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "definitions.state"},
                    dataProvider="definitions.state",
                    alwaysRun=true
                    )
    public void testDefinitionsState(
                    final Class<State> type,
                    final String sourceFilepath,
                    final String xpath,
                    final State expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );
        _testXml( type, sourceFilepath, xpath, expected, resultFilepath );
    }



    //==============================================================
    //  def:variable
    //==============================================================

    @DataProvider( name="definitions.variable" )
    public Object[][] provideOvalDefinitionsVariable()
    {
        return new Object[][] {
                        // local, concat
                        {
                            Variable.class,
                            "test/data/definitions/variable-local_oval-246.xml",
                            "/oval_definitions/variables/local_variable",
                            OvalSample.VARIABLE_LOCAL_246,
                            "marshalled_variable-local_oval-246.xml"
                        }
                        ,
                        // local, regex_capture
                        {
                            Variable.class,
                            "test/data/definitions/variable-local_oval-105.xml",
                            "/oval_definitions/variables/local_variable",
                            OvalSample.VARIABLE_LOCAL_105,
                            "marshalled_variable-local_oval-105.xml"
                        }
                        ,
                        // local, concat
                        {
                            Variable.class,
                            "test/data/definitions/variable-local_oval-489.xml",
                            "/oval_definitions/variables/local_variable",
                            OvalSample.VARIABLE_LOCAL_489,
                            "marshalled_variable-local_oval-489.xml"
                        }
        };
    }


    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "definitions.variable"},
                    dataProvider="definitions.variable",
                    alwaysRun=true
                    )
    public void testDefinitionsVariable(
                    final Class<Variable> type,
                    final String sourceFilepath,
                    final String xpath,
                    final Variable expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );
        _testXml( type, sourceFilepath, xpath, expected, resultFilepath );
    }



    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  SC
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //==============================================================
    //  sc:system_info
    //==============================================================

    @DataProvider( name="sc.system_info" )
    public Object[][] provideSCSystemInfo()
    {
        return new Object[][] {
                        {
                            SystemInfo.class,
                            "test/data/sc/system-info_windows.xml",
                            "/oval_system_characteristics/system_info",
                            ScSample.SYSTEM_INFO_WINDOWS_1,
                            "marshalled_system-info_windows.xml"
                        }
        };
    }


    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "sc.system_info"},
                    dataProvider="sc.system_info",
                    alwaysRun=true
                    )
    public void testSCSystemInfo(
                    final Class<SystemInfo> type,
                    final String sourceFilepath,
                    final String xpath,
                    final SystemInfo expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );
        _testXml( type, sourceFilepath, xpath, expected, resultFilepath );
    }



    //==============================================================
    //  sc:oval_system_characteristics
    //==============================================================

    @DataProvider( name="sc.oval_sc" )
    public Object[][] provideSCOvalSC()
    {
        return new Object[][] {
                        {
                            OvalSystemCharacteristics.class,
                            "test/data/sc/oval-sc-5.8-windows-xp_8050.xml",
                            "/oval_system_characteristics",
                            null,
                            "marshalled_oval-sc-5.8-windows-xp_8050.xml"
                        }
//                        ,
//                        {
//                            OvalSystemCharacteristics.class,
//                            "test/data/sc/oval-sc-5.8_oval-8500_CVE-2009-4019_MySQL.xml",
//                            "/oval_system_characteristics",
//                            null,
//                            "marshalled_oval-sc-5.8_oval-8500_CVE-2009-4019_MySQL.xml"
//                        }
        };
    }


    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "sc.oval_sc"},
                    dataProvider="sc.oval_sc",
                    alwaysRun=true
                    )
    public void testSCOvalSC(
                    final Class<OvalSystemCharacteristics> type,
                    final String sourceFilepath,
                    final String xpath,
                    final OvalSystemCharacteristics expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );
        _testXml( type, sourceFilepath, xpath, expected, resultFilepath );
    }




    //==============================================================
    //  sc:item
    //==============================================================

    @DataProvider( name="sc.item" )
    public Object[][] provideSCItem()
    {
        return new Object[][] {
                        // independent family
                        {
                            Item.class,
                            "test/data/sc/item-independent-family_497.xml",
                            "/oval_system_characteristics/system_data/family_item",
                            ScSample.ITEM_INDEPENDENT_FAMILY_497,
                            "marshalled_item-independent-family_497.xml"
                        }
                        ,
                        // independent textfilecontent
                        {
                            Item.class,
                            "test/data/sc/item-independent-textfilecontent_1.xml",
                            "/oval_system_characteristics/system_data/textfilecontent_item",
                            ScSample.ITEM_INDEPENDENT_TEXTFILECONTENT_1,
                            "marshalled_item-independent-textfilecontent_1.xml"
                        }
                        ,
                        // linux dpkginfo
                        {
                            Item.class,
                            "test/data/sc/item-linux-dpkginfo_14.xml",
                            "/oval_system_characteristics/system_data/dpkginfo_item",
                            ScSample.ITEM_LINUX_DPKGINFO_14,
                            "marshalled_item-linux-dpkginfo_14.xml"
                        }
                        ,
                        // linux rpminfo
                        {
                            Item.class,
                            "test/data/sc/item-linux-rpminfo_2.xml",
                            "/oval_system_characteristics/system_data/rpminfo_item",
                            ScSample.ITEM_LINUX_RPMINFO_2,
                            "marshalled_item-linux-rpminfo_2.xml"
                        }
                        ,
                        // unix uname
                        {
                            Item.class,
                            "test/data/sc/item-unix-uname_17.xml",
                            "/oval_system_characteristics/system_data/uname_item",
                            ScSample.ITEM_UNIX_UNAME_17,
                            "marshalled_item-unix-uname_17.xml"
                        }
                        ,
                        // windows file
                        {
                            Item.class,
                            "test/data/sc/item-windows-file_46.xml",
                            "/oval_system_characteristics/system_data/file_item",
                            ScSample.ITEM_WINDOWS_FILE_46,
                            "marshalled_item-windows-file_46.xml"
                        }
                        ,
                        // windows registry
                        {
                            Item.class,
                            "test/data/sc/item-windows-registry_45.xml",
                            "/oval_system_characteristics/system_data/registry_item",
                            ScSample.ITEM_WINDOWS_REGISTRY_45,
                            "marshalled_item-windows-registry_45.xml"
                        }
                        ,
                        // windows registry
                        {
                            Item.class,
                            "test/data/sc/item-windows-registry_83.xml",
                            "/oval_system_characteristics/system_data/registry_item",
                            ScSample.ITEM_WINDOWS_REGISTRY_83,
                            "marshalled_item-windows-registry_83.xml"
                        }
        };
    }


    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "sc.item"},
                    dataProvider="sc.item",
                    alwaysRun=true
                    )
    public void testSCItem(
                    final Class<Item> type,
                    final String sourceFilepath,
                    final String xpath,
                    final Item expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );
        _testXml( type, sourceFilepath, xpath, expected, resultFilepath );
    }




    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  Results
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //==============================================================
    //  oval_results
    //==============================================================

    @DataProvider( name="results.oval_results" )
    public Object[][] provideOvalResultsOvalResults()
    {
        return new Object[][] {
                      // Windows @Mitre, CVE-2010-0176
                      {
                          OvalResults.class,
                          "test/data/results/oval-results_CVE-2010-0176_mitre7222.xml",
                          "/oval_results",
                          null,
                          "marshalled_oval-results_CVE-2010-0176_mitre7222.xml"
                      }
                      ,

                      // Red Hat patch, CVE-2010-0176, RHSA 20100332
                      {
                          OvalResults.class,
                          "test/data/results/oval-results_CVE-2010-0176_rhsa20100332.xml",
                          "/oval_results",
                          null,
                          "marshalled_oval-results_CVE-2010-0176_rhsa20100332.xml"
                      }
                      ,

                      // Debian @Mitre, CVE-2010-0176, DSA-2027
                      {
                          OvalResults.class,
                          "test/data/results/oval-results_CVE-2010-0176_mitre7432_DSA-2027.xml",
                          "/oval_results",
                          null,
                          "marshalled_oval-results_CVE-2010-0176_mitre7432_DSA-2027.xml"
                      }
        };
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "results.oval_results"},
                    dataProvider="results.oval_results",
                    alwaysRun=true
                    )
    public void testOvalResultsOvalResults(
                    final Class<OvalResults> type,
                    final String sourceFilepath,
                    final String xpath,
                    final OvalResults expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        _testXml( type, sourceFilepath, xpath, expected, resultFilepath );
    }



    //==============================================================
    //  directives
    //==============================================================

    public static final Directives OVAL_RESULTS_DIRECTIVES_01 =
        new Directives(
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL )
                        );


    @DataProvider( name="results.directives" )
    public Object[][] provideOvalResultsDirectives()
    {
        return new Object[][] {
                        {
                            Directives.class,
                            "test/data/results/directives_01.xml",
                            "/oval_results/directives",
                            OVAL_RESULTS_DIRECTIVES_01
                        }
        };

    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "results.directives"},
                    dataProvider="results.directives",
                    alwaysRun=true
                    )
    public void testOvalResultsDirectives(
                    final Class<Directives> type,
                    final String filepath,
                    final String xpath,
                    final Directives expected
                    )
    throws Exception
    {
        Directives  actual =
            _unmarshalWithValidation( type, filepath, xpath, expected );

        _marshal( actual, null );
    }

}
// OvalXmlTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

