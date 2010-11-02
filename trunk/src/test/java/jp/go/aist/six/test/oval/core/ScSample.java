package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.common.Family;
import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.independent.FamilyItem;
import jp.go.aist.six.oval.model.independent.TextFileContentItem;
import jp.go.aist.six.oval.model.linux.DpkgInfoItem;
import jp.go.aist.six.oval.model.linux.RpmInfoItem;
import jp.go.aist.six.oval.model.sc.CollectedSystemObject;
import jp.go.aist.six.oval.model.sc.EntityItemInt;
import jp.go.aist.six.oval.model.sc.EntityItemString;
import jp.go.aist.six.oval.model.sc.EntityItemVersion;
import jp.go.aist.six.oval.model.sc.Flag;
import jp.go.aist.six.oval.model.sc.Item;
import jp.go.aist.six.oval.model.sc.NetInterface;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.model.sc.Status;
import jp.go.aist.six.oval.model.sc.SystemInfo;
import jp.go.aist.six.oval.model.sc.VariableValue;
import jp.go.aist.six.oval.model.unix.UnameItem;
import jp.go.aist.six.oval.model.windows.EntityItemFileType;
import jp.go.aist.six.oval.model.windows.EntityItemRegistryHive;
import jp.go.aist.six.oval.model.windows.FileItem;
import jp.go.aist.six.oval.model.windows.FileType;
import jp.go.aist.six.oval.model.windows.RegistryHive;
import jp.go.aist.six.oval.model.windows.RegistryItem;
import jp.go.aist.six.oval.model.windows.RegistryType;



/**
 * OVAL System Characteristics sample objects.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class ScSample
{

    //==============================================================
    //  sc:interface
    //==============================================================

//    public static final Collection<NetInterface>  NETWORK_INTERFACES_1 =
//        Arrays.asList( new NetInterface[] {
//                        new NetInterface(
//                                        "VMware Virtual Ethernet Adapter for VMnet1",
//                                        "192.168.158.1",
//                                        "00-50-56-C0-00-01"
//                        ),
//                        new NetInterface(
//                                        "VMware Virtual Ethernet Adapter for VMnet8",
//                                        "192.168.1.1",
//                                        "00-50-56-C0-00-08"
//                        )
//    } );



    //==============================================================
    //  sc:system_info
    //==============================================================


    //==============================================================
    //  sc:item
    //==============================================================

    // independent family
    public static final FamilyItem  ITEM_INDEPENDENT_FAMILY_497 =
        new FamilyItem( 497, Family.WINDOWS );


    // independent textfilecontent
    public static final TextFileContentItem  ITEM_INDEPENDENT_TEXTFILECONTENT_1 =
        new TextFileContentItem( 1 )
    .path( "/etc" )
    .filename( "debian_version" )
    .line( "5.0.4" );


    // linux dpkginfo
    public static final DpkgInfoItem  ITEM_LINUX_DPKGINFO_14 =
        new DpkgInfoItem( 14, Status.DOES_NOT_EXIST )
    .name( new EntityItemString( "apache2", Status.DOES_NOT_EXIST ) );


    // linux rpminfo
    public static final RpmInfoItem  ITEM_LINUX_RPMINFO_2 =
        new RpmInfoItem( 2 )
    .name( "gzip" )
    .arch( "i386" )
    .epoch( "(none)" )
    .release( "10.el5" )
    .version( "1.3.5" )
    .evr( "0:1.3.5-10.el5" )
    .signatureKeyID( "5326810137017186" )
    ;


    // unix uname
    public static final UnameItem  ITEM_UNIX_UNAME_17  =
        new UnameItem( 17, UnameItem.DEFAULT_STATUS,
                        "i686",
                        "debian50064",
                        "Linux",
                        "2.6.26-2-686",
                        "#1 SMP Tue Mar 9 17:35:51 UTC 2010",
                        "i686"
                        );


    // windows file
    public static final FileItem  ITEM_WINDOWS_FILE_46 =
        new FileItem( 46, FileItem.DEFAULT_STATUS,
                        new EntityItemString( "C:\\Program Files\\Microsoft Office\\OFFICE11\\outlook.exe" ),
                        new EntityItemString( "C:\\Program Files\\Microsoft Office\\OFFICE11" ),
                        new EntityItemString( "outlook.exe" ),
                        new EntityItemString( "Administrators" ),
                        new EntityItemInt( "196424" ),
                        new EntityItemInt( "115938124830012212" ),
                        new EntityItemInt( "25257592830077382" ),
                        new EntityItemInt( "115938124830012212" ),
                        new EntityItemString( "212346" ),
                        new EntityItemVersion( "11.0.8312.0" ),
                        new EntityItemFileType( FileType.FILE_TYPE_DISK ),
                        new EntityItemString( null, Status.DOES_NOT_EXIST ),
                        new EntityItemString( "Microsoft Corporation" ),
                        new EntityItemString( "Outlook" ),
                        new EntityItemString( null, Status.NOT_COLLECTED ),
                        new EntityItemString( "Outlook.exe" ),
                        new EntityItemString( "Microsoft Office Outlook" ),
                        new EntityItemVersion( "11.0.8312" )
        );


    // windows registry
    public static final RegistryItem  ITEM_WINDOWS_REGISTRY_45 =
        new RegistryItem( 45, RegistryItem.DEFAULT_STATUS,
                        RegistryHive.HKEY_LOCAL_MACHINE,
                        "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\App Paths\\OUTLOOK.EXE",
                        "Path",
                        RegistryType.REG_SZ,
                        "C:\\Program Files\\Microsoft Office\\OFFICE11\\"
                        )
    ;


    // windows registry
    public static final RegistryItem  ITEM_WINDOWS_REGISTRY_83 =
        new RegistryItem( 83, Status.DOES_NOT_EXIST,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "SOFTWARE\\Microsoft\\Updates\\Visual Studio\\7.0\\S895309", Status.DOES_NOT_EXIST )
                        )
    ;



    //**************************************************************
    //  sc:*, def:8050
    //**************************************************************

    public static final Generator  GENERATOR_OVALDI582 =
        new Generator(
                        "5.8",
                        "2010-10-20T11:21:32",
                        "OVAL Definition Interpreter",
                        "5.8 Build: 2"
        );


    public static final NetInterface  NET_INTERFACE_VMNET1 =
        new NetInterface(
                        "VMware Virtual Ethernet Adapter for VMnet1",
                        "192.168.158.1",
                        "00-50-56-C0-00-01"
    );

    public static final NetInterface  NET_INTERFACE_VMNET8 =
        new NetInterface(
                        "VMware Virtual Ethernet Adapter for VMnet8",
                        "192.168.1.1",
                        "00-50-56-C0-00-08"
    );


    public static final SystemInfo  SYSTEM_INFO_WINDOWS_FOO60 =
        new SystemInfo(
                        "Microsoft Windows XP Professional Service Pack 3",
                        "5.1.2600",
                        "INTEL32",
                        "foo60",
                        new NetInterface[] {
                                        NET_INTERFACE_VMNET1,
                                        NET_INTERFACE_VMNET8
                        }
        );


    // collected object:
    public static final CollectedSystemObject  COLLECTED_OBJECT_553 =
        new CollectedSystemObject( "oval:org.mitre.oval:obj:553", 2, Flag.COMPLETE )
    .reference( 4 )
    .variableValue( new VariableValue( "oval:org.mitre.oval:var:225",
                    "C:\\Program Files\\Microsoft Office\\OFFICE11\\" ) )
    ;

    // collected object:
    public static final CollectedSystemObject  COLLECTED_OBJECT_554 =
        new CollectedSystemObject( "oval:org.mitre.oval:obj:554", 1, Flag.COMPLETE )
    .reference( 3 )
    ;

    // collected object:
    public static final CollectedSystemObject  COLLECTED_OBJECT_555 =
        new CollectedSystemObject( "oval:org.mitre.oval:obj:555", 1, Flag.DOES_NOT_EXIST )
    .reference( 2 )
    ;

    // collected object:
    public static final CollectedSystemObject  COLLECTED_OBJECT_850 =
        new CollectedSystemObject( "oval:org.mitre.oval:obj:850", 2, Flag.COMPLETE )
    .reference( 1 )
    ;


    // item, windows file
    public static final FileItem  ITEM_WINDOWS_FILE_4 =
        new FileItem( 4, FileItem.DEFAULT_STATUS,
                        new EntityItemString( "C:\\Program Files\\Microsoft Office\\OFFICE11\\powerpnt.exe" ),
                        new EntityItemString( "C:\\Program Files\\Microsoft Office\\OFFICE11\\" ),
                        new EntityItemString( "powerpnt.exe" ),
                        new EntityItemString( "BUILTIN\\Administrators" ),
                        new EntityItemInt( "6418776" ),
                        new EntityItemInt( "129320148929838537" ),
                        new EntityItemInt( "129159044540000000" ),
                        new EntityItemInt( "129159044540000000" ),
                        new EntityItemString( "6460221" ),
                        new EntityItemVersion( "11.0.8324.0" ),
                        new EntityItemFileType( FileType.FILE_TYPE_DISK ),
                        new EntityItemString( null, Status.DOES_NOT_EXIST ),
                        new EntityItemString( "Microsoft Corporation" ),
                        new EntityItemString( "POWERPNT" ),
                        new EntityItemString( null, Status.NOT_COLLECTED ),
                        new EntityItemString( "POWERPNT.EXE" ),
                        new EntityItemString( "Microsoft Office 2003" ),
                        new EntityItemVersion( "11.0.8324" )
        );

    // item, windows registry
    public static final RegistryItem  ITEM_WINDOWS_REGISTRY_3 =
        new RegistryItem( 3, RegistryItem.DEFAULT_STATUS,
                        RegistryHive.HKEY_LOCAL_MACHINE,
                        "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\App Paths\\powerpnt.exe",
                        "Path",
                        RegistryType.REG_SZ,
                        "C:\\Program Files\\Microsoft Office\\OFFICE11\\"
                        )
    ;

    // item, windows registry
    public static final RegistryItem  ITEM_WINDOWS_REGISTRY_2 =
        new RegistryItem( 2, Status.DOES_NOT_EXIST,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "SOFTWARE\\Microsoft\\Office\\10.0\\PowerPoint\\InstallRoot", Status.DOES_NOT_EXIST )
                        )
    ;

    // item, windows registry
    public static final RegistryItem  ITEM_WINDOWS_REGISTRY_1 =
        new RegistryItem( 1, RegistryItem.DEFAULT_STATUS,
                        RegistryHive.HKEY_LOCAL_MACHINE,
                        "SOFTWARE\\Microsoft\\Office\\11.0\\PowerPoint\\InstallRoot",
                        "Path",
                        RegistryType.REG_SZ,
                        "C:\\Program Files\\Microsoft Office\\OFFICE11\\"
                        )
    ;


    public static final OvalSystemCharacteristics  OVAL_SC_DEF8050 =
        new OvalSystemCharacteristics(
                    GENERATOR_OVALDI582,
                    SYSTEM_INFO_WINDOWS_FOO60,
                    new CollectedSystemObject[] {
                                    COLLECTED_OBJECT_553,
                                    COLLECTED_OBJECT_554,
                                    COLLECTED_OBJECT_555,
                                    COLLECTED_OBJECT_850
                    },
                    new Item[] {
                                    ITEM_WINDOWS_FILE_4,
                                    ITEM_WINDOWS_REGISTRY_3,
                                    ITEM_WINDOWS_REGISTRY_2,
                                    ITEM_WINDOWS_REGISTRY_1
                    }
        );

}
// ScSample
