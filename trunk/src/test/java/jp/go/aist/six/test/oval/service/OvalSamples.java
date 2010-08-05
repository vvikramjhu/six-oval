package jp.go.aist.six.test.oval.service;

import jp.go.aist.six.oval.model.common.Family;
import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.definitions.Affected;
import jp.go.aist.six.oval.model.definitions.Cpe;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.DefinitionClass;
import jp.go.aist.six.oval.model.definitions.Metadata;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.Platform;
import jp.go.aist.six.oval.model.definitions.Product;
import jp.go.aist.six.oval.model.definitions.Reference;
import jp.go.aist.six.oval.model.linux.BugzillaReference;
import jp.go.aist.six.oval.model.linux.CveReference;
import jp.go.aist.six.oval.model.linux.LinuxSecurityAdvisory;
import jp.go.aist.six.oval.model.linux.Severity;
import java.util.Arrays;
import java.util.Date;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalSamples.java 677 2010-04-24 08:06:29Z akihito $
 */
public class OvalSamples
{

    //**************************************************************
    //  OVAL Definitions
    //**************************************************************

    //==============================================================
    //  Definition (1)
    //==============================================================

    public static final String  DEFINITION_1_ID =
        "oval:jp.go.aist.six:def:20090001";


    public static final int  DEFINITION_1_VERSION = 100;


    public static final String  DEFINITION_1_TITLE =
        "Foo stack overflow vulnerability";


    public static final String  DEFINITION_1_DESCRIPTION =
        "The Foo program is ...";


    public static final Platform[]  DEFINITION_1_PLATFORMS = new Platform[] {
        new Platform( "SIX Enterprise Linux 5" ),
        new Platform( "SIX Enterprise Linux 6" )
    };


    public static final Product[]  DEFINITION_1_PRODUCTS = new Product[] {
        new Product( "SIX Foo App" ),
        new Product( "SIX Bar App" )
    };


    // metadata //

    public static final Reference[]  DEFINITION_1_REFERENCES = new Reference[] {
        new Reference( "SIX", "SIX-SA-0001", "https://six.aist.go.jp/six/SIX-SA-0001" ),
        new Reference( "SIX", "SIX-SA-0002", "https://six.aist.go.jp/six/SIX-SA-0002" ),
        new Reference( "SIX", "SIX-SA-0003", "https://six.aist.go.jp/six/SIX-SA-0003" )
    };


    public static final CveReference[]  DEFINITION_1_CVES = new CveReference[] {
        new CveReference( "CVE-2009-1890",
                        "http://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2009-1890"),
        new CveReference( "CVE-2009-1891",
                        "http://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2009-1891")
    };


    public static final BugzillaReference[]  DEFINITION_1_BUGZILLAS = new BugzillaReference[] {
        new BugzillaReference( "509125",
                        "http://bugzilla.redhat.com/509125",
                        "CVE-2009-1891 httpd: possible temporary DoS (CPU consumption) in mod_deflate" ),
        new BugzillaReference( "509375",
                        "http://bugzilla.redhat.com/509375",
                        "CVE-2009-1890 httpd: mod_proxy reverse proxy DoS (infinite loop)" )
    };


    public static final Cpe[]  DEFINITION_1_CPES = new Cpe[] {
        new Cpe( "cpe:/o:redhat:enterprise_linux" )
    };


    public static final LinuxSecurityAdvisory  ADVISORY_1 =
        new LinuxSecurityAdvisory( "secalert@six.com", "Copyright 2009 AIST",
                        Severity.IMPORTANT, "2009-07-09", "2009-07-10",
                        Arrays.asList( DEFINITION_1_CVES ),
                        Arrays.asList( DEFINITION_1_BUGZILLAS ),
                        Arrays.asList( DEFINITION_1_CPES ) );



    /**
     * Definition (1)
     */
    public static final Definition  DEFINITION_1 =
        _createDefinition1();


    private static Definition _createDefinition1()
    {
        Definition  def =
            new Definition( DEFINITION_1_ID, DEFINITION_1_VERSION,
                            DefinitionClass.VULNERABILITY );


        // metadata //
        Metadata  metadata = new Metadata();

        metadata.setTitle( DEFINITION_1_TITLE );
        metadata.setDescription( DEFINITION_1_DESCRIPTION );

        Affected  affected = new Affected();
        affected.setFamily( Family.UNIX );
        for (Platform  platform : DEFINITION_1_PLATFORMS) {
            affected.addPlatform( platform );
        }
        for (Product  product : DEFINITION_1_PRODUCTS) {
            affected.addProduct( product );
        }
        metadata.setAffected( affected );

        for (Reference  ref : DEFINITION_1_REFERENCES) {
            metadata.addReference( ref );
        }

        // RedHat advisory //
        metadata.addMetadataItem( ADVISORY_1 );

        def.setMetadata( metadata );

        return def;
    }


    //==============================================================
    //  OvalDefinitions (1)
    //==============================================================

    public static final Generator  GENERATOR_1 =
        new Generator( "5.6", new Date(), "SIX generator", "1.0" );


    public static final OvalDefinitions  OVAL_DEFINITIONS_1 =
        _createOvalDefinitions1();


    /**
     * OvalDefinitions (1)
     */
    private static OvalDefinitions _createOvalDefinitions1()
    {
        OvalDefinitions  defs = new OvalDefinitions( GENERATOR_1 );
        defs.getDefinitions().add( DEFINITION_1 );

        return defs;
    }




//    //**************************************************************
//    //  OvalSystemCharacteristics (Windows)
//    //**************************************************************
//
//
//    public static final ObjectResult OBJECT_RESULT_WINDOWS_1 =
//        new ObjectResult(
//                        "oval:org.mitre.oval:obj:1000",
//                        2,
//                        ObjectFlag.COMPLETE,
//                        Arrays.asList( new ItemReference[] {
//                                        new ItemReference( 300 )
//                        })
//        );
//
//    public static final Item  ITEM_WINDOWS_300 =
//        new FileItem(
//                        300,
//                        ItemStatus.EXISTS,
//                        "C:\\WINDOWS\\msagent",
//                        "agentdpv.dll",
//                        "Administrators",
//                        "Microsoft Corporation",
//                        "Microsoft Agent Data Provider",
//                        "2.00.0.3427"
//        );
//
//
//    public static final ObjectResult OBJECT_RESULT_WINDOWS_2 =
//        new ObjectResult(
//                        "oval:org.mitre.oval:obj:1608",
//                        1,
//                        ObjectFlag.COMPLETE,
//                        Arrays.asList( new ItemReference[] {
//                                        new ItemReference( 652 ),
//                                        new ItemReference( 653 ),
//                                        new ItemReference( 654 ),
//                                        new ItemReference( 655 ),
//                                        new ItemReference( 656 )
//                        })
//        );
//
//    public static final Item  ITEM_WINDOWS_652 =
//        new RegistryItem(
//                        652,
//                        ItemStatus.EXISTS,
//                        RegistryHive.HKEY_LOCAL_MACHINE,
//                        "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\4",
//                        "1400",
//                        "3",
//                        RegistryType.REG_DWORD
//        );
//
//    public static final Item  ITEM_WINDOWS_653 =
//        new RegistryItem(
//                        653,
//                        ItemStatus.EXISTS,
//                        RegistryHive.HKEY_LOCAL_MACHINE,
//                        "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\3",
//                        "1400",
//                        "0",
//                        RegistryType.REG_DWORD
//        );
//
//    public static final Item  ITEM_WINDOWS_654 =
//        new RegistryItem(
//                        654,
//                        ItemStatus.EXISTS,
//                        RegistryHive.HKEY_LOCAL_MACHINE,
//                        "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2",
//                        "1400",
//                        "0",
//                        RegistryType.REG_DWORD
//        );
//
//    public static final Item  ITEM_WINDOWS_655 =
//        new RegistryItem(
//                        655,
//                        ItemStatus.EXISTS,
//                        RegistryHive.HKEY_LOCAL_MACHINE,
//                        "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\1",
//                        "1400",
//                        "0",
//                        RegistryType.REG_DWORD
//        );
//
//    public static final Item  ITEM_WINDOWS_656 =
//        new RegistryItem(
//                        656,
//                        ItemStatus.EXISTS,
//                        RegistryHive.HKEY_LOCAL_MACHINE,
//                        "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\0",
//                        "1400",
//                        "0",
//                        RegistryType.REG_DWORD
//        );
//
//
//
//    private static final OvalSystemCharacteristics _OVAL_SC_WINDOWS_1_ =
//        new OvalSystemCharacteristics(
//                        new Generator(
//                                        "OVAL Definition Interpreter",
//                                        "5.5 Build: 4",
//                                        "5.5",
//                                        IsoDate.datetimeValueOf( "2009-05-11T14:53:35" )
//                        ),
//                        new SystemInfo(
//                                        "Microsoft Windows XP Professional Service Pack 3",
//                                        "5.1.2600",
//                                        "INTEL32",
//                                        "d4b76bb5.six.aist.go.jp",
//                                        Arrays.asList( new Interface[] {
//                                                        new Interface(
//                                                                        "AMD PCNET Family PCI Ethernet Adapter",
//                                                                        "192.168.1.110",
//                                                                        "00-0C-29-6E-89-BC"
//                                                        )
//                                        })
//                        )
//        );
//
//
//
//    public static final OvalSystemCharacteristics OVAL_SC_WINDOWS_1 =
//        _createSystemCharacteristicsWindows1();
//
//
//    private static final OvalSystemCharacteristics _createSystemCharacteristicsWindows1()
//    {
//        OvalSystemCharacteristics  sc = _OVAL_SC_WINDOWS_1_;
//        sc.addCollectedObject( OBJECT_RESULT_WINDOWS_1 );
//        sc.addCollectedObject( OBJECT_RESULT_WINDOWS_2 );
//
//        sc.addCollectedItem( ITEM_WINDOWS_300 );
//        sc.addCollectedItem( ITEM_WINDOWS_652 );
//        sc.addCollectedItem( ITEM_WINDOWS_653 );
//        sc.addCollectedItem( ITEM_WINDOWS_654 );
//        sc.addCollectedItem( ITEM_WINDOWS_655 );
//        sc.addCollectedItem( ITEM_WINDOWS_656 );
//
//        return sc;
//    }
//
//
//
//    //**************************************************************
//    //  OvalSystemCharacteristics (Linux/RPM)
//    //**************************************************************
//
//    public static final ObjectResult OBJECT_RESULT_LINUX_1 =
//        new ObjectResult(
//                        "oval:com.redhat.rhsa:obj:20091148001",
//                        301,
//                        ObjectFlag.COMPLETE,
//                        Arrays.asList( new ItemReference[] {
//                                        new ItemReference( 3 )
//                        })
//        );
//
//
//    public static final ObjectResult OBJECT_RESULT_LINUX_2 =
//        new ObjectResult(
//                        "oval:com.redhat.rhsa:obj:20091148002",
//                        301,
//                        ObjectFlag.COMPLETE,
//                        Arrays.asList( new ItemReference[] {
//                                        new ItemReference( 5 )
//                        })
//        );
//
//
//    public static final ObjectResult OBJECT_RESULT_LINUX_3 =
//        new ObjectResult(
//                        "oval:com.redhat.rhsa:obj:20091148003",
//                        301,
//                        ObjectFlag.COMPLETE,
//                        Arrays.asList( new ItemReference[] {
//                                        new ItemReference( 1 )
//                        })
//        );
//
//
//    public static final ObjectResult OBJECT_RESULT_LINUX_4 =
//        new ObjectResult(
//                        "oval:com.redhat.rhsa:obj:20091148004",
//                        301,
//                        ObjectFlag.COMPLETE,
//                        Arrays.asList( new ItemReference[] {
//                                        new ItemReference( 4 )
//                        })
//        );
//
//
//    public static final ObjectResult OBJECT_RESULT_LINUX_5 =
//        new ObjectResult(
//                        "oval:com.redhat.rhsa:obj:20091148005",
//                        301,
//                        ObjectFlag.DOES_NOT_EXIST,
//                        Arrays.asList( new ItemReference[] {
//                                        new ItemReference( 2 )
//                        })
//        );
//
//
//
//    //  system.Item - sc/system_data/item (Linux)
//
//    public static final Item  ITEM_LINUX_3 =
//        new RpmInfoItem(
//                        3,
//                        "centos-release",
//                        "i386",
//                        "10",
//                        "3.el5.centos.1",
//                        "5",
//                        "10:5-3.el5.centos.1",
//                        "a8a447dce8562897"
//        );
//
//    public static final Item  ITEM_LINUX_5 =
//        new RpmInfoItem(
//                        5,
//                        "httpd",
//                        "i386",
//                        "(none)",
//                        "22.el5.centos.1",
//                        "2.2.3",
//                        "0:2.2.3-22.el5.centos.1",
//                        "a8a447dce8562897"
//        );
//
//    public static final Item  ITEM_LINUX_1 =
//        new RpmInfoItem(
//                        1,
//                        "httpd-manual",
//                        "i386",
//                        "(none)",
//                        "22.el5.centos.1",
//                        "2.2.3",
//                        "0:2.2.3-22.el5.centos.1",
//                        "a8a447dce8562897"
//        );
//
//    public static final Item  ITEM_LINUX_4 =
//        new RpmInfoItem(
//                        4,
//                        "mod_ssl",
//                        "i386",
//                        "1",
//                        "22.el5.centos.1",
//                        "2.2.3",
//                        "1:2.2.3-22.el5.centos.1",
//                        "a8a447dce8562897"
//        );
//
//    public static final Item  ITEM_LINUX_2 =
//        new RpmInfoItem(
//                        2,
//                        ItemStatus.DOES_NOT_EXIST,
//                        "httpd-devel"
//        );
//
//
//
//    private static final OvalSystemCharacteristics _OVAL_SC_1_ =
//        new OvalSystemCharacteristics(
//                        new Generator(
//                                        "OVAL Definition Interpreter",
//                                        "5.5 Build: 4",
//                                        "5.5",
//                                        IsoDate.datetimeValueOf( "2009-07-10T12:49:07" )
//                        ),
//                        new SystemInfo(
//                                        "Linux",
//                                        "#1 SMP Wed Jun 17 06:40:54 EDT 2009",
//                                        "i686",
//                                        "dhcp1234.six.aist.go.jp",
//                                        Arrays.asList( new Interface[] {
//                                                        new Interface(
//                                                                        "eth0",
//                                                                        "192.168.1.3",
//                                                                        "AA.BB.CC.DD.EE.FF"
//                                                        )
//                                        })
//                        )
//        );
//
//
//    private static final OvalSystemCharacteristics _createSystemCharacteristicsLinux1()
//    {
//        OvalSystemCharacteristics  sc = _OVAL_SC_1_;
//        sc.addCollectedObject( OBJECT_RESULT_LINUX_1 );
//        sc.addCollectedObject( OBJECT_RESULT_LINUX_2 );
//        sc.addCollectedObject( OBJECT_RESULT_LINUX_3 );
//        sc.addCollectedObject( OBJECT_RESULT_LINUX_4 );
//        sc.addCollectedObject( OBJECT_RESULT_LINUX_5 );
//
//        sc.addCollectedItem( ITEM_LINUX_3 );
//        sc.addCollectedItem( ITEM_LINUX_5 );
//        sc.addCollectedItem( ITEM_LINUX_1 );
//        sc.addCollectedItem( ITEM_LINUX_4 );
//        sc.addCollectedItem( ITEM_LINUX_2 );
//
//        return sc;
//    }
//
//
//
//    public static final OvalSystemCharacteristics OVAL_SC_1 =
//        _createSystemCharacteristicsLinux1();
//
//
//    public static final OvalSystemCharacteristics OVAL_SC_2 =
//        new OvalSystemCharacteristics(
//                        new Generator(
//                                        "OVAL Definition Interpreter",
//                                        "5.5 Build: 4",
//                                        "5.5",
//                                        IsoDate.datetimeValueOf( "2009-11-10T12:49:07" )
//                        ),
//                        new SystemInfo(
//                                        "Linux",
//                                        "#1 SMP Wed Jun 17 06:40:54 EDT 2009",
//                                        "i686",
//                                        "dhcp9876.six.aist.go.jp",
//                                        Arrays.asList( new Interface[] {
//                                                        new Interface(
//                                                                        "eth0",
//                                                                        "192.168.1.5",
//                                                                        "DD.EE.FF.AA.BB.CC"
//                                                        ),
//                                                        new Interface(
//                                                                        "eth1",
//                                                                        "192.168.2.5",
//                                                                        "EE.FF.AA.BB.CC.DD"
//                                                        )
//                                        })
//                        )
//        );
//
//
//    //==============================================================
//    //  system.ObjectResult - sc/collected_objects/object
//    //==============================================================
//
//    public static final ObjectResult[]  OBJECT_RESULTS_1 = new ObjectResult[] {
//        new ObjectResult(
//                        "oval:com.redhat.rhsa:obj:20091148001",
//                        301,
//                        ObjectFlag.COMPLETE
//        ),
//        new ObjectResult(
//                        "oval:com.redhat.rhsa:obj:20091148002",
//                        301,
//                        ObjectFlag.COMPLETE
//        )
//    };
//
//
//
//    //==============================================================
//    //  Linux objects - RpmInfoObject
//    //==============================================================
//
//    public static final RpmInfoObject  OBJECT_RPMINFO_1 =
//        new RpmInfoObject( "oval:jp.go.aist.six:obj:0001", 101, "six1rpm" );
//
//    public static final RpmInfoObject  OBJECT_RPMINFO_2 =
//        new RpmInfoObject( "oval:jp.go.aist.six:obj:0002", 102, "six2rpm" );
//
//
//
//    //==============================================================
//    //  Windows objects - FileObject, RegistryObject
//    //==============================================================
//
//    public static final FileObject  OBJECT_FILE_1 =
//        new FileObject( "oval:jp.go.aist.six:obj:0011", 111,
//                        "C:\\windows\\system32", "six.exe" );
//
//
//    public static final RegistryObject  OBJECT_REGISTRY_1 =
//        new RegistryObject( "oval:jp.go.aist.six:obj:0021", 121,
//                        RegistryHive.HKEY_LOCAL_MACHINE,
//                        "SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion",
//                        "CurrentVersion" );
//
//
//
//    //==============================================================
//    //  Definition (RedHat)
//    //==============================================================
//
//    public static final Definition  DEFINITION_REDHAT_2 =
//        _createRedHatDefinition2();
//
//
//    public static final String DEFINITION_ID_REDHAT_2 =
//        "oval:jp.go.aist.six:def:20090018";
//
//
//    public static final Object[] DEFINITION_ID_VERSION_REDHAT_2 =
//        new Object[] { DEFINITION_ID_REDHAT_2, 302 };
//
//
//    public static final String  PLATFORM_REDHAT_2 =
//        "SIX Enterprise Linux 3";
//
//
//    public static final Object[] DEFINITION_PLATFORM_REDHAT_2 =
//        new String[] { DEFINITION_ID_REDHAT_2, PLATFORM_REDHAT_2 };
//
//
//    /**
//     * A sample OVAL definition of Red Hat Enterprise Linux.
//     * The 'id' of this definition is a fiction:
//     * the original 'id' is 'oval:com.redhat.rhsa:def:20090018'.
//     */
//    private static Definition _createRedHatDefinition2()
//    {
//        Definition  def =
//            new Definition( DEFINITION_ID_REDHAT_2, 302,
//                        DefinitionClass.PATCH );
//
//        // metadata
//        def.setTitle( "RHSA-2009:0018: xterm security update (Important)" );
//        def.setDescription( "The xterm program is ..." );
//        def.setAffectedFamily( Family.UNIX );
//        def.addAffectedPlatform( new Platform( "Red Hat Enterprise Linux 3" ) );
//        def.addAffectedPlatform( new Platform( "Red Hat Enterprise Linux 4" ) );
//        def.addAffectedPlatform( new Platform( "Red Hat Enterprise Linux 5" ) );
//        def.addAffectedPlatform( new Platform( PLATFORM_REDHAT_2 ) );
//        def.addReference( new Reference( "RHSA", "RHSA-2009:0018-01",
//                        "https://rhn.redhat.com/errata/RHSA-2009-0018.html" ) );
//
//        // RedHat advisory
//        Advisory  adv = new Advisory();
//        adv.setFrom( "secalert@redhat.com" );
//        adv.setSeverity( Severity.IMPORTANT );
//        adv.setRights( "Copyright 2009 Red Hat, Inc." );
//        adv.setIssued( IsoDate.dateValueOf( "2009-01-01" ) );
//        adv.setUpdated( IsoDate.dateValueOf( "2009-01-02" ) );
//        adv.addCve( new CveReference( "CVE-2008-2383",
//                        "http://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2008-2383" ) );
//        adv.addBugzilla( new Bugzilla( "478888", "http://bugzilla.redhat.com/478888",
//                        "CVE-2008-2383 xterm: arbitrary command injection" ) );
//        adv.addAffectedCpe( new Cpe( "cpe:/o:redhat:enterprise_linux" ) );
//        def.addAnyMetadata( adv );
//
//        return def;
//    }
//
//
//
//    public static final Definition  DEFINITION_REDHAT_1 =
//        _createRedHatDefinition1();
//
//
//    public static final String DEFINITION_ID_REDHAT_1 =
//        "oval:jp.go.aist.six:def:20090018";
//
//    public static final Object[] DEFINITION_ID_VERSION_REDHAT_1 =
//        new Object[] { DEFINITION_ID_REDHAT_1, 301 };
//
//
//    /**
//     * An older version of the above definition.
//     * @return
//     */
//    private static Definition _createRedHatDefinition1()
//    {
//        Definition  def =
//            new Definition( DEFINITION_ID_REDHAT_1, 301,
//                        DefinitionClass.PATCH );
//
//        // metadata
//        def.setTitle( "OLD RHSA-2009:0018: xterm security update (Important)" );
//        def.setDescription( "The xterm program is ..." );
//        def.setAffectedFamily( Family.UNIX );
//        def.addAffectedPlatform( new Platform( "Red Hat Enterprise Linux 3" ) );
//        def.addAffectedPlatform( new Platform( "Red Hat Enterprise Linux 4" ) );
//        def.addAffectedPlatform( new Platform( "Red Hat Enterprise Linux 5" ) );
//        def.addAffectedPlatform( new Platform( PLATFORM_REDHAT_2 ) );
//        def.addReference( new Reference( "RHSA", "RHSA-2009:0018-01",
//                        "https://rhn.redhat.com/errata/RHSA-2009-0018.html" ) );
//
//        // RedHat advisory
//        Advisory  adv = new Advisory();
//        adv.setFrom( "secalert@redhat.com" );
//        adv.setSeverity( Severity.IMPORTANT );
//        adv.setRights( "Copyright 2009 Red Hat, Inc." );
//        adv.setIssued( IsoDate.dateValueOf( "2009-01-01" ) );
//        adv.setUpdated( IsoDate.dateValueOf( "2009-01-02" ) );
//        adv.addCve( new CveReference( "CVE-2008-2383",
//                        "http://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2008-2383" ) );
//        adv.addBugzilla( new Bugzilla( "478888", "http://bugzilla.redhat.com/478888",
//                        "CVE-2008-2383 xterm: arbitrary command injection" ) );
//        adv.addAffectedCpe( new Cpe( "cpe:/o:redhat:enterprise_linux" ) );
//        def.addAnyMetadata( adv );
//
//        return def;
//    }
//
//
//
//    //==============================================================
//    //  Definition (Windows)
//    //==============================================================
//
//    public static final Definition  DEFINITION_WINDOWS_1 =
//        _createWindowsDefinition1();
//
//
//    public static final String DEFINITION_ID_WINDOWS_1 =
//        "oval:jp.go.aist.six:def:5942";
//
//    public static final Object[] DEFINITION_ID_VERSION_WINDOWS_1 =
//        new Object[] { DEFINITION_ID_WINDOWS_1, 1 };
//
//
//    public static final String PRODUCT_WINDOWS_1 =
//        "SIX Media Server 100";
//
//
//    public static final Object[] DEFINITION_PRODUCT_WINDOWS_1 =
//        new String[] { DEFINITION_ID_WINDOWS_1, PRODUCT_WINDOWS_1 };
//
//
//    /**
//     * A sample OVAL definition of Red Hat Enterprise Linux.
//     * The 'id' of this definition is a fiction:
//     * the original 'id' is 'oval:org.mitre.oval:def:5942'.
//     */
//    private static Definition _createWindowsDefinition1()
//    {
//        Definition  def =
//            new Definition( DEFINITION_ID_WINDOWS_1, 1,
//                            DefinitionClass.VULNERABILITY );
//
//        // metadata //
//        def.setTitle( "SPN Vulnerability" );
//        def.setDescription( "Microsoft Windows Media Player 6.4, ..." );
//        def.setAffectedFamily( Family.WINDOWS );
//
//        def.addAffectedPlatform( new Platform( "Microsoft Windows 2000" ) );
//        def.addAffectedPlatform( new Platform( "Microsoft Windows XP" ) );
//        def.addAffectedPlatform( new Platform( "Microsoft Windows Server 2003" ) );
//        def.addAffectedPlatform( new Platform( "Microsoft Windows Vista" ) );
//        def.addAffectedPlatform( new Platform( "Microsoft Windows Server 2008" ) );
//
//        def.addAffectedProduct( new Product( "Windows Media Server 4.1" ) );
//        def.addAffectedProduct( new Product( "Windows Media Server 9" ) );
//        def.addAffectedProduct( new Product( "Windows Media Format Runtime 7.1" ) );
//        def.addAffectedProduct( new Product( "Windows Media Format Runtime 9.5" ) );
//        def.addAffectedProduct( new Product( "Windows Media Format Runtime 11" ) );
//        def.addAffectedProduct( new Product( PRODUCT_WINDOWS_1 ) );
//
//        def.addReference( new Reference( "CVE", "CVE-2008-3009",
//                        "http://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2008-3009" ) );
//
//        // oval_repository //
//        OvalRepository  repo = new OvalRepository();
//        repo.addEvent( new DefinitionSubmittedEvent(
//                        IsoDate.datetimeValueOf( "2008-12-10T10:44:00" ) ) );
//        repo.addEvent( new DefinitionStatusChangeEvent(
//                        IsoDate.datetimeValueOf( "2008-12-12T16:42:41.693-05:00" ),
//                        DefinitionStatus.DRAFT ) );
//        repo.addEvent( new DefinitionStatusChangeEvent(
//                        IsoDate.datetimeValueOf( "2008-12-29T04:00:32.351-05:00" ),
//                        DefinitionStatus.INTERIM ) );
//        repo.addEvent( new DefinitionStatusChangeEvent(
//                        IsoDate.datetimeValueOf( "2009-01-19T04:00:14.339-05:00" ),
//                        DefinitionStatus.ACCEPTED ) );
//        repo.addEvent( new DefinitionModifiedEvent(
//                        IsoDate.datetimeValueOf( "2009-05-07T10:34:00.056-04:00" ) ) );
//        repo.addEvent( new DefinitionStatusChangeEvent(
//                        IsoDate.datetimeValueOf( "2009-05-07T10:36:28.062-04:00" ),
//                        DefinitionStatus.INTERIM ) );
//        def.addAnyMetadata( repo );
//
//        return def;
//    }
//
//
//    /**
//     * Sample OVAL Definitions.
//     *
//     * @testng.data-provider name="oval-definition"
//     */
//    public Object[][] ovalDefinitionProvider()
//    {
//        Definition  def1 = new Definition( "oval:com.redhat.rhsa:def:20090018", 302,
//                        DefinitionClass.PATCH );
//        def1.setTitle( "RHSA-2009:0018: xterm security update (Important)" );
//        def1.setDescription( "The xterm program is ..." );
//        def1.setAffectedFamily( Family.UNIX );
//        def1.addAffectedPlatform( new Platform( "Red Hat Enterprise Linux 3" ) );
//        def1.addAffectedPlatform( new Platform( "Red Hat Enterprise Linux 4" ) );
//        def1.addAffectedPlatform( new Platform( "Red Hat Enterprise Linux 5" ) );
//        def1.addReference( new Reference( "RHSA", "RHSA-2009:0018-01",
//                        "https://rhn.redhat.com/errata/RHSA-2009-0018.html" ) );
//
//        // 2
//        Definition  def2 = new Definition( "oval:org.mitre.oval:def:5942", 1,
//                        DefinitionClass.VULNERABILITY );
//        def2.setTitle( "SPN Vulnerability" );
//        def2.setDescription( "Microsoft Windows Media Player 6.4, ..." );
//        def2.setAffectedFamily( Family.WINDOWS );
//        def2.addAffectedPlatform( new Platform( "Microsoft Windows 2000" ) );
//        def2.addAffectedPlatform( new Platform( "Microsoft Windows XP" ) );
//        def2.addAffectedPlatform( new Platform( "Microsoft Windows Server 2003" ) );
//        def2.addAffectedPlatform( new Platform( "Microsoft Windows Vista" ) );
//        def2.addAffectedPlatform( new Platform( "Microsoft Windows Server 2008" ) );
//        def2.addAffectedProduct( new Product( "Windows Media Server 4.1" ) );
//        def2.addAffectedProduct( new Product( "Windows Media Server 9" ) );
//        def2.addAffectedProduct( new Product( "Windows Media Format Runtime 7.1" ) );
//        def2.addAffectedProduct( new Product( "Windows Media Format Runtime 9.5" ) );
//        def2.addAffectedProduct( new Product( "Windows Media Format Runtime 11" ) );
//        def2.addReference( new Reference( "CVE", "CVE-2008-3009",
//                        "http://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2008-3009" ) );
//
//        return new Object[][] {
//                        { def1 },
//                        { def2 }
//        };
//    }

}
// OvalSamples

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

