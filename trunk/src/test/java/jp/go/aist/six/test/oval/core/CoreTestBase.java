package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.core.service.OvalContext;
import jp.go.aist.six.oval.core.store.OvalStore;
import jp.go.aist.six.oval.core.xml.OvalXml;
import jp.go.aist.six.oval.model.NameEntity;
import jp.go.aist.six.oval.model.common.Datatype;
import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.sc.CollectedSystemObject;
import jp.go.aist.six.oval.model.sc.CollectedSystemObjects;
import jp.go.aist.six.oval.model.sc.EntityItemAnySimple;
import jp.go.aist.six.oval.model.sc.EntityItemInt;
import jp.go.aist.six.oval.model.sc.EntityItemString;
import jp.go.aist.six.oval.model.sc.Flag;
import jp.go.aist.six.oval.model.sc.Item;
import jp.go.aist.six.oval.model.sc.ItemReference;
import jp.go.aist.six.oval.model.sc.NetInterface;
import jp.go.aist.six.oval.model.sc.Status;
import jp.go.aist.six.oval.model.sc.SystemData;
import jp.go.aist.six.oval.model.sc.SystemInfo;
import jp.go.aist.six.oval.model.unix.UnameItem;
import jp.go.aist.six.oval.model.windows.EntityItemFileType;
import jp.go.aist.six.oval.model.windows.EntityItemRegistryHive;
import jp.go.aist.six.oval.model.windows.EntityItemRegistryType;
import jp.go.aist.six.oval.model.windows.FileItem;
import jp.go.aist.six.oval.model.windows.FileType;
import jp.go.aist.six.oval.model.windows.RegistryHive;
import jp.go.aist.six.oval.model.windows.RegistryItem;
import jp.go.aist.six.oval.model.windows.RegistryType;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collection;



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
    //  System Characteristics
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //NetworkInterface

    public static final Collection<NetInterface> WINDWS_NETWORK_INTERFACES
    = Arrays.asList( new NetInterface[] {
                    new NetInterface(
                                    "VMware Virtual Ethernet Adapter for VMnet1",
                                    "192.168.158.1",
                                    "00-50-56-C0-00-01"
                                    ),
                    new NetInterface(
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
        new Generator( "5.6", "2010-05-12T20:27:08", "OVAL Definition Interpreter", "5.6 Build: 4" );



    private static final SystemInfo  _SC_SYSTEM_INFO_WINDOWS_ =
        new SystemInfo(
                        "Microsoft Windows XP Professional Service Pack 3",
                        "5.1.2600",
                        "INTEL32",
                        "x60",
                        WINDWS_NETWORK_INTERFACES
                        );



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


}
// CoreTestBase

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

