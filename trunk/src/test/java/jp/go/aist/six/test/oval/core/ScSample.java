package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.common.Family;
import jp.go.aist.six.oval.model.independent.FamilyItem;
import jp.go.aist.six.oval.model.independent.TextFileContentItem;
import jp.go.aist.six.oval.model.linux.DpkgInfoItem;
import jp.go.aist.six.oval.model.linux.RpmInfoItem;
import jp.go.aist.six.oval.model.sc.EntityItemInt;
import jp.go.aist.six.oval.model.sc.EntityItemString;
import jp.go.aist.six.oval.model.sc.EntityItemVersion;
import jp.go.aist.six.oval.model.sc.Status;
import jp.go.aist.six.oval.model.windows.EntityItemFileType;
import jp.go.aist.six.oval.model.windows.EntityItemRegistryHive;
import jp.go.aist.six.oval.model.windows.FileItem;
import jp.go.aist.six.oval.model.windows.FileType;
import jp.go.aist.six.oval.model.windows.RegistryHive;
import jp.go.aist.six.oval.model.windows.RegistryItem;



/**
 * OVAL System Characteristics sample objects.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class ScSample
{

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
    public static final RegistryItem  ITEM_WINDOWS_REGISTRY_83 =
        new RegistryItem( 83, Status.DOES_NOT_EXIST,
                        new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE ),
                        new EntityItemString( "SOFTWARE\\Microsoft\\Updates\\Visual Studio\\7.0\\S895309", Status.DOES_NOT_EXIST )
                        )
    ;


}
// ScSample
