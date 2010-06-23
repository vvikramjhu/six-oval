package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.core.service.StandardOvalService;
import jp.go.aist.six.oval.core.store.OvalStore;
import jp.go.aist.six.oval.core.xml.OvalXml;
import jp.go.aist.six.oval.model.common.Datatype;
import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.system.EntityItemAnySimple;
import jp.go.aist.six.oval.model.system.EntityItemInt;
import jp.go.aist.six.oval.model.system.EntityItemString;
import jp.go.aist.six.oval.model.system.Item;
import jp.go.aist.six.oval.model.system.NetworkInterface;
import jp.go.aist.six.oval.model.system.Status;
import jp.go.aist.six.oval.model.system.SystemData;
import jp.go.aist.six.oval.model.system.SystemInfo;
import jp.go.aist.six.oval.model.windows.EntityItemFileType;
import jp.go.aist.six.oval.model.windows.EntityItemRegistryHive;
import jp.go.aist.six.oval.model.windows.EntityItemRegistryType;
import jp.go.aist.six.oval.model.windows.FileItem;
import jp.go.aist.six.oval.model.windows.FileType;
import jp.go.aist.six.oval.model.windows.RegistryHive;
import jp.go.aist.six.oval.model.windows.RegistryItem;
import jp.go.aist.six.oval.model.windows.RegistryType;
import jp.go.aist.six.util.IsoDate;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import java.util.Arrays;
import java.util.Collection;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalServiceTestBase.java 778 2010-05-11 06:26:16Z akihito $
 */
public abstract class CoreTestBase
{

    private StandardOvalService  _service = null;



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
        _service = new StandardOvalService();
    }


    protected OvalXml _getXml()
    throws Exception
    {
        return _service.getXml();
    }


    protected OvalStore _getStore()
    throws Exception
    {
        return _service.getStore();
    }



    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  System Characteristics
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    private static final Collection<NetworkInterface> _WINDWS_NETWORK_INTERFACES_
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
                                            _WINDWS_NETWORK_INTERFACES_
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
                                            _WINDWS_NETWORK_INTERFACES_
                                            )
                        }
        };

    }



    //==============================================================
    //  system_info
    //==============================================================

    @DataProvider( name="oval-sc-system_info" )
    public Object[][] ovalScSystemInfoData()
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
                                            _WINDWS_NETWORK_INTERFACES_
                                            )
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
        };

    }

}
// CoreTestBase

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

