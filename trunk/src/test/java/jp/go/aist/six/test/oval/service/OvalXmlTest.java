package jp.go.aist.six.test.oval.service;

import jp.go.aist.six.oval.core.model.definition.OvalDefinitionsUtil;
import jp.go.aist.six.oval.core.service.OvalContext;
import jp.go.aist.six.oval.core.xml.OvalXml;
import jp.go.aist.six.oval.model.common.Family;
import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.definition.Affected;
import jp.go.aist.six.oval.model.definition.Cve;
import jp.go.aist.six.oval.model.definition.Definition;
import jp.go.aist.six.oval.model.definition.DefinitionClass;
import jp.go.aist.six.oval.model.definition.Definitions;
import jp.go.aist.six.oval.model.definition.Metadata;
import jp.go.aist.six.oval.model.definition.MetadataItem;
import jp.go.aist.six.oval.model.definition.OvalDefinitions;
import jp.go.aist.six.oval.model.definition.Platform;
import jp.go.aist.six.oval.model.definition.Product;
import jp.go.aist.six.oval.model.definition.Reference;
import jp.go.aist.six.oval.model.linux.CveReference;
import jp.go.aist.six.oval.model.linux.LinuxSecurityAdvisory;
import jp.go.aist.six.oval.model.linux.RpmInfoItem;
import jp.go.aist.six.oval.model.linux.Severity;
import jp.go.aist.six.oval.model.mitre.DefinitionModifiedEvent;
import jp.go.aist.six.oval.model.mitre.MitreRepositoryMetadataItem;
import jp.go.aist.six.oval.model.mitre.OvalRepositoryEvent;
import jp.go.aist.six.oval.model.result.DefinitionResult;
import jp.go.aist.six.oval.model.result.OvalResults;
import jp.go.aist.six.oval.model.result.Result;
import jp.go.aist.six.oval.model.result.SystemResult;
import jp.go.aist.six.oval.model.system.CollectedSystemObject;
import jp.go.aist.six.oval.model.system.EntityItemString;
import jp.go.aist.six.oval.model.system.Flag;
import jp.go.aist.six.oval.model.system.Item;
import jp.go.aist.six.oval.model.system.NetInterface;
import jp.go.aist.six.oval.model.system.OvalSystemCharacteristics;
import jp.go.aist.six.oval.model.system.Status;
import jp.go.aist.six.oval.model.system.SystemData;
import jp.go.aist.six.oval.model.system.SystemInfo;
import jp.go.aist.six.util.IsoDate;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalXmlTest.java 764 2010-05-10 08:47:46Z akihito $
 */
public class OvalXmlTest
{

    protected OvalXml  _xml = null;


    /**
     */
    public OvalXmlTest()
    {
    }



    /**
     */
    @BeforeClass( alwaysRun=true )
    public void setUp()
        throws Exception
    {
        OvalContext  service = new OvalContext();
        _xml = service.getXml();
    }



    /**
     */
    public void run()
        throws Exception
    {
    }


    private static final String  _PLATFORM_LINUX_REDHAT_ = "Linux RedHat";
    private static final String  _PLATFORM_LINUX_CENTOS_ = "Linux CentOS";
    private static final String  _PLATFORM_LINUX_DEBIAN_ = "Linux Debian";
    private static final String  _PLATFORM_WINDOWS_      = "Windows";


    //**************************************************************
    //  OVAL Results
    //**************************************************************

    private static final String  _SAMPLE_OVAL_R_LINUX_CENTOS_ =
        "test/data/sample_oval-results_linux-centos.xml";

    private static final String  _SAMPLE_OVAL_R_WINDOWS_ =
        "test/data/sample_oval-results_windows.xml";


    private static final String  _SAMPLE_OVAL_R_DEBIAN_ =
        "test/data/sample_oval-results_linux-debian.xml";



    /**
     * Sample OVAL results.
     */
    @DataProvider( name="oval-results" )
    public Object[][] ovalResultsProvider()
    {
        return new Object[][] {
                        {
                            _PLATFORM_WINDOWS_,
                            _SAMPLE_OVAL_R_WINDOWS_
                        },
                        {
                            _PLATFORM_LINUX_DEBIAN_,
                            _SAMPLE_OVAL_R_DEBIAN_
                        },
                        {
                            _PLATFORM_LINUX_CENTOS_,
                            _SAMPLE_OVAL_R_LINUX_CENTOS_
                        }
        };
    }


    /**
     * Unmarshalls the OVAL results.
     */
    @org.testng.annotations.Test( groups={"oval.xml", "oval_results"},
                    dataProvider="oval-results",
                    alwaysRun=true
                    )
    public void unmarshalOvalResults(
                    final String platform,
                    final String filepath
                    )
    throws Exception
    {
        Reporter.log( "\n// OVAL results: unmarshal XML", true );
        Reporter.log( "### platform: " + platform, true );

        File  file = new File( filepath );
        Reporter.log( "*** unmarshalling XML...: file=" + file.getAbsolutePath(), true );
        Reader  reader = new InputStreamReader(
                            new FileInputStream( file ), Charset.forName( "UTF-8" ) );

        OvalResults  results = (OvalResults)_xml.unmarshal( reader );
        Assert.assertNotNull( results );

        if (filepath.equals( _SAMPLE_OVAL_R_LINUX_CENTOS_ )) {
            _validateOvalResultsLinuxCentOS( results );
        }
    }


    private void _validateOvalResultsLinuxCentOS(
                    final OvalResults results
                    )
    throws Exception
    {
        final String  definition_id = "oval:com.redhat.rhsa:def:20091039";


        //==========================================================
        // generator
        //==========================================================
        Reporter.log( "  *** checking generator...", true );
        Generator  generator = results.getGenerator();
        Assert.assertNotNull( generator );
        Assert.assertEquals( generator.getProductName(), "OVAL Definition Interpreter" );
        Assert.assertEquals( generator.getProductVersion(), "5.5 Build: 4" );
        Assert.assertEquals( generator.getSchemaVersion(), "5.5" );
        String  timestamp = IsoDate.format( generator.getTimestamp() );
        Assert.assertEquals( timestamp, "2009-05-22T12:44:59" );


        //==========================================================
        // OVAL Definitions
        //==========================================================
        Reporter.log( "  *** checking oval_definitions...", true );
        OvalDefinitions  defs = results.getDefinitions();

        Reporter.log( "  *** checking oval_definitions/generator...", true );
        Generator  defs_gen = defs.getGenerator();
//        Reporter.log( "    @@@ " + defs_gen, true );
        Assert.assertEquals( defs_gen.getProductName(), "Red Hat Errata System" );
        Assert.assertEquals( defs_gen.getSchemaVersion(), "5.3" );
        String  defs_gen_timestamp = IsoDate.format( defs_gen.getTimestamp() );
        Assert.assertEquals( defs_gen_timestamp, "2009-05-18T16:35:05" );

        Reporter.log( "  *** checking oval_definitions/definitions...", true );
        Definitions  def_list = defs.getDefinitions();
        Assert.assertEquals( def_list.size(), 1 );
        Definition  def = def_list.iterator().next();
        Reporter.log( "    @@@ definiton id=" + def.getOvalID(), true );
        Assert.assertEquals( def.getOvalID(), definition_id );
        Assert.assertEquals( def.getOvalVersion(), 301 );
        Assert.assertEquals( def.getDefinitionClass(), DefinitionClass.PATCH );

        Metadata  metadata = def.getMetadata();
        Assert.assertNotNull( metadata );
        Assert.assertEquals( metadata.getTitle(), "RHSA-2009:1039: ntp security update (Important)" );

        Assert.assertEquals( metadata.getReference().size(), 1 );
        Reference  ref = metadata.getReference().iterator().next();
//        Reporter.log( "    @@@ reference=" + ref, true );
        Assert.assertEquals( ref.getSource(), "RHSA" );
        Assert.assertEquals( ref.getRefID(), "RHSA-2009:1039-00" );
        Assert.assertEquals( ref.getRefURL(), "https://rhn.redhat.com/errata/RHSA-2009-1039.html" );

        // definition/metadata/affected //
        Affected  affected = metadata.getAffected();
        Assert.assertNotNull( affected );
        Assert.assertEquals( affected.getFamily(), Family.UNIX );
        Assert.assertEquals( affected.getPlatform().size(), 1 );
        Platform  platform = affected.getPlatform().iterator().next();
        Assert.assertEquals( platform.getName(), "Red Hat Enterprise Linux 5" );
        Assert.assertEquals( affected.getProduct().size(), 0 );


        Reporter.log( "  *** checking oval_definitions/tests...", true );
        Assert.assertEquals( defs.getTests().size(), 3 );


        // results //

        Reporter.log( "  *** checking results...", true );
        Assert.assertEquals( results.getResults().size(), 1 );
        SystemResult  system = results.getResults().iterator().next();
        Assert.assertEquals( system.getDefinitions().size(), 1 );
        DefinitionResult  def_result = system.getDefinitions().iterator().next();
        Assert.assertEquals( def_result.getOvalID(), definition_id );
        Assert.assertEquals( def_result.getResult(), Result.TRUE );

        // oval_system_characteristics //
        OvalSystemCharacteristics  sc = system.getOvalSystemCharacteristics();
        Assert.assertNotNull( sc );

        Generator  sc_gen = sc.getGenerator();
        Assert.assertNotNull( sc_gen );
        Assert.assertEquals( sc_gen.getProductName(), "OVAL Definition Interpreter" );
        Assert.assertEquals( sc_gen.getProductVersion(), "5.5 Build: 4" );
        Assert.assertEquals( sc_gen.getSchemaVersion(), "5.5" );
        String  sc_gen_timestamp = IsoDate.format( sc_gen.getTimestamp() );
        Assert.assertEquals( sc_gen_timestamp, "2009-05-22T12:44:57" );

        SystemInfo  sys = sc.getSystemInfo();
        Assert.assertEquals( sys.getOsName(), "Linux" );
        Assert.assertEquals( sys.getOsVersion(), "#1 SMP Thu May 7 10:39:21 EDT 2009" );
        Assert.assertEquals( sys.getArchitecture(), "i686" );
        Assert.assertEquals( sys.getPrimaryHostName(), "dhcp149254.a01.aist.go.jp" );

        Assert.assertEquals( sys.getInterfaces().size(), 1 );
        NetInterface  netif = new NetInterface(
                        "eth0", "150.29.149.254", "00.0c.29.78.1a.8b" );
        Assert.assertEquals( sys.getInterfaces().iterator().next(), netif );

        Collection<CollectedSystemObject>  collected_objects = sc.getCollectedObjects().getObject();
        Reporter.log( "    @@@ #collected objects: " + collected_objects.size(), true );
        Assert.assertEquals( collected_objects.size(), 2 );

        SystemData  sd = sc.getSystemData();
        Reporter.log( "    @@@ #items: " + sd.size(), true );
        Assert.assertEquals( sd.size(), 2 );
    }



    //**************************************************************
    //  OVAL system characteristics
    //**************************************************************

    private static final String  _SAMPLE_OVAL_SC_LINUX_CENTOS_ =
        "test/data/system/sample_oval-sc_linux-centos.xml";

    private static final String  _SAMPLE_OVAL_SC_WINDOWS_ =
        "test/data/system/sample_oval-sc_windows.xml";



    /**
     * Sample OVAL SC.
     */
    @DataProvider( name="oval-sc" )
    public Object[][] ovalScProvider()
    {
        return new Object[][] {
                        {
                            _PLATFORM_WINDOWS_,
                            _SAMPLE_OVAL_SC_WINDOWS_
                        },
                        {
                            _PLATFORM_LINUX_CENTOS_,
                            _SAMPLE_OVAL_SC_LINUX_CENTOS_
                        }
        };
    }


    /**
     * Unmarshalls the OVAL system characteristics.
     */
    @org.testng.annotations.Test( groups={"oval.xml", "oval_system_characteristics"},
                    dataProvider="oval-sc",
                    alwaysRun=true
                    )
    public void unmarshalOvalSc(
                    final String platform,
                    final String filepath
                    )
    throws Exception
    {
        Reporter.log( "\n// OVAL system characteristics: unmarshal XML", true );
        Reporter.log( "### platform: " + platform, true );

        File  file = new File( filepath );
        Reporter.log( "*** unmarshalling XML...: file=" + file.getAbsolutePath(), true );
        Reader  reader = new InputStreamReader(
                            new FileInputStream( file ), Charset.forName( "UTF-8" ) );

        OvalSystemCharacteristics  sc =
            (OvalSystemCharacteristics)_xml.unmarshal( reader );
        Assert.assertNotNull( sc );

        if (filepath.equals( _SAMPLE_OVAL_SC_WINDOWS_ )) {
            _validateOvalSystemCharacteristicsWindows( sc );
        } else if (filepath.equals( _SAMPLE_OVAL_SC_LINUX_CENTOS_ )) {
            _validateOvalSystemCharacteristicsLinuxCentOS( sc );
        }
    }


    private void _validateOvalSystemCharacteristicsLinuxCentOS(
                    final OvalSystemCharacteristics sc
                    )
    throws Exception
    {
        //==========================================================
        // generator
        //==========================================================
        Reporter.log( "  *** checking generator...", true );
        Generator  generator = sc.getGenerator();
        Assert.assertNotNull( generator );
        Assert.assertEquals( generator.getProductName(), "OVAL Definition Interpreter" );
        Assert.assertEquals( generator.getProductVersion(), "5.5 Build: 4" );
        Assert.assertEquals( generator.getSchemaVersion(), "5.5" );

        String  timestamp = IsoDate.format( generator.getTimestamp() );
        Assert.assertEquals( timestamp, "2009-07-10T12:49:07" );


        //==========================================================
        // system_info
        //==========================================================
        Reporter.log( "  *** checking system_info...", true );
        SystemInfo  sys = sc.getSystemInfo();
        Assert.assertEquals( sys.getOsName(), "Linux" );
        Assert.assertEquals( sys.getOsVersion(), "#1 SMP Wed Jun 17 06:40:54 EDT 2009" );
        Assert.assertEquals( sys.getArchitecture(), "i686" );
        Assert.assertEquals( sys.getPrimaryHostName(), "dhcp149254.a01.aist.go.jp" );

        Assert.assertEquals( sys.getInterfaces().size(), 1 );
        NetInterface  netif = new NetInterface(
                        "eth0", "150.29.149.254", "00.0c.29.78.1a.8b" );
        Assert.assertEquals( sys.getInterfaces().iterator().next(), netif );


        //==========================================================
        // collected_objects
        //==========================================================
        Reporter.log( "  *** checking objects...", true );
        Collection<CollectedSystemObject>  objects = sc.getCollectedObjects().getObject();
        Reporter.log( "    @@@ #objects: " + objects.size(), true );
        Assert.assertEquals( objects.size(), 5 );

        Collection<String>  object_ids = Arrays.asList( new String[] {
                        "oval:com.redhat.rhsa:obj:20091148001",
                        "oval:com.redhat.rhsa:obj:20091148002",
                        "oval:com.redhat.rhsa:obj:20091148003",
                        "oval:com.redhat.rhsa:obj:20091148004",
                        "oval:com.redhat.rhsa:obj:20091148005"
        });

        HashMap<String, Integer>  object_item_refs = new HashMap<String, Integer>();
        object_item_refs.put( "oval:com.redhat.rhsa:obj:20091148001", new Integer( 3 ) );
        object_item_refs.put( "oval:com.redhat.rhsa:obj:20091148002", new Integer( 5 ) );
        object_item_refs.put( "oval:com.redhat.rhsa:obj:20091148003", new Integer( 1 ) );
        object_item_refs.put( "oval:com.redhat.rhsa:obj:20091148004", new Integer( 4 ) );
        object_item_refs.put( "oval:com.redhat.rhsa:obj:20091148005", new Integer( 2 ) );

        // object's id, version, flag, reference
        for (CollectedSystemObject  object : objects) {
//          Reporter.log( "    object: " + object, true );
            Assert.assertTrue( object_ids.contains( object.getOvalID() ) );
            Assert.assertEquals( object.getOvalVersion(), 301 );
            if (object.getOvalID().equals( "oval:com.redhat.rhsa:obj:20091148005" )) {
                Assert.assertEquals( Flag.DOES_NOT_EXIST, object.getFlag() );
            } else {
                Assert.assertEquals( Flag.COMPLETE, object.getFlag() );
            }

            Assert.assertEquals( object.getReference().size(), 1 );
            int  item_ref = object_item_refs.get( object.getOvalID() ).intValue();
            Assert.assertEquals( object.getReference().iterator().next().getItemRef(), item_ref );
        }


        //==========================================================
        // system_data (collected items)
        //==========================================================
        Reporter.log( "  *** checking items...", true );
        SystemData  systemData = sc.getSystemData();
        Reporter.log( "    @@@ #items: " + systemData.size(), true );
        Assert.assertEquals( systemData.size(), 5 );

        // rpminfo_item/@id --- rpminfo_item/name //
        HashMap<Integer, String>  rpm_names = new HashMap<Integer, String>();
        rpm_names.put( new Integer( 3 ), "centos-release" );
        rpm_names.put( new Integer( 5 ), "httpd" );
        rpm_names.put( new Integer( 1 ), "httpd-manual" );
        rpm_names.put( new Integer( 4 ), "mod_ssl" );
        rpm_names.put( new Integer( 2 ), "httpd-devel" );

        // rpminfo_item/name --- rpminfo_item/evr //
        HashMap<String, String>  rpm_evrs = new HashMap<String, String>();
        rpm_evrs.put( "centos-release", "10:5-3.el5.centos.1" );
        rpm_evrs.put( "httpd", "0:2.2.3-22.el5.centos.1" );
        rpm_evrs.put( "httpd-manual", "0:2.2.3-22.el5.centos.1" );
        rpm_evrs.put( "mod_ssl", "1:2.2.3-22.el5.centos.1" );
        rpm_evrs.put( "httpd-devel", null );

        for (Item  item : systemData) {
            int  id = item.getID();
//          Reporter.log( "    item: " + item, true );
            Assert.assertTrue( item instanceof RpmInfoItem);
            RpmInfoItem  rpm_info = (RpmInfoItem)item;
            if (rpm_info != null) {
                EntityItemString  rpm_name = rpm_info.getName();
                if (rpm_name != null) {
                    String  pkg_name = rpm_name.getData();
                    Assert.assertEquals( rpm_names.get( new Integer( id ) ), pkg_name );
                    Assert.assertEquals( rpm_evrs.get( pkg_name ), rpm_info.getEvr() );
                }
            }

            if (id == 2) {
                Assert.assertEquals( item.getStatus(), Status.DOES_NOT_EXIST );
            } else {
                Assert.assertEquals( rpm_info.getSignatureKeyID(), "a8a447dce8562897" );
            }
        }
    }


    private void _validateOvalSystemCharacteristicsWindows(
                    final OvalSystemCharacteristics sc
    )
    throws Exception
    {
        //==========================================================
        // system_info
        //==========================================================
        Reporter.log( "*** checking system_info...", true );
        SystemInfo  sys = sc.getSystemInfo();
        for (NetInterface  netif : sys.getInterfaces()) {
            Reporter.log( "@@@ network interface: " + netif, true );
        }


        //==========================================================
        // collected_objects
        //==========================================================
        Reporter.log( "  *** checking objects...", true );
        Collection<CollectedSystemObject>  objects = sc.getCollectedObjects().getObject();
        Reporter.log( "    #objects: " + objects.size(), true );

        Collection<String>  messaged_ids = Arrays.asList( new String[] {
                        "oval:org.mitre.oval:obj:1",
                        "oval:org.mitre.oval:obj:1014",
                        "oval:org.mitre.oval:obj:1070"
        });

        for (CollectedSystemObject  object : objects) {
            String  id = object.getOvalID();
            if (messaged_ids.contains( id )) {
//                Reporter.log( "    object: id=" + object.getID()
//                                + ", message=" + object.getMessage(), true );
                Assert.assertTrue( object.getMessage() != null );
            }
        }
    }



    //**************************************************************
    //  OVAL definitions
    //**************************************************************

    // Debian
    private static final String  _SAMPLE_OVAL_D_LINUX_DEBIAN_ =
        "test/data/sample_oval-definitions_linux-debian.xml";

    private static final String  _SAMPLE_OVAL_D_LINUX_DEBIAN_DEFINITION_ID_ =
        "oval:jp.go.aist.debian:def:20100112";

    private static final Integer _SAMPLE_OVAL_D_LINUX_DEBIAN_DEFINITION_VERSION_ =
        Integer.valueOf( 1 );


    // Red Hat
    private static final String  _SAMPLE_OVAL_D_LINUX_REDHAT_ =
        "test/data/sample_oval-definitions_linux-redhat.xml";

    private static final String  _SAMPLE_OVAL_D_LINUX_REDHAT_DEFINITION_ID_ =
        "oval:com.redhat.rhsa:def:20100061";

    private static final Integer _SAMPLE_OVAL_D_LINUX_REDHAT_DEFINITION_VERSION_ =
        Integer.valueOf( 301 );


    // Windows
    private static final String  _SAMPLE_OVAL_D_WINDOWS_ =
        "test/data/sample_oval-definitions_windows.xml";

    private static final String  _SAMPLE_OVAL_D_WINDOWS_DEFINITION_ID_ =
        "oval:org.mitre.oval:def:1020";

    private static final Integer  _SAMPLE_OVAL_D_WINDOWS_DEFINITION_VERSION_ =
        Integer.valueOf( 2 );


    // CentOS (generated)
    private static final String  _SAMPLE_OVAL_D_LINUX_CENTOS_ =
        "test/data/sample_oval-definitions_linux-centos.xml";

    private static final String  _SAMPLE_OVAL_D_LINUX_CENTOS_DEFINITION_ID_ =
        "oval:jp.go.aist.six.oval.centos:def:20100061";

    private static final Integer _SAMPLE_OVAL_D_LINUX_CENTOS_DEFINITION_VERSION_ =
        Integer.valueOf( 301 );


//    { "/jp/go/aist/six/test/oval/oval-sample_definitions_linux-dpkg_debian-1960.xml", "Linux/DPKG" },


    /**
     * Sample OVAL Definitions.
     */
    @DataProvider( name="oval-definitions" )
    public Object[][] ovalDefinitionsProvider()
    {
        return new Object[][] {
                        {
                            _PLATFORM_LINUX_DEBIAN_,
                            _SAMPLE_OVAL_D_LINUX_DEBIAN_,
                            _SAMPLE_OVAL_D_LINUX_DEBIAN_DEFINITION_ID_,
                            _SAMPLE_OVAL_D_LINUX_DEBIAN_DEFINITION_VERSION_
                        },
                        {
                            _PLATFORM_LINUX_REDHAT_,
                            _SAMPLE_OVAL_D_LINUX_REDHAT_,
                            _SAMPLE_OVAL_D_LINUX_REDHAT_DEFINITION_ID_,
                            _SAMPLE_OVAL_D_LINUX_REDHAT_DEFINITION_VERSION_
                        },
                        {
                            _PLATFORM_WINDOWS_,
                            _SAMPLE_OVAL_D_WINDOWS_,
                            _SAMPLE_OVAL_D_WINDOWS_DEFINITION_ID_,
                            _SAMPLE_OVAL_D_WINDOWS_DEFINITION_VERSION_
                        },
                        {
                            _PLATFORM_LINUX_CENTOS_,
                            _SAMPLE_OVAL_D_LINUX_CENTOS_,
                            _SAMPLE_OVAL_D_LINUX_CENTOS_DEFINITION_ID_,
                            _SAMPLE_OVAL_D_LINUX_CENTOS_DEFINITION_VERSION_
                        }
        };
    }


    /**
     * Unmarshalls the OVAL definitions.
     */
    @org.testng.annotations.Test( groups={"oval.xml", "oval_definitions"},
                    dataProvider="oval-definitions",
                    alwaysRun=true
                    )
    public void unmarshalOvalDefinitions(
                    final String platform,
                    final String filepath,
                    final String ovalID,
                    final Integer ovalVersion
                    )
    throws Exception
    {
        Reporter.log( "\n// OVAL definitions: unmarshal XML", true );
        Reporter.log( "### platform: " + platform, true );
        Reporter.log( "### definition: id=" + ovalID + ", version=" + ovalVersion, true );

        File  file = new File( filepath );
        Reporter.log( "*** unmarshalling XML...: file=" + file.getAbsolutePath(), true );
        OvalDefinitions  defs = (OvalDefinitions)_xml.unmarshal(
                        new FileReader( file ) );
        Assert.assertNotNull( defs );
        Reporter.log( "@@@ #definitions: " + defs.getDefinitions().size(), true );

        if (filepath.equals( _SAMPLE_OVAL_D_LINUX_REDHAT_ )) {
            _validateOvalDefinitionsLinuxRedHat( defs );
        } else if (filepath.equals( _SAMPLE_OVAL_D_WINDOWS_ )) {
            _validateOvalDefinitionsWindows( defs );
        } else if (filepath.equals( _SAMPLE_OVAL_D_LINUX_CENTOS_ )) {
            _validateOvalDefinitionsLinuxCentOS( defs );
        } else if (filepath.equals( _SAMPLE_OVAL_D_LINUX_DEBIAN_ )) {
            _validateOvalDefinitionsLinuxDebian( defs );
        }
    }



    /**
     */
    private void _validateOvalDefinitionsLinuxDebian(
                    final OvalDefinitions defs
                    )
    throws Exception
    {
        Reporter.log( "*** checking generator...", true );
        Generator  generator = defs.getGenerator();
//        Reporter.log( "    @ generator=" + generator, true );
        Assert.assertEquals( generator.getProductName(), "Debian Security Advisary 2 OVAL definitions" );
        Assert.assertEquals( generator.getSchemaVersion(), "5.3" );

        // definitions //
        Reporter.log( "*** checking definitions...", true );
        Collection<Definition>  def_list = defs.getDefinitions();
        Assert.assertEquals( def_list.size(), 1 );
        Definition  def = def_list.iterator().next();
        Reporter.log( "@@@ definiton[0]: id=" + def.getOvalID()
                        + ", version=" + def.getOvalVersion(), true );
        Assert.assertEquals( def.getOvalID(),
                        _SAMPLE_OVAL_D_LINUX_DEBIAN_DEFINITION_ID_ );
        Assert.assertEquals( def.getOvalVersion(),
                        _SAMPLE_OVAL_D_LINUX_DEBIAN_DEFINITION_VERSION_.intValue() );
//        Assert.assertEquals( def.getDefinitionClass(), DefinitionClass.PATCH );

        Collection<String>  testIDs =
            OvalDefinitionsUtil.newInstance( defs ).getRelatedTestIDOfDefinition( def.getOvalID() );
//        Reporter.log( "    @@@ test ids in criteria =" + testIDs, true );
        Assert.assertEquals( testIDs.size(), 1 );


        // definition/metadata //
        Reporter.log( "*** checking definition/metadata/references....", true );
        Metadata  metadata = def.getMetadata();
        Assert.assertNotNull( metadata );
        Assert.assertEquals( metadata.getReference().size(), 1 );
        Reference  ref = metadata.getReference().iterator().next();
//        Reporter.log( "    @@@ reference=" + ref, true );
        Assert.assertEquals( ref.getSource(), "DSA" );
        Assert.assertEquals( ref.getRefID(), "dsa-1960" );
        Assert.assertEquals( ref.getRefURL(), "http://www.debian.org/security/2009/dsa-1960.en.html" );

        // definition/metadata/affected //
        Reporter.log( "*** checking definition/metadata/affected....", true );
        Affected  affected = metadata.getAffected();
        Assert.assertNotNull( affected );
        Assert.assertEquals( affected.getFamily(), Family.UNIX );
//        Assert.assertEquals( def.getAffected().getPlatforms().size(), 3 );
//        for (Platform  platform : def.getAffected().getPlatforms()) {
//            Assert.assertTrue( platform.getName().startsWith( "CentOS" ) );
//        }

//        Reporter.log( "*** checking metadata/advisory...", true );
//        Assert.assertEquals( def.getMetadataElements().size(), 1 );
//        MetadataElement  meta = def.getMetadataElements().iterator().next();
//        Assert.assertTrue( meta instanceof LinuxSecurityAdvisory );
//        LinuxSecurityAdvisory  adv = (LinuxSecurityAdvisory)def.getMetadataElements().iterator().next();
//        Assert.assertEquals( "secalert@redhat.com", adv.getFrom() );
//        Assert.assertEquals( Severity.MODERATE, adv.getSeverity() );

//        Assert.assertEquals( adv.getCves().size(), 1 );
//        Collection<String>  cve_ids = Arrays.asList( new String[] {
//                        "CVE-2010-0001"
//        });
//        for (CveReference  cve : adv.getCves()) {
//            Assert.assertTrue( cve_ids.contains( cve.getReferenceID() ) );
//        }

//        Reporter.log( "*** checking related CVEs...", true );
//        Collection<Cve>  cves = def.getRelatedCves();
//        Assert.assertEquals( cves.size(), 1 );
//        for (Cve  cve : cves) {
//            Assert.assertTrue( cve_ids.contains( cve.getName() ) );
//        }

//        Assert.assertEquals( def.getLastModified(), "2010-01-20" );

        Reporter.log( "*** checking tests...", true );
        Reporter.log( "@@@ #tests=" + defs.getTests().size(), true );
//        Reporter.log( "    @@@ tests=" + defs.getTests(), true );
        Assert.assertEquals( defs.getTests().size(), 1 );

        Reporter.log( "*** checking objects...", true );
        Reporter.log( "@@@ #objects=" + defs.getObjects().size(), true );
        Assert.assertEquals( defs.getObjects().size(), 1 );
    }


    /**
     */
    private void _validateOvalDefinitionsLinuxCentOS(
                    final OvalDefinitions defs
                    )
    throws Exception
    {
        Reporter.log( "*** checking generator...", true );
        Generator  generator = defs.getGenerator();
//        Reporter.log( "    @ generator=" + generator, true );
        Assert.assertEquals( generator.getProductName(), "SIX OVAL Generator" );
        Assert.assertEquals( generator.getSchemaVersion(), "5.3" );

        // definitions //
        Reporter.log( "*** checking definitions...", true );
        Collection<Definition>  def_list = defs.getDefinitions();
        Assert.assertEquals( def_list.size(), 1 );
        Definition  def = def_list.iterator().next();
        Reporter.log( "@@@ definiton[0]: id=" + def.getOvalID()
                        + ", version=" + def.getOvalVersion(), true );
        Assert.assertEquals( def.getOvalID(),
                        _SAMPLE_OVAL_D_LINUX_CENTOS_DEFINITION_ID_ );
        Assert.assertEquals( def.getOvalVersion(),
                        _SAMPLE_OVAL_D_LINUX_CENTOS_DEFINITION_VERSION_.intValue() );
        Assert.assertEquals( def.getDefinitionClass(), DefinitionClass.PATCH );

        Collection<String>  testIDs =
            OvalDefinitionsUtil.newInstance( defs ).getRelatedTestIDOfDefinition( def.getOvalID() );
//        Reporter.log( "    @@@ test ids in criteria =" + testIDs, true );
        Assert.assertEquals( testIDs.size(), 14 );


        // definition/metadata //
        Reporter.log( "*** checking definition/metadata/references....", true );
        Metadata  metadata = def.getMetadata();
        Assert.assertNotNull( metadata );
        Assert.assertEquals( metadata.getReference().size(), 1 );
        Reference  ref = metadata.getReference().iterator().next();
//        Reporter.log( "    @@@ reference=" + ref, true );
        Assert.assertEquals( ref.getSource(), "RHSA" );
        Assert.assertEquals( ref.getRefID(), "RHSA-2010:0061-00" );
        Assert.assertEquals( ref.getRefURL(), "https://rhn.redhat.com/errata/RHSA-2010-0061.html" );

        // definition/metadata/affected //
        Reporter.log( "*** checking definition/metadata/affected....", true );
        Affected  affected = metadata.getAffected();
        Assert.assertNotNull( affected );
        Assert.assertEquals( affected.getFamily(), Family.UNIX );
        Assert.assertEquals( affected.getPlatform().size(), 3 );
        for (Platform  platform : affected.getPlatform()) {
            Assert.assertTrue( platform.getName().startsWith( "CentOS" ) );
        }

        Reporter.log( "*** checking metadata/advisory...", true );
        Collection<MetadataItem>  metadataItems = def.getMetadata().getMetadataItem();
        Assert.assertEquals( metadataItems.size(), 1 );
        MetadataItem  metadataItem = metadataItems.iterator().next();
        Assert.assertTrue( metadataItem instanceof LinuxSecurityAdvisory );
        LinuxSecurityAdvisory  advisory = (LinuxSecurityAdvisory)metadataItem;
        Assert.assertEquals( "secalert@redhat.com", advisory.getFrom() );
        Assert.assertEquals( Severity.MODERATE, advisory.getSeverity() );

        Assert.assertEquals( advisory.getCve().size(), 1 );
        Collection<String>  cve_ids = Arrays.asList( new String[] {
                        "CVE-2010-0001"
        });
        for (CveReference  cve : advisory.getCve()) {
            Assert.assertTrue( cve_ids.contains( cve.getRefID() ) );
        }

        Reporter.log( "*** checking related CVEs...", true );
        Collection<Cve>  cves = def.getRelatedCves();
        Assert.assertEquals( cves.size(), 1 );
        for (Cve  cve : cves) {
            Assert.assertTrue( cve_ids.contains( cve.getName() ) );
        }

        Assert.assertEquals( def.getMetadata().getLastModifiedDate(), "2010-01-20" );

        Reporter.log( "*** checking tests...", true );
        Reporter.log( "@@@ #tests=" + defs.getTests().size(), true );
//        Reporter.log( "    @@@ tests=" + defs.getTests(), true );
        Assert.assertEquals( defs.getTests().size(), 19 );

        Reporter.log( "*** checking objects...", true );
        Reporter.log( "@@@ #objects=" + defs.getObjects().size(), true );
        Assert.assertEquals( defs.getObjects().size(), 3 );
    }


    /**
     */
    private void _validateOvalDefinitionsLinuxRedHat(
                    final OvalDefinitions defs
                    )
    throws Exception
    {
        Reporter.log( "*** checking generator...", true );
        Generator  generator = defs.getGenerator();
//        Reporter.log( "    @ generator=" + generator, true );
        Assert.assertEquals( generator.getProductName(), "Red Hat Errata System" );
        Assert.assertEquals( generator.getSchemaVersion(), "5.3" );

        // definitions //
        Reporter.log( "*** checking definitions...", true );
        Collection<Definition>  def_list = defs.getDefinitions();
        Assert.assertEquals( def_list.size(), 1 );
        Definition  def = def_list.iterator().next();
        Reporter.log( "@@@ definiton[0]: id=" + def.getOvalID()
                        + ", version=" + def.getOvalVersion(), true );
        Assert.assertEquals( def.getOvalID(),
                        _SAMPLE_OVAL_D_LINUX_REDHAT_DEFINITION_ID_ );
        Assert.assertEquals( def.getOvalVersion(),
                        _SAMPLE_OVAL_D_LINUX_REDHAT_DEFINITION_VERSION_.intValue() );
        Assert.assertEquals( def.getDefinitionClass(), DefinitionClass.PATCH );

        Collection<String>  testIDs =
            OvalDefinitionsUtil.newInstance( defs ).getRelatedTestIDOfDefinition( def.getOvalID() );
//        Reporter.log( "    @@@ test ids in criteria =" + testIDs, true );
        Assert.assertEquals( testIDs.size(), 8 );


        // definition/metadata //
        Reporter.log( "*** checking definition/metadata/references....", true );
        Metadata  metadata = def.getMetadata();
        Assert.assertNotNull( metadata );
        Assert.assertEquals( metadata.getReference().size(), 1 );
        Reference  ref = metadata.getReference().iterator().next();
//        Reporter.log( "    @@@ reference=" + ref, true );
        Assert.assertEquals( ref.getSource(), "RHSA" );
        Assert.assertEquals( ref.getRefID(), "RHSA-2010:0061-00" );
        Assert.assertEquals( ref.getRefURL(), "https://rhn.redhat.com/errata/RHSA-2010-0061.html" );

        // definition/metadata/affected //
        Reporter.log( "*** checking definition/metadata/affected....", true );
        Affected  affected = metadata.getAffected();
        Assert.assertNotNull( affected );
        Assert.assertEquals( affected.getFamily(), Family.UNIX );
        Assert.assertEquals( affected.getPlatform().size(), 3 );
        for (Platform  platform : affected.getPlatform()) {
            Assert.assertTrue( platform.getName().startsWith( "Red Hat Enterprise Linux" ) );
        }

        Reporter.log( "*** checking metadata/advisory...", true );
        Collection<MetadataItem>  metadataItems = def.getMetadata().getMetadataItem();
        Assert.assertEquals( metadataItems.size(), 1 );
        MetadataItem  metadataItem = metadataItems.iterator().next();
        Assert.assertTrue( metadataItem instanceof LinuxSecurityAdvisory );
        LinuxSecurityAdvisory  advisory = (LinuxSecurityAdvisory)metadataItem;
        Assert.assertEquals( "secalert@redhat.com", advisory.getFrom() );
        Assert.assertEquals( Severity.MODERATE, advisory.getSeverity() );

        Assert.assertEquals( advisory.getCve().size(), 1 );
        Collection<String>  cve_ids = Arrays.asList( new String[] {
                        "CVE-2010-0001"
        });
        for (CveReference  cve : advisory.getCve()) {
            Assert.assertTrue( cve_ids.contains( cve.getRefID() ) );
        }

//        Assert.assertEquals( 1, adv.getAffectedCpes().size() );
//        Cpe  cpe = adv.getAffectedCpes().iterator().next();
//        Assert.assertEquals( "cpe:/o:redhat:enterprise_linux", cpe.getName() );

        Reporter.log( "*** checking related CVEs...", true );
        Collection<Cve>  cves = def.getRelatedCves();
        Assert.assertEquals( cves.size(), 1 );
        for (Cve  cve : cves) {
            Assert.assertTrue( cve_ids.contains( cve.getName() ) );
        }

        Assert.assertEquals( def.getMetadata().getLastModifiedDate(), "2010-01-20" );

        Reporter.log( "*** checking tests...", true );
        Reporter.log( "@@@ #tests=" + defs.getTests().size(), true );
//        Reporter.log( "    @@@ tests=" + defs.getTests(), true );
        Assert.assertEquals( defs.getTests().size(), 8 );

        Reporter.log( "*** checking objects...", true );
        Reporter.log( "@@@ #objects=" + defs.getObjects().size(), true );
        Assert.assertEquals( defs.getObjects().size(), 2 );
//        Collection<String>  object_names = Arrays.asList( new String[] {
//                        "httpd-manual", "httpd-devel", "redhat-release", "mod_ssl", "httpd"
//        });
//        for (SystemObject object : defs.getObjects()) {
//            Assert.assertTrue( object instanceof RpmInfoObject );
//            RpmInfoObject  rpminfo = (RpmInfoObject)object;
//            Assert.assertTrue( object_names.contains( rpminfo.getName() ) );
//        }
    }



    /**
     */
    private void _validateOvalDefinitionsWindows(
                    final OvalDefinitions defs
                    )
    throws Exception
    {
        // generator //
        Generator  generator = defs.getGenerator();
        Reporter.log( "  *** checking generator...", true );
        Assert.assertEquals( generator.getProductName(), "The OVAL Repository" );
        Assert.assertEquals( generator.getSchemaVersion(), "5.6" );


        // definitions //
        Reporter.log( "  *** checking definitions...", true );
        Collection<Definition>  def_list = defs.getDefinitions();
        Assert.assertEquals( def_list.size(), 1 );
        Definition  def = def_list.iterator().next();
        Reporter.log( "    @@@ definiton id=" + def.getOvalID(), true );
        Assert.assertEquals( def.getOvalID(),
                        _SAMPLE_OVAL_D_WINDOWS_DEFINITION_ID_ );
        Assert.assertEquals( def.getOvalVersion(),
                        _SAMPLE_OVAL_D_WINDOWS_DEFINITION_VERSION_.intValue() );
        Assert.assertEquals( def.getDefinitionClass(), DefinitionClass.VULNERABILITY );

        Collection<String>  testIDs =
            OvalDefinitionsUtil.newInstance( defs ).getRelatedTestIDOfDefinition( def.getOvalID() );
//        Reporter.log( "    @@@ test ids in criteria =" + testIDs, true );
        // test: {2339, 2747, 2748, 2838(twice), 2843, 3019}
        Assert.assertEquals( testIDs.size(), 6 );


        // definition/metadata //
        Reporter.log( "  *** checking definition/metadata/references....", true );
        Metadata  metadata = def.getMetadata();
        Assert.assertNotNull( metadata );
        Assert.assertEquals( metadata.getReference().size(), 1 );
        Reference  ref = metadata.getReference().iterator().next();
        Assert.assertEquals( ref.getSource(), "CVE" );
        Assert.assertEquals( ref.getRefID(), "CVE-2006-1189" );
        Assert.assertEquals( ref.getRefURL(), "http://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2006-1189" );

        // definition/metadata/affected //
        Reporter.log( "  *** checking definition/metadata/affected....", true );
        Affected  affected = metadata.getAffected();
        Assert.assertNotNull( affected );
        Assert.assertEquals( affected.getFamily(), Family.WINDOWS );
        Assert.assertEquals( affected.getPlatform().size(), 1 );
        Platform  platform = affected.getPlatform().iterator().next();
        Assert.assertEquals( platform.getName(), "Microsoft Windows XP" );
        Assert.assertEquals( affected.getProduct().size(), 1 );
        Product  product = affected.getProduct().iterator().next();
        Assert.assertEquals( product.getName(), "Microsoft Internet Explorer" );


//        Assert.assertEquals( def.getTitle(), "IE6 Double Byte Character Parsing Memory Corruption (WinXP)" );
//        Assert.assertEquals( def.getAffectedFamily(), Family.WINDOWS );
//        Assert.assertEquals( def.getAffectedPlatforms().size(), 1 );
//        Platform  platform = def.getAffectedPlatforms().iterator().next();
//        Assert.assertEquals( platform.getName(), "Microsoft Windows XP" );
//        Assert.assertEquals( def.getAffectedProducts().size(), 1 );
//        Product  product = def.getAffectedProducts().iterator().next();
//        Assert.assertEquals( product.getName(), "Microsoft Internet Explorer" );

        Reporter.log( "  *** checking definition/metadata...", true );
        Collection<MetadataItem>  metadataItems = def.getMetadata().getMetadataItem();
        Assert.assertEquals( metadataItems.size(), 1 );
        MetadataItem  metadataItem = metadataItems.iterator().next();
        Assert.assertTrue( metadataItem instanceof MitreRepositoryMetadataItem );
        MitreRepositoryMetadataItem  repo = (MitreRepositoryMetadataItem)metadataItem;
        Assert.assertEquals( repo.getDates().size(), 7 );
        for (OvalRepositoryEvent  event : repo.getDates()) {
            if (event instanceof DefinitionModifiedEvent) {
                Calendar  cal = Calendar.getInstance();
                cal.setTime( event.getDate() );
                Assert.assertEquals( cal.get( Calendar.YEAR ), 2009 );
                Assert.assertEquals( cal.get( Calendar.MONTH ), 5 - 1 ); //the 1st month is 0
                Assert.assertEquals( cal.get( Calendar.DAY_OF_MONTH ), 7 );
            }
        }

        Assert.assertEquals( def.getMetadata().getLastModifiedDate(), "2009-05-07" );


        Reporter.log( "  *** checking related CVEs...", true );
        Collection<Cve>  cves = def.getRelatedCves();
        Assert.assertEquals( cves.size(), 1 );
        Collection<String>  cve_ids = Arrays.asList( new String[] {
                        "CVE-2006-1189"
        });
        for (Cve  cve : cves) {
            Assert.assertTrue( cve_ids.contains( cve.getName() ) );
        }

        Reporter.log( "  *** checking tests...", true );
        Reporter.log( "    @@@ #tests=" + defs.getTests().size(), true );
//        Reporter.log( "    @@@ tests=" + defs.getTests(), true );
        Assert.assertEquals( defs.getTests().size(), 6 );

        Reporter.log( "  *** checking #objects...", true );
        Reporter.log( "    @@@ #objects=" + defs.getObjects().size(), true );
        Assert.assertEquals( defs.getObjects().size(), 5 );

//        for (SystemObject object : defs.getObjects()) {
//            if (object.getOvalID().equals( "oval:org.mitre.oval:obj:419" )) {
//                Assert.assertTrue( object instanceof RegistryObject );
//                RegistryObject  reg = (RegistryObject)object;
//                Assert.assertEquals( reg.getComment(), "This registry key holds the version of the installed operating system." );
//                Assert.assertEquals( reg.getHive(), RegistryHive.HKEY_LOCAL_MACHINE );
//                Assert.assertEquals( reg.getKey().getValue(), "SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion" );
//                Assert.assertEquals( reg.getName().getValue(), "CurrentVersion" );
//            } else if (object.getOvalID().equals( "oval:org.mitre.oval:obj:222" )) {
//                Assert.assertTrue( object instanceof FileObject );
//                FileObject  file = (FileObject)object;
//                Assert.assertEquals( file.getComment(), "The path to the mshtml.dll file in the system root" );
//                Assert.assertEquals( file.getPath().getVariableReference(), "oval:org.mitre.oval:var:200" );
//                Assert.assertEquals( file.getPath().getVariableCheck(), Check.ALL );
//                Assert.assertEquals( file.getFilename().getValue(), "mshtml.dll" );
//            }
//        }
    }

}
// OvalXmlTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

