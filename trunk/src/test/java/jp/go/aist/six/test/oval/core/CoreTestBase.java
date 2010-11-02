package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.core.service.OvalContext;
import jp.go.aist.six.oval.core.store.OvalStore;
import jp.go.aist.six.oval.core.xml.OvalXml;
import jp.go.aist.six.oval.model.NameEntity;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.State;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import jp.go.aist.six.oval.model.definitions.Test;
import jp.go.aist.six.oval.model.definitions.Variable;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.Item;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.model.sc.SystemInfo;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class CoreTestBase
{

    private OvalContext  _context = null;

    private OvalXml  _xml = null;
    private OvalStore  _store = null;



    /**
     */
    public CoreTestBase()
    {
    }



    /**
     */
    @BeforeClass( alwaysRun=true )
    public void setUp()
    throws Exception
    {
        _context = new OvalContext();
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



    /**
     */
    protected <T> T _unmarshalWithValidation(
                    final Class<T> type,
                    final String filepath,
                    final String xpath,
                    final T expected
                    )
    throws Exception
    {
        Reporter.log( "  * XPath: " + xpath, true );
        Reporter.log( "  * XML file: " + filepath, true );

        File  file = new File( filepath );
        Reporter.log( "unmarshalling XML...", true );
        long  time = System.currentTimeMillis();
        Object  obj = _getXml().unmarshal( new FileInputStream( file ) );
        Reporter.log( "...unmarshalling done: " + (System.currentTimeMillis() - time) + "(ms)", true );

        Reporter.log( "  @ unmarshalled object: " + obj, true );
        Assert.assertTrue( type.isInstance( obj ) );

        T  actual = type.cast( obj );

        if (expected != null) {
            Reporter.log( "validating...", true );
            Validators.validator( type ).equals( actual, expected );
            Reporter.log( "...validation OK", true );
        }

        return actual;
    }



    /**
     */
    protected void _marshal(
                    final Object object,
                    final String filepath
                    )
    throws Exception
    {
        OutputStream  output = null;
        if (filepath == null) {
            output = System.out;
        } else {
            Reporter.log( "  * result XML file: " + filepath, true );
            output = new FileOutputStream( new File( filepath ) );
        }

        Reporter.log( "marshalling...", true );
        long  time = System.currentTimeMillis();
        _getXml().marshal( object, output );
        Reporter.log( "...marshalling done: " + (System.currentTimeMillis() - time) + "(ms)", true );
    }



    /**
     */
    protected <T extends NameEntity> void _syncNameEntity(
                    final Class<T> type,
                    final T e
                    )
    throws Exception
    {
//        Reporter.log( "getting object...", true );
//        T  p_eq = _getStore().get( type, e.getPersistentID() );
//        Reporter.log( "...get done", true );
//        Reporter.log( "  @ persistent object: " + p_eq, true );

//        Reporter.log( "finding equaivalent...", true );
//        p_eq = _getStore().findEquivalent( type, e );
//        Reporter.log( "...find equivalent done", true );
//        Reporter.log( "  @ equivalent: " + p_eq, true );

        Reporter.log( "syncing object...", true );
        T  p = _getStore().sync( type, e );
        Reporter.log( "...sync done", true );
        String  pid = p.getPersistentID();
        Reporter.log( "  @ synced: pid=" + pid, true );

        Reporter.log( "getting object...", true );
        T  p2 = _getStore().get( type, pid );
        Reporter.log( "...get done", true );
        Reporter.log( "  @ get: object=" + p2, true );
        Assert.assertEquals( p2, e );
    }




    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  Test Suites
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //**************************************************************
    //  definitions
    //**************************************************************

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
//                        ,
//                      // Mitre, windows, inverntory, MySQL 5.1
//                      {
//                          Definition.class,
//                          "test/data/definitions/definition_oval-def-8297_1.xml",
//                          "oval_definitions/definitions/definition",
//                          OvalSample.DEFINITION_8297
//                      }
//                      ,
//                      // Red Hat, unix, patch, firefox
//                      {
//                          Definition.class,
//                          "test/data/definitions/definition_rhsa-def-20100332_301.xml",
//                          "oval_definitions/definitions/definition",
//                          OvalSample.DEFINITION_20100332
//                      }
        };

    }



    @DataProvider( name="definitions.test" )
    public Object[][] provideDefinitionsTest()
    {
        return new Object[][] {
                        // independent family
                        {
                            Test.class,
                            "test/data/definitions/test-independent-family_oval-99.xml",
                            "/oval_definitions/tests/family_test",
                            DefinitionsSample.TEST_INDEPENDENT_FAMILY_99,
                            "marshalled_test-independent-family_oval-99.xml"
                        }
                        ,
                        // independent textfilecontent
                        {
                            Test.class,
                            "test/data/definitions/test-independent-textfilecontent_oval-11150.xml",
                            "/oval_definitions/tests/textfilecontent_test",
                            DefinitionsSample.TEST_INDEPENDENT_TEXTFILECONTENT_11150,
                            "marshalled_test-independent-textfilecontent_oval-11150.xml"
                        }
                        ,
                        // independent textfilecontent54
                        {
                            Test.class,
                            "test/data/definitions/test-independent-textfilecontent54_oval-41853.xml",
                            "/oval_definitions/tests/textfilecontent54_test",
                            DefinitionsSample.TEST_INDEPENDENT_TEXTFILECONTENT54_41853,
                            "marshalled_test-independent-textfilecontent54_oval-41853.xml"
                        }
                        ,
                        // independent unknown
                        {
                            Test.class,
                            "test/data/definitions/test-independent-unknown_oval-2531.xml",
                            "/oval_definitions/tests/unknown_test",
                            DefinitionsSample.TEST_INDEPENDENT_UNKNOWN_2531,
                            "marshalled_test-independent-unknown_oval-2531.xml"
                        }
                        ,
                        // linux dpkginfo
                        {
                            Test.class,
                            "test/data/definitions/test-linux-dpkginfo_oval-19402.xml",
                            "/oval_definitions/tests/dpkginfo_test",
                            DefinitionsSample.TEST_LINUX_DPKGINFO_19402,
                            "marshalled_test-linux-dpkginfo_oval-19402.xml"
                        }
                        ,
                        // linux rpminfo
                        {
                            Test.class,
                            "test/data/definitions/test-linux-rpminfo_rhsa-20100061002.xml",
                            "/oval_definitions/tests/rpminfo_test",
                            DefinitionsSample.TEST_LINUX_RPMINFO_20100061002,
                            "marshalled_test-linux-rpminfo_rhsa-20100061002.xml"
                        }
                        ,
                        // unix uname
                        {
                            Test.class,
                            "test/data/definitions/test-unix-uname_oval-11195.xml",
                            "/oval_definitions/tests/uname_test",
                            DefinitionsSample.TEST_UNIX_UNAME_11195,
                            "marshalled_test-unix-uname_oval-11195.xml"
                        }
                        ,
                        // windows file, with 2 States
                        {
                            Test.class,
                            "test/data/definitions/test-windows-file_oval-10629.xml",
                            "/oval_definitions/tests/file_test",
                            DefinitionsSample.TEST_WINDOWS_FILE_10629,
                            "marshalled_test-windows-file_oval-10629.xml"
                        }
                        ,
                        // windows file
                        {
                            Test.class,
                            "test/data/definitions/test-windows-file_oval-2339.xml",
                            "/oval_definitions/tests/file_test",
                            DefinitionsSample.TEST_WINDOWS_FILE_2339,
                            "marshalled_test-windows-file_oval-2339.xml"
                        }
                        ,
                        // windows metabase, without State
                        {
                            Test.class,
                            "test/data/definitions/test-windows-metabase_oval-709.xml",
                            "/oval_definitions/tests/metabase_test",
                            DefinitionsSample.TEST_WINDOWS_METABASE_709,
                            "marshalled_test-windows-metabase_oval-709.xml"
                        }
                        ,
                        // windows registry
                        {
                            Test.class,
                            "test/data/definitions/test-windows-registry_oval-3019.xml",
                            "/oval_definitions/tests/registry_test",
                            DefinitionsSample.TEST_WINDOWS_REGISTRY_3019,
                            "marshalled_test-windows-registry_oval-3019.xml"
                        }
        };
    }



    @DataProvider( name="definitions.object" )
    public Object[][] provideDefinitionsObject()
    {
        return new Object[][] {
                        // independent family
                        {
                            SystemObject.class,
                            "test/data/definitions/object-independent-family_oval-99.xml",
                            "/oval_definitions/objects/family_object",
                            DefinitionsSample.OBJECT_INDEPENDENT_FAMILY_99,
                            "marshalled_object-independent-family_oval-99.xml"
                        }
                        ,
                        // independent textfilecontent
                        {
                            SystemObject.class,
                            "test/data/definitions/object-independent-textfilecontent_oval-7326.xml",
                            "/oval_definitions/objects/textfilecontent_object",
                            DefinitionsSample.OBJECT_INDEPENDENT_TEXTFILECONTENT_7326,
                            "marshalled_object-independent-textfilecontent_oval-7326.xml"
                        }
                        ,
                        // independent textfilecontent54
                        {
                            SystemObject.class,
                            "test/data/definitions/object-independent-textfilecontent54_oval-15567.xml",
                            "/oval_definitions/objects/textfilecontent54_object",
                            DefinitionsSample.OBJECT_INDEPENDENT_TEXTFILECONTENT54_15567,
                            "marshalled_object-independent-textfilecontent54_oval-15567.xml"
                        }
                        ,
                        // linux dpkginfo
                        {
                            SystemObject.class,
                            "test/data/definitions/object-linux-dpkginfo_oval-10648.xml",
                            "/oval_definitions/objects/dpkginfo_object",
                            DefinitionsSample.OBJECT_LINUX_DPKGINFO_10648,
                            "marshalled_object-linux-dpkginfo_oval-10648.xml"
                        }
                        ,
                        // linux rpminfo
                        {
                            SystemObject.class,
                            "test/data/definitions/object-linux-rpminfo_rhsa-20100061001.xml",
                            "/oval_definitions/objects/rpminfo_object",
                            DefinitionsSample.OBJECT_LINUX_RPMINFO_20100061001,
                            "marshalled_object-linux-rpminfo_rhsa-20100061001.xml"
                        }
                        ,
                        // unix uname
                        {
                            SystemObject.class,
                            "test/data/definitions/object-unix-uname_oval-2759.xml",
                            "/oval_definitions/objects/uname_object",
                            DefinitionsSample.OBJECT_UNAME_UNAME_2759,
                            "marshalled_object-unix-uname_oval-2759.xml"
                        }
                        ,
                        // windows file
                        {
                            SystemObject.class,
                            "test/data/definitions/object-windows-file_oval-222.xml",
                            "/oval_definitions/objects/file_object",
                            DefinitionsSample.OBJECT_WINDOWS_FILE_222,
                            "marshalled_object-windows-file_oval-222.xml"
                        }
                        ,
                        // windows file
                        {
                            SystemObject.class,
                            "test/data/definitions/object-windows-file_oval-6982.xml",
                            "/oval_definitions/objects/file_object",
                            DefinitionsSample.OBJECT_WINDOWS_FILE_6982,
                            "marshalled_object-windows-file_oval-6982.xml"
                        }
                        ,
                        // windows metabase
                        {
                            SystemObject.class,
                            "test/data/definitions/object-windows-metabase_oval-556.xml",
                            "/oval_definitions/objects/metabase_object",
                            DefinitionsSample.OBJECT_WINDOWS_METABASE_556,
                            "marshalled_object-windows-metabase_oval-556.xml"
                        }
                        ,
                        // windows registry
                        {
                            SystemObject.class,
                            "test/data/definitions/object-windows-registry_oval-717.xml",
                            "/oval_definitions/objects/registry_object",
                            DefinitionsSample.OBJECT_WINDOWS_REGISTRY_717,
                            "marshalled_object-windows-registry_oval-717.xml"
                        }
        };
    }



    @DataProvider( name="definitions.state" )
    public Object[][] provideOvalDefinitionsState()
    {
        return new Object[][] {
                        // independent family
                        {
                            State.class,
                            "test/data/definitions/state-independent-family_oval-99.xml",
                            "/oval_definitions/states/family_state",
                            DefinitionsSample.STATE_INDEPENDENT_FAMILY_99,
                            "marshalled_state-independent-family_oval-99.xml"
                        }
                        ,
                        // independent textfilecontent
                        {
                            State.class,
                            "test/data/definitions/state-independent-textfilecontent_oval-5132.xml",
                            "/oval_definitions/states/textfilecontent_state",
                            DefinitionsSample.STATE_INDEPENDENT_TEXTFILECONTENT_5132,
                            "marshalled_state-independent-textfilecontent_oval-5132.xml"
                        }
                        ,
                        // independent textfilecontent54
                        {
                            State.class,
                            "test/data/definitions/state-independent-textfilecontent54_oval-11440.xml",
                            "/oval_definitions/states/textfilecontent54_state",
                            DefinitionsSample.STATE_INDEPENDENT_TEXTFILECONTENT54_11440,
                            "marshalled_state-independent-textfilecontent54_oval-11440.xml"
                        }
                        ,
                        // linux dpkginfo
                        {
                            State.class,
                            "test/data/definitions/state-linux-dpkginfo_oval-5797.xml",
                            "/oval_definitions/states/dpkginfo_state",
                            DefinitionsSample.STATE_LINUX_DPKGINFO_5797,
                            "marshalled_state-linux-dpkginfo_oval-5797.xml"
                        }
                        ,
                        // linux rpminfo
                        {
                            State.class,
                            "test/data/definitions/state-linux-rpminfo_rhsa-20100061002.xml",
                            "/oval_definitions/states/rpminfo_state",
                            DefinitionsSample.STATE_LINUX_RPMINFO_20100061002,
                            "marshalled_state-linux-rpminfo_rhsa-20100061002.xml"
                        }
                        ,
                        // linux rpminfo
                        {
                            State.class,
                            "test/data/definitions/state-linux-rpminfo_rhsa-20100061003.xml",
                            "/oval_definitions/states/rpminfo_state",
                            DefinitionsSample.STATE_LINUX_RPMINFO_20100061003,
                            "marshalled_state-linux-rpminfo_rhsa-20100061003.xml"
                        }
                        ,
                        // linux rpminfo
                        {
                            State.class,
                            "test/data/definitions/state-linux-rpminfo_rhsa-20100061004.xml",
                            "/oval_definitions/states/rpminfo_state",
                            DefinitionsSample.STATE_LINUX_RPMINFO_20100061004,
                            "marshalled_state-linux-rpminfo_rhsa-20100061004.xml"
                        }
                        ,
                        // unix uname
                        {
                            State.class,
                            "test/data/definitions/state-unix-uname_oval-3597.xml",
                            "/oval_definitions/states/uname_state",
                            DefinitionsSample.STATE_UNIX_UNAME_3597,
                            "marshalled_state-unix-uname_oval-3597.xml"
                        }
                        ,
                        // unix uname
                        {
                            State.class,
                            "test/data/definitions/state-unix-uname_oval-5377.xml",
                            "/oval_definitions/states/uname_state",
                            DefinitionsSample.STATE_UNIX_UNAME_5377,
                            "marshalled_state-unix-uname_oval-5377.xml"
                        }
                        ,
                        // windows file/version
                        {
                            State.class,
                            "test/data/definitions/state-windows-file_oval-2190.xml",
                            "/oval_definitions/states/file_state",
                            DefinitionsSample.STATE_WINDOWS_FILE_2190,
                            "marshalled_state-windows-file_oval-2190.xml"
                        }
                        ,
                        // windows file/product_version
                        {
                            State.class,
                            "test/data/definitions/state-windows-file_oval-6503.xml",
                            "/oval_definitions/states/file_state",
                            DefinitionsSample.STATE_WINDOWS_FILE_6503,
                            "marshalled_state-windows-file_oval-6503.xml"
                        }
                        ,
                        // windows metadata
                        {
                            State.class,
                            "test/data/definitions/state-windows-metabase_oval-537.xml",
                            "/oval_definitions/states/metadata_state",
                            DefinitionsSample.STATE_WINDOWS_METABASE_537,
                            "marshalled_state-windows-metabase_oval-537.xml"
                        }
                        ,
                        // windows registry
                        {
                            State.class,
                            "test/data/definitions/state-windows-registry_oval-1205.xml",
                            "/oval_definitions/states/registry_state",
                            DefinitionsSample.STATE_WINDOWS_REGISTRY_1205,
                            "marshalled_state-windows-registry_oval-1205.xml"
                        }
        };
    }



    @DataProvider( name="definitions.variable" )
    public Object[][] provideOvalDefinitionsVariable()
    {
        return new Object[][] {
                        // local, concat
                        {
                            Variable.class,
                            "test/data/definitions/variable-local_oval-246.xml",
                            "/oval_definitions/variables/local_variable",
                            DefinitionsSample.VARIABLE_LOCAL_246,
                            "marshalled_variable-local_oval-246.xml"
                        }
                        ,
                        // local, regex_capture
                        {
                            Variable.class,
                            "test/data/definitions/variable-local_oval-105.xml",
                            "/oval_definitions/variables/local_variable",
                            DefinitionsSample.VARIABLE_LOCAL_105,
                            "marshalled_variable-local_oval-105.xml"
                        }
                        ,
                        // local, concat
                        {
                            Variable.class,
                            "test/data/definitions/variable-local_oval-489.xml",
                            "/oval_definitions/variables/local_variable",
                            DefinitionsSample.VARIABLE_LOCAL_489,
                            "marshalled_variable-local_oval-489.xml"
                        }
        };
    }



    @DataProvider( name="definitions.oval_definitions" )
    public Object[][] provideOvalDefinitionsOvalDefinitions()
    {
        return new Object[][] {
                        // Windows XP, CVE-2010-0035, PowerPoint
                        {
                            OvalDefinitions.class,
                            "test/data/definitions/oval-definitions-5.8_windows-xp_8050.xml",
                            "/oval_definitions",
                            DefinitionsSample.OVAL_DEFINITIONS_8050,
                            "marshalled_oval-definitions-5.8_windows-xp_8050.xml"
                        }
//                        ,
//                        // Red Hat, CVE-2010-0176, RHSA 20100332
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/oval-definitions_rhsa-20100332_CVE-2010-0176.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_oval-definitions_rhsa-20100332_CVE-2010-0176.xml"
//                        }
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





    //**************************************************************
    //  system characteristics
    //**************************************************************

    @DataProvider( name="sc.system_info" )
    public Object[][] provideSCSystemInfo()
    {
        return new Object[][] {
                        {
                            SystemInfo.class,
                            "test/data/sc/system-info_windows.xml",
                            "/oval_system_characteristics/system_info",
                            ScSample.SYSTEM_INFO_WINDOWS_FOO60,
                            "marshalled_system-info_windows.xml"
                        }
        };
    }



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



    @DataProvider( name="sc.oval_sc" )
    public Object[][] provideSCOvalSC()
    {
        return new Object[][] {
                        {
                            OvalSystemCharacteristics.class,
                            "test/data/sc/oval-sc-5.8_windows-xp_8050.xml",
                            "/oval_system_characteristics",
                            ScSample.OVAL_SC_DEF8050,
                            "marshalled_oval-sc-5.8_windows-xp_8050.xml"
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





    //**************************************************************
    //  results
    //**************************************************************

    @DataProvider( name="results.oval_results" )
    public Object[][] provideOvalResultsOvalResults()
    {
        return new Object[][] {
                      // Windows XP, CVE-2010-0030, MS PowerPoint
                      {
                          OvalResults.class,
                          "test/data/results/oval-results-5.8_windows-xp_8050.xml",
                          "/oval_results",
                          ResultsSample.OVAL_RESULTS_8050,
                          "marshalled_oval-results-5.8_windows-xp_8050.xml"
                      }
//                      ,
//                      // Windows @Mitre, CVE-2010-0176
//                      {
//                          OvalResults.class,
//                          "test/data/results/oval-results_CVE-2010-0176_mitre7222.xml",
//                          "/oval_results",
//                          null,
//                          "marshalled_oval-results_CVE-2010-0176_mitre7222.xml"
//                      }
//                      ,
//                      // Red Hat patch, CVE-2010-0176, RHSA 20100332
//                      {
//                          OvalResults.class,
//                          "test/data/results/oval-results_CVE-2010-0176_rhsa20100332.xml",
//                          "/oval_results",
//                          null,
//                          "marshalled_oval-results_CVE-2010-0176_rhsa20100332.xml"
//                      }
//                      ,
//                      // Debian @Mitre, CVE-2010-0176, DSA-2027
//                      {
//                          OvalResults.class,
//                          "test/data/results/oval-results_CVE-2010-0176_mitre7432_DSA-2027.xml",
//                          "/oval_results",
//                          null,
//                          "marshalled_oval-results_CVE-2010-0176_mitre7432_DSA-2027.xml"
//                      }
        };
    }

}
// CoreTestBase

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

