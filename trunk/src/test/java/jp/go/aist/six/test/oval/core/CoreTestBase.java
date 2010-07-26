package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.core.service.OvalContext;
import jp.go.aist.six.oval.core.store.OvalStore;
import jp.go.aist.six.oval.core.xml.OvalXml;
import jp.go.aist.six.oval.model.NameEntity;
import jp.go.aist.six.oval.model.OvalElementContainer;
import jp.go.aist.six.oval.model.OvalEntity;
import jp.go.aist.six.oval.model.common.Datatype;
import jp.go.aist.six.oval.model.common.Family;
import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.definition.Affected;
import jp.go.aist.six.oval.model.definition.Definition;
import jp.go.aist.six.oval.model.definition.DefinitionClass;
import jp.go.aist.six.oval.model.definition.Definitions;
import jp.go.aist.six.oval.model.definition.Metadata;
import jp.go.aist.six.oval.model.definition.OvalDefinitions;
import jp.go.aist.six.oval.model.definition.Platform;
import jp.go.aist.six.oval.model.definition.Product;
import jp.go.aist.six.oval.model.definition.Reference;
import jp.go.aist.six.oval.model.independent.FamilyItem;
import jp.go.aist.six.oval.model.independent.TextFileContentItem;
import jp.go.aist.six.oval.model.linux.DpkgInfoItem;
import jp.go.aist.six.oval.model.linux.LinuxPkgInfoItem;
import jp.go.aist.six.oval.model.linux.RpmInfoItem;
import jp.go.aist.six.oval.model.result.Content;
import jp.go.aist.six.oval.model.result.DefinitionResult;
import jp.go.aist.six.oval.model.result.Directive;
import jp.go.aist.six.oval.model.result.Directives;
import jp.go.aist.six.oval.model.result.OvalResults;
import jp.go.aist.six.oval.model.result.Result;
import jp.go.aist.six.oval.model.result.SystemResult;
import jp.go.aist.six.oval.model.system.CollectedSystemObject;
import jp.go.aist.six.oval.model.system.CollectedSystemObjects;
import jp.go.aist.six.oval.model.system.EntityItemAnySimple;
import jp.go.aist.six.oval.model.system.EntityItemInt;
import jp.go.aist.six.oval.model.system.EntityItemString;
import jp.go.aist.six.oval.model.system.Flag;
import jp.go.aist.six.oval.model.system.Item;
import jp.go.aist.six.oval.model.system.ItemReference;
import jp.go.aist.six.oval.model.system.NetworkInterface;
import jp.go.aist.six.oval.model.system.OvalSystemCharacteristics;
import jp.go.aist.six.oval.model.system.Status;
import jp.go.aist.six.oval.model.system.SystemData;
import jp.go.aist.six.oval.model.system.SystemInfo;
import jp.go.aist.six.oval.model.unix.UnameItem;
import jp.go.aist.six.oval.model.windows.EntityItemFileType;
import jp.go.aist.six.oval.model.windows.EntityItemRegistryHive;
import jp.go.aist.six.oval.model.windows.EntityItemRegistryType;
import jp.go.aist.six.oval.model.windows.FileItem;
import jp.go.aist.six.oval.model.windows.FileType;
import jp.go.aist.six.oval.model.windows.RegistryHive;
import jp.go.aist.six.oval.model.windows.RegistryItem;
import jp.go.aist.six.oval.model.windows.RegistryType;
import jp.go.aist.six.util.IsoDate;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class CoreTestBase
{

    private OvalContext  _service = null;



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
        if (_service == null) {
            _service = new OvalContext();
        }
    }


    protected OvalXml _getXml()
    throws Exception
    {
        return _service.getXml();
    }


    protected OvalStore _getStore()
    throws Exception
    {
        if (_service == null) {
            setUp();
        }

        return _service.getStore();
    }



    /**
     */
    protected <T> T _unmarshalFile(
                    final String filepath,
                    final Class<T> type
                    )
    throws Exception
    {
        File  file = new File( filepath );
        Reporter.log( "unmarshalling XML...", true );
        Object  obj = _getXml().unmarshal( new FileInputStream( file ) );
        Reporter.log( "...unmarshalling done", true );
        Reporter.log( "  @ unmarshalled object: " + obj, true );

        Assert.assertTrue( type.isInstance( obj ) );

        return type.cast( obj );
    }



    /**
     */
    protected <T extends OvalEntity> void _syncOvalEntity(
                    final Class<T> type,
                    final T e
                    )
    throws Exception
    {
//        Reporter.log( "getting object...", true );
//        T  p_eq = _getStore().get( type, e.getPersistentID() );
//        Reporter.log( "...get done", true );
//        Reporter.log( "  @ persistent object: " + p_eq, true );
//
//        Reporter.log( "finding equaivalent...", true );
//        p_eq = _getStore().findEquivalent( type, e );
//        Reporter.log( "...find equivalent done", true );
//        Reporter.log( "  @ equivalent: " + p_eq, true );

        Reporter.log( "syncing OvalEntity: " + e, true );
        T  p = _getStore().sync( type, e );
        Reporter.log( "...sync done", true );
        String  pid = p.getPersistentID();
        Reporter.log( "  @ synced: pid=" + pid, true );
//        Reporter.log( "  @ synced: hash=" + p.hashCode(), true );


//        Reporter.log( "finding object by ID...", true );
//        RelationalBinding  idFilter = RelationalBinding.equalBinding( "persistentID", pid );
//        List<T>  entities = _getStore().find( type, idFilter );
//        Reporter.log( "...find done", true );
//        T  p3 = entities.get( 0 );
//        Reporter.log( "  @ find by ID: object=" + p3, true );
//        Assert.assertEquals( p3.getOvalID(), e.getOvalID() );
//        Assert.assertEquals( p3.getOvalVersion(), e.getOvalVersion() );


        Reporter.log( "getting object...", true );
        T  p2 = _getStore().get( type, pid );
//        T  p2 = _getStore().get( type, pid );
        Reporter.log( "...get done", true );
        Reporter.log( "  @ get: object=" + p2, true );
//        Reporter.log( "  @ get: hash=" + p.hashCode(), true );
        Assert.assertEquals( p2, e );
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




    protected void _validate(
                    final OvalElementContainer<?> actual,
                    final OvalElementContainer<?> expected
                    )
    {
        Assert.assertEquals( actual, expected );
    }



    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  Common
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    // Generator //
    protected void _validate(
                    final Generator actual,
                    final Generator expected
                    )
    {
        Reporter.log( " - schema_version", true );
        Assert.assertEquals( actual.getSchemaVersion(), expected.getSchemaVersion() );

        Reporter.log( " - timestamp", true );
        Assert.assertEquals( actual.getTimestamp(), expected.getTimestamp() );

        Reporter.log( " - product_name", true );
        Assert.assertEquals( actual.getProductName(), expected.getProductName() );

        Reporter.log( " - product_version", true );
        Assert.assertEquals( actual.getProductVersion(), expected.getProductVersion() );
    }



    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  Definitions
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    // definition //

    public static final Affected AfFECTED_1020_2 =
        new Affected( Family.WINDOWS,
                        new Platform[] { new Platform( "Microsoft Windows XP" ) },
                        new Product[] { new Product( "Microsoft Internet Explorer" ) }
        );


    public static final Definition  DEFINITION_1020_2 =
        new Definition( "oval:org.mitre.oval:def:1020", 2 );
    {
        DEFINITION_1020_2.setDefinitionClass( DefinitionClass.VULNERABILITY );

        Metadata  metadata = new Metadata(
                        "IE6 Double Byte Character Parsing Memory Corruption (WinXP)",
                        "Buffer overflow in URLMON.DLL in Microsoft Internet Explorer 5.01 through 6 allows remote attackers to execute arbitrary code via a crafted URL with an International Domain Name (IDN) using double-byte character sets (DBCS), aka the \"Double Byte Character Parsing Memory Corruption Vulnerability.\""
                        );
        metadata.setAffected( AfFECTED_1020_2 );
        metadata.addReference(
                        new Reference(
                                        "CVE",
                                        "CVE-2006-1189",
                                        "http://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2006-1189"
                                        )
                        );
        DEFINITION_1020_2.setMetadata( metadata );
    }



    protected void _validate(
                    final OvalDefinitions actual,
                    final OvalDefinitions expected
                    )
    {
        Assert.assertEquals( actual.getGenerator(),    expected.getGenerator() );
        Assert.assertEquals( actual.getDefinitions(),  expected.getDefinitions() );

        Definitions  expected_definitions = expected.getDefinitions();
        for (Definition  actual_def : actual.getDefinitions()) {
            String  id = actual_def.getOvalID();
            Definition  expected_def = expected_definitions.find( id );
            Assert.assertEquals( actual_def, expected_def );
        }

//        Assert.assertEquals( actual.getTests(),        expected.getTests() );
//        Assert.assertEquals( actual.getObjects(),      expected.getObjects() );
//        Assert.assertEquals( actual.getStates(),       expected.getStates() );
    }


    protected void _validate(
                    final Definition actual,
                    final Definition expected
                    )
    {
        Reporter.log( " - metadata", true );
        _validate( actual.getMetadata(), expected.getMetadata() );
    }


    protected void _validate(
                    final Metadata actual,
                    final Metadata expected
                    )
    {
        Reporter.log( " - title", true );
        Assert.assertEquals( actual.getTitle(),    expected.getTitle() );

        Reporter.log( " - description", true );
        Assert.assertEquals( actual.getDescription(),  expected.getDescription() );

        Reporter.log( " - affected", true );
        Assert.assertEquals( actual.getAffected(),  expected.getAffected() );
    }



    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  System Characteristics
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //NetworkInterface

    public static final Collection<NetworkInterface> WINDWS_NETWORK_INTERFACES
    = Arrays.asList( new NetworkInterface[] {
                    new NetworkInterface(
                                    "VMware Virtual Ethernet Adapter for VMnet1",
                                    "192.168.158.1",
                                    "00-50-56-C0-00-01"
                                    ),
                    new NetworkInterface(
                                    "VMware Virtual Ethernet Adapter for VMnet8",
                                    "192.168.1.1",
                                    "00-50-56-C0-00-08"
                                    )
    } );



    //collected_objects

    private static final CollectedSystemObject  COLLECTED_OBJECT_10 =
        new CollectedSystemObject(
                        "oval:org.mitre.oval:obj:10",
                        1,
                        Flag.DOES_NOT_EXIST,
                        new ItemReference[] {
                                        new ItemReference( 83 )
                        }
        );


    private static final CollectedSystemObject  COLLECTED_OBJECT_1070 =
        new CollectedSystemObject(
                        "oval:org.mitre.oval:obj:1070",
                        2,
                        Flag.COMPLETE,
                        new ItemReference[] {
                                        new ItemReference( 46 )
                        }
        );


    private static final CollectedSystemObject  COLLECTED_OBJECT_1071 =
        new CollectedSystemObject(
                        "oval:org.mitre.oval:obj:1071",
                        1,
                        Flag.COMPLETE,
                        new ItemReference[] {
                                        new ItemReference( 45 )
                        }
        );


    private static final CollectedSystemObject  COLLECTED_OBJECT_109 =
        new CollectedSystemObject(
                        "oval:org.mitre.oval:obj:109",
                        1,
                        Flag.DOES_NOT_EXIST,
                        new ItemReference[] {
                                        new ItemReference( 103 )
                        }
        );



    private static final Generator  _SC_GENERATOR_WINDOWS_ =
        new Generator( "5.6", IsoDate.valueOf( "2010-05-12T20:27:08" ), "OVAL Definition Interpreter", "5.6 Build: 4" );



    private static final SystemInfo  _SC_SYSTEM_INFO_WINDOWS_ =
        new SystemInfo(
                        "Microsoft Windows XP Professional Service Pack 3",
                        "5.1.2600",
                        "INTEL32",
                        "x60",
                        WINDWS_NETWORK_INTERFACES
                        );



    //==============================================================
    //  oval_system_characteristics
    //==============================================================

    @DataProvider( name="oval-sc-oval_system_characteristics" )
    public Object[][] ovalScOvalSystemCharacteristicsData()
    {
        return new Object[][] {
                        {
                            "oval-sc:oval_system_characteristics",
                            "test/data/sc/oval-sc.oval_system_characteristics.1-windows-minimal.xml",
                            new Generator( "5.6", IsoDate.valueOf( "2010-05-12T20:27:08" ), "OVAL Definition Interpreter", "5.6 Build: 4" ),
                            new SystemInfo(
                                            "Microsoft Windows XP Professional Service Pack 3",
                                            "5.1.2600",
                                            "INTEL32",
                                            "x60",
                                            WINDWS_NETWORK_INTERFACES
                                            )
                        }
                        ,
                        {
                            "oval-sc:oval_system_characteristics",
                            "test/data/sc/oval-sc.oval_system_characteristics.2-windows.xml",
                            new Generator( "5.6", IsoDate.valueOf( "2010-05-12T20:27:08" ), "OVAL Definition Interpreter", "5.6 Build: 4" ),
                            new SystemInfo(
                                            "Microsoft Windows XP Professional Service Pack 3",
                                            "5.1.2600",
                                            "INTEL32",
                                            "x60",
                                            WINDWS_NETWORK_INTERFACES
                                            )
                        }
        };

    }



    //==============================================================
    //  system_info
    //==============================================================

    @DataProvider( name="oval-sc-system_info" )
    public Object[][] ovalScSystemInfoProvider()
    {
        return new Object[][] {
                        {
                            "oval-sc:system_info",
                            "test/data/sc/oval-sc.system_info.1-windows.xml",
                            new SystemInfo(
                                            "Microsoft Windows XP Professional Service Pack 3",
                                            "5.1.2600",
                                            "INTEL32",
                                            "x60",
                                            WINDWS_NETWORK_INTERFACES
                                            )
                        }
        };

    }


    //==============================================================
    //  collected_objects
    //==============================================================

    @DataProvider( name="oval-sc-collected_objects" )
    public Object[][] ovalScCollectedObjects()
    {
        return new Object[][] {
                        {
                            "oval-sc:collected_objects",
                            "test/data/sc/oval-sc.collected_objects.1.xml",
                            new CollectedSystemObjects(
                                            new CollectedSystemObject[] {
                                                            COLLECTED_OBJECT_10,
                                                            COLLECTED_OBJECT_1070,
                                                            COLLECTED_OBJECT_1071,
                                                            COLLECTED_OBJECT_109
                                            })
                        }
        };

    }



    //==============================================================
    //  system_data
    //==============================================================

    @DataProvider( name="oval-sc-system_data" )
    public Object[][] ovalScSystemDataData()
    {
        return new Object[][] {
                        {
                            "oval-sc:system_data",
                            "test/data/sc/oval-sc.system_data.1-windows.xml",
                            new SystemData(
                                            new Item[] {
                                                            REGISTRY_ITEM_83,
                                                            REGISTRY_ITEM_45,
                                                            FILE_ITEM_46,
                                                            REGISTRY_ITEM_103
                                            }

                            )
                        }
        };
    }



    //==============================================================
    //  item
    //==============================================================

    public static final RegistryItem  REGISTRY_ITEM_83 =
        new RegistryItem(
                        83,
                        Status.DOES_NOT_EXIST,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString(
                                        "SOFTWARE\\Microsoft\\Updates\\Visual Studio\\7.0\\S895309",
                                        EntityItemString.DEFAULT_DATATYPE,
                                        Status.DOES_NOT_EXIST
                                        ),
                        null,
                        null,
                        null
        );


    public static final RegistryItem  REGISTRY_ITEM_45 =
        new RegistryItem(
                        45,
                        RegistryItem.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\App Paths\\OUTLOOK.EXE" ),
                        new EntityItemString( "Path" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "C:\\Program Files\\Microsoft Office\\OFFICE11\\" )
        );


    public static final RegistryItem  REGISTRY_ITEM_103 =
        new RegistryItem(
                        103,
                        Status.DOES_NOT_EXIST,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString(
                                        "SOFTWARE\\Microsoft\\Office\\9.0\\Publisher\\InstallRoot",
                                        EntityItemString.DEFAULT_DATATYPE,
                                        Status.DOES_NOT_EXIST
                                        ),
                        null,
                        null,
                        null
        );


    public static final FileItem  FILE_ITEM_46 =
        new FileItem(
                        46,
                        RegistryItem.DEFAULT_STATUS,
                        new EntityItemString( "C:\\Program Files\\Microsoft Office\\OFFICE11\\outlook.exe" ), //filepath
                        new EntityItemString( "C:\\Program Files\\Microsoft Office\\OFFICE11\\" ),  //path
                        new EntityItemString( "outlook.exe" ),  //filename
                        new EntityItemString( "Administrators" ),  //owner
                        new EntityItemInt( "196424", Datatype.INT ),  //size
                        new EntityItemInt( "115938124830012212", Datatype.INT ),  //a_time
                        new EntityItemInt( "25257592830077382", Datatype.INT ),  //c_time
                        new EntityItemInt( "115938124830012212", Datatype.INT ),  //m_time
                        new EntityItemString( "212346" ),  //ms_checksum
                        new EntityItemString( "11.0.8312.0", Datatype.VERSION ),  //version
                        new EntityItemFileType( FileType.FILE_TYPE_DISK ), //type
                        new EntityItemString( null, EntityItemString.DEFAULT_DATATYPE, Status.DOES_NOT_EXIST ),  //development_class
                        new EntityItemString( "Microsoft Corporation" ),  //company
                        new EntityItemString( "Outlook" ),  //internal_name
                        new EntityItemString( null, EntityItemString.DEFAULT_DATATYPE, Status.NOT_COLLECTED ),  //language
                        new EntityItemString( "Outlook.exe" ),  //original_filename
                        new EntityItemString( "Microsoft Office Outlook" ),  //product_name
                        new EntityItemString( "11.0.8312" )  //product_version
        );


    public static final FamilyItem  FAMILY_ITEM_497 =
        new FamilyItem(
                        497,
                        FamilyItem.DEFAULT_STATUS,
                        Family.WINDOWS
                        );


    public static final TextFileContentItem  TEXTFILECONTENT_ITEM_1 =
        new TextFileContentItem(
                        1,
                        RegistryItem.DEFAULT_STATUS,
                        null,   //filepath
                        new EntityItemString( "/etc" ),   //path
                        new EntityItemString( "debian_version" ),   //filename
                        null,   //pattern
                        null,   //instance
                        new EntityItemString( "5.0.4" ),    //line
                        null,   //text
                        null    //subexpression
        );


    public static final UnameItem  UNAME_ITEM_17  =
        new UnameItem(
                        17,
                        UnameItem.DEFAULT_STATUS,
                        "i686",
                        "debian50064",
                        "Linux",
                        "2.6.26-2-686",
                        "#1 SMP Tue Mar 9 17:35:51 UTC 2010",
                        "i686"
                        );


    public static final DpkgInfoItem  DPKG_INFO_ITEM_14  =
        new DpkgInfoItem(
                        14,
                        Status.DOES_NOT_EXIST,
                        new EntityItemString( "apache2", EntityItemString.DEFAULT_DATATYPE, Status.DOES_NOT_EXIST )
                        );


    public static final RpmInfoItem  RPM_INFO_ITEM_2  =
        new RpmInfoItem(
                        2,
                        RpmInfoItem.DEFAULT_STATUS,
                        new EntityItemString( "i386" ),
                        new EntityItemString( "gzip" ),
                        new EntityItemString( "1.3.5" ),
                        new EntityItemString( "10.el5" ),
                        new EntityItemString( "(none)" ),
                        new EntityItemString( "0:1.3.5-10.el5" ),
                        new EntityItemString( "5326810137017186" )
                        );



    @DataProvider( name="oval-sc-item" )
    public Object[][] ovalScItemData()
    {
        return new Object[][] {
                        {
                            "oval-sc#windows:registry_item",
                            "test/data/sc/oval-sc.item.registry_item.1.xml",
                            REGISTRY_ITEM_83
                        }
                        ,
                        {
                            "oval-sc#windows:registry_item",
                            "test/data/sc/oval-sc.item.registry_item.2.xml",
                            REGISTRY_ITEM_45
                        }
                        ,
                        {
                            "oval-sc#windows:file_item",
                            "test/data/sc/oval-sc.item.file_item.1.xml",
                            FILE_ITEM_46
                        }
                        ,
                        {
                            "oval-sc#independent:family_item",
                            "test/data/sc/oval-sc.item.family_item.1.xml",
                            FAMILY_ITEM_497
                        }
                        ,
                        {
                            "oval-sc#independent:textfilecontent_item",
                            "test/data/sc/oval-sc.item.textfilecontent_item.1.xml",
                            TEXTFILECONTENT_ITEM_1
                        }
                        ,
                        {
                            "oval-sc#independent:uname_item",
                            "test/data/sc/oval-sc.item.uname_item.1.xml",
                            UNAME_ITEM_17
                        }
                        ,
                        {
                            "oval-sc#independent:dpkginfo_item",
                            "test/data/sc/oval-sc.item.dpkginfo_item.1.xml",
                            DPKG_INFO_ITEM_14
                        }
                        ,
                        {
                            "oval-sc#independent:rpminfo_item",
                            "test/data/sc/oval-sc.item.rpminfo_item.1.xml",
                            RPM_INFO_ITEM_2
                        }
        };

    }




    //SystemInfo
    protected void _validate(
                    final SystemInfo actual,
                    final SystemInfo expected
                    )
    {
        Assert.assertEquals( actual.getOsName(), expected.getOsName() );
        Assert.assertEquals( actual.getOsVersion(), expected.getOsVersion() );
        Assert.assertEquals( actual.getArchitecture(), expected.getArchitecture() );
        Assert.assertEquals( actual.getPrimaryHostName(), expected.getPrimaryHostName() );

        Set<NetworkInterface>  a_netifs = new HashSet<NetworkInterface>( actual.getInterfaces() );
        Set<NetworkInterface>  e_netifs = new HashSet<NetworkInterface>( expected.getInterfaces() );
        Assert.assertEquals( a_netifs, e_netifs );
    }



    // CollectedSystemObjects
    protected void _validate(
                    final CollectedSystemObjects actual,
                    final CollectedSystemObjects expected
                    )
    {
        Assert.assertEquals(
                        new HashSet<CollectedSystemObject>( actual.getObject() ),
                        new HashSet<CollectedSystemObject>( expected.getObject() )
                        );
    }



    // SystemData
    protected void _validate(
                    final SystemData actual,
                    final SystemData expected
                    )
    {
        Assert.assertEquals( actual, expected );
    }



    //Item
    protected void _validate(
                    final Item actual,
                    final Item expected
                    )
    {
        Reporter.log( " - ID", true );
        Assert.assertEquals( actual.getID(), expected.getID() );
        Reporter.log( " - status", true );
        Assert.assertEquals( actual.getStatus(), expected.getStatus() );

        if (expected instanceof RegistryItem) {
            _validate( RegistryItem.class.cast( actual ), RegistryItem.class.cast( expected ) );
        } else if (expected instanceof FileItem) {
            _validate( FileItem.class.cast( actual ), FileItem.class.cast( expected ) );
        } else if (expected instanceof LinuxPkgInfoItem) {
            _validate( LinuxPkgInfoItem.class.cast( actual ), LinuxPkgInfoItem.class.cast( expected ) );
        } else if (expected instanceof UnameItem) {
            _validate( UnameItem.class.cast( actual ), UnameItem.class.cast( expected ) );
        } else if (expected instanceof TextFileContentItem) {
            _validate( TextFileContentItem.class.cast( actual ), TextFileContentItem.class.cast( expected ) );
        } else if (expected instanceof FamilyItem) {
            _validate( FamilyItem.class.cast( actual ), FamilyItem.class.cast( expected ) );
        }
    }


    //FamilyItem
    private void _validate(
                    final FamilyItem actual,
                    final FamilyItem expected
                    )
    {
        Reporter.log( " - family", true );
        Assert.assertEquals( actual.getFamily(), expected.getFamily() );
    }



    //TextFileContentItem
    private void _validate(
                    final TextFileContentItem actual,
                    final TextFileContentItem expected
                    )
    {
        Reporter.log( " - filepath", true );
        Assert.assertEquals( actual.getFilepath(), expected.getFilepath() );
        Reporter.log( " - path", true );
        Assert.assertEquals( actual.getPath(), expected.getPath() );
        Reporter.log( " - filename", true );
        Assert.assertEquals( actual.getFilename(), expected.getFilename() );
        Reporter.log( " - pattern", true );
        Assert.assertEquals( actual.getPattern(), expected.getPattern() );
        Reporter.log( " - instance", true );
        Assert.assertEquals( actual.getInstance(), expected.getInstance() );
        Reporter.log( " - line", true );
        Assert.assertEquals( actual.getLine(), expected.getLine() );
        Reporter.log( " - text", true );
        Assert.assertEquals( actual.getText(), expected.getText() );
        Reporter.log( " - subexpression", true );
        Assert.assertEquals( new HashSet<EntityItemAnySimple>( actual.getSubexpression() ),
                        new HashSet<EntityItemAnySimple>( expected.getSubexpression() ) );
    }



    //RegistryItem
    private void _validate(
                    final RegistryItem actual,
                    final RegistryItem expected
                    )
    {
        Reporter.log( " - hive", true );
        Assert.assertEquals( actual.getHive(), expected.getHive() );
        Reporter.log( " - key", true );
        Assert.assertEquals( actual.getKey(), expected.getKey() );
        Reporter.log( " - name", true );
        Assert.assertEquals( actual.getName(), expected.getName() );
        Reporter.log( " - type", true );
        Assert.assertEquals( actual.getType(), expected.getType() );
        Reporter.log( " - value", true );
        Assert.assertEquals( actual.getValue(), expected.getValue() );
    }


    //FileItem
    private void _validate(
                    final FileItem actual,
                    final FileItem expected
                    )
    {
        Reporter.log( " - filepath", true );
        Assert.assertEquals( actual.getFilepath(), expected.getFilepath() );
        Reporter.log( " - path", true );
        Assert.assertEquals( actual.getPath(), expected.getPath() );
        Reporter.log( " - filename", true );
        Assert.assertEquals( actual.getFilename(), expected.getFilename() );
        Reporter.log( " - owner", true );
        Assert.assertEquals( actual.getOwner(), expected.getOwner() );
        Reporter.log( " - size", true );
        Assert.assertEquals( actual.getSize(), expected.getSize() );
        Reporter.log( " - aTime", true );
        Assert.assertEquals( actual.getATime(), expected.getATime() );
        Reporter.log( " - cTime", true );
        Assert.assertEquals( actual.getCTime(), expected.getCTime() );
        Reporter.log( " - mTime", true );
        Assert.assertEquals( actual.getMTime(), expected.getMTime() );
        Reporter.log( " - msChecksum", true );
        Assert.assertEquals( actual.getMsChecksum(), expected.getMsChecksum() );
        Reporter.log( " - version", true );
        Assert.assertEquals( actual.getVersion(), expected.getVersion() );
        Reporter.log( " - type", true );
        Assert.assertEquals( actual.getType(), expected.getType() );
        Reporter.log( " - developmentClass", true );
        Assert.assertEquals( actual.getDevelopmentClass(), expected.getDevelopmentClass() );
        Reporter.log( " - company", true );
        Assert.assertEquals( actual.getCompany(), expected.getCompany() );
        Reporter.log( " - internalName", true );
        Assert.assertEquals( actual.getInternalName(), expected.getInternalName() );
        Reporter.log( " - language", true );
        Assert.assertEquals( actual.getLanguage(), expected.getLanguage() );
        Reporter.log( " - originalFilename", true );
        Assert.assertEquals( actual.getOriginalFilename(), expected.getOriginalFilename() );
        Reporter.log( " - productName", true );
        Assert.assertEquals( actual.getProductName(), expected.getProductName() );
        Reporter.log( " - productVersion", true );
        Assert.assertEquals( actual.getProductVersion(), expected.getProductVersion() );
    }


    //UnameItem
    private void _validate(
                    final UnameItem actual,
                    final UnameItem expected
                    )
    {
        Reporter.log( " - machine_class", true );
        Assert.assertEquals( actual.getMachineClass(), expected.getMachineClass() );
        Reporter.log( " - node_name", true );
        Assert.assertEquals( actual.getNodeName(), expected.getNodeName() );
        Reporter.log( " - os_name", true );
        Assert.assertEquals( actual.getOsName(), expected.getOsName() );
        Reporter.log( " - os_release", true );
        Assert.assertEquals( actual.getOsRelease(), expected.getOsRelease() );
        Reporter.log( " - os_version", true );
        Assert.assertEquals( actual.getOsVersion(), expected.getOsVersion() );
        Reporter.log( " - processor_type", true );
        Assert.assertEquals( actual.getProcessorType(), expected.getProcessorType() );
    }


    //LinuxPkgInfoItem
    private void _validate(
                    final LinuxPkgInfoItem actual,
                    final LinuxPkgInfoItem expected
                    )
    {
        Reporter.log( " - name", true );
        Assert.assertEquals( actual.getName(), expected.getName() );

        Reporter.log( " - arch", true );
        Assert.assertEquals( actual.getArch(), expected.getArch() );

        Reporter.log( " - version", true );
        Assert.assertEquals( actual.getVersion(), expected.getVersion() );
    }


    //OvalSystemCharacteristics
    protected void _validate(
                    final OvalSystemCharacteristics actual,
                    final OvalSystemCharacteristics expected
                    )
    {
        Reporter.log( " - generator", true );
        _validate( actual.getGenerator(), expected.getGenerator() );

        Reporter.log( " - system_info", true );
        _validate( actual.getSystemInfo(), expected.getSystemInfo() );
    }



    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  Results
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //Directives
    protected void _validate(
                    final Directives actual,
                    final Directives expected
                    )
    {
        Assert.assertEquals( actual, expected );
    }



    //SystemResult
    protected void _validate(
                    final SystemResult actual,
                    final SystemResult expected
                    )
    {
        _validate(
                        actual.getOvalSystemCharacteristics(),
                        expected.getOvalSystemCharacteristics()
                        );
    }


    //DefinitionResult
    protected void _validate(
                    final DefinitionResult actual,
                    final DefinitionResult expected
                    )
    {
        Assert.assertEquals( actual.getDefinitionID(), expected.getDefinitionID() );
        Assert.assertEquals( actual.getOvalVersion(), expected.getOvalVersion() );
        Assert.assertEquals( actual.getResult(), expected.getResult() );
        Assert.assertEquals( actual.getVariableInstance(), expected.getVariableInstance() );
    }



    protected void _validate(
                    final OvalResults actual,
                    final OvalResults expected
                    )
    {
        Assert.assertEquals( actual.getGenerator(), expected.getGenerator() );
        Assert.assertEquals( actual.getDirectives(), expected.getDirectives() );
    }



    ////////////////////////////////////////////////////////////////
    //  Data Providers
    ////////////////////////////////////////////////////////////////

    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  Results
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    // directives //

    public static final Directives DIRECTIVES_1 =
        new Directives(
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL )
                        );


    @DataProvider( name="oval-results-directives" )
    public Object[][] ovalResultsDirectivesData()
    {
        return new Object[][] {
                        {
                            "oval-results:directives",
                            "test/data/result/oval-results.directive.1.xml",
                            DIRECTIVES_1
                        }
        };

    }


    // definition //
    public static final DefinitionResult  DEFINITION_RESULT_6262 =
        new DefinitionResult(
                        "oval:org.mitre.oval:def:6262",
                        0,
                        Result.FALSE
                        );

    @DataProvider( name="oval-results-definition" )
    public Object[][] ovalResultsDefinitionData()
    {
        return new Object[][] {
                        {
                            "oval-results:definition",
                            "test/data/result/oval-results.definition.1.xml",
                            DEFINITION_RESULT_6262
                        }
        };

    }


    // system //

    public static final SystemResult  SYSTEM_RESULT_MINIMAL =
        new SystemResult( new OvalSystemCharacteristics(
                        _SC_GENERATOR_WINDOWS_,
                        _SC_SYSTEM_INFO_WINDOWS_
                        )
        );


    @DataProvider( name="oval-results-system" )
    public Object[][] ovalResultsSystemData()
    {
        return new Object[][] {
                        {
                            "oval-results:system",
                            "test/data/result/oval-results.oval_results.1-minimal.xml",
                            SYSTEM_RESULT_MINIMAL
                        }
        };

    }


    // oval_results //

    public static final Generator  RESULTS_GENERATOR_1 =
        new Generator(
                        "5.6",
                        IsoDate.valueOf( "2010-05-12T20:27:10" ),
                        "OVAL Definition Interpreter",
                        "5.6 Build: 4"
                        );


}
// CoreTestBase

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

