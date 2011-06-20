package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.common.Datatype;
import jp.go.aist.six.oval.model.sc.EntityItemAnySimple;
import jp.go.aist.six.oval.model.sc.EntityItemInt;
import jp.go.aist.six.oval.model.sc.EntityItemString;
import jp.go.aist.six.oval.model.sc.EntityItemVersion;
import jp.go.aist.six.oval.model.sc.Item;
import jp.go.aist.six.oval.model.sc.Status;
import jp.go.aist.six.oval.model.windows.EntityItemFileType;
import jp.go.aist.six.oval.model.windows.EntityItemRegistryHive;
import jp.go.aist.six.oval.model.windows.EntityItemRegistryType;
import jp.go.aist.six.oval.model.windows.FileItem;
import jp.go.aist.six.oval.model.windows.FileType;
import jp.go.aist.six.oval.model.windows.RegistryHive;
import jp.go.aist.six.oval.model.windows.RegistryItem;
import jp.go.aist.six.oval.model.windows.RegistryType;


public class ItemsSample
{

    public static final Item[]  ITEMS_1 = new Item[] {
        new FileItem(
                        2,
                        Item.DEFAULT_STATUS,
                        new EntityItemString( "C:\\Program Files\\MySQL\\MySQL Server 5.1\\bin\\mysqld.exe" ),
                        new EntityItemString( "C:\\Program Files\\MySQL\\MySQL Server 5.1\\bin\\" ),
                        new EntityItemString( "mysqld.exe" ),
                        new EntityItemString( "BUILTIN\\Administrators" ),
                        new EntityItemInt( 6591104 ),
                        new EntityItemInt( 129258204872031250L ),
                        new EntityItemInt( 128919810880000000L ),
                        new EntityItemInt( 128919810880000000L ),
                        new EntityItemString( "6592576" ),
                        new EntityItemVersion( null, Status.ERROR ),
                        new EntityItemFileType( FileType.FILE_TYPE_DISK ),
                        new EntityItemString( null, Status.ERROR ),
                        new EntityItemString( null, Status.ERROR ),
                        new EntityItemString( null, Status.ERROR ),
                        new EntityItemString( null, Status.ERROR ),
                        new EntityItemString( null, Status.ERROR ),
                        new EntityItemString( null, Status.ERROR ),
                        new EntityItemVersion( null, Status.ERROR )
        )
        ,
        new RegistryItem(
                        197,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "SOFTWARE\\MySQL AB\\MySQL Server 5.1" ),
                        new EntityItemString( "Version" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "5.1.37" )
        )
        ,
        new RegistryItem(
                        198,
                        Status.DOES_NOT_EXIST,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "SOFTWARE\\MySQL AB\\MySQL Server 5.0", Status.DOES_NOT_EXIST )
        )
        ,
        new RegistryItem(
                        1,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "SOFTWARE\\MySQL AB\\MySQL Server 5.1" ),
                        new EntityItemString( "Location" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "C:\\Program Files\\MySQL\\MySQL Server 5.1\\" )
        )
        ,
        new RegistryItem(
                        3,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Adobe Flash Player ActiveX" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Adobe Flash Player 10 ActiveX" )
        )
        ,
        new RegistryItem(
                        4,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Adobe Flex Builder 3 Plug-in" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Adobe Flex Builder 3 Plug-in" )
        )
        ,
        new RegistryItem(
                        5,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Adobe_6a3003001b9c4e53e6b3f44e0db85d4" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Adobe Update Manager CS3" )
        )
        ,
        new RegistryItem(
                        6,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\EdMaxU" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "EdMax" )
        )
        ,
        new RegistryItem(
                        7,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\FFFTP" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "FFFTP" )
        )
        ,
        new RegistryItem(
                        8,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\GPL Ghostscript 8.71" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "GPL Ghostscript 8.71" )
        )
        ,
        new RegistryItem(
                        9,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\GSview 4.9" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "GSview 4.9" )
        )
        ,
        new RegistryItem(
                        10,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\HDMI" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Intel(R) Graphics Media Accelerator Driver" )
        )
        ,
        new RegistryItem(
                        11,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\IDNMitigationAPIs" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft Internationalized Domain Names Mitigation APIs" )
        )
        ,
        new RegistryItem(
                        12,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\InstallShield_{3A801B30-F3FD-42C2-B460-4A4117B572EE}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "au Music Port" )
        )
        ,
        new RegistryItem(
                        13,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\InstallShield_{457D7505-D665-4F95-91C3-ECB8C56E9ACA}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Easy Tune 6 B08.1030.1" )
        )
        ,
        new RegistryItem(
                        14,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB2229593" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB2229593)" )
        )
        ,
        new RegistryItem(
                        15,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB2286198" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB2286198)" )
        )
        ,
        new RegistryItem(
                        16,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB892130" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Genuine Advantage Validation Tool (KB892130)" )
        )
        ,
        new RegistryItem(
                        17,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB898461" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u66f4\u65b0 (KB898461)" )
        )
        ,
        new RegistryItem(
                        18,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB923561" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB923561)" )
        )
        ,
        new RegistryItem(
                        19,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB923789" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB923789)" )
        )
        ,
        new RegistryItem(
                        20,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB927489" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "MS \u30b4\u30b7\u30c3\u30af \uff06 MS \u660e\u671d JIS2004 \u5bfe\u5fdc\u30d5\u30a9\u30f3\u30c8 (KB927489)" )
        )
        ,
        new RegistryItem(
                        21,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB929399" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Hotfix for Windows Media Format 11 SDK (KB929399)" )
        )
        ,
        new RegistryItem(
                        22,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB938127-v2-IE7" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 7 \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB938127-v2)" )
        )
        ,
        new RegistryItem(
                        23,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB938464-v2" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB938464-v2)" )
        )
        ,
        new RegistryItem(
                        24,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB939683" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Player 11 (KB939683) \u30db\u30c3\u30c8\u30d5\u30a3\u30c3\u30af\u30b9" )
        )
        ,
        new RegistryItem(
                        25,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB941569" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP (KB941569) \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u554f\u984c\u306e\u4fee\u6b63\u30d7\u30ed\u30b0\u30e9\u30e0" )
        )
        ,
        new RegistryItem(
                        26,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB941776_WM11" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Player 11 (KB941776) \u30db\u30c3\u30c8\u30d5\u30a3\u30c3\u30af\u30b9" )
        )
        ,
        new RegistryItem(
                        27,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB946648" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB946648)" )
        )
        ,
        new RegistryItem(
                        28,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB950762" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB950762)" )
        )
        ,
        new RegistryItem(
                        29,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB950974" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB950974)" )
        )
        ,
        new RegistryItem(
                        30,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB951066" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB951066)" )
        )
        ,
        new RegistryItem(
                        31,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB951376-v2" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB951376-v2)" )
        )
        ,
        new RegistryItem(
                        32,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB951748" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB951748)" )
        )
        ,
        new RegistryItem(
                        33,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB951978" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u66f4\u65b0 (KB951978)" )
        )
        ,
        new RegistryItem(
                        34,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB952004" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB952004)" )
        )
        ,
        new RegistryItem(
                        35,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB952069_WM9" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Player (KB952069) \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u554f\u984c\u306e\u4fee\u6b63\u30d7\u30ed\u30b0\u30e9\u30e0" )
        )
        ,
        new RegistryItem(
                        36,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB952287" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30db\u30c3\u30c8\u30d5\u30a3\u30c3\u30af\u30b9 (KB952287)" )
        )
        ,
        new RegistryItem(
                        37,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB952954" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB952954)" )
        )
        ,
        new RegistryItem(
                        38,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB954154_WM11" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Player 11 (KB954154) \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u554f\u984c\u306e\u4fee\u6b63\u30d7\u30ed\u30b0\u30e9\u30e0" )
        )
        ,
        new RegistryItem(
                        39,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB954155_WM9" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Player (KB954155) \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u554f\u984c\u306e\u4fee\u6b63\u30d7\u30ed\u30b0\u30e9\u30e0" )
        )
        ,
        new RegistryItem(
                        40,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB954459" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB954459)" )
        )
        ,
        new RegistryItem(
                        41,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB954550-v5" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Hotfix for Windows XP (KB954550-v5)" )
        )
        ,
        new RegistryItem(
                        42,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB954600" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB954600)" )
        )
        ,
        new RegistryItem(
                        43,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB955069" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB955069)" )
        )
        ,
        new RegistryItem(
                        44,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB955759" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u66f4\u65b0 (KB955759)" )
        )
        ,
        new RegistryItem(
                        45,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB955839" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u66f4\u65b0 (KB955839)" )
        )
        ,
        new RegistryItem(
                        46,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB956572" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB956572)" )
        )
        ,
        new RegistryItem(
                        47,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB956744" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB956744)" )
        )
        ,
        new RegistryItem(
                        48,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB956802" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB956802)" )
        )
        ,
        new RegistryItem(
                        49,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB956803" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB956803)" )
        )
        ,
        new RegistryItem(
                        50,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB956844" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB956844)" )
        )
        ,
        new RegistryItem(
                        51,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB957097" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB957097)" )
        )
        ,
        new RegistryItem(
                        52,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB958644" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB958644)" )
        )
        ,
        new RegistryItem(
                        53,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB958687" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB958687)" )
        )
        ,
        new RegistryItem(
                        54,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB958869" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB958869)" )
        )
        ,
        new RegistryItem(
                        55,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB959426" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB959426)" )
        )
        ,
        new RegistryItem(
                        56,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB960225" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB960225)" )
        )
        ,
        new RegistryItem(
                        57,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB960803" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB960803)" )
        )
        ,
        new RegistryItem(
                        58,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB960859" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB960859)" )
        )
        ,
        new RegistryItem(
                        59,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB961118" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB961118)" )
        )
        ,
        new RegistryItem(
                        60,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB961371-v2" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB961371-v2)" )
        )
        ,
        new RegistryItem(
                        61,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB961501" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB961501)" )
        )
        ,
        new RegistryItem(
                        62,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB967715" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u66f4\u65b0 (KB967715)" )
        )
        ,
        new RegistryItem(
                        63,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB968389" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u66f4\u65b0 (KB968389)" )
        )
        ,
        new RegistryItem(
                        64,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB968537" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB968537)" )
        )
        ,
        new RegistryItem(
                        65,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB968816_WM9" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Player (KB968816) \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u554f\u984c\u306e\u4fee\u6b63\u30d7\u30ed\u30b0\u30e9\u30e0" )
        )
        ,
        new RegistryItem(
                        66,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB969059" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB969059)" )
        )
        ,
        new RegistryItem(
                        67,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB969947" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB969947)" )
        )
        ,
        new RegistryItem(
                        68,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB970238" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB970238)" )
        )
        ,
        new RegistryItem(
                        69,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB970430" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB970430)" )
        )
        ,
        new RegistryItem(
                        70,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB970653-v3" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30db\u30c3\u30c8\u30d5\u30a3\u30c3\u30af\u30b9 (KB970653-v3)" )
        )
        ,
        new RegistryItem(
                        71,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB971468" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB971468)" )
        )
        ,
        new RegistryItem(
                        72,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB971486" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB971486)" )
        )
        ,
        new RegistryItem(
                        73,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB971557" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB971557)" )
        )
        ,
        new RegistryItem(
                        74,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB971633" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB971633)" )
        )
        ,
        new RegistryItem(
                        75,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB971657" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB971657)" )
        )
        ,
        new RegistryItem(
                        76,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB971737" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u66f4\u65b0 (KB971737)" )
        )
        ,
        new RegistryItem(
                        77,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB971961" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB971961)" )
        )
        ,
        new RegistryItem(
                        78,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB971961-IE8" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 8 \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB971961)" )
        )
        ,
        new RegistryItem(
                        79,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB972260" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB972260)" )
        )
        ,
        new RegistryItem(
                        80,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB972260-IE7" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 7 \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB972260)" )
        )
        ,
        new RegistryItem(
                        81,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB972270" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB972270)" )
        )
        ,
        new RegistryItem(
                        82,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB973346" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB973346)" )
        )
        ,
        new RegistryItem(
                        83,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB973354" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB973354)" )
        )
        ,
        new RegistryItem(
                        84,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB973507" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB973507)" )
        )
        ,
        new RegistryItem(
                        85,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB973525" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB973525)" )
        )
        ,
        new RegistryItem(
                        86,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB973540_WM9" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Player (KB973540) \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u554f\u984c\u306e\u4fee\u6b63\u30d7\u30ed\u30b0\u30e9\u30e0" )
        )
        ,
        new RegistryItem(
                        87,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB973687" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u66f4\u65b0 (KB973687)" )
        )
        ,
        new RegistryItem(
                        88,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB973815" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u66f4\u65b0 (KB973815)" )
        )
        ,
        new RegistryItem(
                        89,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB973869" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB973869)" )
        )
        ,
        new RegistryItem(
                        90,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB973904" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB973904)" )
        )
        ,
        new RegistryItem(
                        91,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB974112" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB974112)" )
        )
        ,
        new RegistryItem(
                        92,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB974318" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB974318)" )
        )
        ,
        new RegistryItem(
                        93,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB974392" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB974392)" )
        )
        ,
        new RegistryItem(
                        94,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB974455-IE7" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 7 \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB974455)" )
        )
        ,
        new RegistryItem(
                        95,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB974571" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB974571)" )
        )
        ,
        new RegistryItem(
                        96,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB975025" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB975025)" )
        )
        ,
        new RegistryItem(
                        97,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB975467" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB975467)" )
        )
        ,
        new RegistryItem(
                        98,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB975560" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB975560)" )
        )
        ,
        new RegistryItem(
                        99,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB975561" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB975561)" )
        )
        ,
        new RegistryItem(
                        100,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB975562" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB975562)" )
        )
        ,
        new RegistryItem(
                        101,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB975713" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB975713)" )
        )
        ,
        new RegistryItem(
                        102,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB976098-v2" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30db\u30c3\u30c8\u30d5\u30a3\u30c3\u30af\u30b9 (KB976098-v2)" )
        )
        ,
        new RegistryItem(
                        103,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB976325-IE7" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 7 \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB976325)" )
        )
        ,
        new RegistryItem(
                        104,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB976325-IE8" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 8 \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB976325)" )
        )
        ,
        new RegistryItem(
                        105,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB976662-IE8" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 8 \u66f4\u65b0 (KB976662)" )
        )
        ,
        new RegistryItem(
                        106,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB976749-IE7" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 7 \u66f4\u65b0 (KB976749)" )
        )
        ,
        new RegistryItem(
                        107,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB977165" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB977165)" )
        )
        ,
        new RegistryItem(
                        108,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB977816" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB977816)" )
        )
        ,
        new RegistryItem(
                        109,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB977914" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB977914)" )
        )
        ,
        new RegistryItem(
                        110,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB978037" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB978037)" )
        )
        ,
        new RegistryItem(
                        111,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB978207-IE7" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 7 \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB978207)" )
        )
        ,
        new RegistryItem(
                        112,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB978207-IE8" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 8 \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB978207)" )
        )
        ,
        new RegistryItem(
                        113,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB978251" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB978251)" )
        )
        ,
        new RegistryItem(
                        114,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB978262" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB978262)" )
        )
        ,
        new RegistryItem(
                        115,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB978338" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB978338)" )
        )
        ,
        new RegistryItem(
                        116,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB978506-IE8" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 8 \u66f4\u65b0 (KB978506)" )
        )
        ,
        new RegistryItem(
                        117,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB978542" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB978542)" )
        )
        ,
        new RegistryItem(
                        118,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB978601" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB978601)" )
        )
        ,
        new RegistryItem(
                        119,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB978695_WM9" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Player (KB978695) \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u554f\u984c\u306e\u4fee\u6b63\u30d7\u30ed\u30b0\u30e9\u30e0" )
        )
        ,
        new RegistryItem(
                        120,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB978706" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB978706)" )
        )
        ,
        new RegistryItem(
                        121,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB979306" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30db\u30c3\u30c8\u30d5\u30a3\u30c3\u30af\u30b9 (KB979306)" )
        )
        ,
        new RegistryItem(
                        122,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB979309" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB979309)" )
        )
        ,
        new RegistryItem(
                        123,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB979482" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB979482)" )
        )
        ,
        new RegistryItem(
                        124,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB979559" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB979559)" )
        )
        ,
        new RegistryItem(
                        125,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB979683" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB979683)" )
        )
        ,
        new RegistryItem(
                        126,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB980182-IE8" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 8 \u66f4\u65b0 (KB980182)" )
        )
        ,
        new RegistryItem(
                        127,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB980195" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB980195)" )
        )
        ,
        new RegistryItem(
                        128,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB980218" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB980218)" )
        )
        ,
        new RegistryItem(
                        129,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB980232" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB980232)" )
        )
        ,
        new RegistryItem(
                        130,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB981332-IE8" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 8 ?Z?L?????e?B?X?V (KB981332)" )
        )
        ,
        new RegistryItem(
                        131,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB981793" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows XP \u30db\u30c3\u30c8\u30d5\u30a3\u30c3\u30af\u30b9 (KB981793)" )
        )
        ,
        new RegistryItem(
                        132,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\KB982381-IE8" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 8 \u30bb\u30ad\u30e5\u30ea\u30c6\u30a3\u66f4\u65b0 (KB982381)" )
        )
        ,
        new RegistryItem(
                        133,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\LHTTSJPJ" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "L&H TTS3000 Japanese" )
        )
        ,
        new RegistryItem(
                        134,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Lhaplus" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Lhaplus" )
        )
        ,
        new RegistryItem(
                        135,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\MSCompPackV1" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft Compression Client Pack 1.0 for Windows XP" )
        )
        ,
        new RegistryItem(
                        136,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Microsoft .NET Framework 3.5 Language Pack SP1 - jpn" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft .NET Framework 3.5 Language Pack SP1 - \u65e5\u672c\u8a9e" )
        )
        ,
        new RegistryItem(
                        137,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Microsoft .NET Framework 3.5 SP1" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft .NET Framework 3.5 SP1" )
        )
        ,
        new RegistryItem(
                        138,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\NLSDownlevelMapping" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft National Language Support Downlevel APIs" )
        )
        ,
        new RegistryItem(
                        139,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\OKI LPR Utility" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "OKI LPR \uff95\uff70\uff83\uff68\uff98\uff83\uff68" )
        )
        ,
        new RegistryItem(
                        140,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\ST6UNST #1" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "\u30d7\u30ec\u30bc\u30f3\u30c6\u30fc\u30b7\u30e7\u30f3\u30bf\u30a4\u30de\u30fc<Pt> Ver.1.52" )
        )
        ,
        new RegistryItem(
                        141,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Shockwave" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Shockwave" )
        )
        ,
        new RegistryItem(
                        142,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Takeo'clock" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Takeo'clock" )
        )
        ,
        new RegistryItem(
                        143,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Tera Term_is1" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Tera Term 4.63" )
        )
        ,
        new RegistryItem(
                        144,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\WGA" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Genuine Advantage Validation Tool (KB892130)" )
        )
        ,
        new RegistryItem(
                        145,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\WMFDist11" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Format 11 runtime" )
        )
        ,
        new RegistryItem(
                        146,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\WgaNotify" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Genuine Advantage Notifications (KB905474)" )
        )
        ,
        new RegistryItem(
                        147,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Windows Media Format Runtime" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Format 11 runtime" )
        )
        ,
        new RegistryItem(
                        148,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Windows Media Player" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Player 11" )
        )
        ,
        new RegistryItem(
                        149,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\Wudf01000" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft User-Mode Driver Framework Feature Pack 1.0" )
        )
        ,
        new RegistryItem(
                        150,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\XPSEPSCLP" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "XML Paper Specification Shared Components Language Pack 1.0" )
        )
        ,
        new RegistryItem(
                        151,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\astah professional_is1" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "astah professional 6.2" )
        )
        ,
        new RegistryItem(
                        152,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\ie7" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 7" )
        )
        ,
        new RegistryItem(
                        153,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\ie8" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Internet Explorer 8" )
        )
        ,
        new RegistryItem(
                        154,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\wmp11" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Windows Media Player 11" )
        )
        ,
        new RegistryItem(
                        155,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{00BA866C-F2A2-4BB9-A308-3DFA695B6F7C}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Java DB 10.5.3.0" )
        )
        ,
        new RegistryItem(
                        156,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{034A00E1-3975-4267-9F39-1DC4745090B7}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft \u30a8\u30f3\u30ab\u30eb\u30bf \u7dcf\u5408\u5927\u767e\u79d1 2003" )
        )
        ,
        new RegistryItem(
                        157,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{0E2EE98E-17AE-4798-8F8C-64E49CA86D20}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "MySQL Server 5.1" )
        )
        ,
        new RegistryItem(
                        158,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{26A24AE4-039D-4CA4-87B4-2F83216021FF}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Java(TM) 6 Update 21" )
        )
        ,
        new RegistryItem(
                        159,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{2D33B338-EA1B-34EA-BD7F-BBD59487E03A}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft .NET Framework 3.0 Service Pack 2 Language Pack - JPN" )
        )
        ,
        new RegistryItem(
                        160,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{32A3A4F4-B792-11D6-A78A-00B0D0160210}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Java(TM) SE Development Kit 6 Update 21" )
        )
        ,
        new RegistryItem(
                        161,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{34F3877C-6399-4A89-98FD-C3FE32EEE25C}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "FileMaker Pro 8.5" )
        )
        ,
        new RegistryItem(
                        162,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{350C97B1-3D7C-4EE8-BAA9-00BCB3D54227}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "WebFldrs XP" )
        )
        ,
        new RegistryItem(
                        163,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{38ADB9A6-798C-11D6-A855-00105A80791C}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "OKI Network Extension" )
        )
        ,
        new RegistryItem(
                        164,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{3A801B30-F3FD-42C2-B460-4A4117B572EE}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "au Music Port" )
        )
        ,
        new RegistryItem(
                        165,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{457D7505-D665-4F95-91C3-ECB8C56E9ACA}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Easy Tune 6 B08.1030.1" )
        )
        ,
        new RegistryItem(
                        166,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{4A03706F-666A-4037-7777-5F2748764D10}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Java Auto Updater" )
        )
        ,
        new RegistryItem(
                        167,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{4D235F63-5F7F-4EC4-AB09-63231A67CE4D}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "au W41CA Software" )
        )
        ,
        new RegistryItem(
                        168,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{71AD79C6-EB2F-4C62-9527-42E6B29E20F2}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Acronis True Image Home" )
        )
        ,
        new RegistryItem(
                        169,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{78E884B8-7DB5-4708-AFE5-DAECEA900EE4}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Diskeeper 2009 Professional" )
        )
        ,
        new RegistryItem(
                        170,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{86493ADD-824D-4B8E-BD72-8C5DCDC52A71}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "MSXML 4.0 SP2 (KB954430)" )
        )
        ,
        new RegistryItem(
                        171,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{90110411-6000-11D3-8CFE-0150048383C9}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft Office Professional Edition 2003" )
        )
        ,
        new RegistryItem(
                        172,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{902DAEAA-18CA-4068-99C4-0F1C7797A25A}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "au Music Port Supplemental Files" )
        )
        ,
        new RegistryItem(
                        173,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{90510411-6000-11D3-8CFE-0150048383C9}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft Office Visio Professional 2003" )
        )
        ,
        new RegistryItem(
                        174,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{932245FB-2F3B-3E2E-B8AB-BDE96E434F21}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft .NET Framework 3.5 Language Pack SP1 - jpn" )
        )
        ,
        new RegistryItem(
                        175,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{95120000-00AF-0411-0000-0000000FF1CE}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft Office PowerPoint Viewer 2007 (Japanese)" )
        )
        ,
        new RegistryItem(
                        176,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{A3051CD0-2F64-3813-A88D-B8DCCDE8F8C7}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft .NET Framework 3.0 Service Pack 2" )
        )
        ,
        new RegistryItem(
                        177,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{A35CAAAB-5977-400C-B355-AC0A51EE2352}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "B's Recorder GOLD 8.67 (Update)" )
        )
        ,
        new RegistryItem(
                        178,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{A3FF5CB2-FB35-4658-8751-9EDE1D65B3AA}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "VMware Workstation" )
        )
        ,
        new RegistryItem(
                        179,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{AC76BA86-1041-0000-7760-000000000004}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Adobe Acrobat 9 Pro - Japanese" )
        )
        ,
        new RegistryItem(
                        180,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{AC76BA86-1041-0000-7760-000000000004}_933" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Adobe Acrobat 9.3.3 - CPSID_83708" )
        )
        ,
        new RegistryItem(
                        181,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{AC76BA86-1041-0000-7760-000000000004}{AC76BA86-1041-0000-7760-000000000004}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Adobe Adobe Acrobat 9 Pro - Japanese" )
        )
        ,
        new RegistryItem(
                        182,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{AFDFBE99-FE9F-41B2-B96C-F1248F9E8ACE}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "ESET NOD32 Antivirus" )
        )
        ,
        new RegistryItem(
                        183,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{B6EC7388-E277-4A5B-8C8F-71067A41BA64}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "TextPad 5" )
        )
        ,
        new RegistryItem(
                        184,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{C09FB3CD-3D0C-3F2D-899A-6A1D67F2073F}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft .NET Framework 2.0 Service Pack 2" )
        )
        ,
        new RegistryItem(
                        185,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{CE2CDD62-0124-36CA-84D3-9F4DCF5C5BD9}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft .NET Framework 3.5 SP1" )
        )
        ,
        new RegistryItem(
                        186,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{CE2CDD62-0124-36CA-84D3-9F4DCF5C5BD9}.KB953595" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Hotfix for Microsoft .NET Framework 3.5 SP1 (KB953595)" )
        )
        ,
        new RegistryItem(
                        187,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{CE2CDD62-0124-36CA-84D3-9F4DCF5C5BD9}.KB958484" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Hotfix for Microsoft .NET Framework 3.5 SP1 (KB958484)" )
        )
        ,
        new RegistryItem(
                        188,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{CE2CDD62-0124-36CA-84D3-9F4DCF5C5BD9}.KB963707" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Update for Microsoft .NET Framework 3.5 SP1 (KB963707)" )
        )
        ,
        new RegistryItem(
                        189,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{D85BDA1A-983E-3C61-8F03-E5F9C394075C}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Microsoft .NET Framework 2.0 Service Pack 2 Language Pack - JPN" )
        )
        ,
        new RegistryItem(
                        190,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{DEC2C123-3CE0-4669-B119-61519130CACD}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "TortoiseSVN 1.6.10.19898 (32 bit)" )
        )
        ,
        new RegistryItem(
                        191,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{E69AE897-9E0B-485C-8552-7841F48D42D8}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Adobe Update Manager CS3" )
        )
        ,
        new RegistryItem(
                        192,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{F132AF7F-7BCA-4EDE-8A7C-958108FE7DBC}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Realtek High Definition Audio Driver" )
        )
        ,
        new RegistryItem(
                        193,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{F662A8E6-F4DC-41A2-901E-8C11F044BDEC}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "MSXML 4.0 SP2 (KB973688)" )
        )
        ,
        new RegistryItem(
                        194,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{F761359C-9CED-45AE-9A51-9D6605CD55C4}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Evernote" )
        )
        ,
        new RegistryItem(
                        195,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{FCB10DE3-E190-4A7E-B06A-FAC61567ABFC}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "MySQL Tools for 5.0" )
        )
        ,
        new RegistryItem(
                        196,
                        Item.DEFAULT_STATUS,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "Software\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\{FDF9862D-2B3E-4648-9DD9-CEEDD4971686}" ),
                        new EntityItemString( "DisplayName" ),
                        new EntityItemRegistryType( RegistryType.REG_SZ ),
                        new EntityItemAnySimple( "Adobe Setup" )
        )
    };

}
